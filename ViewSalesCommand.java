public class ViewSalesCommand implements Command{
    InventoryManager inventoryManager;
    public ViewSalesCommand(InventoryManager inventoryManager)
    {
        this.inventoryManager=inventoryManager;
    }
    public void execute(String input)
    {
        inventoryManager.showSales();
    }
    
}
