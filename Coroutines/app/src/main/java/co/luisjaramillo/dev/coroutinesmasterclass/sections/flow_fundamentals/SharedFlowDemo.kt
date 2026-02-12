package co.luisjaramillo.dev.coroutinesmasterclass.sections.flow_fundamentals

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

fun sharedFlowDemo() {
    val sharedFlowDemo = MutableSharedFlow<Int>(
        extraBufferCapacity = 5,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    GlobalScope.launch {
        delay(3000L)
        sharedFlowDemo.onEach {
            println("Collector 1: $it")
            delay(5000L)
        }.launchIn(GlobalScope)

        sharedFlowDemo.onEach {
            println("Collector 2: $it")
        }.launchIn(GlobalScope)
    }


    GlobalScope.launch {
        repeat(10) {
            delay(500L)
            sharedFlowDemo.emit(it)
        }
    }

}