package com.estivy.sokkerarchitect.ui.screens.composables.graph

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estivy.sokkerarchitect.R
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint
import com.estivy.sokkerarchitect.ui.screens.model.SimpleLinearRegression


private const val POINTS_IN_SCREEN = 10

private const val GRAPH_HEIGHT = 500

@Composable
fun Graph(
    drawer: Drawer,
    points: List<GraphPoint>,
    graphAppearance: GraphAppearance,
    listener: (Int) -> Unit,
    yValues: List<Int>
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val paddingSpace = 16
    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            color = graphAppearance.graphAxisColor.toArgb()
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }
    Column {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
        ) {
            Column {
                Canvas(
                    modifier = Modifier
                        .width(16.dp)
                        .height(GRAPH_HEIGHT.dp)
                ) {
                    val yAxisSpace = size.height / yValues.size
                    val yAxisPointNumbersDrawer = YAxisPointNumbersDrawer(yValues, paddingSpace)
                    with(yAxisPointNumbersDrawer) {
                        drawYourself(0f, yAxisSpace, textPaint)
                    }
                }
            }
            Column {
                val scrollState = rememberScrollState(Int.MAX_VALUE)
                Row(
                    modifier = Modifier.horizontalScroll(scrollState)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(GRAPH_HEIGHT.dp)
                            .width((((screenWidth - (paddingSpace)) / POINTS_IN_SCREEN) * points.size).dp)
                            .background(graphAppearance.backgroundColor)
                    ) {
                        Canvas(
                            modifier = Modifier
                                .fillMaxSize()
                                .pointerInput(Unit) {
                                    detectTapGestures(
                                        onTap = { tapOffset ->
                                            listener.invoke((tapOffset.x / (size.width / points.size)).toInt())
                                        }
                                    )
                                }
                        ) {
                            val xAxisSpace = size.width / points.size
                            val yAxisSpace = size.height / yValues.size
                            with(drawer) {
                                draw(xAxisSpace, yAxisSpace, textPaint)
                            }
                        }
                    }
                }
            }
        }
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(stringResource(R.string.weeks_ago))
        }
    }
}

@Preview
@Composable
fun GraphPreview() {
    val points = listOf(
        GraphPoint(value = 12, bar = 0.8f, color = Color.Green, week = 115),
        GraphPoint(value = 13, bar = 0.9f, color = Color.Green, week = 116),
        GraphPoint(value = 13, bar = 1f, color = Color.Green, week = 117),
        GraphPoint(value = 13, bar = 0.8f, color = Color.Green, week = 118),
        GraphPoint(value = 13, bar = 0.8f, color = Color.Green, week = 119),
        GraphPoint(value = 13, bar = 0.8f, color = Color.Green, week = 120),
        GraphPoint(value = 14, bar = 0.95f, color = Color.Red, week = 121),
        GraphPoint(value = 14, bar = 0.8f, color = Color.Green, week = 122),
        GraphPoint(value = 14, bar = 0.8f, color = Color.Green, week = 123),
        GraphPoint(value = 14, bar = 0.8f, color = Color.Green, week = 124),
        GraphPoint(value = 15, bar = 0.8f, color = Color.Green, week = 126),
        GraphPoint(value = 15, bar = 0.8f, color = Color.Green, week = 127),
        GraphPoint(value = 15, bar = 0.8f, color = Color.Green, week = 128)
    )
    val graphAppearance = GraphAppearance(
        graphAxisColor = Color.Black,
        backgroundColor = Color.White,
    )
    val yValues = (-1..17).map { (it + 1) }
    val barsDrawer = BarsDrawer(points)
    val xAxisPointNumbersDrawer = XAxisPointNumbersDrawer(points)
    xAxisPointNumbersDrawer.setParent(barsDrawer)
    val yPointingLinesDrawer =
        YPointingLinesDrawer(yValues, graphAppearance)
    yPointingLinesDrawer.setParent(xAxisPointNumbersDrawer)
    val linesDrawer = LinesDrawer(points, graphAppearance)
    linesDrawer.setParent(yPointingLinesDrawer)
    val pointsDrawer = PointsDrawer(points, graphAppearance)
    pointsDrawer.setParent(linesDrawer)
    val linearRegressionDrawer =
        LinearRegressionDrawer(SimpleLinearRegression(points), points, graphAppearance)
    linearRegressionDrawer.setParent(pointsDrawer)

    Graph(
        drawer = linearRegressionDrawer,
        points = points,
        graphAppearance = graphAppearance,
        listener = {},
        yValues
    )
}
