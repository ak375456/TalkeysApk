package com.example.talkeysapk

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkies.ui.HomeTopBar

@Composable
fun ExploreEventsScreen(navController: NavController) {
    val category1Events = listOf(
        Event("Sunday Salsa", "Downtown Club", R.drawable.ic_eventbanner),
        Event("Jazz Night", "The Blue Note", R.drawable.ic_eventbanner),
        Event("Rock Fest", "City Arena", R.drawable.ic_eventbanner),
        Event("Tech Meetup", "Silicon Valley Hub", R.drawable.ic_eventbanner),
        Event("Food Carnival", "Central Park", R.drawable.ic_eventbanner)
    )

    val category2Events = listOf(
        Event("Coding Hackathon", "Tech Park", R.drawable.ic_eventbanner),
        Event("Startup Pitch", "Innovation Center", R.drawable.ic_eventbanner),
        Event("AI Conference", "Grand Hotel", R.drawable.ic_eventbanner),
        Event("Blockchain Summit", "Convention Center", R.drawable.ic_eventbanner),
        Event("Product Showcase", "Exhibition Hall", R.drawable.ic_eventbanner)
    )

    val category3Events = listOf(
        Event("Yoga Retreat", "Peaceful Hills", R.drawable.ic_eventbanner),
        Event("Meditation Camp", "Tranquil Valley", R.drawable.ic_eventbanner),
        Event("Fitness Bootcamp", "City Gym", R.drawable.ic_eventbanner),
        Event("Marathon Run", "Downtown Streets", R.drawable.ic_eventbanner),
        Event("Sports Festival", "Olympic Stadium", R.drawable.ic_eventbanner)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(bottom = 56.dp) // Padding for BottomBar
        ) {
            // Top Bar
            HomeTopBar()

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text(
                        text = "Explore Events",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(top = 12.dp, start = 19.dp)
                    )
                }

                item { Spacer(modifier = Modifier.height(4.dp)) }

                item { CategoryTitle("Gaming") }
                item { Spacer(modifier = Modifier.height(1.dp)) }
                item { EventRow(category1Events) }
                item { Spacer(modifier = Modifier.height(5.dp)) }

                item { CategoryTitle("Parties") }
                item { Spacer(modifier = Modifier.height(1.dp)) }
                item { EventRow(category2Events) }
                item { Spacer(modifier = Modifier.height(5.dp)) }

                item { CategoryTitle("Category 3") }
                item { Spacer(modifier = Modifier.height(1.dp)) }
                item { EventRow(category3Events) }
                item { Spacer(modifier = Modifier.height(5.dp)) }

                item { Footer() }
            }
        }

        val scrollState= rememberScrollState()
        // BottomBar
        BottomBar(navController = navController, scrollState,modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun CategoryTitle(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
            color = Color.White,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .padding(start = 19.dp)
            .width(120.dp)
            .height(19.dp)
    )
}

@Composable
fun EventRow(events: List<Event>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 19.dp),
        horizontalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        items(events) { event ->
            EventCard(title = event.title, location = event.location, imageRes = event.imageRes)
        }
    }
}