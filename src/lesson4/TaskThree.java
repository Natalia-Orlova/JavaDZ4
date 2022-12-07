package lesson4;

//https://leetcode.com/problems/simplify-path/

import java.util.Stack;

public class TaskThree {
    public String simplifyPath(String path) {
        Stack<String> direct = new Stack<>();
        String[] split = path.split("/");

        for (String s : split) {
            if (s.length() == 0 || s.equals(".")) {
                continue;
            }
            else if (s.equals("..")) {
                if (!direct.isEmpty()) {
                    direct.pop();
                }
            }
            else {
                direct.push(s);
            }
        }
        String result = "";
        while (!direct.isEmpty()) {
            result = "/" + direct.pop() + result;
        }
        if (result.equals("")) {
            result = "/";
        }
        return result;
    }
}
