package Solution.easy;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String xString = String.valueOf(x);
        int len = xString.length();
        for(int i = 0; i < len/2; i++){
            if (xString.charAt(i) != xString.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeJava67(int number) {
        if (number < 0){
            return false;
        }
        if (number / 10 < 1){
            return true;
        }
        int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        // if original and the reverse of number is equal means
        // number is palindrome in Java
        return number == reverse;
    }


    public static boolean isPalindromeJava67Optimize(int number) {
        if (number < 0){
            return false;
        }
        if (number / 10 < 1){
            return true;
        }
        int reverse = 0;

        int len = (int) Math.log10(number) + 1;
        int count = 0;

        while (count < len/2) {
            reverse = reverse * 10 + (number % 10);
            number = number / 10;
            count++;
        }

        if (len % 2 == 0){
            // if original and the reverse of number is equal means
            // number is palindrome in Java
            return number == reverse;
        } else {
            return number / 10 == reverse;
        }
    }

    public static boolean isPalindromeCodeRecipe(int x) {
        // If x is a negative number it is not a palindrome
        // If x % 10 = 0, in order for it to be a palindrome the first digit should also be 0
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        // If x is equal to reversed number then it is a palindrome
        // If x has odd number of digits, dicard the middle digit before comparing with x
        // Example, if x = 23132, at the end of for loop x = 23 and reversedNum = 231
        // So, reversedNum/10 = 23, which is equal to x
        return (x == res || x == res / 10);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(isPalindromeJava67Optimize(1011101));
    }
}
