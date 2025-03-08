package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.display.window.SurfaceAttributes;
import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.display.window.SurfaceRenderer;
import com.ai.engg.curves.models.Drawing;

import java.util.ArrayList;

public class ABox extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        ArrayList<Point> points1 = new ArrayList<Point>();
        points1.add(new Point(-2 * 2, 1));
        points1.add(new Point(2 * 2, 1));
        points1.add(new Point(2 * 2, -3));
        points1.add(new Point(-2 * 2, -3));
        points1.add(new Point(-2 * 2, 1));

        points1.add(new Point(-1 * 2, 3));
        points1.add(new Point(3 * 2, 3));
        points1.add(new Point(2 * 2, 1));
        points1.add(new Point(2 * 2, -3));
        points1.add(new Point(3 * 2, -1));
        points1.add(new Point(3 * 2, 3));
        points1.add(new Point(3 * 2, -1));
        points1.add(new Point(2 * 2, -3));
        points1.add(new Point(-2 * 2, -3));
        points1.add(new Point(-1 * 2, -1));
        points1.add(new Point(-1 * 2, 3));
        points1.add(new Point(-1 * 2, -1));
        points1.add(new Point(3 * 2, -1));

        CurveAttributes pathAttributes1 = new CurveAttributes();
        Curve path1 = new Curve(points1, pathAttributes1);

        ArrayList<Point> points2 = new ArrayList<Point>();
        CurveAttributes pathAttributes2 = new CurveAttributes();
        pathAttributes2.setPathColor("#FF0000");
        points2.add(new Point(3 * 2, -1));
        points2.add(new Point(-2 * 2, 1));
        Curve path2 = new Curve(points2, pathAttributes2);

        ArrayList<Point> points3 = new ArrayList<Point>();
		/*PathAttributes pathAttributes2 = new PathAttributes();
		pathAttributes2.setPathColor("#FF0000");*/
        points3.add(new Point(-2 * 2, -3));
        points3.add(new Point(3 * 2, 3));
        Curve path3 = new Curve(points3, pathAttributes2);

        ArrayList<Point> points4 = new ArrayList<Point>();
		/*PathAttributes pathAttributes2 = new PathAttributes();
		pathAttributes2.setPathColor("#FF0000");*/
        points4.add(new Point(-1 * 2, 3));
        points4.add(new Point(2 * 2, -3));
        Curve path4 = new Curve(points4, pathAttributes2);

        ArrayList<Point> points5 = new ArrayList<Point>();
		/*PathAttributes pathAttributes2 = new PathAttributes();
		pathAttributes2.setPathColor("#FF0000");*/
        points5.add(new Point(-1 * 2, -1));
        points5.add(new Point(2 * 2, 1));
        Curve path5 = new Curve(points5, pathAttributes2);

        ArrayList<Curve> paths = new ArrayList<Curve>();
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        paths.add(path4);
        paths.add(path5);
        //paths.add(path2);

        SurfaceAttributes surfaceAttributes = new SurfaceAttributes();

        Drawing drawing = new Drawing();
        drawing.setCurves(paths);

        setContentView(new SurfaceRenderer(this, drawing, surfaceAttributes));
    }
}