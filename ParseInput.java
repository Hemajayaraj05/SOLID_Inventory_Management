public class ParseInput
{
    public Product parseInventoryInput(String input)
    {
           String[] parts=input.split("=>")[1].split("\\|");
           return new Product(
            parts[0], 
            parts[1], 
            Integer.parseInt(parts[2]), 
            Double.parseDouble(parts[3])
        );
    }


    public Sale parseSalesInput(String input)
    {

        String[] parts=input.split("=>")[1].split("\\|");
        return new Sale(
            parts[0], 
            Integer.parseInt(parts[1])
        );
    }
}