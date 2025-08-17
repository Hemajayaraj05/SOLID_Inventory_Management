import java.util.*;
public class CommandHandler{
   
    Map<String,Command> commandMap=new HashMap<>();
    public void registerCommand(String key,Command command)
    {
        commandMap.put(key.toUpperCase(),command);
    }

    public void handleInput(String input)
    {  
        String key=input.contains("=>")?input.split("=>")[0]:input;
        Command command=commandMap.get(key.toUpperCase());
        if (command!=null)
        {
            command.execute(input);
        } else
        {
            System.out.println("Invalid input");
        }

    }
}