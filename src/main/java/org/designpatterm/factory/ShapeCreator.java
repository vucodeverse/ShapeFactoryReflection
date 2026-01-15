package org.designpatterm.factory;

import org.designpatterm.constant.ShapeName;
import org.designpatterm.model.Shape;
import org.designpatterm.utils.AppException;

public interface ShapeCreator {
    Shape createShape(ShapeName shapeName, double[] dimensions) throws AppException;
}
