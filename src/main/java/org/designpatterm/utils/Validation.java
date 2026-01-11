package org.designpatterm.utils;

import org.designpatterm.constant.ShapeName;

public class Validation {

    private Validation() {
    }

    /**
     * Converts a string to the corresponding ShapeName enum value.
     * <p>
     * The comparison is case-insensitive. If the provided name does not
     * match any ShapeName value, an AppException will be thrown.
     * <p>
     * @param name the shape name as a string
     * @return the corresponding ShapeName enum
     * @throws AppException if the shape name is invalid or unknown
     */
    public static ShapeName fromString(String name) throws AppException {
        for (ShapeName shapeName : ShapeName.values()) {
            if (shapeName.name().equalsIgnoreCase(name)) {
                return shapeName;
            }
        }
        throw new AppException("Unknown shape name: " + name);
    }


    /**
     * Validates that the given value is a positive number (> 0).
     *
     * @param value the input number to validate
     * @return the value if it is greater than 0
     * @throws AppException if the value is not positive
     */
    public static double getPositiveNum(double value) throws AppException {
        if (value > 0)
            return value;
        else
            throw new AppException("Please input number > 0");
    }


}
