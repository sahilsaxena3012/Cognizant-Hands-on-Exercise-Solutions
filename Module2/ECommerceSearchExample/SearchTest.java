package Module2.ECommerceSearchExample;

public class SearchTest {

    public static void main(String[] args) {

        Product products[] = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Phone", "Electronics"),
                new Product(104, "Watch", "Accessories")

        };

        System.out.println("Linear Search:");

        Product p1 = Search.linearSearch(products, 103);

        if (p1 != null)
            p1.display();
        else
            System.out.println("Product not found");

        System.out.println("\nBinary Search:");

        Product p2 = Search.binarySearch(products, 104);

        if (p2 != null)
            p2.display();
        else
            System.out.println("Product not found");

    }
}