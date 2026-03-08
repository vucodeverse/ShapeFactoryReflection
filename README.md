# 🔷 ShapeFactoryReflection

> Ứng dụng Java Console minh họa **Factory Design Pattern** kết hợp **Java Reflection** để tính diện tích và chu vi các hình học, tuân thủ nguyên lí **SOLID**.

## ✨ Điểm nổi bật

- **Factory Pattern + Reflection**: Tạo đối tượng Shape động qua tên class — thêm hình mới mà **không cần sửa Factory**
- **SOLID Principles**: Tuân thủ tốt 5 nguyên lí thiết kế hướng đối tượng
- **Dependency Injection (tự viết)**: Controller phụ thuộc vào interface `ShapeCreator`, không phụ thuộc concrete class
- **MVC Architecture**: Tách biệt rõ ràng Model – View – Controller
- **Clean Code**: Javadoc đầy đủ, xử lý Exception tập trung, tách biệt Validation

## 🏗️ Kiến trúc dự án

```
src/main/java/org/designpatterm/
├── Main.java                          # Entry point + Menu
├── constant/
│   ├── Message.java                   # Enum chứa thông báo lỗi
│   └── ShapeName.java                 # Enum định nghĩa tên các hình
├── controller/
│   └── ShapeController.java           # Xử lý nghiệp vụ chính
├── dto/
│   └── ShapeDTO.java                  # Data Transfer Object
├── factory/
│   ├── ShapeCreator.java              # Interface (abstraction)
│   └── ShapeFactory.java              # Concrete Factory dùng Reflection
├── model/
│   ├── Shape.java                     # Abstract class cho các hình
│   ├── Rectangle.java                 # Hình chữ nhật
│   └── Triangle.java                  # Tam giác
├── utils/
│   ├── AppException.java              # Custom Exception
│   └── Validation.java                # Validate dữ liệu đầu vào
└── view/
    └── ShapeView.java                 # Hiển thị kết quả
```

## 🔄 Luồng hoạt động

```
User Input → Main → Validation → ShapeDTO → ShapeController
                                                    ↓
                                        ShapeCreator (interface)
                                                    ↓
                                    ShapeFactory (Reflection) → Shape
                                                    ↓
                                            ShapeView (Output)
```

## 🧩 Design Pattern áp dụng

### Factory Pattern
- **Interface**: `ShapeCreator` — định nghĩa phương thức `createShape()`
- **Concrete Factory**: `ShapeFactory` — dùng Java Reflection để tạo instance Shape từ tên enum
- **Product**: `Shape` (abstract) → `Rectangle`, `Triangle`

### Cách hoạt động của Reflection Factory
```java
// Tự động map: RECTANGLE → "org.designpatterm.model.Rectangle"
String className = MODEL_PACKAGE + capitalize(shapeName.name());
Class<?> shapeClass = Class.forName(className);
Constructor<?> constructor = shapeClass.getConstructor(paramTypes);
return (Shape) constructor.newInstance(args);
```

> **Lợi ích**: Khi thêm hình mới (vd: `Circle`), chỉ cần tạo class `Circle extends Shape` và thêm enum — **không cần sửa Factory**.

## ⚙️ SOLID Principles

| Nguyên lí | Áp dụng |
|-----------|---------|
| **S** – Single Responsibility | Mỗi class chỉ đảm nhận 1 trách nhiệm duy nhất |
| **O** – Open/Closed | Factory mở cho mở rộng (thêm Shape), đóng cho sửa đổi |
| **L** – Liskov Substitution | Các subclass thay thế `Shape` mà không gây lỗi |
| **I** – Interface Segregation | `ShapeCreator` gọn gàng với 1 phương thức |
| **D** – Dependency Inversion | Controller phụ thuộc interface `ShapeCreator`, không phụ thuộc `ShapeFactory` |

## 🚀 Cách chạy

### Yêu cầu
- **Java**: JDK 21+
- **Maven**: 3.8+

### Build & Run
```bash
# Build
mvn compile

# Chạy chương trình
mvn exec:java -Dexec.mainClass="org.designpatterm.Main"
```

Hoặc chạy trực tiếp từ IDE (IntelliJ IDEA / VS Code) bằng cách Run `Main.java`.

## 📖 Cách mở rộng — Thêm hình mới

Ví dụ thêm hình tròn (`Circle`):

**Bước 1**: Thêm enum vào `ShapeName.java`
```java
CIRCLE("Circle"),
```

**Bước 2**: Tạo class `Circle.java` trong package `model`
```java
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super(ShapeName.CIRCLE);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
```

**Bước 3**: Thêm case nhập liệu trong `Main.java` — **Factory không cần sửa!**

## 🛠️ Công nghệ

- **Java 21**
- **Maven** — Quản lý build
- **Java Reflection API** — Tạo đối tượng động

## 👨‍💻 Tác giả

Dự án học tập minh họa Factory Design Pattern và nguyên lí SOLID trong Java.
