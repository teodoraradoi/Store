import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Menu menu = new Menu();
        Store store = new Store();
        store.setName("Store");
       
        store.addNewAdministrator("Admin", "+40...", "Craiova");
        store.addNewSeller("Seller", "+40...", "Craiova");
        store.addNewCashRegister("Store", "#456");
        
        boolean app = true;
        while(app)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                System.out.println("0. Exit  1. Use as administrator 2. Use as seller");
                int choice = scanner.nextInt();
                System.out.print("\n");

                switch(choice)
                {
                    case 0: // Exit
                    {
                        app = false;
                        break;
                    }

                    case 1: // Use as administrator
                    {
                        menu.UseAsAdministrator(store);
                        break;
                    }

                    case 2: // Use as seller
                    {
                        menu.UseAsSeller(store);
                        break;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Invalid input\n");
            }
        }
    }
}