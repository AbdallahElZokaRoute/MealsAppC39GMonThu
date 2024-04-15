package com.route.mealsappc39gmonthu.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.route.mealsappc39gmonthu.R
import com.route.mealsappc39gmonthu.model.CategoryItem
import com.route.mealsappc39gmonthu.ui.theme.MealsAppC39GMonThuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealsAppC39GMonThuTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent(viewModel: MainViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchCategoriesList()
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(viewModel.categoriesList.size) { position ->
            MealCard(categoryItem = viewModel.categoriesList[position])
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MealCard(categoryItem: CategoryItem) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            val (image, title, description) = createRefs()
            GlideImage(
                model = categoryItem.strCategoryThumb,
                contentDescription = stringResource(R.string.category_meal_image),
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(title.start)
                    }
                    .size(80.dp),

                )
            Text(
                text = categoryItem.strCategory ?: "",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(image.end)
                    top.linkTo(image.top)
                    bottom.linkTo(description.top)
                }
            )
            // match_constraint     0dp
            Text(
                text = categoryItem.strCategoryDescription ?: "", fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.constrainAs(description) {
                    start.linkTo(title.start)
                    top.linkTo(title.bottom)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis

            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MealPreview() {
    MealCard(CategoryItem(1, "Beef Meal", "This is Description for meal hello hello hello"))
}

@Preview
@Composable
private fun MainPreview() {
    MainContent()
}
