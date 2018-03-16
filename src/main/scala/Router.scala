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

  get("/canteenNames/") {
    (request: Request) => {
      Map(
        "names" -> Menza.getCanteenNames
      )
    }
  }

  get("/testReq/") {
    (request: Request) => {
      println(request.getParams())
      println(request.params)
      println(request.toString())
    }
  }



  options("/:*") {
    _: Request => response.ok
  }
}
