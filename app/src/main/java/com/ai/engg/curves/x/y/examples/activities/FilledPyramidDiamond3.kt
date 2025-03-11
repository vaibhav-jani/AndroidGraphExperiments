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
import com.ai.engg.curves.x.y.examples.drawings.filledPyramidDiamond3

class FilledPyramidDiamond3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContent {
            GlobeExample()
        }
    }
}

@Composable
private fun GlobeExample() {
    val drawings = filledPyramidDiamond3()
    val surfaceAttributes = SurfaceAttributes()
    MathCurveViewComposable(
        drawings = drawings,
        surfaceAttributes = surfaceAttributes,
        modifier = Modifier.fillMaxSize()
    )
}


