import java.util.*;

public class Receipt
{
    private List<ReceiptItem> recieptItems = new ArrayList<>();
    
    
    public List<ReceiptItem> getReceiptItems()
   {
       return recieptItems;
   }
    
    public double getTotal()
   {
       double total = 0;
       for(int i = 0; i < recieptItems.size(); i++)
       {
           recieptItems.get(i).getTotalForProduct();
           total = total + recieptItems.get(i).getTotal();
       }
       return total;  
   }
    
    public void printReceiptItems()
   {
       for(int i = 0; i < recieptItems.size(); i++)
       {
           System.out.print("Item #");
           System.out.print(i+1);
           System.out.println(":\n");
           System.out.println("Name: " + recieptItems.get(i).getProductName());
           System.out.println("Quantity: " + recieptItems.get(i).getQuantity());
           System.out.println("Price per unit: " + recieptItems.get(i).getPricePerUnit() + "\n");
       }
       System.out.print("\n");
   }
    
}
