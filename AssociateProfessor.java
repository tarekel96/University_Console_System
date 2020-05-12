import java.util.Collections;
import java.util.LinkedList;
/**
  * AssociateProfessor is a class that represents associate professors
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class AssociateProfessor extends Faculty {

  // Fields
  /** m_yearsSinceTenure is an int that represents an associate professor's number of tenure years */
  private int m_yearsSinceTenure;

  /**
    * Default Constructor - it assigns some default values to the AssociateProfessor fields
  */
  public AssociateProfessor(){
    super();
    m_yearsSinceTenure= -1;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the associate professor's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param facultyId assigned to the m_facultyId field of the faculty member
    * @param deparment assigned to the m_deparment field of the faculty member
    * @param yearlySalary assigned to the m_yearlySalary field of the faculty member
    * @param numberOfPapers assigned to the m_numberOfPapers field of the faculty member
    * @param m_yearsSinceTenure assigned to the m_yearsSinceTenure field of the associate professor member
  */
  public AssociateProfessor(String name, int age, String address, String phoneNumber, int yearBegan, int facultyId, String department, double yearlySalary, int numberOfPapers, int yearsSinceTenure){
    super(name, age, address, phoneNumber, yearBegan, facultyId, department, yearlySalary, numberOfPapers);
    m_yearsSinceTenure = yearsSinceTenure;
  }

  /**
    * Copy Constructor - it creates a copy of AssociateProfessor instance
    * @param c - the AssociateProfessor instance that is being copied
  */
  public AssociateProfessor(AssociateProfessor c){
    super(c);
    m_yearsSinceTenure = c.m_yearsSinceTenure;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Faculty.
    * @return returns the type of Faculty
  */
  @Override
  public String getClassType(){
    return "Associate Professor";
  };
  /**
    * This is an accessor method
    * @return returns the Associate Professor's yearsSinceTenure field
  */
  public int getYearsSinceTenure(){
    return m_yearsSinceTenure;
  }
  // Mutators
  /**
    * This is a mutator method
    * @param yearsSinceTenure is set equal to m_yearsSinceTenure
  */
  public void setYearsSinceTenure(int yearsSinceTenure){
    m_yearsSinceTenure = yearsSinceTenure;
  }

  /**
    * toString - override the default toString Object method
    * @return returns the contents of an Associate Professor in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nYears Since Tenure: " + m_yearsSinceTenure;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object ap){
    if(!(ap instanceof AssociateProfessor)){
      return false;
    }
    AssociateProfessor c = (AssociateProfessor)ap;
    if(m_yearsSinceTenure != c.m_yearsSinceTenure){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of an associate professor
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nYears Since Tenure: " + m_yearsSinceTenure;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return returns the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Years Since Tenure: " + m_yearsSinceTenure);
    Collections.sort(stringLL);
    return stringLL;
  }

   public static void main(String[] args){
  //   AssociateProfessor ap1 = new AssociateProfessor();
     AssociateProfessor ap2 = new AssociateProfessor("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Computer Science", 100000.00, 12, 4);
     System.out.println(ap2.printAlphabetically(ap2.orderAlphabetically()));
  //   AssociateProfessor ap3 = new AssociateProfessor("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Computer Science", 100000.00, 12, 4);
  //   System.out.println(ap1.toString());
  //   System.out.println(ap2.toString());
  //   System.out.println(ap1.equals(ap1));
  //   System.out.println(ap1.equals(ap2));
  //   System.out.println(ap3.equals(ap3));
  //   AssociateProfessor ap4 = new AssociateProfessor("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Computer Science", 100000.00, 12, 4);
  //   AssociateProfessor ap5 = new AssociateProfessor(ap4);
  //   System.out.println(ap5);
  //   System.out.println(ap5.print());
  //   System.out.println(ap2.compareTo(ap1));
   }

}
