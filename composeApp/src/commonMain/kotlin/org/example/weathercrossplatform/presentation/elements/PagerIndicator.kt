package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.example.weathercrossplatform.presentation.image_vectors.LocationArrow

@Composable
fun MyPagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    visibleItems: Int = 5,
    dotSize: Dp = 8.dp,
    padding: Dp = 2.dp
) {
    val rowState = rememberLazyListState()
    LaunchedEffect(pagerState.currentPage) {
        val layoutInfo = rowState.layoutInfo
        val visibleItems = layoutInfo.visibleItemsInfo

        if (visibleItems.isNotEmpty()) {
            val viewportCenter = layoutInfo.viewportEndOffset / 2
            val itemSize = visibleItems.first().size
            val itemCenterOffset = viewportCenter - itemSize / 2

            rowState.animateScrollToItem(
                index = pagerState.currentPage,
                scrollOffset = -itemCenterOffset
            )
        }
    }

    LazyRow(
        modifier
            .width((dotSize + padding * 2) * visibleItems)
            .wrapContentHeight()
            .padding(vertical = 8.dp),
        state = rowState,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(pagerState.pageCount) { index ->
            val color = if (pagerState.currentPage == index) Color.White else Color.DarkGray
            if (index == 0) {
                Icon(
                    imageVector = LocationArrow,
                    contentDescription = null,
                    modifier = Modifier.size(10.dp),
                    tint = color
                )
            } else {
                Box(
                    modifier = Modifier
                        .padding(padding)
                        .clip(CircleShape)
                        .background(color)
                        .size(dotSize)
                )
            }
        }
    }
}

@Preview
@Composable
fun PagerIndicatorPreview() {
    MyPagerIndicator(
        pagerState = rememberPagerState(pageCount = { 10 })
    )
}