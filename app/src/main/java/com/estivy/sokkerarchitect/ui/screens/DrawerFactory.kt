package com.estivy.sokkerarchitect.ui.screens

import com.estivy.sokkerarchitect.ui.screens.composables.graph.BarsDrawer
import com.estivy.sokkerarchitect.ui.screens.composables.graph.Drawer
import com.estivy.sokkerarchitect.ui.screens.composables.graph.LinearRegressionDrawer
import com.estivy.sokkerarchitect.ui.screens.composables.graph.LinesDrawer
import com.estivy.sokkerarchitect.ui.screens.composables.graph.PointsDrawer
import com.estivy.sokkerarchitect.ui.screens.composables.graph.XAxisPointNumbersDrawer
import com.estivy.sokkerarchitect.ui.screens.composables.graph.YPointingLinesDrawer
import com.estivy.sokkerarchitect.ui.screens.model.GraphAppearance
import com.estivy.sokkerarchitect.ui.screens.model.GraphPoint
import com.estivy.sokkerarchitect.ui.screens.model.SimpleLinearRegression

fun createJuniorDrawer(
    points: List<GraphPoint>,
    yValues: List<Int>,
    graphAppearance: GraphAppearance,
    linearRegression: SimpleLinearRegression
): Drawer {
    var drawer: Drawer = BarsDrawer(points)
    drawer = addDrawer(XAxisPointNumbersDrawer(points), drawer)
    drawer = addDrawer(YPointingLinesDrawer(yValues, graphAppearance), drawer)
    drawer = addDrawer(LinesDrawer(points, graphAppearance), drawer)
    drawer = addDrawer(PointsDrawer(points, graphAppearance), drawer)
    if (points.size > 2) {
        drawer = addDrawer(LinearRegressionDrawer(linearRegression, points, graphAppearance), drawer)
    }
    return drawer
}

fun createSkillDrawer(
    points: List<GraphPoint>,
    yValues: List<Int>,
    graphAppearance: GraphAppearance
): Drawer {
    var drawer: Drawer = BarsDrawer(points)
    drawer = addDrawer(XAxisPointNumbersDrawer(points), drawer)
    drawer = addDrawer(YPointingLinesDrawer(yValues, graphAppearance), drawer)
    drawer = addDrawer(LinesDrawer(points, graphAppearance), drawer)
    drawer = addDrawer(PointsDrawer(points, graphAppearance), drawer)
    return drawer
}

fun addDrawer(childDrawer: Drawer, parentDrawer: Drawer) : Drawer {
    childDrawer.setParent(parentDrawer)
    return childDrawer
}