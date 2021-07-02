import java.time.LocalDateTime

case class Transactio(name: String, amount: Double, kind: String, when: LocalDateTime)

object TransactionRunner extends App {
    val t1 = Transactio("T1", 12.22, "debit", LocalDateTime.now)

    println(t1.toString())

    val t2 = Transactio("T2", 12.22, "debit", LocalDateTime.now)
    println(t1 == t2)
    println(t1.equals(t2))
    println(t1 eq t2)

    val t3 = Transactio("T1", 12.22, "debit", t1.when)
    println(t1 == t3)
    println(t1.equals(t3))
    println(t1 eq t3)

    val t4 = t1.copy(name = "T4", amount = 24.66)
    println(t4)

    val amount = t3 match {
        case Transactio(_, amount, _, _) => amount
    }
    println(amount)
}