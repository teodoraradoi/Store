import java.util.*;

public class CashRegister
{
    private int currentReceiptNo;
    private List<Receipt> receipts = new ArrayList<>();
    private String storeName;
    private String fiscalIdentifier;
    
    
    public CashRegister(String _storeName, String _fiscalIdentifier)
    {
        this.currentReceiptNo = 0;
        this.storeName = _storeName;
        this.fiscalIdentifier = _fiscalIdentifier;
    }
    
    public String getStoreName()
    {
        return storeName;
    }
    
    public String getFiscalIdentifier()
    {
        return fiscalIdentifier;
    }
    
    public List<Receipt> getReceipts()
    {
        return receipts;
    }
    
    public int getCurrentReceiptNo()
    {
        return currentReceiptNo;
    }
    
    public void startNewSell()
    {
        receipts.add(new Receipt());
    }
    
    public void registerNewProduct(String name, int quantity, Stock stock)
    {
        ReceiptItem item = new ReceiptItem();
        item.setProductName(name);
        item.setQuanity(quantity);
        
        for(int i = 0; i < stock.getStockItems().size(); i++)
        {
            String aux1 = stock.getStockItems().get(i).getStockItemName();
            String aux2 = item.getProductName();
            if(aux1.equals(aux2))
            {
                item.setPricePerUnit(stock.getStockItems().get(i).getPrice());
            }
        }
        receipts.get(getCurrentReceiptNo()).getReceiptItems().add(item);
    }
    
    public void removeProduct(String name)
    {
        for(int i = 0; i < receipts.get(currentReceiptNo).getReceiptItems().size(); i++)
        {
            String aux = receipts.get(currentReceiptNo).getReceiptItems().get(i).getProductName();
            if(aux.equals(name))
            {
                receipts.get(currentReceiptNo).getReceiptItems().remove(i);
            }
        }
    }
    
    public void removeQuantity(String name, int quantity)
    {
        int quant = 0;
        for(int i = 0; i < receipts.get(currentReceiptNo).getReceiptItems().size(); i++)
        {
            String aux = receipts.get(currentReceiptNo).getReceiptItems().get(i).getProductName();
            if(aux.equals(name))
            {
                quant = receipts.get(currentReceiptNo).getReceiptItems().get(i).getQuantity() - quantity;
                receipts.get(currentReceiptNo).getReceiptItems().get(i).setQuanity(quant);
                break;
            }
        }
    }

    public void finalizeSell(Receipt receipt, Stock stock)
    {
        currentReceiptNo++;
        for(int i = 0; i < stock.getStockItems().size(); i++)
        {
            for(int j = 0; j < receipt.getReceiptItems().size(); j++)
            {
                if(stock.getStockItems().get(i).getName().equals(receipt.getReceiptItems().get(j).getProductName()))
                    stock.getStockItems().get(i).updateAfterSell(receipt, stock, i);
            }
        }
        
        System.out.print("Total: ");
        System.out.println(receipt.getTotal() + "\n");
    }
}
