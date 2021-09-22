package com.company;

import java.util.ArrayList;

public class Var15 {
    public static ArrayList<ArrayList<String>> Solution15(ArrayList<ArrayList<String>> arr){
        ArrayList<ArrayList<String>> answerList = new ArrayList<>();
        boolean TextIsOneStringComment = false;
        boolean TextIsMultiStringComment = false;

        for (int iStroka = 0; iStroka< arr.size(); iStroka++){
            TextIsOneStringComment = false;
            ArrayList<String> words = arr.get(iStroka);
            ArrayList<String> wordsAnswer = new ArrayList<>();
            for (int iSlovo = 0; iSlovo< words.size(); iSlovo++){
                char[] word = words.get(iSlovo).toCharArray();
                ArrayList<Character> wordAnswer = new ArrayList<>();
                for (int iBukva = 0; iBukva < word.length-1; iBukva++){
                    if (word[iBukva] == '/' && word[iBukva+1] == '/'){
                        TextIsOneStringComment = true;

                    }
                    if (word[iBukva] == '/' && word[iBukva+1] == '*'){
                        TextIsMultiStringComment = true;

                    }
                    if (word[iBukva] == '*' && word[iBukva+1] == '/'){
                        TextIsMultiStringComment = false;
                        word[iBukva] = ' ';
                        word[iBukva+1] = ' ';

                    }
                    if(!TextIsOneStringComment &&!TextIsMultiStringComment){
                        wordAnswer.add(word[iBukva]);
                    }

                }
                StringBuilder builder = new StringBuilder(wordAnswer.size());
                for(Character ch: wordAnswer)
                {
                    builder.append(ch);
                }
                if(!TextIsOneStringComment &&!TextIsMultiStringComment && word.length != 0) {
                    builder.append(word[word.length - 1]);
                }
                if(builder.toString().length() != 0) //
                wordsAnswer.add(builder.toString());


            }
            answerList.add(wordsAnswer);
        }


        return answerList;

    }


}
