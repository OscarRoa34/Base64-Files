package co.edu.uptc.Services;

import java.io.File;

public class DirectoryPermissionServices {

    public void directoryCheck() {
        String directoryPath = "resources";
        File directory = new File(directoryPath);
        if (directory.exists()) {
            System.out.println("Existe la carpeta");
            if (directory.canWrite()) {
                System.out.println("Existen permisos");
            } else {
                System.out.println("No existen permisos");
            }
        } else {
            System.out.println("No existe la carpeta");
        }
    }
}
