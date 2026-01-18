package StockTradingPlatform;
import java.util.ArrayList;

public class user {
	private String name;
	private double balance;
	private ArrayList<stock>portfolio;
	public user(String name,double balance)
	{
		this.name=name;
		this.balance=balance;
		this.portfolio=new ArrayList<stock>();
}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void buyStock(stock s) {
		if(this.balance>=s.getPrice()) {
			this.balance=this.balance - s.getPrice();
			this.portfolio.add(s);
			System.out.println(this.name+" bought "+s.getSymbol()+" successfully!");
		}
		else {
			System.out.println("Insufficient funds!");
		}
	}
	public void showPortfolio() {
		System.out.println("--- "+ this.name+"'s Portfolio ---");
		for(stock s:this.portfolio) {
			System.out.println("- "+s.getSymbol());
		}
	}
	// This is the method main.java is looking for!
    public void sellStockBySymbol(String symbol) {
        stock stockToSell = null;

        // 1. Search the portfolio for a stock that matches the name
        for (stock s : this.portfolio) {
            if (s.getSymbol().equalsIgnoreCase(symbol)) {
                stockToSell = s;
                break; // Found it, stop the loop
            }
        }

        // 2. If we found it, remove it and give back the money
        if (stockToSell != null) {
            this.portfolio.remove(stockToSell);
            this.balance = this.balance + stockToSell.getPrice();
            System.out.println(this.name + " sold " + symbol + " successfully!");
        } else {
            // 3. If we didn't find it, tell the user
            System.out.println("You don't own any " + symbol + "!");
        }
    }
}
