package displaywindow;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import curves.Curve;
import curves.CurveAttributes;
import drawings.Drawing;

public class SurfaceRenderer extends DrawingSurface {

	private float no_of_x_positive_unit;
	private float no_of_y_positive_unit;

	private float no_of_x_negetive_unit;
	private float no_of_y_negetive_unit;

	private float x_unit_length;
	private float y_unit_length;

	private float x_translate_factor;
	private float y_translate_factor;

	private ArrayList<Drawing> drawings = new ArrayList<Drawing>();
	private SurfaceAttributes surfaceAttributes = new SurfaceAttributes();

	public SurfaceRenderer(Activity activity, ArrayList<Drawing> drawings, SurfaceAttributes surfaceAttributes) {
		super(activity);
		if(drawings != null) this.drawings = drawings;
		if(surfaceAttributes != null) this.surfaceAttributes = surfaceAttributes;
		this.drawings = configurePaths(drawings);
	}

	public SurfaceRenderer(Activity activity, Drawing drawing, SurfaceAttributes surfaceAttributes) {
		super(activity);
		if(drawing != null) this.drawings.add(drawing);
		if(surfaceAttributes != null) this.surfaceAttributes = surfaceAttributes;
		this.drawings = configurePaths(drawings);
	}

	private ArrayList<Drawing> configurePaths(ArrayList<Drawing> drawings) {

		double minimum_x = 0;
		double maximum_x = 0;

		double minimum_y = 0;
		double maximum_y = 0;

		ArrayList<Drawing> drawings_configured = drawings;

		for (Drawing drawing : drawings_configured) {

			for (Curve curve : drawing.getCurves()) {

				ArrayList<SurfacePoint> points = curve.getPoints();

				for (SurfacePoint surfacePoint : points) {

					if(surfacePoint.x < minimum_x) minimum_x = surfacePoint.x;
					if(surfacePoint.y < minimum_y) minimum_y = surfacePoint.y;
					if(surfacePoint.x > maximum_x) maximum_x = surfacePoint.x;
					if(surfacePoint.y > maximum_y) maximum_y = surfacePoint.y;
				}
			}
		}

		no_of_x_negetive_unit = (float) Math.abs(minimum_x);
		no_of_x_positive_unit = (float) Math.abs(maximum_x);

		no_of_y_negetive_unit = (float) Math.abs(minimum_y);
		no_of_y_positive_unit = (float) Math.abs(maximum_y);

		x_unit_length = (float) (drawing_width / (no_of_x_negetive_unit + no_of_x_positive_unit));
		y_unit_length = (float) (drawing_height / (no_of_y_negetive_unit+no_of_y_positive_unit));

		//x_translate_factor = offset_left;
		y_translate_factor = display_height - offset_bottom;

		x_translate_factor = (no_of_x_negetive_unit*x_unit_length)+offset_left;
		y_translate_factor = display_height - (no_of_y_negetive_unit*y_unit_length) - offset_bottom;


		for (Drawing drawing : drawings_configured) {

			for (Curve curve : drawing.getCurves()) {

				ArrayList<SurfacePoint> tPoints = new ArrayList<SurfacePoint>();
				ArrayList<SurfacePoint> points = curve.getPoints();

				for (SurfacePoint surfacePoint : points) {
					SurfacePoint tPoint = new SurfacePoint(surfacePoint.x, surfacePoint.y);
					tPoints.add(tPoint);
				}

				curve.setPoints(tPoints);
			}
		}


		for (Drawing drawing : drawings_configured) {

			for (Curve curve : drawing.getCurves()) {

				ArrayList<SurfacePoint> points = curve.getPoints();

				for (SurfacePoint surfacePoint : points) {

					//System.out.println("(x_translate_factor, x_unit_length)"+"("+x_translate_factor+","+x_unit_length+")");
					//System.out.println("(y_translate_factor, y_unit_length)"+"("+y_translate_factor+","+y_unit_length+")");
					//System.out.println("Before : (x, y)"+"("+surfacePoint.x+","+surfacePoint.y+")");

					surfacePoint.x = x_translate_factor + ((float)(surfacePoint.x) * x_unit_length);
					surfacePoint.y = y_translate_factor - ((float)(surfacePoint.y) * y_unit_length);

					//System.out.println("After : (x, y)"+"("+surfacePoint.x+","+surfacePoint.y+")");
				}
			}
		}

		return drawings;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawColor(Color.parseColor(surfaceAttributes.getBackgroundColor()));
		if(surfaceAttributes.getBackground() != null) canvas.drawBitmap(surfaceAttributes.getBackground(), 0, 0, paint);
		//if(surfaceAttributes.isGridVisible()) drawGrid(canvas);
		if(surfaceAttributes.isGridVisible()) drawGridNew(canvas);
		if(surfaceAttributes.isAxisVisible()) drawAxis(canvas);
		drawCurves(canvas);
		drawAxisNames(canvas);
	}

