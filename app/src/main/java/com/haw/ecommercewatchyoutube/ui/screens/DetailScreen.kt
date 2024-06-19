package com.haw.ecommercewatchyoutube.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haw.ecommercewatchyoutube.R
import com.haw.ecommercewatchyoutube.data.itemsViewPager
import com.haw.ecommercewatchyoutube.model.CategoryViewPager
import com.haw.ecommercewatchyoutube.ui.component.ViewPagerItem
import com.haw.ecommercewatchyoutube.ui.theme.BluePrimary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(modifier: Modifier = Modifier, onClickBack: () -> Unit) {

    val buttonGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF8743FF),
            Color(0xFF4136F1)
        )
    )

    val itemsViewPager = listOf(
        CategoryViewPager(name = "Details"),
        CategoryViewPager(name = "Review"),
    )

    val pagerState = rememberPagerState { itemsViewPager.size }

    Surface(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp)
        ) {
            // Top Bar
            TopBar(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                onClickBack = onClickBack
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .padding(top = 16.dp),
                painter = painterResource(id = R.drawable.img_detail_screen),
                contentDescription = "Image Detail"
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Apple Watch Series 7",
                        fontFamily = FontFamily(Font(R.font.raleway_bold)),
                        fontSize = 20.sp
                    )

                    Text(
                        modifier = Modifier.padding(top = 6.dp),
                        text = "(With solo loop)",
                        fontFamily = FontFamily(Font(R.font.raleway_light)),
                        fontSize = 12.sp
                    )
                }

                Text(
                    text = "$799",
                    fontFamily = FontFamily(Font(R.font.raleway_bold)),
                    fontSize = 24.sp,
                    color = BluePrimary
                )
            }

            HorizontalPager(
                modifier = Modifier.padding(top = 36.dp, start = 16.dp, end = 16.dp),
                state = pagerState
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(itemsViewPager) { categoryViewPager ->
                        ViewPagerItem(
                            isSelected = pagerState.currentPage == itemsViewPager.indexOf(
                                categoryViewPager
                            ),
                            item = categoryViewPager
                        )
                    }
                }
            }

            // Description
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "The aluminium case is lightweight and made\n" +
                        "from 100 percent recycled aerospace\n" +
                        "grade alloy.",
                fontFamily = FontFamily(Font(R.font.raleway_light))
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp)
                    .background(brush = buttonGradientBrush, shape = RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                onClick = { }
            ) {
                Text("Add to Cart", fontFamily = FontFamily(Font(R.font.raleway_bold)))
            }
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier, onClickBack: () -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.clickable { onClickBack() },
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Icon Back"
        )

        Image(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Icon Favorite")
    }
}

@Preview
@Composable
private fun DetailScreenPreview() {
    DetailScreen(onClickBack = {})
}