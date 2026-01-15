package org.designpatterm.view;

/**
 * ShapeView chịu trách nhiệm hiển thị thông tin lên bảng điều khiển.
 * Nó định dạng và in nội dung tiêu đề và nội dung chính liên quan đến một hình dạng.
 */
public class ShapeView {
    private String header;
    private String body;

    // ====== Getter & Setter ======
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Hiển thị thông tin hình dạng ra bảng điều khiển.
     */
    public void displayViewShape() {
        System.out.printf("%s", header);
        System.out.printf("%s",  body);
    }
}
