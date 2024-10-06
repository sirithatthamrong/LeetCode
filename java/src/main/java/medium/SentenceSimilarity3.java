package medium;

import java.util.*;

// https://leetcode.com/problems/sentence-similarity-iii/description/?envType=daily-question&envId=2024-10-06
public class SentenceSimilarity3 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        // s1 -> longer
        // s2 -> shorter
        if (s1.length < s2.length) {
            String[] temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int prefix = 0;
        int suffix = 0;

        while (prefix < s2.length && s1[prefix].equals(s2[prefix])) {
//            System.out.println("S1 prefix: " + s1[prefix]);
//            System.out.println("S2 prefix: " + s2[prefix]);
            prefix++;
        }

        while (suffix < s2.length && s1[s1.length - 1 - suffix].equals(s2[s2.length - 1 - suffix])) {
//            System.out.println("S1 suffix: " + s1[s1.length - 1 - suffix]);
//            System.out.println("S2 suffix: " + s2[s2.length - 1 - suffix]);
            suffix++;
        }

//        System.out.println("Prefix: " + prefix);
//        System.out.println("Suffix: " + suffix);
        return prefix + suffix >= s2.length;
    }

    public static void main(String[] args) {
        SentenceSimilarity3 sentenceSimilarity3 = new SentenceSimilarity3();
        System.out.println(sentenceSimilarity3.areSentencesSimilar("My name is Haley", "My Haley")); // true
        System.out.println(sentenceSimilarity3.areSentencesSimilar("of", "A lot of words")); // false
        System.out.println(sentenceSimilarity3.areSentencesSimilar("Eating right now", "Eating")); // true
        System.out.println(sentenceSimilarity3.areSentencesSimilar("Luky", "Lucccky")); // false
        System.out.println(sentenceSimilarity3.areSentencesSimilar("Ogn WtWj HneS", "Ogn WtWj HneS")); // true
    }
}

