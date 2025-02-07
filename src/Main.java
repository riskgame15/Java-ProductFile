
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "files/products.dat";
        ProductManager manager = new ProductManager(filePath);

        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("""
                    \n-----Product management system-----
                    1. Display products
                    2. Add new product
                    3. Find a product by name
                    0. Exit
                    Enter your choice:
                    """);
            choice = input.nextInt();
            switch(choice) {
                case 1:
                    manager.displayProducts();
                    break;
                case 2:
                    manager.addProduct();
                    break;
                case 3:
                    manager.searchProduct();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Not a choice!");
            }
        }
    }
}
