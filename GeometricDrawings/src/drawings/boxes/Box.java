package drawings.boxes;

import java.util.ArrayList;

import curves.Curve;
import curves.CurveAttributes;
import displaywindow.SurfacePoint;
import drawings.Drawing;

public class Box extends Drawing {

	protected String color = "#0000FF";
	
	protected float width = 1;
	protected float length = 1;
	protected float depth = 1;

	protected SurfacePoint bl;
	protected SurfacePoint br;
	protected SurfacePoint tr;
	protected SurfacePoint tl;
	
	protected SurfacePoint blr;
	protected SurfacePoint brr;
	protected SurfacePoint trr;
	protected SurfacePoint tlr;
		
	public Box(float len, float wid, float dep, float start_x, float start_y) {
			
		if(len != 0) length = len;
		if(wid != 0) width = wid;
		if(dep != 0) depth = dep;
		
		bl = new SurfacePoint(start_x, start_y);
		br = new SurfacePoint(start_x+width, start_y);
		tr = new SurfacePoint(start_x+width, length+start_y);
		tl = new SurfacePoint(start_x, length+start_y);
		
		if(length < 0) {
			SurfacePoint temp = bl;
			bl = tl;
			tl = temp;
			
			temp = br;
			br = tr;
			tr = temp;
		}
		
		if(width < 0) {
			SurfacePoint temp = bl;
			bl = br;
			br = temp;
			
			temp = tl;
			tl = tr;
			tr = temp;
		}
		
		blr = new SurfacePoint(bl.x + dep, bl.y + dep);
		brr = new SurfacePoint(br.x + dep, br.y + dep);
		trr = new SurfacePoint(tr.x + dep, tr.y + dep);
		tlr = new SurfacePoint(tl.x + dep, tl.y + dep);

		if(depth < 0) {
			
			SurfacePoint temp = bl;
			bl = blr;
			blr = temp;
			
			temp = tl;
			tl = tlr;
			tlr = temp;
			
			temp = tr;
			tr = trr;
			trr = temp;
			

			temp = br;
			br = brr;
			brr = temp;
		}
		
		draw();
	}

	protected void draw() {

		curves.add(getLine(bl, br));
		curves.add(getLine(br, tr));
		curves.add(getLine(tr, tl));
		curves.add(getLine(tl, bl));

		curves.add(getLine(blr, brr));
		curves.add(getLine(brr, trr));
		curves.add(getLine(trr, tlr));
		curves.add(getLine(tlr, blr));

		curves.add(getLine(bl, blr));
		curves.add(getLine(br, brr));
		curves.add(getLine(tr, trr));
		curves.add(getLine(tl, tlr));
	}

	protected Curve getLine(SurfacePoint bl, SurfacePoint br) {

		CurveAttributes defAttribs = new CurveAttributes();
		defAttribs.setPathColor(color);
		defAttribs.setDrawPoints(false);

		ArrayList<SurfacePoint> blbr = new ArrayList<SurfacePoint>();
		blbr.add(bl);
		blbr.add(br);

		Curve line = new Curve(blbr, defAttribs);
		return line;
	}

	/**
	 * @return The Front center
	 */
	public SurfacePoint getFrontCenter() {
		
		return new SurfacePoint((bl.x+tr.x)/2, (bl.y+tr.y)/2);
	}
	
	/**
	 * @return The Rear center
	 */
	public SurfacePoint getRearCenter() {
		
		return new SurfacePoint((blr.x+trr.x)/2, (blr.y+trr.y)/2);
	}
	
	/**
	 * @return The Left center
	 */
	public SurfacePoint getLeftCenter() {
		
		return new SurfacePoint((tl.x+blr.x)/2, (tl.y+blr.y)/2);
	}
	
	/**
	 * @return The Right center
	 */
	public SurfacePoint getRightCenter() {
		
		return new SurfacePoint((tr.x+brr.x)/2, (tr.y+brr.y)/2);
	}
	
	/**
	 * @return The Top center
	 */
	public SurfacePoint getTopCenter() {
		
		return new SurfacePoint((tl.x+trr.x)/2, (tl.y+trr.y)/2);
	}
	
	/**
	 * @return The Top center
	 */
	public SurfacePoint getBottomCenter() {
		
		return new SurfacePoint((bl.x+brr.x)/2, (bl.y+brr.y)/2);
	}
	
	/**
	 * Set color of box in #AARRGGBB format
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
	/**
	 * @return The bl : Bottom-Left-Front point of box
	 */
	public SurfacePoint getBl() {
		return bl;
	}

	/**
	 * @param The bl : Bottom-Left-Front point of box
	 */
	public void setBl(SurfacePoint bl) {
		this.bl = bl;
	}

	/**
	 * @return The br : Bottom-Right-Front point of box
	 */
	public SurfacePoint getBr() {
		return br;
	}

	/**
	 * @param The br : Bottom-Right-Front point of box
	 */
	public void setBr(SurfacePoint br) {
		this.br = br;
	}

	/**
	 * @return The tr : Top-Right-Front point of box
	 */
	public SurfacePoint getTr() {
		return tr;
	}

	/**
	 * @param The tr : Top-Right-Front point of box
	 */
	public void setTr(SurfacePoint tr) {
		this.tr = tr;
	}

	/**
	 * @return The tl : Top-Left-Front point of box
	 */
	public SurfacePoint getTl() {
		return tl;
	}

	/**
	 * @param The tl : Top-Left-Front point of box
	 */
	public void setTl(SurfacePoint tl) {
		this.tl = tl;
	}

	/**
	 * @return The blr : Bottom-Left-Rear point of box
	 */
	public SurfacePoint getBlr() {
		return blr;
	}

	/**
	 * @param The blr : Bottom-Left-Rear point of box
	 */
	public void setBlr(SurfacePoint blr) {
		this.blr = blr;
	}

	/**
	 * @return The brr : Bottom-Right-Rear point of box
	 */
	public SurfacePoint getBrr() {
		return brr;
	}

	/**
	 * @param The brr : Bottom-Right-Rear point of box
	 */
	public void setBrr(SurfacePoint brr) {
		this.brr = brr;
	}

	/**
	 * @return The trr : Top-Right-Rear point of box
	 */
	public SurfacePoint getTrr() {
		return trr;
	}

	/**
	 * @param The trr : Top-Right-Rear point of box
	 */
	public void setTrr(SurfacePoint trr) {
		this.trr = trr;
	}

	/**
	 * @return The tlr : Top-Left-Rear point of box
	 */
	public SurfacePoint getTlr() {
		return tlr;
	}

	/**
	 * @param  The tlr : Top-Left-Rear point of box
	 */
	public void setTlr(SurfacePoint tlr) {
		this.tlr = tlr;
	}

	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public float getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(float length) {
		this.length = length;
	}

	/**
	 * @return the depth
	 */
	public float getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(float depth) {
		this.depth = depth;
	}
}
