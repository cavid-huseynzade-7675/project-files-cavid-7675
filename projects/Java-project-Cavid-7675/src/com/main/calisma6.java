package com.main;

import java.time.LocalDateTime;
import java.util.Arrays;
import javafx.util.converter.LocalDateTimeStringConverter;

public class calisma6 {

    public static void main(String[] args) {
        
//1. Massivlər üzərində işləmək üçün hansı sinifdən istifadə
//olunur? və bu sinif hansı paketdə yerləşir?

//arrays sinifinden istifade olunur, java.util paketindedir

//2. Arrays sinifində olan hansı metod ilə axtarış aparmaq olar?
//Bu metodun düzgün işləməsi üçün hansı şərtlər ödənməlidir?
        String[] s = {"a", "b", "t", "q", "j", "e", "y", "f", "g", "w"};
        Arrays.sort(s);
        System.out.println(Arrays.binarySearch(s, "t"));

        //izah: axtarisi binarySearch metodu ile eleyirek,binarySearch metodu ancaq 
        //massivin deyerleri ardicil duzulmusse duzgun isleyir
        //onun ucun de bir metod var sort metodu
        
        
//3. 2 ədəd int tipli massiv yaradın və onların bir birinə bərabər olub-olmamasını
//yoxlayın. (Massivlərin daxilinə minimum 4 element yazın).
        int[] i1 = {12, 156, 165, 79, 6, 19, 46, 849, 132, 489, 49, 465};
        int[] i2 = {12, 156, 165, 79, 6, 19, 46, 849, 132, 489, 49, 465};

        System.out.println(Arrays.equals(i1, i2));
        //true
        int[] i3 = {16, 189, 165, 16, 216, 984, 624, 489};
        int[] i4 = {1645, 164, 996, 1, 654, 985, 164, 5, 465, 16, 4};
        System.out.println(Arrays.equals(i3, i4));
        //false

//4. int tipli massiv yaradın və daxilinə 7 ədəd element yazın.
//İlk olaraq onun cari vəziyyətini konsola çap edin.
//Sonra onu artan sıra ilə sortlaşdırın.
//Sonra onun cari vəziyyətini konsola çap edin.
        int[] i5 = {24, 234, 63, 536, 334, 346, 3};
        System.out.println(Arrays.toString(i5));
        Arrays.sort(i5);
        System.out.println(Arrays.toString(i5));
//5. Java-da tarixlərlə işləmək üçün hansı siniflər var?

//Date,LocalDate,LocalDateTome


//6. Sistemin cari tarixini necə tapmaq olar?
//Buna aid misal yazın.

        LocalDateTime tarix = LocalDateTime.now();
        System.out.println(tarix.toString());

//7. Hazırkı olduğumuz ili necə tapmaq olar?
//Buna aid misal yazın.

        LocalDateTime tarix1 = LocalDateTime.now();
        System.out.println(tarix1.getYear());
        
//8. Hazırkı olduğumuz ayın gününü necə tapmaq olar?
//Buna aid misal yazın.

        LocalDateTime tarix2 = LocalDateTime.now();
        System.out.println(tarix2.getDayOfMonth());
//9. Hazırkı olduğumuz saatı necə tapmaq olar?
//Buna aid misal yazın.

        LocalDateTime tarix3 = LocalDateTime.now();
        System.out.println(tarix3.getHour());
        
//10. İki tarixi bir-biri ilə necə müqayisə olar?
//Buna aid misal yazın.
//iki yolu var compareTo ve boolean equals

        LocalDateTime tarix4 = LocalDateTime.now();
        LocalDateTime tarix5 = LocalDateTime.now();
        System.out.println(tarix4.compareTo(tarix5));

        LocalDateTime tarix6 = LocalDateTime.now();
        LocalDateTime tarix7 = LocalDateTime.now();
        System.out.println(tarix6.equals(tarix7));
        
    }

}
