import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import jidlo.JidloService
import rozvrh.RozvrhService
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

  // ---------- Menza ---------------------

  get("/jidlo/") {
    (request: Request) => {
      Map(
        "response" -> JidloService.getJidlo()
      )
    }
  }


  // ---------- Rozvrh ---------------------

  // MOCK
  get("/rozvrh/next") {
    (request: Request) => {
      Map(
        "response" -> RozvrhService.getNextCourse
      )
    }
  }
  // MOCK
  get("/rozvrh/week") {
    (request: Request) => {
      Map(
        "response" -> RozvrhService.getWeekCourses
      )
    }
  }
  // MOCK
  get("/rozvrh/screenshot") {
    (request: Request) => {
      Map(
        "response" -> RozvrhService.getScreenshot
      )
    }
  }
  // MOCK
  get("/rozvrh/file") {
    (request: Request) => {
      Map(
        "response" -> RozvrhService.getFile
      )
    };
  }

  // REAL
  get("/rozvrh/all") {
    (request: Request) => {
      Map(
        "response" -> RozvrhService.getAllCourses("data1.csv")
      )
    };
  }

  // REAL
  get("/rozvrh/all/byRoom/:data") {
    (request: Request) => {

      val data = request.getParam("data").toString

      println(data)

      Map(
        "response" -> RozvrhService.filterAllCoursesRoom(data)
      )
    };
  }

  // REAL
  get("/rozvrh/all/byTeacher/:data") {

    (request: Request) => {

      val data = request.getParam("data").toString

      println(data)

      Map(
        "response" -> RozvrhService.filterAllCoursesTeacher(data)
      )
    };
  }




  options("/:*") {
    _: Request => response.ok
  }
}
