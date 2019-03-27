package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static final String CONNECTION_STRING= "jdbc:sqLite:/Users/Sarthak/Desktop/DatabasePopulater/testjava1.db";
    public static final Queries queries = new Queries();
    public static void main(String[] args) {



        queries.openFile("maleFirstNames.txt");
        queries.readFile();
        queries.closeFile();

       menu();


    }

    public static void printArrays(String[] arr)
    {
        for(int i = 0; i<arr.length; i++)
        {
            System.out.println(arr[i]);
        }

    }





    public static void menu()
    {

        boolean status = true;
        int menuChoice;
        int totAtt;
        Scanner sc = new Scanner(System.in);
        System.out.println("SELECT AN OPTION: " +
                "\n1)CREATE TABLE"+
                "\n2)POPULATE TABLE"+
                "\n3)DELETE TABLE");
        menuChoice = sc.nextInt();
        sc.nextLine();
        while(status)
        {
            switch(menuChoice)
            {
                case 1:
                    System.out.println("Enter in the name of your table");
                    String table = sc.nextLine();
                    System.out.println("Please specify the amount of attributes desired: ");
                    totAtt = Integer.parseInt(sc.nextLine());

                    int counter = 0;

                    String [] attributes = new String[totAtt];




                    while(totAtt>0) {
                        System.out.println("PLEASE TYPE IN THE NAME OF ATTRIBUTE " +  (counter+1 ));
                        String name = sc.nextLine() + " ";
                        System.out.println("SELECT DATA TYPE FOR ATTRIBUTE: "+ (counter+1 )  + "\n" + "1)Name " + "\n" + "2)Email \n" + "3)Date \n" +"4)Num");

                        int datType =  Integer.parseInt(sc.nextLine());

                        attributes[counter] = name + datType;


                        totAtt--;
                        counter++;
                    }

                    System.out.println("End of counter");

                    queries.generateQuery(attributes);

                    printArrays(attributes);
//                    String[] attribute;
//
//                        System.out.println("Enter attribute name and attribute type separated by a space ");
//                        attribute = sc.nextLine().split(" ");




                    break;
                case 2:


                    break;
                case 3:

                    break;

                case 0:
                    status = false;
                    break;
            }
            System.out.println("SELECT AN OPTION: " +
                    "\n1)CREATE TABLE"+
                    "\n2)POPULATE TABLE"+
                    "\n3)DELETE TABLE"+
                    "\n0)QUIT");
            menuChoice = sc.nextInt();
        }

    }


}
