package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color(0xFF073042)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        LogoSection()
        Spacer(modifier = Modifier.height(50.dp))
        ContactDetails()
    }
}

@Composable
fun LogoSection(modifier: Modifier = Modifier){
    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier
                .padding(5.dp)
                .size(200.dp)
        )
        Text(
            text = stringResource(R.string.card_name),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(5.dp)
        )
        Text(
            text = stringResource(R.string.card_title),
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier
        )
    }
}

@Composable
fun ContactDetails(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .padding(10.dp),
    ) {
        Row {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = "Phone Icon",
                tint = Color(0xFF3ddc84),
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, end = 10.dp)
            )
            Text(
                text = stringResource(R.string.phone_number),
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier
            )
        }
        Row {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = "Email Icon",
                tint = Color(0xFF3ddc84),
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = stringResource(R.string.email),
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, end = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}