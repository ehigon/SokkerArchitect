package com.estivy.sokkerarchitect.ui.screens.composables.graph

import android.graphics.Paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance

class YPointingLinesDrawer(val yValues: List<Int>, val graphAppearance: GraphAppearance) :
    Drawer() {

    override fun DrawScope.drawYourself(xAxisSpace: Float, yAxisSpace: Float, textPaint: Paint) {
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
                color = graphAppearance.pointingLineColor,
                strokeWidth = 7f,
                cap = StrokeCap.Round
            )
        }
    }
}