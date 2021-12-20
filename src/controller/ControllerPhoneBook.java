package controller;

import io.ReadAndWritePhoneBook;
import models.PhoneBook;
import phoneBookService.PhoneBookService;
import views.Alerts;
import views.ViewPhoneBook;

import java.util.ArrayList;
import java.util.List;

public class ControllerPhoneBook {
    public static void menuManager() {
        ViewPhoneBook viewPhoneBook = new ViewPhoneBook();
        PhoneBookService phoneBookService = new PhoneBookService();
        List<PhoneBook> phoneBookList = new ArrayList<>();
        Alerts alerts = new Alerts();

        while (true) {
            int choice = viewPhoneBook.menu();
            switch (choice) {
                case 1:
                    ReadAndWritePhoneBook.readFromFile("phoneBook.csv");
                    viewPhoneBook.show(phoneBookService.findAll());
                    int choiceShow = viewPhoneBook.menushow();
                    switch (choiceShow) {
                        case 1:
                            phoneBookService.addPhoneBook(viewPhoneBook.cretePhoneBook());
                            break;

                        case 2:
                            int indexEdit = phoneBookService.findIndexByPhoneNumber(viewPhoneBook.inputPhoneNumber());
                            if (indexEdit != -1) {
                                phoneBookService.edit(indexEdit, viewPhoneBook.cretePhoneBook());
                            }
                            break;

                        case 3:
                            if (alerts.confirmToDelete()) {
                                int indexDelete = phoneBookService.findIndexByPhoneNumber(viewPhoneBook.inputPhoneNumber());
                                if (indexDelete != -1) {
                                    phoneBookService.delete(indexDelete);
                                }
                            } else {
                                viewPhoneBook.menushow();
                            }
                            break;

                        case 4:
                            break;
                        default:
                            alerts.reEnter();
                            viewPhoneBook.menushow();
                    }
                    break;

                case 2:
                    phoneBookService.addPhoneBook(viewPhoneBook.cretePhoneBook());
                    break;

                case 3:
                    if (alerts.confirmToUpdate()) {
                        int indexEdit = phoneBookService.findIndexByPhoneNumber(viewPhoneBook.inputPhoneNumber());
                        phoneBookService.edit(indexEdit, viewPhoneBook.cretePhoneBook());
                    } else {
                        menuManager();
                    }
                    break;

                case 4:
                    if (alerts.confirmToDelete()) {
                        int indexDelete = phoneBookService.findIndexByPhoneNumber(viewPhoneBook.inputPhoneNumber());
                        phoneBookService.delete(indexDelete);
                    } else {
                        menuManager();
                    }
                    break;

                case 5:
                    int indexFindByName = phoneBookService.findIndexByNameApprox(viewPhoneBook.inputName());
                    phoneBookService.showSearched(indexFindByName);
                    return;

                case 6:
                    ReadAndWritePhoneBook readAndWritePhoneBook = new ReadAndWritePhoneBook();
                    readAndWritePhoneBook.readFromFile("phoneBook.csv");

                    break;

                case 7:
                    if(alerts.confirmToUpdate()) {
                        ReadAndWritePhoneBook.writeToFile(phoneBookService.findAll(),"phoneBook.csv");
                    }
                    break;

                case 8:
                    System.exit(8);
                    break;

                default:
                    alerts.reEnter();
            }
        }
    }
}