	private void drawCurves(Canvas canvas) {

		for (Drawing drawing : drawings) {

			for (Curve curve : drawing.getCurves()) {
				
				CurveAttributes attributes = curve.getAttributes();
				if(attributes.isDrawPoints()) drawPoints(canvas);

				paint.setColor(Color.parseColor(attributes .getPointColor()));
				Path path = new Path();
				SurfacePoint p1 = curve.getPoints().get(0);
				path.moveTo(p1.x, p1.y);
				for (SurfacePoint point : curve.getPoints()) {

					path.quadTo(p1.x, p1.y, point.x, point.y); 
					p1 = point;
					//System.out.println("Point x = " + p1.x + " y = " + p1.y);

					path.lineTo(p1.x, p1.y);

					super.paint.setColor(Color.parseColor(attributes.getPathColor()));
					super.paint.setStrokeWidth(curve.getAttributes().getStrokeWidthOfPath());
					super.paint.setStyle(Paint.Style.STROKE);
		
				}
				
				/*if(attributes.isDotted()) {
					super.paint.setPathEffect(new DashPathEffect(new float[] {5, 10}, 0));
				} else {
					super.paint.setPathEffect(new CornerPathEffect(10));
				}*/
				canvas.drawPath(path, paint);
			}
			
		}
	}

	private void drawAxisNames(Canvas canvas) {
		paint.setColor(Color.parseColor(surfaceAttributes.getAxisNameColor()));
		paint.setStrokeWidth(surfaceAttributes.getAxisStrokeWidth());

		Path curve = new Path();
		//RectF rect = new RectF(offset_left*0.33f, y_translate_factor+(lineChartAttributes.Y_unit_name.length()*5), offset_left*0.33f, y_translate_factor-(lineChartAttributes.Y_unit_name.length()*5));
		RectF rect = new RectF(xbl - offset_left*0.50f, ybl, xtl - offset_left*0.50f, ytl);
		curve.addRect(rect , Direction.CCW);
		canvas.drawTextOnPath(surfaceAttributes.getY_axis_name(), curve, 0, 0, paint);

		curve = new Path();
		//rect = new RectF(x_translate_factor-(lineChartAttributes.X_unit_name.length()*5), display_height-offset_bottom*0.33f, x_translate_factor+(lineChartAttributes.X_unit_name.length()*5), display_height-offset_bottom*0.33f);
		rect = new RectF(xbl, ybl + offset_bottom*0.60f, xbr, ybr + offset_bottom*0.60f); 
		curve.addRect(rect , Direction.CW);
		canvas.drawTextOnPath(surfaceAttributes.getX_axis_name(), curve, 0, 0, paint);
	}

	private void drawPoints(Canvas canvas) {

		for (Drawing drawing : drawings) {

			for (Curve curve : drawing.getCurves()) {
				paint.setColor(Color.parseColor(curve.getAttributes().getPointColor()));
				for (SurfacePoint point : curve.getPoints()) {
					canvas.drawCircle((float)point.x, (float)point.y, curve.getAttributes().getRadiusOfPoints(), paint);
				}
			}
		}
	}

