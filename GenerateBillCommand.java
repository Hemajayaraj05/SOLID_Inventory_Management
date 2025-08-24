public class GenerateBillCommand implements Command {
    InventoryManager inventoryManager;

    public GenerateBillCommand(InventoryManager inventoryManager) {
        this.inventoryManager=inventoryManager;
    }

    public void execute(String input) {
        if (inventoryManager.salesHistory.isEmpty()) {
            System.out.println("No sales recorded.");
            return;
        }

        System.out.println("===" + input + "===");
        System.out.println("ProductID | ProductName | QtyBought | PricePerQty | Offer | TotalPrice");

        double grandTotal=0;

        for (Sale sale:inventoryManager.salesHistory) 
        {
            Product product=inventoryManager.products.get(sale.productId);
            if (product==null) {
                System.out.println(sale.productId + " | Product Not Found");
                continue;
            }

            Offer bestOffer=inventoryManager.getBestOffer(sale.productId, sale.quantity);

            double price;
            String offerApplied="N/A";

            if (bestOffer!=null) 
            {
                ProvidingOffer strategy = OfferFactory.getOfferStrategy(bestOffer);

                if (strategy!=null) {
                    price=strategy.calculatePrice(product, sale, bestOffer);
                    offerApplied=bestOffer.offerName;
                } else {
                    
                    price=product.priceperQuantity*sale.quantity;
                }
            } else
             {
                price=product.priceperQuantity*sale.quantity;
            }

            grandTotal+=price;

            System.out.println(
                product.productId + " | " +
                product.productName + " | " +
                sale.quantity + " | " +
                product.priceperQuantity + " | " +
                offerApplied + " | " +
                price
            );
        }

        System.out.println("=== Total: " + grandTotal + " ===");
    }
}
