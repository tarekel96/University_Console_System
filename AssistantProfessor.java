import java.util.Collections;
import java.util.LinkedList;

/**
  * AssistantProfessor is a class that represents assistant professors
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class AssistantProfessor extends Faculty {

  // Fields
  /** m_yearsUntilTenure is an int that represents an assistant professor's number of years until tenure */
  private int m_yearsUntilTenure;

  /**
    * Default Constructor - it assigns some default values to the AssistantProfessor fields
  */
  public AssistantProfessor(){
    super();
    m_yearsUntilTenure = -1;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the assistant professor's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param facultyId assigned to the m_facultyId field of the faculty member
    * @param deparment assigned to the m_deparment field of the faculty member
    * @param yearlySalary assigned to the m_yearlySalary field of the faculty member
    * @param numberOfPapers assigned to the m_numberOfPapers field of the faculty member
    * @param yearsUntilTenure assigned to the m_yearsUntilTenure field of the assistant professor member
  */
  public AssistantProfessor(String name, int age, String address, String phoneNumber, int yearBegan, int facultyId, String department, double yearlySalary, int numberOfPapers, int yearsUntilTenure){
    super(name, age, address, phoneNumber, yearBegan, facultyId, department, yearlySalary, numberOfPapers);
    m_yearsUntilTenure = yearsUntilTenure;
  }

  /**
    * Copy Constructor - it creates a copy of AssistantProfessor instance
    * @param c - the AssistantProfessor instance that is being copied
  */
  public AssistantProfessor(AssistantProfessor c){
    super(c);
    m_yearsUntilTenure = c.m_yearsUntilTenure;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Faculty.
    * @return returns the type of Faculty
  */
  @Override
  public String getClassType(){
    return "Assistant Professor";
  };
  /**
    * This is an accessor method
    * @return returns the AssistantProfessor's yearsUntilTenure field
  */
  public int getYearsUntilTenure(){
    return m_yearsUntilTenure;
  }
  // Mutators
  /**
    * This is a mutator method
    * @param yearsUntilTenure is set equal to m_yearsUntilTenure
  */
  public void setYearsUntilTenure(int yearsUntilTenure){
    m_yearsUntilTenure = yearsUntilTenure;
  }

  /**
    * toString - override the default toString Object method
    * @return returns the contents of an Assistant Professor in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nYears Until Tenure: " + m_yearsUntilTenure;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object ap){
    if(!(ap instanceof AssistantProfessor)){
      return false;
    }
    AssistantProfessor c = (AssistantProfessor)ap;
    if(m_yearsUntilTenure != c.m_yearsUntilTenure){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of an assistant professor
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nYears Until Tenure: " + m_yearsUntilTenure;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return returns the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Years Until Tenure: " + m_yearsUntilTenure);
    Collections.sort(stringLL);
    return stringLL;
  }

   public static void main(String[] args){
  //   AssistantProfessor ap1 = new AssistantProfessor();
     AssistantProfessor ap2 = new AssistantProfessor("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Computer Science", 100000.00, 12, 8);
     System.out.println(ap2.printAlphabetically(ap2.orderAlphabetically()));
  //   AssistantProfessor ap3 = new AssistantProfessor("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Computer Science", 100000.00, 12, 8);
  //   System.out.println(ap1.toString());
  //   System.out.println(ap2.toString());
  //   System.out.println(ap1.equals(ap1));
  //   System.out.println(ap1.equals(ap2));
  //   System.out.println(ap3.equals(ap3));
  //   AssistantProfessor ap4 = new AssistantProfessor("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996, 0001, "Computer Science", 100000.00, 12, 8);
  //   AssistantProfessor ap5 = new AssistantProfessor(ap4);
  //   System.out.println(ap5);
   }

}
