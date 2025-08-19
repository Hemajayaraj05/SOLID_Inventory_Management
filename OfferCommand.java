import java.util.*;
public class OfferCommand implements Command{

    InventoryManager inventoryManager;
    ParseInput parseInput;

    public OfferCommand(InventoryManager inventoryManager,ParseInput parseInput)
    {
        this.inventoryManager=inventoryManager;
        this.parseInput=parseInput;
    }

    public void execute(String input)
    {
        List<Offer> offer=parseInput.parseOfferInput(input);
        for(int i=0;i<offer.size();i++)
        {
             inventoryManager.recordOffer(offer.get(i));
        }
        

    }


    
    
}
