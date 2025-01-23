import java.util.Scanner;

class Stack {
    private int array[];
    private int top;
    private int cap;

    Stack(int s) {
        array = new int[s];
        cap = s;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return;
        }
        System.out.println("Inserting " + x);
        array[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("STACK IS EMPTY");
            return -1;
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("STACK IS EMPTY");
            return -1;
        }
        return array[top]; 
    }

    public int getSize() {
        return top + 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == cap - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\nChoose an operation from below:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to pushto the stack: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    int poppedElement = stack.pop();
                    if (poppedElement != -1) {
                        System.out.println("Popped element from the stack: " + poppedElement);
                    }
                    break;
                case 3:
                    int topElement = stack.peek();
                    if (topElement != -1) {
                        System.out.println("Top element on the stack: " + topElement);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice ");
            }
        }
    }
}