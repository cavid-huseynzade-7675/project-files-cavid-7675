
package com.main;

import static java.time.Clock.system;


public class Calisma2 {
    public static void main(String[] args) {
//1. String sinifindən obyekt yaradın və daxilinə "Java" dəyərini mənimsədin,
//davamında bu obyektin daxilində olan simvolların sayını metod vasitəsilə tapıb
//konsolda çap edin
String setir="Java" ;
        System.out.println(setir.length());


//2. String sinifinin neçə ədəd qurucu konstruktoru var?
System.out.println("11 eded qurucu konstruktoru var");

//3. String sinfinin əsas çatışmayan xüsusiyyətini yazılı olaraq izah edin və
//bu çatışmayan xüsusiyyəti aradan qaldırmaq üçün hansı sinifləri alternativ
//olaraq istifadə etmək olar?
System.out.println("biz string obyektinin ustune nese artirmaq isteyende onu kopyalayir ve "
        + "elave string yaratmis olur ve bu ramda zibil kimi qalir bu da performansi azaldir"
        + " bunun alternativ yolu stringbuilderdir");

//4. StringBuffer sinifindən obyekt yaradın və onun daxilinə bir neçə sətir
//əlavə edin, davamında bu obyektin tutumunu konsolda çap edin.
StringBuffer sb =new StringBuffer("Github");
        System.out.println(sb.capacity());
        //Izah:cavab 22 olacaq cunki StringBuffer 16 dene artiq yer saxlayir 
        //cunki eleva eden de performans azalmasin deye


//5. StringBuffer sinifindən obyekt yaradın və onun daxilinə bir neçə sətir
//əlavə edin, davamında onun daxilində olan sətiri tərsinə çevirib konsolda
//çap edin.
StringBuffer sb2 =new StringBuffer(" Bu metod, ona daxil edilən dəyərin daxilində olan simvolları tərsinə çevirir.");
        System.out.println(sb2.reverse());

//6. StringBuffer sinifində olan "delete" metodu necə yazılır və onun işləmə prinsipini
//yazılı izah edin.
StringBuffer sb3 =new StringBuffer("James minecraft Gosling");
        System.out.println(sb3.delete(6, 15));
        //Izah:delete metodu ona daxil edilən dəyərin daxilində olan simvolları, 
        //"start" indeksindən"end" indeksinə kimi silir.
        

//7. StringBuffer sinifində olan "insert" metodu necə yazılır və onun işləmə prinsipini
//yazılı izah edin.
StringBuffer sb4=new StringBuffer(" metodu, daxil edilən dəyərin daxilində olan simvolları tərsinə çevirir.");
        System.out.println(sb4.insert(0, "reverse"));
        //Izah:insert metodu hansisa indekse  nese elave etmeyimize yarayir

//8. StringBuffer sinifində olan "replace" metodu necə yazılır və onun işləmə prinsipini
//yazılı izah edin.
StringBuffer sb5=new StringBuffer("mark zukerberq instagrami yaradmisdir");
        System.out.println(sb5.replace(15, 25, "facebooku"));
        //izah:replace meodu start indeksinden end indeksine qeder simvollari deyisdirir

//9. StringBuffer sinifindən obyekt yaradın və onun daxilinə dövr vasitəsilə
//1 0000 000 dəfə "a" stringini əlavə edin, prosesin başlanması və bitməsi
//zamanını konsolda çap edin.
//(Sistemin cari zamanını tapmaq üçün System.currentTimeMillis() istifadə olunur)
   StringBuffer sb6=new StringBuffer();
   String s="";
        System.out.println("basladi");
        
         long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
          sb6.append("a");
   
        }
      System.out.println("bitdi");
    long currentTimeMillis1 = System.currentTimeMillis();
    long a=currentTimeMillis1-currentTimeMillis;
        System.out.println("10 milyon defe artirmayi "+a+" milli saniye de  edir");
    }
 
}
