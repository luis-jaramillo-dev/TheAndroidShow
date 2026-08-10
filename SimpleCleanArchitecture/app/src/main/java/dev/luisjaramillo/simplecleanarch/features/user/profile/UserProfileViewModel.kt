package dev.luisjaramillo.simplecleanarch.features.user.profile

import androidx.lifecycle.ViewModel
import dev.luisjaramillo.simplecleanarch.domain.user.repository.UserRepository
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject

class UserProfileViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    init {
        userRepository.findUserOrNull("Test")
    }

    private fun fetchUser() {
        val result = userRepository.findUserOrNull("test")

    }
}