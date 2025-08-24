public class Offer {

    String offerId;
    String offerName;
    String productId;
    int MinQuantity;
    String discountPercentage;
     
    public Offer(String offerName,String offerId,String productId,int MinQuantity,String discountPercentage)
    {
        this.offerName=offerName;
        this.offerId=offerId;
        this.productId=productId;
        this.MinQuantity=MinQuantity;
        this.discountPercentage = (discountPercentage == null || discountPercentage.isBlank() || discountPercentage.equalsIgnoreCase("N/A"))
                              ? null 
                              : discountPercentage;
    }
    
    
}
