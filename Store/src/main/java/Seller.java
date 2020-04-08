public class Seller extends EmployeeInfo
{
    public Seller(String name, String phoneNo, String adress)
    {
        this.name = name;
        this.phoneNo = phoneNo;
        this.adress = adress;
    }
    
    public int checkProductStock(Stock stock, String name, int quantity)
    {
        if(stock.checkStock(name) >= quantity)
        {
            return stock.checkStock(name);
        }
        return -1;
    }
}
