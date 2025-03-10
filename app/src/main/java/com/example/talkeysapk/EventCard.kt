package com.example.talkeysapk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.talkeysapk.ui.theme.TalkeysApkTheme
@Composable
fun EventCard(title: String, location: String, imageRes: Int) {
    // ✅ Wrapper Box to Add White Glow Below the Card
    Box(
        modifier = Modifier
            .width(162.dp)
//            .shadow(
//                elevation = 40.dp, // Higher elevation for glow effect
//                spotColor = Color.White.copy(alpha = 0.5f), // Soft white glow
//                ambientColor = Color.White.copy(alpha = 0.5f),
//                shape = RoundedCornerShape(15.dp) // Keep shape consistent
//            )
    ) {
        // ✅ Grey Background Card
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
//                .shadow(
//                    elevation = 4.dp,
//                    spotColor = Color(0xFF000000),
//                    ambientColor = Color(0xFF000000)
//                )
//                .shadow(
//                    elevation = 27.dp,
//                    spotColor = Color(0x40FFFFFF),
//                    ambientColor = Color(0x40FFFFFF)
//                )
                .width(162.dp)
                .background(color = Color(0x1AFFFFFF), shape = RoundedCornerShape(size = 15.dp))
                .padding(start = 6.dp, top = 6.dp, bottom = 6.dp) // ✅ Removed right padding
        ) {
            // ✅ Adjusted Event Image Height (No Right-Side Padding)
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Crop,  // Ensures image fills the space properly
                modifier = Modifier
                    .fillMaxWidth() // ✅ Ensures image takes full width
                    .height(250.dp) // Increased height
                    .clip(RoundedCornerShape(15.dp)) // Rounded corners
            )

            // ✅ Event Title (Dynamic Width)
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_bold)),
                    color = Color.White
                ),
                modifier = Modifier.padding(top = 2.dp)
            )

            // ✅ Event Location (No Fixed Width to Avoid Cutting Text)
            Text(
                text = location,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.urbanist_medium)),
                    color = Color.White
                )
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEventCard() {
    TalkeysApkTheme {
        EventCard(
            title = "Sunday Salsa",
            location = "Downtown Club",
            imageRes = R.drawable.ic_eventbanner
        )
    }
}


