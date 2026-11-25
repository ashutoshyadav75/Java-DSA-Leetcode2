
class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                NestedInteger ni = new NestedInteger();

                if (!stack.isEmpty()) {
                    stack.peek().add(ni);
                }

                stack.push(ni);
            } 
            else if (c == ']') {
                if (stack.size() > 1) {
                    stack.pop();
                }
            } 
            else if (c == '-' || Character.isDigit(c)) {
                int start = i;

                while (i + 1 < s.length() &&
                       Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }

                int num = Integer.parseInt(s.substring(start, i + 1));
                stack.peek().add(new NestedInteger(num));
            }
        }

        return stack.pop();
    }
}
