package com.company;
import java.util.*;
import java.io.*;
/**
 * Created by Sarthak on 3/4/19.
 */
public class Queries {
    int totAtt;
    List<String> names;
    Scanner file;


    public Queries() {
        names = new ArrayList<>();
    }

    public boolean test = true;
    public void TableQuery(String name)
    {


        String[] attribute;

    }

    public void openFile(String name)
    {

        try{
            file = new Scanner(new FileReader(name));
            System.out.println("File read");
        }

        catch(Exception e )
        {
            System.out.println(e.getMessage());
            System.out.println("Not able to read file");
        }
    }

    public void readFile() {

        while (file.hasNext()) {

            String name = file.next();

            if (!(name.equals(" "))) {
                names.add(name);
            }
        }
    }

    public void closeFile()
    {
        file.close();
    }

//    public String[] splitArray(String [] arr)
//    {
//        for(int i = 0; i<arr.length; i++) {
//
//            String splitAtts[] = arr[i].split(" ");
//        }
//
//    }

    public String generateQuery(String [] attributes)
    {
        String att [];
        int i ;

        Random rand = new Random();
        for( i = 1; i<attributes.length; i+=2) {
            att = attributes[i].split(" ");

            switch (att[1]) {
                case "1":
                    int rand_int1 = rand.nextInt(48);
                    System.out.println("insert into Author " + "Values (47, " + names.get(rand_int1)+ ", 'Smith', 'JohnSmith123@yahoo.com', 'Care for Climate Inc')");
                 String sql=   "insert into Author " + "Values (47, 'John', 'Smith', 'JohnSmith123@yahoo.com', 'Care for Climate Inc')";



                    //Randomly Generate Names


                    break;

                case "2":

            
                    System.out.println("It has reached the varchar switch statement");
                    break;

                case "3":

                    break;


            }
        }
        return null;
    }



}
