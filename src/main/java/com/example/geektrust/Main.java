package com.example.geektrust;

import com.example.geektrust.model.MetroCard;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
//            FileInputStream fis = new FileInputStream(args[0]);
            FileInputStream fis = new FileInputStream("sample_input/input2.txt");
            Scanner sc = new Scanner(fis);
            MetroCardApplication metroCardApplication = new MetroCardApplication();
            while (sc.hasNextLine()) {
                String data[] = sc.nextLine().split(" ");
                metroCardApplication.commandExecutor(data[0], Arrays.asList(data).subList(1, data.length));
            }
            sc.close();
        } catch (IOException e) {
        }
    }
}
