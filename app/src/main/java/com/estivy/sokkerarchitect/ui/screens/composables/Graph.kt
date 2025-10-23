package com.estivy.sokkerarchitect.ui.screens.composables

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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
    points: List<GraphPoint>,
    graphAppearance: GraphAppearance,
    listener: (Int) -> Unit,
    linearRegression: SimpleLinearRegression? = null
) {
    val verticalStep = 1
    val yValues = (-1..17).map { (it + 1) * verticalStep }
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
                    placeYAxisPoints(yValues, paddingSpace.dp, yAxisSpace, textPaint)
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
                            drawBars(points, xAxisSpace, yAxisSpace)
                            placeXAxisPoints(points, xAxisSpace, textPaint)
                            drawYPointingLines(
                                yValues,
                                yAxisSpace,
                                graphAppearance.pointingLineColor
                            )
                            drawLines(
                                points,
                                xAxisSpace,
                                yAxisSpace,
                                verticalStep,
                                graphAppearance.lineColor
                            )
                            drawPoints(
                                points,
                                xAxisSpace,
                                yAxisSpace,
                                verticalStep,
                                graphAppearance.lineColor,
                            )
                            if (linearRegression != null && points.size > 2) {
                                drawLinearRegression(
                                    linearRegression,
                                    xAxisSpace,
                                    yAxisSpace,
                                    verticalStep,
                                    graphAppearance.trendLineColor,
                                    points.size
                                )
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

private fun DrawScope.placeYAxisPoints(
    yValues: List<Int>,
    paddingSpace: Dp,
    yAxisSpace: Float,
    textPaint: Paint
) {
    for (i in yValues.indices) {
        drawContext.canvas.nativeCanvas.drawText(
            "${yValues[i]}",
            paddingSpace.toPx() / 2f,
            size.height - yAxisSpace * (i + 1),
            textPaint
        )
    }
}

private fun DrawScope.drawYPointingLines(
    yValues: List<Int>,
    yAxisSpace: Float,
    pointingLineColor: Color
) {
    val dotPadding = yAxisSpace / 4
    for (i in yValues.indices) {
        var j = 0.0F
        val points: MutableList<Offset> = mutableListOf()
        while (j < size.width) {
            points.add(Offset(x = j, y = size.height - yAxisSpace * (i + 1)))
            j += dotPadding
        }
        drawPoints(
            points = points,
            pointMode = PointMode.Points,
            color = pointingLineColor,
            strokeWidth = 7f,
            cap = StrokeCap.Round
        )
    }
}

private fun DrawScope.placeXAxisPoints(
    points: List<GraphPoint>,
    xAxisSpace: Float,
    textPaint: Paint
) {
    val lastWeek = points.last().week
    for (i in points.indices) {
        drawContext.canvas.nativeCanvas.drawText(
            "${lastWeek - points[i].week}",
            (xAxisSpace / 2) + (xAxisSpace * (i)),
            size.height - 30,
            textPaint
        )
    }
}

private fun DrawScope.drawBars(
    points: List<GraphPoint>,
    xAxisSpace: Float,
    yAxisSpace: Float
) {
    val padding = xAxisSpace * 0.2f
    for (i in points.indices) {
        val x = (xAxisSpace / 2) + (xAxisSpace * (i)) - (xAxisSpace / 2) + (padding / 2)
        val y = (size.height - yAxisSpace) * (1 - points[i].bar)
        drawRect(
            color = points[i].color,
            topLeft = Offset(x = x, y = y),
            size = Size(
                height = ((size.height - yAxisSpace) * points[i].bar),
                width = xAxisSpace - padding
            )
        )
    }
}

private fun DrawScope.drawLines(
    points: List<GraphPoint>,
    xAxisSpace: Float,
    yAxisSpace: Float,
    verticalStep: Int,
    lineColor: Color
) {
    for (i in 0 until points.size - 1) {
        val x1 = (xAxisSpace / 2) + (xAxisSpace * (i))
        val y1 = size.height - (yAxisSpace * ((points[i].value + 1) / verticalStep.toFloat()))
        val x2 = (xAxisSpace / 2) + (xAxisSpace * (i + 1))
        val y2 = size.height - (yAxisSpace * ((points[i + 1].value + 1) / verticalStep.toFloat()))
        drawLine(
            start = Offset(x = x1, y = y1),
            end = Offset(x = x2, y = y2),
            color = lineColor,
            strokeWidth = 7f
        )
    }
}

private fun DrawScope.drawPoints(
    points: List<GraphPoint>,
    xAxisSpace: Float,
    yAxisSpace: Float,
    verticalStep: Int,
    lineColor: Color
) {
    val pointList: MutableList<Offset> = mutableListOf()
    for (i in 0 until points.size) {
        val x = (xAxisSpace / 2) + (xAxisSpace * (i))
        val y = size.height - (yAxisSpace * ((points[i].value + 1) / verticalStep.toFloat()))
        pointList.add(Offset(x = x, y = y))
    }
    drawPoints(
        points = pointList,
        pointMode = PointMode.Points,
        color = lineColor,
        strokeWidth = 20f,
        cap = StrokeCap.Round
    )
}

private fun DrawScope.drawLinearRegression(
    linearRegression: SimpleLinearRegression,
    xAxisSpace: Float,
    yAxisSpace: Float,
    verticalStep: Int,
    lineColor: Color,
    numPoints: Int
) {
    val firstY = linearRegression.calculateY(1F)
    val lastY = linearRegression.calculateY(numPoints.toFloat())
    val x1 = xAxisSpace / 2
    val y1 = size.height - (yAxisSpace * (firstY + 1 / verticalStep.toFloat()))
    val x2 = (xAxisSpace / 2) + (xAxisSpace * (numPoints - 1))
    val y2 = size.height - (yAxisSpace * (lastY + 1 / verticalStep.toFloat()))
    drawLine(
        start = Offset(x = x1, y = y1),
        end = Offset(x = x2, y = y2),
        color = lineColor,
        strokeWidth = 7f
    )
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
    Graph(
        points = points,
        graphAppearance = GraphAppearance(
            graphAxisColor = Color.Black,
            backgroundColor = Color.White,
        ),
        listener = {},
        linearRegression = SimpleLinearRegression(points)
    )
}
