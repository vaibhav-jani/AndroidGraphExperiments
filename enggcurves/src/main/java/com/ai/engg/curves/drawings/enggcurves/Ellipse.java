package com.ai.engg.curves.drawings.enggcurves;

import java.util.ArrayList;

import com.ai.engg.curves.Curve;
import com.ai.engg.curves.CurveAttributes;

import com.ai.engg.curves.display.window.SurfacePoint;
import com.ai.engg.curves.drawings.Drawing;

public class Ellipse extends Drawing{
	
	public static int X = 0;
	public static int Y = 1;
	
	private static String color = "#0000FF";

	public Ellipse(int x0, int y0, int a, int b, int direction) {
	
		curves.add(getCurve(x0, y0, a, b, direction));
	}
	
	public Ellipse(int x0, int y0, int a, int b, float angle) {
		
		curves.add(getAngelCurve(x0, y0, a, b, angle));
	}
	
	public static Curve getCurve(int x0, int y0, int a, int b, int direction) {
		
		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();
		
		for(float i=0; i<=6.3; i= i+0.1f) {
			float x = x0+(a*((float)Math.cos(i)));
			float y = y0+(b*((float)Math.sin(i)));
			if(direction == X) {
				points.add(new SurfacePoint(x, y));
			} else {
				points.add(new SurfacePoint(y, x));
			} 
		}
		
		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);
		
		return new Curve(points, defAttribs);
	}
	
	public static Curve getAngelCurve(int x0, int y0, int a, int b, float angle) {
		
		ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();
		
		for(float i=0; i<=6.3; i= i+0.1f) {
		
			float x = x0+(a*((float)Math.cos(i)));
			float y = y0+(b*((float)Math.sin(i)));
			
			x = x+(float) (((float) x*Math.cos(angle)) - ((float) y*Math.sin(angle)));
			y = y+(float) (((float) y*Math.cos(angle)) + ((float) x*Math.sin(angle)));
			
			points.add(new SurfacePoint(x, y));
		}
		
		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);
		
		return new Curve(points, defAttribs);
	}
}
