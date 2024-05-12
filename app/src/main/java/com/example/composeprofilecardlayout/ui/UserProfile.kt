package com.example.composeprofilecardlayout.ui

import com.example.composeprofilecardlayout.R

data class UserProfile constructor(
    val userName: String,
    val userStatus: Boolean,
    val profilePic: Int
)

public val listOfUsers = arrayListOf(
    UserProfile("John Doe", false, R.drawable.profile_picture),
    UserProfile("Anna Freddy", true, R.drawable.profile_picture2),
    UserProfile("John Doe", false, R.drawable.profile_picture),
    UserProfile("Anna Freddy", true, R.drawable.profile_picture2),
    UserProfile("John Doe", false, R.drawable.profile_picture),
    UserProfile("Anna Freddy", true, R.drawable.profile_picture2),
    UserProfile("John Doe", false, R.drawable.profile_picture),
    UserProfile("Anna Freddy", true, R.drawable.profile_picture2),
    UserProfile("John Doe", false, R.drawable.profile_picture),
    UserProfile("Anna Freddy", true, R.drawable.profile_picture2),
    UserProfile("John Doe", false, R.drawable.profile_picture),
    UserProfile("Anna Freddy", true, R.drawable.profile_picture2)
)
