package com.mmd;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author MMD
 * @create 2024-02-22
 */
public class Test2 {
    public static String changeMoreThanThreeConsecutiveCharacters(String input) {
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
                }else{
                    //大于两位字符拿到字符的上一个
                    char c = geFrontCharacter(chars[i - 1]);
                    sb.append(c);

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

    /**
     * 拿到字母表中前一位
     * @param letter
     * @return
     */
    public static char geFrontCharacter(char letter){
        char previousLetter;
        if (Character.isLowerCase(letter)) {
            String strLowerCase = "abcdefghijklmnopqrstuvwxyz";
            // 获取当前字母在字母表中的位置
            int index = strLowerCase.indexOf(letter);
            // 计算上一个字母的位置并获取对应的字符
            previousLetter = strLowerCase.charAt((index - 1 + 26) % 26);
        } else if (Character.isUpperCase(letter)) {
            String strUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            // 获取当前字母在字母表中的位置
            int index = strUpperCase.indexOf(letter);
            // 计算上一个字母的位置并获取对应的字符
            previousLetter = strUpperCase.charAt((index - 1 + 26) % 26);
        } else {
            // 如果不是字母，则保持不变
            previousLetter = letter;
        }
        return previousLetter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String result = input;
        String prevResult = "";
        while(!Objects.equals(result,prevResult)) {
            prevResult = result;
            result = changeMoreThanThreeConsecutiveCharacters(result);
            if(Objects.equals(result,prevResult)){
                break;
            }
            System.out.println("-> " + result);
        }


    }
}
