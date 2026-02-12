package co.luisjaramillo.dev.coroutinesmasterclass.sections.flow_fundamentals

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun flowDemo() {
    GlobalScope.launch {
        flow<Int> {
            delay(1000L)
            emit(1)
            delay(1000L)
            emit(2)
            delay(1000L)
            emit(3)
        }.onEach {
            println("Value emitted :$it")
        }.launchIn(this)
    }
}

