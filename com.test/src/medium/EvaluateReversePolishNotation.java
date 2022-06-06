package medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Integer top, bot;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length() - 1))) {
                stack.push(Integer.valueOf(token));
            } else {
                top = stack.pop();
                bot = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(bot + top);
                        break;
                    case "-":
                        stack.push(bot - top);
                        break;
                    case "*":
                        stack.push(bot * top);
                        break;
                    case "/":
                        if(top == 0 || bot == 0){
                            stack.push(0);
                        } else {
                            stack.push(bot / top);
                        }
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
