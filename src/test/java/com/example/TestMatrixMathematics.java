package com.example;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.example.exception.NoSquareException;
import com.example.model.Matrix;
import com.example.service.MatrixMathematics;



public class TestMatrixMathematics {

	

	/*@Test
	public void testTranspose() {
		double[][]data ={{1,2},{3,4}};
		double[][]dataExpected ={{1,3},{2,4}};
		Matrix matrix = new Matrix(data);
		Assert.assertArrayEquals(dataExpected, MatrixMathematics.transpose(matrix).getValues());
	
		
	}

	@Test
	public void testInverse() throws NoSquareException {
		double[][]data ={{1,2},{3,4}};
		double[][]dataExpected ={{-2,1},{1.5,-(0.5)}};
		Matrix matrix = new Matrix(data);
		Assert.assertArrayEquals(dataExpected, MatrixMathematics.inverse(matrix).getValues());
	}*/

//dim == 2
	@Test
	public void testDeterminant() throws NoSquareException {
		double[][]data ={{11,2},{3,4}};
		Matrix matrix = new Matrix(data);
		double detExpected=38;
		//Assert.assertEquals(detExpected, MatrixMathematics.determinant(matrix),0);
	}
	//non square
	/*@Test
	public void testDeterminant1()  {
		double[][]data ={{11,2},{3,4},{11,2}};
		Matrix matrix = new Matrix(data);
		double detExpected=38;
		
		
	}
	//dim > 2
	@Test
	public void testDeterminant2() throws NoSquareException {
		double[][]data ={{11,2,1},{3,4,5},{11,2,6}};
		Matrix matrix = new Matrix(data);
		double detExpected=190;
		//Assert.assertEquals(detExpected, MatrixMathematics.determinant(matrix),0);
	}
	

	/*@Test
	public void testCofactor() throws NoSquareException {
		double[][]data ={{1,2,3},{6,5,4},{7,8,9}};
		double[][]dataExpected ={{13,-26,13},{6,-12,6},{-7,14,-7}};
		Matrix matrix = new Matrix(data);
		//Assert.assertArrayEquals(dataExpected, MatrixMathematics.cofactor(matrix).getValues());
	}*/

}
