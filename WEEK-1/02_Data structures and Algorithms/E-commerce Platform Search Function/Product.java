public class Product {

    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public void display() {
        System.out.println("ID : " + productId);
        System.out.println("Name : " + productName);
        System.out.println("Category : " + category);
    }
}