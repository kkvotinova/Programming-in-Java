//  Copyright © 2021 Ksuvot
package com.company;

public class Main {

    public static void main(String[] args) {
        /* create new complex numbers */
        ComplexNumber num1= new ComplexNumber(2, 4);
        ComplexNumber num2= new ComplexNumber();
        num2.setReal(1);
        num2.setMnim(3);

        num1.sumOfNumbers(num2).printNumber(); // +
        num1.subOfNumbers(num2).printNumber(); // -
        num2.subOfNumbers(num1).printNumber(); // -

        num1.multiOfNumbers(num2).printNumber(); // *
        num1.divOfNumbers(num2).printNumber(); // %
        num2.divOfNumbers(num1).printNumber(); // %

        num1.convertToGeometry(); // alg -> geo
        num2.convertToGeometry(); // alg -> geo
    }
}
