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

import com.ql.model.Phongban;

public class PhongbanDao {
    private static final String Phongban_FILE_NAME = "Phongban.txt";

    public void write(List<Phongban> phongbanList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(Phongban_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(phongbanList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(oos);
        }
    }

    public List<Phongban> read() {
        List<Phongban> phongbanList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(Phongban_FILE_NAME));
            ois = new ObjectInputStream(fis);
            List<Phongban> readObject = extracted(ois);
            phongbanList = readObject;
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
        return phongbanList;
    }

	private List<Phongban> extracted(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		return (List<Phongban>) ois.readObject();
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
