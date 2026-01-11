package org.designpatterm.constant;

public enum ShapeName {
    SQUARE("Square"),
    RECTANGLE("Rectangle"),
    TRIANGLE("Triangle");

    private final String displayName;

    ShapeName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
