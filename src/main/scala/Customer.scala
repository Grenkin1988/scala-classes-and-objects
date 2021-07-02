import java.util.UUID

class Customer(first: String, last: String, email: String) {
    private val _id = UUID.randomUUID()
    private val _first = first
    private val _last = last
    private val _email = email

    def getId = _id
    def getFirst = _first
    def getLast = _last
    def getEmail = _email
}
trait Adress {
    protected var _zip: Int
    protected var _street: String
    protected var _state: String

    def setZip(zip: Int): Unit
    def setStreet(street: String): Unit
    def setState(state: String): Unit
    def printAdress() = println(s"${_street}. ${_state}, ${_zip}")
}

trait SecretCodeGenerator {
    def getOTP: String = UUID.randomUUID().toString()
}

class CustomerWithAdress(first: String, last: String, email: String) extends Customer(first, last, email) 
    with Adress with SecretCodeGenerator {
  override protected var _zip: Int = -1
  override protected var _street: String = ""
  override protected var _state: String = ""

  override def setZip(zip: Int): Unit = _zip = zip

  override def setStreet(street: String): Unit = _street = street

  override def setState(state: String): Unit = _state = state


}

class DepositBoxContainer extends SecretCodeGenerator {

}

object EmailRunner extends App {
    val c1 = new Customer("Tony", "Stark", "tony@stark.com")
    println(c1.getId, c1.getFirst, c1.getLast, c1.getEmail)

    val c2 = new CustomerWithAdress("Tony", "Stark", "tony@stark.com")
    c2.setZip(95050)
    c2.setStreet("45 Fremont St")
    c2.setState("California")
    println(c2)
    c2.printAdress()
    println(c2.getOTP)

    val deposit = new DepositBoxContainer()
    println("Deposit OTP: " + deposit.getOTP)
}
