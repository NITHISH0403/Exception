package org.example;

import java.util.logging.*;
import java.util.*;


class Point implements  cloneable{
    String x1 = String.valueOf(10);
    String y1 = String.valueOf(20);
    String x2;
    String y2;
    Logger l= Logger.getLogger("My Logger");
    Scanner s = new Scanner(System.in);
    Point()
    {
        l.info("Enter the Co-ordinate of X2 :");
        x2 =s.nextLine();

        l.info("Enter the Co-ordinate of Y2 :");
        y2 =s.nextLine();
    }

    //this method calls object clone().
    Point clonePoint() {
        try {
            //call clone in object.
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            l.info("Cloning not allowed");
            return this;
        }
    }
}
class BasicPointException {
    public static void main(String[] args) {

        Logger l = Logger.getLogger("My Logger");
        Point o1 = new Point();

        //call object clone() clone o1.
        Point o2 = o1.clonePoint();

        l.log(Level.INFO, () ->o1.x1 + " " + o1.y1 );
        if(o1.x1.equals(o2.x2) && o1.y1.equals(o2.y2)){
            l.info("Your Co-ordinates is True.");
            l.log(Level.INFO, () ->"x1:" + o1.x1 + " " + "y1:" + o1.y1);
            l.log(Level.INFO, () ->"x2:" + o1.x2 + " " + "y2:" +o1.y2);
        }
        else {
            l.info("Your Co-ordinates is False.");
            l.log(Level.INFO, () ->"x1:" + o1.x1 + " " + "y1:" + o1.y1);
            l.log(Level.INFO, () ->"x2:" + o1.x2 + " " + "y2:" + o1.y2);
        }

    }
}
