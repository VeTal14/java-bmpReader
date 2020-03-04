package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    private  static WorkWithFile worker;
    private static String inPath;
    private static String outPath;

    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);
//        String defoultImg = "C:\\Users\\vteli\\OneDrive\\Рабочий стол\\Изображения\\test_bmp.bmp";
        boolean isRight = false;

        while (!isRight){
            System.out.println("Вкажіть повний шлях до файлу типа .BMP: ");
            inPath = scanner.nextLine();

            if(!inPath.contains(".")){
                System.out.println("Неіснуючий шлях до файлу!");
                continue;
            }
            if (inPath.equals("") || !inPath.split("\\.")[1].equals("bmp")) {
                System.out.println("Image has no .bmp extension");
            }
            else isRight = true;

        }

        System.out.println("Вкажіть повний шлях до файлу, куди треба записати результат: ");
        outPath = scanner.nextLine();

        worker = new WorkWithFile(inPath,outPath);
        worker.write(" bfType: " + worker.readType() + "\n bfSize: " +  worker.getSize() + "\n bfReservedWords: first -  " + worker.getReservedWords().substring(0,2) + ", second - " + worker.getReservedWords().substring(2,6) + "\n bfOffBits: " + worker.getOffBits());

//
//        File file = new File(path);
//
//        try {
//            BufferedImage bufferedImage = ImageIO.read(file);
//            byte[] imageBytes = ((DataBufferByte) bufferedImage.getData().getDataBuffer()).getData();
//            System.out.println("File size in bytes: " + imageBytes.length);
//            System.out.println("Name of the image: " + file.getName());
//            System.out.println(bufferedImage.getColorModel());
//            System.out.println("Type: " + bufferedImage.getType());
//            System.out.println("Width of the image: " + bufferedImage.getWidth());
//            System.out.print("Height of the image: " + bufferedImage.getHeight());
//
//        } catch (IOException e) {
//            System.out.println("Error, " + e.getMessage());
//        }

    }


}
