package displaywindow;

import android.graphics.Bitmap;

public class SurfaceAttributes {
	
	private boolean gridVisible = true;
	private boolean axisVisible = true;
	
	//String X_unit_name = "Er. Vaibhav Anilkumar Jani's Horizontal axixs";
	//String Y_unit_name = "Er. Vaibhav Anilkumar Jani Vertical axixs";
	
	private String X_axis_name = "X";
	private String Y_axis_name = "Y";
	
	private String axisColor = "#FF000000";
	private String axisNameColor = "#FF000000";
	private float axisStrokeWidth = 1.25f;
	
	private float gridStrokeWidth = 0.25f;
	private String gridColor = "#88555555";

	private String backgroundColor = "#FFFFFFFF";
	private Bitmap background;
	
	/**
	 * @return the gridVisible
	 */
	public boolean isGridVisible() {
		return gridVisible;
	}
	
	/**
	 * @param gridVisible the gridVisible to set
	 */
	public void setGridVisible(boolean gridVisible) {
		this.gridVisible = gridVisible;
	}
	
	/**
	 * @return the axisVisible
	 */
	public boolean isAxisVisible() {
		return axisVisible;
	}
	
	/**
	 * @param axisVisible the axisVisible to set
	 */
	public void setAxisVisible(boolean axisVisible) {
		this.axisVisible = axisVisible;
	}
	
	/**
	 * @return the x_axis_name
	 */
	public String getX_axis_name() {
		return X_axis_name;
	}
	
	/**
	 * @param x_axis_name the x_axis_name to set
	 */
	public void setX_axis_name(String x_axis_name) {
		X_axis_name = x_axis_name;
	}
	
	/**
	 * @return the y_axis_name
	 */
	public String getY_axis_name() {
		return Y_axis_name;
	}
	
	/**
	 * @param y_axis_name the y_axis_name to set
	 */
	public void setY_axis_name(String y_axis_name) {
		Y_axis_name = y_axis_name;
	}
	
	/**
	 * @return the axisColor
	 */
	public String getAxisColor() {
		return axisColor;
	}
	
	/**
	 * @param axisColor the axisColor to set
	 */
	public void setAxisColor(String axisColor) {
		this.axisColor = axisColor;
	}
	
	/**
	 * @return the axisNameColor
	 */
	public String getAxisNameColor() {
		return axisNameColor;
	}
	
	/**
	 * @param axisNameColor the axisNameColor to set
	 */
	public void setAxisNameColor(String axisNameColor) {
		this.axisNameColor = axisNameColor;
	}
	
	/**
	 * @return the axisStrokeWidth
	 */
	public float getAxisStrokeWidth() {
		return axisStrokeWidth;
	}
	
	/**
	 * @param axisStrokeWidth the axisStrokeWidth to set
	 */
	public void setAxisStrokeWidth(float axisStrokeWidth) {
		this.axisStrokeWidth = axisStrokeWidth;
	}
	
	/**
	 * @return the gridStrokeWidth
	 */
	public float getGridStrokeWidth() {
		return gridStrokeWidth;
	}
	
	/**
	 * @param gridStrokeWidth the gridStrokeWidth to set
	 */
	public void setGridStrokeWidth(float gridStrokeWidth) {
		this.gridStrokeWidth = gridStrokeWidth;
	}
	
	/**
	 * @return the gridColor
	 */
	public String getGridColor() {
		return gridColor;
	}
	
	/**
	 * @param gridColor the gridColor to set
	 */
	public void setGridColor(String gridColor) {
		this.gridColor = gridColor;
	}
	
	/**
	 * @return the backgroundColor
	 */
	public String getBackgroundColor() {
		return backgroundColor;
	}
	
	/**
	 * @param backgroundColor the backgroundColor to set
	 */
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	/**
	 * @return the background
	 */
	public Bitmap getBackground() {
		return background;
	}
	
	/**
	 * @param background the background to set
	 */
	public void setBackground(Bitmap background) {
		this.background = background;
	}
}
