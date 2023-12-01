package com.sample.android.movie.ui.feed

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.sample.android.movie.R
import com.sample.android.movie.domain.model.FeedWrapper
import com.sample.android.movie.domain.model.Movie
import com.sample.android.movie.domain.model.SortType
import com.sample.android.movie.domain.model.TmdbItem
import com.sample.android.movie.ui.common.Dimens
import com.sample.android.movie.ui.common.TmdbTheme
import com.sample.android.movie.ui.paging.main.movie.*

@Composable
fun <T : TmdbItem> FeedCollectionList(
    navType: NavType,
    collection: List<FeedWrapper<T>>,
    onFeedClick: (TmdbItem) -> Unit
) {
    LazyColumn {

        itemsIndexed(collection) { index, feedCollection ->
            FeedCollection(
                feedCollection = feedCollection,
                navType = navType,
                onFeedClick = onFeedClick,
                index = index
            )
        }
    }
}

@Composable
private fun <T : TmdbItem> FeedCollection(
    feedCollection: FeedWrapper<T>,
    navType: NavType,
    onFeedClick: (TmdbItem) -> Unit,
    index: Int,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 36.dp)
                .padding(start = Dimens.PaddingNormal)
        ) {
            Text(
                text = stringResource(id = feedCollection.sortTypeResourceId),
                maxLines = 1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            Text(
                text = stringResource(R.string.more_item),
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable {
                        val activityClass = when (navType) {
                            NavType.MOVIES -> {
                                when (feedCollection.sortType) {
                                    SortType.TRENDING -> {
                                        TrendingMoviesActivity::class.java
                                    }

                                    SortType.MOST_POPULAR -> {
                                        PopularMoviesActivity::class.java
                                    }


                                    SortType.DISCOVER -> {
                                        DiscoverMoviesActivity::class.java
                                    }
                                }
                            }

                            else -> throw RuntimeException("Unknown item to start paging Activity")
                        }
                        val intent = Intent(context, activityClass)
                        context.startActivity(intent)
                    }
                    .padding(Dimens.PaddingNormal)
            )
        }
        Feeds(feedCollection.feeds, onFeedClick, index)
    }
}

@Composable
private fun <T : TmdbItem> Feeds(
    feeds: List<T>,
    onFeedClick: (TmdbItem) -> Unit,
    index: Int,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = Dimens.PaddingMicro, end = Dimens.PaddingMicro)
    ) {
        items(feeds) { feed ->
            TmdbItem(feed, onFeedClick, index)
        }
    }
}

@Composable
private fun <T : TmdbItem> TmdbItem(
    tmdbItem: T,
    onFeedClick: (TmdbItem) -> Unit,
    index: Int
) {
    val itemWidth: Dp
    val imageUrl: String?
    if (index % 3 == 0) {
        itemWidth = 220.dp
        imageUrl = tmdbItem.backdropUrl
    } else {
        itemWidth = 120.dp
        imageUrl = tmdbItem.posterUrl
    }
    Card(
        modifier = Modifier
            .padding(Dimens.PaddingSmall)
            .clickable(onClick = { onFeedClick(tmdbItem) }),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(width = itemWidth, height = 180.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = tmdbItem.name,
                fontSize = TmdbTheme.fontSizes.sp_11,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .size(width = itemWidth, height = 36.dp)
                    .wrapContentHeight()
            )
        }
    }
}

@Preview("default")
@Composable
fun FeedCardPreview() {
    TmdbTheme {
        val movie = Movie(1, "", null, null, null, "Movie", 1.0)
        TmdbItem(
            tmdbItem = movie,
            onFeedClick = {},
            0
        )
    }
}