package co.luisjaramillo.dev.coroutinesmasterclass.sections.coroutine_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import co.luisjaramillo.dev.coroutinesmasterclass.ui.theme.CoroutinesMasterclassTheme
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class JobsConcept : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val job = lifecycleScope.launch {

            val profileDeferred = async {
                println("Fetching profile data...")
                delay(2000L)
                "profile"
            }
            val postsDeferred = async {
                println("Fetching profile posts...")
                delay(3000L)
                "posts"
            }

            val timeMillis = measureTimeMillis {
                val posts = postsDeferred.await()
                val profile = profileDeferred.await()

                println("Profile loaded: $profile, $posts")
            }
            println("Jobs took $timeMillis milliseconds.")
        }

        setContent {
            CoroutinesMasterclassTheme { }
        }


    }

    override fun onDestroy() {
        super.onDestroy()

    }
}