package com.company;

public class ComplexNumberMatrix {
    private int n; // number of columns
    private int m; // number of rows
    private ComplexNumber[][] A; // matrix

    public ComplexNumberMatrix() { }

    public ComplexNumberMatrix(int m, int n) {
        this.n = n;
        this.m = m;
        this.A = new ComplexNumber[m][n];
    }

    public ComplexNumberMatrix(ComplexNumber[][] A) {
        this.m = A.length;
        this.n = A[0].length;
        this.A = A;
    }

    // the addition of two matrix
    public ComplexNumberMatrix sumOfMatrix(ComplexNumberMatrix matrix) {
        if (this.n != matrix.n || this.m != matrix.m) {
            throw new ArithmeticException("The matrices have different sizes");
        } else {
            ComplexNumber[][] array = new ComplexNumber[matrix.m][matrix.n];
            for (int i = 0; i < this.m; i++) {
                for (int j = 0; j < this.n; j++) {
                    array[i][j] = this.A[i][j].sumOfNumbers(matrix.A[i][j]);
                }
            }
            return new ComplexNumberMatrix(array);
        }
    }

    // the subtraction of two matrix
    public ComplexNumberMatrix subOfMatrix(ComplexNumberMatrix matrix) {
        if (this.n != matrix.n || this.m != matrix.m) {
            throw new ArithmeticException("The matrices have different sizes");
        } else {
            ComplexNumber[][] array = new ComplexNumber[matrix.m][matrix.n];
            for (int i = 0; i < this.m; i++) {
                for (int j = 0; j < this.n; j++) {
                    array[i][j] = this.A[i][j].subOfNumbers(matrix.A[i][j]);
                }
            }
            return new ComplexNumberMatrix(array);
        }
    }

    // the multiplication of two matrix
    public ComplexNumberMatrix multiOfMatrix(ComplexNumberMatrix matrix) {
        if (this.n != matrix.m) {
            throw new ArithmeticException("The matrices have different sizes");
        }
        ComplexNumber[][] array = new ComplexNumber[this.m][matrix.n];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                array[i][j] = new ComplexNumber(0.0, 0.0);
            }
        }
        for (int i = 0; i < this.m; i++) { // go through the rows of the 1st matrix
            for (int j = 0; j < matrix.n; j++) { // go through the columns of the 2nd matrix
                for (int k = 0; k < matrix.m; k++) { // go through the rows of the 2nd matrix
                    array[i][j] = array[i][j].sumOfNumbers(this.A[i][k].multiOfNumbers(matrix.A[k][j]));
                }
            }
        }
        return new ComplexNumberMatrix(array);
    }

    // the transpose of the matrix
    public ComplexNumberMatrix transposeOfMatrix() {
        ComplexNumberMatrix answer = new ComplexNumberMatrix(this.n, this.m);
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                answer.setElement(j, i, this.getElement(i, j));
            }
        }
        return answer;
    }

    // the determinant of a matrix
    public ComplexNumber findDeterminantOfMatrix() {
        if (this.n != this.m) {
            throw new ArithmeticException("Matrix must be square");
        } else {
            if (this.m == 2){ // if matrix have 4 elements
                return this.A[0][0].multiOfNumbers(this.A[1][1])
                        .subOfNumbers(this.A[0][1].multiOfNumbers(this.A[1][0]));
            } else { // if > 2
                ComplexNumber sum = new ComplexNumber(0.0, 0.0);
                for (int i = 0; i < this.m; i++) {
                    ComplexNumberMatrix matrix = new ComplexNumberMatrix(this.n - 1, this.m - 1);
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
                        sum = sum.sumOfNumbers(this.A[0][i].multiOfNumbers(matrix.findDeterminantOfMatrix()));
                    }
                    else {
                        sum = sum.sumOfNumbers(this.A[0][i].multiOfNumbers(matrix.findDeterminantOfMatrix()));
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

    public ComplexNumber[][] getA() {
        return A;
    }

    public void setA(ComplexNumber[][] A) {
        this.A = A;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public ComplexNumber getElement(int m, int n) {
        return this.A[m][n];
    }

    public void setElement(int m, int n, ComplexNumber num) {
        this.A[m][n] = num;
    }

    public void printMatrix() {
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                this.A[i][j].printNumber();
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
