/**
*	Denominations class stores how many money tthere are according to the denominations.
*	The denominations are segmented from coins of five, ten, to bills of 20, 50, 100, 200, and 500
*	@author Kurt Hugo and Nauj Agbayani
*	@version 1.1
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
    public int getFiveHundred(){
        return this.fiveHundred;
    }
    public int getTwoHundred(){
        return this.twoHundred;
    }
    public int getOneHundred(){
        return this.oneHundred;
    }
    public int getFifty(){
        return this.fifty;
    }
    public int getTwenty(){
        return this.twenty;
    }
    public int getTen(){
        return this.ten;
    }   
    public int getFive(){
        return this.five;
    }
    public int getOne(){
        return this.one;
    }
    
}
