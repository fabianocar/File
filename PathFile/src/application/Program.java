package application;
import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a folder path: ");
        
        String strPath = sc.nextLine();
        
        File path = new File(strPath);
        
        System.out.println(path.getName());
        System.out.println(path.getParent());
        System.out.println(path.getPath());
        System.out.println(path.getTotalSpace());
        System.out.println(path.getUsableSpace());
        System.out.println(path.getFreeSpace());
        
        sc.close();
        
    }
}
