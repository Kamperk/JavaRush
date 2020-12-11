package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String [] s = url.split("[\\?\\&]");
        for(int i =1; i<s.length; i ++){
            if (s[i].contains("=")){
                System.out.print(s[i].substring(0, s[i].indexOf("="))+ " ");}
            else
                System.out.print(s[i] + " ");
        }
        System.out.println("");

        for(int i =1; i<s.length; i ++){
            if (s[i].substring(0, 2).contains("ob")){
                if (Solution.parseDouble(s[i].substring(4)))
                    Solution.alert(Double.parseDouble(s[i].substring(4)));
                else
                    Solution.alert(s[i].substring(4));
            }
        }



        }
        String d = "javarush.ru/alpha/index.html?lvl=15&view&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&oobj=3.0&obj=1&obj=2.3&obj=aaa";

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
    public static boolean parseDouble(String s){
        try{
            Double.parseDouble(s);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
