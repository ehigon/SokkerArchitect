package com.estivy.sokkerarchitect.ui.screens.composables.graph

import android.graphics.Paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint
import com.estivy.sokkerarchitect.ui.screens.model.SimpleLinearRegression

class LinearRegressionDrawer(
    val linearRegression: SimpleLinearRegression,
    val points: List<GraphPoint>,
    val graphAppearance: GraphAppearance
) : Drawer() {

    override fun DrawScope.drawYourself(xAxisSpace: Float, yAxisSpace: Float, textPaint: Paint) {
        for(i in 0 until points.size){
            val point = points[i]
            val firstY = linearRegression.calculateY(point.week.toFloat() - 0.5F)
            val lastY = linearRegression.calculateY(point.week.toFloat() + 0.5F)
            val x1 = (xAxisSpace * (i))
            val x2 = (xAxisSpace * (i+1))
            val y1 = size.height - (yAxisSpace * (firstY + 1))
            val y2 = size.height - (yAxisSpace * (lastY + 1))
            drawLine(
                start = Offset(x = x1, y = y1),
                end = Offset(x = x2, y = y2),
                color = graphAppearance.trendLineColor,
                strokeWidth = 7f
            )
        }
    }
}