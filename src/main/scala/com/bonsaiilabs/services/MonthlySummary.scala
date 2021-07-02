package com.bonsaiilabs.services

import com.bonsaiilabs.entities.{Budget, Transaction => BankTransaction}
import com.bonsaiilabs.entities._ // import all

case class MonthlySummary(val budget: Budget, ts: BankTransaction)