package org.designpatterm;

import org.designpatterm.constant.ShapeName;
import org.designpatterm.controller.ShapeController;
import org.designpatterm.dto.ShapeDTO;
import org.designpatterm.factory.ShapeFactory;
import org.designpatterm.utils.AppException;
import org.designpatterm.utils.Validation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Controller điều phối xử lý nghiệp vụ
        ShapeController controller = new ShapeController();

        //ShapeFactory nhận biết đối tưởng
        ShapeFactory shapeFactory = new ShapeFactory();

        // DTO dùng để truyền dữ liệu từ Main sang Controller
        ShapeDTO dto = new ShapeDTO();

        // Scanner dùng để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        //Truyền Factory về Controller
        controller.setShapeFactory(shapeFactory);

        boolean running = true;

        // Vòng lặp chính của chương trình
        while (running) {
            try {
                // Hiển thị menu
                System.out.println("\n======== Calculate Shape =======");
                System.out.println("1. Calculate Triangle");
                System.out.println("2. Calculate Rectangle");
                System.out.println("0. Exit");
                System.out.print("Choose option: ");

                // Đọc lựa chọn từ người dùng
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    // ====== Xử lý tam giác ======
                    case 1 -> {
                        // Gán loại hình cho DTO
                        dto.setShapeName(ShapeName.TRIANGLE);

                        // Nhập và validate cạnh a
                        System.out.print("Enter side a: ");
                        double a = Validation.getPositiveNum(
                                Double.parseDouble(scanner.nextLine())
                        );

                        // Nhập và validate cạnh b
                        System.out.print("Enter side b: ");
                        double b = Validation.getPositiveNum(
                                Double.parseDouble(scanner.nextLine())
                        );

                        // Nhập và validate cạnh c
                        System.out.print("Enter side c: ");
                        double c = Validation.getPositiveNum(
                                Double.parseDouble(scanner.nextLine())
                        );

                        // Kiểm tra điều kiện tam giác
                        Validation.validateTriangle(a, b, c);

                        // Đóng gói dữ liệu vào DTO
                        dto.setDimensions(new double[]{a, b, c});
                    }

                    // ====== Xử lý hình chữ nhật ======
                    case 2 -> {
                        // Gán loại hình cho DTO
                        dto.setShapeName(ShapeName.RECTANGLE);

                        // Nhập và validate chiều dài
                        System.out.print("Enter length: ");
                        double length = Validation.getPositiveNum(
                                Double.parseDouble(scanner.nextLine())
                        );

                        // Nhập và validate chiều rộng
                        System.out.print("Enter width: ");
                        double width = Validation.getPositiveNum(
                                Double.parseDouble(scanner.nextLine())
                        );

                        // Đóng gói dữ liệu vào DTO
                        dto.setDimensions(new double[]{length, width});
                    }

                    // ====== Thoát chương trình ======
                    case 0 -> {
                        System.out.println("Exit program. Goodbye!");
                        running = false;
                        continue;
                    }

                    // ====== Lựa chọn không hợp lệ ======
                    default -> throw new AppException("Invalid choice");
                }

                // Truyền DTO vào Controller
                controller.setShapeDTO(dto);

                // Gọi Controller xử lý nghiệp vụ
                controller.processShape();

            } catch (AppException e) {
                // Xử lý lỗi nghiệp vụ
                System.out.println("Error: " + e.getMessage());

            } catch (NumberFormatException e) {
                // Xử lý lỗi nhập sai kiểu dữ liệu
                System.out.println("Error: Please enter a valid number");
            }
        }
    }
}
