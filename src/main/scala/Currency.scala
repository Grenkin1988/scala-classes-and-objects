object Currency {
    private val conversionTable: Map[String, Double] =
        Map("CAD" -> 1 / 1.3, "NZD" -> 1 / 1.5)

    // With apply no need for new key word for object creation
    def apply(code: String, amount: Double) = new Currency(code, amount, getCostInUsd(code, amount))

    def createUSD(amount: Double) = apply("USD", amount)
    def createNZD(amount: Double) = apply("NZD", amount)
    def createCAD(amount: Double) = apply("CAD", amount)

    private def getCostInUsd(code: String, amount: Double): Double = {
        code match {
            case "USD" => amount
            case ccy if conversionTable.contains(ccy) =>
                amount * conversionTable(ccy)
            case _ => throw new IllegalArgumentException(s"No conversion available for ${_code}")
        }
    }
}
class Currency(code: String, amount: Double, inUSD: Double) {
    import Currency.conversionTable
    private val _code = code
    private val _amount = amount
    private val _inUSD = inUSD

    override def toString(): String = s"${_code} ${_amount} = USD ${_inUSD}"
}

object CurrencyRunner extends App {
    val usd1 = Currency("USD", 100.12)
    println(usd1)

    val nzd1 = Currency("NZD", 100.12)
    println(nzd1)

    val cad1 = Currency("CAD", 100.12)
    println(cad1)

    import Currency._

    val usd2 = createUSD(25)
    println(usd2)

    val nzd2 = createNZD(25)
    println(nzd2)

    val cad2 = createCAD(25)
    println(cad2)
}