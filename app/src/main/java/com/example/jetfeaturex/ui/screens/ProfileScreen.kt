package com.yourname.jetfeaturex.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetfeaturex.R


// Define IconType for flexibility in resources
sealed class IconType
data class ImageVectorIcon(val imageVector: ImageVector) : IconType()
data class DrawableResourceIcon(val id: Int) : IconType()

// Mock Icons (Replace with your actual icons)
object MyIcons {
    // Vector Icons from Material Design Icons
    val AppIcon = Icons.Default.Person
    val Location = Icons.Default.LocationOn
    val Email = Icons.Default.Email
    val AccountBox = Icons.Default.AccountBox
    val Edit = Icons.Default.Edit
    val Info = Icons.Default.Info
    val Share = Icons.Default.Share
    val Person = Icons.Default.Person
    val ArrowBack = Icons.Default.ArrowBack
    val Search = Icons.Default.Search
    val MoreVert = Icons.Default.MoreVert
    val KeyboardArrowRight = Icons.Default.KeyboardArrowRight
    val Policy = Icons.Default.Info
    val AndroidHead = Icons.Default.Person
    val Star = Icons.Default.Star
    val List = Icons.Default.List

//    val AppIcon = R.drawable.ic_app_icon // Replace with your actual drawable resource
//    val Location = R.drawable.ic_location // Replace with location icon
//    val Email = R.drawable.ic_email // Replace with email icon
//    val AccountBox = R.drawable.ic_account_box // Replace with account box icon
//    val Edit = R.drawable.ic_edit // Replace with edit icon
//    val Policy = R.drawable.ic_policy // Replace with policy icon
//    val Info = R.drawable.ic_info // Replace with info icon
//    val Android_Head = R.drawable.ic_android_head // Replace with android head icon
//    val Share = R.drawable.ic_share // Replace with share icon
//    val ArrowBack = R.drawable.ic_arrow_back // Replace with arrow back icon
//    val Search = R.drawable.ic_search // Replace with search icon
//    val MoreVert = R.drawable.ic_more_vert // Replace with more options icon
}

// Mock Data
const val username = "mehdicode"
const val myDescription =
    "A group of simple, open source Android apps without ads and unnecessary permissions, with material design UI."

val profilePopularList = listOf(
    ProfilePopularList(
        "Jetpack-Compose-UI",
        "A collection of Jetpack Compose UI Layouts and demo screens.",
        "25",
        "Kotlin"
    ),
    ProfilePopularList(
        "Leaf-Explorer",
        "File Manager, File Sharing & Music Player App for Android.",
        "9",
        "Kotlin"
    ),
    ProfilePopularList(
        "DayNight-Theme",
        "A Material Design-based Theme Management System for Jetpack Compose.",
        "45",
        "Kotlin"
    )
)

val imageTextList = listOf(
    ImageTextList(ImageVectorIcon(Icons.Default.LocationOn), "Istanbul/Turkey"),
    ImageTextList(ImageVectorIcon(Icons.Default.Email), "mehdi.alomer98@gmail.com"),
    ImageTextList(ImageVectorIcon(Icons.Default.Person), "100 followers")
)

val moreOptionsList = listOf(
    FeatureList("Edit Profile", ImageVectorIcon(Icons.Default.Edit), ""),
    FeatureList("Manage Account", ImageVectorIcon(Icons.Default.AccountBox), ""),
//    FeatureList("Privacy Policy", DrawableResourceIcon(MyIcons.Policy), ""),
    FeatureList("Privacy Policy", ImageVectorIcon(MyIcons.Policy), ""),
    FeatureList("About", ImageVectorIcon(Icons.Default.Info), ""),
//    FeatureList("Help & Feedback", DrawableResourceIcon(MyIcons.Android_Head), ""),
    FeatureList("Help & Feedback", ImageVectorIcon(MyIcons.AndroidHead), ""),
    FeatureList("Share 'Damahe Code'", ImageVectorIcon(Icons.Default.Share), "")
)

// Data classes for profile content
data class ProfilePopularList(
    val name: String,
    val description: String,
    val star: String,
    val language: String
)

