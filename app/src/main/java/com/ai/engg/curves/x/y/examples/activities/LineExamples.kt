package com.ai.engg.curves.x.y.examples.activities

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ai.engg.curves.display.window.SurfaceAttributes
import com.ai.engg.curves.display.window.compose.MathCurveViewComposable
import com.ai.engg.curves.models.Drawing
import com.ai.engg.curves.x.y.examples.drawings.getLines
import com.ai.engg.curves.x.y.examples.drawings.getLinesAndCircles
import com.ai.engg.curves.x.y.examples.drawings.getLinesAndCirclesAndCurves

class LineExamples : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContent {
            Lines()
        }
    }
}

@Composable
private fun Lines() {
    val drawing = Drawing()
    // drawing.curves = getLines()
    // drawing.curves = getLinesAndCircles()
    drawing.curves = getLinesAndCirclesAndCurves()
    val surfaceAttributes = SurfaceAttributes()
    MathCurveViewComposable(
        drawing = drawing,
        surfaceAttributes = surfaceAttributes,
        modifier = Modifier.fillMaxSize()
    )
}