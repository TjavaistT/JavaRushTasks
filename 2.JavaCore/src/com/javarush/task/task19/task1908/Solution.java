package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.*;
import java.lang.*;
/*
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        try(
                //считать названия, открыть поток и пометить на автозакрытие - все сразу и вначале
                BufferedReader consoleBufR = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileReader = new BufferedReader(new FileReader(consoleBufR.readLine()));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(consoleBufR.readLine()))
        ){
        //представить считываемый файл потоком строк
        fileReader.lines()
                //каждую строку разбить по пробелам, чтоб получить поток слов
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                //отфильтровать слова, которые могут быть числами
                .filter(Solution::isNumeric)
                //записать числа  в файл
                .forEach(strNumber -> Solution.writeToFile(fileWriter, strNumber));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void writeToFile(BufferedWriter buf, String strNumber){
        try {
            buf.write(strNumber + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //взято из NumberUtils::isCreatable
    public static boolean isNumeric(String str){
        if (str.equals("")) {
            return false;
        }
        final char[] chars = str.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;
        // deal with any possible sign up front
        boolean isPoint = false;
        for (char character : chars) {
            if (character == '.'){
                isPoint = true;
            }
        }
        final int start = chars[0] == '-' || chars[0] == '+' ? 1 : 0;
        if (sz > start + 1 && chars[start] == '0' && !isPoint) { // leading 0, skip if is a decimal number
            if (chars[start + 1] == 'x' || chars[start + 1] == 'X') { // leading 0x/0X
                int i = start + 2;
                if (i == sz) {
                    return false; // str == "0x"
                }
                // checking hex (it can't be anything else)
                for (; i < chars.length; i++) {
                    if ((chars[i] < '0' || chars[i] > '9')
                            && (chars[i] < 'a' || chars[i] > 'f')
                            && (chars[i] < 'A' || chars[i] > 'F')) {
                        return false;
                    }
                }
                return true;
            } else if (Character.isDigit(chars[start + 1])) {
                // leading 0, but not hex, must be octal
                int i = start + 1;
                for (; i < chars.length; i++) {
                    if (chars[i] < '0' || chars[i] > '7') {
                        return false;
                    }
                }
                return true;
            }
        }
        sz--; // don't want to loop to the last char, check it afterwords
        // for type qualifiers
        int i = start;
        // loop to the next to last char or to the last char if we need another digit to
        // make a valid number (e.g. chars[0..5] = "1234E")
        while (i < sz || i < sz + 1 && allowSigns && !foundDigit) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                foundDigit = true;
                allowSigns = false;

            } else if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                hasDecPoint = true;
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // we've already taken care of hex.
                if (hasExp) {
                    // two E's
                    return false;
                }
                if (!foundDigit) {
                    return false;
                }
                hasExp = true;
                allowSigns = true;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (!allowSigns) {
                    return false;
                }
                allowSigns = false;
                foundDigit = false; // we need a digit after the E
            } else {
                return false;
            }
            i++;
        }
        if (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                // no type qualifier, OK
                return true;
            }
            if (chars[i] == 'e' || chars[i] == 'E') {
                // can't have an E at the last byte
                return false;
            }
            if (chars[i] == '.') {
                if (hasDecPoint || hasExp) {
                    // two decimal points or dec in exponent
                    return false;
                }
                // single trailing decimal point after non-exponent is ok
                return foundDigit;
            }
            if (!allowSigns
                    && (chars[i] == 'd'
                    || chars[i] == 'D'
                    || chars[i] == 'f'
                    || chars[i] == 'F')) {
                return foundDigit;
            }
            if (chars[i] == 'l'
                    || chars[i] == 'L') {
                // not allowing L with an exponent or decimal point
                return foundDigit && !hasExp && !hasDecPoint;
            }
            // last character is illegal
            return false;
        }
        // allowSigns is true iff the val ends in 'E'
        // found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
        return !allowSigns && foundDigit;
    }
}
