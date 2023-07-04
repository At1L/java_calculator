package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //add scanner in
        Scanner in = new Scanner(System.in);
        //initialize numbers and operation
        int first_num = 0, second_num = 0;
        int first_numerator = 0, first_denominator = 1;
        int second_numerator = 0, second_denominator = 1;
        String operation, buff;
        //try to read it, with exceptions
        System.out.println("Enter first number");
        buff = in.next();
        try {
            first_numerator = Integer.parseInt(buff);
        } catch (NumberFormatException e){
            String[] buff_prc = buff.split("/");
            first_numerator = Integer.parseInt(buff_prc[0]);
            first_denominator = Integer.parseInt(buff_prc[1]);
        }
        System.out.println("Enter operation");
        operation = in.next();
        System.out.println("Enter second number");
        buff = in.next();
        try {
            second_numerator = Integer.parseInt(buff);
        } catch (NumberFormatException e){
            String[] buff_prc = buff.split("/");
            second_numerator = Integer.parseInt(buff_prc[0]);
            second_denominator = Integer.parseInt(buff_prc[1]);
        }

        if(first_denominator == 0 || second_denominator == 0){
            System.out.println("One of denominators equal zero");
            return;
        }

        //our calculator
        int ans_numerator = 0, ans_denominator = 1;
        switch (operation){
            case "+":
                if(Math.abs(first_denominator) == Math.abs(second_denominator)){
                    ans_numerator = first_numerator + second_numerator;
                    ans_denominator = first_denominator;
                }
                else{
                    ans_numerator = first_numerator * second_denominator + second_numerator * first_denominator;
                    ans_numerator = first_denominator * second_denominator;
                }
                break;
            case "-":
                if(Math.abs(first_denominator) == Math.abs(second_denominator)){
                    ans_numerator = first_numerator - second_numerator;
                    ans_denominator = first_denominator;
                }
                else{
                    ans_numerator = first_numerator * second_denominator - second_numerator * first_denominator;
                    ans_numerator = first_denominator * second_denominator;
                }
                break;
            case "*":
                ans_numerator = first_numerator * second_numerator;
                ans_denominator = first_denominator * second_denominator;
                break;
            case "/":
                ans_numerator = first_numerator * second_denominator;
                ans_denominator = first_denominator * second_numerator;
                break;
            //if user write wrong operation print message about it
            default:
                System.out.println("Wrong operation");
                return;
        }
        System.out.println(ans_numerator + "/" + ans_denominator);

    }
}