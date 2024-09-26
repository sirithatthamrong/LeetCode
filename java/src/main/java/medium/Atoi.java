package medium;

public class Atoi {
    public int myAtoi(String s) {
        int n = s.length();
        StringBuilder numStr = new StringBuilder();

        boolean signEncountered = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (numStr.isEmpty() && c == ' ') {
                continue;
            }
            else if ((c == '-' || c == '+') && !signEncountered) {
                numStr.append(c);
                signEncountered = true;
            }
            else if (Character.isDigit(c)) {
                numStr.append(c);
                signEncountered = true;
            }
            else {
                break;
            }
        }

        if (numStr.isEmpty() || (numStr.length() == 1 && (numStr.charAt(0) == '-' || numStr.charAt(0) == '+'))) {
            return 0;
        }

        long numLong = 0;
        try {
            numLong = Long.parseLong(numStr.toString());
        } catch (NumberFormatException e) {
            return numStr.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if (numLong > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (numLong < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) numLong;
        }
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("42")); // 42
        System.out.println(atoi.myAtoi("   -42")); // -42
        System.out.println(atoi.myAtoi("4193 with words")); // 4193
        System.out.println(atoi.myAtoi("words and 987")); // 0
        System.out.println(atoi.myAtoi("-91283472332")); // -2147483648
        System.out.println(atoi.myAtoi("91283472332")); // 2147483647
        System.out.println(atoi.myAtoi("+-12")); // 0
        System.out.println(atoi.myAtoi(" -042")); // -42
    }
}
