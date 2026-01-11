package org.designpatterm.model;

import org.designpatterm.constant.ShapeName;

public class Rectangle extends Shape{

    private double length;
    private double width;


    //Parameter Constructor
    public Rectangle(ShapeName shapeName, double length, double width) {
        super(shapeName);
        this.length = length;
        this.width = width;
    }

    // ====== Getter & Setter ======
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    //Calculate Area of Rectangle
    @Override
    public double calculateArea() {
        return 0;
    }

    //Calculate Perimeter of Rectangle
    @Override
    public double calculatePerimeter() {
        return 0;
    }
}
