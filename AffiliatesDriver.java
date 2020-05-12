// import Scanner for user input
import java.util.Scanner;
// import data structures and Collections methods
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Collections;
// import for file error handling
import java.io.IOException;
// import File writing packages
import java.io.PrintWriter;
import java.io.FileWriter;
// import File reading packages
import java.io.FileReader;
import java.io.BufferedReader;

public class AffiliatesDriver {

  public static String presentMenuOptions(){
    String ret = "Please enter a number to pick a choice:";
    ret += "\n1) Create an affiliate record";
    ret += "\n2) Print information for an Affiliate given the id";
    ret += "\n3) List all affiliates in order of seniority";
    ret += "\n4) Delete a record given the id";
    ret += "\n5) Save your database to a file";
    ret += "\n6) Restore your database from a file";
    ret += "\n7) Exit";
    return ret;
  }

  public static String presentCreateOptions(){
    String ret = "Please enter a number to pick a choice:";
    ret += "\n1) Full Professor";
    ret += "\n2) Associate Professor";
    ret += "\n3) Assistant Professor";
    ret += "\n4) Full Time Staff";
    ret += "\n5) Part Time Staff";
    ret += "\n6) Graduate Student";
    ret += "\n7) Undergraduate Student";
    ret += "\n8) Cancel";
    return ret;
  }

  public static String printWritingInstructions(){
    String ret = "***********Each field should have no spaces and the fields should be separated from each other with a single space***********";
    return ret;
  }

  public static boolean checkIfIdExists(HashMap<Integer, Affiliates> hm, int inputId){
    boolean exists = false;
    exists = hm.containsKey(inputId);
    if(exists == true){
      System.out.println("***********The id " + inputId + " already exists.***********");
    }
    return exists;
  }

  public static String printAffiliateById(HashMap<Integer, Affiliates> hm, int inputId){
    String ret = "";
    Affiliates af = hm.get(inputId);
    ret = af.print();
    return ret;
  }

  public static String deleteAffiliateById(HashMap<Integer, Affiliates> hm, int inputId){
    String ret = "";
    hm.remove(inputId);
    ret += "Removed ID " + inputId + " from the Database.\n";
    return ret;
  }

  public static String parseFieldsFromFile(String word){
    word = word.substring(word.lastIndexOf(":") + 1);
    word = word.trim();
    return word;
  }

