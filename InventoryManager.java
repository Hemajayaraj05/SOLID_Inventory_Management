import java.util.*;
public class InventoryManager{

    Map<String,Product> products=new HashMap<>();
    public void addProduct(Product product)
    {
        products.put(product.productId,product);
        System.out.println("Product added successfully");
    }

    public void recordSale(Sale sale) {
        Product product=products.get(sale.productId);
        if (product==null) 
        {
            System.out.println("Product not found");
            return;
        }
        if (product.quantity<sale.quantity) 
        {
            System.out.println("Not enough stock");
            return;
        }
        product.quantity=product.quantity-sale.quantity;
        System.out.println("Sale recorded");
    }

    public void showStocks() 
    {
        if (products.isEmpty())
         {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Inventory:");
        for (Product product : products.values()) 
        {
            System.out.println(product.productId + " | " + product.productName +" | Qty: " + product.quantity +" | Price: " + product.priceperQuantity);
        }
    }




    
}