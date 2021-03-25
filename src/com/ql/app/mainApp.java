package com.ql.app;

import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int choose;
		do {
			System.out.println("0. Quan ly Nhan Vien");
			System.out.println("1.Quan Ly Phong Ban");
			choose = sn.nextInt();
		}while(choose <-1 && choose >2);
		switch (choose) {
		case 0:{
			MainNV manv= new MainNV();
			manv.qlNhanvien();
			break;
		}
		case 1:
			mainPB mapb = new mainPB();
			mapb.qlPhongban();
			break;
		}
	}

}
