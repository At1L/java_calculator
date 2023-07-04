package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //add scanner in
        Scanner in = new Scanner(System.in);
        //initialize numbers and operation
        int first_num = 0, second_num = 0;
        String operation, buff;
        //try to read it, with exceptions
        System.out.println("Enter first number");
        buff = in.next();
        try {
            first_num = Integer.parseInt(buff);
        } catch (NumberFormatException e){
            System.out.println("You enter not a number");
            return;
        }
        System.out.println("Enter operation");
        operation = in.next();
        System.out.println("Enter second number");
        buff = in.next();
        try {
            second_num = Integer.parseInt(buff);
        } catch (NumberFormatException e){
            System.out.println("You enter not a number");
            return;
        }
        //our calculator
        switch (operation){
            case "+":
                System.out.println(first_num + second_num);
                break;
            case "-":
                System.out.println(first_num - second_num);
                break;
            case "*":
                System.out.println(first_num * second_num);
                break;
            case "/":
                //exception if second number equal zero
                if(second_num != 0){
                    System.out.println(first_num / second_num);
                }
                else{
                    System.out.println("You can`t divide by zero");
                }
                break;
            //if user write wrong operation print message about it
            default:
                System.out.println("Wrong operation");
                break;
        }

    }
}