package com.example.coffeeshop.features.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R
import com.example.coffeeshop.common.presentation.utils.SetStatusBarTextColor
import com.example.coffeeshop.ui.theme.Black
import com.example.coffeeshop.ui.theme.SoraFontFamily
import com.example.coffeeshop.ui.theme.Brown

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    onGetStartedClick: () -> Unit
) {
    OnboardingScreen(
        onGetStartedClick = onGetStartedClick
    )
}

@Composable
fun OnboardingScreen(onGetStartedClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )
        OnboardingInfoSection(
            modifier = Modifier.align(Alignment.BottomCenter),
            onGetStartedClick
        )
    }
}

@Composable
fun OnboardingInfoSection(
    modifier: Modifier,
    onGetStartedClick: () -> Unit
) {
    SetStatusBarTextColor(isDark = false)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    0f to Black.copy(alpha = 0f),
                    0.24f to Black
                )
            )
            .padding(WindowInsets.navigationBars.asPaddingValues())
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = stringResource(R.string.onboarding_title),
                color = Color.White,
                fontSize = 32.sp,
                fontFamily = SoraFontFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                letterSpacing = 0.16.sp,
                lineHeight = 48.sp
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
            Text(
                text = stringResource(R.string.onboarding_description),
                color = Color(0xFFA2A2A2),
                fontSize = 14.sp,
                fontFamily = SoraFontFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                letterSpacing = 0.14.sp,
                lineHeight = 21.sp
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
            )
            Button(
                onClick = onGetStartedClick,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(size = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Brown),
                contentPadding = PaddingValues(all = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.onboarding_button),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = SoraFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 24.sp
                )
            }
        }
    }
}

@Preview(
    widthDp = 360,
    heightDp = 800
)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(onGetStartedClick = {})
}
