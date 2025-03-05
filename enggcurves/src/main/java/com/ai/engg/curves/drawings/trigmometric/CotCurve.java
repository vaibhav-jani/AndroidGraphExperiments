package com.ai.engg.curves.drawings.trigmometric;

import java.util.ArrayList;
import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;
import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

public class CotCurve extends Drawing{

	private String color = "#FF0000";

	public CotCurve(float start, float end) {

		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

		for(float i = start; i < end; i = i + 0.1f) {
			float tan = (float)Math.tan(i);
			if(tan != 0) points.add(new SurfacePoint(i, 1/tan));
		}

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);

		curves.add(new Curve(points, defAttribs));
	}
}
