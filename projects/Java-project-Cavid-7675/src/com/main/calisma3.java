package com.main;

import java.util.Arrays;
import java.util.Locale;

public class calisma3 {

    public static void main(String[] args) {
//1. Simvol massivini String dəyişənə çevirmək üçün hansı metodu istifadə etmək olar?
        char[] simvol = {'s', 'a', 'l', 'a', 'm'};
        String a = Arrays.toString(simvol);
        System.out.println(a);
        String b = new String(simvol);
        System.out.println(b);
        //izah: simvol massivine stringe kecirtmek ucun bir nece yol var 
        //men ikisini yazdim 

//2. Verilmiş sətirdə, axtarılan sətiri tapmaq üçün hansı metodu istifadə etmək olar?
        StringBuffer sb = new StringBuffer("Proqlasdirma diqqet teleb edir.");
        System.out.println(sb.subSequence(0, 12));

//3. Hansı metod vasitəsilə sətirlərdə olan simvol sayını tapmaq olar?
        String c = "Bu metod sətirdə olan simvol sayını qaytarır.";
        int uzunluq = c.length();
        System.out.println(uzunluq);

//4. Sətirlərin müəyyən indekslərində olan alt sətirlərini tapmaq üçün hansı metodu istifadə etmək olar?
        StringBuffer sb1 = new StringBuffer("Proqlasdirma diqqet teleb edir.");
        System.out.println(sb1.substring(0, 12));

//5. Sətirləri bir biri ilə birləşdirmək üçün hansı yolları istifadə etmək olar?
        String s = "kom";
        System.out.println(s);
        s = s.concat("pu");
        System.out.println(s);
        s = s.concat("ter");
        System.out.println(s);

//6. Sətirlərin formatlı yazılması üçün hansı yolları istifadə etmək olar?
        //                       1 ci yol
        Float f = 15.56f;
        int i = 546;
        String str = "salam";
        System.out.printf("float deyisenin deyeri ="
                + "%f,\nint deyiseninin deyeri="
                + "%d,\nstring deyiseninin deyeri=%s", f, i, str);
        //                      2 ci yol   
        String formats;
        Float f1 = 29.56f;
        int i1 = 4767;
        String str1 = "java";
        formats = String.format("\n\nfloat deyisenin deyeri ="
                + "%f,\nint deyiseninin deyeri="
                + "%d,\nstring deyiseninin deyeri=%s", f1, i1, str1);
        System.out.println(formats);

//7. Sətirlərin müqayisə olunması zamanı hansı metoddan istifadə olunur?
//Sətirlərin müqayisə qaydalarını yazılı izah edin.
        String str2 = "salam";
        String str3 = "java";

        System.out.println(str2.compareTo(str3));
        //izah bu metod string deyisenlerini arqument kimi muqayise edir
        //eger daxil etdiyimiz string daha boyuk olarsa musbet eded gosterecek,  beraber
        // olarsa 0,kicik olarsa  menfi eded gosterer
        // yalniz  ancaq bir edede  baxir ve deyir
        //compareToIgnoreCase deyerin  boyuk yada kicik eded olmasina baxmir
       
        

//8. "endsWith" metodu nə üçün istifadə olunur?
String str4="Amerika";
      System.out.println(str4.endsWith("rika"));// true
      System.out.println(str4.endsWith("a"));// true
      System.out.println(str4.endsWith("rik"));// false
      System.out.println(str4.endsWith("Ame"));// false
      System.out.println(str4.endsWith("ika"));// true
      //izah:bu Bu metod, cari sətirin, metoda parametr kimi daxil edilən setirDeyeri sətiri
// ilə bitib-bitmədiyini yoxlayır. Əgər metodun istifadə 
//olunduğu sətir, setirDeyeri sətiri ilə bitərsə, onda, bu metod true
// qaytarır, əks halda isə false qaytarır.

    }

}
