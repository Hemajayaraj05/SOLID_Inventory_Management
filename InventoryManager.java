import java.util.*;
public class InventoryManager{

    Map<String,Product> products=new HashMap<>();
    Map<String ,InventoryStock> stocks=new HashMap<>();
    Map<String,Offer> offerHistory=new HashMap<>();
    List<Sale> salesHistory=new ArrayList<>();
   
    public void addProduct(Product product,int quantity)
    {
        products.put(product.productId,product);
        stocks.put(product.productId,new InventoryStock(product.productId, quantity));
        System.out.println("Product added successfully");
    }

    public void recordSale(Sale sale) {
        InventoryStock stock=stocks.get(sale.productId);
        if (stock==null) 
        {
            System.out.println("Product not found");
            return;
        }
        if (stock.quantity<sale.quantity) 
        {
            System.out.println("Not enough stock");
            return;
        }
        stock.quantity=stock.quantity-sale.quantity;
        salesHistory.add(sale);
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
            InventoryStock stock=stocks.get(product.productId);
            System.out.println(product.productId + " | " + product.productName +" | Qty: " + stock.quantity +" | Price: " + product.priceperQuantity);
        }
    }

      public void showSales() {
        if (salesHistory.isEmpty()) {
            System.out.println("No sales recorded");
            return;
        }
        System.out.println("Sales History:");
        for (Sale sale : salesHistory) {
            System.out.println("Product ID: " + sale.productId +
                    " | Qty Sold: " + sale.quantity);
        }
    }

    public void recordOffer(Offer offer)
    {
         offerHistory.put(offer.offerId,offer);
         System.out.println("Offer recorded successfully");
    }


    public void showOfferDetails(){

        System.out.println("Offer History: ");

          for (Offer offer : offerHistory.values()) 
        {
            System.out.println(offer.offerName + " |OfferId: " + offer.offerId +" | productId: " + offer.productId +" | MinQuantity: " + offer.MinQuantity+" |discountPercentage: "+ offer.discountPercentage);
        }

    }

    public Offer getBestOffer(String productId, int quantity)
   {
    Offer bestOffer=null;
    for (Offer offer:offerHistory.values())
     {
        if (offer.productId.equals(productId) && quantity >= offer.MinQuantity) 
        {
            if (bestOffer==null || 
                Integer.parseInt(offer.discountPercentage.replace("%","")) > 
                Integer.parseInt(bestOffer.discountPercentage.replace("%","")))
                
            {
                bestOffer = offer;
            }
        }
    }
    return bestOffer;
}




}