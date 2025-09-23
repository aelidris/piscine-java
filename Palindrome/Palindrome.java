public class Palindrome {
    public static boolean isPalindrome(String s) {
        String reverse = new StringBuilder(s.toLowerCase()).reverse().toString();
        return s.toLowerCase().equals(reverse);
    }
}