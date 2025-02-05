import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Custom implementation of a Stack that uses a generic array.
 * Extends Java's Stack class to provide additional functionality.
 */
public class ArrayStack<T> extends Stack<T> {
    private final int DEFAULT_CAPACITY = 10;  // Default initial capacity of the stack
    private int count;  // Number of elements currently in the stack
    private T[] stack;  // Array to store the stack elements

    /**
     * Constructor that initializes the stack with default capacity.
     */
    public ArrayStack() {
        count = 0;
        stack = (T[])(new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the stack array if necessary.
     *
     * @param element the element to be pushed onto the stack
     * @return the element that was added
     */
    public T push(T element) {
        if (count == stack.length) {
            expandCapacity();
        }
        stack[count] = element;
        count++;
        return element;
    }

    /**
     * Doubles the size of the array when capacity is reached to accommodate more elements.
     */
    private void expandCapacity() {
        T[] larger = (T[])(new Object[stack.length * 2]);
        System.arraycopy(stack, 0, larger, 0, stack.length);
        stack = larger;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to it.
     * @return the element at the top of the stack or null if the stack is empty
     */
    public T pop() {
        if (count == 0) {
            System.out.println("Pop operation failed. Stack is empty.");
            return null;
        }
        T temp = stack[count - 1];
        count--;
        return temp;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * @return top element of the stack, null if stack is empty
     */
    public T peek() {
        if (count == 0) {
            System.out.println("Peek operation failed. Stack is empty.");
            return null;
        }
        return stack[count - 1];
    }

    /**
     * Checks if the stack is empty.
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in the stack.
     * @return the stack size
     */
    public int size() {
        return count;
    }

    /**
     * Checks whether an expression containing brackets is balanced.
     * @param expression the string containing various types of brackets
     * @return true if brackets are balanced, false otherwise
     */
    public boolean checkExpression(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}' || c == '>') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((top == '(' && c != ')') ||
                    (top == '[' && c != ']') ||
                    (top == '{' && c != '}') ||
                    (top == '<' && c != '>')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ArrayStack<String> a = new ArrayStack<>();
        // Test the checkExpression method with a balanced expression
        String expression = "{([abc])}";
        boolean isValid = a.checkExpression(expression);
        System.out.println("Expression is balanced: " + isValid);

        // Task 2: Implement file reading and bracket checking
        String filePath = "sample.txt";  // Modify with actual file path
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                isValid = a.checkExpression(line);
                System.out.println("Line is balanced: " + isValid + " | Line: " + line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Please check the file path.");
        }
    }
}
