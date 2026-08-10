package dev.luisjaramillo.simplecleanarch.domain.user.repository

import dev.luisjaramillo.simplecleanarch.domain.user.User

interface UserRepository {
    fun findUserOrNull(name: String): User?
    fun addUsers(users: List<User>)
}
