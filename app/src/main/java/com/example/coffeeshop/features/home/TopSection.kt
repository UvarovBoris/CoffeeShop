package com.example.coffeeshop.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R
import com.example.coffeeshop.ui.theme.Brown
import com.example.coffeeshop.ui.theme.GreyLighter
import com.example.coffeeshop.ui.theme.GreyNormal
import com.example.coffeeshop.ui.theme.GreyNormalHover
import com.example.coffeeshop.ui.theme.SoraFontFamily
import com.example.coffeeshop.ui.theme.SurfaceNormalActive
import com.example.coffeeshop.ui.theme.SurfaceWhite

@Composable
fun TopSection(
    modifier: Modifier = Modifier,
    paddingTop: Dp = 0.dp,
    searchText: String,
    onSearchTextChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    listOf(Color(0xFF111111), GreyNormal),
                    start = Offset(Float.POSITIVE_INFINITY, 0f),
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
            .padding(
                top = paddingTop,
                start = 24.dp,
                end = 24.dp
            )
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.home_top_location),
            color = GreyLighter,
            fontFamily = SoraFontFamily,
            fontSize = 12.sp,
            lineHeight = 14.4.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Bilzen, Tanjungbalai",
            color = SurfaceNormalActive,
            fontFamily = SoraFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 21.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = searchText,
                onValueChange = onSearchTextChange,
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = SoraFontFamily,
                    lineHeight = 16.8.sp,
                    letterSpacing = 0.sp,
                ),
                singleLine = true,
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = null,
                        tint = SurfaceWhite
                    )
                },
                placeholder = { SearchPlaceholder() },
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors().copy(
                    focusedTextColor = SurfaceWhite,
                    unfocusedTextColor = SurfaceWhite,
                    focusedContainerColor = GreyNormalHover,
                    unfocusedContainerColor = GreyNormalHover,
                    cursorColor = SurfaceWhite,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(color = Brown)
                    .clickable(onClick = {})
                    .padding(18.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.filters),
                    contentDescription = "Filters",
                    tint = SurfaceWhite
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun SearchPlaceholder() {
    Text(
        text = stringResource(R.string.home_top_search_hint),
        color = GreyLighter,
        fontSize = 14.sp,
        fontFamily = SoraFontFamily,
        lineHeight = 16.8.sp,
        letterSpacing = 0.sp
    )
}

@Preview
@Composable
fun TopSectionPreview() {
    TopSection(
        searchText = "",
        onSearchTextChange = {}
    )
}