package org.example;

import java.util.*;
import java.util.logging.*;

class Card implements cloneable
{
    Logger l = Logger.getLogger("MY Logger");
    Scanner s = new Scanner(System.in);
    String hname = "NITHISH KUMAR M";
    String cno = "1234567890123456";
    String vto = "12/27";
    String holderName;
    String cardNo;
    String validTo;
    Card()
    {
        l.info("Enter the Holder name :");
        holderName = s.nextLine();

        l.info("Enter the Card No :");
        cardNo = s.nextLine();

        l.info("Enter the Expired Date");
        validTo = s.nextLine();
    }
    //This method calls Object clone();
    Card cloneCard(){
        try{
            //call clone in object.
            return (Card) super.clone();
        }catch (CloneNotSupportedException e){
            l.info("Cloning not allowed");
            return this;
        }
    }
}

class  CreditCardException
{
    public static void main(String[] args)
    {
        Logger l = Logger.getLogger("My Logger");
        Card o1 = new Card();
        //call object clone().
        //clone o1.
        Card o2 = o1.cloneCard();
        
        String holdername = "Holder Name :" ;
        String cardno = "Card No :";

        l.log(Level.INFO, () -> holdername + o1.hname + " " + cardno + o1.cno + " " + "Valid To:" + o1.vto );
        if(o1.hname.equals(o2.holderName) && o1.cno.equals(o2.cardNo) && o1.vto.equals(o2.validTo)){
            l.info("Your Co-ordinates is True.");
            l.log(Level.INFO, () -> holdername + o1.hname + " " + cardno + "y1:" + o1.cno);
            l.log(Level.INFO, () -> holdername + o1.holderName + " " + cardno +o1.cardNo);
        }
        else {
            l.info("Your Co-ordinates is False.");
            l.log(Level.INFO, () -> holdername + o1.holderName + " " + cardno + o1.cardNo);
            l.log(Level.INFO, () -> holdername + o1.hname + " " + cardno + o1.cno);
        }

    }
}
