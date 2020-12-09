package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        BigInteger a = reader.nextBigInteger();
        BigInteger b = reader.nextBigInteger();
        if(a.intValue()<1 || b.intValue()<1){
            throw new Exception();
        }
        System.out.println(a.gcd(b));
    }
}
