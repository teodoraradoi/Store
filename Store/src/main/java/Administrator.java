public class Administrator extends EmployeeInfo
{   
    public Administrator(String name, String phoneNo, String adress)
    {
        this.name = name;
        this.phoneNo = phoneNo;
        this.adress = adress;
    }
    
    public void addProductsToStock(Stock stock, Product product, int quantity)
    {
        stock.addProduct(product, quantity);
    }
    
    public int checkProductStock(Stock stock, String name)
    {
        return stock.checkStock(name);
    }
    
    public void removeProductsFromStock(Stock stock, StockItem product)
    {
        stock.removeProducts(product);
    }
    
    public void modifyStock(Stock stock, String name, int quantity, int option)
    {
        stock.modifyStock(name, quantity, option);
    }
    
    public void updateProductPrice(Stock stock, String name, double price)
    {
        stock.updatePrice(name, price);
    }
}
