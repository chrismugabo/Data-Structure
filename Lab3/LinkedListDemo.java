import java.util.Collections;
import java.util.LinkedList;
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
        if (this == obj) return true; // Check if both references point to the same object.
        if (obj == null || getClass() != obj.getClass()) return false; // Check if the object is not null and is of the same class.
        Student student = (Student) obj; // Type cast the object to Student.
        return ssid == student.ssid && name.equals(student.name) && lab.equals(student.lab); // Compare SSID, name, and lab for equality.
    }

    // Override the hashCode method to return a hash code based on the Student's attributes.
    @Override
    public int hashCode() {
        return Objects.hash(name, lab, ssid); // Generate a hash code using the name, lab, and SSID.
    }
}

// Main class for demonstration.
public class LinkedListDemo {
    public static void main(String[] args) {
        // Initialize a LinkedList to hold Student objects.
        LinkedList<Student> LL1 = new LinkedList<>();
        // Add several unique Student objects to the LinkedList.
        LL1.add(new Student("St1", "CST3108", 1));
        LL1.add(new Student("St2", "CST3108", 2));
        LL1.add(new Student("St3", "CST3108", 3));
        LL1.add(new Student("St4", "CST3108", 4));
        LL1.add(new Student("St5", "CST3108", 5));
        LL1.add(new Student("St6", "CST3108", 6));

        // Display the LinkedList before handling duplicates
        System.out.println("Initial LinkedList:");
        for (Student s : LL1) {
            System.out.println(s);
        }

        // Attempt to add a duplicate Student object to check for errors.
        Student duplicate = new Student("St6", "CST3108", 6);
        if (LL1.contains(duplicate)) {
            System.out.println("Error: This student is already in the list."); // Error message if duplicate is found.
        } else {
            LL1.add(duplicate);
            System.out.println("Added duplicate student as LinkedList allows duplicates without explicit checks.");
        }

        // Display the LinkedList after attempting to add duplicate
        System.out.println("LinkedList after attempting to add a duplicate:");
        for (Student s : LL1) {
            System.out.println(s);
        }

        // Reverse the LinkedList using Collections.swap()
        for (int i = 0; i < LL1.size() / 2; i++) {
            Collections.swap(LL1, i, LL1.size() - i - 1);
        }

        // Display the reversed LinkedList
        System.out.println("Reversed LinkedList:");
        for (Student s : LL1) {
            System.out.println(s);
        }
    }
}

