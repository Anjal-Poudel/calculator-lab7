import java.util.Scanner;

 public class CalculatorMain {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         CalculatorOperations calc = new CalculatorOperations();
         boolean continueCalc = true;
 
         while (continueCalc) {
             displayMenu();
             try {
                 System.out.print("Enter your choice (1-8): ");
                 int choice = Integer.parseInt(scanner.nextLine());
 
                 switch (choice) {
                     case 1 -> performBinaryOperation(scanner, calc, "Addition", "add");
                     case 2 -> performBinaryOperation(scanner, calc, "Subtraction", "subtract");
                     case 3 -> performBinaryOperation(scanner, calc, "Multiplication", "multiply");
                     case 4 -> performBinaryOperation(scanner, calc, "Division", "divide");
                     case 5 -> performUnaryOperation(scanner, calc, "Square", "square");
                     case 6 -> performUnaryOperation(scanner, calc, "Cube", "cube");
                     case 7 -> performUnaryOperation(scanner, calc, "Square Root", "squareRoot");
                     case 8 -> {
                         continueCalc = false;
                         System.out.println("Calculator exiting. Goodbye!");
                     }
                     default -> throw new InvalidInputException("Choice must be between 1 and 8.");
                 }
             } catch (NumberFormatException e) {
                 System.out.println("Error: Please enter a valid number.");
             } catch (InvalidInputException e) {
                 System.out.println("Error: " + e.getMessage());
             } catch (Exception e) {
                 System.out.println("Unexpected error: " + e.getMessage());
             }
         }
         scanner.close();
    }

}
