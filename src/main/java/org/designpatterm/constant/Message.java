package org.designpatterm.constant;

public enum Message {
    SHAPE_DTO_NULL("ShapeDTO chưa được khởi tạo "),
    SHAPE_CLASS_NOT_FOUND("Không tìm thấy class cho shape "),
    SHAPE_CONSTRUCTOR_NOT_FOUND("Constructor không phù hợp cho shape "),
    SHAPE_CREATE_ERROR("Lỗi khi tạo shape "),
    UNKNOWN_SHAPE_NAME("Unknown shape name "),
    INVALID_POSITIVE_NUMBER("Please input number > 0"),
    INVALID_TRIANGLE("Ba cạnh không tạo thành tam giác")
    ;

    Message(String msg) {
        this.msg = msg;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }
}
