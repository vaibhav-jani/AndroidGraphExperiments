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
import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.models.Drawing;

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

    private ArrayList<Drawing> drawings = new ArrayList<>();

    private final ArrayList<Curve> curvesCache = new ArrayList<>();

    private SurfaceAttributes surfaceAttributes = new SurfaceAttributes();

    public MathCurveView(Activity activity, ArrayList<Drawing> drawings, SurfaceAttributes surfaceAttributes) {
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

    private ArrayList<Drawing> configurePaths(ArrayList<Drawing> drawings) {

        double minimum_x = 0;
        double maximum_x = 0;

        double minimum_y = 0;
        double maximum_y = 0;

        // Add empty drawings to avoid divide by zero.
        // For cases with empty drawings and all points on one of the axis;
        addEmptyDrawing(drawings);

        for (Drawing drawing : drawings) {
            for (Curve curve : drawing.getCurves()) {
                ArrayList<Point> points = curve.getPoints();
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

        float x_translate_factor = (no_of_x_negative_unit * x_unit_length) + offset_left;
        float y_translate_factor = display_height - (no_of_y_negative_unit * y_unit_length) - offset_bottom;

        for (Drawing drawing : drawings) {
            for (Curve curve : drawing.getCurves()) {
                ArrayList<Point> tPoints = new ArrayList<>();
                ArrayList<Point> points = curve.getPoints();

                for (Point point : points) {
                    Point tPoint = new Point(point.x, point.y);
                    tPoints.add(tPoint);
                }
                curve.setPoints(tPoints);
            }
        }

        for (Drawing drawing : drawings) {
            for (Curve curve : drawing.getCurves()) {
                ArrayList<Point> points = curve.getPoints();
                for (Point point : points) {
                    point.x = x_translate_factor + (point.x * x_unit_length);
                    point.y = y_translate_factor - (point.y * y_unit_length);
                }
                this.curvesCache.add(curve);
            }
        }

        return drawings;
    }

    private void addEmptyDrawing(ArrayList<Drawing> drawings) {
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
        //y
        canvas.drawLine(xtl + (no_of_x_negative_unit * x_unit_length), ytl, xbl + (no_of_x_negative_unit * x_unit_length), ybl, paint);
        //x
        canvas.drawLine(xtl, ytl + (no_of_y_positive_unit * y_unit_length), xtr, ytr + (no_of_y_positive_unit * y_unit_length), paint);
    }

    private void drawGridNew(Canvas canvas) {

        paint.setColor(Color.parseColor(surfaceAttributes.getGridColor()));

        float max_stroke_width = surfaceAttributes.getGridStrokeWidth();

        float gridStrokeWidth_x = 10 / (no_of_x_negative_unit + no_of_x_positive_unit);
        float gridStrokeWidth_y = 10 / (no_of_y_negative_unit + no_of_y_positive_unit);

        gridStrokeWidth_x = Math.min(gridStrokeWidth_x, max_stroke_width);
        gridStrokeWidth_y = Math.min(gridStrokeWidth_y, max_stroke_width);

        paint.setStrokeWidth(gridStrokeWidth_x);
        for (int i = 1; i < (no_of_x_negative_unit + no_of_x_positive_unit); i++) {
            canvas.drawLine(xtl + (i * x_unit_length), ytl, xbl + (i * x_unit_length), ybl, paint);
        }

        paint.setStrokeWidth(gridStrokeWidth_y);
        for (int i = 1; i < (no_of_y_negative_unit + no_of_y_positive_unit); i++) {
            canvas.drawLine(xtl, ytl + (i * y_unit_length), xtr, ytr + (i * y_unit_length), paint);
        }

        canvas.drawLine(xtl, ytl, xbl, ybl, paint);
        canvas.drawLine(xbl, ybl, xbr, ybr, paint);
        canvas.drawLine(xbr, ybr, xtr, ytr, paint);
        canvas.drawLine(xtr, ytr, xtl, ytl, paint);
    }
}
