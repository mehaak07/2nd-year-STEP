public class ShoppingCart {

    private double[] prices;
    private int itemCount;
    private final String cartId;

    // Constructor
    public ShoppingCart(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new double[maxItems];
        itemCount = 0;
    }

    // Add item price
    public void addItem(double price) {

        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Cart is full.");
        }
    }

    // Calculate total whenever requested
    public double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total = total + prices[i];
        }

        return total;
    }

    // Return number of items
    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
