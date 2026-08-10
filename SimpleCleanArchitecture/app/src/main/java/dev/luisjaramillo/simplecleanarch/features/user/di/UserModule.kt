package dev.luisjaramillo.simplecleanarch.features.user.di

import dev.luisjaramillo.simplecleanarch.features.user.profile.UserProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val userProfileViewModel = module {
    viewModelOf(::UserProfileViewModel)
}