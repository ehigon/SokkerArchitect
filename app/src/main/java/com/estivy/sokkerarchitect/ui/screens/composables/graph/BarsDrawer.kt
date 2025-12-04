package com.estivy.sokkerarchitect.ui.screens.composables.graph

import android.graphics.Paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint

class BarsDrawer (private val points: List<GraphPoint>) : Drawer() {

    override fun DrawScope.drawYourself(xAxisSpace: Float, yAxisSpace: Float, textPaint: Paint) {
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


}