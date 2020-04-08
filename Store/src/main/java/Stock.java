import java.util.*;

public class Stock
{
   private List<StockItem> stockItems = new ArrayList<>();
    
   
   public List<StockItem> getStockItems()
   {
       return this.stockItems;
   }
   
   public void addProduct(Product product, int quantity)
   {
       StockItem stockItem = new StockItem();
       stockItem.setStockItem(product, quantity);
       stockItems.add(stockItem);
   }
   
   public void updatePrice(String name, double price)
   {
       for(int i = 0; i < stockItems.size(); i++)
       {
           if(stockItems.get(i).getName().equals(name))
           {
              stockItems.get(i).setPrice(price);
           }
           break;
       }
   }
   
   public double getOldPrice(String name)
   {
       double aux = 0;
        for(int i = 0; i < stockItems.size(); i++)
        {
            if(stockItems.get(i).getName().equals(name))
            {
                aux = stockItems.get(i).getPrice();
            }
        }
        return aux;
   }
   
   public void removeProducts(StockItem product)
    {
        for(int i = 0; i < this.getStockItems().size(); i++)
        {
            if(this.getStockItems().get(i).getName().equals(product.getName()))
            {
                this.getStockItems().remove(this.getStockItems().get(i));
            }
        }
    }
   
   public void modifyStock(String name, int quantity, int option)
    {
        int aux = 0;
        for(int i = 0; i < this.getStockItems().size(); i++)
        {
            String aux1 = this.getStockItems().get(i).getName();
            if(aux1.equals(name))
            {
                if(option == 1)
                {
                    aux = this.getStockItems().get(i).getQuantity() + quantity;
                }
                if(option == 2)
                {
                    aux = this.getStockItems().get(i).getQuantity() - quantity;
                }
                
                this.getStockItems().get(i).setQuantity(aux);
                break;
            }
        }
    }
   
   public void printStockItems()
   {
       for(int i = 0; i < stockItems.size(); i++)
       {
           System.out.print("Item #");
           System.out.println(i+1);
           System.out.println("Name: " + stockItems.get(i).getName());
           System.out.println("Description: " + stockItems.get(i).getDescription());
           System.out.println("Price: " + stockItems.get(i).getPrice());
           System.out.println("Quantity: " + stockItems.get(i).getQuantity());
           System.out.print("\n");
       }
   }
   
   public int checkStock(String name)
   {
       int aux = 0;
        for(int i = 0; i < this.getStockItems().size(); i++)
        {
            String aux1 = this.getStockItems().get(i).getName();
            if(aux1.equals(name))
            {
                aux = this.getStockItems().get(i).getQuantity();
                break;
            }
        }
        return aux;
   }
   
    public boolean checkName(String name)
    {
        for(int i = 0; i < this.getStockItems().size(); i++)
        {
            if(this.getStockItems().get(i).getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }
}
