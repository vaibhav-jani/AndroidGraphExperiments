package com.ai.engg.curves.drawings.globe;

import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.conic.sections.Ellipse;

public class Globe extends Drawing {

    public Globe(int x0, int y0, int radius) {

        for (int i = radius; i > 0; i--) {
            Ellipse ellipse = new Ellipse(x0, y0, radius, radius - i, Ellipse.X);
            curves.add(ellipse.getCurve());
        }

        for (int i = radius; i > 0; i--) {

            if ((x0 < 0 && y0 > 0) || (x0 > 0 && y0 < 0)) {
                if (Math.abs(x0) == Math.abs(y0)) {
                    Ellipse ellipse = new Ellipse(-x0, -y0, radius, radius - i, Ellipse.Y);
                    curves.add(ellipse.getCurve());
                } else {
                    Ellipse ellipse = new Ellipse(y0, x0, radius, radius - i, Ellipse.Y);
                    curves.add(ellipse.getCurve());
                }
            } else {

                if (x0 == y0) {
                    Ellipse ellipse = new Ellipse(x0, y0, radius, radius - i, Ellipse.Y);
                    curves.add(ellipse.getCurve());
                } else {
                    Ellipse ellipse = new Ellipse(y0, x0, radius, radius - i, Ellipse.Y);
                    curves.add(ellipse.getCurve());
                }
            }
        }

        Ellipse ellipse = new Ellipse(x0, y0, radius, radius, Ellipse.X);
        curves.add(ellipse.getCurve());

        for (int i = radius; i > 0; i--) {
            Ellipse ellipse1 = new Ellipse(x0, y0 - i, radius - i, radius - i, Ellipse.X);
            curves.add(ellipse1.getCurve());
        }

        for (int i = radius; i > 0; i--) {
            Ellipse ellipse1 = new Ellipse(x0, y0 + i, radius - i, radius - i, Ellipse.X);
            curves.add(ellipse1.getCurve());
        }
    }
}
