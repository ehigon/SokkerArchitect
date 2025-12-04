package com.estivy.sokkerarchitect.ui.screens.composables.graph

import android.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope

abstract class Drawer {

    private var parentDrawer: Drawer? = null

    fun setParent(drawer: Drawer) {
        parentDrawer = drawer;
    }

    fun DrawScope.draw(xAxisSpace: Float, yAxisSpace: Float, textPaint: Paint) {
        if (parentDrawer != null) {
            with(parentDrawer!!) {
                draw(xAxisSpace, yAxisSpace, textPaint)
            }
        }
        drawYourself(xAxisSpace, yAxisSpace, textPaint)
    }

    abstract fun DrawScope.drawYourself(xAxisSpace: Float, yAxisSpace: Float, textPaint: Paint)
}