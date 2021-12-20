package phoneBookService;


import io.ReadAndWritePhoneBook;
import models.PhoneBook;
import views.ViewPhoneBook;

import java.util.List;
import java.util.Locale;

public class PhoneBookService {
    List<PhoneBook> phoneBooks = ReadAndWritePhoneBook.readFromFile("phoneBook.csv");
    ViewPhoneBook viewPhoneBook = new ViewPhoneBook();

    public PhoneBookService() {
        phoneBooks = ReadAndWritePhoneBook.readFromFile("phoneBook.csv");
    }

    public void addPhoneBook(PhoneBook phoneBook) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getName().equals(viewPhoneBook.inputPhoneNumber())) {
                System.err.println("Sô điện thoại đã tồn tại!");
                System.out.println("Nhập lại!");
                addPhoneBook(phoneBook);
            }
        }
        phoneBooks.add(phoneBook);
        ReadAndWritePhoneBook.writeToFile(phoneBooks, "phoneBook.csv");
    }

    public PhoneBook showSearched(int index) {
       return phoneBooks.get(index);
    }

    public boolean checkName(String name) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

    public List<PhoneBook> findAll() {
        return phoneBooks;
    }

    public void delete(int index) {
        phoneBooks.remove(index);
        ReadAndWritePhoneBook.writeToFile(phoneBooks,"phoneBook.csv");
    }

    public void edit(int index, PhoneBook phoneBook) {
        phoneBooks.set(index, phoneBook);
        ReadAndWritePhoneBook.writeToFile(phoneBooks,"phoneBook.csv");
    }

    public int findIndexByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }

    public int findIndexByNameApprox(String name) {
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getName().contains(name)) {
                return i;
            }
        }
        return -1;
    }
}
