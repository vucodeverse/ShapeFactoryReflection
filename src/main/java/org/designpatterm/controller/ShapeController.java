package org.designpatterm.controller;

import org.designpatterm.dto.ShapeDTO;
import org.designpatterm.factory.ShapeFactory;
import org.designpatterm.model.Shape;
import org.designpatterm.view.ShapeView;

public class ShapeController {
    private ShapeDTO shapeDTO;
    private ShapeFactory shapeFactory;
    private ShapeView shapeView;

    public void setShapeDTO(ShapeDTO shapeDTO) {
        this.shapeDTO = shapeDTO;
    }

    public void setShapeFactory(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public void processShape() {
        try {
            if (shapeFactory == null) {
                throw new IllegalStateException("Factory chưa được khởi tạo!");
            }
            if (shapeDTO == null) {
                throw new IllegalStateException("ShapeDTO chưa được gán dữ liệu!");
            }

            Shape shape = shapeFactory.createShape(shapeDTO);
            double area = shape.calculateArea();
            double perimeter = shape.calculatePerimeter();

            System.out.println("Shape: " + shapeDTO.getShapeName().getDisplayName());
            System.out.println("Area: " + area);
            System.out.println("Perimeter: " + perimeter);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
