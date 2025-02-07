
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private String filePath;
    private List<Product> list;

    public ProductManager(String filePath) {
        this.filePath = filePath;
        list = new ArrayList<>();
        loadProducts();
    }

    public void displayProducts() {
        if (list.isEmpty()) {
            System.out.println("Product list is empty");
            return;
        }
        for (Product product : list) {
            System.out.println(product);
        }
    }

    public boolean addProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----Enter product information-----");
        System.out.print("Product ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Price: ");
        float price = Float.parseFloat(input.nextLine());
        System.out.print("Manufacturer: ");
        String manufacturer = input.nextLine();
        System.out.print("Description: ");
        String description = input.nextLine();

        Product newProduct = new Product(id, name, price, manufacturer, description);
        list.add(newProduct);
        saveProducts();
        return true;
    }

    public void searchProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = input.nextLine();

        Product product = searchProduct(name);

        if (product != null) {
            System.out.println("Product found:");
            System.out.println(product);
        } else {
            System.out.println("No product in the list is named " + name);
        }
    }

    private Product searchProduct(String name) {
        for (Product product : list) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    private void loadProducts() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
            list = (List<Product>) inputStream.readObject();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        } catch (IOException e) {
            System.out.println("Wrong input/output");
        }
    }

    private void saveProducts() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            outputStream.writeObject(list);
            System.out.println("Products saved!");

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Wrong input/output");
        }
    }
}
