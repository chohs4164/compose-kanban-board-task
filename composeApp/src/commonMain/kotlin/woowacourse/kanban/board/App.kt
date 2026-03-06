package woowacourse.kanban.board

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kanbanboard.composeapp.generated.resources.Res
import kanbanboard.composeapp.generated.resources.compose_multiplatform
import kanbanboard.composeapp.generated.resources.my_image
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun App() {
//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                Image(painterResource(Res.drawable.compose_multiplatform), null)
//            }
//        }
//    }
}

@Composable
@Preview
fun GreetingPreview() {
    Column(
        modifier = Modifier.background(Color.White),
    ) {
        TextExample()
        ImageExample()
        IconExample()
        SaveButtonExample()
        ImgButtonExample()
        LikeButtonExample()
        BoxAlignmentExample()
    }
}

@Composable
fun TextExample() {
    Text(
        "Jetpack Compost Text 실습",
        color = Color.Blue,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun ImageExample() {
    Image(
        painter = painterResource(resource = Res.drawable.my_image),
        contentDescription = "우아한테크코스",
    )
}

@Composable
fun IconExample() {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "하트 아이콘",
        tint = Color.Black
    )
}

@Composable
fun SaveButtonExample() {
    Button(
        onClick = {
            println("저장됨!!")
        },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
        ),
    ) {
        Text(text = "저장")
    }
}

@Composable
fun ImgButtonExample() {
    Button(
        onClick = {
            println("heart")
        },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Red,
        ),
    ) {
        Image(imageVector = Icons.Default.Favorite, contentDescription = "heart")
    }
}

@Composable
fun LikeButtonExample() {
    Button(
        onClick = {
            println("like")
        },
    ) {
        Row {
            IconExample()
            Text("좋아요")
        }
    }
}

@Composable
fun BoxAlignmentExample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.White),
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .align(Alignment.TopStart),
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Yellow)
                .align(Alignment.Center),
        )
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .align(Alignment.BottomEnd),
        )
    }
}
