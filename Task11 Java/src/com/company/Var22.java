package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class Var22 {

    public static ArrayList<String> Solution22(String str) {
        /*Scanner in = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String str = in.nextLine();*/
        ArrayList<String> answerList = new ArrayList<>();
        String[] words = str.split(" ");
        char[] AllowedSymbols = new char[70];
        int k = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            AllowedSymbols[k] = i;
            k++;
        }
        for (char i = 'а'; i <= 'я'; i++) {
            AllowedSymbols[k] = i;
            k++;
        }
        for (int i = 49; i <= 57; i++) {
            AllowedSymbols[k] = (char) i;
            k++;
        }
        AllowedSymbols[k] = '.';
        int temp = 0, temp1;
        for (String word : words) {
            boolean symbolIsAllowed = true;

            char tempCharArray[] = word.toCharArray();
            for (char Symbol : tempCharArray) {
                temp1 = 0;

                for (char AllowedSymbol : AllowedSymbols) {

                    if (String.valueOf(AllowedSymbol).compareToIgnoreCase(String.valueOf(Symbol)) == 0) {
                        break;
                    }
                    temp1++;

                }
                if (temp1 == 70) {
                    symbolIsAllowed = false;
                    break;

                }
            }
            if (symbolIsAllowed == false)
                answerList.add(word + " ");
            else {
                if (tempCharArray[tempCharArray.length-1] == '.'){
                    char tempCharArray1[] = word.toCharArray();


                    for (int i = 1; i<tempCharArray.length ; i++){
                        tempCharArray[i]  = tempCharArray1[i-1];

                    }
                    tempCharArray[0] = '.';
                    String DotWord = new String(tempCharArray);
                    StringBuilder sb = new StringBuilder(DotWord);
                    answerList.add(sb.reverse() + " ");

                }else {


                    StringBuilder sb = new StringBuilder(word);
                    answerList.add(sb.reverse() + " ");
                }
            }

        }
        return answerList;
    }

}
