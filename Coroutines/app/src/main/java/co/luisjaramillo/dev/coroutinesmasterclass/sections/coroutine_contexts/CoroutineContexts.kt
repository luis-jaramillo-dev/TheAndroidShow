package co.luisjaramillo.dev.coroutinesmasterclass.sections.coroutine_contexts

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext


suspend fun queryDataBase() {

    val job = coroutineContext[Job]
    val name = coroutineContext[CoroutineName]
    val handler = coroutineContext[CoroutineExceptionHandler]
    val dispatcher = coroutineContext[CoroutineDispatcher]

    CoroutineScope(Dispatchers.Main + CoroutineName("My coroutine")).launch {
        println("Dispatcher ${coroutineContext[CoroutineDispatcher]}")
        println("Name ${coroutineContext[CoroutineName]}")

    }

    println("Job $job")
    println("Name $name")
    println("Handler $handler")
    println("Dispatcher $dispatcher")

}


