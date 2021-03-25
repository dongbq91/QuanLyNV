package com.ql.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ql.model.Nhanvien;

public class NhanvienDao {
    private static final String Nhanvien_FILE_NAME = "Nhanvien.txt";

    public void write(List<Nhanvien> nhanvienList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(Nhanvien_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nhanvienList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(oos);
        }
    }

    public List<Nhanvien> read() {
        List<Nhanvien> nhanvienList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(Nhanvien_FILE_NAME));
            ois = new ObjectInputStream(fis);
            List<Nhanvien> readObject = extracted(ois);
            nhanvienList = readObject;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return nhanvienList;
    }

	private List<Nhanvien> extracted(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		return (List<Nhanvien>) ois.readObject();
	}

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
