import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.HtmlPage
import jidlo.{JidloDay, JidloItem}
import collection.JavaConverters._

object Menza {
  private val webClient = new WebClient()
  private lazy val page = webClient.getPage[HtmlPage]("http://ipm.mendelu.cz/jidelnicek")
  def getCanteenNames: Seq[String] = {
    val domList = page.querySelectorAll(".ui-state-default")
    (0 until domList.getLength).map{
      domList.get(_).getAttributes.getNamedItem("aria-controls").getNodeValue
    }.filter(_ != "alergeny")
  }

  private def stringToJidloitem(line: String) = {
    val exploded = line.split(" 	")
    if(exploded.length < 2) null
    else new JidloItem(exploded(0), exploded(1))
  }

  val dishes = Seq(
    Seq("Pondělí 19. 3. 2018", """|Zeleninový vývar s těstovinou (1, 3, 9)	6,90
        |Kantonské hovězí maso 100g, rýže (1, 3, 6, 9, 12, 1001)	73,90
        |Vepřový steak 100g, pepřová omáčka (1, 6, 7, 9, 10, 1001)	68,20
        |Kuřecí řízek v cornflakes 120g (1, 3, 7, 9, 10, 1001)	66,70
        |Pikantní kuřecí směs 120g (1, 9, 10, 12, 1001)	68,40
        |Selský bramborový guláš s klobásou, chléb (1, 9, 1001)	66,80
        |Špenátové rizoto se žampiony, okurek (7, 9, 12)	67,20
        |Americké brambory 	9,00
        |Bramborová kaše (7)	7,00
        |Brambory vařené (7)	7,00
        |Francouzská zelenina na másle 250g (1, 7, 9, 1001)	15,00
        |Hranolky MINUTKY 	8,00
        |Jasmínová rýže 	6,00
        |Houbová polévka s bramborami (1, 6, 9, 1001)	8,00
        |Hovězí pečeně 100g, svíčková omáčka, houskový knedlík (1, 3, 7, 9, 10, 1001)	74,40
        |Vepřové žebírko 100g, sázené vejce (3, 6, 9, 10)	69,60
        |Kuřecí kapsa na bylinkovém másle 120g (1, 7, 1001)	68,00
        |Chilli con carne z vepřového masa 100g (1, 6, 9, 10)	66,80
        |Smažený sýr 100g, tatarka (1, 3, 7, 10, 1001)	68,40
        |Penne Pomodoro (1, 7)	66,20
        |Bramborová kaše (7)	7,00
        |Bramborové hranolky 	8,00
        |Brambory vařené (7)	7,00
        |Francouzská zelenina na másle 250g (1, 7, 9, 1001)	15,00
        |Hranolky MINUTKY 	8,00
        |Rýže dušená 	5,00
        |Hovězí vývar s nudlemi (1, 3, 6, 9)	7,80
        |Hovězí pečeně po orientálsku 100g, rýže (1, 9, 12, 1001)	73,90
        |Vepřový steak 100g, lázeňská zelenina na másle (6, 9, 10)	69,10
        |Kuřecí přírodní řízek se šunkou a sýrem 120g (1, 7, 10)	68,40
        |Aljašská treska v bramborovém obalu 150g (1, 3, 4)	74,70
        |Francouzské brambory s uzeným masem 80g, okurek (3, 7, 9)	71,30
        |Tortilla se zeleninou a tofu, obloha (1, 6, 7)	74,50
        |Bramborová kaše (7)	7,00
        |Brambory vařené (7)	7,00
        |Francouzská zelenina na másle 250g (1, 7, 9, 1001)	15,00
        |Hranolky MINUTKY 	8,00
        |Jasmínová rýže 	6,00
        |Polévka hrachová (1, 6, 7, 9, 1001)	7,70
        |Jelení guláš 100g, houskový knedlík (1, 3, 7, 9, 1001)	74,70
        |Marinované vepřové žebírko Barbecue 100g, tatarka (3, 6, 9, 10)	67,80
        |Kuřecí roláda se špenátem 150g (1, 9)	69,80
        |Špagety s kuřecím masem 100g v rajčatové omáčce (1, 7, 9, 1001)	70,10
        |Francouzská zelenina na másle 250g, vařená vejce 2 ks, brambory (1, 3, 7, 9)	70,70
        |Rýžový nákyp se švestkami (3, 7)	66,70
        |Bramborová kaše (7)	7,00
        |Bramborové hranolky 	8,00
        |Brambory vařené (7)	7,00
        |Francouzská zelenina na másle 250g (1, 7, 9, 1001)	15,00
        |Hranolky MINUTKY 	8,00
      """.stripMargin
        .split("\n")
        .filter(_ != null)
        .map(stringToJidloitem)
        .toList),
  Seq("Pátek 23. 3. 2018",
    """|Polévka pórková (1, 3, 6, 7, 9, 1001)	7,40
      |Fazolové kari (9)	62,60
      |Hovězí kostky na slanině 100g (1, 10, 1001)	69,60
      |Vepřový vrabec 100g, špenát, bramborový knedlík (1, 3, 7, 1001)	74,20
      |Smažený vepřový mletý řízek s nivou 110g (1, 3, 7, 1001)	66,20
      |Kuskus s kuřecím masem 120g a zeleninou (1, 7, 9, 10)	74,50
      |Americké brambory 	9,00
      |Bramborové hranolky 	8,00
      |Brambory vařené (7)	7,00
      |Francouzská zelenina na másle 250g (1, 7, 9, 1001)	15,00
      |Hranolky MINUTKY 	8,00
      |Jasmínová rýže 	6,00
    """.stripMargin
      .split("\n")
      .map(stringToJidloitem)
      .filter(_ != null)
      .toList)
  ).toList
}
