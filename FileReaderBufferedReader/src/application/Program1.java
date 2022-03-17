package application;
import java.io.BufferedReader;
import java.io.FileReader;

/*
*Declaração automatica FileReader e BufferedReader (try-with-resources)
*
*/

public class Program1 {
    public static void main(String[] args) throws Exception {
        
        String path = "C:\\Users\\slbia\\OneDrive\\área de Trabalho\\JAVA\\ws-eclipse\\File\\dados.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (Exception e) {
            System.out.println("error: "+ e.getMessage());
        }
        
    }
}
