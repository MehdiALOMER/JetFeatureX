package com.example.jetfeaturex.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainDashboard() {
    Box(
        modifier = Modifier
            .background(GreenBackground)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(
                chips = listOf("Data structures", "Algorithms", "Competitive programming")
            )
            SuggestionSection()
            CourseSection(
                courses = listOf(
                    Course(
                        "Geek of the Year",
                        Icons.Filled.AddCircle,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Course(
                        "How does AI Work",
                        Icons.Filled.Info,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Course(
                        "Advance Python Course",
                        Icons.Filled.PlayArrow,
                        SkyBlue1,
                        SkyBlue2,
                        SkyBlue3
                    ),
                    Course("Advance Java Course", Icons.Filled.Build, Beige1, Beige2, Beige3)
                )
            )
        }
        BottomMenu(
            items = listOf(
                BottomMenuContent("Home", Icons.Filled.Home),
                BottomMenuContent("Explore", Icons.Filled.Search),
                BottomMenuContent("Dark Mode", Icons.Filled.Search),
                BottomMenuContent("Videos", Icons.Filled.Search),
                BottomMenuContent("Profile", Icons.Filled.Person)
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun GreetingSection(name: String = "Geeks") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text("Good morning, $name", fontSize = 24.sp, color = Color.White)
            Text("We wish you have a good day!", fontSize = 16.sp, color = Color(0xFF9aa5c4))
        }
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChipIndex by remember { mutableStateOf(0) }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (selectedChipIndex == it) GreenAccent else LightGreen)
                    .clickable { selectedChipIndex = it }
                    .padding(15.dp)
            ) {
                Text(chips[it], color = Color.White)
            }
        }
    }
}

@Composable
fun SuggestionSection(color: Color = LightGreen) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text("Daily Coding", fontSize = 18.sp, color = Color.White)
            Text("Do at least 3-10 problems/day", fontSize = 14.sp, color = Color.White)
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(GreenAccent)
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun CourseSection(courses: List<Course>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            "Courses",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxHeight(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(courses.size) {
                CourseItem(courses[it])
            }
        }
    }
}

@Composable
fun CourseItem(course: Course) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(course.darkColor)
    ) {
        val width = constraints.maxWidth.toFloat()
        val height = constraints.maxHeight.toFloat()

        val mediumColoredPath = createPath(
            width, height,
            listOf(
                Offset(0f, height * 0.3f),
                Offset(width * 0.1f, height * 0.35f),
                Offset(width * 0.4f, height * 0.05f),
                Offset(width * 0.75f, height * 0.7f),
                Offset(width * 1.4f, -height)
            )
        )

        val lightColoredPath = createPath(
            width, height,
            listOf(
                Offset(0f, height * 0.35f),
                Offset(width * 0.1f, height * 0.4f),
                Offset(width * 0.3f, height * 0.35f),
                Offset(width * 0.65f, height),
                Offset(width * 1.4f, -height / 3f)
            )
        )

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = course.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = course.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = course.title,
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                imageVector = course.icon,
                contentDescription = course.title,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(35.dp)
            )
            Text(
                text = "Start",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(GreenAccent)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}

fun createPath(width: Float, height: Float, points: List<Offset>): Path {
    return Path().apply {
        moveTo(points[0].x, points[0].y)
        for (i in 0 until points.size - 1) {
            quadraticBezierTo(
                (points[i].x + points[i + 1].x) / 2,
                (points[i].y + points[i + 1].y) / 2,
                points[i + 1].x,
                points[i + 1].y
            )
        }
        lineTo(width + 100f, height + 100f)
        lineTo(-100f, height + 100f)
        close()
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items.forEach { item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = Color(0xFF9aa5c4),
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.title,
                    color = Color(0xFF9aa5c4)
                )
            }
        }
    }
}

data class Course(
    val title: String,
    val icon: ImageVector,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)

data class BottomMenuContent(val title: String, val icon: ImageVector)

val GreenBackground = Color(0xFF1B5E20)
val LightGreen = Color(0xFF81C784)
val GreenAccent = Color(0xFF66BB6A)
val DarkGreen = Color(0xFF2E7D32)

val BlueViolet1 = Color(0xFFaeb4fd)
val BlueViolet2 = Color(0xFF9fa5fe)
val BlueViolet3 = Color(0xFF8f98fd)

val LightGreen1 = Color(0xFF54e1b6)
val LightGreen2 = Color(0xFF36ddab)
val LightGreen3 = Color(0xFF11d79b)

val SkyBlue1 = Color(0xFF5AC8FA)
val SkyBlue2 = Color(0xFF49B9F0)
val SkyBlue3 = Color(0xFF3B96DA)

val Beige1 = Color(0xFFFFB493)
val Beige2 = Color(0xFFFFA584)
val Beige3 = Color(0xFFFF916E)


// Preview Function
@Preview(showBackground = true, name = "Main Dashboard Preview")
@Composable
fun MainDashboardPreview() {
    MainDashboard()
}
