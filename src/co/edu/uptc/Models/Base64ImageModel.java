package co.edu.uptc.Models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Base64;

public class Base64ImageModel {

    public void processBase64File(String base64String, String outputPath) {
        try {
            byte[] imageBytes = decodeBase64(base64String);
            saveImage(imageBytes, outputPath);
            System.out.println("Imagen guardada en: " + outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] decodeBase64(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

    public void saveImage(byte[] imageBytes, String outputPath) throws Exception {
        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        BufferedImage image = ImageIO.read(bis);
        bis.close();

        File outputFolder = new File(outputPath).getParentFile();

        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }

        ImageIO.write(image, "png", new File(outputPath));
    }
}
