package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String CONNECTION_STRING= "jdbc:sqLite:/Users/Sarthak/Desktop/DatabasePopulater/testjava1.db";
    //Initializes a Queries object, queries
    public static final Queries queries = new Queries();
    public static final String te = "Te";

    public static void main(String[] args) {



        //Calls menu method found in the main class
        menu();


    }

    public static void printArrays(String[] arr)
    {
        for(int i = 0; i<arr.length; i++)
        {
            System.out.println(arr[i]);
        }

    }




    //Menu Method Which Is Called In The Main
    public static void menu()
    {
        //Boolean status variable used for determining when the user wants to exit the program
        boolean status = true;
        //Initializing int value for the switch case statement used for determining what the user wants to do based off the menu choices
        int menuChoice;
        //Initializing int value for the total amount of attributes the user wants in his table
        int totAtt;
        Scanner sc = new Scanner(System.in);
        //Menu choice for the user to select between the following options
        System.out.println("SELECT AN OPTION: " +
                "\n1)CREATE TABLE"+
                "\n2)POPULATE TABLE"+
                "\n3)DELETE TABLE");
        //saves an int value based off what menu choice the user wants to conduct
        menuChoice = sc.nextInt();
        sc.nextLine();
        //
        while(status)
        {
            switch(menuChoice)
            {
                //If menuChoice = 1
                case 1:
                    System.out.println("Enter in the name of your table");
                    String table;
                    table = sc.nextLine();

                    System.out.println("Please specify the amount of attributes desired: ");
                    totAtt = Integer.parseInt(sc.nextLine());
                    int totAttCopy = totAtt;
                    int counter = 0;

                    String amtEnt = "";


                    //Initializes a new String array based off how many total attributes are desired by the user
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

                    System.out.println("Enter the amount of entities desired");
                    amtEnt = sc.nextLine();


                    System.out.println(queries.createTable(table, totAttCopy, attributes));
                    List<String> myQueries = queries.generateQuery(attributes, amtEnt, table);

                    for(int i = 0; i <myQueries.size(); i++)
                    {
                        System.out.println(myQueries.get(i) + "\n");
                    }

                    //   printArrays(attributes);
//                    String[] attribute;
//
//                        System.out.println("Enter attribute name and attribute type separated by a space ");
//                        attribute = sc.nextLine().split(" ");




                    break;
                //If menuChoice = 2
                case 2:
                    System.out.println("Please specify how many entities you desire");
                    String amt;
                    amt = sc.nextLine();

                    //queries.generateQuery(attributes, amtEnt);



                    break;
                //If menuChoice = 3
                case 3:

                    break;

                case 0:
                    status = false;
                    break;
            }
            //
            System.out.println("SELECT AN OPTION: " +
                    "\n1)CREATE TABLE"+
                    "\n2)POPULATE TABLE"+
                    "\n3)DELETE TABLE"+
                    "\n0)QUIT");
            menuChoice = sc.nextInt();
        }

    }


}

