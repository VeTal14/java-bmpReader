package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;

public class WorkWithFile {

    private String inPath;
    private String outPath;
    private RandomAccessFile file;

    // ������� ������������ ������������������� ���� � �����
    public WorkWithFile(String inPath, String outPath) {
        this.inPath = inPath;
        this.outPath = outPath;
    }


    public String readType() throws IOException {
        file = new RandomAccessFile(inPath, "r");
        String res = "";
        int b = file.read();
        // �������� ������ ������� � ������� �� � ������

        for(int i = 0; i < 2; i ++){
                res = res + (char)b;
                b = file.read();
        }


        file.close();

        return res;
    }

    public String getSize() throws IOException{
        file = new RandomAccessFile(inPath, "r");
        String  size = "";

        file.seek(2);
        int b = file.read();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 4; i ++){
                sb.append(b);
                b = file.read();
        }
        size = sb.toString();
        file.close();
        return size;
    }

    public String getReservedWords() throws IOException{
        file = new RandomAccessFile(inPath, "r");
        String  bfRes = "";
        file.seek(7);
        int b = file.read();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 4; i ++){
                sb.append(b);
                b = file.read();
        }
        bfRes = sb.toString();
        file.close();
        return bfRes;
    }

    public String getOffBits() throws IOException{
        file = new RandomAccessFile(inPath, "r");
        String  offBits = "";

        file.seek(11);
        int b = file.read();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 4; i ++){
            sb.append(b);
            b = file.read();
        }
        offBits = sb.toString();
        file.close();
        return offBits;
    }

    // ������ � ����
    public void write(String st) throws IOException {
        // ��������� ���� ��� ������
        // ��� ����� ��������� ����������� rw (read & write)
        // ��� �������� ������� ���� � �������� ���
        file = new RandomAccessFile(outPath, "rw");

        // ���������� ������ ������������ � ����
        file.write(st.getBytes());

        // ��������� ����, ����� ���� ������ ������������ ������ ������� � ����
        file.close();
    }

}

