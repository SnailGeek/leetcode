package test.asynchronous.transfer;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: VaildParams
 * @description:
 * @author: wangf-q
 * @date: 2020-03-24 12:42
 **/
public class VaildParams {
    public static boolean isVaild(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty()) {
                int c = s.charAt(i) - stack.peek();
                if (c != 1 && c != 2) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Map<String, Boolean> testMap = new HashMap<>();
        testMap.put("", true);
        testMap.put("()", true);
        testMap.put("{}", true);
        testMap.put("(){}[]", true);
        testMap.put("(){([])}", true);
        testMap.put("({[]})", true);
        testMap.put("([)]", false);
        testMap.put("()([)]", false);
        testMap.put("[(({})}]", false);

        for (Map.Entry<String, Boolean> entry : testMap.entrySet()) {
            try {
                boolean result = isVaild(entry.getKey());
                if (result != entry.getValue()) {
                    System.out.println(entry.getKey() + " : " + result);
                }
            } catch (Exception e) {
                System.out.println(entry.getKey());
                e.printStackTrace();
            }
        }
    }
}
