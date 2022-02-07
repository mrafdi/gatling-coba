
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class GatlingDatabase extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://computer-database.gatling.io")
    .inferHtmlResources(AllowList(), DenyList())
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36")
  
  private val headers_0 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_1 = Map(
  		"Accept" -> "text/css,*/*;q=0.1",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Sec-Fetch-Dest" -> "style",
  		"Sec-Fetch-Mode" -> "no-cors",
  		"Sec-Fetch-Site" -> "same-origin",
  		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_3 = Map(
  		"Origin" -> "https://computer-database.gatling.io",
  		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_8 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-US,en;q=0.9",
  		"Cache-Control" -> "max-age=0",
  		"Origin" -> "https://computer-database.gatling.io",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val uri2 = "https://cdn.loom.com/assets/fonts/circular/CircularXXWeb-Book-cd7d2bcec649b1243839a15d5eb8f0a3.woff2"

  private val scn = scenario("GatlingDatabase")
    .exec(
      http("LOAD_HOMEPAGE")
        .get("/computers")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/assets/css/bootstrap.min.css")
            .headers(headers_1),
          http("request_2")
            .get("/assets/css/main.css")
            .headers(headers_1),
          http("request_3")
            .get(uri2)
            .headers(headers_3)
        )
    )
    .pause(1)
    .exec(
      http("LOAD_NEW_COMPUTER_PAGE")
        .get("/computers/new")
        .headers(headers_0)
        .resources(
          http("request_5")
            .get("/assets/css/main.css")
            .headers(headers_1),
          http("request_6")
            .get(uri2)
            .headers(headers_3),
          http("request_7")
            .get("/assets/css/bootstrap.min.css")
            .headers(headers_1)
        )
    )
    .pause(1)
    .exec(
      http("CREATE_NEW_COMPUTER")
        .post("/computers")
        .headers(headers_8)
        .formParam("name", "aab123")
        .formParam("introduced", "2021-01-10")
        .formParam("discontinued", "2041-01-10")
        .formParam("company", "1")
        .resources(
          http("request_9")
            .get("/assets/css/main.css")
            .headers(headers_1),
          http("request_10")
            .get(uri2)
            .headers(headers_3),
          http("request_11")
            .get("/assets/css/bootstrap.min.css")
            .headers(headers_1)
        )
    )
    .pause(1)
    .exec(
      http("SEARCH_COMPUTER")
        .get("/computers?f=aab123")
        .headers(headers_0)
        .resources(
          http("request_13")
            .get(uri2)
            .headers(headers_3)
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
