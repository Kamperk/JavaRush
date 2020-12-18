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

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat newDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Sex.MALE.equals("м");
        Sex.FEMALE.equals("ж");
        if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                Person person = Person.createMale(args[1], date.parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
            if (args[2].equals("ж")) {
                Person person = Person.createFemale(args[1], date.parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            }
        }
        if (args[0].equals("-u")) {
            if (args[3].equals("м")) {
                allPeople.set(Integer.parseInt(args[1]), new Person(args[2], Sex.MALE, date.parse(args[4])));
            }
            if (args[3].equals("ж")) {
                allPeople.set(Integer.parseInt(args[1]), new Person(args[2], Sex.FEMALE, date.parse(args[4])));
            }
        }
        if (args[0].equals("-d")) {
            allPeople.set(Integer.parseInt(args[1]), new Person(null, null, null));
        }
        if (args[0].equals("-i")) {
            if (allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE) {
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " + "м" + " " + newDate.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
            }
            if (allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.FEMALE) {
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " + "ж" + " " + newDate.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));

            }
        }
    }
}

