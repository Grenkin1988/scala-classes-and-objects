import java.time.LocalDateTime
import java.util.UUID

class Account(id: UUID, name: String, dateOpened: LocalDateTime) {
    private val _id: UUID = id
    private val _name: String = name
    private val _dateOpened: LocalDateTime = dateOpened

    def this(name: String){
        this(UUID.randomUUID(), name, LocalDateTime.now)
    }

    def getId = _id
    def getName = _name
    def getDateOpened = _dateOpened
}

class CreditAccount(name: String) extends Account(name: String){
    private val _accountType = "Credit"
    def getAccountType: String = _accountType
}

class DepositAccount(name: String) extends Account(name: String){
    private val _accountType = "Deposit"
    def getAccountType: String = _accountType
}

object AccountRunner extends App{
    val a1 = new Account(UUID.randomUUID(), "Account 01", LocalDateTime.now)
    val a2 = new Account(UUID.randomUUID(), "Account 02", LocalDateTime.now.plusHours(6))
    val a3 = new Account("Account 3")

    println(a1.getId, a1.getName, a1.getDateOpened)
    println(a2.getId, a2.getName, a2.getDateOpened)
    println(a3.getId, a3.getName, a3.getDateOpened)
    println("--------------------------------------------------")

    val ca1 = new CreditAccount("Credit Accout 01")
    println(ca1.getId, ca1.getName, ca1.getDateOpened, ca1.getAccountType)
    val da1 = new DepositAccount("Deposit Accout 01")
    println(da1.getId, da1.getName, da1.getDateOpened, da1.getAccountType)
}
