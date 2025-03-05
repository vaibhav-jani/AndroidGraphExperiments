package com.ai.engg.curves.drawings.boxes.piramid;

import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.boxes.filledboxes.FilledBox;

public class FilledPyramid extends FilledBox {

    public static final int TOP = 0;
    public static final int BOTTOM = 1;

    int direction = TOP;

    public FilledPyramid(float len, float wid, float dep, float start_x, float start_y, int direction) {
        super(len, wid, dep, start_x, start_y);
        this.direction = direction;
        draw(direction);
    }

    @Override
    protected void draw() {
    }

    @Override
    protected void fillTop() {
    }

    @Override
    protected void fillFront() {
    }

    @Override
    protected void fillSide() {
    }

    protected void fillTop(int direction) {

        if (direction == TOP) {

        } else {
            super.fillTop();
        }
    }

    protected void fillFront(int direction) {

        if (direction == TOP) {
            float start = bl.x + 2;
            float end = br.x;
            float count = Math.abs((start - end) / 2);

            for (float i = 0; i <= count; i++) {
                curves.add(getColorLine(new SurfacePoint(getTopCenter().x, getTopCenter().y), new SurfacePoint(bl.x + (2 * i), bl.y), frontColor));
            }
        } else {
            float start = tl.x + 2;
            float end = tr.x;
            float count = Math.abs((start - end) / 2);

            for (float i = 0; i <= count; i++) {
                curves.add(getColorLine(new SurfacePoint(getBottomCenter().x, getBottomCenter().y), new SurfacePoint(tl.x + (2 * i), tl.y), frontColor));
            }
        }
    }

    protected void fillSide(int direction) {

        if (direction == TOP) {
            float start = br.x + 2;
            float end = brr.x;
            float count = Math.abs((start - end) / 2);
            for (float i = 0; i <= count; i++) {
                curves.add(getColorLine(new SurfacePoint(getTopCenter().x, getTopCenter().y), new SurfacePoint(br.x + (2 * i), br.y + (2 * i)), sideColor));
            }
        } else {
            float start = tr.x + 2;
            float end = trr.x;
            float count = Math.abs((start - end) / 2);
            for (float i = 0; i <= count; i++) {
                curves.add(getColorLine(new SurfacePoint(getBottomCenter().x, getBottomCenter().y), new SurfacePoint(tr.x + (2 * i), tr.y + (2 * i)), sideColor));
            }
        }
    }

    protected void draw(int direction) {
        if (direction == TOP) {
            SurfacePoint topCenter = getTopCenter();
            tl = topCenter;
            tlr = topCenter;
            tr = topCenter;
            trr = topCenter;
        } else if (direction == BOTTOM) {
            SurfacePoint bottomCenter = getBottomCenter();
            bl = bottomCenter;
            blr = bottomCenter;
            br = bottomCenter;
            brr = bottomCenter;
        }

        fillFront(direction);
        fillTop(direction);
        fillSide(direction);

        super.draw();
    }
}
