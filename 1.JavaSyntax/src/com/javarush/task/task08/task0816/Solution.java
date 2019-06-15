package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 0816 - Есть только один способ удалить запись из карты во время итерации не вызвав конфликта с итератора
это удалять через итератор :)
Также необходимо явно указывать какие значения хотим получить в паре ключ - значения, иначе все будет свдено к строке
Добрая Зинаида и летние каникулы
*/
public class Solution {

    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Погорелов", df.parse("NOVEMBER 5 1981"));
        map.put("Левин", df.parse("JUNE 6 1982"));
        map.put("Булгаков", df.parse("SEPTEMBER 7 1983"));
        map.put("Карпов", df.parse("JUNE 8 1984"));
        map.put("Корсиков", df.parse("JUNE 9 1984"));
        map.put("Романчук", df.parse("JUNE 10 1985"));
        map.put("Марченко", df.parse("JUNE 11 1985"));
        map.put("Зорин", df.parse("JUNE 12 1987"));
        map.put("Лутченко", df.parse("JULY 15 1988"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator mapIterator = map.entrySet().iterator();

        while (mapIterator.hasNext()){
            //если не применить в итераторе Map.Entry то и удалить он ничего не сможет
            //здесь важно указать <String, Date> иначе запишет в переменную число как строку и функции для даты к строке не примяенятся
            Map.Entry<String, Date> pair = (Map.Entry) mapIterator.next();

            if(pair.getValue().getMonth() == 5
                || pair.getValue().getMonth() == 6
                || pair.getValue().getMonth() == 7){
                // единственный не конфликтный способ удаления из карты во время перебора
                mapIterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        try {
            HashMap<String, Date> map = createMap();
            removeAllSummerPeople(map);
        } catch (Throwable exception){
            System.out.println(exception);
        }
    }
}