package x.y;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import displaywindow.Drawer;
import drawings.Drawing;
import drawings.trigmometric.CosCurve;
import drawings.trigmometric.SinCurve;
import drawings.trigmometric.TanCurve;

public class Trigonometry extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		ArrayList<Drawing> drawings = new ArrayList<Drawing>();
		drawings.add(new SinCurve(-7, 7));
		drawings.add(new CosCurve(-7, 7));
		drawings.add(new TanCurve(-7, 7));
		//drawings.add(new CotCurve(-10, 10));
		
		Drawer drawer = new Drawer(drawings, null, this);
		drawer.draw();
	}
}