package com.main;

public class calisma {

    public static void main(String[] args) {

        //1. Simvol dəyişəni yaradın, davamında o dəyişənin daxilində olan
        //dəyərin rəqəm olmasını yoxlayın.
        Character simvol = new Character('2');
        System.out.println(Character.isDigit(simvol));

        // 2. Simvol dəyişəni yaradın, davamında o dəyişənin daxilində olan
        //dəyərin hərf olmasını yoxlayın.
        Character simvol1 = new Character('/');
        System.out.println(Character.isLetter(simvol1));

        //3. Verilmiş simvolun kiçik simvol olub-olmadığını yoxlamaq üçün hansı
        //metoddan istifadə olunur? və misal göstərin.
        Character simvol2 = new Character('B');
        System.out.println(Character.isLowerCase(simvol2));

        //4. Verilmiş simvolun əlifbada böyük olan halını əldə etmək üçün hansı
        // metoddan istifadə olunur ? və  misal göstərin.
        Character simvol3 = new Character('w');
        System.out.println(Character.toUpperCase(simvol3));

        // 5. Verilmiş simvolun əlifbada kiçik olan halını əldə etmək üçün hansı
        // metoddan istifadə olunur ? və  misal göstərin.
        Character simvol4 = new Character('Y');
        System.out.println(Character.toLowerCase(simvol4));

        //6. Verilmiş simvolun böyük simvol olub-olmadığını yoxlamaq üçün hansı
        //metoddan istifadə olunur? və misal göstərin.
        Character simvol5 = new Character('B');
        System.out.println(Character.isUpperCase(simvol5));

        //7. Verilmiş simvolun boşluq simvolu olub - olmadığını yoxlamaq üçün hansı metoddan istifadə olunur
        // ? və misal göstərin.
        Character simvol6 = new Character(' ');
        System.out.println(Character.isWhitespace(simvol6));
    }

}