data class ImageTextList(val icon: IconType, val text: String)
data class FeatureList(val name: String, val listIcon: IconType, val description: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//fun ProfileScreen(onGoBack: () -> Unit) {
fun ProfileScreen() {

    Scaffold(
//        modifier = Modifier.semantics {
//            testTagsAsResourceId = true
//        },
//        containerColor = Color.Transparent,
        containerColor = Color(0xFF6A1B9A),
        contentColor = MaterialTheme.colorScheme.onBackground,
        topBar = {
            TopAppBar(
                title = {
//                    Text(text = stringResource(id = R.string.txt_profile))
                    Text(text = "Profile", color = Color.White)
                },
//                navigationIcon = {
//                    IconButton(onClick = onGoBack) {
//                        Icon(MyIcons.ArrowBack, contentDescription = "Back")
//                    }
//                },
                navigationIcon = {
                        Icon(MyIcons.ArrowBack, contentDescription = "Back", tint = Color.White)
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(MyIcons.Search, contentDescription = "Search", tint = Color.White)
                    }
                    IconButton(onClick = { }) {
                        Icon(MyIcons.MoreVert, contentDescription = "More", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//                    containerColor = Color.Transparent,
                    containerColor = Color(0xFF8E24AA)
                ),
            )
        }
    ) { padding ->

        ProfileContent(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            TopProfileLayout()
            MainProfileContent()
            FooterContent()
        }
    }
}

@Composable
fun ProfileContent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        content()
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TopProfileLayout() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
        color = Color(0xFFF3E5F5)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier.padding(vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
//                    painter = painterResource(id = DrawableResourceIcon(MyIcons.AppIcon).id),
                    imageVector = MyIcons.AppIcon,
                    contentDescription = null,
                    tint = Color(0xFF6A1B9A),
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                        .background(Color(0xFFFFFFFF))
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .weight(1f)
                ) {
                    Text(
//                        text = stringResource(id = R.string.app_name),
                        text = "Mehdi",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF4A148C)
                    )

                    Text(
                        text = username,
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF6A1B9A),
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }

            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = myDescription,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF4A148C)
            )

            FlowRow(modifier = Modifier.padding(vertical = 5.dp)) {
                imageTextList.forEach {
                    ImageTextContent(
                        modifier = Modifier.padding(vertical = 5.dp),
                        icon = {
                            when (it.icon) {
                                is ImageVectorIcon -> Icon(
                                    imageVector = it.icon.imageVector,
                                    contentDescription = null,
                                    tint = Color(0xFF4CAF50),
                                    modifier = Modifier
                                        .size(20.dp)
                                )

                                is DrawableResourceIcon -> Icon(
                                    painter = painterResource(id = it.icon.id),
                                    contentDescription = null,
                                    tint = Color(0xFF4CAF50),
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                        },
                        text = {
                            Text(
                                text = it.text,
                                style = MaterialTheme.typography.labelLarge,
                                color = Color(0xFF4A148C)
                            )
                        }
                    )
                }
            }

        }

    }
}

@Composable
fun ImageTextContent(
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        icon()
        Spacer(modifier = Modifier.width(5.dp))
        text()
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun MainProfileContent() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
        color = Color(0xFFFFFFFF)
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = "Popular",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF6A1B9A)
            )
            PopularContentList()

            Divider(modifier = Modifier.padding(vertical = 16.dp), color = Color(0xFFBDBDBD))

            GitContentItem(
                modifier = Modifier.padding(vertical = 2.dp),
                icon = {
                    Icon(
                        imageVector = ImageVectorIcon(MyIcons.List).imageVector,
                        contentDescription = null,
                        tint = Color(0xFFFF5722),
                        modifier = Modifier
                            .size(40.dp)
                            .padding(6.dp)
                    )
                },
                text = {
                    Text(
                        text = "Repositories",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(0xFF4A148C)
                    )
                },
                endItem = {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "24",
                        color = Color(0xFF6A1B9A)
                    )
                }
            )
            GitContentItem(
                modifier = Modifier.padding(vertical = 2.dp),
                icon = {
                    Icon(
                        imageVector = ImageVectorIcon(MyIcons.Star).imageVector,
                        contentDescription = null,
                        tint = Color(0xFFFF5722),
                        modifier = Modifier
                            .size(40.dp)
                            .padding(6.dp)
                    )
                },
                text = {
                    Text(
                        text = "Starred",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(0xFF4A148C)
                    )
                },
                endItem = {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "60",
                        color = Color(0xFF6A1B9A)
                    )
                }
            )
        }
    }
}

