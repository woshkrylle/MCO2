import java.util.*;

/**
 * This class represents a Regular vending machine. 
 * A user can call its methods to simulate a purchasing
 * from a regular vending machine.
 * @author Kurt Hugo and Nauj Agbayani
 * @version 1.1
 */
public class RegularVendingMachine{    
    /**
     * balance stores the denominations that the vending machine has
     */
    private Denominations balance = new Denominations(100,100,100,100,100,100,100);
    
    /**
     * change stores the denominations that the user has for their change
     */
    private Denominations change =  new Denominations(0, 0, 0, 0, 0, 0, 0);
    
    /**
     * slots is an array list that contains each slot that can contain item objects
     */
    private ArrayList<Item> slots = new ArrayList<>();

    /**
     * transaction is an object that represents the current transaction that the user is having
     */
    private Transaction transaction = new Transaction();

    /**
     * tracks how many items are in array list slots, so that it doesn't go over 20
     */
    private int productAmount = 0;

    /**
     * Scanner object sc is used to allow the user to have inputs
     */
    Scanner sc = new Scanner(System.in);

    /**
     *  Adds an item to the inventory.
     * @param name the name of the item
     * @param price the price of the item
     * @param qty the quantity of the item
     * @param cal the calorie content of the item
     */
    public void addItems(String name, int price, int qty, int cal){
        if(productAmount<20){
            Item product = new Item(name, price, qty, cal);
            slots.add(product);
        }else System.out.println("Item Slots Full");
    }

    /**
     * Creates a new transaction, and facilitates the vending functions of the vending machine.
     */
    public void addTransaction(){
        transaction = new Transaction();
        receivePay();
        buy();
        if(checkChange(transaction.getPaymentTotal()-transaction.getPriceTotal())==true){
            System.out.println("===================");
            System.out.println("Purchase Successful");
            System.out.println("===================");
            System.out.println("No. of Items: "+transaction.getItemCount());
            System.out.println("Total Payment: "+transaction.getPaymentTotal());
            System.out.println("Total Price: "+transaction.getPriceTotal());
            System.out.println("Change: "+(transaction.getPaymentTotal()-transaction.getPriceTotal()));
            System.out.println("Calories: "+transaction.getCaloriesTotal());
        }else System.out.println("Not enough change; Transaction ended.");
    }
    
    /**
     * Receives payment from the user for the transaction.
     * Each denomination is specified instead of receiving a grand total.
     */
    public void receivePay(){
        int amount = 0, choice = -1;
        System.out.println("Total Paid: "+transaction.getPaymentTotal());
        while(choice!=0){
            System.out.println("\nInsert Denomination:");
            System.out.println("[1] Five Pesos");
            System.out.println("[2] Ten Pesos");
            System.out.println("[3] Twenty Pesos");
            System.out.println("[4] Fifty Pesos");
            System.out.println("[5] One Hundred Pesos");
            System.out.println("[6] Two Hundred Pesos");
            System.out.println("[7] Five Hundred Pesos");
            System.out.println("[0] Proceed to Menu");
            System.out.print("Please select a number: ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice != 0) {
                System.out.print("How many of this denomination? ");
                amount = sc.nextInt();
                sc.nextLine();
            }
            switch(choice){
                case 1: 
                    balance.addFive(amount);
                    transaction.addPaymentTotal(5*amount);
                    break;
                case 2: 
                    balance.addTen(amount);
                    transaction.addPaymentTotal(10*amount);
                    break;
                case 3: 
                    balance.addTwenty(amount);
                    transaction.addPaymentTotal(20*amount);
                    break;
                case 4: 
                    balance.addFifty(amount);
                    transaction.addPaymentTotal(50*amount);
                    break;
                case 5: 
                    balance.addOneHundred(amount);
                    transaction.addPaymentTotal(100*amount);
                    break;
                case 6: 
                    balance.addTwoHundred(amount);
                    transaction.addPaymentTotal(200*amount);
                    break;
                case 7: 
                    balance.addFiveHundred(amount);
                    transaction.addPaymentTotal(500*amount);
                    break;
            }
            System.out.println("Total Paid: "+transaction.getPaymentTotal());
        }
    }
    
