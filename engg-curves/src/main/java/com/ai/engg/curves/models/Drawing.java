package com.ai.engg.curves.models;

import java.util.ArrayList;
import java.util.List;

public class Drawing {

    protected List<Curve> curves = new ArrayList<>();

    /**
     * @return the curves
     */
    public List<Curve> getCurves() {
        return curves;
    }

    /**
     * @param curves the curves to set
     */
    public void setCurves(List<Curve> curves) {
        this.curves = curves;
    }

    public void addCurve(Curve curve) {
        this.curves.add(curve);
    }
}
