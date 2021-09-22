package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class Graph  extends JFrame {
    private  JLabel label1=new JLabel("Введите текст или возьмите его из файла");
    private JTextArea area1 = new JTextArea(10, 30);
    private JTextArea area2 = new JTextArea(10, 30);
    private JTextArea area3 = new JTextArea(10, 30);
    private JButton accept= new JButton("Подтвердить");
    private JButton ReadArrayFromFileBut15= new JButton("Взять текст из файла для 15");
    private JButton ReadArrayFromFileBut22= new JButton("Взять текст из файла для 22");
    private JButton WriteTextBut= new JButton("Ввести текст");
    private JButton task15but= new JButton("Задание 15");
    private JButton task22but= new JButton("Задание 22");
    ArrayList<ArrayList<String>> text15 = new ArrayList<>();
    String text22 = new String();
    FileWork filework = new FileWork();

    public void graphics(){
        JFrame frame = new JFrame("Лабораторная номер 11");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.setVisible(true);
        Var15 var15 = new Var15();
        Var22 var22 = new Var22();
        WriteTextBut.addActionListener(new ActionListener() {
                                           public void actionPerformed(ActionEvent e) {
                                               //Создаем новый контейнер JFrame
                                               JFrame jfrm = new JFrame("Ввод текста");
                                               //Устанавливаем диспетчер компоновки
                                               jfrm.getContentPane().setLayout(new FlowLayout());
                                               //Устанавливаем размер окна
                                               jfrm.setSize(600, 250);
                                               //Устанавливаем завершение программы при закрытии окна
                                               jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                               //Создаем новую таблицу на основе двумерного массива данных и заголовков
                                               //jTable1.setModel(new javax.swing.table.DefaultTableModel(c,headers));*/

                                               //panel.add(jTable1);

                                               //Создаем панель прокрутки и включаем в ее состав нашу таблицу
                                               JScrollPane jscrlp = new JScrollPane(area1);

                                               //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
                                               jfrm.getContentPane().add(jscrlp);
                                               jfrm.add(accept);
                                               //Отображаем контейнер
                                               jfrm.setVisible(true);
                                               accept.addActionListener(new ActionListener() {
                                                   public void actionPerformed(ActionEvent e) {
                                                       text22 = area1.getText();
                                                       File file = new File("C:\\Users\\olegf\\IdeaProjects\\Task11 Java\\src\\com\\company\\tempFile.txt");
                                                       FileWriter fr = null;
                                                       try {
                                                           fr = new FileWriter(file);
                                                           fr.write(text22);
                                                       } catch (IOException e1) {
                                                           e1.printStackTrace();
                                                       }finally{
                                                           try {
                                                               fr.close();
                                                           } catch (IOException e1) {
                                                               e1.printStackTrace();
                                                           }
                                                       }
                                                       text15 = filework.GetFile15("C:\\Users\\olegf\\IdeaProjects\\Task11 Java\\src\\com\\company\\tempFile.txt");


                                                   }
                                               });

                                           }
                                       });
        task15but.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {

                                            Var15 var15 = new Var15();
                                            ArrayList<ArrayList<String>> text15Answer = var15.Solution15(text15);

                                            //Создаем новый контейнер JFrame
                                            JFrame jfrm = new JFrame("Отформатированный текст");
                                            //Устанавливаем диспетчер компоновки
                                            jfrm.getContentPane().setLayout(new FlowLayout());
                                            //Устанавливаем размер окна
                                            jfrm.setSize(600, 250);
                                            //Устанавливаем завершение программы при закрытии окна
                                            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                            //Создаем новую таблицу на основе двумерного массива данных и заголовков
                                            //jTable1.setModel(new javax.swing.table.DefaultTableModel(c,headers));*/

                                            //panel.add(jTable1);

                                            //Создаем панель прокрутки и включаем в ее состав нашу таблицу
                                            JScrollPane jscrlp = new JScrollPane(area2);
                                            for (int i =0;i<text15Answer.size();i++) {
                                                for (int j = 0; j < text15Answer.get(i).size(); j++) {
                                                    area2.append(text15Answer.get(i).get(j) + " ");
                                                }
                                                if(text15Answer.get(i).size() != 0)
                                                area2.append("\n");
                                            }

                                            //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
                                            jfrm.getContentPane().add(jscrlp);

                                            //Отображаем контейнер
                                            jfrm.setVisible(true);

                                        }
                                    });
        task22but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Var22 var22 = new Var22();
                ArrayList<String> text22Answer = var22.Solution22(text22);

                //Создаем новый контейнер JFrame
                JFrame jfrm = new JFrame("Отформатированный текст");
                //Устанавливаем диспетчер компоновки
                jfrm.getContentPane().setLayout(new FlowLayout());
                //Устанавливаем размер окна
                jfrm.setSize(600, 250);
                //Устанавливаем завершение программы при закрытии окна
                jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Создаем новую таблицу на основе двумерного массива данных и заголовков
                //jTable1.setModel(new javax.swing.table.DefaultTableModel(c,headers));*/

                //panel.add(jTable1);

                //Создаем панель прокрутки и включаем в ее состав нашу таблицу
                JScrollPane jscrlp = new JScrollPane(area3);
                for (int i =0;i<text22Answer.size();i++) {

                    area3.append(text22Answer.get(i) + " ");


                }


                //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
                jfrm.getContentPane().add(jscrlp);

                //Отображаем контейнер
                jfrm.setVisible(true);

            }
        });



        panel.add(label1);
        //panel.add(area1);
        panel.add(WriteTextBut);
        panel.add(ReadArrayFromFileBut15);
        panel.add(ReadArrayFromFileBut22);
        panel.add(task15but);
        panel.add(task22but);
        frame.add(panel);
    }


}
