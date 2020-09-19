/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incidencia06;

import java.io.File;

/**
 *
 * @author Elio
 */
public class Incidencia06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String carpAct = System.getProperty("user.dir");
        File carpeta = new File(carpAct);
        
        carpActual(carpeta, carpAct);     
    }

    public static void carpActual(File c, String carpAct) {
        c = new File(carpAct);
        File nameFiles[] = c.listFiles();
        for (int i = 0; i < nameFiles.length; i++) {
            if (nameFiles[i].isDirectory()) {
                carpActual(nameFiles[i],carpAct + "\\" + nameFiles[i].getName());
                try {
                    if (Integer.parseInt(nameFiles[i].getName()) < 2010) {
                        File anio = new File(nameFiles[i].getPath());
                        File alum[] = anio.listFiles();
                        for (int j = 0; j < alum.length; j++) {
                            if (alum[j].isDirectory()) {
                                File newName = new File(alum[j].getParent() + "\\" + "0" + alum[j].getName());
                                alum[j].renameTo(newName);
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                       
                }      
            }
        }
    }

}
