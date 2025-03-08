package com.ai.engg.curves.drawings.boxes;

import com.ai.engg.curves.models.Curve;
import com.ai.engg.curves.models.CurveAttributes;
import com.ai.engg.curves.models.Point;
import com.ai.engg.curves.models.Drawing;

import java.util.ArrayList;

public class Box extends Drawing {

    // TODO: Bad hack, it should be exclusively 
    //  handled on individual curves level
    protected String color = "#0000FF";

    protected float width = 1;
    protected float length = 1;
    protected float depth = 1;

    protected Point bl;
    protected Point br;
    protected Point tr;
    protected Point tl;

    protected Point blr;
    protected Point brr;
    protected Point trr;
    protected Point tlr;

    public Box(float len, float wid, float dep, float start_x, float start_y) {

        if (len != 0) length = len;
        if (wid != 0) width = wid;
        if (dep != 0) depth = dep;

        bl = new Point(start_x, start_y);
        br = new Point(start_x + width, start_y);
        tr = new Point(start_x + width, length + start_y);
        tl = new Point(start_x, length + start_y);

        if (length < 0) {
            Point temp = bl;
            bl = tl;
            tl = temp;

            temp = br;
            br = tr;
            tr = temp;
        }

        if (width < 0) {
            Point temp = bl;
            bl = br;
            br = temp;

            temp = tl;
            tl = tr;
            tr = temp;
        }

        blr = new Point(bl.x + dep, bl.y + dep);
        brr = new Point(br.x + dep, br.y + dep);
        trr = new Point(tr.x + dep, tr.y + dep);
        tlr = new Point(tl.x + dep, tl.y + dep);

        if (depth < 0) {

            Point temp = bl;
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

    protected Curve getLine(Point bl, Point br) {

        CurveAttributes defAttribs = new CurveAttributes();
        defAttribs.setPathColor(color);
        defAttribs.setDrawPoints(true);

        ArrayList<Point> blbr = new ArrayList<Point>();
        blbr.add(bl);
        blbr.add(br);

        Curve line = new Curve(blbr, defAttribs);
        return line;
    }

    /**
     * @return  Front center
     */
    public Point getFrontCenter() {

        return new Point((bl.x + tr.x) / 2, (bl.y + tr.y) / 2);
    }

    /**
     * @return  Rear center
     */
    public Point getRearCenter() {

        return new Point((blr.x + trr.x) / 2, (blr.y + trr.y) / 2);
    }

    /**
     * @return  Left center
     */
    public Point getLeftCenter() {

        return new Point((tl.x + blr.x) / 2, (tl.y + blr.y) / 2);
    }

    /**
     * @return  Right center
     */
    public Point getRightCenter() {

        return new Point((tr.x + brr.x) / 2, (tr.y + brr.y) / 2);
    }

    /**
     * @return  Top center
     */
    public Point getTopCenter() {

        return new Point((tl.x + trr.x) / 2, (tl.y + trr.y) / 2);
    }

    /**
     * @return  Top center
     */
    public Point getBottomCenter() {

        return new Point((bl.x + brr.x) / 2, (bl.y + brr.y) / 2);
    }

    public String getColor() {
        return color;
    }

    /**
     * Set color of box in #AARRGGBB format
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
        
        // TODO Bad hack,
        //  have to separate drawing from constructing 
        //  also Box and Pyramid and Box 
        //  inheritance need to change with something like shape builder 
        curves.clear();
        draw();
    }

    /**
     * @return  bl : Bottom-Left-Front point of box
     */
    public Point getBl() {
        return bl;
    }

    /**
     * @param  bl : Bottom-Left-Front point of box
     */
    public void setBl(Point bl) {
        this.bl = bl;
    }

    /**
     * @return  br : Bottom-Right-Front point of box
     */
    public Point getBr() {
        return br;
    }

    /**
     * @param  br : Bottom-Right-Front point of box
     */
    public void setBr(Point br) {
        this.br = br;
    }

    /**
     * @return  tr : Top-Right-Front point of box
     */
    public Point getTr() {
        return tr;
    }

    /**
     * @param  tr : Top-Right-Front point of box
     */
    public void setTr(Point tr) {
        this.tr = tr;
    }

    /**
     * @return  tl : Top-Left-Front point of box
     */
    public Point getTl() {
        return tl;
    }

    /**
     * @param  tl : Top-Left-Front point of box
     */
    public void setTl(Point tl) {
        this.tl = tl;
    }

    /**
     * @return  blr : Bottom-Left-Rear point of box
     */
    public Point getBlr() {
        return blr;
    }

    /**
     * @param  blr : Bottom-Left-Rear point of box
     */
    public void setBlr(Point blr) {
        this.blr = blr;
    }

    /**
     * @return  brr : Bottom-Right-Rear point of box
     */
    public Point getBrr() {
        return brr;
    }

    /**
     * @param  brr : Bottom-Right-Rear point of box
     */
    public void setBrr(Point brr) {
        this.brr = brr;
    }

    /**
     * @return  trr : Top-Right-Rear point of box
     */
    public Point getTrr() {
        return trr;
    }

    /**
     * @param  trr : Top-Right-Rear point of box
     */
    public void setTrr(Point trr) {
        this.trr = trr;
    }

    /**
     * @return  tlr : Top-Left-Rear point of box
     */
    public Point getTlr() {
        return tlr;
    }

    /**
     * @param  tlr : Top-Left-Rear point of box
     */
    public void setTlr(Point tlr) {
        this.tlr = tlr;
    }

    /**
     * @return  width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param width  width to set
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * @return  length
     */
    public float getLength() {
        return length;
    }

    /**
     * @param length  length to set
     */
    public void setLength(float length) {
        this.length = length;
    }

    /**
     * @return  depth
     */
    public float getDepth() {
        return depth;
    }

    /**
     * @param depth  depth to set
     */
    public void setDepth(float depth) {
        this.depth = depth;
    }
}
