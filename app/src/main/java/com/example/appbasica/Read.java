package com.example.appbasica;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Read {
    public Read() {
    }

    public static void csvRead(String ruta) throws FileNotFoundException {
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        CSVReaderBuilder builder = new CSVReaderBuilder(new FileReader(ruta));
        try (CSVReader reader = builder.withCSVParser(parser).withSkipLines(1).build()) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String name = nextLine[0];
                String nickname = nextLine[1];
                String email =nextLine[2];
                String userID =nextLine[3];
                UserProfile.Users.add(new UserProfile(name,nickname,email,userID));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
