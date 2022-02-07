
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://dev.blackbox.accelbyte.io")
    .inferHtmlResources(AllowList(), DenyList())
  
  private val headers_0 = Map(
  		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
  		"accept-encoding" -> "gzip, deflate, br",
  		"accept-language" -> "en-US,en;q=0.9",
  		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows",
  		"sec-fetch-dest" -> "document",
  		"sec-fetch-mode" -> "navigate",
  		"sec-fetch-site" -> "same-origin",
  		"sec-fetch-user" -> "?1",
  		"upgrade-insecure-requests" -> "1",
  		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36"
  )
  
  private val headers_1 = Map(
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36",
  		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_7 = Map(
  		"Origin" -> "https://dev.blackbox.accelbyte.io",
  		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36",
  		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val uri2 = "https://cdn.loom.com/assets/fonts/circular/CircularXXWeb-Book-cd7d2bcec649b1243839a15d5eb8f0a3.woff2"
  
  private val uri3 = "https://fonts.gstatic.com/s/roboto/v29/KFOmCnqEu92Fr1Mu4mxK.woff2"
  
  private val uri4 = "https://fonts.googleapis.com/css"

  private val scn = scenario("RecordedSimulation")
    .exec(
      http("request_0")
        .get("/login-namespace?redirect=%2Flogin")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/main.bundle.js?7a830bd7b86f16d2e412")
            .headers(headers_1),
          http("request_2")
            .get("/main.a3a40da6f6298fc88826.css?7a830bd7b86f16d2e412"),
          http("request_3")
            .get("/6033.f5d0df3e71b82f474727.css"),
          http("request_4")
            .get("/6033.e923b4de712e5778065a.chunk.js"),
          http("request_5")
            .get(uri4 + "?family=Roboto|Roboto+Mono&display=swap")
            .headers(headers_1),
          http("request_6")
            .get(uri4 + "?family=Rubik&display=swap")
            .headers(headers_1),
          http("request_7")
            .get(uri3)
            .headers(headers_7),
          http("request_8")
            .get(uri2)
            .headers(headers_7),
          http("request_9")
            .get("/admin/favicon.ico")
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
