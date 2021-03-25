package com.ql.app;

import java.util.Scanner;

import com.ql.repo.PhongbanManager;


public class mainPB {
    public static Scanner scanner = new Scanner(System.in);

    public static void qlPhongban() {
        String choose = null;
        boolean exit = false;
        PhongbanManager phongbanManager = new PhongbanManager();
        int phongbanId;

        // show menu
        showMenuPB();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
            case "1":
            	phongbanManager.addPB();
                break;
            case "2":
            	phongbanId = phongbanManager.inputIdPB();
            	phongbanManager.editPB(phongbanId);
                break;
            case "3":
            	phongbanId = phongbanManager.inputIdPB();
            	phongbanManager.deletePB(phongbanId);
                break;
            case "4":
                    phongbanId = phongbanManager.inputIdPB();
                    phongbanManager.fillbyid(phongbanId);
                    break;
            case "5":
            	phongbanManager.showPB();
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
            showMenuPB();
        }
    }


    public static void showMenuPB() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add phong ban .");
        System.out.println("2. Edit phong ban by id.");
        System.out.println("3. Delete phong ban by id.");
        System.out.println("4. Fill phong ban by id.");
        System.out.println("5. Show phong ban.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}
