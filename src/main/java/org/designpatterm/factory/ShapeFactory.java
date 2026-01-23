package org.designpatterm.factory;

import org.designpatterm.constant.Message;
import org.designpatterm.constant.ShapeName;
import org.designpatterm.model.Shape;
import org.designpatterm.utils.AppException;

import java.lang.reflect.Constructor;


/**
 * ShapeFactory chịu trách nhiệm tạo ra các đối tượng Shape
 * dựa trên ShapeName và danh sách tham số kích thước.
 *
 * <p>
 * Class này hiện thực Factory Pattern và sử dụng Reflection
 * để tạo instance mà không phụ thuộc trực tiếp vào các class Shape cụ thể.
 * </p>
 */
public class ShapeFactory implements ShapeCreator {

    /**
     * Package chứa các class Shape cụ thể
     */
    private static final String MODEL_PACKAGE = "org.designpatterm.model.";


    /**
     * Chuyển tên enum sang đúng format tên class
     * Ví dụ:
     *  - CIRCLE  -> Circle
     *  - RECTANGLE -> Rectangle
     *
     * @param s tên enum ShapeName
     * @return tên class tương ứng
     */
    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }


    /**
     * Tạo đối tượng Shape tương ứng với ShapeName và danh sách kích thước
     *
     * @param shapeName  tên hình (enum)
     * @param dimensions danh sách tham số (ví dụ: bán kính, chiều dài, chiều rộng)
     * @return instance của Shape
     * @throws AppException nếu không tạo được shape
     */
    @Override
    public Shape createShape(ShapeName shapeName, double[] dimensions) throws AppException {

        // Tạo tên đầy đủ của class Shape
        String className = MODEL_PACKAGE + capitalize(shapeName.name());

        try {
            // Load class Shape bằng Reflection
            Class<?> shapeClass = Class.forName(className);

            // Xây dựng danh sách kiểu tham số constructor
            Class<?>[] paramTypes = new Class<?>[dimensions.length];
            for (int i = 0; i < dimensions.length; i++) {
                paramTypes[i] = double.class;
            }

            // Lấy constructor tương ứng với danh sách tham số
            Constructor<?> constructor = shapeClass.getConstructor(paramTypes);

            // Chuẩn bị danh sách đối số truyền vào constructor
            Object[] args = new Object[dimensions.length];
            for (int i = 0; i < dimensions.length; i++) {
                args[i] = dimensions[i];
            }

            // Tạo instance Shape bằng constructor
            return (Shape) constructor.newInstance(args);

        } catch (ClassNotFoundException e) {
            // Không tìm thấy class Shape
            throw new AppException(Message.SHAPE_CLASS_NOT_FOUND.getMsg() + shapeName, e);
        } catch (NoSuchMethodException e) {
            // Không tìm thấy constructor phù hợp
            throw new AppException(Message.SHAPE_CONSTRUCTOR_NOT_FOUND.getMsg() + shapeName, e);
        } catch (Exception e) {
            // Các lỗi Reflection khác
            throw new AppException(Message.SHAPE_CREATE_ERROR.getMsg() + shapeName, e);
        }
    }
}
