package x.y;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import displaywindow.Drawer;
import drawings.Drawing;
import drawings.boxes.filledboxes.FilledBox;
import drawings.boxes.filledboxes.FilledOpenBox;

public class ComplexIsometric extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		int l = 8;
		int w = 4;
		int d = 3;
		
		FilledOpenBox box = new FilledOpenBox(l*25, w*25, d*25,0, 0);
				
		FilledBox box1 = new FilledBox(l*8, w*8, -d*8, box.getBlr().x, box.getBlr().y);
		FilledBox box2 = new FilledBox(l*10, -w*8, -d*10, box.getBrr().x, box.getBrr().y);
		FilledBox box3 = new FilledBox(l*4, w*4, -d*4, box1.getBl().x, box1.getBl().y);
		FilledBox box4 = new FilledBox(l*5, -w*4, d*4, box.getBr().x, box.getBr().y);
		FilledBox box6 = new FilledBox(l*8, -w*5, -d*6, box2.getTrr().x, box2.getTrr().y);
		FilledBox box7 = new FilledBox(l*2, w*7, d*7, box.getBl().x, box.getBl().y);
		FilledBox box8 = new FilledBox(l*6, w*6, -d*6, box1.getTlr().x, box1.getTlr().y);
		FilledBox box9 = new FilledBox(l*4, -w*4, d*4, box8.getTr().x, box8.getTr().y);
		FilledBox box10 = new FilledBox(l*3, w*3, d*3, box9.getTopCenter().x, box9.getTopCenter().y);
		FilledBox box11 = new FilledBox(l*10, w*5, d*5, box7.getTl().x, box7.getTl().y);
		FilledBox box12 = new FilledBox(l*5, -w*4, -d*4, box6.getTopCenter().x, box6.getTopCenter().y);
		FilledBox box13 = new FilledBox(l*2, -w*2, d*2, box4.getBrr().x, box4.getBrr().y);
		FilledBox box14 = new FilledBox(l*4, -w*2, -d*2, box6.getBr().x, box6.getBr().y);
		FilledBox box15 = new FilledBox(l*6, w*3, d*3, box2.getTl().x, box2.getTl().y);
		FilledBox box16 = new FilledBox(l*6, -w*1, -d*1, box11.getTrr().x, box11.getTrr().y);
		FilledBox box17 = new FilledBox(l*4, w*4, d*4, box11.getTopCenter().x, box11.getTopCenter().y+box16.getLength());
		FilledBox box18 = new FilledBox(l*4, w*2, d*2, box10.getTopCenter().x, box10.getTopCenter().y);		
		FilledBox box19 = new FilledBox(l*3, w*2, -d*2, box17.getTlr().x, box17.getTlr().y);
		FilledBox box20 = new FilledBox(l*3, -w*3, -d*3, box12.getTopCenter().x, box12.getTopCenter().y);
		FilledBox box21 = new FilledBox(l*2, w*2, -d*2, box3.getTlr().x, box3.getTlr().y);	
		FilledBox box22 = new FilledBox(l*4, -w*3, -d*3, box15.getTopCenter().x, box15.getTopCenter().y);
		FilledBox box23 =  new FilledBox(l*4, w*4, -d*6, box1.getBrr().x, box1.getBrr().y);
		FilledBox box24 = new FilledBox(l*3, -w*2, d*2, box23.getTopCenter().x, box23.getTopCenter().y);
		FilledBox box25 = new FilledBox(l*6, -w*2, d*2, box22.getTopCenter().x, box22.getTopCenter().y);
		FilledBox box26 = new FilledBox(l*8, -w*5, d*5, box4.getBl().x, box4.getBl().y);
		FilledBox box5 = new FilledBox(l*3, -w*3, d*3, box26.getBl().x, box26.getBl().y);	
		
		ArrayList<Drawing> drawings = new ArrayList<Drawing>();
		drawings.add(box);
		drawings.add(box1);
		drawings.add(box2);
		drawings.add(box3);
		drawings.add(box4);
		drawings.add(box5);
		drawings.add(box6);
		drawings.add(box7);
		drawings.add(box8);
		drawings.add(box9);
		drawings.add(box10);
		drawings.add(box11);
		drawings.add(box12);
		drawings.add(box13);
		drawings.add(box14);
		drawings.add(box15);
		drawings.add(box16);
		drawings.add(box17);
		drawings.add(box18);
		drawings.add(box19);
		drawings.add(box20);
		drawings.add(box21);
		drawings.add(box22);
		drawings.add(box23);
		drawings.add(box24);
		drawings.add(box25);
		drawings.add(box26);
		
		Drawer drawer = new Drawer(drawings, null, this);
		drawer.draw();
	}
}