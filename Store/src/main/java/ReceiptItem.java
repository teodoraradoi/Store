public class ReceiptItem
{
    private String productName;
    private double pricePerUnit;
    private int quantity;
    private double total;
    
    
    public void setProductName(String _productName)
    {
        this.productName = _productName;
    }
    
     public void setPricePerUnit(double _pricePerUnit)
    {
        this.pricePerUnit = _pricePerUnit;
    }
     
    public void setQuanity(int _quantity)
    {
        this.quantity = _quantity;
    }
    
    public void setTotal(double _total)
    {
        this.total = _total;
    }
    
     public String getProductName()
    {
        return productName;
    }
    
     public double getPricePerUnit()
    {
        return pricePerUnit;
    }
     
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getTotal()
    {
       return total;
    }
    
    public void getTotalForProduct()
   {
        double sum = 0;
        sum = this.getPricePerUnit() * this.getQuantity();
        this.setTotal(sum);
   }
}
