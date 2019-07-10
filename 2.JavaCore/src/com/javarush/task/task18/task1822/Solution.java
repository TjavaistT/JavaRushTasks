package com.javarush.task.task18.task1822;

/* Задача 1822 - как выпарсить из файла строки с пробелами
* если будешь заглядывать в этот файл - то сможешь решить задачу как ее решили бы в проекте
*
* для решения задачи достаточно распознать id c которого строка начинается
* но лучше решить качественно, т.е. выделить и структурировать все данные
*
 Поиск данных внутри файла
*/

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        int id = Integer.parseInt(args[0]);

        List<Item> items = getItems();

        if(id >= 0){
            Optional<Item> searchItem = items.stream().filter(item -> item.getId() == id).findFirst();
            System.out.println(searchItem.orElse(new Item()));
        }
    }

    private static List<Item> getItems() {
        String wordInFile;

        Item currentItem = new Item();
        List<Item> items = new ArrayList<>();

        StringBuilder itemName = new StringBuilder();

        //объявляем сразу поток чтения с консоли и из файла в блоке автозакрытия, чтоб потом не забыть закрыть
        //одновременно это же и блок отлова ошибок (обожаю этот лайфхак :) )
        try (Scanner scanConsole = new Scanner(System.in);
             Scanner scanFile = new Scanner(new BufferedInputStream(new FileInputStream(scanConsole.nextLine())))){
            scanFile.useDelimiter(Pattern.compile("\\s+"));

            while (scanFile.hasNextLine()){
                wordInFile = scanFile.next();

                //получаем исключительно строки, для этого проверяем может ли сторока быть числом
                //для этой достаточно проверить может ли число быть дробным Double
                while (!isNumeric(wordInFile))
                {
                    itemName.append(" ").append(wordInFile);
                    wordInFile = scanFile.next();
                }

                //значения товара записаны в файле по порядку - Id, Имя Цена, Количество
                //в таком порядке и проверяем
                if (currentItem.getId() == null) {
                    currentItem.setId(Integer.parseInt(wordInFile));
                    continue;
                }

                if(!itemName.toString().equals("")){
                    currentItem.setName(itemName.toString());
                    itemName = new StringBuilder();
                }

                if (currentItem.getPrice() == null){
                    currentItem.setPrice(Double.parseDouble(wordInFile));
                    continue;
                }

                if(currentItem.getQuantity() == null){
                    currentItem.setQuantity(Integer.parseInt(wordInFile));
                }

                //сохраним товар в коллекцию, чтоб до него не добрался сборщик муссора
                items.add(currentItem);

                currentItem = new Item();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }


    private static boolean isNumeric(String word) {
        try {
            Double.parseDouble(word);
            return true;
        } catch (NumberFormatException exc){
            return false;
        }
    }

    //поступим как верные ООП-адепты - создадим объект Товар
    public static class Item{

        private Integer id = null;

        private String name = null;

        private Double price = null;

        private Integer quantity = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return getId() + " " + getName() + " " + getPrice() + " " + getQuantity();
        }
    }

}
