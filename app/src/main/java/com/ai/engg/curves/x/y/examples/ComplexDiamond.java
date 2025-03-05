package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.Drawer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.boxes.piramid.Pyramid;

import java.util.ArrayList;

public class ComplexDiamond extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        int l = 64;
        int w = 32;
        int d = 24;

        Pyramid p311 = new Pyramid(l * 4, w * 4, d * 4, 0, 0, Pyramid.TOP);
        Pyramid p312 = new Pyramid(l * 4, w * 4, d * 4, p311.getBlr().x, p311.getBlr().y, Pyramid.TOP);
        Pyramid p313 = new Pyramid(l * 4, w * 4, d * 4, p312.getBlr().x, p312.getBlr().y, Pyramid.TOP);
        Pyramid p314 = new Pyramid(l * 4, w * 4, d * 4, p313.getBlr().x, p313.getBlr().y, Pyramid.TOP);

        Pyramid p321 = new Pyramid(l * 4, w * 4, d * 4, p311.getBr().x, p311.getBr().y, Pyramid.TOP);
        Pyramid p322 = new Pyramid(l * 4, w * 4, d * 4, p321.getBlr().x, p321.getBlr().y, Pyramid.TOP);
        Pyramid p323 = new Pyramid(l * 4, w * 4, d * 4, p322.getBlr().x, p322.getBlr().y, Pyramid.TOP);
        Pyramid p324 = new Pyramid(l * 4, w * 4, d * 4, p323.getBlr().x, p323.getBlr().y, Pyramid.TOP);

        Pyramid p331 = new Pyramid(l * 4, w * 4, d * 4, p321.getBr().x, p321.getBr().y, Pyramid.TOP);
        Pyramid p332 = new Pyramid(l * 4, w * 4, d * 4, p331.getBlr().x, p331.getBlr().y, Pyramid.TOP);
        Pyramid p333 = new Pyramid(l * 4, w * 4, d * 4, p332.getBlr().x, p332.getBlr().y, Pyramid.TOP);
        Pyramid p334 = new Pyramid(l * 4, w * 4, d * 4, p333.getBlr().x, p333.getBlr().y, Pyramid.TOP);

        Pyramid p341 = new Pyramid(l * 4, w * 4, d * 4, p331.getBr().x, p331.getBr().y, Pyramid.TOP);
        Pyramid p342 = new Pyramid(l * 4, w * 4, d * 4, p341.getBlr().x, p341.getBlr().y, Pyramid.TOP);
        Pyramid p343 = new Pyramid(l * 4, w * 4, d * 4, p342.getBlr().x, p342.getBlr().y, Pyramid.TOP);
        Pyramid p344 = new Pyramid(l * 4, w * 4, d * 4, p343.getBlr().x, p343.getBlr().y, Pyramid.TOP);

        Pyramid p211 = new Pyramid(l * 4, w * 4, d * 4, p311.getTopCenter().x, p311.getTopCenter().y, Pyramid.TOP);
        Pyramid p212 = new Pyramid(l * 4, w * 4, d * 4, p211.getBlr().x, p211.getBlr().y, Pyramid.TOP);
        Pyramid p213 = new Pyramid(l * 4, w * 4, d * 4, p212.getBlr().x, p212.getBlr().y, Pyramid.TOP);

        Pyramid p221 = new Pyramid(l * 4, w * 4, d * 4, p211.getBr().x, p211.getBr().y, Pyramid.TOP);
        Pyramid p222 = new Pyramid(l * 4, w * 4, d * 4, p221.getBlr().x, p221.getBlr().y, Pyramid.TOP);
        Pyramid p223 = new Pyramid(l * 4, w * 4, d * 4, p222.getBlr().x, p222.getBlr().y, Pyramid.TOP);

        Pyramid p231 = new Pyramid(l * 4, w * 4, d * 4, p221.getBr().x, p221.getBr().y, Pyramid.TOP);
        Pyramid p232 = new Pyramid(l * 4, w * 4, d * 4, p231.getBlr().x, p231.getBlr().y, Pyramid.TOP);
        Pyramid p233 = new Pyramid(l * 4, w * 4, d * 4, p232.getBlr().x, p232.getBlr().y, Pyramid.TOP);

        Pyramid p111 = new Pyramid(l * 4, w * 4, d * 4, p211.getTopCenter().x, p211.getTopCenter().y, Pyramid.TOP);
        Pyramid p112 = new Pyramid(l * 4, w * 4, d * 4, p111.getBlr().x, p111.getBlr().y, Pyramid.TOP);

        Pyramid p121 = new Pyramid(l * 4, w * 4, d * 4, p111.getBr().x, p111.getBr().y, Pyramid.TOP);
        Pyramid p122 = new Pyramid(l * 4, w * 4, d * 4, p121.getBlr().x, p121.getBlr().y, Pyramid.TOP);

        Pyramid p000 = new Pyramid(l * 4, w * 4, d * 4, p111.getTopCenter().x, p111.getTopCenter().y, Pyramid.TOP);

        l = -l;

        Pyramid p311r = new Pyramid(l * 4, w * 4, d * 4, 0, 0, Pyramid.BOTTOM);
        Pyramid p312r = new Pyramid(l * 4, w * 4, d * 4, p311r.getTlr().x, p311r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p313r = new Pyramid(l * 4, w * 4, d * 4, p312r.getTlr().x, p312r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p314r = new Pyramid(l * 4, w * 4, d * 4, p313r.getTlr().x, p313r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p321r = new Pyramid(l * 4, w * 4, d * 4, p311r.getTr().x, p311r.getTr().y, Pyramid.BOTTOM);
        Pyramid p322r = new Pyramid(l * 4, w * 4, d * 4, p321r.getTlr().x, p321r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p323r = new Pyramid(l * 4, w * 4, d * 4, p322r.getTlr().x, p322r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p324r = new Pyramid(l * 4, w * 4, d * 4, p323r.getTlr().x, p323r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p331r = new Pyramid(l * 4, w * 4, d * 4, p321r.getTr().x, p321r.getTr().y, Pyramid.BOTTOM);
        Pyramid p332r = new Pyramid(l * 4, w * 4, d * 4, p331r.getTlr().x, p331r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p333r = new Pyramid(l * 4, w * 4, d * 4, p332r.getTlr().x, p332r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p334r = new Pyramid(l * 4, w * 4, d * 4, p333r.getTlr().x, p333r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p341r = new Pyramid(l * 4, w * 4, d * 4, p331r.getTr().x, p331r.getTr().y, Pyramid.BOTTOM);
        Pyramid p342r = new Pyramid(l * 4, w * 4, d * 4, p341r.getTlr().x, p341r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p343r = new Pyramid(l * 4, w * 4, d * 4, p342r.getTlr().x, p342r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p344r = new Pyramid(l * 4, w * 4, d * 4, p343r.getTlr().x, p343r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p211r = new Pyramid(l * 4, w * 4, d * 4, p311r.getBottomCenter().x, p311r.getBottomCenter().y, Pyramid.BOTTOM);
        Pyramid p212r = new Pyramid(l * 4, w * 4, d * 4, p211r.getTlr().x, p211r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p213r = new Pyramid(l * 4, w * 4, d * 4, p212r.getTlr().x, p212r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p221r = new Pyramid(l * 4, w * 4, d * 4, p211r.getTr().x, p211r.getTr().y, Pyramid.BOTTOM);
        Pyramid p222r = new Pyramid(l * 4, w * 4, d * 4, p221r.getTlr().x, p221r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p223r = new Pyramid(l * 4, w * 4, d * 4, p222r.getTlr().x, p222r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p231r = new Pyramid(l * 4, w * 4, d * 4, p221r.getTr().x, p221r.getTr().y, Pyramid.BOTTOM);
        Pyramid p232r = new Pyramid(l * 4, w * 4, d * 4, p231r.getTlr().x, p231r.getTlr().y, Pyramid.BOTTOM);
        Pyramid p233r = new Pyramid(l * 4, w * 4, d * 4, p232r.getTlr().x, p232r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p111r = new Pyramid(l * 4, w * 4, d * 4, p211r.getBottomCenter().x, p211r.getBottomCenter().y, Pyramid.BOTTOM);
        Pyramid p112r = new Pyramid(l * 4, w * 4, d * 4, p111r.getTlr().x, p111r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p121r = new Pyramid(l * 4, w * 4, d * 4, p111r.getTr().x, p111r.getTr().y, Pyramid.BOTTOM);
        Pyramid p122r = new Pyramid(l * 4, w * 4, d * 4, p121r.getTlr().x, p121r.getTlr().y, Pyramid.BOTTOM);

        Pyramid p000r = new Pyramid(l * 4, w * 4, d * 4, p111r.getBottomCenter().x, p111r.getBottomCenter().y, Pyramid.BOTTOM);

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();

        drawings.add(p311);
        drawings.add(p312);
        drawings.add(p313);
        drawings.add(p314);

        drawings.add(p321);
        drawings.add(p322);
        drawings.add(p323);
        drawings.add(p324);

        drawings.add(p331);
        drawings.add(p332);
        drawings.add(p333);
        drawings.add(p334);

        drawings.add(p341);
        drawings.add(p342);
        drawings.add(p343);
        drawings.add(p344);

        drawings.add(p211);
        drawings.add(p212);
        drawings.add(p213);

        drawings.add(p221);
        drawings.add(p222);
        drawings.add(p223);

        drawings.add(p231);
        drawings.add(p232);
        drawings.add(p233);

        drawings.add(p111);
        drawings.add(p112);

        drawings.add(p121);
        drawings.add(p122);

        drawings.add(p000);

        drawings.add(p311r);
        drawings.add(p312r);
        drawings.add(p313r);
        drawings.add(p314r);

        drawings.add(p321r);
        drawings.add(p322r);
        drawings.add(p323r);
        drawings.add(p324r);

        drawings.add(p331r);
        drawings.add(p332r);
        drawings.add(p333r);
        drawings.add(p334r);

        drawings.add(p341r);
        drawings.add(p342r);
        drawings.add(p343r);
        drawings.add(p344r);

        drawings.add(p211r);
        drawings.add(p212r);
        drawings.add(p213r);

        drawings.add(p221r);
        drawings.add(p222r);
        drawings.add(p223r);

        drawings.add(p231r);
        drawings.add(p232r);
        drawings.add(p233r);

        drawings.add(p111r);
        drawings.add(p112r);

        drawings.add(p121r);
        drawings.add(p122r);

        drawings.add(p000r);

        Drawer drawer = new Drawer(drawings, null, this);
        drawer.draw();
    }
}