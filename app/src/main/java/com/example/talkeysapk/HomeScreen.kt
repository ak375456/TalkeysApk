package com.example.talkeysapk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.talkeysapk.ui.theme.TalkeysApkTheme
import com.example.talkeysapk.ui.theme.Urbanist
import com.example.talkies.ui.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = { HomeTopBar() } // ✅ Keeps TopBar fixed
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues) // Full-screen layout
        ) {
            // ✅ Background Image
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // ✅ Foreground UI Content
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                //     HomeTopBar() // ✅ Fixed Top Bar

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 100.dp)
                ) {
                    item {
                        // ✅ Banner Section
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.5f)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.banner),
                                contentDescription = "Banner",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )

                            // ✅ Overlay Box for Text & Buttons
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.85f)
                                    .align(Alignment.Center)
                                    .background(
                                        Color.Black.copy(alpha = 0.8f),
                                        RoundedCornerShape(12.dp)
                                    )
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    // ✅ Banner Heading
                                    Text(
                                        text = "Explore Shows and \nevents with ease.",
                                        color = Color.White,
                                        fontSize = 20.sp,
                                        fontFamily = Urbanist,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))

                                    // ✅ Banner Description
                                    Text(
                                        text = "Connect with fellow enthusiasts in our \nchat rooms. Share experiences and ideas\nanonymously.",
                                        color = Color(0xFF8A44CB),
                                        fontSize = 14.sp,
                                        fontFamily = Urbanist,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.fillMaxWidth()
                                    )

                                    Spacer(modifier = Modifier.height(12.dp))

                                    // ✅ Buttons Row
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(
                                            8.dp,
                                            Alignment.CenterHorizontally
                                        ),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Button(
                                            onClick = { navController.navigate("events") },
                                            modifier = Modifier
                                                .width(140.dp)  // Reduced width slightly
                                                .height(48.dp),
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color(0xFF8A44CB)
                                            )
                                        ) {
                                            Text(
                                                text = "Explore Events",
                                                fontSize = 14.sp,  // Slightly smaller for better fit
                                                fontFamily = Urbanist,
                                                fontWeight = FontWeight.Medium,
                                                color = Color.White,
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                        }

                                        Button(
                                            onClick = { navController.navigate("communities") },
                                            modifier = Modifier
                                                .width(260.dp)  // Increased width for full text
                                                .height(48.dp),
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color(0xFF8A44CB)
                                            )
                                        ) {
                                            Text(
                                                text = "Explore Community",
                                                fontSize = 14.sp,  // Slightly reduced to fit well
                                                fontFamily = Urbanist,
                                                fontWeight = FontWeight.Medium,
                                                color = Color.White,
                                                textAlign = TextAlign.Start,
                                                maxLines = 1,  // Forces it to stay in one line
                                                overflow = TextOverflow.Visible,  // Ensures full text shows
                                                modifier = Modifier.wrapContentWidth()  // Prevents squishing
                                            )
                                        }


                                    }
                                }
                            }
                        }
                    }

                    // ✅ Upcoming Events Section
                    item {
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = "Upcoming Events",
                            modifier = Modifier.padding(start = 19.5.dp),
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(28.dp)
                        ) {
                            val eventList = listOf(
                                Event("Sunday Salsa", "Location", R.drawable.ic_eventbanner),
                                Event("Rock Concert", "Downtown Hall", R.drawable.ic_eventbanner),
                                Event("Tech Meetup", "City Center", R.drawable.ic_eventbanner)
                            )
                            items(eventList) { event ->
                                EventCard(
                                    title = event.title,
                                    location = event.location,
                                    imageRes = event.imageRes
                                )
                            }
                        }
                    }

                    // ✅ Featured Communities Section
                    item {
                        Spacer(modifier = Modifier.height(32.dp)) // ✅ Padding before heading

                        Text(
                            text = "Featured Communities",
                            modifier = Modifier
                                .padding(start = 19.5.dp) // Consistent padding
                                .width(220.dp)
                                .height(26.dp),
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                                color = Color.White,
                                textAlign = TextAlign.Center

                            )
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp)) // ✅ Padding before LazyRow

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(22.dp) // ✅ Space between cards
                        ) {
                            // ✅ Updated community list with descriptions
                            val communityList = listOf(
                                HomePageCommunity(
                                    "Music Lovers",
                                    R.drawable.ic_community_card,
                                    "Description"
                                ),
                                HomePageCommunity(
                                    "Tech Geeks",
                                    R.drawable.ic_community_card,
                                    "Description"
                                ),
                                HomePageCommunity(
                                    "Dance Squad",
                                    R.drawable.ic_community_card,
                                    "Description"
                                )
                            )

                            // ✅ Updated CommunityCard calls to include description
                            items(communityList) { community ->
                                CommunityCard(
                                    name = community.name,
                                    imageRes = community.imageRes,
                                    description = community.description
                                )
                            }
                        }
                    }


                    // ✅ Influencers Section
                    item {
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = "Influencers Shaping the Community",
                            modifier = Modifier
                                .padding(start = 19.5.dp) // Consistent padding
                                .width(346.dp)
                                .height(26.dp),
                            style = TextStyle(
                                fontSize = 22.sp,
                                fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(8.dp)) // Spacer above LazyRow

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(15.dp) // Padding between cards
                        ) {
                            val influencerList = listOf(
                                InfluencerHomeScreen(
                                    "Arijit Sharma",
                                    "F1 Racer",
                                    R.drawable.ic_influencer_banner
                                ),
                                InfluencerHomeScreen(
                                    "Arsh Chatrath",
                                    "Cricketer",
                                    R.drawable.ic_influencer_banner
                                ),
                                InfluencerHomeScreen(
                                    "Rohan Mehta",
                                    "Tech Reviewer",
                                    R.drawable.ic_influencer_banner
                                )
                            )
                            items(influencerList) { influencer ->
                                InfluencerCard(
                                    name = influencer.name,
                                    profession = influencer.profession,
                                    imageRes = influencer.imageResId
                                )
                            }
                        }
                    }
                    item {
                        HostEventSection()
                    }
                    item {
                        Footer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                        )
                    }

                }

            }
            BottomBar(
                navController,
                scrollState,
                modifier = Modifier
                   .align(Alignment.BottomCenter)
                   .fillMaxWidth()
            )


        }
    }
}
    @Composable
    fun HostEventSection(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .width(260.dp) // Increased width to prevent line break
            ) {
                Text(
                    text = "Host your own EVENT!!!",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFFCFCFC),
                    )
                )

                Spacer(modifier = Modifier.height(45.dp))

                Text(
                    text = "Create an event, invite your community, and manage everything in one place.",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .width(237.dp)
                        .height(57.dp)
                )

                Spacer(modifier = Modifier.height(28.dp))

                // Moved button slightly to the right
                Box(
                    modifier = Modifier
                        .padding(start = 63.5.dp)
                        .width(130.dp) // Adjusted width
                        .height(45.dp) // Adjusted height
                        .background(color = Color(0xFF8A44CB), shape = RoundedCornerShape(8.dp))
                        .padding(vertical = 10.dp)
                        .clickable { /* Navigate to event creation */ },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Host Event",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.urbanist_semibold)),
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }

            // Sticker Image - Increased size
            Image(
                painter = painterResource(id = R.drawable.hostevent_sticker),
                contentDescription = "Dancing Stormtroopers",
                modifier = Modifier
                    .height(230.dp) // Adjusted height to extend to the bottom
                    .padding(start = 16.dp)
            )
        }
    }


@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun HostEventSectionPreview() {
    HostEventSection()
}


