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

public class FourBoxes extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);


		ArrayList<Curve> paths = new ArrayList<Curve>();
		//drawCubeOnPaths(paths, 64*3, 32*3, 24*3, 0, 0);
		drawCubeOnPaths(paths, 64*4, -32*4, -24*4, 0, 0);
		//drawCubeOnPaths(paths, 64*3, -32*3, 24*3, 0, 0);
		//drawCubeOnPaths(paths, 64*3, 32*3, -24*3, 0, 0);
		//drawCubeOnPaths(paths, 512, 256, 192, 0, 0);
		///drawCubeOnPaths(paths, 256, 128, 96, 0, 0);
		//drawCubeOnPaths(paths, 224, 112, 72, 0, 0);
		//drawCubeOnPaths(paths, 192, 96, 60, 0, 0);
		//drawCubeOnPaths(paths, 128, 64, 48, 0, 0);
		//drawCubeOnPaths(paths, 96, 48, 36, 0, 0);
		drawCubeOnPaths(paths, 64*1, 32*1, 24*1, 0, 0);
		//drawCubeOnPaths(paths, 64*2, -32*2, -24*2, 0, 0);
		drawCubeOnPaths(paths, 64*3, 32*3, -24*3, 0, 0);
		drawCubeOnPaths(paths, 64*2, -32*2, 24*2, 0, 0);
		//drawCubeOnPaths(paths, 64, -32, -24, 0, 0);
		//drawCubeOnPaths(paths, 64, -32, 24, 0, 0);
		//drawCubeOnPaths(paths, 64, 32, -24, 0, 0);
		//drawCubeOnPaths(paths, 32, 16, 12, 0, 0);
		//drawCubeOnPaths(paths, 16, 8, 6, 0, 0);
		//drawCubeOnPaths(paths, 8, 4, 2, 0, 0);
		SurfaceAttributes surfaceAttributes = new SurfaceAttributes();
		
		Drawing drawing = new Drawing();
		drawing.setCurves(paths);

		setContentView(new SurfaceRenderer(this, drawing, surfaceAttributes));
	}
	
	private void drawCubeOnPaths(ArrayList<Curve> paths, int len, int wid, int dep, int start_x, int start_y ){
		
		SurfacePoint p1 = new SurfacePoint(start_x, start_y);
		SurfacePoint p2 = new SurfacePoint(wid, start_y);
		SurfacePoint p3 = new SurfacePoint(wid, len);
		SurfacePoint p4 = new SurfacePoint(start_x, len);
		
		SurfacePoint p5 = new SurfacePoint(p1.x - dep, p1.y - dep);
		SurfacePoint p6 = new SurfacePoint(p2.x - dep, p2.y - dep);
		SurfacePoint p7 = new SurfacePoint(p3.x - dep, p3.y - dep);
		SurfacePoint p8 = new SurfacePoint(p4.x - dep, p4.y - dep);
		

		paths.add(getBlueLine(p1, p2));
		paths.add(getBlueLine(p2, p3));
		paths.add(getBlueLine(p3, p4));
		paths.add(getBlueLine(p4, p1));

		paths.add(getBlueLine(p5, p6));
		paths.add(getBlueLine(p6, p7));
		paths.add(getBlueLine(p7, p8));
		paths.add(getBlueLine(p8, p5));
		
		paths.add(getBlueLine(p1, p5));
		paths.add(getBlueLine(p2, p6));
		paths.add(getBlueLine(p3, p7));
		paths.add(getBlueLine(p4, p8));
		
	}
	
	Curve getBlueLine(SurfacePoint p1, SurfacePoint p2) {
		
		CurveAttributes defAttribs = new CurveAttributes();
		
		ArrayList<SurfacePoint> p1p2 = new ArrayList<SurfacePoint>();
		p1p2.add(p1);
		p1p2.add(p2);
		
		Curve line = new Curve(p1p2, defAttribs);
		return line;
	}
	
	Curve getRedLine(SurfacePoint p1, SurfacePoint p2) {
		
		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor("#FF0000");
		
		ArrayList<SurfacePoint> p1p2 = new ArrayList<SurfacePoint>();
		p1p2.add(p1);
		p1p2.add(p2);
		
		Curve line = new Curve(p1p2, defAttribs);
		return line;
	}
}