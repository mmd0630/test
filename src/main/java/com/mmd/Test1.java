package com.mmd;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author MMD
 * @create 2024-02-22
 *  * For a given string that only contains alphabet characters a-z,
 *  * if 3 or more consecutive characters are identical,
 *  * remove them from the string.
 *  * Repeat this process until
 *  * there is no more than 3 identical characters sitting besides each other.
 *  *
 *  * Example:
 *  * Input: aabcccbbad
 *  * Output:
 *  * -> aabbbad
 *  * -> aaad
 *  * -> d
 */
public class Test1 {
    public static String delMoreThanThreeConsecutiveCharacters(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count <= 2) {
                    //从chars的i - count（含）开始取count个字母
                    sb.append(chars, i - count, count);
                }
                count = 1;
            }
        }

        //最后一组
        if (count <= 2) {
            sb.append(chars, chars.length - count, count);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String result = input;
        String prevResult = "";
        while(!Objects.equals(result,prevResult)) {
            prevResult = result;
            result = delMoreThanThreeConsecutiveCharacters(result);
            if(Objects.equals(result,prevResult)){
                break;
            }
            System.out.println("-> " + result);
        }
    }
}
