package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List <Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int num = scanner.nextInt();

        for(int i = 1; i <= num; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = scanner.next().charAt(0);
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            if(ch == 'i') {
                System.out.print("Customs fee: ");
                double fee = scanner.nextDouble();

                products.add(new ImportedProduct(name, price, fee));
            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String dateStr = scanner.next();
                Date date = sdf.parse(dateStr);

                products.add(new UsedProduct(name, price, date));
            } else {
                products.add(new Product(name, price));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");

        for(Product product : products) {
            System.out.println(product.priceTag());
        }

        scanner.close();
    }
}
