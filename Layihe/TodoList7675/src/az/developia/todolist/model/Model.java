
package az.developia.todolist.model;

import java.sql.Date;


public class Model {
  int id,gun,necegunqalib;
  String tapsiriq,kateqoriya,status;
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

    public int getNecegunqalib() {
        return necegunqalib;
    }

    public void setNecegunqalib(int necegunqalib) {
        this.necegunqalib = necegunqalib;
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
