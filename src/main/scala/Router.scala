import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import jidlo.JidloService
import rozvrh.RozvrhService
import study.StudyService
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

  get("/mezera") {
    (request: Request) => {
      Map(
        "response" -> "ahoj \\u000A \n <br> \n\r \n  \u000A  <br> neco"
      )
    }
  }

  get("/canteenNames") {
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
        "response" -> Menza.dishes
      )
    }
  }




  // ---------- Rozvrh ---------------------

  // MOCK
  get("/rozvrh/next") {

    println("call /rozvrh/next")
    (request: Request) => {
      Map(
        "response" -> RozvrhService.getNextCourse
      )
    }
  }
  // MOCK
  get("/rozvrh/week") {
    println("call /rozvrh/week")
    (request: Request) => {
      Map(
        "response" -> RozvrhService.getWeekCourses
      )
    }
  }
  // MOCK
  get("/rozvrh/screenshot") {
    println("call /rozvrh/screenshot")
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
      println("call /rozvrh/byRoom/"+data)

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
      println("call /rozvrh/byTeacher/"+data)

      println(data)

      Map(
        "response" -> RozvrhService.filterAllCoursesTeacher(data)
      )
    };
  }



  // ---------- Studijni zalezitosti ---------------------

  // REAL
  get("/study/isic") {
    (request: Request) => {
      Map(
        "response" -> StudyService.getIsic()
      )
    };
  }

  // ---------- Studijni zalezitosti ---------------------

  // REAL
  get("/study/studijni") {
    (request: Request) => {
      Map(
        "response" -> StudyService.getStudijni
      )
    };
  }


  // REAL
  get("/study/odevzdavarna") {
    (request: Request) => {
      Map(
        "response" -> StudyService.getOdevzdavarny
      )
    };
  }


  options("/:*") {
    _: Request => response.ok
  }
}
