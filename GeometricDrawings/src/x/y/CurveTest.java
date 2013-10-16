package x.y;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import curves.Curve;
import curves.CurveAttributes;
import displaywindow.Drawer;
import displaywindow.SurfacePoint;
import drawings.Drawing;

public class CurveTest extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

		for (float i = -20;  i <= 20; i = i+1f) {

			if(i != 0) {
				float x = (float) i;
				float y = (float) 1/x;

				Log.d("Curve test", x+" | "+y);
				points.add(new SurfacePoint(x,y));
			}
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