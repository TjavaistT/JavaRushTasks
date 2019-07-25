package com.javarush.task.task19.task1918;

/* Задача 1918
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<String> tags = new ArrayList<>();
    private static String tag = "span";

    //баланс помогает справится с вложенностью
    //если найден открывающий тег - уменьшается на еденицу
    //если найден закрывающий тег - увеличивается на еденицу
    //т.е. когда баланс приходит в ноль - значит закрылись все теги
    private static volatile int balance;

    public static void main(String[] args) {
        try (
                BufferedReader scanConsole = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileStream = new BufferedReader(new FileReader(scanConsole.readLine()))
        ) {
            tag = args[0];

            String allContent = fileStream.lines().reduce((line1, line2) -> line1 + line2)
                    ///по условию переносы строк нужно не учитывать
                    .map(element -> element.replaceAll("\\n", "").replaceAll("\\r", "")).orElse("");

            //получить первый тег в тексте (может быть родительским)
            List<String> tags = getTags(allContent);

            tags.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //получить местоположение тега в тексте
    public static List<String> getTags(String allText) {
        //позиция в которой заканчивается тег и начинается текст
        // показывает до куда необходимо обрезать текст, чтоб остался не проанализированный остаток
        Integer currentPositionText = 0;
        //позиция в общем тексте первого символа открывающего тега
        int firstPosition = getOpenTagPosition(allText);
        //позиция в общем тексте последнего символа закрывающего тега
        Integer lastPosition = 0;
        //не проанализированный остаток
        String cutText = allText;


        do{
            if(isOpenNextTag(cutText)) {
                //сумма открывающих (отрицательных) и закрывающих (положительных) тегов
                //позволяет не переживать о вложенности
                balance--;

                currentPositionText = getOpenTagPosition(cutText) + getOpenTag().length();

                lastPosition += currentPositionText;

            } else if(isClosedNextTag(cutText)){
                //сумма открывающих (отрицательных) и закрывающих (положительных) тегов
                //позволяет не переживать о вложенности
                balance++;

                currentPositionText = getClosedTagPosition(cutText) + getClosedTag().length();

                lastPosition += currentPositionText;
            }

            //отрезать уже проверенное
            cutText = cutText.substring(currentPositionText);
        }
        while(balance != 0);

        String fullTagText = getFullTagText(allText, firstPosition, lastPosition);
        //нашел результат, который искал - сохраняю
        tags.add(fullTagText);
        //внутрений текст тега без обрамляющих тегов
        String innerTagText = fullTagText.substring(getOpenTag().length(), fullTagText.length() - getClosedTag().length());

        //проверка остались ли теги внутри рассмотренного тега и получение, если есть, через рекурсию
        if(isTagInText(innerTagText)){
            getTags(innerTagText);
        }

        //проверка остались ли теги в оставшемся не исследованном тексте и получение, если есть через рекурсию
        if(isTagInText(cutText)){
            getTags(cutText);
        }

        return tags;
    }

    public static int getOpenTagPosition(String text) {
        return getStringPosition(text, getOpenTag());
    }

    public static int getClosedTagPosition(String text) {
        return getStringPosition(text, getClosedTag());
    }

    private static String getOpenTag() {
        return "<" + tag;
    }

    private static String getClosedTag() {
        return "</" + tag + ">";
    }

    private static  int getStringPosition(String text, String str){
        return text.indexOf(str);
    }

    public static boolean isOpenNextTag(String text) {
        return getOpenTagPosition(text) != -1 && getOpenTagPosition(text) < getClosedTagPosition(text);
    }

    public static boolean isClosedNextTag(String text) {
        return getClosedTagPosition(text) != -1 && (
                getClosedTagPosition(text) < getOpenTagPosition(text)
                || getOpenTagPosition(text) == -1);
    }

    public static String getFullTagText(String text, int firstPosition, int lastPosition) {
        return text.substring(firstPosition, lastPosition);
    }

    public static boolean isTagInText(String text) {
        return isOpenNextTag(text);
    }
}
