package MidtermProject;


public class LinkedStack {
    private Node top;

    public LinkedStack() {
        top = null;
    }

    public void push(double value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public double pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        double value = top.data;
        top = top.next;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = top;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}