package com.ai.engg.curves.display.window;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;

import androidx.annotation.NonNull;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.models.Drawing;
import com.ai.engg.curves.models.Point;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ViewConstructor")
public class MathCurveView extends BaseSurface {

    private float no_of_x_positive_unit;
    private float no_of_y_positive_unit;

    private float no_of_x_negative_unit;
    private float no_of_y_negative_unit;

    private float x_unit_length;
    private float y_unit_length;

    private List<Drawing> drawings = new ArrayList<>();

    private final List<Curve> curvesCache = new ArrayList<>();

    private SurfaceAttributes surfaceAttributes = new SurfaceAttributes();

    public MathCurveView(Activity activity, List<Drawing> drawings, SurfaceAttributes surfaceAttributes) {
        super(activity);
        if (drawings != null) this.drawings = drawings;
        if (surfaceAttributes != null) this.surfaceAttributes = surfaceAttributes;
        if (drawings != null) {
            this.drawings = configurePaths(drawings);
        }
    }

    public MathCurveView(Activity activity, Drawing drawing, SurfaceAttributes surfaceAttributes) {
        super(activity);
        if (drawing != null) this.drawings.add(drawing);
        if (surfaceAttributes != null) this.surfaceAttributes = surfaceAttributes;
        configurePaths(drawings);
    }

    private List<Drawing> configurePaths(List<Drawing> drawings) {

        double minimum_x = 0;
        double maximum_x = 0;

        double minimum_y = 0;
        double maximum_y = 0;

        // Add empty drawings to avoid divide by zero.
        // For cases with empty drawings and all points on one of the axis;
        addEmptyDrawing(drawings);

        for (Drawing drawing : drawings) {
            for (Curve curve : drawing.getCurves()) {
                List<Point> points = curve.getPoints();
                for (Point point : points) {
                    if (point.x < minimum_x) minimum_x = point.x;
                    if (point.y < minimum_y) minimum_y = point.y;
                    if (point.x > maximum_x) maximum_x = point.x;
                    if (point.y > maximum_y) maximum_y = point.y;
                }
            }
        }

        no_of_x_negative_unit = (float) Math.abs(minimum_x);
        no_of_x_positive_unit = (float) Math.abs(maximum_x);

        no_of_y_negative_unit = (float) Math.abs(minimum_y);
        no_of_y_positive_unit = (float) Math.abs(maximum_y);

        float total_x_units = no_of_x_negative_unit + no_of_x_positive_unit;
        float total_y_units = no_of_y_negative_unit + no_of_y_positive_unit;

        if (total_x_units != 0) {
            x_unit_length = drawing_width / total_x_units;
        } else {
            x_unit_length = 0;
        }

        if (total_y_units != 0) {
            y_unit_length = drawing_height / total_y_units;
        } else {
            y_unit_length = 0;
        }

        for (Drawing drawing : drawings) {
            for (Curve curve : drawing.getCurves()) {
                ArrayList<Point> tPoints = new ArrayList<>();
                List<Point> points = curve.getPoints();

                for (Point point : points) {
                    Point tPoint = new Point(point.x, point.y);
                    tPoints.add(tPoint);
                }
                curve.setPoints(tPoints);
            }
        }


        float x_translate_factor = (no_of_x_negative_unit * x_unit_length) + offset_left;
        float y_translate_factor = display_height - (no_of_y_negative_unit * y_unit_length) - offset_bottom;

        for (Drawing drawing : drawings) {
            for (Curve curve : drawing.getCurves()) {
                List<Point> points = curve.getPoints();
                for (Point point : points) {
                    point.x = x_translate_factor + (point.x * x_unit_length);
                    point.y = y_translate_factor - (point.y * y_unit_length);
                }
                this.curvesCache.add(curve);
            }
        }

        return drawings;
    }

