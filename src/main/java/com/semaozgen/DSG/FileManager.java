/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semaozgen.DSG;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sozgen
 */
public class FileManager {
    private static final String FILE_NAME = "score.txt";

    public static void saveScore(String username, String level, int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + "," + level + "," + score);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Skor kaydedilirken hata oluştu: " + e.getMessage());
        }
    }

    public static void loadScoresToBST(scoreBST bst) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String level = parts[1];
                    int score = Integer.parseInt(parts[2]);
                    bst.insert(username, level, score);
                }
            }
        } catch (IOException e) {
            System.out.println("Skor okunurken hata oluştu: " + e.getMessage());
        }
    }
}

