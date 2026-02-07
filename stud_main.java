package Student_Management;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class stud_main {
    public static void main(String[] args) {
        ArrayList<Student> s = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int roll;
        String name;
        String branch;
        int year;
        
        int choice = 0;
        while (choice != 7) {
            System.out.println("======================================");
            System.out.println("   WELCOME TO STUDENT MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("+ enter  the choice:");
            System.out.println("1.display Student");
            System.out.println("2.add Student");
            System.out.println("3.remove Student");
            System.out.println("4.search Student");
            System.out.println("5.update Student");
            System.out.println("6. load from db");
            System.out.println("7.EXit");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("----------all Students----------");
                    for (Student std : s) {
                        std.display();
                    }
                    break;
                case 2:
                    System.out.println("----------adding Student-----------");
                    System.out.println("+  enter a roll_no:");
                    roll = sc.nextInt();
                    System.out.println("+  enter your name:");
                    name = sc.next();
                    System.out.println("+  enter your branch:");
                    branch = sc.next();
                    System.out.println("+  Enter year:");
                    year = sc.nextInt();
                    s.add(new Student(roll, name, branch, year));
                    String query = "INSERT INTO students values (" +roll+",'"+name+"','"+branch+"',"+year+");";
                    DButils.executeQuery(query);
                    break;
                case 3:
                    System.out.println("----------Removing Student-----------");
                    System.out.println("+  enter a roll_no:");
                    int rolla = sc.nextInt();
                    boolean removed = s.removeIf(students-> students.getRoll()==rolla);
                    if(removed){
                        String deleteQuery = "delete from students where id = "+rolla;
                        DButils.executeQuery(deleteQuery);
                        System.out.println("student deleted");
                    }else{
                        System.out.println("student not found");
                    }

                    break;
                case 4:
                    System.out.println("----------searching Student------------");
                    System.out.println("+  enter a roll_no:");
                    roll = sc.nextInt();
                    for (Student student : s) {
                        if (student.getRoll() == roll) {
                            student.display();
                            
                        }
                    }
                    break;

                case 5:
                    System.out.println("------------updating Student-----------");
                    System.out.println("+  enter a roll_no:");
                    roll = sc.nextInt();
                    System.out.println("+  enter a name:");
                    name = sc.next();
                    for (Student student : s) {
                        if (student.getRoll() == roll) {
                            student.setName(name);
                        }
                    }
                    break;
                case 6:
                    //load from database
                    s.clear();
                    try{
                        ResultSet rs = DButils.executeQueryGetResult("SELECT * FROM students");
                        while(rs.next()){
                            roll = rs.getInt("roll_no");
                            name = rs.getString("name");
                            branch = rs.getString("branch");
                            year = rs.getInt("year");

                            s.add(new Student(roll,name ,branch,year));

                        }
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("-----------Exiting------------");
                    System.out.println("thank you...!");
                    break;
              
                default:
                    System.out.println("Invalid choice...!");

            }
        }
        sc.close();

    }

}
