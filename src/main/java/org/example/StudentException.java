package org.example;

import java.util.*;
import java.util.logging.*;

// class representing custom exception.
class OutOfTotalException extends Exception{
    OutOfTotalException(String str){
        // calling the constructor of parent Exception
        super(str);
    }
}
class Process
{
    Logger l = Logger.getLogger("MY Logger");
    String studentname;
    int total;
    String gradelevel;
    int gpa = 0 ;
    Process(String sname, int tol)
    {
        studentname = sname;
        total = tol;
    }
    void updategrade(){
        if(total >= 450)
            gradelevel = "A";
        else if(total >= 350)
            gradelevel = "B";
        else if(total >= 300)
            gradelevel = "C";
        else if(total >= 250)
            gradelevel = "D";
        else
            gradelevel = "E";
    }
    void update()
    {
        if("A".equalsIgnoreCase(gradelevel))
            gpa = 5;
        else if("B".equalsIgnoreCase(gradelevel))
            gpa = 4;
        else if("C".equalsIgnoreCase(gradelevel))
            gpa = 3;
        else if("D".equalsIgnoreCase(gradelevel))
            gpa = 2;
        else
            gpa = 1;
    }
    String display()
    {
        l.log(Level.INFO, () -> studentname + " " + "has a" + " " + gradelevel + " " + "Grade");
        return studentname + " " + "has a" + " " + gpa + " "+ "GPA.";
    }
}

class  StudentException
{
    public static void main(String[] args) {
        Logger l = Logger.getLogger("My Logger");
        Scanner s = new Scanner(System.in);

        l.info("Enter the Student name :");
        String sname = s.nextLine();

        try {
            l.info("Enter the total :");
            int tol = s.nextInt();
            if (tol < 600) {
                Process p = new Process(sname, tol);
                p.updategrade();
                p.update();
                //use in Lambda method
                l.log(Level.INFO, p::display);
            }
            else{
                // throw an object of user defined exception
                throw new OutOfTotalException("Your Total is Out of Range. \n Please, Enter the below 600.");
            }
        }catch (OutOfTotalException e){
            // printing the message from OutOfTotalException object
            l.info(String.valueOf(e));
        }

    }
}
