package com.haw.ecommercewatchyoutube.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haw.ecommercewatchyoutube.R

@Composable
fun SearchBarView(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(38.dp),
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu Icon"
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 56.dp)
                .weight(1f)
                .height(48.dp),
            shape = RoundedCornerShape(32.dp),
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            placeholder = {
                Text(
                    text = "Search Product",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.raleway_light))
                )
            },
            value = "Search Product",
            onValueChange = {}
        )
    }
}