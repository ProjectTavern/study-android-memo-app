package com.example.qoov.memo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileManager {
    private static final String FILENAME = "MEMO.txt";
    Context mContext = null;

    public TextFileManager(Context context) {
        mContext = context;
    }

    public void save(String data) {
        if (data == null || "".equals(data)) {
            return;
        }

        FileOutputStream fosMemo = null;

        try {
            fosMemo = mContext.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fosMemo.write(data.getBytes());
            fosMemo.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String load() {
        try {
            FileInputStream fisMemo = mContext.openFileInput(FILENAME);

            byte[] memoData = new byte[fisMemo.available()];
            while (fisMemo.read(memoData) != -1) { }
            return new String(memoData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public void delete() {
        mContext.deleteFile(FILENAME);
    }
}
