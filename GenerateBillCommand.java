

public class GenerateBillCommand implements Command {
    InventoryManager inventoryManager;

    public GenerateBillCommand(InventoryManager inventoryManager) {
        this.inventoryManager=inventoryManager;
    }

    
    public void execute(String input) {
        if (inventoryManager.salesHistory.isEmpty()) {

            System.out.println("No sales recorded.Cannot generate bill.");
            return;
        }
        System.out.println("==="+input+"===");
        System.out.println("ProductID | ProductName | QtyBought | PricePerQty | Offer | TotalPrice");

        double grandTotal=0;

        for (Sale sale:inventoryManager.salesHistory)
         {
            Product product=inventoryManager.products.get(sale.productId);
            if (product==null) 
            {
                System.out.println(sale.productId + " | Product Not Found");
                continue;


            }

            Offer bestOffer=inventoryManager.getBestOffer(sale.productId, sale.quantity);

            double price=product.priceperQuantity * sale.quantity;
            String offerApplied="N/A";

            if (bestOffer != null) {
                int discount=Integer.parseInt(bestOffer.discountPercentage.replace("%", ""));
                double discountAmount=price*discount/100;
                price=price-discountAmount;
                offerApplied=bestOffer.offerName;
            }

            grandTotal=grandTotal+price;

            System.out.println(product.productId + " | " +product.productName + " | " + sale.quantity + " | " + product.priceperQuantity + " | " +
                               offerApplied + " | " + price);
        }

        System.out.println("=== Total: " + grandTotal + " ===");
    }
}
