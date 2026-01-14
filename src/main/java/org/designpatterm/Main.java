package org.designpatterm;

import org.designpatterm.constant.ShapeName;
import org.designpatterm.controller.ShapeController;
import org.designpatterm.dto.ShapeDTO;
import org.designpatterm.factory.ShapeFactory;

public class Main {
    public static void main(String[] args) {
        // Tạo dữ liệu
        ShapeDTO dto = new ShapeDTO();
        dto.setShapeName(ShapeName.RECTANGLE);
        dto.setDimensions(new double[]{5, 3});

        // Tạo các thành phần cần thiết
        ShapeFactory factory = new ShapeFactory();
        ShapeController controller = new ShapeController();

        // Gán dữ liệu vào controller
        controller.setShapeDTO(dto);
        controller.setShapeFactory(factory);

        // Thực hiện xử lý
        controller.processShape();
    }
}