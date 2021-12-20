package io;

import models.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWritePhoneBook {
    public static List<PhoneBook> readFromFile(String filePath) {
        List<PhoneBook> phoneBooks = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.isFile()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] tokens = str.split(",");
                phoneBooks.add(new PhoneBook(tokens[0], tokens[1], tokens[2], tokens[3]));
            }
            return phoneBooks;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void writeToFile(List<PhoneBook> phoneBookList,String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (PhoneBook phoneBook : phoneBookList) {
                bufferedWriter.write(phoneBook.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
