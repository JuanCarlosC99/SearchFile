package Class;

import java.io.File;
import java.io.FileFilter;
public class SearchesFilter {
    /**
     * English
     * Allows perfom a file search whith key word(of its completion)
     * Español
     * Permite realizar una busqueda de archivos con palabras clave (de su terminación)
     * @param direction
     * Address where the search will be carried out
     * Direcion donde se realizara la busqueda     *
     * @param information
     * Show message if folder is empty
     * Mostrar mensaje si la carpeta esta vacia
     * @param searcheCode
     * Key word to search
     * Pablabra clave a buscar
     */
    public static void  searsh(String direction,boolean information,String searcheCode){
        try {
            File carpeta = new File(direction);
            if(carpeta.canRead()==false)
            {
                System.out.println("No access");
            }else{
                File[] archivos = carpeta.listFiles();
                FileFilter filtro = new FileFilter() {
                    @Override
                    public boolean accept(File arch) {
                        if (arch.isDirectory()) {
                            searsh(direction + "/" + arch.getName(), false, searcheCode);
                        }
                        return arch.isFile();
                    }
                };
                archivos = carpeta.listFiles(filtro);
                String name = "";
                if (archivos == null || archivos.length == 0 && information == true) {
                    System.out.println("No hay elementos dentro de la carpeta actual");
                }//close if
                else {
                    filterFile(archivos, searcheCode);
                }//close else
            }
        }catch (Exception e){
            System.out.println("No permission");
        }//close catch
    }//close search

    /**
     * English
     * Print the results of filtering the files that match the keyword of your completion
     * Español
     * Imprime los resusltados de filtrar los archivos que coincida con la parabra clave
     * de su terminacion
     * @param files
     * Receive an array of type File
     * Recibe un arreglo de tipo File
     * @param type
     * Keyword to filter
     * Palabra clave a filtrar
     */
    public static void filterFile(File files[],String type){
        try {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                String nameFIle = file.getName();
                int searchLength = type.length();
                int nameLength = nameFIle.length();
                String subName = nameFIle.substring(nameLength - searchLength);
                if (subName.compareToIgnoreCase(type) == 0) {
                    System.out.println(nameFIle);
                }
            }//close for
        }catch (Exception e){
            System.out.println("no permission");
        }
    }//close filterFile

    /**
     * English
     * Español
     * Imprime la busqueda de archivos con una palabra clave, esta puede ser desde el inicio del nombre
     * o desde el final la busqueda
     * @param files
     * Receive an array of type File
     * Recibe un arreglo de tipo File
     * @param type
     * Keyword to filter
     * Palabra clave a filtrar
     * @param position
     * The search starts with the first characters or with the last to be compared
     * La busqueda inicia con los primeros caracteres o con los ultimos a comparar 
     */

    public static void filterFile(File files[],String type,boolean position){
        String subName="";
        try {
            for (int i=0; i< files.length; i++) {
                File file = files[i];
                String nameFIle=file.getName();
                int searchLength=type.length();
                int nameLength=nameFIle.length();
                int stringlength=nameLength-searchLength;
                if(stringlength>0) {
                    if (position) {
                        subName = nameFIle.substring(0, searchLength);
                    } else {
                        subName = nameFIle.substring(nameLength - searchLength);
                    }
                    if (subName.compareToIgnoreCase(type) == 0) {
                        System.out.println(nameFIle);
                    }
                }//if length
            }//close for
        }catch (Exception e){
            System.out.println("no permission*");
        }
    }//close filterFile
}//close SearchFilter
