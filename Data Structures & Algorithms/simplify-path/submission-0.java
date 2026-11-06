class Solution {
    public String simplifyPath(String path) {
        
         Stack<String> stack = new Stack<>();

        String[] dirs = path.split("/");

        for (String dir : dirs) {

            if (dir.equals("") || dir.equals(".")) {
                continue;
            }

            else if (dir.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            }

            else {

                stack.push(dir);

            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.toString();
    }
}