package com.hockeyhigh.util;

import com.hockeyhigh.model.entity.enums.MediaType;
import com.hockeyhigh.model.entity.media.Media;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static final String GENERAL_FOLDER = "src/main/webapp/articles/";
    public static final String VIDEOS_FOLDER = "src/main/webapp/videos/";

    public static List<String> readFile(String url) {
        List<String> rows = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(url));
            String row;
            while((row= bufferedReader.readLine()) != null) {
                rows.add(row);
            }
        }
        catch (IOException ex) {
            System.out.println("File does not exists");
            return null;
        }
        return rows;
    }

    public static void createFolder(Media media) throws IOException {
        String folder = "";
        if(media.getType() == MediaType.PHOTO) {
            folder = GENERAL_FOLDER;
        }
        if(media.getType() == MediaType.VIDEO) {
            folder = VIDEOS_FOLDER;
        }
        File directory = new File(folder + media.getId());

        if (directory.mkdirs()) {
            System.out.println("Directory created successfully");
        }

    }
}
