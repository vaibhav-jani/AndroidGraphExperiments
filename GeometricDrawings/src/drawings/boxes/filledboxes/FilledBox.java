package drawings.boxes.filledboxes;

import java.util.ArrayList;

import curves.Curve;
import curves.CurveAttributes;
import displaywindow.SurfacePoint;
import drawings.boxes.Box;

public class FilledBox extends Box {
	
	protected String frontColor = "#450000FF";
	protected String sideColor = "#300000FF";
	protected String topColor = "#150000FF";

	public FilledBox(float len, float wid, float dep, float start_x, float start_y) {
		super(len, wid, dep, start_x, start_y);

		fillFront();
		fillTop();
		fillSide();
	}

	@Override
	protected void draw(){

		curves.add(getLine(bl, br));
		curves.add(getLine(br, tr));
		curves.add(getLine(tr, tl));
		curves.add(getLine(tl, bl));

		//curves.add(getDottedLine(blr, brr));
		curves.add(getLine(brr, trr));
		curves.add(getLine(trr, tlr));
		//curves.add(getDottedLine(tlr, blr));

		//curves.add(getDottedLine(bl, blr));
		curves.add(getLine(br, brr));
		curves.add(getLine(tr, trr));
		curves.add(getLine(tl, tlr));
	}
	
	/*protected Curve getDottedLine(SurfacePoint bl, SurfacePoint br) {

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);
		defAttribs.setDotted(true);

		ArrayList<SurfacePoint> blbr = new ArrayList<SurfacePoint>();
		blbr.add(bl);
		blbr.add(br);

		Curve line = new Curve(blbr, defAttribs);
		return line;
	}*/
	
	protected void fillSide() {

		float start = br.x+2;
		float end = brr.x;
		float count = Math.abs((start - end)/2);
		for(float i = 0; i <= count; i++) {
			curves.add(getColorLine(new SurfacePoint(tr.x+(2*i), tr.y+(2*i)), new SurfacePoint(br.x+(2*i), br.y+(2*i)), sideColor));
		}
	}

	protected void fillTop() {

		float start = tl.x+2;
		float end = tr.x;
		float count = Math.abs((start - end)/2);
		for(float i = 0; i <= count; i++) {
			curves.add(getColorLine(new SurfacePoint(tl.x+(2*i), tl.y), new SurfacePoint(tlr.x+(2*i), tlr.y), topColor));
		}
	}

	protected void fillFront() {

		float start = bl.x+2;
		float end = br.x;
		float count = Math.abs((start - end)/2);

		for(float i = 0; i <= count; i++) {
			curves.add(getColorLine(new SurfacePoint(tl.x+(2*i), tl.y), new SurfacePoint(bl.x+(2*i), bl.y), frontColor));
		}
	}

	protected Curve getColorLine(SurfacePoint bl, SurfacePoint br, String clr) {

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(clr);
		defAttribs.setDrawPoints(false);

		ArrayList<SurfacePoint> blbr = new ArrayList<SurfacePoint>();
		blbr.add(bl);
		blbr.add(br);

		Curve line = new Curve(blbr, defAttribs);
		return line;
	}
}
