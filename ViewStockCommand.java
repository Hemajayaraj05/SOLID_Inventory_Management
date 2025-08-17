class ViewStockCommand implements Command 
{
     InventoryManager inventoryManager;

    ViewStockCommand(InventoryManager inventoryManager)
    {
        this.inventoryManager=inventoryManager;
    }

    
    public void execute(String input)
    {
        inventoryManager.showStocks();
    }
}