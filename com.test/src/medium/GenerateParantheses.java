package medium;

import java.util.*;

public class GenerateParantheses {
    StringBuilder stringBuilder = new StringBuilder();
    List<String> result = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0,0);
        return result;
    }

    private void dfs(int open, int closed) {
        if(stringBuilder.length() == n * 2 ) {
            result.add(stringBuilder.toString());
            return;
        }
        if(open < n) {
            stringBuilder.append("(");
            dfs(open + 1, closed);
            stringBuilder.deleteCharAt(stringBuilder.length() -1);
        }
        if(closed < open) {
            stringBuilder.append(")");
            dfs(open, closed + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() -1);
        }
    }
}
