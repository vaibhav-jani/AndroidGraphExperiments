package drawings.trigmometric;

import java.util.ArrayList;
import curves.Curve;
import curves.CurveAttributes;
import displaywindow.SurfacePoint;
import drawings.Drawing;

public class TanCurve extends Drawing{

	private String color = "#0000FF";

	public TanCurve(float start, float end) {

		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

		for(float i = start; i < end; i = i + 0.1f) {
			points.add(new SurfacePoint(i, (float)Math.tan(i)));
		}

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);

		curves.add(new Curve(points, defAttribs));
	}
}
