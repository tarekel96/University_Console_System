import java.util.Collections;
import java.util.LinkedList;

/**
  * FullProfessor is a class that represents full professors
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class FullProfessor extends Faculty {

  // Fields
  /** m_yearsUntilRetirement is an int that represents a full professor's number of years until retirement */
  private int m_yearsUntilRetirement;

  /**
    * Default Constructor - it assigns some default values to the FullProfessor fields
  */
  public FullProfessor(){
    super();
    m_yearsUntilRetirement= -1;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the full professor's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param facultyId assigned to the m_facultyId field of the faculty member
    * @param deparment assigned to the m_deparment field of the faculty member
    * @param yearlySalary assigned to the m_yearlySalary field of the faculty member
    * @param numberOfPapers assigned to the m_numberOfPapers field of the faculty member
    * @param m_yearsUntilRetirement assigned to the m_yearsUntilRetirement field of the full professor member
  */
  public FullProfessor(String name, int age, String address, String phoneNumber, int yearBegan, int facultyId, String department, double yearlySalary, int numberOfPapers, int yearsUntilRetirement){
    super(name, age, address, phoneNumber, yearBegan, facultyId, department, yearlySalary, numberOfPapers);
    m_yearsUntilRetirement = yearsUntilRetirement;
  }

  /**
    * Copy Constructor - it creates a copy of FullProfessor instance
    * @param c - the FullProfessor instance that is being copied
  */
  public FullProfessor(FullProfessor c){
    super(c);
    m_yearsUntilRetirement = c.m_yearsUntilRetirement;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Faculty.
    * @return returns the type of Faculty
  */
  @Override
  public String getClassType(){
    return "Full Professor";
  };
  /**
    * This is an accessor method
    * @return returns the Full Professor's yearsUntilRetirement field
  */
  public int getYearsUntilRetirement(){
    return m_yearsUntilRetirement;
  }
  // Mutators
  /**
    * This is a mutator method
    * @param yearsUntilRetirement is set equal to m_yearsUntilRetirement
  */
  public void setYearsUntilRetirement(int yearsUntilRetirement){
    m_yearsUntilRetirement = yearsUntilRetirement;
  }

  /**
    * toString - override the default toString Object method
    * @return returns the contents of a Full Professor in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nYears Until Retirement: " + m_yearsUntilRetirement;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object fp){
    if(!(fp instanceof FullProfessor)){
      return false;
    }
    FullProfessor c = (FullProfessor)fp;
    if(m_yearsUntilRetirement != c.m_yearsUntilRetirement){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of a full professor
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nYears Until Retirement: " + m_yearsUntilRetirement;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return returns the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Years Until Retirement: " + m_yearsUntilRetirement);
    Collections.sort(stringLL);
    return stringLL;
  }

  public static void main(String[] args){
    // FullProfessor ap1 = new FullProfessor();
    FullProfessor ap2 = new FullProfessor("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Computer Science", 100000.00, 12, 14);
    System.out.println(ap2.printAlphabetically(ap2.orderAlphabetically()));
    // FullProfessor ap3 = new FullProfessor("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Computer Science", 100000.00, 12, 14);
    // System.out.println(ap1.toString());
    // System.out.println(ap2.toString());
    // System.out.println(ap1.equals(ap1));
    // System.out.println(ap1.equals(ap2));
    // System.out.println(ap3.equals(ap3));
    // FullProfessor ap4 = new FullProfessor("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Computer Science", 100000.00, 12, 14);
    // FullProfessor ap5 = new FullProfessor(ap4);
    // System.out.println(ap5);
  }

}
