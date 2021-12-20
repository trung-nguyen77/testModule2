package controller;

import phoneBookService.PhoneBookService;
import views.Alerts;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    Alerts alert = new Alerts();
    Scanner scanner =new Scanner(System.in);
    PhoneBookService phoneBookService = new PhoneBookService();


    public String validateName() {
        String regex = scanner.nextLine();
        if (phoneBookService.checkName(regex)) {
            System.err.println("DA TON TAI TEN NAY!");
            validateName();
        }
        final String ACCOUNT_REGEX = ("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\"+\n" +
                "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\"+\n" +
                "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        if (matcher.matches()) {
            return regex;
        } else {
            System.err.println("VUI LONG NHAP LAI!");
            regex = validateName();
        }
        return regex;
    }

    public String validatePhoneNumber() {
        String regex = scanner.nextLine();
        Pattern pattern = Pattern.compile("[0]\\d{9}");
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.err.println("VUI LONG NHAP LAI SO DIEN THOAI!");
            return validatePhoneNumber();
        }else return regex;
    }

    public String validateDate(){
        String regex = scanner.nextLine();
        Pattern pattern = Pattern.compile("[0-3]\\d-[012]\\d-\\d{4}");
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.err.println("VUI LONG NHAP LAI NGAY!");
            return validateDate();
        }else return regex;
    }

    public String validateEmail(){
        String regex = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.(codegym))$");
        Matcher matcher = pattern.matcher(regex);
        if(!matcher.matches()){
            System.err.println("VUI LONG NHAP LAI!");
            System.err.println("Email phải có đuôi \".codegym\" !");
            return validateEmail();
        }else return regex;
    }

    public String validateAddress() {
        String regex = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9 ]+$");
        Matcher matcher = pattern.matcher(regex);
        if (!matcher.matches()) {
            System.err.println("VUI LONG NHẬP LẠI !");
            return validateDate();
        } else return regex;
    }
}
