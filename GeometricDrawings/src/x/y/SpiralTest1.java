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

public class SpiralTest1 extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

		float x0 = 0;
		float y0 = 0;
		float radius = 1;

		for(float i=0; i<=72; i= i+0.1f) {
			points.add(new SurfacePoint(x0+(radius*((float)Math.cos(i))), y0+(radius*((float)Math.sin(i)))));
			if(i < 36){
				radius = radius+0.075f;
				x0 = x0+0.15f;
				y0 = y0+0.15f;
			} else {
				radius = radius+0.075f;
				x0 = x0-0.15f;
				y0 = y0+0.15f;
			}
		}

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setDrawPoints(false);

		Drawing drawing = new Drawing();
		drawing.addCurve(new Curve(points, defAttribs));

		ArrayList<Drawing> drawings = new ArrayList<Drawing>();
		drawings.add(drawing);

		Drawer drawer = new Drawer(drawings, null, this);
		drawer.draw();
	}
}