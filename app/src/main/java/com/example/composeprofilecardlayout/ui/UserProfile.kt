package com.example.composeprofilecardlayout.ui

import com.example.composeprofilecardlayout.R

data class UserProfile constructor(
    val userId: Int,
    val userName: String,
    val userStatus: Boolean,
    val profilePic: String
)

public val listOfUsers = arrayListOf(
    UserProfile(
        userId = 0,
        userName = "Michaela Runnings",
        userStatus = true,
        "https://images.unsplash.com/photo-1485290334039-a3c69043e517?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80"
    ),
    UserProfile(
        userId = 1,
        userName = "John Pestridge",
        userStatus = false,
        "https://images.unsplash.com/photo-1542178243-bc20204b769f?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTB8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 2,
        userName = "Manilla Andrews",
        userStatus = true,
        "https://images.unsplash.com/photo-1543123820-ac4a5f77da38?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDh8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 3,
        userName = "Dan Spicer",
        userStatus = false,
        "https://images.unsplash.com/photo-1595152772835-219674b2a8a6?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NDd8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 4,
        userName = "Keanu Dester",
        userStatus = false,
        "https://images.unsplash.com/photo-1597528380214-aa94bde3fc32?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NTZ8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 5,
        userName = "Anichu Patel",
        userStatus = false,
        "https://images.unsplash.com/photo-1598641795816-a84ac9eac40c?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NjJ8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 6,
        userName = "Kienla Onso",
        userStatus = true,
        "https://images.unsplash.com/photo-1566895733044-d2bdda8b6234?ixid=MXwxMjA3fDB8MHxzZWFyY2h8ODh8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 7,
        userName = "Andra Matthews",
        userStatus = false,
        "https://images.unsplash.com/photo-1530577197743-7adf14294584?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NTV8fHBvcnRyYWl0fGVufDB8MnwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 8,
        userName = "Georgia S.", userStatus = false,
        "https://images.unsplash.com/photo-1547212371-eb5e6a4b590c?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTA3fHxwb3J0cmFpdHxlbnwwfDJ8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 0,
        userName = "Matt Dengo",
        userStatus = false,
        "https://images.unsplash.com/photo-1578176603894-57973e38890f?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTE0fHxwb3J0cmFpdHxlbnwwfDJ8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 0,
        userName = "Marsha T.",
        userStatus = true,
        "https://images.unsplash.com/photo-1605087880595-8cc6db61f3c6?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTI0fHxwb3J0cmFpdHxlbnwwfDJ8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 0,
        userName = "Invshu Patel",
        userStatus = true,
        "https://images.unsplash.com/photo-1561820009-8bef03ebf8e5?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTM3fHxwb3J0cmFpdHxlbnwwfDJ8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 0,
        userName = "Braylen Nathan",
        userStatus = true,
        "https://images.unsplash.com/photo-1605857840732-188f2f08cb31?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTQ5fHxwb3J0cmFpdHxlbnwwfDJ8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 0,
        userName = "Jorge Andre",
        userStatus = false,
        "https://images.unsplash.com/photo-1517588632672-9758d6acba04?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTYyfHxwb3J0cmFpdHxlbnwwfDJ8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 0,
        userName = "Jamison Dana",
        userStatus = false,
        "https://images.unsplash.com/photo-1513690277738-c9bc7eb2a992?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTY1fHxwb3J0cmFpdHxlbnwwfDJ8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
    UserProfile(
        userId = 0,
        userName = "Laura S.",
        userStatus = true,
        "https://images.unsplash.com/photo-1513708847802-f2fa846a7eaa?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTg1fHxwb3J0cmFpdHxlbnwwfDJ8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
    ),
)
