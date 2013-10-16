package x.y;

import java.util.ArrayList;

import curves.CurveAttributes;
import curves.Curve;

import displaywindow.SurfaceAttributes;
import displaywindow.SurfacePoint;
import displaywindow.SurfaceRenderer;
import drawings.Drawing;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class ABox extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		ArrayList<SurfacePoint> points1 = new ArrayList<SurfacePoint>();
		points1.add(new SurfacePoint(-2*2, 1*1));
		points1.add(new SurfacePoint(2*2, 1*1));
		points1.add(new SurfacePoint(2*2, -3*1));
		points1.add(new SurfacePoint(-2*2, -3*1));
		points1.add(new SurfacePoint(-2*2, 1*1));
		
		points1.add(new SurfacePoint(-1*2, 3*1));
		points1.add(new SurfacePoint(3*2, 3*1));
		points1.add(new SurfacePoint(2*2, 1*1));
		points1.add(new SurfacePoint(2*2, -3*1));
		points1.add(new SurfacePoint(3*2, -1*1));
		points1.add(new SurfacePoint(3*2, 3*1));
		points1.add(new SurfacePoint(3*2, -1*1));
		points1.add(new SurfacePoint(2*2, -3*1));
		points1.add(new SurfacePoint(-2*2, -3*1));
		points1.add(new SurfacePoint(-1*2, -1*1));
		points1.add(new SurfacePoint(-1*2, 3*1));
		points1.add(new SurfacePoint(-1*2, -1*1));
		points1.add(new SurfacePoint(3*2, -1*1));
						
		CurveAttributes pathAttributes1 = new CurveAttributes();
		Curve path1 = new Curve(points1, pathAttributes1);
		
		ArrayList<SurfacePoint> points2 = new ArrayList<SurfacePoint>();
		CurveAttributes pathAttributes2 = new CurveAttributes();
		pathAttributes2.setPathColor("#FF0000");
		points2.add(new SurfacePoint(3*2, -1*1));
		points2.add(new SurfacePoint(-2*2, 1*1));
		Curve path2 = new Curve(points2, pathAttributes2 );
		
		ArrayList<SurfacePoint> points3 = new ArrayList<SurfacePoint>();
		/*PathAttributes pathAttributes2 = new PathAttributes();
		pathAttributes2.setPathColor("#FF0000");*/
		points3.add(new SurfacePoint(-2*2, -3*1));
		points3.add(new SurfacePoint(3*2, 3*1));
		Curve path3 = new Curve(points3, pathAttributes2 );
		
		ArrayList<SurfacePoint> points4 = new ArrayList<SurfacePoint>();
		/*PathAttributes pathAttributes2 = new PathAttributes();
		pathAttributes2.setPathColor("#FF0000");*/
		points4.add(new SurfacePoint(-1*2, 3*1));
		points4.add(new SurfacePoint(2*2, -3*1));
		Curve path4 = new Curve(points4, pathAttributes2 );
		
		ArrayList<SurfacePoint> points5 = new ArrayList<SurfacePoint>();
		/*PathAttributes pathAttributes2 = new PathAttributes();
		pathAttributes2.setPathColor("#FF0000");*/
		points5.add(new SurfacePoint(-1*2, -1*1));
		points5.add(new SurfacePoint(2*2, 1*1));
		Curve path5 = new Curve(points5, pathAttributes2 );
		
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