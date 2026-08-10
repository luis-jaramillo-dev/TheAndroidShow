package dev.luisjaramillo.simplecleanarch.features.user.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserProfileRoot(
    modifier: Modifier = Modifier,
    viewModel: UserProfileViewModel = koinViewModel(),
){
    Column {
        Text("Hello word!")
    }
}
