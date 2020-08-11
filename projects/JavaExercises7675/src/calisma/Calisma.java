
package calisma;

import java.util.Random;
import java.util.Scanner;

public class Calisma {
  static Random random=new Random();
 static int sira=1;
   private static void show() {
      
        System.out.println(sira+"ci calisma");
        sira++;
    }
    public static void main(String[] args) {
Calisma1();// İlk olaraq konsolda Salam sözünü, sonra növbəti sətirdə öz adınızı konsolda
//çıxardan Java proqram yazın. 
Calisma2();//İki ədəddin dəyərlərini cəmləyib nəticəni konsolda çap edən proqram yazın 
Calisma3();// İki ədəddin dəyərlərini bölüb nəticəni konsolda çap edən proqram yazın
Calisma4();//Aşağıdakı əməliyyatların nəticələrini hesablayan proqram yazın 
Calisma5();//İstifadəçidən 2 ədəd qəbul edən və ədədlərin hasilini hesablayan proqram yazın.
//Scanner istifadə edin.        
Calisma6();//İstifadəçidən 2 ədəd qəbul edən və bu ədədlərin cəmini, hasilini, fərqini, nisbətini, 
//bir-birinə bölünməsindən alınan qalığı hesablayan proqram yazın.
Calisma7(); //İstifadəçidən 1 ədəd qəbul edən və bu ədədi 1-dən 30-a kimi ədədlərin hamısına vurub nəticələri konsolda
//çap edən proqram yazın.  
Calisma8();  // Aşağıda verilmiş nəticəni konsolda çap edən proqram yazın
Calisma9();// Aşağıda verilmiş əməliyyatın nəticəsini hesablayan Java proqram yazın ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5))
Calisma10(); //Aşağıda verilmiş əməliyyatın nəticəsini hesablayan Java proqram yazın 4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11))
    }

    private static void Calisma1() {
        show();
       System.out.println("Salam\nCavid"); 
     
    }

    private static void Calisma2() {
        show();
      int bir=random.nextInt(100);
       int iki=random.nextInt(100);
       int cem=bir+iki;
        System.out.println(cem);
    }

    private static void Calisma3() {
    show();
     int bir=random.nextInt(500);
       int iki=random.nextInt(50);
       double cem=bir/iki;
        System.out.println(cem);
    }

    private static void Calisma4() {
   show();
        System.out.println(-5 + 8 * 6);
        System.out.println((55+9) % 9);
        System.out.println((55+9) %9);
        System.out.println(5 + 15 / 3 * 2 - 8 % 3);
    }

    private static void Calisma5() {
        show();
     Scanner skaner = new Scanner(System.in);
        System.out.println("1ci ededi yaz ");
        int birincieded=skaner.nextInt();
        System.out.println("2ci ededi yaz");
          int ikincieded=skaner.nextInt();
          long hasil=birincieded*ikincieded;
          System.out.println(hasil);
}

    private static void Calisma6() {
       show();
        Scanner skaner = new Scanner(System.in);
        System.out.println("1ci ededi yaz ");
        int birincieded=skaner.nextInt();
        System.out.println("2ci ededi yaz");
          int ikincieded=skaner.nextInt();
          int cem=birincieded+ikincieded;
          int ferq=birincieded-ikincieded;
          int nisbet=birincieded/ikincieded;
          int hasil=birincieded*ikincieded;
          int qaliq=birincieded%ikincieded;
          System.out.println("cem "+cem+"\nferq "+ferq+"\nnisbet "+nisbet+"\nhasil "+hasil+"\nqaliq "+qaliq);
    }

    private static void Calisma7() {
     show();
        Scanner skaner = new Scanner(System.in);
        System.out.println("ededi yaz ");
          int birincieded=skaner.nextInt();
          for (int i = 1; i <= 30; i++) {
              long cem=birincieded*i;
              System.out.println(birincieded+"*"+i+"="+cem);
              
        }
          
    }

    private static void Calisma8() {
    show();
        System.out.println("   J    a   v     v  a                                                  \n"+
        "    J   a a   v   v  a a                                                 \n"+ 
       "J  J  aaaaa   V V  aaaaa                                                \n" 
        +" JJ  a     a   V  a     a");
    }

    private static void Calisma9() {
    show();
        System.out.println(((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)));
    }
      private static void Calisma10() {
    show();
        System.out.println(4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11)));
    }
}
