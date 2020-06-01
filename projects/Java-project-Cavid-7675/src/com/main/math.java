package com.main;

import java.util.Scanner;

public class math {

    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        //Bir ədəd sətir dəyişəni yaradın və sonra bu
        //dəyişəni int dəyişəninə parse edin. (açıq sual)
        System.out.println("int tipinde eded yazin");
        String s = skaner.nextLine();
        int i = Integer.parseInt(s);
        System.out.println("magazada" + i + "kq et var");
        System.out.println("--------------------------");
        //2. Bir ədəd sətir dəyişəni yaradın və sonra bu
        //dəyişəni double dəyişəninə parse edin. (açıq sual)
        System.out.println("double tipinde eded yazin");
        String a = skaner.nextLine();
        double b = Double.valueOf(a);
        System.out.println("bu meselenin cavabi " + b + " dir");
         System.out.println("--------------------------");
        // 3. Verilmiş ədədi necə yuvarlaqlaşdırmaq olar?
        //(açıq sual). Misal göstərin.
        System.out.println("double tipinde eded yazin");
        double w = skaner.nextDouble();
        System.out.println(Math.rint(w));
         System.out.println("--------------------------");
        //4. Ədədlərin qüvvət üstünü tapmaq üçün Java
        //-da Math sinifinin hansı metodu istifadə olunur?
        // (açıq sual)
        System.out.println("eded yazin");
        int r = skaner.nextInt();
        System.out.println("qüvvət üstünü dusen eded yazin");
        int e = skaner.nextInt();
        System.out.print(Math.pow(e, b));
        System.out.print("cavab budur");
    }

}
