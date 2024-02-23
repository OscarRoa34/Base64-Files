package co.edu.uptc.Models;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class Base64TextModel {

    public void processBase64File(String base64String, String outputPath) {
        try {
            byte[] textBytes = decodeBase64(base64String);
            saveText(textBytes, outputPath);
            System.out.println("Archivo guardado en: " + outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] decodeBase64(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

    public void saveText(byte[] textBytes, String outputPath) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(textBytes);
        File outputFolder = new File(outputPath).getParentFile();
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }

        FileOutputStream out = new FileOutputStream(outputPath);

        int bytesRead;
        byte[] buffer = new byte[1024];
        while ((bytesRead = bis.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        bis.close();
        out.close();
    }

}