    private void addEmptyDrawing(List<Drawing> drawings) {
        ArrayList<Point> emptyPoints = new ArrayList<>();
        emptyPoints.add(new Point(-0.1f, -0.1f));
        emptyPoints.add(new Point(0.1f, 0.1f));

        ArrayList<Curve> paths = new ArrayList<>();
        CurveAttributes pathAttributes = new CurveAttributes();
        pathAttributes.setPathColor("#00ff0000");
        pathAttributes.setPointColor("#00ff0000");
        Curve empty = new Curve(emptyPoints, pathAttributes);
        paths.add(empty);

        Drawing emptyDrawing = new Drawing();
        emptyDrawing.setCurves(paths);
        drawings.add(emptyDrawing);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor(surfaceAttributes.getBackgroundColor()));
        if (surfaceAttributes.getBackground() != null)
            canvas.drawBitmap(surfaceAttributes.getBackground(), 0, 0, paint);
        //if(surfaceAttributes.isGridVisible()) drawGrid(canvas);
        if (surfaceAttributes.isGridVisible()) drawGridNew(canvas);
        if (surfaceAttributes.isAxisVisible()) drawAxis(canvas);
        drawAxisNames(canvas);
        drawCurves(canvas);
    }

    private void drawCurves(Canvas canvas) {

        for (Curve curve : curvesCache) {
            CurveAttributes attributes = curve.getAttributes();

            paint.setColor(Color.parseColor(attributes.getPathColor()));
            paint.setStrokeWidth(curve.getAttributes().getStrokeWidthOfPath());
            paint.setStyle(Paint.Style.STROKE);

            Path path = new Path();
            Point p1 = curve.getPoints().get(0);
            path.moveTo(p1.x, p1.y);
            for (Point point : curve.getPoints()) {
                path.quadTo(p1.x, p1.y, point.x, point.y);
                p1 = point;
            }
            canvas.drawPath(path, paint);

            if (attributes.isDrawPoints()) {
                drawPoints(curve.getPoints(), attributes, canvas);
            }
        }
    }

    private void drawAxisNames(Canvas canvas) {
        paint.setColor(Color.parseColor(surfaceAttributes.getAxisNameColor()));
        paint.setStrokeWidth(surfaceAttributes.getAxisStrokeWidth());

        Path curve = new Path();
        //RectF rect = new RectF(offset_left*0.33f, y_translate_factor+(lineChartAttributes.Y_unit_name.length()*5), offset_left*0.33f, y_translate_factor-(lineChartAttributes.Y_unit_name.length()*5));
        RectF rect = new RectF(xbl - offset_left * 0.50f, ybl, xtl - offset_left * 0.50f, ytl);
        curve.addRect(rect, Direction.CCW);
        canvas.drawTextOnPath(surfaceAttributes.getY_axis_name(), curve, 0, 0, paint);

        curve = new Path();
        //rect = new RectF(x_translate_factor-(lineChartAttributes.X_unit_name.length()*5), display_height-offset_bottom*0.33f, x_translate_factor+(lineChartAttributes.X_unit_name.length()*5), display_height-offset_bottom*0.33f);
        rect = new RectF(xbl, ybl + offset_bottom * 0.60f, xbr, ybr + offset_bottom * 0.60f);
        curve.addRect(rect, Direction.CW);
        canvas.drawTextOnPath(surfaceAttributes.getX_axis_name(), curve, 0, 0, paint);
    }

    private void drawPoints(List<Point> points, CurveAttributes attributes, Canvas canvas) {
        paint.setColor(Color.parseColor(attributes.getPointColor()));
        paint.setStyle(Paint.Style.STROKE);
        float pointRadius = attributes.getRadiusOfPoints();
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            canvas.drawCircle(point.x, point.y, pointRadius, paint);
        }
    }

    private void drawAxis(Canvas canvas) {

        paint.setColor(Color.parseColor(surfaceAttributes.getAxisColor()));
        paint.setStrokeWidth(surfaceAttributes.getAxisStrokeWidth());

        float x1_mid_top = xtl + (no_of_x_negative_unit * x_unit_length);
        float y1_mid_top = ytl;

        float x2_mid_bottom = xbl + (no_of_x_negative_unit * x_unit_length);
        float y2_mid_bottom = ybl;

        // y
        canvas.drawLine(x1_mid_top, y1_mid_top, x2_mid_bottom, y2_mid_bottom, paint);

        float x1_mid_left = xtl;
        float y1_mid_left = ytl + (no_of_y_positive_unit * y_unit_length);

        float x2_mid_right = xtr;
        float y2_mid_right = ytr + (no_of_y_positive_unit * y_unit_length);

        // x
        canvas.drawLine(x1_mid_left, y1_mid_left, x2_mid_right, y2_mid_right, paint);
    }

    private void drawGridNew(Canvas canvas) {

        float max_stroke_width = surfaceAttributes.getGridStrokeWidth();

        float total_x_units = no_of_x_negative_unit + no_of_x_positive_unit;
        float total_y_units = no_of_y_negative_unit + no_of_y_positive_unit;

        float gridStrokeWidth_x = 10 / (total_x_units);
        float gridStrokeWidth_y = 10 / (total_y_units);

        gridStrokeWidth_x = Math.min(gridStrokeWidth_x, max_stroke_width);
        gridStrokeWidth_y = Math.min(gridStrokeWidth_y, max_stroke_width);

        paint.setColor(Color.parseColor(surfaceAttributes.getGridColor()));

        float x1_mid_top = xtl + (no_of_x_negative_unit * x_unit_length);
        float y1_mid_top = ytl;

        float x2_mid_bottom = xbl + (no_of_x_negative_unit * x_unit_length);
        float y2_mid_bottom = ybl;

        // y
        paint.setStrokeWidth(gridStrokeWidth_x);
        for (int i = 0; i < no_of_x_positive_unit; i++) {
            float x1 = x1_mid_top + (i * x_unit_length);
            float x2 = x2_mid_bottom + (i * x_unit_length);
            canvas.drawLine(x1, y1_mid_top, x2, y2_mid_bottom, paint);
        }

        for (int i = 0; i < no_of_x_negative_unit; i++) {
            float x1 = x1_mid_top + (-i * x_unit_length);
            float x2 = x2_mid_bottom + (-i * x_unit_length);
            canvas.drawLine(x1, y1_mid_top, x2, y2_mid_bottom, paint);
        }

        float x1_mid_left = xtl;
        float y1_mid_left = ytl + (no_of_y_positive_unit * y_unit_length);

        float x2_mid_right = xtr;
        float y2_mid_right = ytr + (no_of_y_positive_unit * y_unit_length);

        // x
        paint.setStrokeWidth(gridStrokeWidth_y);
        for (int i = 0; i < no_of_y_positive_unit; i++) {
            float y1 = y1_mid_left + (-i * y_unit_length);
            float y2 = y2_mid_right + (-i * y_unit_length);
            canvas.drawLine(x1_mid_left, y1, x2_mid_right, y2, paint);
        }

        for (int i = 0; i < no_of_y_negative_unit; i++) {
            float y1 = y1_mid_left + (i * y_unit_length);
            float y2 = y2_mid_right + (i * y_unit_length);
            canvas.drawLine(x1_mid_left, y1, x2_mid_right, y2, paint);
        }

        canvas.drawLine(xtl, ytl, xbl, ybl, paint);
        canvas.drawLine(xbl, ybl, xbr, ybr, paint);
        canvas.drawLine(xbr, ybr, xtr, ytr, paint);
        canvas.drawLine(xtr, ytr, xtl, ytl, paint);
    }
}
