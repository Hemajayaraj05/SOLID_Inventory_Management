class SalesCommand implements Command {
     InventoryManager inventoryManager;
     ParseInput parser;

    SalesCommand(InventoryManager inventoryManager, ParseInput parser) 
    {
        this.inventoryManager=inventoryManager;
        this.parser=parser;
    }

    
    public void execute(String input)
    {
        Sale sale=parser.parseSalesInput(input);
        inventoryManager.recordSale(sale);
    }
}