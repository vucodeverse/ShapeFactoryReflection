package org.designpatterm.factory;

import org.designpatterm.constant.ShapeName;
import org.designpatterm.dto.ShapeDTO;
import org.designpatterm.model.Shape;
import org.designpatterm.utils.AppException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ShapeFactory {

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toUpperCase();
    }

    public Shape createShape(ShapeDTO shapeDTO) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String shapeType = shapeDTO.getShapeName().name();
        String className = "model." + capitalize(shapeType);

        Class<?> shapeClass = Class.forName(className);
        double[] dimensions = shapeDTO.getDimensions();

        // Tạo danh sách kiểu tham số
        Class<?>[] paramTypes = new Class<?>[dimensions.length];
        for (int i = 0; i < dimensions.length; i++) {
            paramTypes[i] = double.class;
        }

        // Tìm constructor
        Constructor<?> constructor = shapeClass.getConstructor(paramTypes);

        // Chuẩn bị tham số
        Object[] args = new Object[dimensions.length];
        for (int i = 0; i < dimensions.length; i++) {
            args[i] = dimensions[i];
        }

        // Tạo instance
        return (Shape) constructor.newInstance(args);

    }
}
