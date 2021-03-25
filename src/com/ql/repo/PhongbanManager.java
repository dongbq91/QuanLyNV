package com.ql.repo;

import java.util.List;
import java.util.Scanner;

import com.ql.dao.PhongbanDao;
import com.ql.model.Phongban;


public class PhongbanManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Phongban> phongbanList;
    private PhongbanDao phongbanDao;

    public PhongbanManager() {
    	phongbanDao = new PhongbanDao();
    	phongbanList = phongbanDao.read();
    }

    public void addPB() {
        int idPB = (phongbanList.size() > 0) ? (phongbanList.size() + 1) : 1;
        System.out.println("Phong ban id = " + idPB);
        String namePB = inputName();
        Phongban phongban = new Phongban(idPB , namePB);
        phongbanList.add(phongban);
        phongbanDao.write(phongbanList);
    }


    public void editPB(int idPB) {
        boolean isExisted = false;
        int size = phongbanList.size();
        for (int i = 0; i < size; i++) {
        	if (phongbanList.get(i).getIdPB() == idPB) {
                isExisted = true;
                phongbanList.get(i).setNamePB(inputName());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", idPB);
        } else {
        	phongbanDao.write(phongbanList);
        }
    }

    public void deletePB(int idPB) {
        Phongban phongban = null;
        int size = phongbanList.size();
        for (int i = 0; i < size; i++) {
            if (phongbanList.get(i).getIdPB() == idPB) {
            	phongban = phongbanList.get(i);
                break;
            }
        }
        if (phongban != null) {
        	phongbanList.remove(phongban);
        	phongbanDao.write(phongbanList);
        } else {
            System.out.printf("id = %d not existed.\n", idPB);
        }
    }
    public int fillbyid(int idPB){
        Phongban phongban = null;
        int size = phongbanList.size();
        for (int i=0;i<size;i++){
            if(phongbanList.get(i).getIdPB() == idPB){
                System.out.println("Tim thay phan tu : "+phongbanList.get(i));
                return idPB;
            }
        }
        return -1 ;
    }

    
    public void showPB() {
        for (Phongban phongban : phongbanList) {
            System.out.format("%5d | ", phongban.getIdPB());
            System.out.format("%20s | ", phongban.getNamePB());
        }
    }

    public int inputIdPB() {
        System.out.print("Input phong ban id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input phong ban id again: ");
            }
        }
    }
    
    private String inputName() {
        System.out.print("Input phong ban name: ");
        return scanner.nextLine();
    }

    public List<Phongban> getphongbanList() {
        return phongbanList;
    }

    public void setStudentList(List<Phongban> phongbanList) {
        this.phongbanList = phongbanList;
    }
}
