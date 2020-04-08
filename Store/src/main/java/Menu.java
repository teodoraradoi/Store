import java.util.Scanner;

public class Menu
{
    public void UseAsAdministrator(Store store)
    {  
        try
        {
            boolean screen1 = true;
            while(screen1)
            {
                Scanner in1 = new Scanner(System.in);
                System.out.println("0. Back  1. Stock  2. Cash registers");
                int choice1 = in1.nextInt();
                 System.out.print("\n");

                switch(choice1)
                {
                    case 0: // Back
                    {
                        screen1 = false;
                        break;
                    }

                    case 1: // Stock
                    {
                        boolean screen2 = true;
                        while(screen2)
                        {
                            Scanner in2 = new Scanner(System.in);
                            System.out.println("0. Back  1. Add product  2. Remove product  3. View Stock  4. Update price  5. Modify stock");
                            int choice2 = in2.nextInt();
                            System.out.print("\n");

                            switch(choice2)
                            {
                                case 0: // Back
                                {
                                    screen2 = false;
                                    break;
                                }

                                case 1: // Add a product
                                {
                                    Product product = new Product();
                                    Scanner scanner1 = new Scanner(System.in);
                                    System.out.println("Input the name");
                                    String aux1 = scanner1.nextLine();
                                    System.out.print("\n");
                                    
                                    if(store.getStock().checkName(aux1))
                                    {
                                        System.out.println("The product already exists in stock. Enter the quantity you want to add.");
                                        Scanner scanner2 = new Scanner(System.in);
                                        int aux2 = scanner2.nextInt();
                                        store.getAdmins().get(0).modifyStock(store.getStock(), aux1, aux2, 1);
                                    }
                                    else
                                    {
                                        System.out.println("Input the description");
                                        String aux2 = scanner1.nextLine();
                                        System.out.print("\n");
                                        System.out.println("Input the price");
                                        double aux3 = scanner1.nextDouble();
                                        System.out.print("\n");
                                        System.out.println("Input the quantity");
                                        int aux4 = scanner1.nextInt();
                                        
                                        product.setProduct(aux1, aux2, aux3);
                                        store.getAdmins().get(0).addProductsToStock(store.getStock(), product, aux4);
                                    }
                                    System.out.print("\n");
                                    
                                    break;
                                }

                                case 2: // Remove product
                                {
                                    StockItem product = new StockItem();
                                    Scanner scanner2 = new Scanner(System.in);
                                    System.out.println("Input the name");
                                    String aux1 = scanner2.nextLine();
                                    System.out.print("\n");

                                    product.setStockItemName(aux1);
                                    store.getAdmins().get(0).removeProductsFromStock(store.getStock(), product);
                                    break;
                                }

                                case 3: // View stock
                                {
                                    store.getStock().printStockItems();
                                    break;
                                }

                                case 4: // Update price
                                {
                                    Scanner scanner3 = new Scanner(System.in);
                                    System.out.println("Input the name");
                                    String aux1 = scanner3.nextLine();
                                    System.out.print("\n");
                                    System.out.println("The price is " + store.getStock().getOldPrice(aux1) + "\n");
                                    System.out.println("Input the new price");
                                    double aux2 = scanner3.nextDouble();
                                    System.out.print("\n");

                                    store.getAdmins().get(0).updateProductPrice(store.getStock(), aux1, aux2);
                                    break;
                                }

                                case 5: // Modify stock
                                {
                                    Scanner scanner4 = new Scanner(System.in);
                                    System.out.println("Input the name");
                                    String aux1 = scanner4.nextLine();
                                    System.out.print("\n");
                                    System.out.println(aux1 + ": " + store.getStock().checkStock(aux1) + " left in stock.\n");
                                    System.out.println("Input the quantity");
                                    int aux2 = scanner4.nextInt();
                                    System.out.print("\n");
                                    System.out.println("Input 1 to add that quantity or 2 to remove that quantity");
                                    int option = scanner4.nextInt();
                                     System.out.print("\n");

                                    store.getAdmins().get(0).modifyStock(store.getStock(), aux1, aux2, option);
                                    break;
                               }
                            }
                        }
                        break;
                    }

                    case 2: // Cash registers
                    {
                        boolean screen3 = true;
                        while(screen3)
                        {
                            Scanner in3 = new Scanner(System.in);
                            System.out.println("0. Back  1. Add cash register  2. Remove cash register  3. View cash registers");
                            int choice3 = in3.nextInt();
                            System.out.print("\n");

                            switch(choice3)
                            {
                                case 0: // Back
                                {
                                    screen3 = false;
                                    break;
                                }

                                case 1: // Add cash register
                                {
                                    store.addNewCashRegister("Store", "#456");
                                    break;
                                }

                                case 2: // Remove cash register
                                {
                                    Scanner scanner3 = new Scanner(System.in);
                                    System.out.println("Input the index");
                                    int i = scanner3.nextInt();
                                    System.out.print("\n");

                                    store.removeCashRegister(i);
                                    break;
                                }

                                case 3: // View cash registers
                                {
                                    store.viewCashRegister();
                                    break;
                                }
                            }
                        }
                        
                        break;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid input\n");
        }
    }
    
    public void UseAsSeller(Store store)
    {
        try
        {   
            boolean screen4 = true;
            while(screen4)
            {
                Scanner in4 = new Scanner(System.in);
                System.out.println("0. Back  1. Start sell  2. Search product  3. View stock");
                int choice4 = in4.nextInt();
                System.out.print("\n");

                switch(choice4)
                {
                    case 0:
                    {
                        screen4 = false;
                        break;
                    }

                    case 1: // Start sell
                    {
                        store.getCashRegister().get(0).startNewSell(); // Change to register of choice...

                        boolean screen5 = true;
                        while(screen5)
                        {
                            Scanner in5 = new Scanner(System.in);
                            System.out.println("0. Back  1. Add product to sell  2. Remove product  3. View current sell  4. Finalize sell");
                            int choice5 = in5.nextInt();
                            System.out.print("\n");

                            switch(choice5)
                            {
                                case 0: // Back
                                {
                                    screen5 = false;
                                    break;
                                }

                                case 1: // Add product to sell
                                {
                                    Scanner scanner3 = new Scanner(System.in);
                                    System.out.println("Enter the name");
                                    String name = scanner3.nextLine();
                                    System.out.print("\n");
                                    System.out.println("Enter the quantity");
                                    int quantity = scanner3.nextInt();
                                    System.out.print("\n");

                                    if(store.getStock().checkName(name) == true)
                                    {
                                        if(store.getSellers().get(0).checkProductStock(store.getStock(), name, quantity) > 0)
                                        {
                                            store.getCashRegister().get(0).registerNewProduct(name, quantity, store.getStock());
                                        }
                                        else
                                        {
                                            System.out.println("We don't have enough.\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("We don't have that product.\n");
                                    }

                                    break;
                                }

                                case 2: // Remove product
                                {
                                    Scanner scanner4 = new Scanner(System.in);
                                    System.out.println("Enter the name");
                                    String name = scanner4.nextLine();
                                    System.out.print("\n");
                                    System.out.println("Enter 1 to remove the product entirely or 2 to decrease quantity");
                                    int option = scanner4.nextInt();
                                    System.out.print("\n");

                                    if(option == 1)
                                    {
                                        store.getCashRegister().get(0).removeProduct(name);
                                    }
                                    if(option == 2)
                                    {
                                        Scanner scanner5 = new Scanner(System.in);
                                        System.out.println("Enter the quantity");
                                        int quantity = scanner5.nextInt();
                                        System.out.print("\n");

                                        store.getCashRegister().get(0).removeQuantity(name, quantity);
                                    }

                                    break;
                                }

                                case 3: // View current sell
                                {
                                    store.getCashRegister().get(0).getReceipts().get(store.getCashRegister().get(0).getCurrentReceiptNo()).printReceiptItems();
                                    break;
                                }

                                case 4: // Finalize sell
                                {
                                    System.out.print("Receipt ID: ");
                                    System.out.println(store.getCashRegister().get(0).getCurrentReceiptNo() + 1);
                                    System.out.print("\n");
                                    store.getCashRegister().get(0).getReceipts().get(store.getCashRegister().get(0).getCurrentReceiptNo()).printReceiptItems();

                                    store.getCashRegister().get(0).finalizeSell(store.getCashRegister().get(0).getReceipts()
                                            .get(store.getCashRegister().get(0).getCurrentReceiptNo()), store.getStock());
                                    screen5 = false;
                                    break;
                                }
                            }
                        }

                        break;
                    }

                    case 2: // Search product
                    {
                        Scanner scanner4 = new Scanner(System.in);
                        System.out.println("Input the name");
                        String aux_name = scanner4.nextLine();
                        System.out.print("\n");

                        Product product = new Product();
                        product.setName(aux_name);

                        int aux = store.getSellers().get(0).checkProductStock(store.getStock(), aux_name, 1);
                        if(aux == -1)
                        {
                            System.out.println("We don't have that product in stock.\n");
                        }
                        else
                        {
                            System.out.println(product.getName() + ": " + aux + " left in stock\n");
                        }

                        break;
                    }

                    case 3: // View stock
                    {
                        store.getStock().printStockItems();
                        break;
                    }
                } 
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid input\n");
        }
    }
}
