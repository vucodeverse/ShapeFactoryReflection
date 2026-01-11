package org.designpatterm.dto;

import org.designpatterm.constant.ShapeName;

public class ShapeDTO {
    private ShapeName shapeName;
    private double[] dimensions;

    //Default Constructor
    public ShapeDTO() {
    }

    // ====== Getter & Setter ======
    public ShapeName getShapeName() {
        return shapeName;
    }

    public void setShapeName(ShapeName shapeName) {
        this.shapeName = shapeName;
    }

    public double[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(double[] dimensions) {
        this.dimensions = dimensions;
    }
}
