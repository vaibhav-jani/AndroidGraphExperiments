package com.ai.engg.curves.drawings.enggcurves;

import java.util.ArrayList;

import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;

import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

public class Parabola extends Drawing{

	public static int NEGATIVE_X = 0;
	public static int POSITIVE_X = 1;
	public static int NEGATIVE_Y = 2;
	public static int POSITIVE_Y = 3;

	private static String color = "#FF0000";

	public Parabola(int x0, int yo, int start, int end, int a, int b, int direction) {
		
		curves.add(getCurve(x0, yo, start, end, a, b, direction));
	}

	public static Curve getCurve(int x0, int yo, int start, int end, int a, int b, int direction) {

		if(end < start) {
			int temp = start;
			start = end;
			end = temp;
		}

		if(b == 0) b = 1;

		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();

		for(float y=start; y<=end; y= y+0.1f) {

			float x = (float)(((float)a/b)*(Math.sqrt((b*b)+(y*y))));

			if(direction == POSITIVE_X) {
				points.add(new SurfacePoint(x0+x, y+yo));
			} else if(direction == NEGATIVE_X) {
				points.add(new SurfacePoint(-x+x0, y+yo));
			} else if(direction == POSITIVE_Y) {
				points.add(new SurfacePoint(y+x0, x+yo));
			} else if(direction == NEGATIVE_Y) {
				points.add(new SurfacePoint(y+x0, -x+yo));	
			}
		}

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);
		return new Curve(points, defAttribs);
	}
}
