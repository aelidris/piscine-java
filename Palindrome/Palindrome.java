public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String reverse = new StringBuilder(s.toLowerCase()).reverse().toString();
        return s.toLowerCase().equals(reverse);
    }
}