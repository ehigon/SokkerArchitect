package com.estivy.sokkerarchitect.ui.screens.composables.graph

import android.graphics.Paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint

class LinesDrawer(val points:List<GraphPoint>, val graphAppearance: GraphAppearance) : Drawer() {

    override fun DrawScope.drawYourself(xAxisSpace: Float, yAxisSpace: Float, textPaint: Paint) {
        for (i in 0 until points.size - 1) {
            val x1 = (xAxisSpace / 2) + (xAxisSpace * (i))
            val y1 = size.height - (yAxisSpace * ((points[i].value + 1)))
            val x2 = (xAxisSpace / 2) + (xAxisSpace * (i + 1))
            val y2 = size.height - (yAxisSpace * ((points[i + 1].value + 1)))
            drawLine(
                start = Offset(x = x1, y = y1),
                end = Offset(x = x2, y = y2),
                color = graphAppearance.lineColor,
                strokeWidth = 7f
            )
        }
    }
}