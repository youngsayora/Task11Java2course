package com.company;
import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;
public class FileWork {

    public void SetFile(ArrayList<ArrayList<String>> MyArray, String path){

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(path),true);
            for (int i =0;i<MyArray.size();i++){
                for (int j = 0; j< MyArray.get(i).size(); j++) {

                    out.print(MyArray.get(i).get(j) + " ");
                }
                if(MyArray.get(i).size() != 0)
                    out.println();


            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void SetFile22(ArrayList<String> MyArray, String path){

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(path),true);
            for (int i =0;i<MyArray.size();i++){
                    out.print(MyArray.get(i) + " ");
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ArrayList<String>> GetFile15 ( String path){
        ArrayList<ArrayList<String>> arr = new ArrayList();

        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                ArrayList<String> stroka = new ArrayList<>();
                String[] numbers = scanner.nextLine().split(" ");
                for(String word: numbers)
                {
                    stroka.add(word);
                }
                arr.add(stroka);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arr;
    }
    public String GetFile22 ( String path){

        StringBuilder sb = new StringBuilder(512);
        try {
            FileInputStream is =new FileInputStream(path);
            Reader r = new InputStreamReader(is, "UTF-8");
            int c = 0;
            while ((c = r.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }


}
