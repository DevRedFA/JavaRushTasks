package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeData data = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }
            @Override
            public String getContactFirstName() {
                return "Ivan";
            }
            @Override
            public String getContactLastName() {
                return "Ivanov";
            }
            @Override
            public int getCountryPhoneCode() {
                return 38;
            }
            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };
        Contact
                var = new IncomeDataAdapter(data);
        Customer var2 = new IncomeDataAdapter(data);
        System.out.println(var2.getCompanyName());
        System.out.println(var2.getCountryName());
        System.out.println(var.getName());
        System.out.println(var.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        private final int maxPhoneLength = 10;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());

        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phone = String.valueOf(data.getPhoneNumber());
            String allNumber = "";
            if (phone.length() < maxPhoneLength) {
                for (int i = 0; i < maxPhoneLength - phone.length(); i++) {
                    allNumber += 0;
                }
            }
            allNumber += data.getPhoneNumber();
            return "+" + data.getCountryPhoneCode() + "(" + allNumber.substring(0, 3) + ")"
                    + allNumber.substring(3, 6) + "-" + allNumber.substring(6, 8) + "-" + allNumber.substring(8, maxPhoneLength);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}