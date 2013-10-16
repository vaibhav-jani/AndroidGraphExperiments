package drawings.boxes.filledboxes;

public class ClosedBox extends FilledBox {

	public ClosedBox(float len, float wid, float dep, float start_x,
			float start_y) {
		super(len, wid, dep, start_x, start_y);
	}
	
	@Override
	protected void fillFront() {
	}
	
	@Override
	protected void fillSide() {
	}

	@Override
	protected void fillTop() {
	}
}
