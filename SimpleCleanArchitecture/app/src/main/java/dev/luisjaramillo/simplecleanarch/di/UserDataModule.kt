package dev.luisjaramillo.simplecleanarch.di

import dev.luisjaramillo.simplecleanarch.data.local.user.LocalUserRepositoryImpl
import dev.luisjaramillo.simplecleanarch.domain.user.repository.UserRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val userModule = module {
    singleOf(::LocalUserRepositoryImpl) bind UserRepository::class
}