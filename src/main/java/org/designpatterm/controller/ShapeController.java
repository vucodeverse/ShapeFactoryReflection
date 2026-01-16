package org.designpatterm.controller;

import org.designpatterm.dto.ShapeDTO;
import org.designpatterm.factory.ShapeFactory;
import org.designpatterm.model.Shape;
import org.designpatterm.utils.AppException;
import org.designpatterm.view.ShapeView;

public class ShapeController {
    /**
     * DTO chứa dữ liệu đầu vào (ShapeName + dimensions)
     */
    private ShapeDTO shapeDTO;

    /**
     * Factory chịu trách nhiệm tạo đối tượng Shape
     */
    private ShapeFactory shapeFactory;

    /**
     * Inject shapeFactory từ bên ngoài
     *
     * @param shapeFactory dữ liệu cần xử lí
     */
    public void setShapeFactory(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    /**
     * Inject ShapeDTO từ bên ngoài
     *
     * @param shapeDTO dữ liệu cần xử lý
     */
    public void setShapeDTO(ShapeDTO shapeDTO) {
        this.shapeDTO = shapeDTO;
    }

    /**
     * Thiết lập nội dung cho View và hiển thị kết quả
     *
     * @param header tiêu đề
     * @param body   nội dung kết quả
     */
    private void displayResult(String header, String body) {
        //View chịu trách nhiệm hiển thị kết quả
        ShapeView shapeView = new ShapeView();
        //Set header cho view
        shapeView.setHeader(header);
        //Set body cho view
        shapeView.setBody(body);
        //Hiển thị kết quả
        shapeView.displayViewShape();
    }


    /**
     * Xử lý nghiệp vụ chính:
     * - Kiểm tra DTO
     * - Tạo Shape thông qua Factory
     * - Tính diện tích và chu vi
     * - Hiển thị kết quả ra View
     *
     * @throws AppException nếu dữ liệu không hợp lệ hoặc lỗi tạo Shape
     */
    public void processShape() throws AppException {

        try {
            // Kiểm tra DTO đã được truyền vào hay chưa
            if (shapeDTO == null) {
                throw new AppException("ShapeDTO chưa được khởi tạo");
            }

            // Tạo đối tượng Shape dựa trên dữ liệu trong DTO
            Shape shape = shapeFactory.createShape(shapeDTO.getShapeName(), shapeDTO.getDimensions());

            // Tạo header cho bảng kết quả
            String header = String.format("|%-15s|%-15s|%-15s\n", "Shape", "Area", "Perimeter");
            // Tạo body chứa kết quả tính toán
            String body = String.format("|%-15s|%-15.4f|%-15.4f\n", shapeDTO.getShapeName(),
                    shape.calculateArea(), shape.calculatePerimeter());
            // Hiển thị kết quả
            displayResult(header, body);
        } catch (AppException e) {
            // Bọc exception lại để thống nhất xử lý lỗi
            throw new AppException(e.getMessage());
        }
    }


}
