package com.ai.engg.curves.drawings.boxes.filledboxes;

import com.ai.engg.curves.display.window.SurfacePoint;

public class FilledOpenBox extends FilledBox {


	public FilledOpenBox(float len, float wid, float dep, float start_x, float start_y) {
		super(len, wid, dep, start_x, start_y);

		fillFront();
		fillTop();
		fillSide();
	}

	@Override
	public void draw(){

		curves.add(getLine(bl, br));
		//curves.add(getLine(br, tr));
		//curves.add(getLine(tr, tl));
		curves.add(getLine(tl, bl));

		curves.add(getLine(blr, brr));
		curves.add(getLine(brr, trr));
		curves.add(getLine(trr, tlr));
		curves.add(getLine(tlr, blr));

		curves.add(getLine(bl, blr));
		curves.add(getLine(br, brr));
		//curves.add(getLine(tr, trr));
		curves.add(getLine(tl, tlr));
	}
	
	@Override
	protected void fillSide() {

		float start = tl.x+2;
		float end = tlr.x;
		float count = Math.abs((start - end)/2);
		for(float i = 0; i <= count; i++) {
			curves.add(getColorLine(new SurfacePoint(tl.x+(2*i), tl.y+(2*i)), new SurfacePoint(bl.x+(2*i), bl.y+(2*i)), sideColor));
		}
	}

	@Override
	protected void fillTop() {

		float start = bl.x+2;
		float end = br.x;
		float count = Math.abs((start - end)/2);
		for(float i = 0; i <= count; i++) {

			curves.add(getColorLine(new SurfacePoint(bl.x+(2*i), bl.y), new SurfacePoint(blr.x+(2*i), blr.y), topColor));
		}
	}

	@Override
	protected void fillFront() {

		float start = tlr.x+2;
		float end = trr.x;
		float count = Math.abs((start - end)/2);

		for(float i = 0; i <= count; i++) {
			curves.add(getColorLine(new SurfacePoint(tlr.x+(2*i), tlr.y), new SurfacePoint(blr.x+(2*i), blr.y), frontColor));
		}
	}
}
