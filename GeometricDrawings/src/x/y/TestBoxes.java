package x.y;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import displaywindow.Drawer;
import drawings.Drawing;
import drawings.boxes.ExBox;

public class TestBoxes extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		float l = 0.32f;
		float w = 0.16f;
		float d = 0.12f;
		
		ExBox ExBox = new ExBox(l*24, w*24, d*24, 0, 0);
			
		ExBox ExBox11 = new ExBox(l*3, -w*3, d*3, ExBox.getBr().x, ExBox.getBr().y);
		ExBox ExBox13 = new ExBox(-l*3, -w*3, d*3, ExBox.getTr().x, ExBox.getTr().y);
		
		ExBox ExBox12 = new ExBox(l*3, w*3, d*3, ExBox.getBottomCenter().x, ExBox.getBottomCenter().y);
		ExBox ExBox14 = new ExBox(-l*3, w*3, d*3, ExBox.getTopCenter().x, ExBox.getTopCenter().y);
	
		ExBox ExBox15 = new ExBox(l*3, w*3, -d*3, ExBox.getBlr().x, ExBox.getBlr().y);
		ExBox ExBox16 = new ExBox(-l*3, w*3, -d*3, ExBox.getTlr().x, ExBox.getTlr().y);
		
		ArrayList<Drawing> drawings = new ArrayList<Drawing>();
		drawings.add(ExBox);
		
		/*drawings.add(ExBox1);
		drawings.add(ExBox2);
		drawings.add(ExBox3);
		drawings.add(ExBox4);
		drawings.add(ExBox5);
		drawings.add(ExBox6);
		drawings.add(ExBox7);
		drawings.add(ExBox8);
		drawings.add(ExBox9);
		drawings.add(ExBox10);*/
		
		drawings.add(ExBox11);
		drawings.add(ExBox12);
		drawings.add(ExBox13);
		drawings.add(ExBox14);
		drawings.add(ExBox15);
		drawings.add(ExBox16);
				
		Drawer drawer = new Drawer(drawings, null, this);
		drawer.draw();
	}
}