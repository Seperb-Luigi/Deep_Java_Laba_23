package com.volkov.lab23;

import java.util.Scanner;

public class GeoExcept {
    public static void main(String[] args) {
        GeoCalc calculator = new GeoCalc();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Geometry Volume Calculator ===");
        while (true) {
            printMenu();

            System.out.print("Your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // очищаємо потік
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> handleCube(scanner, calculator);
                    case 2 -> handleSphere(scanner, calculator);
                    case 3 -> handleCylinder(scanner, calculator);
                    case 0 -> {
                        System.out.println("Exiting");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (ValidExcept e) {
                System.out.println("Validation error: " + e.getMessage());
            } catch (CalcExcept e) {
                System.out.println("Calculation error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Calculate cube volume");
        System.out.println("2. Calculate sphere volume");
        System.out.println("3. Calculate cylinder volume");
        System.out.println("0. Exit");
    }

    private static void handleCube(Scanner scanner, GeoCalc calculator) throws ValidExcept {
        System.out.print("Enter the side of the cube: ");
        double side = scanner.nextDouble();
        double volume = calculator.calculateCubeVolume(side);
        System.out.printf("The volume of the cube is: %.2f\n", volume);
    }

    private static void handleSphere(Scanner scanner, GeoCalc calculator) throws ValidExcept {
        System.out.print("Enter the radius of the sphere: ");
        double radius = scanner.nextDouble();
        double volume = calculator.calculateSphereVolume(radius);
        System.out.printf("The volume of the sphere is: %.2f\n", volume);
    }

    private static void handleCylinder(Scanner scanner, GeoCalc calculator)
            throws ValidExcept, CalcExcept {
        System.out.print("Enter the radius of the cylinder: ");
        double radius = scanner.nextDouble();
        System.out.print("Enter the height of the cylinder: ");
        double height = scanner.nextDouble();
        double volume = calculator.calculateCylinderVolume(radius, height);
        System.out.printf("The volume of the cylinder is: %.2f\n", volume);
    }
}
