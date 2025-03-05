package com.ai.engg.curves;

import java.util.ArrayList;

import com.ai.engg.curves.display.window.SurfacePoint;

public class Curve {
	
	private CurveAttributes attributes = new CurveAttributes();
	
	private ArrayList<SurfacePoint> points = new ArrayList<SurfacePoint>();
	
	public Curve(ArrayList<SurfacePoint> points, CurveAttributes curveAttributes) {
		
		if(curveAttributes != null) this.attributes = curveAttributes;
		if(points != null) this.points = points;
	}

	public void setPoints(ArrayList<SurfacePoint> points) {
		this.points = points;
	}

	public ArrayList<SurfacePoint> getPoints() {
		return points;
	}

	public void setAttributes(CurveAttributes attributes) {
		this.attributes = attributes;
	}

	public CurveAttributes getAttributes() {
		return attributes;
	}
}
