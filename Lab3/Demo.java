import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

// Definition of the Student class to store student information.
class Student {
    String name;  // Student's name
    String lab;   // Lab code
    int ssid;     // Student ID (SSID)

    // Constructor to initialize the Student object with name, lab, and SSID.
    public Student(String name, String lab, int ssid) {
        this.name = name;
        this.lab = lab;
        this.ssid = ssid;
    }

    // Override the toString method to return the student's details in a readable format.
    @Override
    public String toString() {
        return "Name: " + this.name + ", Lab: " + this.lab + ", SSID: " + this.ssid;
    }

    // Override the equals method to compare two Student objects based on their attributes.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if both references point to the same object.
        if (obj == null || getClass() != obj.getClass()) return false;  // Check if the object is not null and is of the same class.
        Student student = (Student) obj;  // Type cast the object to Student.
        return ssid == student.ssid && name.equals(student.name) && lab.equals(student.lab);  // Compare SSID, name, and lab for equality.
    }

    // Override the hashCode method to return a hash code based on the Student's attributes.
    @Override
    public int hashCode() {
        return Objects.hash(name, lab, ssid);  // Generate a hash code using the name, lab, and SSID.
    }
}

// Main class for demonstration.
public class Demo {
    public static void main(String[] args) {
        // Initialize an ArrayList to hold Student objects.
        ArrayList<Student> AL1 = new ArrayList<>();
        // Add several unique Student objects to the ArrayList.
        AL1.add(new Student("St1", "CST3108", 1));
        AL1.add(new Student("St2", "CST3108", 2));
        AL1.add(new Student("St3", "CST3108", 3));
        AL1.add(new Student("St4", "CST3108", 4));
        AL1.add(new Student("St5", "CST3108", 5));
        AL1.add(new Student("St6", "CST3108", 6));

        // Display the ArrayList before handling duplicates
        System.out.println("Initial ArrayList:");
        for (Student s : AL1) {
            System.out.println(s);
        }

        // Attempt to add a duplicate Student object to check for errors.
        Student duplicate = new Student("St6", "CST3108", 6);
        if (AL1.contains(duplicate)) {
            System.out.println("Error: This student is already in the list.");  // Error message if duplicate is found.
        } else {
            AL1.add(duplicate);
            System.out.println("Added duplicate student as ArrayList allows duplicates without explicit checks.");
        }

        // Display the ArrayList after attempting to add duplicate
        System.out.println("ArrayList after attempting to add a duplicate:");
        for (Student s : AL1) {
            System.out.println(s);
        }

        // Reverse the ArrayList using Collections.swap()
        for (int i = 0; i < AL1.size() / 2; i++) {
            Collections.swap(AL1, i, AL1.size() - i - 1);
        }

        // Display the reversed ArrayList
        System.out.println("Reversed ArrayList:");
        for (Student s : AL1) {
            System.out.println(s);
        }
    }
}





