package com.bonsaiilabs.entities

case class User(val first: String, val last: String) {
    private[entities] def getId: String = ???
}