package com.ai.engg.curves.drawings.trigmometric;

import java.util.ArrayList;
import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;
import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

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
