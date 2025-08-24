
import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        InventoryManager inventoryManager=new InventoryManager();
        ParseInput parseInput=new ParseInput();
        CommandHandler commandHandler=new CommandHandler();

        commandHandler.registerCommand("INVENTORY", new InventoryCommand(inventoryManager, parseInput));
        commandHandler.registerCommand("SALE", new SalesCommand(inventoryManager, parseInput));
        commandHandler.registerCommand("VIEWSTOCKS", new ViewStockCommand(inventoryManager));
        commandHandler.registerCommand("NEW-OFFER",new OfferCommand(inventoryManager,parseInput));
        commandHandler.registerCommand(("VIEWSALES"), new ViewSalesCommand(inventoryManager));
        commandHandler.registerCommand("VIEWOFFER",new ViewOfferCommand(inventoryManager));
        commandHandler.registerCommand("BILL", new GenerateBillCommand(inventoryManager));



        while(true)
        {

            String input=scanner.nextLine();
            if(input.equals("EXIT"))
            {
                return;
            }
            commandHandler.handleInput(input);
        }
        
    }
   
}


//Doubt: for view sales,stock,offer...there is no need of passing the input to the execute function..
//is it better to create a seperate interface and that should be inplemented in the CommandHandler and inventoryCommand 
