//  Copyright © 2021 Ksuvot
package com.company;

public class ComplexNumber {
    private double real; // the real part of
    private double mnin; // the imaginary part

    public ComplexNumber() { }

    public ComplexNumber(double real, double mnin) {
        this.real = real;
        this.mnin = mnin;
    }

    // the addition of two complex numbers
    public ComplexNumber sumOfNumbers(ComplexNumber number) {
        return new ComplexNumber(this.real + number.real, this.mnin + number.mnin);
    }

    // the subtraction of two complex numbers
    public ComplexNumber subOfNumbers(ComplexNumber number) {
        return new ComplexNumber(this.real - number.real, this.mnin - number.mnin);
    }

    // the multiplication of two complex numbers
    public ComplexNumber multiOfNumbers(ComplexNumber number) {
        return new ComplexNumber(this.real * number.real - this.mnin * number.mnin,
                this.real * number.mnin + this.mnin * number.real);
    }

    // the division  of two complex numbers
    public ComplexNumber divOfNumbers(ComplexNumber number) {
        if (number.real == 0 && number.mnin == 0) {
            throw new ArithmeticException("/ by zero");
        }
        ComplexNumber answer= new ComplexNumber();
        double divider = Math.pow(number.real, 2) + Math.pow(number.mnin, 2);
        answer.real = this.real * number.real + this.mnin * number.mnin;
        answer.mnin = this.mnin * number.real - this.real * number.mnin;
        answer.real = answer.real / divider;
        answer.mnin = answer.mnin / divider;
        return answer;
    }

    // SQRT(sqr(real) + sqr(mnim))
    public double getModule(ComplexNumber number) {
        return Math.sqrt(Math.pow(number.getReal(), 2) + Math.pow(number.getMnin(), 2));
    }

    public double getPhi(ComplexNumber number) {
        return Math.atan(number.mnin / number.real);
    }

    // converting a number from an algebraic form to a geometric one
    public void convertToGeometry() {
        System.out.format("%.2f*(cos(%.2f)+sin(%.2f)*i)\n", this.getModule(this),
                this.getPhi(this), this.getPhi(this));
    }

    // printing complex numbers to the console in algebraic form
    public void printNumber() {
        if (this.mnin == 0) {
            System.out.print(this.real);
        } else if (this.mnin >= 0) {
            System.out.print(this.real + "+" + this.mnin + "i");
        } else {
            System.out.print(this.real + "" + this.mnin + "i");
        }
    }

    public void setMnim(double mnin) {
        this.mnin = mnin;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getMnin() {
        return mnin;
    }

    public double getReal() {
        return real;
    }
}
