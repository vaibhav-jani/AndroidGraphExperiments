package drawings.trigmometric;

import java.util.ArrayList;
import curves.Curve;
import curves.CurveAttributes;
import displaywindow.SurfacePoint;
import drawings.Drawing;

public class CosCurve extends Drawing{

	private String color = "#660000FF";

	public CosCurve(float start, float end) {

		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

		for(float i = start; i < end; i = i + 0.1f) {
			points.add(new SurfacePoint(i, (float)Math.cos(i)));
		}

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);

		curves.add(new Curve(points, defAttribs));
	}
}
