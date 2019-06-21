package com.company;
import java.util.*;
import java.io.*;
/**
 * Created by Sarthak on 3/4/19.
 */
public class Queries {
    public boolean test = true;
    int totAtt;
    List<String> names;
    List<String> emails;
    List<String> insertQueries;
    List<String> ranNames;
    List<String> ranEmails;
    List<String> ranDates;
    Scanner file;

    public Queries() {
        names = new ArrayList<>();
        emails = new ArrayList<>();
        ranNames = new ArrayList<>();
        ranEmails = new ArrayList<>();
        ranDates = new ArrayList<>();
        insertQueries = new ArrayList<>();

    }

    public void TableQuery(String name)
    {


        String[] attribute;

    }

    public void openFile(String name)
    {

        try{
            file = new Scanner(new FileReader(name));
           // System.out.println("File read");
        }

        catch(Exception e )
        {
            System.out.println(e.getMessage());
            System.out.println("Not able to read file");
        }
    }

    public void readFile(String fileName) {

        while (file.hasNext()) {

            String name = file.next();

            switch(fileName)
            {

                case "maleFirstNames.txt":
                    if (!(name.equals(" "))) {
                        names.add(name);
                    }
                    break;

                case "randEmail.txt":
                    if (!(name.equals(" "))) {
                        emails.add(name);
                    }
                    break;

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

    public String randEmailDom()
    {
        Random rand = new Random();
        int randNum  = rand.nextInt(3);


        String emailDom;

        switch(randNum)
        {
            case 0:

                emailDom =  "@Gmail.com";
                return emailDom;

            case 1:
                emailDom = "@Yahoo.com";

                return emailDom;


            case 2:
                emailDom  =  "@Outlook.com";
                return emailDom;



        }


        return null;


    }

    public String createTable(String tableName, int totalAmt, String [] myAttributeNames)
    {
        String myTableSkeleton = "Create table " + tableName + " (";

        String myAttributes [];
        List<String> myEntities = new ArrayList<>();
        for(int i= 0; i<totalAmt; i++)
        {
            myAttributes = myAttributeNames[i].split(" ");

            switch(myAttributes[1])
            {
                case "1":

                    myEntities.add(myAttributes[0]+ " varchar(55)");

                    break;

                case "2":
                    myEntities.add(myAttributes[0]+ " varchar(55)");
                    break;

                case "3":
                    myEntities.add(myAttributes[0]+ " date");
                    break;

                case "4":
                    myEntities.add(myAttributes[0]+ " int");
            }
        }
        //testIterator(myEntities);
        myTableSkeleton+=myListIterator(myEntities);

        return myTableSkeleton;
    }

    public void testIterator(List<String> testList)
    {
        Iterator myIt = testList.iterator();
        while(myIt.hasNext())
        {
            System.out.println(myIt.next());
        }
    }
    public String myListIterator(List<String> entities)
    {
        Iterator myIterator = entities.iterator();
        StringBuilder myBuilder = new StringBuilder();
        for(int i= 0; i<entities.size(); i ++ )
        {
            if(i==entities.size()-1)
            {
                myBuilder.append(entities.get(i)+ ");");
                return myBuilder.toString();
            }

            else
            {
                myBuilder.append(entities.get(i) + ", ");
            }
        }
        return myBuilder.toString();
    }

    public String stringBuilderAppender(ArrayList<String> toBeAppendedEntities)
    {


        return "";
    }

    public String myRandomDate() {
        Random rand = new Random();
        int myRandYear = rand.nextInt(2019 - 2000) + 2000;
        int myRandDay = rand.nextInt(31 - 1) + 1;
        int myRandMonth = rand.nextInt(12 - 1) + 1;

        StringBuilder myRandomDate = new StringBuilder(myRandYear + "-" + myRandMonth + "-" + myRandDay);
        return myRandomDate.toString();
    }

    public List<String> generateQuery(String [] attributes, String amtEnt, String tableName) {
        String att[];
        String ranName;
        int i;
        Random rand = new Random();
        int randNum;

        for (i = 0; i < attributes.length; i ++) {
            att = attributes[i].split(" ");
            for (int j = 0; j < Integer.valueOf(amtEnt); j++) {




                switch (att[1]) {
                    case "1":
                        openFile("maleFirstNames.txt");
                        readFile("maleFirstNames.txt");
                        closeFile();
                        randNum = rand.nextInt(48);

                        ranName = names.get(randNum);

                        ranNames.add(ranName);

                        if(i==attributes.length-1)
                        {

                        }
//                    System.out.println("insert into Author " + "Values (47, " + names.get(rand_int1)+ ", 'Smith', 'JohnSmith123@yahoo.com', 'Care for Climate Inc')");
//                 String sql=   "insert into Author " + "Values (47, 'John', 'Smith', 'JohnSmith123@yahoo.com', 'Care for Climate Inc')";
                        break;
                    case "2":

                        openFile("randEmail.txt");
                        readFile("randEmail.txt");
                        closeFile();

                        openFile("maleFirstNames.txt");
                        readFile("maleFirstNames.txt");
                        closeFile();


                        randNum = rand.nextInt(48);

                        StringBuilder myRandomEmail = new StringBuilder(names.get(randNum));

                        myRandomEmail.append(randEmailDom());


                        ranEmails.add(myRandomEmail.toString());

                        break;

                    case "3":

                        ranDates.add(myRandomDate());

                        break;


                }

                //create sql string at the end of the loop
            }



        }



        String toPass = requiredQuery(tableName,attributes);
        return linkDataQuery(toPass, attributes);

    }

    public List<String> linkDataQuery(String toPassQuery, String [] attributes)
    {



        for(int i = 0; i < ranNames.size(); i++)
            {

            StringBuilder requiredQuery = new StringBuilder(toPassQuery);
            StringBuilder insertSB2 = new StringBuilder("VALUES (");
            String [] att;

                for (int j = 0; j < attributes.length; j ++) {
                    att = attributes[j].split(" ");

                    if(att[1].equals("1"))
                    {
                        if(j==attributes.length-1)
                        {

                            insertQueries.add(requiredQuery.append(insertSB2.append("\n"+"'"+ranNames.get(i) + "'" + ");").toString()).toString());
                        }
                        else
                        {
                            insertSB2.append("'" + ranNames.get(i) + "'" + " ,");
                        }
                    }

                    if(att[1].equals("2"))
                    {
                        if(j==attributes.length-1)
                        {
                            insertQueries.add(requiredQuery.append(insertSB2.append("'"+ranEmails.get(i) + "'" + ");").toString()).toString());
                        }
                        else
                        {
                            insertSB2.append("'" + ranEmails.get(i) + "'" + " ,");
                        }
                    }

                    if(att[1].equals("3"))
                    {
                        if(j==attributes.length-1)
                        {
                            insertQueries.add(requiredQuery.append(insertSB2.append("'"+ranDates.get(i) + "'" + ");").toString()).toString());
                        }
                        else
                        {
                            insertSB2.append("'" + ranDates.get(i) + "'" + " ,");
                        }
                    }
                }
            //insertQueries.add(requiredQuery.append("\n" +insertSB2.append("'"+ranNames.get(i) + "'" + ", " + "'" + ranEmails.get(i) + "'" + ");").toString()).toString());
        }

        return insertQueries;
    }

    public String requiredQuery(String tableName, String [] attributes)
    {
        StringBuilder insertSB1 = new StringBuilder("INSERT INTO " + tableName + "( ");
        String [] att;
        for (int i = 0; i < attributes.length; i ++) {
            att = attributes[i].split(" ");

            if(i==attributes.length-1)
            {
                insertSB1.append(att[0] + ")" + "\n");
            }
            else
            {
                insertSB1.append(att[0] + ", ");
            }

        }

        return insertSB1.toString();




    }





}
