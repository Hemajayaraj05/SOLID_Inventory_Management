public class ViewOfferCommand implements Command{
    InventoryManager inventoryManager;
    public ViewOfferCommand(InventoryManager inventoryManager)
    {
        this.inventoryManager=inventoryManager;
    }
    public void execute(String input)
    {
        inventoryManager.showOfferDetails();
    }
    
    
}
