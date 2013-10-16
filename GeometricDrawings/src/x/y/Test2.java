package x.y;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import displaywindow.Drawer;
import drawings.Drawing;
import drawings.enggcurves.Ellipse;

public class Test2 extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		ArrayList<Drawing> drawings = new ArrayList<Drawing>();

		drawings.add(new Ellipse(0, 0, 4, 5, Ellipse.X));
		drawings.add(new Ellipse(0, 0, 4, 5, -1.57f));
		drawings.add(new Ellipse(0, 0, 4, 5, 1.57f));
		/*drawings.add(new Ellipse(0, 0, 4, 5, 0.585f));
		drawings.add(new Ellipse(0, 0, 4, 5, -0.585f));
		 */
		Drawer drawer = new Drawer(drawings, null, this);
		drawer.draw();
	}
}