package telran.shapes;

import java.util.Arrays;

public class Canvas extends Shape {
	private Shape[] shapes;
	private int margin = 2;

	public Canvas(int width, int height, Shape[] shapes) {
		super(width, height);
		this.shapes = shapes;
	}
	
	@Override
	public String[] presentation(int offset) {
		String[] res = new String[getHeight()];
		Arrays.fill(res, getOffset(offset));
		for (Shape shape: shapes) {
			String[] sh = shape.presentation(0);
			for (int i = 0; i < sh.length; i++ ) {
				res[i] += sh[i] + getOffset(margin);
			}
		}		
		return res;
	}		
	
	public String[] column (int offset) {
		int height = getHeight();
		int countRows = (height + margin) * shapes.length;
		String[] res = new String[countRows];
		int index = 0;
		for (Shape shape: shapes) {			
			res = method(res, shape.presentation(offset), offset, index);
			index += height + margin;
		}		
		return res;
	}
	private String[] method (String[] res, String[] shape, int offset, int index) {
		int height = getHeight();
		System.arraycopy(shape, 0, res, index, height);
		for (int i = index + height; i < index + height + margin; i++) {
			res[i] = getOffset(offset + getWidth());
		}
		return res;
	}
}
