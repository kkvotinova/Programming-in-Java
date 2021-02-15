//  Copyright © 2021 Ksuvot
package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Dear user, please, enter the path to your .txt file:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();
        readFile(path);
    }

    static void readFile(String path) {
        try(FileReader reader = new FileReader(path)) {
            Scanner scanner = new Scanner(reader);
            int[] alphabet = new int[26];

            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                char[] chars = string.toCharArray();
                for (char symbol : chars) {
                   if ((int)symbol >= 65 && (int)symbol <= 90) { // a ... z
                       ++alphabet[(int)symbol - 65];
                   } else if ((int)symbol >= 97 && (int)symbol <= 122) { // A ... Z
                       ++alphabet[(int)symbol - 97];
                   }
                }
            }

            reader.close();
            scanner.close();

            writeFile(alphabet);
        }
        catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    static void writeFile(int[] alphabet) {
        Path path = Paths.get("src\\resources\\output.txt").toAbsolutePath();
        try(FileWriter writer = new FileWriter(path.toString())) {
            for (int i = 0; i < 26; i++) {
                writer.append((char)(65 + i) + " " + (char)(97 + i) + " - " + alphabet[i] + "\n");
            }
            writer.close();
            System.out.println("Writing to the file was successful!");
        }
        catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
