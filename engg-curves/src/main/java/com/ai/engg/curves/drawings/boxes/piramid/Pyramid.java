package com.ai.engg.curves.drawings.boxes.piramid;

import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.drawings.boxes.Box;

public class Pyramid extends Box {

    public static final int TOP = 0;
    public static final int BOTTOM = 1;

    int direction = TOP;

    public Pyramid(float len, float wid, float dep, float start_x, float start_y, int direction) {
        super(len, wid, dep, start_x, start_y);
        this.direction = direction;
        draw(direction);
    }

    @Override
    protected void draw() {
    }

    protected void draw(int direction) {
        if (direction == TOP) {
            Point topCenter = getTopCenter();
            tl = topCenter;
            tlr = topCenter;
            tr = topCenter;
            trr = topCenter;
        } else if (direction == BOTTOM) {
            Point bottomCenter = getBottomCenter();
            bl = bottomCenter;
            blr = bottomCenter;
            br = bottomCenter;
            brr = bottomCenter;
        }
        super.draw();
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        curves.clear();
        draw(direction);
    }
}
