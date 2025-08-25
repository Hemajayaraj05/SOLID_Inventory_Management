public class BuyXGetYOffer implements ProvidingOffer {

    
    public double calculatePrice(Product product, Sale sale, Offer offer) {
        int buyQty = offer.MinQuantity; 
        int freeQty = 1;

        String name = offer.offerName.toLowerCase();
        if (name.startsWith("buy") && name.contains("get")) {
            try {
                String[] parts = name.replace("buy", "").split("get");
                buyQty = Integer.parseInt(parts[0]);
                freeQty = Integer.parseInt(parts[1]);
            } catch (Exception e) {
                buyQty = offer.MinQuantity;
                freeQty = 1;
            }
        }

        int quantity = sale.quantity;
        int groupSize = buyQty + freeQty;

        int groups = quantity / groupSize;
        int remainder = quantity % groupSize;
        int payableQty = (groups * buyQty) + Math.min(remainder, buyQty);

        return payableQty * product.priceperQuantity;
    }
}
