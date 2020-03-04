package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;

public class WorkWithFile {

    private String inPath;
    private String outPath;
    private RandomAccessFile file;

    // говорим конструктору проинициализировать путь к файлу
    public WorkWithFile(String inPath, String outPath) {
        this.inPath = inPath;
        this.outPath = outPath;
    }


    public String readType() throws IOException {
        file = new RandomAccessFile(inPath, "r");
        String res = "";
        int b = file.read();
        // побитово читаем символы и плюсуем их в строку

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

    // запись в файл
    public void write(String st) throws IOException {
        // открываем файл для записи
        // для этого указываем модификатор rw (read & write)
        // что позволит открыть файл и записать его
        file = new RandomAccessFile(outPath, "rw");

        // записываем строку переведенную в биты
        file.write(st.getBytes());

        // закрываем файл, после чего данные записываемые данные попадут в файл
        file.close();
    }

}

