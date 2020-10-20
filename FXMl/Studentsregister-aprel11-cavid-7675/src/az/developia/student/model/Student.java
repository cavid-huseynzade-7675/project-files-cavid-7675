
package az.developia.student.model;

import java.sql.Date;
import java.time.LocalDate;


public class Student {
     // burdaki deyerleri getter and setter eleyirik 
  private int id;
  private String name;
  private String username;
  private String surname;
  private String adres;
  private String telefon;
  private String vname;
    private String sector2;

    public String getSector2() {
        return sector2;
    }

    public void setSector2(String sector2) {
        this.sector2 = sector2;
    }
 private Date birthday;
 

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public void setBirthday(LocalDate dt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
          
}
