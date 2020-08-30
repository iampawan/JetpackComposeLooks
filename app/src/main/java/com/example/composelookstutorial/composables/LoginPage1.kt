package com.example.composelookstutorial.composables

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.composelookstutorial.R
import com.example.composelookstutorial.ui.orangish
import com.example.composelookstutorial.ui.purplish
import com.example.composelookstutorial.ui.shapes


@Preview(showBackground = true)
@Composable
fun LoginPage1() {

    Stack {
        BgCard()
        MainCard()

    }

}

@Composable
fun BgCard() {
    val signupText = annotatedString {
        append("Don't have an account? ")
        withStyle(SpanStyle(color = orangish)) {
            append("Sign up here!")
        }
    }
    Surface(color = purplish, modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Bottom, horizontalGravity = Alignment.CenterHorizontally, modifier = Modifier.offset(y = (-30).dp)
        ) {
            Row() {
                Image(asset = vectorResource(id = R.drawable.ic_fb))
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(asset = vectorResource(id = R.drawable.ic_google))
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Image(asset = vectorResource(id = R.drawable.ic_twitter))

            }
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = signupText, color = Color.White)
        }
    }
}


@Composable
fun MainCard() {
    val emailState = remember { mutableStateOf(TextFieldValue("mtechviral@gmail.com")) }
    val passState = remember { mutableStateOf(TextFieldValue("")) }
    Surface(color = Color.White, modifier = Modifier.preferredHeight(600.dp).fillMaxWidth(),
            shape = RoundedCornerShape(60.dp).copy(topLeft = ZeroCornerSize, topRight = ZeroCornerSize)) {
        Column(modifier = Modifier.padding(16.dp), horizontalGravity = Alignment.CenterHorizontally
        ) {

            val modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            Image(asset = vectorResource(id = R.drawable.ic_vaccum))
            Spacer(modifier = Modifier.padding(16.dp))
            OutlinedTextField(value = emailState.value, onValueChange = {
                emailState.value = it
            }, {
                Text(text = "Email address")
            }, leadingIcon = { Icon(Icons.Filled.Email) }, modifier = modifier)

            Spacer(modifier = Modifier.padding(6.dp))

            OutlinedTextField(value = passState.value, onValueChange = {
                passState.value = it
            }, {
                Text(text = "Password")

            }, leadingIcon = { Icon(Icons.Filled.Lock) }, modifier = modifier, keyboardType = KeyboardType.Password)

            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            ProvideEmphasis(emphasis = EmphasisAmbient.current.disabled) {
                Text(text = "Forgot password?", textAlign = TextAlign.End, modifier = modifier)
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Button(onClick = {}, backgroundColor = orangish, shape = shapes.medium,
                    contentColor = Color.White, modifier = modifier, contentPadding = InnerPadding(16.dp)
            ) {
                Text(text = "Log In")
            }
        }
    }
}