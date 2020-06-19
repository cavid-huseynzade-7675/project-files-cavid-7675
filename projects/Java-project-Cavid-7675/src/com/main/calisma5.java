package com.main;

import java.util.Arrays;

public class calisma5 {

    public static void main(String[] args) {

// 1. String sinifində neçə ədəd replace metodu var?
//Onların hər birinə aid misallar yazın.
// 3dene var
        String setir = "java expression";
        setir = setir.replace("java", "regular");
        System.out.println(setir);
//-----------------------------------------------------------
        String setir2 = "ant length()";
        setir2 = setir2.replace('a', 'i');
        System.out.println(setir2);
//-----------------------------------------------------------

        String setir3 = "Bu metod, daxilinə yazılan sətirin, əsas sətirdə (basİndeks-dən\n "
                + "əvvəlki) son rastlanan indeksini qaytarır. Əgər axtarılan simvol tapılmazsa\n"
                + ", onda bu metod geriyə -1 qaytarır.";
        setir3 = setir3.replaceAll(" metod", "method");
        System.out.println(setir3);
        //-----------------------------------------------------------      
        String setir4 = " Bu metod, daxilinə yazılan sətirin, əsas sətirdə son\n"
                + "rastlanan indeksini qaytarır. Əgər axtarılan simvol tapılmazsa, onda bu metod geriyə -1 qaytarır.";
        setir4 = setir4.replaceFirst("r", "w");
        System.out.println(setir4);

//2. String sinifinin metodları arasında olan split metodu nə üçün istifadə olunur?
//String sinifində neçə ədəd split metodu var?
//Onların hər birinə aid misallar yazın.
// 2 dene var 
        String setir5 = "Men-java-proglasdirma-dili-oyrenirem";
        String[] massiv = setir5.split("-");

        for (String setir6 : massiv) {
            System.out.println(setir6);
        }
//-----------------------------------------------------------

        String setir7 = "Men-java-proglasdirma-dili-oyrenirem";
        String[] massiv1 = setir7.split("-", 3);

        for (String setir8 : massiv1) {
            System.out.println(setir8);
        }

//3. String sinifinin metodları arasında olan startsWith metodu nə üçün istifadə olunur?
//String sinifində neçə ədəd startsWith metodu var?
//Onların hər birinə aid misallar yazın.
//Bu metod, cari sətirin, parametr olaraq qoyulmuş sətirlə başlamasını yoxlayır.
        String setir8 = "String sinifinin metodları";
        System.out.println(setir8.startsWith("St"));
        //true
        System.out.println(setir8.startsWith("String"));
        //true
        System.out.println(setir8.startsWith("met"));
        //false
        System.out.println(setir8.startsWith("lari"));
        //false
        //------------------------------------------------------
        String setir9 = "String sinifinin metodlari";
        System.out.println(setir9.startsWith("St", 0));
        //true
        System.out.println(setir9.startsWith("String", 12));
        //false
        System.out.println(setir9.startsWith("sin", 7));
        //true
        System.out.println(setir9.startsWith("lari", 22));

        //true
//4. String dəyişənin daxilində olan dəyərin alt sətirini əldə etmək üçün
//hansı metoddan istifadə olunur?
//Əgər bir neçə yolu varsa, hər birinə aid misal yazın.
//subSequence  substring
        String setir10 = "Bu metod String obyektini başqa bir String obyekti ilə müqayisə \nedir. Əgər müqayisə olunan String arqument kimi daxil edilən String-dən kiçik olarsa,\n onda bu metod mənfi ədəd qaytarır. Əgər müqayisə olunan String arqument kimi \ndaxil edilən String-ə bərabər olarsa, onda bu metod sıfır qaytarır.  Əgər müqayisə \nolunan String arqument kimi daxil edilən String-dən böyük olarsa, onda bu metod müsbət ədəd qaytarır.\n";
        System.out.println(setir10.subSequence(35, 65));//cavab String obyekti ilə müqayisə
        //--------------------------------------------------------------------------------------------
        System.out.println(setir10.substring(107, 132));// kimi daxil edilən String

//5. String sinifi ilə StringBuffer siniflərinin adları ortaq olan metodların
//adlarını yazılı sadalayın.
//charAt,getChars,indexof,lastindexof,length,replace,subSequence,toString,substring
//6. Sətirlərin başlığında və sonunda olan lazımsız boşluqları necə aradan qaldırmaq olar?
//Həmçinin misal göstərin.
// trim metodu 
        String setir11 = "       salam      ";
        System.out.println(setir11);
        //cavab ;      salam      
        System.out.println(setir11.trim());
        //cavab ;salam     
//7. Müxtəlif dəyərləri sətirə çevirmək üçün String sinifinin daxilində olan hansı
//static metodlardan istifadə olunur? 

//              valueof
        Boolean mentiq = false;
        char cha = 'a';
        int eded = 56;
        Double eded1 = 56.2425;
        float eded2 = 23.53f;
        char[] massiv3 = new char[5];
        massiv3[0] = 's';
        massiv3[1] = 'a';
        massiv3[2] = 'l';
        massiv3[3] = 'a';
        massiv3[4] = 'm';
        long eded3 = 5498;
        Object obyekt = new Object();

        System.out.println(String.valueOf(mentiq));
        System.out.println(String.valueOf(cha));
        System.out.println(String.valueOf(eded));
        System.out.println(String.valueOf(eded1));
        System.out.println(String.valueOf(eded2));
        System.out.println(String.valueOf(massiv3));
        System.out.println(String.valueOf(eded3));
        System.out.println(String.valueOf(obyekt));
        
 //----------------------------------------------------------
 
 //                      copyvalueof
 char[] simvolmassivi=new char[5];
 simvolmassivi[0] = 's';
 simvolmassivi[1] = 'a';
 simvolmassivi[2] = 'l';
 simvolmassivi[3] = 'a';
 simvolmassivi[4] = 'm';
 String setir12=String.copyValueOf(simvolmassivi);
        System.out.println(setir12);
        
//-------------------------------------------------------------------
//                      tostring

Integer eded4=7547;
        System.out.println(eded4.toString());
//------------------------------------------------------------------
//                parseint
String setir13="486";
int x=Integer.parseInt(setir13);

String setir14="486.634";
Double c=Double.parseDouble(setir14);

        System.out.println(x);
        System.out.println(c);
    }
}