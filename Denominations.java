/**
*	Denominations class stores how many money tthere are according to the denominations.
*	The denominations are segmented from coins of five, ten, to bills of 20, 50, 100, 200, and 500
*/
public class Denominations {
    private int fiveHundred = 0,
                twoHundred = 0,
                oneHundred = 0,
                fifty = 0,
                twenty = 0,
                ten = 0,
                five = 0,
                one = 0;
/**
*	The constructor Denominations instantiates the count of the bills per denomination
*	@param fiveh number of five hundred bills
*	@param twoh number of two hundred bills
*	@param oneh number of one hundred bills
*	@param fifty number of fifty bills
*	@param twenty number of twenty bills
*	@param ten number of ten coins
*	@param five number of five coins
*   @param one number of one coins
*/
    public Denominations(int fiveh,int  twoh,int  oneh,int  fifty,int  twenty,int  ten,int  five,int one){
        this.fiveHundred = fiveh;
       this.twoHundred = twoh;
        this.oneHundred = oneh;
        this.fifty = fifty;
        this.twenty = twenty;
        this.ten = ten;
        this.five = five;
        this.one = one;
    }

    //setters
/**
* setFiveHundred() sets the number of five hundred peso bills according to the amount parameter
* @param amount is the number of bills
*
*/
    public void setFiveHundred(int amount){
        this.fiveHundred = amount;
    }
    
/**
* setTwoHundred() sets the number of two hundred peso bills according to the amount parameter
* @param amount is the number of bills
*
*/
    public void setTwoHundred(int amount){
        this.twoHundred = amount;
    }
    
/**
* setOneHundred() sets the number of one hundred peso bills according to the amount parameter
* @param amount is the number of bills
*
*/
    public void setOneHundred(int amount){
        this.oneHundred = amount;
    }
    
/**
* setFifty() sets the number of fifty peso bills according to the amount parameter
* @param amount is the number of bills
*
*/
    public void setFifty(int amount){
        this.fifty = amount;
    }
    
/**
* setTwenty() sets the number of twenty peso bills according to the amount parameter
* @param amount is the number of bills
*
*/
    public void setTwenty(int amount){
        this.twenty = amount;
    }
    
/**
* setTen() sets the number of ten coins according to the amount parameter
* @param amount is the number of bills
*
*/
    public void setTen(int amount){
        this.ten = amount;
    }
    
/**
* setFive() sets the number of five coins according to the amount parameter
* @param amount is the number of bills
*
*/
    public void setFive(int amount){
        this.five = amount;
    }

/**
* setFive() sets the number of one coins according to the amount parameter
* @param amount is the number of bills
*
*/
    public void setOne(int amount){
        this.one = amount;
    }

  //getters
    /**
     * the getter method for the five hundred denomination
     * @return the number of five hundred denomination
     */
    public int getFiveHundred(){
        return this.fiveHundred;
    }

    /**
     * the getter method for the two hundred denomination
     * @return the number of two hundred denomination
     */
    public int getTwoHundred(){
        return this.twoHundred;
    }

    /**
     * the getter method for the one hundred denomination
     * @return the number of one hundred denomination
     */
    public int getOneHundred(){
        return this.oneHundred;
    }

    /**
     * the getter method for the fifty denomination
     * @return the number of fifty denomination
     */
    public int getFifty(){
        return this.fifty;
    }

    /**
     * the getter method for the twenty denomination
     * @return the number of twenty denomination
     */
    public int getTwenty(){
        return this.twenty;
    }

    /**
     * the getter method for the ten denomination
     * @return the number of ten denomination
     */
    public int getTen(){
        return this.ten;
    } 

    /**
     * the getter method for the five denomination
     * @return the number of five denomination
     */
    public int getFive(){
        return this.five;
    }

    /**
     * the getter method for the one denomination
     * @return the number of one denomination
     */
    public int getOne(){
        return this.one;
    }
    
}
