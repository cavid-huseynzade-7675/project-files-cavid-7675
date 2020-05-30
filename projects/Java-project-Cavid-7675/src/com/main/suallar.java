package com.main;

import java.util.Scanner;

public class suallar {

    public static void main(String[] args) {
        SuallarSablon[] questions = new SuallarSablon[4];
        SuallarSablon q1 = new SuallarSablon();
        q1.setQuestion("javada tek setirli comment nece yazilir?");

        String[] q1answer = new String[4];
        q1answer[0] = "zehmet olmasa cavabini sec";
        q1answer[1] = "\"/*\"(1 bu cavabi secmek ucun )";
        q1answer[2] = "\"//\"(2 bu cavabi secmek ucun )";
        q1answer[3] = "\"/**\"(3 bu cavabi secmek ucun )";
        q1.setAnswer(q1answer);
        q1.setDogrucavab(2);
        questions[0] = q1;

        SuallarSablon q2 = new SuallarSablon();
        q2.setQuestion("stringin deafault deyeri  nedir");
        String[] q2answer = new String[4];
        q2answer[0] = "zehmet olmasa cavabini sec";
        q2answer[1] = "\"null\"(1 bu cavabi secmek ucun )";
        q2answer[2] = "\"0\"(2 bu cavabi secmek ucun )";
        q2answer[3] = "\"false\"(3bu cavabi secmek ucun )";
        q2.setAnswer(q2answer);
        q2.setDogrucavab(1);
        questions[1] = q2;

        SuallarSablon q3 = new SuallarSablon();
        q3.setQuestion("obyekt harda saxlanir");
        String[] q3answer = new String[4];
        q3answer[0] = "zehmet olmasa cavabini sec";
        q3answer[1] = "\"ram\"(1 bu cavabi secmek ucun ) ";
        q3answer[2] = "\"heap\"(2 bu cavabi secmek ucun )";
        q3answer[3] = "\"stack\"(3 bu cavabi secmek ucun )";
        q3.setAnswer(q3answer);
        q3.setDogrucavab(2);
        questions[2] = q3;

        SuallarSablon q4 = new SuallarSablon();
        q4.setQuestion("sinifin icinde ne qeder konskruktor yaratmaq olar");
        String[] q4answer = new String[4];
        q4answer[0] = "zehmet olmasa cavabini sec";
        q4answer[1] = "\"1\"(1 bu cavabi secmek ucun )";
        q4answer[2] = "\"2 \"(2 bu cavabi secmek ucun )";
        q4answer[3] = "\"nezeri olaraq sonsuz\"(3 bu cavabi secmek ucun )";
        q4.setAnswer(q4answer);
        q4.setDogrucavab(3);
        questions[3] = q4;

        Scanner skaner = new Scanner(System.in);
        System.out.println("adini yaz ");
        String sagirdAdi = skaner.nextLine();
        System.out.println("teste baslandi");
        int topladigibal = 0;

        for (SuallarSablon question : questions) {

            System.out.println(question.getQuestion());
            for (String aanswer : question.getAnswer()) {
                System.out.println(aanswer);
            }

            int secdiyicavab = skaner.nextInt();
            if (secdiyicavab == question.getDogrucavab()) {

                topladigibal++;
            }

            System.out.println("--------------------------------");
        }
        System.out.println("topladigi bal 100 uzerinden " + topladigibal*25);
    }

}
