package com.ai.engg.curves.drawings.boxes.piramid;

import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.drawings.boxes.filled.FilledBox;

public class FilledPyramid extends FilledBox {

    public static final int TOP = 0;
    public static final int BOTTOM = 1;

    int direction = TOP;

    public FilledPyramid(
            float len,
            float wid,
            float dep,
            float start_x,
            float start_y,
            int direction
    ) {
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
        if (direction != TOP) {
            super.fillTop();
        }
    }

    protected void fillFront(int direction) {

        if (direction == TOP) {
            float start = bl.x + 2;
            float end = br.x;
            float count = Math.abs((start - end) / 2);

            for (float i = 0; i <= count; i++) {
                Point topCenter = getTopCenter();
                Point p1 = new Point(topCenter.x, topCenter.y);
                Point p2 = new Point(bl.x + (2 * i), bl.y);
                curves.add(getColorLine(p1, p2, frontColor));
            }
        } else {
            float start = tl.x + 2;
            float end = tr.x;
            float count = Math.abs((start - end) / 2);

            for (float i = 0; i <= count; i++) {
                Point bottomCenter = getBottomCenter();
                Point p1 = new Point(bottomCenter.x, bottomCenter.y);
                Point p2 = new Point(tl.x + (2 * i), tl.y);
                curves.add(getColorLine(p1, p2, frontColor));
            }
        }
    }

    protected void fillSide(int direction) {

        if (direction == TOP) {
            float start = br.x + 2;
            float end = brr.x;
            float count = Math.abs((start - end) / 2);
            for (float i = 0; i <= count; i++) {
                Point topCenter = getTopCenter();
                Point p1 = new Point(topCenter.x, topCenter.y);
                Point p2 = new Point(br.x + (2 * i), br.y + (2 * i));
                curves.add(getColorLine(p1, p2, sideColor));
            }
        } else {
            float start = tr.x + 2;
            float end = trr.x;
            float count = Math.abs((start - end) / 2);
            for (float i = 0; i <= count; i++) {
                Point bottomCenter = getBottomCenter();
                Point p1 = new Point(bottomCenter.x, bottomCenter.y);
                Point p2 = new Point(tr.x + (2 * i), tr.y + (2 * i));
                curves.add(getColorLine(p1, p2, sideColor));
            }
        }
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

        fillFront(direction);
        fillTop(direction);
        fillSide(direction);

        super.draw();
    }

    @Override
    public void setFrontColor(String frontColor) {
        this.frontColor = frontColor;
        curves.clear();
        draw(direction);
    }

    @Override
    public void setSideColor(String sideColor) {
        this.sideColor = sideColor;
        curves.clear();
        draw(direction);
    }

    @Override
    public void setTopColor(String topColor) {
        this.topColor = topColor;
        curves.clear();
        draw(direction);
    }
}
