package org.example;

import java.util.logging.*;
import java.util.*;
import java.lang.*;

class Payment
{
    static Logger l=Logger.getLogger("My Logger");
    Payment (String name, int no)
    {
        l.info ("Hii\t" + name + "\tyour account will be created.");
        l.info ("Your account No is\t" + no);
    }

    double deposit (double d, double balance)
    {
        balance = balance + d;
        return balance;
    }

    double withdraw (double w, double balance)
    {
        balance = balance - w;
        return balance;
    }

    void amount (double balance)
    {
        l.info ("Your Current Balance :" + balance);
    }

}

class BankException
{
    public static void main (String[]arg)
    {
        Scanner s = new Scanner (System.in);
        Logger l=Logger.getLogger("My Logger");

        l.info("Enter the Holder Name:");
        String h_name = s.nextLine ();

        l.info("Enter the Account Number:");
        int a_no = 0;
        try {
            a_no = s.nextInt();
        }catch (InputMismatchException e){
            l.log(Level.INFO, () -> "User only input in Integer Value." + e);
            System.exit(0);
        }

        double balance = 0.0;
        double d_amt;
        double w_amt;

        Payment p = new Payment (h_name, a_no);

        while(true)
        {
            l.info("select your payment method \n1. Deposit \n2. Withdraw \n3. Balance \n0.Exit");
            int ch = s.nextInt ();
            switch (ch) {
                case 1 -> {
                    l.info("Your Deposit Amount :");
                    d_amt = s.nextDouble();
                    balance = p.deposit(d_amt, balance);
                    l.info("Your Current Balance :" + balance);
                }
                case 2 -> {
                    l.info("Your Withdraw Amount :");
                    w_amt = s.nextDouble();
                    if (balance < w_amt) {
                        l.info("Your Amount balance : " + balance + ". so, didn't withdraw Amount.");
                    } else {
                        balance = p.withdraw(w_amt, balance);
                        l.info("Your Current Balance :" + balance);
                    }
                }
                case 3 -> p.amount(balance);
                default -> System.exit(0);
            }
        }
    }

}