    /**
     * Allows the user to select from previously added Items.
     * The user can buy as much as they want until they run out of funds or the vending machine runs out of stock
     */
    public void buy(){
        int choice = -1;
        while(choice!=0){
            for(int i = 0; i < this.slots.size(); i++){
                Item p = this.slots.get(i);
                System.out.println("["+(i+1)+"] "+p.getName()+": P" + p.getPrice()+" "+p.getCalories()+" kcal ["+p.getQuantity()+"/20]");
            }
            System.out.println("[0] Exit/Checkout Cart");
            System.out.println("Current balance: P"+(transaction.getPaymentTotal()-transaction.getPriceTotal()));
            System.out.println("Current price: P"+transaction.getPriceTotal());
            System.out.println("Current calories: "+transaction.getCaloriesTotal()+" kCal");
            System.out.print("Select A Number: ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice!=0){
                Item p = this.slots.get(choice-1);
                if(p.getQuantity()>0){
                    if(this.transaction.getPaymentTotal()>=this.transaction.getPriceTotal()){        
                        p.setQuantity(p.getQuantity()-1);
                        this.transaction.addItem(p);
                    } else System.out.println("Error: Insufficient Funds");
                } else System.out.println("Error: No Stocks Left");
            }
        }
    }

    /**
     * Checks if the change can be provided by the vending machine.
     *
     * @param c the amount of change
     * @return true if change can be provided, false otherwise
     */
    public boolean checkChange(int c){
        change =  new Denominations(0, 0, 0, 0, 0, 0, 0);
        int bFiveh = balance.getFiveHundred(), 
            bTwoh = balance.getTwoHundred(), 
            bOneh = balance.getOneHundred(), 
            bFifty = balance.getFifty(), 
            bTwenty = balance.getTwenty(), 
            bTen = balance.getTen(), 
            bFive = balance.getFive();

        
        while(bFiveh>0 && c>=500){
            c -= 500;
            bFiveh--;
            this.change.addFiveHundred(1);
        }
        while(bTwoh>0 && c>=200){
            c -= 200;
            bTwoh--;
            this.change.addTwoHundred(1);
        }
        while(bOneh>0 && c>=100){
            c -= 100;
            bOneh--;
            this.change.addOneHundred(1);
        }
        while(bFifty>0 && c>=50){
            c -= 50;
            bFifty--;
            this.change.addFifty(1);
        }
        while(bTwenty>0 && c>=20){
            c -= 20;
            bTwenty--;
            this.change.addTwenty(1);
        }
        while(bTen>0 && c>=10){
            c -= 10;
            bTen--;
            this.change.addTen(1);
        }
        while(bFive>0 && c>=5){
            c -= 5;
            bFive--;
            this.change.addFive(1);
        }
        if(c == 0){
            setBalance(bFiveh, bTwoh, bOneh, bFifty, bTwenty, bTen, bFive);
            return true;
        } else return false;
    }
    
