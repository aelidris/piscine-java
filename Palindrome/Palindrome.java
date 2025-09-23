public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }
}