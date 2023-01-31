package org.example;

import java.util.logging.*;
import java.util.*;


class Payment
{
    static Logger l=Logger.getLogger("My Logger");
    Payment (String name, int no)
    {
        l.log(Level.INFO, () ->"Hii\t" + name + "\tyour account will be created.");
        l.log(Level.INFO, () ->"Your account No is\t" + no);
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
        l.log(Level.INFO, () ->"Your Current Balance :" + balance);
    }

}

class BankException
{
    public static void main (String[]arg)
    {
        Scanner s = new Scanner (System.in);
        Logger l=Logger.getLogger("My Logger");

        l.info("Enter the Holder Name:");
        String hname = s.nextLine ();

        l.info("Enter the Account Number:");
        int ano = 0;
        try {
            ano = s.nextInt();
        }catch (InputMismatchException e){
            l.log(Level.INFO, () -> "User only input in Integer Value." + e);
            System.exit(0);
        }

        double balance = 0.0;
        double damt;
        double wamt;

        Payment p = new Payment (hname, ano);

        while(true)
        {
            l.info("select your payment method \n1. Deposit \n2. Withdraw \n3. Balance \n0.Exit");
            int ch = s.nextInt ();
            String currentBalance = "Your Current Balance :";
            switch (ch) {
                case 1 -> {
                    l.info("Your Deposit Amount :");
                    damt = s.nextDouble();
                    balance = p.deposit(damt, balance);
                    l.log(Level.INFO, () ->currentBalance + balance);
                }
                case 2 -> {
                    l.info("Your Withdraw Amount :");
                    wamt = s.nextDouble();
                    if (balance < wamt) {
                        l.log(Level.INFO, () ->"Your Amount balance : " + balance + ". so, didn't withdraw Amount.");
                    } else {
                        balance = p.withdraw(wamt, balance);
                        l.log(Level.INFO, () ->currentBalance + balance);
                    }
                }
                case 3 -> p.amount(balance);
                default -> System.exit(0);
            }
        }
    }

}
