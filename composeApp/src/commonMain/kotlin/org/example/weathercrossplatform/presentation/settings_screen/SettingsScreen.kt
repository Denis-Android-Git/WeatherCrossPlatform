package org.example.weathercrossplatform.presentation.settings_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.weathercrossplatform.presentation.elements.MyDropDownElement
import org.example.weathercrossplatform.presentation.elements.SettingsType
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.settings
import weathercrossplatform.composeapp.generated.resources.units

@Composable
fun SettingsScreenRoot(
    viewModel: SettingsScreenViewModel = koinViewModel(),
    onBackButtonClick: () -> Unit

) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SettingsScreenScreen(
        state = state,
        onAction = viewModel::onAction,
        onBackButtonClick = onBackButtonClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenScreen(
    state: SettingsScreenState,
    onAction: (SettingsScreenAction) -> Unit,
    onBackButtonClick: () -> Unit
) {
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = {
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackButtonClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxWidth().padding(padding).padding(horizontal = 8.dp)
        ) {
            Text(
                text = stringResource(Res.string.settings),
                modifier = Modifier.padding(start = 10.dp),
                color = Color.White, fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
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
            onBackButtonClick = {}
        )
    }
}