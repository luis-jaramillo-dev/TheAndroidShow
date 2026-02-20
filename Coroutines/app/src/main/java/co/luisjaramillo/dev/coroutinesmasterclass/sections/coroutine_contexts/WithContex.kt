package co.luisjaramillo.dev.coroutinesmasterclass.sections.coroutine_contexts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun withContextDemo() {

    println("Thread: ${Thread.currentThread().name}")

    withContext(Dispatchers.Main) {
        println("Thread: ${Thread.currentThread().name}")
        withContext(Dispatchers.IO) {
            println("Thread: ${Thread.currentThread().name}")
        }
    }
}