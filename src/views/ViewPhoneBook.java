package views;

import controller.Validate;
import io.ReadAndWritePhoneBook;
import models.PhoneBook;

import java.util.List;
import java.util.Scanner;

public class ViewPhoneBook {
    Scanner scanner = new Scanner(System.in);

    public int menu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới ");
        System.out.println("3. Cập nhập");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int menushow() {
        System.out.println("1. Thêm mới ");
        System.out.println("2. Cập nhập");
        System.out.println("3. Xóa");
        System.out.println("4. Quay lại menu chương trình");
        System.out.print("Chọn chức năng theo số: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void show(List<PhoneBook> phoneBookList) {
        for (PhoneBook phoneBook : phoneBookList) {
            System.out.println(phoneBook.toString());
        }
    }

    public String inputPhoneNumber() {
        System.out.println("Nhập số điện thoại cần tìm:");
        return scanner.nextLine();
    }

    public String inputName() {
        System.out.println("Nhập name");
        return scanner.nextLine();
    }

    public PhoneBook cretePhoneBook() {
        Validate validate = new Validate();
        System.out.println("Nhập name");
        String name = validate.validateName();
        System.out.println("Nhập phoneNumber");
        String phoneNumber = validate.validatePhoneNumber();
        System.out.println("Nhập address");
        String address = validate.validateAddress();
        System.out.println("Nhập email");
        String email = validate.validateEmail();
        return new PhoneBook(name, phoneNumber, address, email);
    }


}
