import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
class Router extends Controller {
  get("/repeater/:data") {
    (request: Request) => {
      val data = request.getParam("data").toString
      println(data)
      Map(
        "response" -> data
      )
    }
  }

  get("/test/") {
    (request: Request) => {
      val test = new Test()
      Map(
        "response" -> test.test()
      )
    }
  }

  options("/:*") {
    _: Request => response.ok
  }
}
