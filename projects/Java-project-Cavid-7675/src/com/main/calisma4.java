package com.main;

import java.util.Arrays;

public class calisma4 {

    public static void main(String[] args) {
// 1. equals metodunun xüsusiyyətlərini yazılı olaraq izah edin və 2 ədəd misal yazın
//equals istifadəsinə aid.

        String setir = "java";
        String setir1 = "java";
        System.out.println(setir.equals(setir1));

        String setir2 = "alma";
        String setir3 = "armud";
        System.out.println(setir2.equals(setir3));

//izah:Eger daxil etdiyimiz setir cari setire beraber olasa true,beraber olmasa false qaytarir

//2. equalsIgnoreCase metodunun equals ilə fərqi nədir? Yazılı olaraq izah edin
        String setir4 = "SALAM";
        String setir5 = "salam";
        System.out.println(setir4.equalsIgnoreCase(setir5));

//izah:bu equals kimi isleyir ancaq herflerin boyuk yada kicik olmasina baxmir

//3. Ən çox istifadə olunan kod sistemi hansıdır?

// en cox istifade olunan kod sistemi"UTF-8"dir

//4. Hansı metod ilə biz sətirdə olan bütün simvolların kodlarını massiv şəklində əldə
//edə bilərik? Buna aid misal yazın.
        String setir6 = "James ";
        System.out.println(setir6.getBytes());
        
        //biz getBytes ile onun yaddasda hansi yerde oldugun oyrenirik 

        //kodlarini gormek ucun ise for ile yada arrays tostring ile elemeliyik
        
        System.out.println(Arrays.toString(setir6.getBytes()));

//5. 'D' simvolunun unicode sistemində qarşılığı hansı ədəddir?
        String a = "D";
        System.out.println(Arrays.toString(a.getBytes()));

//6. Sətirin hash kodu necə hesablanır?
        String setir7 = "proqram";
        System.out.println(setir7.hashCode());
        
        //izah s[0]*31^(n - 1) + s[1]*31^(n - 2) + ... + s[n - 1] bele hesblanir       

//7. regex texnologiyası nə üçün istifadə olunur?

//regex setiri uygun hisselere bolmek ucundur

//8. String sinifinin hansı metodu ilə regex istifadə olunur?
        String setir8 = "Men-java-proglasdirma-dili-oyrenirem";

        String[] massiv = setir8.split("-");

        for (String setir9 : massiv) {
            System.out.println(setir9);

        }
//9. Neçə ədəd indexOf metodu var? və onların hər birinə aid misal göstərin.
        String setir10 = "regex texnologiyası";
        System.out.println(setir10.indexOf("r"));
        String setir11 = "replace metodu";
        System.out.println(setir11.indexOf(108));
        String setir12 = "character sinifi";
        System.out.println(setir12.indexOf("a", 5));
        String setir13 = "reverse metoDu";
        System.out.println(setir13.indexOf(68, 6));

//10. Neçə ədəd lastIndexOf metodu var? və onların hər birinə aid misal göstərin.
String setir14 = "regex texnologiyası";
        System.out.println(setir14.lastIndexOf("r"));
        String setir15 = "replace metodu";
        System.out.println(setir15.lastIndexOf(108));
        String setir16 = "character sinifi";
        System.out.println(setir16.lastIndexOf("a", 5));
        String setir17 = "reverse metoDu";
        System.out.println(setir17.lastIndexOf(68, 6));
    }

}
