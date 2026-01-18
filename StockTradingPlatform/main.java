package StockTradingPlatform;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class main { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        // 1. Setup the Market
        ArrayList<stock> market = new ArrayList<>();
        market.add(new stock("AAPL", 150.0));
        market.add(new stock("TSLA", 700.0));
        market.add(new stock("GOOG", 2800.0));
        
        // 2. Setup the User
        user myuser = new user("rithu", 1000.0);
        
        System.out.println("Welcome to the Trading Platform!");

        // 3. The Game Loop
        while(true) {
            System.out.println("\n--- MARKET UPDATE ---");
            
            // Randomly update all stock prices
            for (stock s : market) {
                // Price fluctuates between -2% and +2%
                double change = 0.98 + (0.04 * rand.nextDouble()); 
                s.setPrice(s.getPrice() * change);
                System.out.println(s.getSymbol() + ": $" + String.format("%.2f", s.getPrice()));
            }

            System.out.println("\n1. Buy Stock  2. Sell Stock  3. View Portfolio  4. Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                // Show list of stocks to buy
                System.out.println("\nSelect stock to buy:");
                for (int i = 0; i < market.size(); i++) {
                    System.out.println(i + ": " + market.get(i).getSymbol());
                }
                int idx = input.nextInt();
                
                if(idx >= 0 && idx < market.size()) {
                    myuser.buyStock(market.get(idx));
                } else {
                    System.out.println("Invalid Selection!");
                }

            } else if (choice == 2) {
                // Sell by typing the name (e.g., AAPL)
                System.out.print("Enter the symbol of the stock to sell (e.g., AAPL): ");
                String sym = input.next(); 
                myuser.sellStockBySymbol(sym);

            } else if (choice == 3) {
                // Show what rithu owns
                myuser.showPortfolio();
                System.out.println("Current Balance: $" + String.format("%.2f", myuser.getBalance()));

            } else if (choice == 4) {
                System.out.println("Closing platform... Thankyou for visiting us!");
                break; 
            } else {
                System.out.println("Invalid option. Try again.");
            }
            for(stock s:market) {
            	double changePercent=(rand.nextDouble()*0.06)-0.03;
            	double newPrice=s.getPrice()*(1+changePercent);
            	s.setPrice(newPrice);
            	System.out.println(s.getSymbol()+": $"+String.format("%.2f",s.getPrice()));
            }
        } 
        
        input.close(); 
    } 
}