  public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    HashMap<Integer, Affiliates> DB = new HashMap<Integer, Affiliates>();
    int menuOption = 0;
    while(menuOption != 7){
      //HashMap<Integer, Affiliates> DB = new HashMap<Integer, Affiliates>();
      System.out.println(presentMenuOptions());
      menuOption = scnr.nextInt();
      // this path is taken if the user desires to add an affiliate to the database
      if(menuOption == 1){
        int createOption = 0;
        System.out.println(presentCreateOptions());
        createOption = scnr.nextInt();
        if(createOption == 8){
          break;
        }
        /** the following variables are used in all affiliates */
        String name;
        int age;
        String address;
        String phoneNumber;
        int yearBegan;
        int id;
        System.out.println(printWritingInstructions());
        System.out.println("Enter the following in the precise order: Name, Age, Address, Phone Number, Year Began");
        name = scnr.next();
        age = scnr.nextInt();
        address = scnr.next();
        phoneNumber = scnr.next();
        yearBegan = scnr.nextInt();
        System.out.println("Name: " + name + "Age: " + age);
        while(true){
          System.out.println("Enter an id");
          id = scnr.nextInt();
          if(checkIfIdExists(DB, id) == true){
            System.out.println("The id: " + id + " already exists.");
            System.out.println("Please enter a different id");
          }
          else if((checkIfIdExists(DB, id) == false)) {
            System.out.println("The id: " + id + " is valid.");
            break;
          }
        }

        if(createOption == 1){
          System.out.println("Creating a new Full Professor...");
          String department;
          double yearlySalary;
          int numberOfPapers;
          int yearsUntilRetirement;
          System.out.println(printWritingInstructions());
          System.out.println("Enter the following in the precise order: Department, Yearly Salary (decimals are accepted), Number of Papers, Years Until Retirement");
          department = scnr.next();
          yearlySalary = scnr.nextDouble();
          numberOfPapers = scnr.nextInt();
          yearsUntilRetirement = scnr.nextInt();
          FullProfessor newFP = new FullProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsUntilRetirement);
          DB.put(newFP.getId(),newFP);
          System.out.println("Success: added a Full Professor to the database.");
          System.out.println("Full Professor info:\n" + newFP.print());
          System.out.println();
        }
        else if(createOption == 2){
          System.out.println("In process of creating an Associate Professor...");
          String department;
          double yearlySalary;
          int numberOfPapers;
          int yearsSinceTenure;
          System.out.println(printWritingInstructions());
          System.out.println("Enter the following in the precise order: Department, Yearly Salary (decimals are accepted), Number of Papers, Years Since Tenure");
          department = scnr.next();
          yearlySalary = scnr.nextDouble();
          numberOfPapers = scnr.nextInt();
          yearsSinceTenure = scnr.nextInt();
          AssociateProfessor newAP = new AssociateProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsSinceTenure);
          DB.put(newAP.getId(),newAP);
          System.out.println("Success: added an Associate Professor to the database.");
          System.out.println("Associate Professor info:\n" + newAP.print());
          System.out.println();
        }
        else if(createOption == 3){
          System.out.println("In process of creating an Assistant Professor...");
          String department;
          double yearlySalary;
          int numberOfPapers;
          int yearsUntilTenure;
          System.out.println(printWritingInstructions());
          System.out.println("Enter the following in the precise order: Department, Yearly Salary (decimals are accepted), Number of Papers, Years Until Tenure");
          department = scnr.next();
          yearlySalary = scnr.nextDouble();
          numberOfPapers = scnr.nextInt();
          yearsUntilTenure = scnr.nextInt();
          AssociateProfessor newAP = new AssociateProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsUntilTenure);
          DB.put(newAP.getId(),newAP);
          System.out.println("Success: added an Assistant Professor to the database.");
          System.out.println("Assistant Professor info:\n" + newAP.print());
          System.out.println();
        }
        else if(createOption == 4){
          System.out.println("In process of creating a Full Time Staff Member...");
          String title;
          String building;
          double yearlySalary;
          System.out.println(printWritingInstructions());
          System.out.println("Enter the following in the precise order: Title, Building, Yearly Salary (decimals are accepted)");
          title = scnr.next();
          building = scnr.next();
          yearlySalary = scnr.nextDouble();
          FullTimeStaff newFTS = new FullTimeStaff(name, age, address, phoneNumber, yearBegan, id, title, building, yearlySalary);
          DB.put(newFTS.getId(),newFTS);
          System.out.println("Success: added a Full Time Staff member to the database.");
          System.out.println("Full Time Staff Member info:\n" + newFTS.print());
          System.out.println();
        }
        else if(createOption == 5){
          System.out.println("In process of creating a Part Time Staff Member...");
          String title;
          String building;
          double hourlySalary;
          System.out.println(printWritingInstructions());
          System.out.println("Enter the following in the precise order: Title, Building, Hourly Salary (decimals are accepted)");
          title = scnr.next();
          building = scnr.next();
          hourlySalary = scnr.nextDouble();
          PartTimeStaff newPTS = new PartTimeStaff(name, age, address, phoneNumber, yearBegan, id, title, building, hourlySalary);
          DB.put(newPTS.getId(),newPTS);
          System.out.println("Success: added a Part Time Staff member to the database.");
          System.out.println("Part Time Staff Member info:\n" + newPTS.print());
          System.out.println();
        }
        else if(createOption == 6){
          System.out.println("In process of creating a Graduate Student...");
          String major;
          String minor;
          String classStanding;
          int numberOfPapersPublished;
          String thesisAdvisor;
          System.out.println(printWritingInstructions());
          System.out.println("Enter the following in the precise order: Major, Minor, Class Standing, Number Of Papers Published, Thesis Advisor");
          major = scnr.next();
          minor = scnr.next();
          classStanding = scnr.next();
          numberOfPapersPublished = scnr.nextInt();
          thesisAdvisor = scnr.next();
          GraduateStudents newGS = new GraduateStudents(name, age, address, phoneNumber, yearBegan, id, major, minor, classStanding, numberOfPapersPublished, thesisAdvisor);
          DB.put(newGS.getId(),newGS);
          System.out.println("Success: added a Graduate Student to the database.");
          System.out.println("Graduate Student info:\n" + newGS.print());
          System.out.println();
        }
        else if(createOption == 7){
          System.out.println("In process of creating an Undergraduate Student...");
          String major;
          String minor;
          String classStanding;
          int numberOfCourses;
          double scholarshipAmount;
          System.out.println(printWritingInstructions());
          System.out.println("Enter the following in the precise order: Major, Minor, Class Standing, Number Of Classes, Scholarship amount (decimals are accepted)");
          major = scnr.next();
          minor = scnr.next();
          classStanding = scnr.next();
          numberOfCourses = scnr.nextInt();
          scholarshipAmount = scnr.nextDouble();
          UnderGraduateStudents newUGS = new UnderGraduateStudents(name, age, address, phoneNumber, yearBegan, id, major, minor, classStanding, numberOfCourses, scholarshipAmount);
          DB.put(newUGS.getId(),newUGS);
          System.out.println(DB.get(newUGS.getId()));
          System.out.println("Success: added an Undergraduate Student to the database.");
          System.out.println("Undergraduate Student info:\n" + newUGS.print());
          System.out.println();
        }
        // else if(createOption == 8){
        //   System.out.println(8);
        //   break;
        // }
        else {
          System.out.println("Invalid Input");
          System.out.println("Terminating Program");
          break;
        }
      }
      // ****Main Menu Option 2 - this path is taken if the user desires to search for an affiliate by id****
      else if(menuOption == 2){
        int inputId = 0;
        System.out.println("Enter the id of the Affiliate");
        inputId = scnr.nextInt();
        System.out.println("Searching Database...");
        if(checkIfIdExists(DB, inputId) == false){
          System.out.println("*********The id does not exist.*********");
        }
        else {
          System.out.println(printAffiliateById(DB, inputId));
        }
        System.out.println();
      }
      else if(menuOption == 3){
        // LinkedList where the Affiliates are stored in and later sorted
        LinkedList<Affiliates> LL = new LinkedList<Affiliates>();
        // maps out the Affiliate instances from the HashMap onto a LinkedList
        DB.forEach((key, value) -> LL.add(value));
        // invoking sort() sorts the Affiliates by the compareTo() method that was overrided to sort Affiliates by yearBegan
        Collections.sort(LL);
        System.out.println("*********Organized in order of seniority (year began at Chapman)*********");
        for(Affiliates a: LL){
          System.out.println("\n" + a.print() + "\n");
        }
        System.out.println("^^^^^^^Organized in order of seniority (year began at Chapman)^^^^^^^");
        System.out.println();
      }
      else if(menuOption == 4){
        int inputId = 0;
        System.out.println("Enter the id of the Affiliate you wish to delete");
        inputId = scnr.nextInt();
        System.out.println("Searching Database...");
        if(checkIfIdExists(DB, inputId) == false){
          System.out.println("*********The id does not exist.*********");
        }
        else {
          System.out.println(deleteAffiliateById(DB, inputId));
        }
        System.out.println();
      }
      else if(menuOption == 5){
        try {
          System.out.println("Enter the name of the file (no .txt) where you would like to save the Database.");
          String fileName = scnr.next() + ".txt";
          PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
          //LinkedList<Affiliates> LL = new LinkedList<Affiliates>();
          DB.forEach((key,value) -> {
            pw.println(value.getClassType() + ", " + value.printAlphabetically(value.orderAlphabetically()));
          });
          pw.close();
          System.out.println("SUCCESS: Added database to file: " + fileName + ".txt");
        }
        catch(IOException error){
          System.out.println("ERROR: error in writing to a file.");
          error.printStackTrace();
        }
      }
      else if(menuOption == 6){
        try {
          System.out.println("Enter the name of the file (no .txt) that has the Affiliates you would like to add to the Database.");
          String fileName = scnr.next() + ".txt";
          BufferedReader br = new BufferedReader(new FileReader(fileName));
          // LinkedList that holds arrays of Strings
          LinkedList<String[]> fileData = new LinkedList<String[]>();
          // each line is stored in variable named line during the loop
          for(String line = br.readLine(); line != null; line = br.readLine()){
            // count the comas in order to know precisely how big each array should be
            int comaCounter = 0;
            for(int j = 0; j < line.length(); ++j){
              if(line.charAt(j) == ','){
                comaCounter += 1;
              }
            }
            String[] lineArray = new String[comaCounter + 1]; // add 1 because each line does not end with a coma (do not want to miss the last element)
            lineArray = line.split(","); // turns each line of Strings into an array of Strings - elements are split by a ','
            fileData.add(lineArray);
          }
          for(int i = 0; i < fileData.size(); ++i){
            // currStrArray is the String array that i is currently on of the fileData LinkedList
            String[] currStrArray = fileData.get(i);
            String classType = currStrArray[0];
            // for(int m = 0; m < currStrArray.length; ++m){
            //   System.out.println(currStrArray[0]);
            // }
            if(classType.equals("Full Professor")){
              String address = parseFieldsFromFile(currStrArray[1]);
              String ageTemp = parseFieldsFromFile(currStrArray[2]);
              int age = Integer.parseInt(parseFieldsFromFile(ageTemp));
              String department = parseFieldsFromFile(currStrArray[3]);
              int id = Integer.parseInt(parseFieldsFromFile(currStrArray[4]));
              String name = parseFieldsFromFile(currStrArray[5]);
              int numberOfPapers = Integer.parseInt(parseFieldsFromFile(currStrArray[6]));
              String phoneNumber = parseFieldsFromFile(currStrArray[7]);
              int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[8]));
              double yearlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[9]));
              int yearsUntilRetirement = Integer.parseInt(parseFieldsFromFile(currStrArray[10]));
              FullProfessor newFullProfessor = new FullProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsUntilRetirement);
              DB.put(newFullProfessor.getId(), newFullProfessor);
            }
            else if(classType.equals("Associate Professor")){
              String address = parseFieldsFromFile(currStrArray[1]);
              int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
              String department = parseFieldsFromFile(currStrArray[3]);
              int id = Integer.parseInt(parseFieldsFromFile(currStrArray[4]));
              String name = parseFieldsFromFile(currStrArray[5]);
              int numberOfPapers = Integer.parseInt(parseFieldsFromFile(currStrArray[6]));
              String phoneNumber = parseFieldsFromFile(currStrArray[7]);
              int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[8]));
              double yearlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[9]));
              int yearsSinceTenure = Integer.parseInt(parseFieldsFromFile(currStrArray[10]));
              AssociateProfessor newAssociateProfessor = new AssociateProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsSinceTenure);
              DB.put(newAssociateProfessor.getId(), newAssociateProfessor);
            }
            else if(classType.equals("Assistant Professor")){
              String address = parseFieldsFromFile(currStrArray[1]);
              int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
              String department = parseFieldsFromFile(currStrArray[3]);
              int id = Integer.parseInt(parseFieldsFromFile(currStrArray[4]));
              String name = parseFieldsFromFile(currStrArray[5]);
              int numberOfPapers = Integer.parseInt(parseFieldsFromFile(currStrArray[6]));
              String phoneNumber = parseFieldsFromFile(currStrArray[7]);
              int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[8]));
              double yearlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[9]));
              int yearsUntilTenure = Integer.parseInt(parseFieldsFromFile(currStrArray[10]));
              AssistantProfessor newAssistantProfessor = new AssistantProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsUntilTenure);
              DB.put(newAssistantProfessor.getId(), newAssistantProfessor);
            }
            else if(classType.equals("Full Time Staff")){
              String address = parseFieldsFromFile(currStrArray[1]);
              int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
              String building = parseFieldsFromFile(currStrArray[3]);
              double yearlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[4]));
              String name = parseFieldsFromFile(currStrArray[5]);
              String phoneNumber = parseFieldsFromFile(currStrArray[6]);
              int id = Integer.parseInt(parseFieldsFromFile(currStrArray[7]));
              String title = parseFieldsFromFile(currStrArray[8]);
              int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[9]));
              FullTimeStaff newFullTimeStaff = new FullTimeStaff(name, age, address, phoneNumber, yearBegan, id, title, building, yearlySalary);
              DB.put(newFullTimeStaff.getId(), newFullTimeStaff);
            }
            else if(classType.equals("Part Time Staff")){
              String address = parseFieldsFromFile(currStrArray[1]);
              int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
              String building = parseFieldsFromFile(currStrArray[3]);
              String name = parseFieldsFromFile(currStrArray[4]);
              double hourlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[5]));
              String phoneNumber = parseFieldsFromFile(currStrArray[6]);
              int id = Integer.parseInt(parseFieldsFromFile(currStrArray[7]));
              String title = parseFieldsFromFile(currStrArray[8]);
              int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[9]));
              PartTimeStaff newPartTimeStaff = new PartTimeStaff(name, age, address, phoneNumber, yearBegan, id, title, building, hourlySalary);
              DB.put(newPartTimeStaff.getId(), newPartTimeStaff);
            }
            else if(classType.equals("Graduate Student")){
              String address = parseFieldsFromFile(currStrArray[1]);
              int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
              String classStanding = parseFieldsFromFile(currStrArray[3]);
              String major = parseFieldsFromFile(currStrArray[4]);
              String minor = parseFieldsFromFile(currStrArray[5]);
              String name = parseFieldsFromFile(currStrArray[6]);
              int numberOfPapersPublished = Integer.parseInt(parseFieldsFromFile(currStrArray[7]));
              String phoneNumber = parseFieldsFromFile(currStrArray[8]);
              int id = Integer.parseInt(parseFieldsFromFile(currStrArray[9]));
              String thesisAdvisor = parseFieldsFromFile(currStrArray[10]);
              int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[11]));
              GraduateStudents newGraduateStudent = new GraduateStudents(name, age, address, phoneNumber, yearBegan, id, major, minor, classStanding, numberOfPapersPublished, thesisAdvisor);
              DB.put(newGraduateStudent.getId(), newGraduateStudent);
            }
            else if(classType.equals("Undergraduate Student")){
              String address = parseFieldsFromFile(currStrArray[1]);
              int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
              String classStanding = parseFieldsFromFile(currStrArray[3]);
              String major = parseFieldsFromFile(currStrArray[4]);
              String minor = parseFieldsFromFile(currStrArray[5]);
              String name = parseFieldsFromFile(currStrArray[6]);
              int numberOfCourses = Integer.parseInt(parseFieldsFromFile(currStrArray[7]));
              String phoneNumber = parseFieldsFromFile(currStrArray[8]);
              Double scholarshipAmount = Double.parseDouble(parseFieldsFromFile(currStrArray[9]));
              int id = Integer.parseInt(parseFieldsFromFile(currStrArray[10]));
              int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[11]));
              UnderGraduateStudents newUndergraduateStudent = new UnderGraduateStudents(name, age, address, phoneNumber, yearBegan, id, major, minor, classStanding, numberOfCourses, scholarshipAmount);
              DB.put(newUndergraduateStudent.getId(), newUndergraduateStudent);
            }
            else{
              System.out.println("Error: did not recognize class type for " + classType);
            }
          }
          br.close();
          System.out.println("Success: Added data from file " + fileName + " to database.");
        }
        catch(IOException error){
          System.out.println("Error: error in reading from the file.");
          error.printStackTrace();
        }
      }
      else {
        System.out.println("Invalid Input");
        System.out.println("Terminating Program");
        break;
      }
    }
    
/*
When your program is run it should display the following options:
1) Create an affiliate record
2) Print information for an Affiliate given the id
3) List all affiliates in order of seniority
4) Delete a record given the id
5) Save your database to a file
6) Restore your database from a file
7) Exit
*/
