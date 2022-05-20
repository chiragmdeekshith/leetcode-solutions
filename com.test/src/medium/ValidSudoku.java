package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ValidSudoku {
    public boolean isValidSudokuSlow(char[][] board) {

        Map<String, Set<Character>> rowmap = new HashMap<>();
        Map<String, Set<Character>> colmap = new HashMap<>();
        Map<String, Set<Character>> squaremap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    rowmap.putIfAbsent(String.valueOf(i), new HashSet<>());
                    colmap.putIfAbsent(String.valueOf(j), new HashSet<>());
                    String s = String.valueOf(i / 3) + j / 3;
                    squaremap.putIfAbsent(s, new HashSet<>());

                    if(!rowmap.get(String.valueOf(i)).add(board[i][j]) ||
                            !colmap.get(String.valueOf(j)).add(board[i][j]) ||
                            !squaremap.get(s).add(board[i][j])
                    ){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    if(!set.add("Row:"+i+" Value:"+board[i][j]) ||
                            !set.add("Column:"+j+" Value:"+board[i][j]) ||
                            !set.add("SemiCube:"+i/3+""+j/3+" Value:"+board[i][j])
                    ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
