//
//  Test program for ArrayStack
//
//  The int value determines whether we're testing with
//  String or Integer values, and the second specifies the
//  maximum size of the Stack.
//
//  The program reads commands from standard input until it
//  hits EOF.  The commands are (everything after // is an
//  explanatory comment, not part of the input):
//
//      push <item>     // push an item on the stack
//      pop             // pop an item off the stack and print it
//      size            // prints the size of the stack
//      isEmpty         // prints 'true' if the stack is empty,
//                      //      and 'false' otherwise
//      print           // prints the current stack contents

import java.util.Scanner;

public class Main {

    private static <T> void printStack(Stack<T> stk) {

        System.out.print("[ ");
        for (T item : stk) {
            System.out.printf("%s ", item.toString());
        }
        System.out.println("]");
    }

    private static void testIntegerStack(Scanner sc, int maxSize) {
        
        Stack<Integer> stk = new ArrayStack<Integer>(maxSize);

        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "push":
                {
                    Integer item = sc.nextInt();
                    stk.push(item);
                    break;
                }
                case "pop":
                {
                    Integer item = stk.pop();
                    System.out.printf("%d\n", item);
                    break;
                }
                case "size":
                {
                    System.out.printf("size: %d\n",
                            stk.size());
                    break;
                }
                case "isEmpty":
                {
                    System.out.printf("isEmpty: %s\n",
                            stk.isEmpty());
                    break;
                }
                case "print":
                {
                    printStack(stk);
                    break;
                }
            }
        }
    }

    private static void testStringStack(Scanner sc, int maxSize) {
        
        Stack<String> stk = new ArrayStack<String>(maxSize);

        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "push":
                {
                    String item = sc.next();
                    stk.push(item);
                    break;
                }
                case "pop":
                {
                    String item = stk.pop();
                    System.out.printf("%s\n", item);
                    break;
                }
                case "size":
                {
                    System.out.printf("size: %d\n",
                            stk.size());
                    break;
                }
                case "isEmpty":
                {
                    System.out.printf("isEmpty: %s\n",
                            stk.isEmpty());
                    break;
                }
                case "print":
                {
                    printStack(stk);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String dataType = sc.next();
        int maxSize = sc.nextInt();

        switch (dataType) {
            case "String":
                testStringStack(sc, maxSize);
                break;
            case "Integer":
                testIntegerStack(sc, maxSize);
                break;
            default:
                System.out.printf("Invalid data type : %s\n", dataType);
        }

        sc.close();
    }
}
