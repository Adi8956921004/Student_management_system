package Student_Management;
import java.util.*;


class Student
{
    int roll_no;
    String name;
    String branch;
    int year;
    Student(int roll_no,String name, String branch, int year){
        this.roll_no = roll_no;
        this.name = name;
        this.branch = branch;
        this.year=year;

    }
    public int getRoll(){return roll_no;}
    public String getName(){return name;}
    public String getBranch(){return branch;}
    public int getYear(){ return year;}

    // public void setRoll(int roll_no ){this.roll_no  = roll_no;}
    public void setName(String name ){this.name   = name;}
    public void setBranch(String branch){this.branch  = branch;}
    public void setYear(int year ){this.year  = year;}
    
    void display(){
        System.out.println(roll_no+"\t"+name+"\t"+branch+"\t"+year);
    }
}
