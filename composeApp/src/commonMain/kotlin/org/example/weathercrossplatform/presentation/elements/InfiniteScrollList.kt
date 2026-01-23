package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfiniteScrollList() {
    val list1 by remember {
        mutableStateOf(
            listOf(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24
            )
        )
    }
    val list2 by remember {
        mutableStateOf(
            listOf(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24
            )
        )
    }
    val finalList = remember {
        mutableStateListOf(list1, list2)
    }
    val uiList = remember {
        mutableStateListOf<List<Int>>(emptyList())
    }
    LaunchedEffect(Unit) {
        uiList.addAll(finalList)
    }
    val state = rememberLazyListState()

    LaunchedEffect(state) {
        println("checking uiList size: ${uiList.size}")

        snapshotFlow { state.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collect { lastVisibleItem ->
                val totalItems = state.layoutInfo.totalItemsCount
                if (lastVisibleItem == totalItems - 1) {
                    println("checking inside of if")
                    finalList.removeAt(0)
                    finalList.add(list1)
                    //uiList.clear()
                    uiList.addAll(finalList)
                    uiList.removeAt(0)
                    uiList.removeAt(0)
                    println("checking uiList size: ${uiList.size}")
                }
            }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier.height(300.dp),
            state = state,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiList.isNotEmpty()) {
                items(uiList.flatten()) { number ->
                    Text(text = "$number", color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun InfiniteNumberPicker(
    range: IntRange,
    itemHeight: Dp,
    visibleItems: Int,
    modifier: Modifier = Modifier,
    onValueChange: (Int) -> Unit = {}
) {
    val values = remember(range) { range.toList() }
    val count = 100//Int.MAX_VALUE
    val middle = count / 2
    val startIndex = remember { middle - middle % values.size }

    val state = rememberLazyListState(startIndex)
    val fling = rememberSnapFlingBehavior(lazyListState = state)

    val containerHeight = remember(itemHeight, visibleItems) { itemHeight * visibleItems }
    val sidePadding = remember(containerHeight, itemHeight) { (containerHeight - itemHeight) / 2 }

    // Текущий выбранный элемент по центру
    val selected by remember {
        derivedStateOf {
            val i = state.firstVisibleItemIndex
            val offset = state.firstVisibleItemScrollOffset
            // приблизительная коррекция до ближайшего элемента
            val approxIndex = if (itemHeight.value == 0f) i else {
                val pxPerItem = 1f // не знаем px, но snapping держит по элементам; достаточно i
                i + if (offset > 0) 0 else 0
            }
            values[(approxIndex % values.size + values.size) % values.size]
        }
    }

    LaunchedEffect(selected) { onValueChange(selected) }

    Box(
        modifier = modifier
            .height(containerHeight)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            state = state,
            flingBehavior = fling,
            contentPadding = PaddingValues(vertical = sidePadding),
            modifier = Modifier.fillMaxSize()
        ) {
            items(count) { index ->
                val value = values[index % values.size]
                PickerItem(
                    text = value.toString(),
                    height = itemHeight,
                    isSelected = value == selected
                )
            }
        }

        // Центральная подсветка/линиии
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(itemHeight)
                .background(Color(0x112196F3))
        )
    }
}

@Composable
private fun PickerItem(
    text: String,
    height: Dp,
    isSelected: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = if (isSelected) 24.sp else 20.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.alpha(if (isSelected) 1f else 0.6f)
        )
    }
}

@Preview
@Composable
private fun InfiniteScrollListPreview() {
    InfiniteScrollList()
}
