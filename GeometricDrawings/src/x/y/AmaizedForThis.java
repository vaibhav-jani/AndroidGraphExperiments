package x.y;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import curves.Curve;
import curves.CurveAttributes;
import displaywindow.Drawer;
import displaywindow.SurfacePoint;
import drawings.Drawing;

public class AmaizedForThis extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

		for(float i = 0; i < 360; i = i + 1f) {
			points.add(new SurfacePoint(5*((float)Math.cos(i)), 5*((float)Math.sin(i))));
		}

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setDrawPoints(true);

		Drawing drawing = new Drawing();
		drawing.addCurve(new Curve(points, defAttribs));
		
		ArrayList<Drawing> drawings = new ArrayList<Drawing>();
		drawings.add(drawing);
		
		Drawer drawer = new Drawer(drawings, null, this);
		drawer.draw();
	}
}