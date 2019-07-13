package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        if(args.length != 0 && args[0].equals("-c")) {
            try (Scanner scanConsole = new Scanner(System.in)) {
                String filename = scanConsole.nextLine();
                Scanner readFileScan = new Scanner(new BufferedInputStream(new FileInputStream(filename)));

                Integer currentMaxId = getItems(readFileScan).stream().map(Item::getId).max(Integer::compareTo).orElse(0);

                Item newItem = new Item(currentMaxId + 1, args[1], Double.parseDouble(args[2]), Integer.valueOf(args[3]));

                readFileScan.close();
                BufferedOutputStream writeFileBuf = new BufferedOutputStream(new FileOutputStream(filename, true));

                writeFileBuf.write(newItem.toString().getBytes());
                writeFileBuf.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Item> getItems(Scanner scanFile) {
        Item currentItem = new Item();
        List<Item> items = new ArrayList<>();

        try {
            scanFile.useDelimiter(Pattern.compile(".{3}"));

            while (scanFile.hasNextLine()){
                String strItem = scanFile.nextLine();

                String[] paramsItem = {
                        strItem.substring(0, 8),
                        strItem.substring(8, 38),
                        strItem.substring(38, 46),
                        strItem.substring(46, 50)
                };

                for (String paramItem: paramsItem) {

                    //значения товара записаны в файле по порядку - Id, Имя Цена, Количество
                    //в таком порядке и проверяем
                    if (currentItem.getId() == null) {
                        currentItem.setId(Integer.parseInt(paramItem.trim()));
                        continue;
                    }

                    if(currentItem.getName() == null){
                        currentItem.setName(paramItem.trim());
                        continue;
                    }

                    if (currentItem.getPrice() == null){
                        currentItem.setPrice(Double.parseDouble(paramItem.trim()));
                        continue;
                    }

                    if(currentItem.getQuantity() == null){
                        currentItem.setQuantity(Integer.parseInt(paramItem.trim()));
                    }
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

    //поступим как верные ООП-адепты - создадим объект Товар
    public static class Item{

        private Integer id = null;

        private String name = null;

        private Double price = null;

        private Integer quantity = null;

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Double getPrice() {
            return price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Item() {
        }

        public Item(Integer id, String name, Double price, Integer quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {

            String result;
            //программа будет падать если вызвать строковое представление объекта, до того как в него переданы параметры
            if (getId() != null
                    && getName() != null
                    && getPrice() != null
                    && getQuantity() != null)
            {
                result = String.format("%n%-8d%-30s%-8s%-4d", getId(), getName(), getPrice(), getQuantity());
            } else {
                result = super.toString();
            }

            return result;
        }
    }

}