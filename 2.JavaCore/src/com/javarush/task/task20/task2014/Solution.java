package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        Solution savedObject=new Solution(3);
        FileOutputStream fileOutput = null;
        try
        {
            fileOutput = new FileOutputStream("C:/baskakov/1.dat");
            ObjectOutputStream outd=new ObjectOutputStream(fileOutput);
            outd.writeObject(savedObject);
            fileOutput.close();
            outd.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Solution loadedObject=new Solution(2);
        try {
            FileInputStream fileIntput = new FileInputStream("C:/baskakov/1.dat");
            ObjectInputStream ind=new ObjectInputStream(fileIntput);
            loadedObject=(Solution)ind.readObject();
            fileIntput.close();
            ind.close();
        } catch (IOException e)
        {
        }
        catch (ClassNotFoundException e)
        {
        }
        if (savedObject.string.equals(loadedObject.string)) {
            System.out.println(loadedObject.string);
        } else System.out.println("Noooooo");

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
