import java.util.Stack;

public class Balanced {
    public static void main(String[] args) {

        String[] str = {"({[]})", "({[})", "((()))", "({)}"};

        for (String s : str)
            System.out.println(s + " -> " + isBalanced(s));
    }

    public static boolean isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // check closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {

                // if stack is empty
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // matching check
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // stack must be empty
        return stack.isEmpty();
    }
}