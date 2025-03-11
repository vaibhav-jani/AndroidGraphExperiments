package com.ai.engg.curves.drawings.globe;

import com.ai.engg.curves.models.Drawing;
import com.ai.engg.curves.drawings.conic.sections.Ellipse;

public class Globe extends Drawing {

    private final float x0;
    private final float y0;
    private final float radius;

    // TODO: Bad Hack, fix it
    private String color = "#0000FF";

    public Globe(float x0, float y0, float radius) {
        this.x0 = x0;
        this.y0 = y0;
        this.radius = radius;

        draw();
    }

    private void draw() {
        for (float i = radius; i > 0; i--) {
            Ellipse ellipse = new Ellipse(x0, y0, radius, radius - i, Ellipse.X);
            ellipse.setColor(color);
            curves.add(ellipse.getCurve());
        }

        for (float i = radius; i > 0; i--) {
            if ((x0 < 0 && y0 > 0) || (x0 > 0 && y0 < 0)) {
                if (Math.abs(x0) == Math.abs(y0)) {
                    Ellipse ellipse = new Ellipse(-x0, -y0, radius, radius - i, Ellipse.Y);
                    ellipse.setColor(color);
                    curves.add(ellipse.getCurve());
                } else {
                    Ellipse ellipse = new Ellipse(y0, x0, radius, radius - i, Ellipse.Y);
                    ellipse.setColor(color);
                    curves.add(ellipse.getCurve());
                }
            } else {
                if (x0 == y0) {
                    Ellipse ellipse = new Ellipse(x0, y0, radius, radius - i, Ellipse.Y);
                    ellipse.setColor(color);
                    curves.add(ellipse.getCurve());
                } else {
                    Ellipse ellipse = new Ellipse(y0, x0, radius, radius - i, Ellipse.Y);
                    ellipse.setColor(color);
                    curves.add(ellipse.getCurve());
                }
            }
        }

        Ellipse ellipse = new Ellipse(x0, y0, radius, radius, Ellipse.X);
        ellipse.setColor(color);
        curves.add(ellipse.getCurve());

        for (float i = radius; i > 0; i--) {
            Ellipse ellipse1 = new Ellipse(x0, y0 - i, radius - i, radius - i, Ellipse.X);
            ellipse1.setColor(color);
            curves.add(ellipse1.getCurve());
        }

        for (float i = radius; i > 0; i--) {
            Ellipse ellipse1 = new Ellipse(x0, y0 + i, radius - i, radius - i, Ellipse.X);
            ellipse1.setColor(color);
            curves.add(ellipse1.getCurve());
        }
    }

    public void setColor(String color) {
        this.color = color;
        redraw();
    }

    private void redraw() {
        curves.clear();
        draw();
    }
}
