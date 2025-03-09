package com.ai.engg.curves.display.window.compose

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.ai.engg.curves.display.window.MathCurveView
import com.ai.engg.curves.display.window.SurfaceAttributes
import com.ai.engg.curves.models.Drawing

// TODO Temporary work around
@Composable
fun MathCurveViewComposable(
    drawing: Drawing,
    surfaceAttributes: SurfaceAttributes,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            val activity = context as? Activity
            MathCurveView(activity, drawing, surfaceAttributes)
        },
        modifier = modifier
    )
}