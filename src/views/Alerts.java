package views;

import java.util.Scanner;

public class Alerts {
    Scanner scanner = new Scanner(System.in);
    public void reEnter() {
        System.err.println("Vui long nhap lai");
    }

    public void doesNotExist() {
        System.err.println("Không tìm thấy!");
    }

    public boolean confirmToDelete() {
        System.err.println("Ban co chac muon xóa khong?");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("Yes")) {
            return true;
        }
        return false;
    }

    public void alertChoose() {
        System.err.println("Vui long chon dung so");
    }

    public boolean confirmToUpdate() {
        System.err.println("Bạn có chắc muốn ghi đè lại file không?");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("Yes")) {
            return true;
        }
        return false;
    }

    public void confirm() {
        System.err.println("Ấn Yes để xác nhận");
    }

    public void finish() {
        System.out.println("Da hoan thanh!");
    }

    public void noPhoneBookInList(){
        System.err.println("Khong tồn tại danh bạ!");
    }
}
