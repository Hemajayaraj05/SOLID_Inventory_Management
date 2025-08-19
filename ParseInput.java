import java.util.*;
public class ParseInput
{
    public ParsedInventory parseInventoryInput(String input)
    {
           String[] parts=input.split("=>")[1].split("\\|");
           Product product=new Product(   parts[0], parts[1],Double.parseDouble(parts[3]));
           int quantity= Integer.parseInt(parts[2]);//lets see after
           return new ParsedInventory(product,quantity);
    }


    public List<Sale> parseSalesInput(String input)
    {

        String[] data=input.split("=>");
        String[] values=data[1].split(";");
        List<Sale> sales=new ArrayList<>();
        for(String value:values)
        {
            String[] pair=value.split("\\|");
            Sale sale=new Sale(pair[0],Integer.parseInt(pair[1]));
            sales.add(sale);

        }
        return sales;
       
    }

    public List<Offer> parseOfferInput(String input)
    {
         String[] data=input.split("=>");
        String[] values=data[1].split(";");
        List<Offer> offers=new ArrayList<>();
        for(String value:values)
        {
            String[] pair=value.split("\\|");
            Offer offer= new Offer(pair[0],pair[1],pair[2],Integer.parseInt(pair[3]),pair[4]);
            offers.add(offer);

        }
        return offers;
    }
}