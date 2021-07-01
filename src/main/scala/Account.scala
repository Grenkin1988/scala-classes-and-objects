import java.time.LocalDateTime
import java.util.UUID

class OldAccount(id: UUID, name: String, dateOpened: LocalDateTime) {
    private val _id: UUID = id
    private val _name: String = name
    private val _dateOpened: LocalDateTime = dateOpened
    private val _accountType = "Credit"

    def this(name: String){
        this(UUID.randomUUID(), name, LocalDateTime.now)
    }

    def getId = _id
    def getName = _name
    def getDateOpened = _dateOpened
}

abstract class Account(id: UUID, name: String, dateOpened: LocalDateTime) {
    private val _id: UUID = id
    private val _name: String = name
    private val _dateOpened: LocalDateTime = dateOpened
    val _accountType: String

    def this(name: String){
        this(UUID.randomUUID(), name, LocalDateTime.now)
    }

    def getId = _id
    def getName = _name
    def getDateOpened = _dateOpened
    def getAccountType: String = _accountType
}

class CreditAccount(name: String) extends Account(name: String){
    override val _accountType = "Credit"
}

class DepositAccount(name: String) extends Account(name: String){
    override val _accountType = "Deposit"
}

object AccountRunner extends App{
    val a1 = new OldAccount(UUID.randomUUID(), "Account 01", LocalDateTime.now)
    val a2 = new OldAccount(UUID.randomUUID(), "Account 02", LocalDateTime.now.plusHours(6))
    val a3 = new OldAccount("Account 3")

    println(a1.getId, a1.getName, a1.getDateOpened)
    println(a2.getId, a2.getName, a2.getDateOpened)
    println(a3.getId, a3.getName, a3.getDateOpened)
    println("--------------------------------------------------")

    val ca1: Account = new CreditAccount("Credit Accout 01")
    println(ca1.getId, ca1.getName, ca1.getDateOpened, ca1.getAccountType)
    val da1: Account = new DepositAccount("Deposit Accout 01")
    println(da1.getId, da1.getName, da1.getDateOpened, da1.getAccountType)
}
