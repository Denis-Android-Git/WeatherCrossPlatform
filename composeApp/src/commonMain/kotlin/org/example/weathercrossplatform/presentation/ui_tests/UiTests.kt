package org.example.weathercrossplatform.presentation.ui_tests

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun UiTestsRoot(
    viewModel: UiTestsViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    UiTestsScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiTestsScreen(
    state: UiTestsState,
    onAction: (UiTestsAction) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val listState = scrollBehavior.state
    val appBarExpanded by remember {
        derivedStateOf { listState.overlappedFraction > 0.5f}
    }

    val animatedAlpha by animateFloatAsState(
        if (appBarExpanded) 0f else 1f,
        animationSpec = tween(durationMillis = 900)
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    AnimatedVisibility(
                        visible = appBarExpanded,
                        enter = fadeIn(tween(durationMillis = 900)),
                        exit = fadeOut(tween(durationMillis = 900))
                    ) {
                        Text("Hello, world!")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .fillMaxSize()
                .padding(padding)
        ) {
            item {
                Text(
                    text = "Hello, world!",
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .height(80.dp)
                        .alpha(animatedAlpha)
                )
            }

            item {
                Text("Ui Tests", modifier = Modifier.height(200.dp))
                Text("Ui Tests", modifier = Modifier.height(200.dp))
                Text("Ui Tests", modifier = Modifier.height(200.dp))
            }

            items(10) { item ->
                Text(
                    text = "Item $item",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun UiTestsScreenPreview() {
    UiTestsScreen(
        state = UiTestsState(),
        onAction = {}
    )
}