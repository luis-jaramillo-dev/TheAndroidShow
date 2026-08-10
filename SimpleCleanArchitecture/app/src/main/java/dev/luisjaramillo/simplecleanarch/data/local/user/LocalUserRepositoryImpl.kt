package dev.luisjaramillo.simplecleanarch.data.local.user

import dev.luisjaramillo.simplecleanarch.domain.user.User
import dev.luisjaramillo.simplecleanarch.domain.user.repository.UserRepository

class LocalUserRepositoryImpl : UserRepository {

    private val _users = arrayListOf<User>()

    override fun findUserOrNull(name: String): User? {
        return _users.firstOrNull { it.name == name }
    }

    override fun addUsers(users: List<User>) {
        _users.addAll(users)
    }
}