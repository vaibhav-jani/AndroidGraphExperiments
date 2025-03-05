package com.ai.engg.curves.drawings;

import java.util.ArrayList;

import com.ai.engg.curves.Curve;

public class Drawing {

	protected ArrayList<Curve> curves = new ArrayList<Curve>();

	/**
	 * @return the curves
	 */
	public ArrayList<Curve> getCurves() {
		return curves;
	}

	/**
	 * @param curves the curves to set
	 */
	public void setCurves(ArrayList<Curve> curves) {
		this.curves = curves;
	}
	
	public void addCurve(Curve curve) {
		this.curves.add(curve);
	}
}
