/**
 * Simple graph point
 */
package com.ai.engg.curves.display.window;

public class SurfacePoint {

    public float x;
    public float y;

    public SurfacePoint(float x, float y) {

        this.x = x;
        this.y = y;
    }

    public SurfacePoint(SurfacePoint p) {

        this.x = p.x;
        this.y = p.y;
    }
}
