package com.company;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Main {

    @Test
    public void whenNumberHasIXThenReturnNine()
    {Assert.assertEquals(9, convertIt("IX"));}
    @Test
    public void whenNumberHasMaxValue()
    {Assert.assertEquals(4999,convertIt("MMMMCMXCIX"));}
    @Test
    public void whenNumberIsLowerCase()
    {Assert.assertEquals(1902,convertIt("mcmii"));}
    @Test
    public void whenNumberStringIsIncorrect()
    {Assert.assertEquals(0,convertIt("BBC"));}

    public static void main(String[] args) {
            /*
            *
            * Use java.util.Scanner for the reading of input data
            *
            */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your number: ");
        String number = scanner.next();
        convertIt(number);

    }

    private static int convertIt(String rNum){
        {
            int output = 0;
            rNum = rNum.toUpperCase();
            //it will be our output number
            char[] roman = {'I','V','X','L','C','D','M'};
            if (!StringUtils.containsOnly(rNum,roman)){
                System.out.print("Roman number is invalid !");
                return 0;}
            /*
            *
            * Get char array from the entered string
            *
            */
            char [] romanCharArray = rNum.toCharArray();
            int i = 0;
            while(i<romanCharArray.length){

                int num;
                num = charToNum(romanCharArray[i]);
                if ((i+1<romanCharArray.length)&&(charToNum(romanCharArray[i]) < charToNum(romanCharArray[i + 1]))) {
                    num = charToNum(romanCharArray[i + 1]) - charToNum(romanCharArray[i]);
                    output += num;
                    i+=2;
                    continue;

                } else
                {
                    output += num;
                    i+=1;
                }


            }

            System.out.print(output);
            return output;
        }


         }

                /*
                *
                * This method converts simple Roman num into arabic
                *
                */

     private static int charToNum(char roman)
    {
        int n = 0;
        switch(roman)
        {
            case 'M':
                n=1000;
                break;
            case 'D':
                n=500;
                break;
            case 'C':
                n=100;
                break;
            case 'L':
                n=50;
                break;
            case 'X':
                n=10;
                break;
            case 'V':
                n=5;
                break;
            case 'I':
                n=1;
                break;
        }
        return n;
    }

}
