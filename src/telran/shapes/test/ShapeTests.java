package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import telran.shapes.Rectangle;
import telran.shapes.Square;
import telran.shapes.SquareLeftTriangle;
import telran.shapes.SquareRightTriangle;

class ShapeTests {

	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle = new Rectangle(10, 5);
		assertEquals(10, rectangle.getWidth());
		assertEquals(5, rectangle.getHeight());
		displayStrings(rectangle.presentation(20));
		Rectangle.setSymbol("#");
		displayStrings(rectangle.presentation(20));
	}
	private void displayStrings(String strings[]) {
		for (String str: strings) {
			System.out.println(str);
		}
	}
	@Test
	@Disabled
	void squareTest() {
		Square square = new Square(4);
		assertEquals(4, square.getWidth());
		assertEquals(4, square.getHeight());
		Square.setSymbol("$");
		displayStrings(square.presentation(10));
	}
	@Test
	void squareLeftTriangle() {
		SquareLeftTriangle triangle = new SquareLeftTriangle(7, true);
		displayStrings(triangle.presentation(10));
	}
	@Test
	void squareRightTriangle() {
		SquareRightTriangle triangle = new SquareRightTriangle(7, false);
		displayStrings(triangle.presentation(10));
	}

}
