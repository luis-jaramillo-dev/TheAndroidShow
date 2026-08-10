package dev.luisjaramillo.simplecleanarch

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
import dev.luisjaramillo.simplecleanarch.data.local.user.LocalUserRepositoryImpl
import dev.luisjaramillo.simplecleanarch.domain.user.repository.UserRepository
import dev.luisjaramillo.simplecleanarch.features.user.di.userProfileViewModel
import dev.luisjaramillo.simplecleanarch.features.user.profile.UserProfileRoot
import dev.luisjaramillo.simplecleanarch.ui.theme.SimpleCleanArchitectureTheme
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleCleanArchitectureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserProfileRoot(Modifier.padding(innerPadding))
                }
            }
        }

    }
}
