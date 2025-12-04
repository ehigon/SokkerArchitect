package com.estivy.sokkerarchitect.ui.screens.composables.graph

import android.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint

class XAxisPointNumbersDrawer(private val points: List<GraphPoint>) : Drawer() {

    override fun DrawScope.drawYourself(xAxisSpace: Float, yAxisSpace: Float, textPaint: Paint) {
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
}