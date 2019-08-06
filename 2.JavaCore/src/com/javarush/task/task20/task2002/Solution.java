package com.javarush.task.task20.task2002;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {

    static SimpleDateFormat  dateFormat = new SimpleDateFormat("dd_mm_yyyy");

    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("test.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            User petya = new User();
            petya.setFirstName("Петя");
            petya.setLastName("Иванов");
            petya.setMale(true);
            petya.setBirthDate(new GregorianCalendar(1995, Calendar.AUGUST, 21).getTime());
            petya.setCountry(User.Country.UKRAINE);

            User masha = new User();
            masha.setFirstName("Маша");
            masha.setLastName("Зодчева");
            masha.setMale(false);
            masha.setBirthDate(new GregorianCalendar(1996, Calendar.APRIL, 5).getTime());
            masha.setCountry(User.Country.RUSSIA);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(petya);
            javaRush.users.add(masha);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush.users.equals(loadedObject.users));
            System.out.println(javaRush.hashCode() == loadedObject.hashCode());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter pw = new PrintWriter(outputStream);
            if (users!=null){
                for (User user : users) {
                    pw.println(user.getFirstName());
                    pw.println(user.getLastName());
                    pw.println(user.getBirthDate().getTime());
                    pw.println(user.getCountry());
                    pw.println(user.isMale());
                }
            }
            pw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                User user = new User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                String country = reader.readLine();
                if (country.equalsIgnoreCase("Russia")) {
                    user.setCountry(User.Country.RUSSIA);
                } else if (country.equalsIgnoreCase("Ukraine")) {
                    user.setCountry(User.Country.UKRAINE);
                } else if (country.equalsIgnoreCase("Other")) {
                    user.setCountry(User.Country.OTHER);
                }
                user.setMale(Boolean.parseBoolean(reader.readLine()));
                users.add(user);
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}