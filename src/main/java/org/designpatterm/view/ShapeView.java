package org.designpatterm.view;

/**
 * ShapeView is responsible for displaying shape information to the console.
 * It formats and prints the header and body content related to a shape.
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
     * Displays the shape information to the console.
     */
    public void displayViewShape() {
        System.out.printf("%s", header);
        System.out.printf("%s",  body);
    }
}
