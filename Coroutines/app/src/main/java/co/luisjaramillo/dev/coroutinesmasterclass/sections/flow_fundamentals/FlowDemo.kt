package co.luisjaramillo.dev.coroutinesmasterclass.sections.flow_fundamentals

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.zip
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


fun stateInDemo() {
    GlobalScope.launch {
        val flow = flow<Int> {
            println("Collection started!")
            delay(1000L)
            emit(1)
            delay(1000L)
            emit(2)
            delay(1000L)
            emit(3)
        }.stateIn(this, SharingStarted.Eagerly, 0)

        //Collector 1
        flow.onEach {
            println("Collector 1: $it")
        }.launchIn(GlobalScope)

        //Collector 2
        GlobalScope.launch {
            delay(5000L)
            flow.onEach {
                println("Collector 2: $it")
            }.launchIn(GlobalScope)
        }
    }
}

suspend fun testZipFunction() {
    val flowA = flowOf("A", "B", "C")
     val flowB = flowOf(1, 2, 3)
     flowA.zip(flowB) { a, b -> "$a$b" }.collect { result ->
        print(result)
    }
}
suspend fun testCombine(){

}
