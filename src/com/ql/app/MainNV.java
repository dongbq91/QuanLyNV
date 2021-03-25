package com.ql.app;

import java.util.Scanner;

import com.ql.repo.NhanvienManager;


public class MainNV {
    public static Scanner scanner = new Scanner(System.in);

    public static void qlNhanvien() {
        String choose = null;
        boolean exit = false;
        NhanvienManager nhanvienManager = new NhanvienManager();
        int nhanvienId;

        // show menu
        showMenuNV();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
            case "1":
            	nhanvienManager.add();
                break;
            case "2":
            	nhanvienId = nhanvienManager.inputId();
                nhanvienManager.edit(nhanvienId);
                break;
            case "3":
            	nhanvienId = nhanvienManager.inputId();
                nhanvienManager.delete(nhanvienId);
                break;
            case "4":
                nhanvienId = nhanvienManager.inputId();
                nhanvienManager.fillbyid(nhanvienId);
                break;
            case "5":
            	nhanvienManager.show();
                break;
            case "0":
                System.out.println("exited!");
                exit = true;
                break;
            default:
                System.out.println("invalid! please choose action in below menu:");
                break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenuNV();
        }
    }


    public static void showMenuNV() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add nhan vien .");
        System.out.println("2. Edit nhan vien by id.");
        System.out.println("3. Delete nhan vien by id.");
        System.out.println("4. Fill nhan vien by id.");
        System.out.println("5. Show nhan vien.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}
