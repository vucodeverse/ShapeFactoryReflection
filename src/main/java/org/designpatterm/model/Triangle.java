package org.designpatterm.model;

import org.designpatterm.constant.ShapeName;

public class Triangle extends Shape {

    /**
     * Độ dài cạnh thứ nhất của tam giác
     */
    private double sideA;

    /**
     * Độ dài cạnh thứ hai của tam giác
     */
    private double sideB;

    /**
     * Độ dài cạnh thứ ba của tam giác
     */
    private double sideC;

    /**
     * Constructor khởi tạo Triangle với ba cạnh
     *
     * @param sideA độ dài cạnh A
     * @param sideB độ dài cạnh B
     * @param sideC độ dài cạnh C
     */
    public Triangle(double sideA, double sideB, double sideC) {
        // Gán tên hình cho lớp cha
        super(ShapeName.TRIANGLE);
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

    /**
     * Tính diện tích tam giác theo công thức Heron
     *
     * <p>
     * p = (a + b + c) / 2
     * area = √(p(p − a)(p − b)(p − c))
     * </p>
     *
     * @return diện tích tam giác
     */
    @Override
    public double calculateArea() {
        double p = (sideA + sideB + sideC) / 2; // nửa chu vi
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    /**
     * Tính chu vi tam giác
     *
     * @return chu vi = sideA + sideB + sideC
     */
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

}
