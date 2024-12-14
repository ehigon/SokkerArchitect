package com.estivy.sokkerarchitect.ui.screens.composables

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint


@Composable
fun Graph(
    modifier: Modifier,
    yValues: List<Int>,
    points: List<GraphPoint>,
    paddingSpace: Dp,
    verticalStep: Int,
    graphAppearance: GraphAppearance
) {
    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            color = graphAppearance.graphAxisColor.toArgb()
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Box(
        modifier = modifier
            .background(graphAppearance.backgroundColor)
            .padding(horizontal = 8.dp, vertical = 12.dp),
        contentAlignment = Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize(),
        ) {
            val xAxisSpace = (size.width - paddingSpace.toPx()) / points.size
            val yAxisSpace = size.height / yValues.size
            drawBars(points, xAxisSpace)
            placeXAxisPoints(points.size, xAxisSpace, textPaint)
            placeYAxisPoints(yValues, paddingSpace, yAxisSpace, textPaint)
            drawLines(points, xAxisSpace, yAxisSpace, verticalStep, graphAppearance)
        }
    }
}


private fun DrawScope.placeXAxisPoints(
    points: Int,
    xAxisSpace: Float,
    textPaint: Paint
) {
    for (i in 0 until points) {
        drawContext.canvas.nativeCanvas.drawText(
            "${i + 1}",
            (xAxisSpace * (i + 1)) - (xAxisSpace / points),
            size.height - 30,
            textPaint
        )
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

private fun DrawScope.drawBars(
    points: List<GraphPoint>,
    xAxisSpace: Float
) {
    val padding = xAxisSpace * 0.2f
    for (i in 0 until points.size) {
        val x = (xAxisSpace * (i + 1)) - (xAxisSpace / points.size) - (xAxisSpace / 2) + (padding/2)
        val y = size.height * (1-points[i].bar)
        drawRect(
            color = points[i].color,
            topLeft = Offset(x = x, y = y),
            size = Size(height = size.height * points[i].bar, width = xAxisSpace - padding)
        )
    }
}

private fun DrawScope.drawLines(
    points: List<GraphPoint>,
    xAxisSpace: Float,
    yAxisSpace: Float,
    verticalStep: Int,
    graphAppearance: GraphAppearance
) {
    for (i in 0 until points.size - 1) {
        val x1 = (xAxisSpace * (i + 1)) - (xAxisSpace / points.size)
        val y1 = size.height - (yAxisSpace * (points[i].value / verticalStep.toFloat()))
        val x2 = (xAxisSpace * (i + 2)) - (xAxisSpace / points.size)
        val y2 = size.height - (yAxisSpace * (points[i + 1].value / verticalStep.toFloat()))
        drawLine(
            start = Offset(x = x1, y = y1),
            end = Offset(x = x2, y = y2),
            color = graphAppearance.lineColor,
            strokeWidth = 7f
        )
    }
}

@Preview
@Composable
fun GraphPreview() {
    val yStep = 1
    val points = listOf(
        GraphPoint(value = 12, bar = 0.8f, color = Color.Green),
        GraphPoint(value = 13, bar = 0.9f, color = Color.Green),
        GraphPoint(value = 13, bar = 1f, color = Color.Green),
        GraphPoint(value = 13, bar = 0.8f, color = Color.Green),
        GraphPoint(value = 13, bar = 0.8f, color = Color.Green),
        GraphPoint(value = 13, bar = 0.8f, color = Color.Green),
        GraphPoint(value = 14, bar = 0.95f, color = Color.Red),
        GraphPoint(value = 14, bar = 0.8f, color = Color.Green),
        GraphPoint(value = 14, bar = 0.8f, color = Color.Green),
        GraphPoint(value = 14, bar = 0.8f, color = Color.Green),
        GraphPoint(value = 15, bar = 0.8f, color = Color.Green),
        GraphPoint(value = 15, bar = 0.8f, color = Color.Green)
    )
    Graph(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        yValues = (0..17).map { (it + 1) * yStep },
        points = points,
        paddingSpace = 16.dp,
        verticalStep = yStep,
        graphAppearance = GraphAppearance(
            graphAxisColor = Color.Black,
            backgroundColor = Color.White
        )
    )
}
