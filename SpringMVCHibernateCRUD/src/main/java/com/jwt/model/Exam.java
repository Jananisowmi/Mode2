

package com.jwt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Exam")
public class Exam implements Serializable {

private static final long serialVersionUID = -3465813074586302847L;

@Id
@Column(name="mi")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int mi;

private String subName;
    private double marks;
    private int sid;

    public int getMi() {
    return mi;
}

public void setMi(int mi) {
this.mi = mi;
}
public String getSubName() {
return subName;
}
public void setSubName(String subName) {
this.subName = subName;
}
public double getMarks() {
return marks;
}
public void setMarks(double marks) {
this.marks = marks;
}
public int getSid() {
return sid;
}
public void setSid(int sid) {
this.sid = sid;
}
public static long getSerialversionuid() {
return serialVersionUID;
}
}