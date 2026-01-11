package org.designpatterm.model;

import org.designpatterm.constant.ShapeName;

public abstract class Shape {
    protected ShapeName shapeName;

    public Shape(ShapeName shapeName) {
        this.shapeName = shapeName;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}
