
package mesele;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class HashMapMesle {
static int sira=1;

    static void show() {

        System.out.println(sira + "ci calisma");
        sira++;
    }
    public static void main(String[] args) {
         Calisma1();
        Calisma2();
        Calisma3();
        Calisma4();
        Calisma5();
        Calisma6();
        Calisma7();
        Calisma8();
        Calisma9();
        Calisma10();
        Calisma11();
        Calisma12();
        
    }

    private static void Calisma1() {
      show();
   HashMap<Integer,String> hash_map=new HashMap<>();
  hash_map.put(1, "Red");
  hash_map.put(2, "Green");
  hash_map.put(3, "Black");
  hash_map.put(4, "White");
  hash_map.put(5, "Blue");
  for(Map.Entry x:hash_map.entrySet()){  
   System.out.println(x.getKey()+" "+x.getValue());  
  }  
              }

    private static void Calisma2() {
    show();
     HashMap<Integer,String> hash_map= new HashMap<Integer,String>();  
  hash_map.put(1, "Red");
  hash_map.put(2, "Green");
  hash_map.put(3, "Black");
  hash_map.put(4, "White");
  hash_map.put(5, "Blue");
  System.out.println("Size of the hash map: "+hash_map.size());
    }

    private static void Calisma3() {
     show();
 
  HashMap <Integer,String> hash_map1 = new HashMap <Integer,String> ();
  HashMap <Integer,String> hash_map2 = new HashMap <Integer,String> ();
 
  hash_map1.put(1, "Red");
  hash_map1.put(2, "Green");
  hash_map1.put(3, "Black");
  System.out.println("\nValues in first map: " + hash_map1);
  hash_map2.put(4, "White");
  hash_map2.put(5, "Blue");
  hash_map2.put(6, "Orange");
  System.out.println("\nValues in second map: " + hash_map2);

  
  hash_map2.putAll(hash_map1);
  System.out.println("\nNow values in second map: " + hash_map2);
    }

    private static void Calisma4() {
     show();
    HashMap <Integer,String> hash_map = new HashMap <Integer,String> ();
  hash_map.put(1, "Red");
  hash_map.put(2, "Green");
  hash_map.put(3, "Black");
  hash_map.put(4, "White");
  hash_map.put(5, "Blue");
  System.out.println("The Original linked map: " + hash_map);
  hash_map.clear();
  System.out.println("The New map: " + hash_map);
    }

    private static void Calisma5() {
      show();
    HashMap <Integer,String> hash_map = new HashMap <Integer,String> ();
  hash_map.put(1, "Red");
  hash_map.put(2, "Green");
  hash_map.put(3, "Black");
  hash_map.put(4, "White");
  hash_map.put(5, "Blue");
  boolean result = hash_map.isEmpty();

  System.out.println("Is hash map empty: " + result);
 
  hash_map.clear();
  
  result = hash_map.isEmpty();
  
  System.out.println("Is hash map empty: " + result);
    }

    private static void Calisma6() {
       show();
    HashMap<Integer,String> hash_map= new HashMap<Integer,String>();  
  hash_map.put(1, "Red");
  hash_map.put(2, "Green");
  hash_map.put(3, "Black");
  hash_map.put(4, "White");
  hash_map.put(5, "Blue");
   System.out.println("The Original map: " + hash_map);
   HashMap<Integer,String> new_hash_map= new HashMap<Integer,String>(); 
   new_hash_map = (HashMap)hash_map.clone();     
   System.out.println("Cloned map: " + new_hash_map);      
    }

    private static void Calisma7() {
      show();
    HashMap < String, Integer > hash_map = new HashMap < String, Integer > ();
  hash_map.put("Red", 1);
  hash_map.put("Green", 2);
  hash_map.put("Black", 3);
  hash_map.put("White", 4);
  hash_map.put("Blue", 5);
  System.out.println("The Original map: " + hash_map);
  System.out.println("1. Is key 'Green' exists?");
  if (hash_map.containsKey("Green")) {
   System.out.println("yes! - " + hash_map.get("Green"));
  } else {
   System.out.println("no!");
  }

  System.out.println("\n2. Is key 'orange' exists?");
  if (hash_map.containsKey("orange")) {
   System.out.println("yes! - " + hash_map.get("orange"));
  } else {
   System.out.println("no!");
  }
    }

    private static void Calisma8() {
     show();
     HashMap < Integer, String > hash_map = new HashMap < Integer, String > ();
  hash_map.put(1, "Red");
  hash_map.put(2, "Green");
  hash_map.put(3, "Black");
  hash_map.put(4, "White");
  hash_map.put(5, "Blue");
  System.out.println("The Original map: " + hash_map);
  System.out.println("1. Is value \'Green\' exists?");
  if (hash_map.containsValue("Green")) {
   System.out.println("Yes! ");
  } else {
   System.out.println("no!");
  }

  System.out.println("\n2. Is value \'orange\' exists?");
  if (hash_map.containsValue("orange")) {
   System.out.println("yes! - " );
  } else {
   System.out.println("No!");
  }
    }

    private static void Calisma9() {
     show();
    HashMap < Integer, String > hash_map = new HashMap < Integer, String > ();
  hash_map.put(1, "Red");
  hash_map.put(2, "Green");
  hash_map.put(3, "Black");
  hash_map.put(4, "White");
  hash_map.put(5, "Blue"); 
  Set set = hash_map.entrySet();
  System.out.println("Set values: " + set);
    }

    private static void Calisma10() {
    show();
    HashMap<Integer,String> hash_map= new HashMap<Integer,String>();  
   hash_map.put(1,"Red");
  hash_map.put(2,"Green");
  hash_map.put(3,"Black");
  hash_map.put(4,"White");
  hash_map.put(5,"Blue");
   String val=(String)hash_map.get(3); 
   System.out.println("Value for key 3 is: " + val);
    }

    private static void Calisma11() {
    show();
    HashMap<Integer,String> hash_map= new HashMap<Integer,String>();  
  
  hash_map.put(1,"Red");
  hash_map.put(2,"Green");
  hash_map.put(3,"Black");
  hash_map.put(4,"White");
  hash_map.put(5,"Blue");
  
 
   Set keyset = hash_map.keySet();
      

   System.out.println("Key set values are: " + keyset);  
    }

    private static void Calisma12() {
       show();
     HashMap<Integer,String> hash_map= new HashMap<Integer,String>();  
    hash_map.put(1,"Red");
  hash_map.put(2,"Green");
  hash_map.put(3,"Black");
  hash_map.put(4,"White");
  hash_map.put(5,"Blue");
       
   System.out.println("Collection view is: "+ hash_map.values());
    }
}
