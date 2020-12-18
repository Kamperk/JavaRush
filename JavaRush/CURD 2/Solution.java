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

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat newDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case ("-c"):
                synchronized (allPeople) {
                }
                for (int i = 1; i < args.length ; i = i + 3) {
                    if (args[i + 1].equals("м")) {
                        Person person = Person.createMale(args[i], date.parse(args[i + 2]));
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    if (args[i + 1].equals(("ж"))) {
                        Person person = Person.createFemale(args[i], date.parse(args[i + 2]));
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;
            case ("-u"):
                synchronized (allPeople) {
                }
                for (int i = 1; i < args.length ; i = i + 4) {
                    if (args[i + 2].equals("м")) {
                        Person person = Person.createMale(args[i+1], date.parse(args[i + 3]));
                        allPeople.set(Integer.parseInt(args[i]), person);
                        System.out.println(allPeople.indexOf(person));
                    }
                    if (args[i + 2].equals(("ж"))) {
                        Person person = Person.createFemale(args[i+1], date.parse(args[i + 3]));
                        allPeople.set(Integer.parseInt(args[i]), person);
                        System.out.println(allPeople.indexOf(person));
                    }//start here - начни тут
                }
                break;
            case ("-d"):
                synchronized (allPeople) {
                }
                for (int i = 1; i < args.length ; i++) {
                    allPeople.set(Integer.parseInt(args[i]), new Person(null, null, null));
                }
                break;
            case ("-i"):
                synchronized (allPeople) {
                }
                for (int i = 1; i < args.length ; i++) {
                    if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE)){
                        System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " м " + newDate.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate()));}
                    if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.FEMALE)){
                        System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " ж " + newDate.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate()));}
                }
                break;
        }
    }
}

