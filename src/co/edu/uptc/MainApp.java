package co.edu.uptc;

import java.nio.file.Files;
import java.nio.file.Paths;
import co.edu.uptc.Models.Base64ImageModel;
import co.edu.uptc.Models.Base64TextModel;

public class MainApp {

    public static void main(String[] args) {

        // DirectoryPermissionServices dps = new DirectoryPermissionServices();
        // dps.directoryCheck();

        try {
            String base64ImageFilePath = "src\\co\\edu\\uptc\\Data\\imagenBase64.txt";
            String base64TextFilePath = "src\\co\\edu\\uptc\\Data\\people64.txt";

            String outputPathImage = "src\\co\\edu\\uptc\\Data\\Imagen_Guardada.png";
            String outputPathText = "src\\co\\edu\\uptc\\Data\\Texto_guardado.txt";

            String base64image = new String(Files.readAllBytes(Paths.get(base64ImageFilePath)));

            String base64text = new String(Files.readAllBytes(Paths.get(base64TextFilePath)));

            Base64ImageModel image = new Base64ImageModel();
            Base64TextModel text = new Base64TextModel();

            image.processBase64File(base64image, outputPathImage);
            text.processBase64File(base64text, outputPathText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}