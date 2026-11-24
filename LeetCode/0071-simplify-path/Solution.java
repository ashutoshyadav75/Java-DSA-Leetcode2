
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(part);
            }
        }

        return "/" + String.join("/", stack);
    }
}
