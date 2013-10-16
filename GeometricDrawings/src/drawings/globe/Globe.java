package drawings.globe;

import drawings.Drawing;
import drawings.enggcurves.Ellipse;

public class Globe extends Drawing {

	public Globe(int x0, int y0, int radius){

		int a0 = radius;
		int b0 = radius;
	
		
		for(int i = b0; i > 0; i--){
			curves.add(Ellipse.getCurve(x0, y0, a0, b0-i, Ellipse.X));
		}
		
		for(int i = b0; i > 0; i--){
			
			if((x0<0 && y0>0) || (x0>0 && y0<0)) {
				if(Math.abs(x0) == Math.abs(y0)){
					curves.add(Ellipse.getCurve(-x0, -y0, a0, b0-i, Ellipse.Y));
				} else {
					curves.add(Ellipse.getCurve(y0, x0, a0, b0-i, Ellipse.Y));
				}
			}
			else  {

				if(x0 == y0){
					curves.add(Ellipse.getCurve(x0, y0, a0, b0-i, Ellipse.Y));
				} else {
					curves.add(Ellipse.getCurve(y0, x0, a0, b0-i, Ellipse.Y));
				}
			}
		}
		
		curves.add(Ellipse.getCurve(x0, y0, a0, b0, Ellipse.X));
		
		for(int i = b0; i > 0; i--){
			curves.add(Ellipse.getCurve(x0, y0-i, a0-i, b0-i, Ellipse.X));
		}

		for(int i = b0; i > 0; i--){
			curves.add(Ellipse.getCurve(x0, y0+i, a0-i, b0-i, Ellipse.X));
		}
	}
}
