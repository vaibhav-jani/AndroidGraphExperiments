package com.ai.engg.curves.display.window;

import android.app.Activity;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

public abstract class DrawingSurface extends View {

    //Paint to draw things
    protected Paint paint;
    //protected Canvas canvas;

    //Display size
    protected int display_height;
    protected int display_width;

    //Offset values
    protected float offset_top;
    protected float offset_bottom;
    protected float offset_left;
    protected float offset_right;

    //Coordinates of new calculated boundaries of drawing
    protected float xtl;
    protected float ytl;
    protected float xtr;
    protected float ytr;
    protected float xbl;
    protected float ybl;
    protected float xbr;
    protected float ybr;

    //Actual drawing size
    protected float drawing_height;
    protected float drawing_width;

    public DrawingSurface(Activity activity) {
        super(activity);

        //First determining height of the display
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        display_height = displaymetrics.heightPixels;
        display_width = displaymetrics.widthPixels;

        // Assuming Statusbar at bottom and it's height is 40, we need to reduce surface height
        display_height -= 40;

        //Now calculating Offset values to set padding from layout boundaries
        //Using 84% of total height and 80% of total width of remaining display
        offset_top = display_height * 0.08f;
        offset_bottom = display_height * 0.1f;
        offset_left = display_width * 0.1f;
        offset_right = display_width * 0.08f;

        //Calculating actual drawing size
        drawing_width = display_width - offset_right - offset_left;
        drawing_height = display_height - offset_top - offset_bottom;

        //Calculating drawing corners, tl : top-left, br : bottom-right ... and so on
        xtl = offset_left;
        ytl = offset_top;
        xtr = display_width - offset_right;
        ytr = offset_top;
        xbl = offset_left;
        ybl = display_height - offset_bottom;
        xbr = display_width - offset_right;
        ybr = display_height - offset_bottom;

        //Initialize Paint object
        paint = new Paint();
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
    }
}
