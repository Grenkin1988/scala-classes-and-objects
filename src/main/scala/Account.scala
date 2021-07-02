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

    override def toString(): String = 
        s"Account id=${_id}, name=${_name},dateOpened=${_dateOpened}"
}

class CreditAccount(name: String) extends Account(name: String){
    override val _accountType = "Credit"
}

class DepositAccount(name: String) extends Account(name: String){
    override val _accountType = "Deposit"
}

trait Balance {
    private var _balance: Double = 0
    def getBalance = _balance
    def setBalance(newBalance: Double) = _balance = newBalance
    override def toString(): String = s"Balance=${getBalance}"
}

trait AnualFees extends Balance {
    override def setBalance(newBalance: Double): Unit = super.setBalance(newBalance - 100)
}

trait HighSavings extends Balance {
    override def setBalance(newBalance: Double): Unit = super.setBalance((newBalance + 500) * (1 + 0.50))
}

class PremiumSavingAccount(name: String) extends DepositAccount(name) with AnualFees
class PremiumPromotionalSavingAccount(name: String) extends DepositAccount(name) with AnualFees with HighSavings

object AccountRunner extends App{
    val a1 = new OldAccount(UUID.randomUUID(), "Account 01", LocalDateTime.now)
    val a2 = new OldAccount(UUID.randomUUID(), "Account 02", LocalDateTime.now.plusHours(6))
    val a3 = new OldAccount("Account 3")

    println(a1.getId, a1.getName, a1.getDateOpened)
    println(a2.getId, a2.getName, a2.getDateOpened)
    println(a3.getId, a3.getName, a3.getDateOpened)
    println("--------------------------------------------------")

    val ca1: Account = new CreditAccount("Credit Accout 01")
    println(ca1)
    val da1: Account = new DepositAccount("Deposit Accout 01")
    println(da1)

    println()
    println()

    val psb1 = new PremiumSavingAccount("Premium Saving Account")
    psb1.setBalance(999)
    println(psb1.getBalance)

    val psb2 = new PremiumPromotionalSavingAccount("Premium Promotional Saving Account")
    psb2.setBalance(999)
    println(psb2.getBalance)
}

class C1
class C2
class C3

trait T1
trait T2
trait T3