@Composable
fun PopularContentList() {
    LazyRow {
        items(
            items = profilePopularList,
            itemContent = {
                Surface(
                    modifier = Modifier
                        .width(250.dp)
                        .padding(5.dp),
                    shape = RoundedCornerShape(8),
                    border = BorderStroke(1.dp, Color(0xFF6A1B9A)),
                    color = Color(0xFFFFFFFF)
                ) {
                    Column(modifier = Modifier.padding(5.dp)) {
                        Row(
                            modifier = Modifier.padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
//                                painter = painterResource(id = DrawableResourceIcon(MyIcons.AppIcon).id),
                                imageVector = MyIcons.AppIcon,
                                contentDescription = null,
                                tint = Color(0xFF6A1B9A),
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = it.name,
                                style = MaterialTheme.typography.titleSmall,
                                color = Color(0xFF4A148C)
                            )
                        }

                        Text(
                            modifier = Modifier.padding(vertical = 5.dp),
                            text = it.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFF6A1B9A),
                            maxLines = 2,
                        )

                        Row(
                            modifier = Modifier.padding(vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            ImageTextContent(
                                modifier = Modifier.padding(vertical = 5.dp),
                                icon = {
                                    Icon(
                                        imageVector = ImageVectorIcon(MyIcons.Star).imageVector,
                                        contentDescription = null,
                                        tint = Color(0xFFFFC107),
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(15.dp)
                                    )
                                },
                                text = {
                                    Text(
                                        text = it.star,
                                        style = MaterialTheme.typography.labelLarge,
                                        color = Color(0xFF6A1B9A)
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            ImageTextContent(
                                modifier = Modifier.padding(vertical = 5.dp),
                                icon = {
                                    Icon(
//                                        painter = painterResource(id = DrawableResourceIcon(MyIcons.AppIcon).id),
                                        imageVector = MyIcons.AppIcon,
                                        contentDescription = null,
                                        tint = Color(0xFF4CAF50),
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .size(15.dp)
                                    )
                                },
                                text = {
                                    Text(
                                        text = it.language,
                                        style = MaterialTheme.typography.labelLarge,
                                        color = Color(0xFF4A148C)
                                    )
                                }
                            )
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun GitContentItem(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    endItem: @Composable () -> Unit,
) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        icon()
        Column(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .weight(1f)
        ) {
            text()
        }
        endItem()
    }
}

@Composable
fun FooterContent() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(8),
        color = Color(0xFFF3E5F5)
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                modifier = Modifier
                    .padding(10.dp),
//                text = stringResource(id = R.string.txt_more_options),
                text = "More Options",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF6A1B9A)
            )
            moreOptionsList.forEach {
                MoreOptionsComp(it)
            }
        }
    }
}

@Composable
fun MoreOptionsComp(
    featureList: FeatureList,
) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .background(Color(0xFFF3E5F5), RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        when (featureList.listIcon) {
            is ImageVectorIcon -> Icon(
                imageVector = featureList.listIcon.imageVector,
                contentDescription = null,
                tint = Color(0xFF6A1B9A),
                modifier = Modifier
                    .size(40.dp)
                    .padding(6.dp)
            )

            is DrawableResourceIcon -> Icon(
                painter = painterResource(id = featureList.listIcon.id),
                contentDescription = null,
                tint = Color(0xFF6A1B9A),
                modifier = Modifier
                    .size(40.dp)
                    .padding(6.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .weight(1f)
        ) {
            Text(
                text = featureList.name,
                style = MaterialTheme.typography.labelLarge,
                color = Color(0xFF4A148C)
            )
        }
        Icon(
            imageVector = MyIcons.KeyboardArrowRight,
            contentDescription = null,
            tint = Color(0xFFFF5722),
            modifier = Modifier.padding(4.dp)
        )
    }
}

// Preview Function
@Preview(showBackground = true, name = "Profile Screen Preview")
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}