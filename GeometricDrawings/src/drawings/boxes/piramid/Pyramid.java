package drawings.boxes.piramid;

import displaywindow.SurfacePoint;
import drawings.boxes.Box;

public class Pyramid extends Box {
	
	public static final int TOP = 0;
	public static final int BOTTOM = 1;

	int direction = TOP;

	public Pyramid(float len, float wid, float dep, float start_x, float start_y, int direction) {
		super(len, wid, dep, start_x, start_y);
		this.direction = direction;
		draw(direction);
	}

	@Override
	protected void draw() {
	}
	
	protected void draw(int direction) {
		if(direction == TOP) {
			SurfacePoint topCenter = getTopCenter();
			tl = topCenter;
			tlr = topCenter;
			tr = topCenter;
			trr = topCenter;
		}
		else if(direction == BOTTOM) {
			SurfacePoint bottomCenter = getBottomCenter();
			bl = bottomCenter;
			blr = bottomCenter;
			br = bottomCenter;
			brr = bottomCenter;
		}
		super.draw();
	}
}
