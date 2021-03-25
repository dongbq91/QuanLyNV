package com.ql.repo;

import java.util.List;
import java.util.Scanner;

import com.ql.dao.NhanvienDao;
import com.ql.model.Nhanvien;


public class NhanvienManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Nhanvien> nhanvienList;
    private NhanvienDao nhanvienDao;

    public NhanvienManager() {
    	nhanvienDao = new NhanvienDao();
        nhanvienList = nhanvienDao.read();
    }

    public void add() {
        int id = (nhanvienList.size() > 0) ? (nhanvienList.size() + 1) : 1;
        System.out.println("Nhan vien id = " + id);
        String name = inputName();
        byte age = inputAge();
        String address = inputAddress();
        Nhanvien nhanvien = new Nhanvien( id,  name,  age,  address);
        nhanvienList.add(nhanvien);
        nhanvienDao.write(nhanvienList);
    }


    public void edit(int id) {
        boolean isExisted = false;
        int size = nhanvienList.size();
        for (int i = 0; i < size; i++) {
        	if (nhanvienList.get(i).getId() == id) {
                isExisted = true;
                nhanvienList.get(i).setName(inputName());
                nhanvienList.get(i).setAge(inputAge());
                nhanvienList.get(i).setAddress(inputAddress()); 
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
        	nhanvienDao.write(nhanvienList);
        }
    }

    public void delete(int id) {
        Nhanvien nhanvien = null;
        int size = nhanvienList.size();
        for (int i = 0; i < size; i++) {
            if (nhanvienList.get(i).getId() == id) {
            	nhanvien = nhanvienList.get(i);
                break;
            }
        }
        if (nhanvien != null) {
        	nhanvienList.remove(nhanvien);
        	nhanvienDao.write(nhanvienList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }
    public int fillbyid(int id){
        Nhanvien nhanvien = null;
        int size = nhanvienList.size();
        for (int i=0;i<size;i++){
            if(nhanvienList.get(i).getId() == id){
                System.out.println("Tim thay phan tu : "+nhanvienList.get(i));
                return id;
            }
        }
        return -1 ;
    }

    
    public void show() {
        for (Nhanvien nhanvien : nhanvienList) {
            System.out.format("%5d | ", nhanvien.getId());
            System.out.format("%20s | ", nhanvien.getName());
            System.out.format("%5d | ", nhanvien.getAge());
            System.out.format("%20s | ", nhanvien.getAddress());
        }
    }

    public int inputId() {
        System.out.print("Input nhan vien id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input nhan vien id again: ");
            }
        }
    }
    
    private String inputName() {
        System.out.print("Input nhan vien name: ");
        return scanner.nextLine();
    }

    /**
     * input student address
     * 
     * @return student address
     */
    private String inputAddress() {
        System.out.print("Input nhan vien  address: ");
        return scanner.nextLine();
    }

    private byte inputAge() {
        System.out.print("Input nhan vien age: ");
        while (true) {
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input nhan vien  id again: ");
            }
        }
    }

    // getter && setter
    public List<Nhanvien> getnhanvienList() {
        return nhanvienList;
    }

    public void setStudentList(List<Nhanvien> nhanvienList) {
        this.nhanvienList = nhanvienList;
    }
}
