package x.y;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import displaywindow.Drawer;
import drawings.Drawing;
import drawings.globe.Globe;

public class Protons extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		ArrayList<Drawing> drawings = new ArrayList<Drawing>();

		//drawings.add(new Globe(10, 10, 8));
		
		drawings.add(new Globe(-4, 4, 1));
		drawings.add(new Globe(-2, 1, 1));
		drawings.add(new Globe(-1, 2, 1));
		
		drawings.add(new Globe(-5, -5, 1));
		drawings.add(new Globe(-4, -1, 1));
		drawings.add(new Globe(-1, -4, 1));
		
		drawings.add(new Globe(4, 4, 1));
		drawings.add(new Globe(1, 2, 1));
		drawings.add(new Globe(2, 1, 1));
		
		drawings.add(new Globe(4, -4, 1));
		drawings.add(new Globe(2, -1, 1));
		drawings.add(new Globe(-2, 1, 1));
		
		/*drawings.add(new Globe(-20, -20, 15));
		drawings.add(new Globe(15, 15, 5));
		drawings.add(new Globe(25, 25, 3));
		drawings.add(new Globe(0, 0, 10));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.88f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.84f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.80f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.76f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.72f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.68f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.64f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.60f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.56f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.52f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.48f));
		drawings.add(new Ellipse(0, 0, 10, 10, 1.44f));*/
		
		//drawings.add(new Ellipse(0, 0, 4, 5, -1.57f));
		/*drawings.add(new Ellipse(0, 0, 4, 5, 0.585f));
		drawings.add(new Ellipse(0, 0, 4, 5, -0.585f));*/

		Drawer drawer = new Drawer(drawings, null, this);
		drawer.draw();
	}
}