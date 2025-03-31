import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bottombar.BottomBarScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.transitions.SlideTransition
import settings.ProfileScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(screen = MainScreen()) { navigator ->
            SlideTransition(navigator)
        }
    }
}

class MainScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            Modifier.fillMaxSize().background(Color(0xFFF5F5DC)), // Beige
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                navigator.push(SecondScreen())
            }) {
                Text("Navegación básica")

            }
        }
    }
}

class SecondScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5DC)), // Beige
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Segunda Pantalla", fontSize = 26.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navigator.pop() }) { Text("Volver") }
        }
    }
}
