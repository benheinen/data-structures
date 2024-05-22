//
//  Test program for ArrayQueue
//
//  The int value determines whether we're testing with
//  String or Integer values, and the second specifies the
//  maximum size of the Queue.
//
//  The program reads commands from standard input until it
//  hits EOF.  The commands are (everything after // is an
//  explanatory comment, not part of the input):
//
//      enqueue <item>  // push an item on the queue
//      dequeue         // pop an item off the queue and print it
//      size            // prints the size of the queue
//      isEmpty         // prints 'true' if the queue is empty,
//                      //      and 'false' otherwise
//      print           // prints the current queue contents

import java.util.Scanner;

public class Main {

    private static <T> void printQueue(Queue<T> stk) {

        System.out.print("[ ");
        for (T item : stk) {
            System.out.printf("%s ", item.toString());
        }
        System.out.println("]");
    }

    private static void testIntegerQueue(Scanner sc, int maxSize) {
        
        Queue<Integer> stk = new ArrayQueue<Integer>(maxSize);

        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "enqueue":
                {
                    Integer item = sc.nextInt();
                    stk.enqueue(item);
                    break;
                }
                case "dequeue":
                {
                    Integer item = stk.dequeue();
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
                    printQueue(stk);
                    break;
                }
            }
        }
    }

    private static void testStringQueue(Scanner sc, int maxSize) {
        
        Queue<String> stk = new ArrayQueue<String>(maxSize);

        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "enqueue":
                {
                    String item = sc.next();
                    stk.enqueue(item);
                    break;
                }
                case "dequeue":
                {
                    String item = stk.dequeue();
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
                    printQueue(stk);
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
                testStringQueue(sc, maxSize);
                break;
            case "Integer":
                testIntegerQueue(sc, maxSize);
                break;
            default:
                System.out.printf("Invalid data type : %s\n", dataType);
        }

        sc.close();
    }
}
