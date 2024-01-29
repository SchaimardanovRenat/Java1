package org.example;
import java.util.Scanner;
public class Main_P_S_R_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите фигуру:");
        System.out.println("1 - Круг");
        System.out.println("2 - Прямоугольник");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.print("Введите радиус круга: ");
            double radius = scanner.nextDouble();
            double perimeter = 2 * Math.PI * radius;
            System.out.println("Периметр круга: " + perimeter);
            double area = Math.PI * Math.pow(radius, 2);
            System.out.println("Площадь круга: " + area);
        } else if (choice == 2) {
            System.out.print("Введите ширину прямоугольника: ");
            double width = scanner.nextDouble();
            System.out.print("Введите высоту прямоугольника: ");
            double height = scanner.nextDouble();
            double perimeter = 2 * (width + height);
            System.out.println("Периметр прямоугольника: " + perimeter);
            double area = width * height;
            System.out.println("Площадь прямоугольника: " + area);
        } else {
            System.out.println("Некорректный выбор фигуры.");
        }

        scanner.close();
    }
}
