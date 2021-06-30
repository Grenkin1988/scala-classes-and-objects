import java.util.UUID

final class Customer(first: String, last: String, email: String) {
    private val _id = UUID.randomUUID()
    private val _first = first
    private val _last = last
    private val _email = email

    def getId = _id
    def getFirst = _first
    def getLast = _last
    def getEmail = _email
}

//class Hack() extends Customer("", "", ""){} Cannot do this

object EmailRunner extends App {
    val c1 = new Customer("Tony", "Stark", "tony@stark.com")
    println(c1.getId, c1.getFirst, c1.getLast, c1.getEmail)
}
