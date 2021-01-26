//  Copyright © 2021 Ksuvot
package com.company;

public class Main {

    public static void main(String[] args) {
        // Lab1
        // create new complex numbers
/*        ComplexNumber num1= new ComplexNumber(2, 4);
        ComplexNumber num2= new ComplexNumber();
        num2.setReal(1);
        num2.setMnim(3);

        num1.sumOfNumbers(num2).printNumber(); // +
        System.out.print("\n");
        num1.subOfNumbers(num2).printNumber(); // -
        System.out.print("\n");
        num2.subOfNumbers(num1).printNumber(); // -
        System.out.print("\n");
        num1.multiOfNumbers(num2).printNumber(); // *
        System.out.print("\n");
        num1.divOfNumbers(num2).printNumber(); // %
        System.out.print("\n");
        num2.divOfNumbers(num1).printNumber(); // %
        System.out.print("\n");
        num1.convertToGeometry(); // alg -> geo
        num2.convertToGeometry(); // alg -> geo*/

        // Lab2
/*        // create new matrix
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array2 = {{-4, 2, -5}, {6, -1, 3}};
        int[][] array3 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] array4 = {{1, -2, 3}, {-4, 5, -6}, {7, 8, 9}};
        Matrix matrix1 = new Matrix(2, 3);
        Matrix matrix2 = new Matrix(2, 3);
        Matrix matrix3 = new Matrix(3, 2);
        Matrix matrix4 = new Matrix(3, 3);
        matrix1.setA(array1);
        matrix2.setA(array2);
        matrix3.setA(array3);
        matrix4.setA(array4);

        matrix1.sumOfMatrix(matrix2).printMatrix(); // +
        matrix1.subOfMatrix(matrix2).printMatrix(); // -
        matrix2.subOfMatrix(matrix1).printMatrix(); // -
        matrix1.multiOfMatrix(matrix3).printMatrix(); // *
        matrix2.multiOfMatrix(matrix3).printMatrix(); // *
        matrix2.transposeOfMatrix().printMatrix(); // T
        System.out.println(matrix4.findDeterminantOfMatrix()); // D*/

        // Lab2.1
        // create new matrix this complex numbers
        ComplexNumber[][] array1 = new ComplexNumber[2][2];
        array1[0][0] = new ComplexNumber(10, 2); array1[0][1] = new ComplexNumber(9, 5);
        array1[1][0] = new ComplexNumber(5, 7); array1[1][1] = new ComplexNumber(1, 1);
        ComplexNumberMatrix matrix1 = new ComplexNumberMatrix(2, 2);
        matrix1.setA(array1);

        ComplexNumber[][] array2 = new ComplexNumber[2][2];
        array2[0][0] = new ComplexNumber(1, 6); array2[0][1] = new ComplexNumber(7, 4);
        array2[1][0] = new ComplexNumber(-9, 2); array2[1][1] = new ComplexNumber(4, -5);
        ComplexNumberMatrix matrix2 = new ComplexNumberMatrix(2, 2);
        matrix2.setA(array2);

        matrix1.sumOfMatrix(matrix2).printMatrix(); // +
        matrix1.subOfMatrix(matrix2).printMatrix(); // -
        matrix2.subOfMatrix(matrix1).printMatrix(); // -
        matrix1.multiOfMatrix(matrix2).printMatrix(); // *
        matrix2.multiOfMatrix(matrix1).printMatrix(); // *
        matrix1.transposeOfMatrix().printMatrix(); // T
        matrix1.findDeterminantOfMatrix().printNumber(); // D

    }
}
