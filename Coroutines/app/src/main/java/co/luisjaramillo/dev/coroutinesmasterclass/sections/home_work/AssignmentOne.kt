package co.luisjaramillo.dev.coroutinesmasterclass.sections.home_work

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

fun assignment1() {

    val scope = CoroutineScope(Dispatchers.Default)


    scope.launch {

        (1..4).forEach {
            scope.launch {
                println("Coo")
                delay(1000L)
            }
            scope.launch {

                println("Caw")
                delay(2000L)


            }
            scope.launch {

                println("Chirp")
                delay(3000L)

            }
        }


    }

}

fun assignment2() {
    val scope = CoroutineScope(Dispatchers.Default)
    scope.launch {
        val job1 = launch {
            while (true) {
                println("Coo")
                delay(1000L)

            }
        }
        val job2 = launch {
            while (true) {
                println("Caw")
                delay(2000L)

            }
        }
        val job3 = launch {
            while (true) {

                println("Chirp")
                delay(3000L)

            }
        }


        delay(10000)
        job1.join()
        job2.join()
        job3.join()
        cancel()
    }
}

data class Bird(val name: String, val sound: String, val interval: Long)

@Composable
fun BirdScreen() {
    var selectedBird by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()
    var job by remember { mutableStateOf<Job?>(null) }

    LaunchedEffect(selectedBird) {
        job?.cancel()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            selectedBird = "Tweety"
            job = emitSound(Bird(name = "Tweety", sound = "Coo", interval = 1000L), scope)
        }) {
            Text("Tweety: Coo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            selectedBird = "Zazu"
            job = emitSound(Bird(name = "Zazu", sound = "Caw", interval = 2000L), scope)
        }) {
            Text("Zazu: Caw")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            selectedBird = "Woodstock"
            job = emitSound(Bird(name = "Woodstock", sound = "Chirp", interval = 3000L), scope)
        }) {
            Text("Woodstock: Chirp")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            scope.launch {
                val deferredResult = async {
                    println("Starting referred")
                    delay(1000L)
                    println("Ending referred")
                    return@async 42

                }
                println("Waiting for result")
                val result = deferredResult.await()
                println("Result $result")
            }

        }) {
            Text("Tests print")
        }

        selectedBird?.let {
            Text(text = "Selected Bird: $it", style = MaterialTheme.typography.headlineMedium)
        }
    }
}

object test33 {
    val test: String = "Hola"
}


fun emitSound(bird: Bird, scope: CoroutineScope): Job {
    test33.test
    return scope.launch {
        while (isActive) {
            println(bird.sound)
            delay(bird.interval)
        }
    }
}
