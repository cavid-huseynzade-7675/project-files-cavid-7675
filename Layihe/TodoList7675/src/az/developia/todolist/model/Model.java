
package az.developia.todolist.model;

import java.sql.Date;


public class Model {
  int id,gun;
  String tapsiriq,kateqoriya,status,username;
long necegunqalib;

    public long getNecegunqalib() {
        return necegunqalib;
    }

    public void setNecegunqalib(long necegunqalib) {
        this.necegunqalib = necegunqalib;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
 Date tarix;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

  

    public String getTapsiriq() {
        return tapsiriq;
    }

    public void setTapsiriq(String tapsiriq) {
        this.tapsiriq = tapsiriq;
    }

    public String getKateqoriya() {
        return kateqoriya;
    }

    public void setKateqoriya(String kateqoriya) {
        this.kateqoriya = kateqoriya;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTarix() {
        return tarix;
    }

    public void setTarix(Date tarix) {
        this.tarix = tarix;
    }
   
    
}
