package com.ai.engg.curves.x.y.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ai.engg.curves.display.window.Drawer;
import com.ai.engg.curves.drawings.Drawing;
import com.ai.engg.curves.drawings.trigmometric.CosCurve;
import com.ai.engg.curves.drawings.trigmometric.SinCurve;
import com.ai.engg.curves.drawings.trigmometric.TanCurve;

import java.util.ArrayList;


public class SinCosTan extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        ArrayList<Drawing> drawings = new ArrayList<Drawing>();
        drawings.add(new SinCurve(-7, 7));
        drawings.add(new CosCurve(-7, 7));
        drawings.add(new TanCurve(-7, 7));
        //drawings.add(new CotCurve(-10, 10));

        Drawer drawer = new Drawer(drawings, null, this);
        drawer.draw();
    }
}