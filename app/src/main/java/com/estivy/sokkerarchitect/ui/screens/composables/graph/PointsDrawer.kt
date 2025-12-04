package com.estivy.sokkerarchitect.ui.screens.composables.graph

import android.graphics.Paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint

class PointsDrawer(val points:List<GraphPoint>, val graphAppearance: GraphAppearance) : Drawer() {

    override fun DrawScope.drawYourself(xAxisSpace: Float, yAxisSpace: Float, textPaint: Paint) {
        val pointList: MutableList<Offset> = mutableListOf()
        for (i in 0 until points.size) {
            val x = (xAxisSpace / 2) + (xAxisSpace * (i))
            val y = size.height - (yAxisSpace * ((points[i].value + 1)))
            pointList.add(Offset(x = x, y = y))
        }
        drawPoints(
            points = pointList,
            pointMode = PointMode.Points,
            color = graphAppearance.lineColor,
            strokeWidth = 20f,
            cap = StrokeCap.Round
        )
    }
}