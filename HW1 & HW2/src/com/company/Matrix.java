//  Copyright © 2021 Ksuvot
package com.company;

public class Matrix {
    private int n; // number of columns
    private int m; // number of rows
    private int[][] A; // matrix

    public Matrix() { }

    public Matrix(int m, int n) {
        this.n = n;
        this.m = m;
        this.A = new int[m][n];
    }

    public Matrix(int[][] A) {
        this.m = A.length;
        this.n = A[0].length;
        this.A = A;
    }

    // the addition of two matrix
    public Matrix sumOfMatrix(Matrix matrix) {
        if (this.n != matrix.n || this.m != matrix.m) {
            throw new ArithmeticException("The matrices have different sizes");
        } else {
            Matrix answer = new Matrix(matrix.m, matrix.n);
            for (int i = 0; i < this.m; i++) {
                for (int j = 0; j < this.n; j++) {
                    answer.setElement(i, j, this.getElement(i, j) + matrix.getElement(i, j));
                }
            }
            return answer;
        }
    }

    // the subtraction of two matrix
    public Matrix subOfMatrix(Matrix matrix) {
        if (this.n != matrix.n || this.m != matrix.m) {
            throw new ArithmeticException("The matrices have different sizes");
        } else {
            Matrix answer = new Matrix(matrix.m, matrix.n);
            for (int i = 0; i < this.m; i++) {
                for (int j = 0; j < this.n; j++) {
                    answer.setElement(i, j, this.getElement(i, j) - matrix.getElement(i, j));
                }
            }
            return answer;
        }
    }

    // the multiplication of two matrix
    public Matrix multiOfMatrix(Matrix matrix) {
        if (this.n != matrix.m) {
            throw new ArithmeticException("The matrices have different sizes");
        }
        int[][] answer = new int[this.m][matrix.n];
        for (int i = 0; i < this.m; i++) { // go through the rows of the 1st matrix
            for (int j = 0; j < matrix.n; j++) { // go through the columns of the 2nd matrix
                for (int k = 0; k < matrix.m; k++) { // go through the rows of the 2nd matrix
                    answer[i][j] += this.A[i][k] * matrix.A[k][j];
                }
            }
        }
        return new Matrix(answer);
    }

    // the transpose of the matrix
    public Matrix transposeOfMatrix() {
        Matrix answer = new Matrix(this.n, this.m);
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                answer.setElement(j, i, this.getElement(i, j));
            }
        }
        return answer;
    }

    // the determinant of a matrix
    public double findDeterminantOfMatrix() {
        if (this.n != this.m) {
            throw new ArithmeticException("Matrix must be square");
        } else {
            if (this.m == 2){ // if matrix have 4 elements
                return this.A[0][0]*this.A[1][1] - this.A[0][1]*this.A[1][0];
            } else { // if > 2
                int sum = 0;
                for (int i = 0; i < this.m; i++) {
                    Matrix matrix = new Matrix(this.n - 1, this.m - 1);
                    int tmpI = 0;
                    int tmpJ = 0;
                    for (int j = 1; j < this.n; j++){
                        for (int k = 0; k < this.m; k++){
                            if (k != i) {
                                matrix.A[tmpI][tmpJ] = this.A[j][k];
                                tmpJ += 1;
                                if (tmpJ == this.n - 1){
                                    tmpI += 1;
                                    tmpJ = 0;
                                }
                            }
                        }
                    }
                    if (i % 2 == 0) {
                        sum += this.A[0][i] * matrix.findDeterminantOfMatrix();
                    }
                    else {
                        sum -= this.A[0][i] * matrix.findDeterminantOfMatrix();
                    }
                }
                return sum;
            }
        }
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int[][] getA() {
        return A;
    }

    public void setA(int[][] A) {
        this.A = A;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getElement(int m, int n) {
        return this.A[m][n];
    }

    public void setElement(int m, int n, int num) {
        this.A[m][n] = num;
    }

    public void printMatrix() {
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.print(this.A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
