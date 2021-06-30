import java.time.LocalDateTime
import java.time.LocalDateTime
import java.util.UUID

class Account(id: UUID, name: String, dateOpened: LocalDateTime) {
    var _id: UUID = id
    var _name: String = name
    var _dateOpened: LocalDateTime = dateOpened
}

object AccountRunner extends App{
    val a1 = new Account(UUID.randomUUID(), "Account 01", LocalDateTime.now)
    val a2 = new Account(UUID.randomUUID(), "Account 02", LocalDateTime.now.plusHours(6))

    println(a1._id, a1._name, a1._dateOpened)
    println(a2._id, a2._name, a2._dateOpened)
}
