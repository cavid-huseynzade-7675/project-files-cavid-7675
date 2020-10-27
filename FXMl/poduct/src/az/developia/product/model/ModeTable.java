
package az.developia.product.model;




public class ModeTable {
    // burdaki deyerleri getter and setter eleyirik 
 String id,name,qiymet,username;

    public ModeTable(String id, String name, String qiymet, String username) {
        this.id = id;
        this.name = name;
        this.qiymet = qiymet;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQiymet() {
        return qiymet;
    }

    public void setQiymet(String qiymet) {
        this.qiymet = qiymet;
    }


  

   
   

   
         
}
