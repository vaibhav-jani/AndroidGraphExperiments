package com.ai.engg.curves.drawings.boxes;


public class OpenBox extends Box {


    public OpenBox(float len, float wid, float dep, float start_x, float start_y) {
        super(len, wid, dep, start_x, start_y);
    }

    @Override
    public void draw() {

        curves.add(getLine(bl, br));
        // curves.add(getLine(br, tr));
        // curves.add(getLine(tr, tl));
        curves.add(getLine(tl, bl));

        curves.add(getLine(blr, brr));
        curves.add(getLine(brr, trr));
        curves.add(getLine(trr, tlr));
        curves.add(getLine(tlr, blr));

        curves.add(getLine(bl, blr));
        curves.add(getLine(br, brr));
        // curves.add(getLine(tr, trr));
        curves.add(getLine(tl, tlr));
    }
}
