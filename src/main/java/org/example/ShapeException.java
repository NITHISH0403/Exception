package org.example;
import java.util.logging.*;
import java.util.*;

class Triangle
{
    int b;
    int h;
    int a;
    int c;
    String mylogger = "com.api.jar";
    Logger l = Logger.getLogger(mylogger);
    Triangle(int base, int height, int side1, int side2)
    {
        b = base;
        h = height;
        a = side1;
        c = side2;
        l.info("Triangle is Created...");
    }
    int perimeter()
    {
        return a+b+c;
    }
    int area()
    {
        return h*b/2;
    }
}
class Rectangle
{
    int b;
    int l;
    String mylogger = "com.api.jar";
    Logger l1 = Logger.getLogger(mylogger);
    Rectangle(int width, int length)
    {
        b = width;
        l = length;
        l1.info("Rectangle is Created...");
    }
    int perimeter()
    {
        return 2*(l+b);
    }
    int area()
    {
        return l*b;
    }
}
class Circle
{
    int r;
    String mylogger = "com.api.jar";
    Logger l = Logger.getLogger(mylogger);
    Circle(int radius)
    {
        r = radius;
        l.info("Circle is Created...");
    }
    int perimeter()
    {
        return r;
    }
    double area()
    {
        return 3.14*r*r;
    }
}
class ShapeException{
    public static void main (String[] args)
    {
        String mylogger = "com.api.jar";
        Logger l = Logger.getLogger(mylogger);
        Scanner s = new Scanner(System.in);
   
        while(true)
        {
            l.info("select your choice in \n1.Triangle \n2.Rectangle \n3.Circle");
            int ch = s.nextInt();
            if(ch == 1)
            {
                l.info("Enter the Base value:");
                int base = s.nextInt();

                l.info("Enter the Height value:");
                int height = s.nextInt();

                l.info("Enter the Side1 value:");
                int side1 = s.nextInt();

                l.info("Enter the Side2 value:");
                int side2 = s.nextInt();

                try {
                    Class.forName("org.example.Triangle");
                    Triangle t = new Triangle(base, height, side1, side2);
                    l.info("the perimeter of Triangle :" + t.perimeter());
                    l.info("the area of Triangle :" + t.area());
                }catch (ClassNotFoundException e){
                    l.log(Level.INFO, () -> "This class is not found. " + e);
                }
            }
            else if(ch == 2)
            {
                l.info("Enter the width value:");
                int width = s.nextInt();

                l.info("Enter the length value:");
                int length = s.nextInt();
                try {
                    Class.forName("org.example.Triangle");
                    Rectangle  r = new Rectangle(width, length);
                    l.info("the perimeter of Rectangle :" + r.perimeter());
                    l.info("the area  of Rectangle:" + r.area());
                }catch (ClassNotFoundException e){
                    l.log(Level.INFO, () -> "This class is not found. " + e);
                }
            }
            else if(ch == 3)
            {
                l.info("Enter the radius value:");
                int radius = s.nextInt();
                try {
                    Class.forName("org.example.Circle");
                    Circle c = new Circle(radius);
                    l.info("the perimeter of Circle :" + c.perimeter());
                    l.info("the area of Circle:" + c.area());
                }catch (ClassNotFoundException e){
                    l.log(Level.INFO, () -> "This class is not found. " + e);
                }

            }
            else
            {
                System.exit(0);
            }
        }
    }
}
