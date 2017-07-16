package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
                Person person;
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                try {
            if (args[0].equals("-c")) {
                if (args[2].equals("м")) {

                    allPeople.add(Person.createMale(args[1], dateFormat.parse(args[3])));

                } else {
                    if (args[2].equals("ж")) {
                        allPeople.add(Person.createFemale(args[1], dateFormat.parse(args[3])));
                    }
                }
                System.out.println(allPeople.size() - 1);
            }

            if (args[0].equals("-u")) {
                person = allPeople.get(Integer.parseInt(args[1]));
                if (args[3].equals("м")) {
                    person.setSex(Sex.MALE);
                } else {
                    if (args[3].equals("ж")) {
                        person.setSex(Sex.FEMALE);
                    }
                }
                person.setName(args[2]);
                person.setBirthDay(dateFormat.parse(args[4]));
            }

            if (args[0].equals("-d")) {
                allPeople.remove(Integer.parseInt(args[1]));
                person = Person.createMale(null, null);
                person.setSex(null);
                allPeople.add(Integer.parseInt(args[1]), person);
            }

            if (args[0].equals("-i")) {

                person = allPeople.get(Integer.parseInt(args[1]));
                String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";

                System.out.println(String.format("%s %s %s", person.getName(), sex, dateFormatOut.format(person.getBirthDay())));
            }


   //         Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
