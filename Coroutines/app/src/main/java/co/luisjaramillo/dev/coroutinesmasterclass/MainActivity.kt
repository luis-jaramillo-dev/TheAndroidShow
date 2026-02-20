package co.luisjaramillo.dev.coroutinesmasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.luisjaramillo.dev.coroutinesmasterclass.sections.coroutine_contexts.queryDataBase
import co.luisjaramillo.dev.coroutinesmasterclass.sections.coroutine_contexts.withContextDemo
import co.luisjaramillo.dev.coroutinesmasterclass.sections.flow_fundamentals.flowDemo
import co.luisjaramillo.dev.coroutinesmasterclass.sections.flow_fundamentals.sharedFlowDemo
import co.luisjaramillo.dev.coroutinesmasterclass.sections.flow_fundamentals.stateFlowDemo
import co.luisjaramillo.dev.coroutinesmasterclass.sections.home_work.AssignmentTwoScreen
import co.luisjaramillo.dev.coroutinesmasterclass.sections.home_work.BirdScreen
import co.luisjaramillo.dev.coroutinesmasterclass.ui.theme.CoroutinesMasterclassTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        GlobalScope.launch {
            withContextDemo()
        }

        setContent {
            CoroutinesMasterclassTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AssignmentTwoScreen()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoroutinesMasterclassTheme {
        Greeting("Android")
    }
}