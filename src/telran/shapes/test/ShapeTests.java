package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import telran.shapes.Rectangle;
import telran.shapes.Shape;
import telran.shapes.Square;
import telran.shapes.SquareLeftTriangle;
import telran.shapes.SquareRightTriangle;

import telran.shapes.Canvas;


class ShapeTests {

	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle = new Rectangle(10, 5);
		displayStrings(rectangle.presentation(20));
		assertEquals(10, rectangle.getWidth());
		assertEquals(5, rectangle.getHeight());
//		Rectangle.setSymbol("#");
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
	@Disabled
	void squareLeftTriangle() {
		SquareLeftTriangle triangle = new SquareLeftTriangle(7);
		assertEquals(7, triangle.getWidth());
		displayStrings(triangle.presentation(10));
	}
	@Test
	@Disabled
	void squareRightTriangle() {
		SquareRightTriangle triangle = new SquareRightTriangle(7);
		displayStrings(triangle.presentation(10));
	}
	@Test
	void Canvas() {
		Rectangle rectangle = new Rectangle(5,5);
		Square square = new Square(5);
		SquareLeftTriangle leftTriangle = new SquareLeftTriangle(5);
		SquareRightTriangle rightTriangle = new SquareRightTriangle(5);
		Shape[] shapes = new Shape[] {rectangle, square, leftTriangle, rightTriangle};
		Canvas canvas = new Canvas(5, 5, shapes);
		displayStrings(canvas.presentation(10));
		displayStrings(canvas.column(10));
	}

}
