package com.example.composeprofilecardlayout

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.composeprofilecardlayout.ui.UserProfile
import com.example.composeprofilecardlayout.ui.listOfUsers
import com.example.composeprofilecardlayout.ui.theme.LocalCustomColorsPalette
import com.example.composeprofilecardlayout.ui.theme.MyTheme
import com.example.composeprofilecardlayout.ui.theme.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContent {
            MyTheme {
                MainScreen(context as MainActivity)
            }
        }
    }
}

@Composable
fun MainScreen(context: Context, userProfilesList: ArrayList<UserProfile> = listOfUsers) {
    Scaffold(topBar = { AppBar() }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
//                .verticalScroll(rememberScrollState())
        ) {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyColumn {
                    items(userProfilesList) { userProfile ->
                        ProfileCard(context, userProfile)
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(text = "Messaging Application Users")
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Filled.Home, "homeIcon",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White,
        ),
    )
}

@Composable
fun ProfileCard(context: Context, userProfile: UserProfile) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Top)
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 8.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(context, userProfile.profilePic, userProfile.userStatus)
            ProfileDetails(userProfile.userName, userProfile.userStatus)
        }
    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ProfilePicture(context: Context, profilePic: String, status: Boolean) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (status)
                LocalCustomColorsPalette.current.extraGreenColor
            else
                LocalCustomColorsPalette.current.extraRedColor
        ),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        /*SubcomposeAsyncImage(
            model = "https://image.tmdb.org/t/p/w500/1pdfLvkbY9ohJlCjQH2CZjjYVvJ.jpg",
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = "Image View",
            modifier = Modifier
                .clip(CircleShape)
                .size(72.dp),
            contentScale = ContentScale.Crop
        )*/
        AsyncImage(
            model = profilePic,
            contentDescription = "Display Image View",
            modifier = Modifier
                .clip(CircleShape)
                .size(72.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileDetails(name: String, status: Boolean) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = name, style = Typography.headlineMedium)
        CompositionLocalProvider(LocalContentColor provides Color.Gray) {
            Text(
                text = if (status) "Active Now" else "Offline",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTheme {
//        MainScreen(context = MainActivity)
    }
}