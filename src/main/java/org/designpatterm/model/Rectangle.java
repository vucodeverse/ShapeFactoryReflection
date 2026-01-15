package org.designpatterm.model;

import org.designpatterm.constant.ShapeName;

public class Rectangle extends Shape{

    /**
     * Chiều dài của hình chữ nhật
     */
    private double length;

    /**
     * Chiều rộng của hình chữ nhật
     */
    private double width;


    /**
     * Constructor khởi tạo Rectangle với chiều dài và chiều rộng
     *
     * @param length chiều dài
     * @param width  chiều rộng
     */
    public Rectangle(double length, double width) {
        super(ShapeName.RECTANGLE);
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

    /**
     * Tính diện tích hình chữ nhật
     *
     * @return diện tích = length * width
     */
    @Override
    public double calculateArea() {
        return length * width;
    }

    /**
     * Tính chu vi hình chữ nhật
     *
     * @return chu vi = 2 * (length + width)
     */
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

}
