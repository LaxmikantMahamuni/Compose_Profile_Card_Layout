package com.example.composeprofilecardlayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.example.composeprofilecardlayout.ui.UserProfile
import com.example.composeprofilecardlayout.ui.listOfUsers
import com.example.composeprofilecardlayout.ui.theme.LocalCustomColorsPalette
import com.example.composeprofilecardlayout.ui.theme.MyTheme
import com.example.composeprofilecardlayout.ui.theme.Typography

class MainActivity : ComponentActivity() {
    var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContent {
            MyTheme {
                UsersApplication()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(appBarTitle: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = appBarTitle)
        },
        navigationIcon = {
            IconButton(onClick = {
                iconClickAction.invoke()
            }) {
                Icon(
                    icon, "homeIcon",
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
fun UsersApplication(userProfilesList: ArrayList<UserProfile> = listOfUsers) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "users_list") {
        composable("users_list") {
            UserProfileListScreen(userProfilesList, navController)
        }
        composable(
            route = "user_details/{userId}",
            arguments = listOf(navArgument("userId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            UserProfileDetailsScreen(
                navBackStackEntry.arguments!!.getInt("userId"),
                navController = navController
            )
        }
    }
}

@Composable
fun UserProfileListScreen(userProfilesList: ArrayList<UserProfile>, navController: NavController?) {
    Scaffold(topBar = {
        AppBar("Messaging Application", Icons.Filled.Home) {

        }
    }) { paddingValues ->
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
                        ProfileCard(userProfile) {
                            navController?.navigate("user_details/${userProfile.userId}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun UserProfileDetailsScreen(userId: Int, navController: NavController?) {
    val userProfile = listOfUsers.first { userProfile -> userProfile.userId == userId }

    Scaffold(topBar = {
        AppBar(
            "User Profile Details",
            Icons.AutoMirrored.Filled.ArrowBack
        ) {
            navController?.navigateUp()
        }
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
//                .verticalScroll(rememberScrollState())
        ) {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    ProfilePicture(userProfile.profilePic, userProfile.userStatus, 240.dp)
                    ProfileDetails(
                        userProfile.userName,
                        userProfile.userStatus,
                        Alignment.CenterHorizontally
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Top)
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 8.dp)
            .clickable { clickAction.invoke() },
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.profilePic, userProfile.userStatus, 72.dp)
            ProfileDetails(userProfile.userName, userProfile.userStatus, Alignment.Start)
        }
    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ProfilePicture(profilePic: String, status: Boolean, imageSize: Dp) {
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
                .size(imageSize),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileDetails(name: String, status: Boolean, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
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
fun UserProfileDetailPreview() {
    MyTheme {
        UserProfileDetailsScreen(userId = 0, navController = null)
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileListPreview() {
    MyTheme {
        UserProfileListScreen(userProfilesList = listOfUsers, null)
    }
}