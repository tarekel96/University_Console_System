import java.util.Collections;
import java.util.LinkedList;

/**
  * UnderGraduateStudents is a class that represents undergraduate students
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class UnderGraduateStudents extends Students {

  // Fields
  /** m_numberOfCourses is an int that represents an undergraduate student's number of courses */
  private int m_numberOfCourses;
  /** m_scholarshipAmount is the undergraduate student's scholarship amount */
  private double m_scholarshipAmount;

  /**
    * Default Constructor - it assigns some default values to the UnderGraduateStudents fields
  */
  public UnderGraduateStudents(){
    super();
    m_numberOfCourses= -1;
    m_scholarshipAmount = -100.00;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the undergraduate student's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param facultyId assigned to the m_facultyId field of the faculty member
    * @param deparment assigned to the m_deparment field of the faculty member
    * @param yearlySalary assigned to the m_yearlySalary field of the faculty member
    * @param numberOfPapers assigned to the m_numberOfPapers field of the faculty member
    * @param m_numberOfCourses assigned to the m_numberOfCourses field of the undergraduate student member
    * @param n_scholarshipAmount assigned to the m_scholarshipAmount field of the undergraduate student member
  */
  public UnderGraduateStudents(String name, int age, String address, String phoneNumber, int yearBegan, int studentId, String major, String minor, String classStanding, int numberOfCourses, double scholarshipAmount){
    super(name, age, address, phoneNumber, yearBegan, studentId, major, minor, classStanding);
    m_numberOfCourses = numberOfCourses;
    m_scholarshipAmount = scholarshipAmount;
  }

  /**
    * Copy Constructor - it creates a copy of UnderGraduateStudents instance
    * @param c - the UnderGraduateStudents instance that is being copied
  */
  public UnderGraduateStudents(UnderGraduateStudents c){
    super(c);
    m_numberOfCourses = c.m_numberOfCourses;
    m_scholarshipAmount = c.m_scholarshipAmount;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Students.
    * @return returns the type of Student
  */
  @Override
  public String getClassType(){
    return "Undergraduate Student";
  };
  /**
    * This is an accessor method
    * @return returns the Undergraduate Student's number of courses
  */
  public int getNumberOfCourses(){
    return m_numberOfCourses;
  }
  /**
    * This is an accessor method
    * @return returns the Undergraduate Student's scholarship amount
  */
  public double getScholarshipAmount(){
    return m_scholarshipAmount;
  }

  // Mutators
  /**
    * This is a mutator method
    * @param numberOfCourses is set equal to m_numberOfCourses
  */
  public void setNumberOfCourses(int numberOfCourses){
    m_numberOfCourses = numberOfCourses;
  }
  /**
    * This is a mutator method
    * @param scholarshipAmount is set equal to m_scholarshipAmount
  */
  public void setScholarshipAmount(double scholarshipAmount){
    m_scholarshipAmount = scholarshipAmount;
  }

  /**
    * toString - override the default toString Object method
    * @return returns the contents of an Undergraduate Student in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nNumber of Courses: " + m_numberOfCourses;
    ret += "\nScholarship Amount: " + m_scholarshipAmount;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object ugs){
    if(!(ugs instanceof UnderGraduateStudents)){
      return false;
    }
    UnderGraduateStudents c = (UnderGraduateStudents)ugs;
    if((m_numberOfCourses != c.m_numberOfCourses) || (m_scholarshipAmount != c.m_scholarshipAmount)){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of an undergraduate student
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nNumber of Courses: " + m_numberOfCourses;
    ret += "\nScholarship Amount: " + m_scholarshipAmount;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return returns the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Number of Courses: " + m_numberOfCourses);
    stringLL.add("Scholarship Amount: " + m_scholarshipAmount);
    Collections.sort(stringLL);
    return stringLL;
  }

  public static void main(String[] args){
    // UnderGraduateStudents gs1 = new UnderGraduateStudents();
    // UnderGraduateStudents gs2 = new UnderGraduateStudents("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0007, "Philosophy", "Creative Writing", "Sophomore", 5, 10000);
    // UnderGraduateStudents gs3 = new UnderGraduateStudents("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0007, "Philosophy", "Creative Writing", "Sophomore", 5, 10000);
    // System.out.println(gs1.toString());
    // System.out.println(gs2.toString());
    // System.out.println(gs1.equals(gs1));
    // System.out.println(gs1.equals(gs2));
    // System.out.println(gs3.equals(gs3));
    UnderGraduateStudents gs4 = new UnderGraduateStudents("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Philosophy", "Creative Writing", "Sophomore", 5, 10000);
    System.out.println(gs4.printAlphabetically(gs4.orderAlphabetically()));
    // UnderGraduateStudents gs5 = new UnderGraduateStudents(gs4);
    // System.out.println(gs4.compareTo(gs5));
    // System.out.println(gs5.print());
  }

}
