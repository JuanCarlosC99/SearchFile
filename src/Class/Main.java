package Class;
import SearchesFilter.*;
public class Main {
   // public static final String  direction = "/root";
    public static final String  direction = "/home/carlos/Desktop/SearchType";
    public static void main(String[] args) {
        System.out.println("Search Folder  = " + direction );
        System.out.println("---Files [.nes]----" );
        SearchesFilter.searsh(direction,true,".nes");
    }//Main closed
}//Class closed
