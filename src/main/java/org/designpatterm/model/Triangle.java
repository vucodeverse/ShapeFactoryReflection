package org.designpatterm.model;

import org.designpatterm.constant.ShapeName;

public class Triangle extends Shape{

    private double sideA;
    private double sideB;
    private double sideC;

    //Parameter Constructor
    public Triangle(ShapeName shapeName, double sideA, double sideB, double sideC) {
        super(shapeName);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // ====== Getter & Setter ======
    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    //Calculate Area of Triangle
    @Override
    public double calculateArea() {
        return 0;
    }

    //Calculate Perimeter of Triangle
    @Override
    public double calculatePerimeter() {
        return 0;
    }
}