    /**
     * Replenishes the stocks of the vending machine to the maximum (20)
     */
    public void replenishStocks(){
        int choice = 100;
        while(choice != 0 ){
            for(int i = 0; i < slots.size(); i++){
                Item p = slots.get(i);
                System.out.println("["+(i+1)+"] "+p.getName()+" ["+p.getQuantity()+"/20]");
            }
            System.out.println("[0] Exit");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice!=0) slots.get(choice-1).setQuantity(20);
        }
    }

    /**
     * Allows for the price of previously added items to be changed.
     */
    public void changePrice(){
        int choice = -1;
        int price;
        while(choice != 0 ){
            for(int i = 0; i < slots.size(); i++){
                Item p = slots.get(i);
                System.out.println("["+(i+1)+"] "+p.getName()+": P" + p.getPrice());
            }
            System.out.println("[0] Exit");
            System.out.print("Please select a number: ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice!=0){
                System.out.print("Please set the new price (Multiples of 5): ");
                do{
                    price = sc.nextInt();
                    sc.nextLine();
                }while(price%5>0);
                slots.get(choice-1).setPrice(price);
            }
        }
    }
    /**
     * Replenishes the change in the vending machine if any denomination is less than 100
     */
    public void replenishChange(){
        System.out.print("Five Hundred ("+balance.getTwoHundred()+") -> (");
        if(balance.getFiveHundred()<100) this.balance.setFiveHundred(100);
        System.out.println(balance.getFiveHundred()+")");

        System.out.print("Two Hundred ("+balance.getTwoHundred()+") -> (");
        if(balance.getTwoHundred()<100) this.balance.setTwoHundred(100);
        System.out.println(balance.getTwoHundred()+")");

        System.out.print("One Hundred ("+balance.getOneHundred()+") -> (");
        if(balance.getOneHundred()<100) this.balance.setOneHundred(100);
        System.out.println(balance.getOneHundred()+")");

        System.out.print("Fifty ("+balance.getFifty()+") -> (");
        if(balance.getFifty()<100) this.balance.setFifty(100);
        System.out.println(balance.getFifty()+")");

        System.out.print("Twenty ("+balance.getTwenty()+") -> (");
        if(balance.getTwenty()<100) this.balance.setTwenty(100);
        System.out.println(balance.getTwenty()+")");

        System.out.print("Ten ("+balance.getTen()+") -> (");
        if(balance.getTen()<100) this.balance.setTen(100);
        System.out.println(balance.getTen()+")");

        System.out.print("Five ("+balance.getFive()+") -> (");
        if(balance.getFive()<100) this.balance.setFive(100);
        System.out.println(balance.getFive()+")");
    }

    /**
     * Collects denominations if they exceed 100
     */
    public void collectMoney(){
        System.out.print("Five Hundred ("+balance.getTwoHundred()+") -> (");
        if(balance.getFiveHundred()>100) this.balance.setFiveHundred(100);
        System.out.println(balance.getFiveHundred()+")");

        System.out.print("Two Hundred ("+balance.getTwoHundred()+") -> (");
        if(balance.getTwoHundred()>100) this.balance.setTwoHundred(100);
        System.out.println(balance.getTwoHundred()+")");

        System.out.print("One Hundred ("+balance.getOneHundred()+") -> (");
        if(balance.getOneHundred()>100) this.balance.setOneHundred(100);
        System.out.println(balance.getOneHundred()+")");

        System.out.print("Fifty ("+balance.getFifty()+") -> (");
        if(balance.getFifty()>100) this.balance.setFifty(100);
        System.out.println(balance.getFifty()+")");

        System.out.print("Twenty ("+balance.getTwenty()+") -> (");
        if(balance.getTwenty()>100) this.balance.setTwenty(100);
        System.out.println(balance.getTwenty()+")");

        System.out.print("Ten ("+balance.getTen()+") -> (");
        if(balance.getTen()>100) this.balance.setTen(100);
        System.out.println(balance.getTen()+")");

        System.out.print("Five ("+balance.getFive()+") -> (");
        if(balance.getFive()>100) this.balance.setFive(100);
        System.out.println(balance.getFive()+")");
    }

    /**
     * Sets the balance of denominations in the vending machine.
     *
     * @param fiveh  the quantity of five hundred peso bills
     * @param twoh   the quantity of two hundred peso bills
     * @param oneh   the quantity of one hundred peso bills
     * @param fifty  the quantity of fifty peso bills
     * @param twenty the quantity of twenty peso bills
     * @param ten    the quantity of ten peso coins
     * @param five   the quantity of five peso coins
     */
    public void setBalance(int fiveh, int twoh, int oneh, int fifty, int twenty, int ten, int five) {
        this.balance.setFiveHundred(fiveh);
        this.balance.setTwoHundred(twoh);
        this.balance.setOneHundred(oneh);
        this.balance.setFifty(fifty);
        this.balance.setTwenty(twenty);
        this.balance.setTen(ten);
        this.balance.setFive(five);
    }
}