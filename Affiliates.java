/** imported in order to implement compareTo method */
import java.lang.Comparable;
/** imported to use HashMap Collections data structure */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Collections;
/**
  * Affiliates is an abstract class that can be extended to various types of affiliates
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public abstract class Affiliates implements Printable, Comparable<Affiliates>{

  // Fields
  /** m_name is a String that represents an Affiliate's name */
  protected String m_name;
  /** m_age is an int that represents an Affiliate's age */
  protected int m_age;
  /** m_address is a String that represents an Affiliate's address */
  protected String m_address;
  /** m_phoneNumber is a String that represents an Affiliate's age */
  protected String m_phoneNumber;
  /** m_yearBegan is an int that represents the year when an Affiliate became an affiliate */
  protected int m_yearBegan;

  /**
    * Default Constructor - it assigns some default values to the affiliate's fields
  */
  public Affiliates(){
    m_name = "John Doe";
    m_age = 40;
    m_address = "2655 El Camino Real, Tustin, CA 92782";
    m_phoneNumber = "7148387895";
    m_yearBegan = 2000;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the affiliate's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
  */
  public Affiliates(String name, int age, String address, String phoneNumber, int yearBegan){
    m_name = name;
    m_age = age;
    m_address = address;
    m_phoneNumber = phoneNumber;
    m_yearBegan = yearBegan;
  }

  /**
    * Copy Constructor - it creates a copy of Affiliate instance
    * @param c - the Affiliate instance that is being copied
  */
  public Affiliates(Affiliates c){
    m_name = c.m_name;
    m_age = c.m_age;
    m_address = c.m_address;
    m_phoneNumber = c.m_phoneNumber;
    m_yearBegan = c.m_yearBegan;
  }

  // Accessors
  /**
    * This is an accessor method that is abstract.
    * @return returns the type of Affiliate
  */
  public abstract String getClassType();
  /**
    * This is an accessor method
    * @return returns the Affiliates's name field
  */
  public String getName(){
    return m_name;
  }
  /**
    * This is an accessor method
    * @return returns the Affiliates's age field
  */
  public int getAge(){
    return m_age;
  }
  /**
    * This is an accessor method
    * @return returns the Affiliates's address field
  */
  public String getAddress(){
    return m_address;
  }
  /**
    * This is an accessor method
    * @return returns the Affiliates's phone number field
  */
  public String getPhoneNumber(){
    return m_phoneNumber;
  }
  /**
    * This is an accessor method
    * @return returns the Affiliates's year began field
  */
  public int getYearBegan(){
    return m_yearBegan;
  }

  /**
    * This is a mutator method
    * @param name is set equal to m_name
  */
  public void setName(String name){
    m_name = name;
  }
  /**
    * This is a mutator method
    * @param age is set equal to m_age
  */
  public void setAge(int age){
    m_age = age;
  }
  /**
    * This is a mutator method
    * @param name is set equal to m_address
  */
  public void setAddress(String address){
    m_address = address;
  }
  /**
    * This is a mutator method
    * @param name is set equal to m_phoneNumber
  */
  public void setPhoneNumber(String phoneNumber){
    m_phoneNumber = phoneNumber;
  }
  /**
    * This is a mutator method
    * @param name is set equal to m_yearBegan
  */
  public void setYearBegan(int yearBegan){
    m_yearBegan = yearBegan;
  }

  /**
    * toString - override the default toString Object method
    * @return returns the contents of an Affiliate in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = "";
    ret += "Name: " + m_name;
    ret += "\nAge: " + m_age;
    ret += "\nAddress: " + m_address;
    ret += "\nPhone Number: " + m_phoneNumber;
    ret += "\nYear Began: " + m_yearBegan;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object a){
    if(!(a instanceof Affiliates)){
      return false;
    }
    Affiliates c = (Affiliates)a;
    if(!(m_name.equals(c.m_name)) || m_age != c.m_age || !(m_address.equals(c.m_address)) || !(m_phoneNumber.equals(c.m_phoneNumber)) || m_yearBegan != c.m_yearBegan){
      return false;
    }
    return true;
  }

  /**
    * compareTo() is a method from the Comparable interface that is overridden to compare one Affiliate's year came in with another Affiliate's year came in
    * @param a a represents the Affiliate that being compared to the Affiliate invoking the compareTo() method
    * @return returns an int: 0 if the affiliates have equal years came in, 1 if the affiliate invoking compareTo() has a lower year came in (been an affiliate for more years), -1 if the affiliate invoking compareTo() has a higher year came in (been an affiliate for less years)
  */
  @Override
  public int compareTo(Affiliates a){
    if(m_yearBegan == a.m_yearBegan){
      return 0;
    }
    else if(m_yearBegan < a.m_yearBegan){
      return -1;
    }
    return 1;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of an affiliate
  */
  @Override
  public String print(){
    String ret = "";
    ret += "\nName: " + m_name;
    ret += "\nAge: " + m_age;
    ret += "\nAddress: " + m_address;
    ret += "\nPhone Number: " + m_phoneNumber;
    ret += "\nYear Began: " + m_yearBegan;
    return ret;
  }

  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = new LinkedList<String>();
    stringLL.add("Name: " + m_name);
    stringLL.add("Age: " + m_age);
    stringLL.add("Address: " + m_address);
    stringLL.add("Phone Number: " + m_phoneNumber);
    stringLL.add("Year Began: " + m_yearBegan);
    Collections.sort(stringLL);
    return stringLL;
  }

  public String printAlphabetically(LinkedList<String> stringLL){
    String ret = "";
    for(int i = 0; i < stringLL.size(); ++i){
      if(i == (stringLL.size() - 1)){
        ret += stringLL.get(i) + " ";
      } else {
        ret += stringLL.get(i) + ", ";
      }
    }
    return ret;
  }

  public static void main(String[] args){
    String age =  "  Yearly Salary: $100000.0";
    age = age.substring(age.lastIndexOf(":") + 1);
    age = age.trim();
    System.out.println(age);
    // Affiliates a1 = new Affiliates();
    // Affiliates a2 = new Affiliates("John Doe", 23, "1334 Green Dr", "7074546778", 1996);
    // Affiliates a3 = new Affiliates("Barus", 23, "5737 Alvarado Pl", "7606688677", 1996);
    // Affiliates a4 = new Affiliates("Tom", 23, "5737 Alvarado Pl", "7606688677", 1990);
    // System.out.println(a1.toString());
    // System.out.println(a2.toString());
    // System.out.println(a1.equals(a1));
    // System.out.println(a1.equals(a2));
    // System.out.println(a3.equals(a3));
    // System.out.println(a1.compareTo(a2));
    // System.out.println(a2.compareTo(a2));
    // System.out.println(a4.compareTo(a2));
    // System.out.println(a4.compareTo(a1));
    // System.out.println(a2.print());
    // System.out.println(a4.printAlphabetically(a4.orderAlphabetically()));
    // HashMap<Integer, Affiliates> hm = new HashMap<Integer, Affiliates>();
    // LinkedList<Affiliates> ll = new LinkedList<Affiliates>();
    // ll.add(a1);
    // ll.add(a2);
    // for(int i =0; i < ll.size(); ++i){
    //   hm.put(i,ll.get(i));
    // }

    // for(int j = 0; j < hm.size(); ++j){
    //   System.out.println(hm.get(j));
    // }

    // try {
    //   PrintWriter pw = new PrintWriter(new FileWriter("Output.txt"));
    //   for(int j = 0; j < hm.size(); ++j){
    //     pw.println(hm.get(j));
    //     pw.println("\n");
    //   }
    //   pw.close();
    // }
    // catch(IOException e){
    //   System.out.println("Error in writing to the file");
    //   e.printStackTrace();
    // }
    // try {
    //   BufferedReader br = new BufferedReader(new FileReader("Output.txt"));
    //
    //   br.close();
    // }
    // catch(IOException e){
    //   System.out.println("Error in reading the file.");
    //   e.printStackTrace();
    // }

  }

}
