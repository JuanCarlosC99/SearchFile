package Class;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;

public class Main {
    /*public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";*/

    public static void main(String[] args) {
        String direction = "/home/carlos/Desktop/SearchType";
        System.out.println("Search Folder  = " + direction );

        System.out.println("////Archivos .nes" );
        searsh(direction,true);
    }//Main closed

    /**
     * Realiza la busqueda en una direccion especifica de archivos dentro de una carpeta e
     * imprime lo encontrado en ella simpre y cuando sea un archivo
     * @param direction Direcion en la cual se realizara la busqueda
     * @param information Inormara  si la carpeta esta basia o no
     */
    public static void  searsh(String direction,boolean information){
        File carpeta = new File(direction);
        File[] archivos = carpeta.listFiles();
        FileFilter filtro = new FileFilter() {
            @Override
            public boolean accept(File arch) {
                if(arch.isDirectory()){
                    searsh(direction+"/"+arch.getName(),false);
                }
                return arch.isFile();
            }
        };
        archivos = carpeta.listFiles(filtro);
        String name="";
        if (archivos == null || archivos.length == 0&& information==true) {
            System.out.println("No hay elementos dentro de la carpeta actual");
        }//close if
        else {

            for (int i=0; i< archivos.length; i++) {
                File archivo = archivos[i];
                String accep=filterfile(archivo,".nes");
                if(accep.compareToIgnoreCase("0")!=0){
                    System.out.println(accep);
                }
            }//close for
        }//close else
    }//close search

    /**
     * Busca archivos con una determinada terminacion.
     * @param file Recibe un dato tipo File que sera analizado
     * @param tipe la terminacio con la que se desea buscar.
     *            Ejemplo
     *             ".nes"
     * @return regresa una valor de tipo string, en caso de que no se encuantre lo buscado retorna un "0"
     */
    public static  String filterfile(File file,String tipe){
        String nameFIle="";
        nameFIle =file.getName();

        if(nameFIle.substring(nameFIle.length()-tipe.length()).compareToIgnoreCase(tipe)!=0){
            nameFIle ="0";
        }
        return nameFIle;
    }//clse
}//Class closed
