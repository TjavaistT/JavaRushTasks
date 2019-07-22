package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class DataAdapter implements RowItem {
        public Customer getCustomer() {
            return customer;
        }

        public Contact getContact() {
            return contact;
        }

        private final Customer customer;
        private final Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryName = getCustomer().getCountryName();
            return countries.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(countryName))
                    .map(Map.Entry::getKey)
                    .findFirst().get();
        }

        @Override
        public String getCompany() {
            return getCustomer().getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return getContact().getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return getContact().getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            return "callto://" + getContact().getPhoneNumber().replaceAll("[^\\d+]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}