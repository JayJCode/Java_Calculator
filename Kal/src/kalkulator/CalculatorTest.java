package kalkulator;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testMaxIntAddOne() {
		Calculator sut = new Calculator();
		sut.setState(2147483647);
		sut.add(1);
		assertEquals("maxInt + 1 = -2147483648", -2147483648, sut.getState());
	}
	
	@Test
	public void testNegativeMaxIntSubOne() {
		Calculator sut = new Calculator();
		sut.setState(-2147483648);
		sut.sub(1);
		assertEquals("negativeMaxInt - 1 = 2147483647", 2147483647, sut.getState());
	}
	
	@Test
	public void testMaxIntMultiTwo() {
		Calculator sut = new Calculator();
		sut.setState(2147483647);
		sut.mult(2);
		assertEquals("MaxInt * 2 = -2", -2, sut.getState());
	}
	
	@Test
	public void testNegativeMaxIntMultiTwo() {
		Calculator sut = new Calculator();
		sut.setState(-2147483648);
		sut.mult(2);
		assertEquals("negativeMaxInt * 2 = 0", 0, sut.getState());
	}

	@Test
	public void testMultOneByTwo(){
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}
	
	@Test
	public void testSubTwo(){
		Calculator sut = new Calculator();
		sut.sub(2);
		assertEquals("0-2 = -2", -2, sut.getState());
	}
	
	@Test
	public void testDiv4By0(){
		Calculator sut = new Calculator();
		sut.setState(4);
		sut.div(0);
		assertEquals("4/0 = Nie dziel przez zero :)", 4, sut.getState());
	}
	
	@Test
	public void testMemory0Add2Save7SubMemory() {
		Calculator sut = new Calculator();
		sut.add(2);
		sut.setMem();
		sut.setState(7);
		sut.sub(sut.getMem());
		assertEquals("0+2 = 2, zapis(2), 7-zapis(2)=5", 5, sut.getState(), sut.getMem());
	}
}