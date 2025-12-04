package com.estivy.sokkerarchitect.ui.screens.composables.graph

import android.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

class YAxisPointNumbersDrawer(val yValues: List<Int>, val paddingSpace: Int) : Drawer() {
    override fun DrawScope.drawYourself(
        xAxisSpace: Float,
        yAxisSpace: Float,
        textPaint: Paint
    ) {
        for (i in yValues.indices) {
            drawContext.canvas.nativeCanvas.drawText(
                "${yValues[i]}",
                paddingSpace.dp.toPx() / 2f,
                size.height - yAxisSpace * (i + 1),
                textPaint
            )
        }
    }
}