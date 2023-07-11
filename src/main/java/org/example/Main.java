package org.example;
import java.util.Scanner;

public class Main {
    //class for our numbers
    static public class Num{
        int numerator;
        int denominator;

         public Num(){
             numerator = 0;
             denominator = 1;
         };
         public Num(String num){
             try {
                 numerator = Integer.parseInt(num);
                 denominator = 1;
             } catch (NumberFormatException e){
                 String[] buff_prc = num.split("/");
                 numerator = Integer.parseInt(buff_prc[0]);
                 denominator = Integer.parseInt(buff_prc[1]);
                 if(numerator > 0 && denominator < 0){
                     numerator *= -1;
                     denominator *= -1;
                 }
             }
         };
    }
    //num reader func
    public static void read_num(Num num){
        Scanner in = new Scanner(System.in);
        String buff;
        //try to read it, with exceptions
        System.out.println("Enter number");
        buff = in.next();
        try {
            num.numerator = Integer.parseInt(buff);
        } catch (NumberFormatException e){
            String[] buff_prc = buff.split("/");
            num.numerator = Integer.parseInt(buff_prc[0]);
            num.denominator = Integer.parseInt(buff_prc[1]);
            if(num.numerator > 0 && num.denominator < 0){
                num.numerator *= -1;
                num.denominator *= -1;
            }
        }
    }
    //our calculator
    public static void calculations(String operation, Num first_num, Num second_num, Num ans){
        switch (operation){
            case "+":
                if(Math.abs(first_num.denominator) == Math.abs(second_num.denominator)){
                    ans.numerator = first_num.numerator + second_num.numerator;
                    ans.denominator = first_num.denominator;
                }
                else{
                    ans.numerator = first_num.numerator * second_num.denominator + second_num.numerator * first_num.denominator;
                    ans.numerator = first_num.denominator * second_num.denominator;
                }
                break;
            case "-":
                if(Math.abs(first_num.denominator) == Math.abs(second_num.denominator)){
                    ans.numerator = first_num.numerator - second_num.numerator;
                    ans.denominator = first_num.denominator;
                }
                else{
                    ans.numerator = first_num.numerator * second_num.denominator - second_num.numerator * first_num.denominator;
                    ans.numerator = first_num.denominator * second_num.denominator;
                }
                break;
            case "*":
                ans.numerator = first_num.numerator * second_num.numerator;
                ans.denominator = first_num.denominator * second_num.denominator;
                break;
            case "/":
                ans.numerator = first_num.numerator * second_num.denominator;
                ans.denominator = first_num.denominator * second_num.numerator;
                break;
            //if user write wrong operation print message about it
            default:
                System.out.println("Wrong operation");
                return;
        }
    }

    //answer output
    public static void answerConsole(Num ans){
        if(ans.numerator == 0){
            System.out.println(0);
        } else if (ans.numerator%ans.denominator == 0) {
            System.out.println(ans.numerator/ans.denominator);
        }
        else{
            if(ans.denominator % ans.numerator == 0) System.out.println("1/" + ans.denominator/ ans.numerator);
            else System.out.println(ans.numerator + "/" + ans.denominator);
        }
    }
    public static String getAnswer(Num ans){
        String temp;
        if(ans.numerator == 0){
            temp = "0";
        } else if (ans.numerator%ans.denominator == 0) {
            temp = String.valueOf(ans.numerator/ans.denominator);
        }
        else{
            if(ans.denominator % ans.numerator == 0) temp =  "1/" + String.valueOf(ans.denominator/ ans.numerator);
            else temp = String.valueOf(ans.numerator) + "/" + String.valueOf(ans.denominator);
        }
        return temp;
    }
    public static void main(String[] args) {
        //add scanner in
        Scanner in = new Scanner(System.in);

        //initialize numbers and operation
        Num first_num = new Num();
        Num second_num = new Num();
        Num ans = new Num();
        String operation;

        //read data
        read_num(first_num);
        System.out.println("Enter operation");
        operation = in.next();
        read_num(second_num);

        //try to catch error, divide by zero
        if(first_num.denominator == 0 || second_num.denominator == 0){
            System.out.println("One of denominators equal zero");
            return;
        }

        //calculations
        calculations(operation, first_num, second_num, ans);

       //answer output
        answerConsole(ans);

    }
}