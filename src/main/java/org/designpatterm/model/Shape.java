package org.designpatterm.model;

import org.designpatterm.constant.ShapeName;

public abstract class Shape {
    /**
     * Tên của hình học (được định nghĩa bằng enum ShapeName)
     */
    protected ShapeName shapeName;

    /**
     * Constructor khởi tạo Shape với tên hình tương ứng
     *
     * @param shapeName tên của hình học
     */
    public Shape(ShapeName shapeName) {
        this.shapeName = shapeName;
    }

    /**
     * Tính diện tích của hình học
     *
     * @return diện tích
     */
    public abstract double calculateArea();

    /**
     * Tính chu vi của hình học
     *
     * @return chu vi
     */
    public abstract double calculatePerimeter();
}
