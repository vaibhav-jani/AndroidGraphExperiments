package com.ai.engg.curves.drawings.enggcurves;

import java.util.ArrayList;

import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;

import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

public class Circle extends Drawing{
	
	public static int NEGATIVE_X = 0;
	public static int POSITIVE_X = 1;
	public static int NEGATIVE_Y = 2;
	public static int POSITIVE_Y = 3;
	
	private String color = "#0000FF";

	/**
	 * 
	 * @param a from y*y = 4*a*x + b
	 * @param b from y*y = 4*a*x + b
	 * @param start Where to start
	 * @param end Where to end
	 * @param step To be incremented each time
	 * @param direction The Direction of curve
	 */
	
	public Circle(int x0, int y0, int radius) {
	
		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();
		
		for(float i=0; i<=6.3; i= i+0.1f) {
			points.add(new SurfacePoint(x0+(radius*((float)Math.cos(i))), y0+(radius*((float)Math.sin(i)))));
		}
		
		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);
		curves.add(new Curve(points, defAttribs));
	}
}
