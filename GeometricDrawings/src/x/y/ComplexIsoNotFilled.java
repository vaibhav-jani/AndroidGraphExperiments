package x.y;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import displaywindow.Drawer;
import drawings.Drawing;
import drawings.boxes.Box;
import drawings.boxes.OpenBox;

public class ComplexIsoNotFilled extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		int l = 1;
		int w = 1;
		int d = 1;

		OpenBox box = new OpenBox(l*25, w*25, d*25,0, 0);

		Box box1 = new Box(l*8, w*8, -d*8, box.getBlr().x, box.getBlr().y);
		Box box2 = new Box(l*10, -w*8, -d*10, box.getBrr().x, box.getBrr().y);
		Box box3 = new Box(l*4, w*4, -d*4, box1.getBl().x, box1.getBl().y);
		Box box4 = new Box(l*5, -w*4, d*4, box.getBr().x, box.getBr().y);
		Box box6 = new Box(l*8, -w*5, -d*6, box2.getTrr().x, box2.getTrr().y);
		Box box7 = new Box(l*2, w*7, d*7, box.getBl().x, box.getBl().y);
		Box box8 = new Box(l*6, w*6, -d*6, box1.getTlr().x, box1.getTlr().y);
		Box box9 = new Box(l*4, -w*4, d*4, box8.getTr().x, box8.getTr().y);
		Box box10 = new Box(l*3, w*3, d*3, box9.getTopCenter().x, box9.getTopCenter().y);
		Box box11 = new Box(l*10, w*5, d*5, box7.getTl().x, box7.getTl().y);
		Box box12 = new Box(l*5, -w*4, -d*4, box6.getTopCenter().x, box6.getTopCenter().y);
		Box box13 = new Box(l*2, -w*2, d*2, box4.getBrr().x, box4.getBrr().y);
		Box box14 = new Box(l*4, -w*2, -d*2, box6.getBr().x, box6.getBr().y);
		Box box15 = new Box(l*6, w*3, d*3, box2.getTl().x, box2.getTl().y);
		Box box16 = new Box(l*6, -w*1, -d*1, box11.getTrr().x, box11.getTrr().y);
		Box box17 = new Box(l*4, w*4, d*4, box11.getTopCenter().x, box11.getTopCenter().y+box16.getLength());
		Box box18 = new Box(l*4, w*2, d*2, box10.getTopCenter().x, box10.getTopCenter().y);		
		Box box19 = new Box(l*3, w*2, -d*2, box17.getTlr().x, box17.getTlr().y);
		Box box20 = new Box(l*3, -w*3, -d*3, box12.getTopCenter().x, box12.getTopCenter().y);
		Box box21 = new Box(l*2, w*2, -d*2, box3.getTlr().x, box3.getTlr().y);	
		Box box22 = new Box(l*4, -w*3, -d*3, box15.getTopCenter().x, box15.getTopCenter().y);
		Box box23 =  new Box(l*4, w*4, -d*6, box1.getBrr().x, box1.getBrr().y);
		Box box24 = new Box(l*3, -w*2, d*2, box23.getTopCenter().x, box23.getTopCenter().y);
		Box box25 = new Box(l*6, -w*2, d*2, box22.getTopCenter().x, box22.getTopCenter().y);
		Box box26 = new Box(l*8, -w*5, d*5, box4.getBl().x, box4.getBl().y);
		Box box5 = new Box(l*3, -w*3, d*3, box26.getBl().x, box26.getBl().y);	

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