import java.util.*;
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
        List<Sale> sales=parser.parseSalesInput(input);
        for(int i=0;i<sales.size();i++)
        {
           inventoryManager.recordSale(sales.get(i));
        }
        
    }
}

