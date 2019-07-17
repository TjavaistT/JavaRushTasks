package com.javarush.task.task18.task1828;

//не нашел возможности редактировать строчки в файле - только перезаписать
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        if (args.length != 0) {
            try (Scanner scanConsole = new Scanner(System.in)) {
                String filename = scanConsole.nextLine();

                if (args[0].equals("-u")) {
                    String idItem = args[1];
                    String nameItem = args[2];
                    String priceItem = args[3];
                    String quantityItem = args[4];

                    updateItem(filename, idItem, nameItem, priceItem, quantityItem);
                }

                if (args[0].equals("-d")) {
                    String idItem = args[1];

                    deleteItem(filename, idItem);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void updateItem(String filename, String id, String name, String price, String quantity) throws IOException {
        Scanner readFileStream = null;

        try {
            readFileStream = new Scanner(new BufferedInputStream(new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Item> items = getItems(readFileStream);

        items.stream()
            //получаю объект с необходимым id
            .filter(item -> Objects.equals(item.getId(), id))
            //заменяю ему все необходимые поля,
            .forEach(item -> {
                item.setName(name);
                item.setPrice(price);
                item.setQuantity(quantity);
            });

        assert readFileStream != null;
        readFileStream.close();

        BufferedOutputStream writeFileStream = new BufferedOutputStream(new FileOutputStream(filename));

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            writeFileStream.write(item.toString().getBytes());
            if(i != items.size() - 1){
                writeFileStream.write(("\n").getBytes());
            }
        }

        writeFileStream.close();
    }

    private static void deleteItem(String filename, String id) throws IOException {
        Scanner readFileStream = null;
        try {
            readFileStream = new Scanner(new BufferedInputStream(new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Item> items = getItems(readFileStream);

        List<Item> modifiedItems = items.stream()
                //отфильтровываю ненужный элемент
                .filter(item -> !item.getId().equals(id))
                //и записываю в список
                .collect(Collectors.toList());

        assert readFileStream != null;
        readFileStream.close();

        BufferedOutputStream writeFileStream = new BufferedOutputStream(new FileOutputStream(filename));

        for (int i = 0; i < modifiedItems.size(); i++) {
            Item item = modifiedItems.get(i);
            writeFileStream.write(item.toString().getBytes());
            if(i != modifiedItems.size() - 1){
                writeFileStream.write(("\n").getBytes());
            }
        }
        writeFileStream.close();

    }

    private static List<Item> getItems(Scanner scanFile) {
        Item currentItem = new Item();
        List<Item> items = new ArrayList<>();

        try {

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
                        currentItem.setId(paramItem.trim());
                        continue;
                    }

                    if(currentItem.getName() == null){
                        currentItem.setName(paramItem.trim());
                        continue;
                    }

                    if (currentItem.getPrice() == null){
                        currentItem.setPrice(paramItem.trim());
                        continue;
                    }

                    if(currentItem.getQuantity() == null){
                        currentItem.setQuantity(paramItem.trim());
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

    public static class Item{

        private String id = null;

        private String name = null;

        private String price = null;

        private String quantity = null;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public String getQuantity() {
            return quantity;
        }

        public Item() {
        }

        public Item(String id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setQuantity(String quantity) {
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
                //переделал свое решение на общепринятое String.format("%-8d%-30s%-8s%-4d%n", getId(), getName(), getPrice(), getQuantity())
                //и пожалел - пропало обрезание символов
                //пришлось общепринятое String.format подпереть костылем trimParam

                result = String.format(
                        "%-8s%-30s%-8s%-4s",
                        trimParam(getId(), 8),
                        trimParam(getName(), 30),
                        trimParam(getPrice(), 8),
                        trimParam(getQuantity(),4)
                );
            } else {
                result = super.toString();
            }

            return result;
        }

        public String trimParam(Object o, int length){
            String param = String.valueOf(o);
            return param.length() > length ? param.substring(0, length) : param;
        }
    }
}