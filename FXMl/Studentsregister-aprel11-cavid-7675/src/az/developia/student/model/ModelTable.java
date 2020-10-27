
package az.developia.student.model;

import java.sql.Date;


public class ModelTable {
    // burdaki deyerleri getter and setter eleyirik 
 String id,username,name,surname,adress,phone,valname ,TBdt,sector1;


    public String getSector1() {
        return sector1;
    }

    public void setSector1(String sector1) {
        this.sector1 = sector1;
    }


   
    

    public String getTBdt() {
        return TBdt;
    }

    public void setTBdt(String TBdt) {
        this.TBdt = TBdt;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

  
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValname() {
        return valname;
    }

    public void setValname(String valname) {
        this.valname = valname;
    }

    public ModelTable(String id, String username, String name, String surname, String TBdt, String adress, String phone, String valname,String sector1) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
       this.TBdt=TBdt; 
        this.adress = adress;
        this.phone = phone;
        this.valname = valname;
        this.sector1 =sector1;
     
    }
         
}
