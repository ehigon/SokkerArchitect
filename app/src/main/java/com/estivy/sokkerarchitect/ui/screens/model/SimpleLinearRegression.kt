package com.estivy.sokkerarchitect.ui.screens.model

class SimpleLinearRegression(points: List<GraphPoint>) {

    var n = points.size
    var b1 = (sumXY(points) - (sumX(points) * sumY(points) / n)) /
            (sumXX(points) - (sumX(points) * sumX(points) / n))
    var b0 = (sumY(points) / n) - b1 * (sumX(points) / n)

    fun calculateY(x:Float):Float{
        return (b1 * x) + b0
    }

    private fun sumXY(points: List<GraphPoint>): Float {
        var sum = 0
        for (i in 0 until points.size) {
            sum += (points[i].week) * points[i].value
        }
        return sum.toFloat()
    }

    private fun sumX(points: List<GraphPoint>): Float {
        var sum = 0
        for (i in 0 until points.size) {
            sum += (points[i].week)
        }
        return sum.toFloat()
    }

    private fun sumY(points: List<GraphPoint>): Float {
        var sum = 0
        for (i in 0 until points.size) {
            sum += points[i].value
        }
        return sum.toFloat()
    }

    private fun sumXX(points: List<GraphPoint>): Float {
        var sum = 0
        for (i in 0 until points.size) {
            sum += (points[i].week) * (points[i].week)
        }
        return sum.toFloat()
    }

}