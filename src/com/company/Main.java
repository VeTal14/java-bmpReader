package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
//        String defoultImg = "C:\\Users\\vteli\\OneDrive\\Рабочий стол\\Изображения\\test_bmp.bmp";
        if (path.equals("") || !path.split("\\.")[1].equals("bmp")) {
            System.out.println("Image has no .bmp extension");
            System.exit(0);
        }

        File file = new File(path);

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            byte[] imageBytes = ((DataBufferByte) bufferedImage.getData().getDataBuffer()).getData();
            System.out.println("File size in bytes: " + imageBytes.length);
            System.out.println("Name of the image: " + file.getName());
            System.out.println(bufferedImage.getColorModel());
            System.out.println("Type: " + bufferedImage.getType());
            System.out.println("Width of the image: " + bufferedImage.getWidth());
            System.out.print("Height of the image: " + bufferedImage.getHeight());
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }

    }
}
