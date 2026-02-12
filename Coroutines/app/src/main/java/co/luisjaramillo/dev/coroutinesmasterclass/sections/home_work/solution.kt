package co.luisjaramillo.dev.coroutinesmasterclass.sections.home_work

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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
            selectedBird = "Coo"
            job = emitSound(Bird(name = "Bird 1", sound = "Coo", interval = 1000L), scope)
        }) {
            Text("Bird 1: Coo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            selectedBird = "Bird 2"
            job = emitSound(Bird(name = "Bird 2", sound = "Caw", interval = 2000L), scope)
        }) {
            Text("Bird 2: Caw")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            selectedBird = "Chirp"
            job = emitSound(Bird(name = "Bird 3", sound = "Chirp", interval = 3000L), scope)
        }) {
            Text("Bird 3: Chirp")
        }

        Spacer(modifier = Modifier.height(32.dp))

        selectedBird?.let {
            Text(text = "Selected Bird: $it", style = MaterialTheme.typography.headlineMedium)
        }
    }
}


fun emitSound(bird: Bird, scope: CoroutineScope): Job {
    return scope.launch {
        while (isActive) {
            println(bird.sound)
            delay(bird.interval)
        }
    }
}
