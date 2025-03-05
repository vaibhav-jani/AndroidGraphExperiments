package com.ai.engg.curves.drawings.trigmometric;

import java.util.ArrayList;
import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;
import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

public class SinCurve extends Drawing{

	private String color = "#aa0000FF";

	public SinCurve(float start, float end) {

		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

		for(float i = start; i < end; i = i + 0.1f) {
			points.add(new SurfacePoint(i, (float)Math.sin(i)));
		}

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);

		curves.add(new Curve(points, defAttribs));
	}
}
