import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer> stack;
    private List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(0, x);
        if (minStack.isEmpty()) {
            minStack.add(0, x);
        } else {
            int min = Math.min(x, minStack.get(0));
            minStack.add(0, min);
        }
    }

    public void pop() {
        stack.remove(0);
        minStack.remove(0);
    }

    public int top() {
        return stack.get(0);
    }

    public int getMin() {
        return minStack.get(0);
    }
}
