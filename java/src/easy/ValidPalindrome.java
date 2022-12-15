package easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                str.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String t = str.toString();
        for (int i = 0, j = t.length() - 1; i < j; i++, j--) {
            if(t.charAt(i) != t.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
