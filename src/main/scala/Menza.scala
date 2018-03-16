import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.HtmlPage


object Menza {
  private val webClient = new WebClient()
  private lazy val page = webClient.getPage[HtmlPage]("http://ipm.mendelu.cz/jidelnicek")
  def getCanteenNames: Seq[String] = {
    val domList = page.querySelectorAll(".ui-state-default")
    (0 until domList.getLength).map{
      domList.get(_).getAttributes.getNamedItem("aria-controls").getNodeValue
    }.filter(_ != "alergeny")
  }
}