	private void drawAxis(Canvas canvas) {

		paint.setColor(Color.parseColor(surfaceAttributes.getAxisColor()));
		paint.setStrokeWidth(surfaceAttributes.getAxisStrokeWidth());
		//y
		canvas.drawLine((float) (xtl+(no_of_x_negetive_unit*x_unit_length)), ytl, (float) (xbl+(no_of_x_negetive_unit*x_unit_length)), ybl, paint);
		//x
		canvas.drawLine(xtl,(float) (ytl+(no_of_y_positive_unit*y_unit_length)), xtr, (float) (ytr+(no_of_y_positive_unit*y_unit_length)), paint);
	}

	/*private void drawGrid(Canvas canvas) {

		paint.setColor(Color.parseColor(surfaceAttributes.getGridColor()));

		float max_stroke_width = surfaceAttributes.getGridStrokeWidth();
		float gridStrokeWidth_x = max_stroke_width ;
		float gridStrokeWidth_y = max_stroke_width;
		
		gridStrokeWidth_x = (float) (10 / (no_of_x_negetive_unit+no_of_x_positive_unit));
		gridStrokeWidth_y = (float) (10 / (no_of_y_negetive_unit+no_of_y_positive_unit));

		gridStrokeWidth_x = (gridStrokeWidth_x > max_stroke_width) ? max_stroke_width : gridStrokeWidth_x;
		gridStrokeWidth_y = (gridStrokeWidth_y > max_stroke_width) ? max_stroke_width : gridStrokeWidth_y;

		paint.setStrokeWidth(gridStrokeWidth_x);
		for(int i=0; i<(no_of_x_negetive_unit+no_of_x_positive_unit)+1; i++) {
			canvas.drawLine(xtl+(i*x_unit_length), ytl, xbl+(i*x_unit_length), ybl, paint);
		}

		paint.setStrokeWidth(gridStrokeWidth_y);
		for(int i=0; i<(no_of_y_negetive_unit+no_of_y_positive_unit)+1; i++) {
			canvas.drawLine(xtl, ytl+(i*y_unit_length), xtr,ytr+(i*y_unit_length), paint);
		}
	}*/
	
	private void drawGridNew(Canvas canvas) {

		paint.setColor(Color.parseColor(surfaceAttributes.getGridColor()));

		float max_stroke_width = surfaceAttributes.getGridStrokeWidth();
		float gridStrokeWidth_x = max_stroke_width ;
		float gridStrokeWidth_y = max_stroke_width;
		
		gridStrokeWidth_x = (float) (10 / (no_of_x_negetive_unit+no_of_x_positive_unit));
		gridStrokeWidth_y = (float) (10 / (no_of_y_negetive_unit+no_of_y_positive_unit));

		gridStrokeWidth_x = (gridStrokeWidth_x > max_stroke_width) ? max_stroke_width : gridStrokeWidth_x;
		gridStrokeWidth_y = (gridStrokeWidth_y > max_stroke_width) ? max_stroke_width : gridStrokeWidth_y;

		paint.setStrokeWidth(gridStrokeWidth_x);
		for(int i=1; i<(no_of_x_negetive_unit+no_of_x_positive_unit); i++) {
			canvas.drawLine(xtl+(i*x_unit_length), ytl, xbl+(i*x_unit_length), ybl, paint);
		}

		paint.setStrokeWidth(gridStrokeWidth_y);
		for(int i=1; i<(no_of_y_negetive_unit+no_of_y_positive_unit); i++) {
			canvas.drawLine(xtl, ytl+(i*y_unit_length), xtr,ytr+(i*y_unit_length), paint);
		}
		
		canvas.drawLine(xtl, ytl, xbl, ybl, paint);
		canvas.drawLine(xbl, ybl, xbr, ybr, paint);
		canvas.drawLine(xbr, ybr, xtr, ytr, paint);
		canvas.drawLine(xtr, ytr, xtl, ytl, paint);
	}
}
