import java.util.Scanner;

public class Main {

    // // Why won't this work?  Are Java generics really that useless?
    // public static <T extends Comparable<T>> void testStack(Scanner sc) {
    //     Stack<T> maxStack = new MaxStack<T>();
    // }

    public static void testIntegerStack(Scanner sc) {
        MaxStack<Integer> maxStack = new MaxStack<Integer>();
        if (maxStack.size() != 0)
            System.out.println("New MaxStack has size != 0!!!");
        if (!maxStack.isEmpty())
            System.out.println("New MaxStack is not empty!!!");
        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("push")) {
                int item = sc.nextInt();
                maxStack.push(item);
                System.out.printf("%d added, new size is %d\n", item, maxStack.size());
                if (maxStack.isEmpty())
                    System.out.println("MaxStack is empty after a push()!!!");
            } else if (command.equals("pop")) {
                int item = maxStack.pop();
                System.out.printf("%d popped, new size is %d\n", item, maxStack.size());
                if (maxStack.isEmpty())
                    System.out.println("The stack is now empty.");
            } else if (command.equals("max")) {
                int max = maxStack.max();
                System.out.printf("Maximum value is %d\n", max);
            } else if (command.equals("print")) {
                System.out.println(maxStack);
            }
        }
    }

    public static void testStringStack(Scanner sc) {
        MaxStack<String> maxStack = new MaxStack<String>();
        if (maxStack.size() != 0)
            System.out.println("New MaxStack has size != 0!!!");
        if (!maxStack.isEmpty())
            System.out.println("New MaxStack is not empty!!!");
        while (sc.hasNext()) {
            String command = sc.next();
            if (command.equals("push")) {
                String item = sc.next();
                maxStack.push(item);
                System.out.printf("%s added, new size is %d\n", item, maxStack.size());
                if (maxStack.isEmpty())
                    System.out.println("MaxStack is empty after a push()!!!");
            } else if (command.equals("pop")) {
                String item = maxStack.pop();
                System.out.printf("%s popped, new size is %d\n", item, maxStack.size());
                if (maxStack.isEmpty())
                    System.out.println("The stack is now empty.");
            } else if (command.equals("max")) {
                String max = maxStack.max();
                System.out.printf("Maximum value is %s\n", max);
            } else if (command.equals("print")) {
                System.out.println(maxStack);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String testType = sc.next();
        if (testType.equals("string"))
            testStringStack(sc);
        else if (testType.equals("integer"))
            testIntegerStack(sc);
    }
}
