
public class OfferFactory {
    public static ProvidingOffer getOfferStrategy(Offer offer) {
        String name=offer.offerName.toLowerCase();

        if (name.startsWith("buy") && name.contains("get")) 
        {
            return new BuyXGetYOffer();
        } else if (name.startsWith("percent"))
        {
            return new PercentageOffer();
        }
        return null;
    }
}
