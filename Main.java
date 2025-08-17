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