
package az.developia.student.model;

import java.sql.Date;


public class ModelMuvaqile {
 int id,studentid;
 double price;
 Date start,end;
 String name;

    public ModelMuvaqile(int id, int studentid, double price, Date start, Date end, String name) {
        this.id = id;
        this.studentid = studentid;
        this.price = price;
        this.start = start;
        this.end = end;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
