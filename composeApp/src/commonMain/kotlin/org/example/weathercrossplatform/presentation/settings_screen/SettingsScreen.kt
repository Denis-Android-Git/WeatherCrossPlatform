package org.example.weathercrossplatform.presentation.settings_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.weathercrossplatform.presentation.elements.MyDropDownElement
import org.example.weathercrossplatform.presentation.elements.SettingsType
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.about_app
import weathercrossplatform.composeapp.generated.resources.policy
import weathercrossplatform.composeapp.generated.resources.settings
import weathercrossplatform.composeapp.generated.resources.units

@Composable
fun SettingsScreenRoot(
    modifier: Modifier,
    viewModel: SettingsScreenViewModel = koinViewModel(),
    onBackButtonClick: () -> Unit

) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SettingsScreenScreen(
        state = state,
        onAction = viewModel::onAction,
        onBackButtonClick = onBackButtonClick,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenScreen(
    modifier: Modifier,
    state: SettingsScreenState,
    onAction: (SettingsScreenAction) -> Unit,
    onBackButtonClick: () -> Unit
) {

    Column(
        modifier = modifier.fillMaxSize().background(color = Color.Black)
            .padding(WindowInsets.systemBars.asPaddingValues()).padding(horizontal = 8.dp)
    ) {
        IconButton(
            onClick = onBackButtonClick
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "back",
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(Res.string.settings),
            modifier = Modifier.padding(start = 10.dp),
            color = Color.White, fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(Res.string.units),
            modifier = Modifier.padding(start = 10.dp),
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(6.dp))
        Column(
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
                .background(color = Color.DarkGray, shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 10.dp, vertical = 24.dp)
        ) {
            MyDropDownElement(
                onAction = onAction,
                state = state,
                settingsType = SettingsType.TEMPERATURE
            )
            Spacer(modifier = Modifier.height(24.dp))
            MyDropDownElement(
                onAction = onAction,
                state = state,
                settingsType = SettingsType.WIND
            )
            Spacer(modifier = Modifier.height(24.dp))
            MyDropDownElement(
                onAction = onAction,
                state = state,
                settingsType = SettingsType.PRESSURE
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(Res.string.about_app),
            modifier = Modifier.padding(start = 10.dp),
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(6.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .background(color = Color.DarkGray, shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 10.dp, vertical = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().clickable {
                    onAction(SettingsScreenAction.OpenPrivacyPolicy)
                }
            ) {
                Text(
                    text = stringResource(Res.string.policy),
                    modifier = Modifier.weight(1f),
                    color = Color.White, fontSize = 16.sp
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    MaterialTheme {
        SettingsScreenScreen(
            state = SettingsScreenState(),
            onAction = {},
            onBackButtonClick = {},
            modifier = Modifier
        )
    }
}