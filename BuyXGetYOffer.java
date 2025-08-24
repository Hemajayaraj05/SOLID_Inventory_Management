public class BuyXGetYOffer implements ProvidingOffer {

    @Override
    public double calculatePrice(Product product, Sale sale, Offer offer) {
        int buyQty = offer.MinQuantity; // e.g., 1 in "BUY1GET1"
        int freeQty = 1; // default GET 1

        // Parse "buy1get1", "buy2get1", etc.
        String name = offer.offerName.toLowerCase();
        if (name.startsWith("buy") && name.contains("get")) {
            try {
                String[] parts = name.replace("buy", "").split("get");
                buyQty = Integer.parseInt(parts[0]);
                freeQty = Integer.parseInt(parts[1]);
            } catch (Exception e) {
                // fallback
                buyQty = offer.MinQuantity;
                freeQty = 1;
            }
        }

        int quantity = sale.quantity;
        int groupSize = buyQty + freeQty;

        // How many full groups can be formed
        int groups = quantity / groupSize;

        // Remaining items outside full groups
        int remainder = quantity % groupSize;

        // Pay for (buyQty * groups) + min(remainder, buyQty)
        int payableQty = (groups * buyQty) + Math.min(remainder, buyQty);

        return payableQty * product.priceperQuantity;
    }
}
