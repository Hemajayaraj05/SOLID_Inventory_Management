class InventoryCommand implements Command 
{
    InventoryManager inventoryManager;
    ParseInput parser;

    InventoryCommand(InventoryManager inventoryManager,ParseInput parser) 
    {
        this.inventoryManager=inventoryManager;
        this.parser=parser;
    }

    
    public void execute(String input) 
    {
        ParsedInventory parsedInventory=parser.parseInventoryInput(input);
        inventoryManager.addProduct(parsedInventory.product,parsedInventory.quantity);
    }
}