public class PercentageOffer implements ProvidingOffer 
{
    public double calculatePrice(Product product, Sale sale, Offer offer)
    
    {
        double percent=Double.parseDouble(offer.discountPercentage.replace("%", ""));
        double total=product.priceperQuantity * sale.quantity;
        return total-(total * percent / 100);
    }
}