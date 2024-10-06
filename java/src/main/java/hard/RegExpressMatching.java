package hard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://leetcode.com/problems/regular-expression-matching/description/
public class RegExpressMatching {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

    public static void main(String[] args) {
        RegExpressMatching obj = new RegExpressMatching();
        System.out.println(obj.isMatch("aa", "a")); // false
        System.out.println(obj.isMatch("aa", "aa")); // true
        System.out.println(obj.isMatch("aaa", "aa")); // false
        System.out.println(obj.isMatch("aa", "a*")); // true
        System.out.println(obj.isMatch("aa", ".*")); // true
        System.out.println(obj.isMatch("ab", ".*")); // true
        System.out.println(obj.isMatch("aab", "c*a*b")); // true
        System.out.println(obj.isMatch("mississippi", "mis*is*p*.")); // false
    }
}
