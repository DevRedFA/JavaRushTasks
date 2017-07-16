package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    private static SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    private static Person person;

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    public static void createPeople(String[] args) throws ParseException {
        for (int i = 0; i < (args.length - 1); i = i + 3) {
            if (args[2 + i].equals("м")) {

                allPeople.add(Person.createMale(args[1 + i], dateFormat.parse(args[3 + i])));

            } else {
                if (args[2 + i].equals("ж")) {
                    allPeople.add(Person.createFemale(args[1 + i], dateFormat.parse(args[3 + i])));
                }
            }
            System.out.println(allPeople.size() - 1);
        }
    }

    public static void updatePeople(String[] args) throws ParseException {
        for (int i = 0; i < (args.length - 1); i = i + 4) {
            person = allPeople.get(Integer.parseInt(args[1 + i]));
            if (args[3 + i].equals("м")) {
                person.setSex(Sex.MALE);
            } else {
                if (args[3 + i].equals("ж")) {
                    person.setSex(Sex.FEMALE);
                }
            }
            person.setName(args[2 + i]);
            person.setBirthDay(dateFormat.parse(args[4 + i]));
        }
    }

    public static void delitePeople(String[] args) throws ParseException {
        for (int i = 0; i < (args.length - 1); i = i + 1) {
            allPeople.remove(Integer.parseInt(args[1 + i]));
            person = Person.createMale(null, null);
            person.setSex(null);
            allPeople.add(Integer.parseInt(args[1 + i]), person);
        }
    }

    public static void infoPeople(String[] args) throws ParseException {
        for (int i = 0; i < (args.length - 1); i = i + 1) {
            person = allPeople.get(Integer.parseInt(args[1 + i]));
            String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";

            System.out.println(String.format("%s %s %s", person.getName(), sex, dateFormatOut.format(person.getBirthDay())));
        }
    }

    public static void main(String[] args) {


        try {
            switch (args[0]) {
                case "-c":
                    synchronized (allPeople) {
                        createPeople(args);
                        break;
                    }
                case "-u":
                    synchronized (allPeople) {
                        updatePeople(args);
                        break;
                    }
                case "-d":
                    synchronized (allPeople) {
                        delitePeople(args);
                        break;
                    }
                case "-i":
                    synchronized (allPeople) {
                        infoPeople(args);
                        break;
                    }
            }

     //       Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

