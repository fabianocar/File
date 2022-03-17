package application;
import java.io.BufferedReader;
import java.io.FileReader;

/*
*Declaração Manual FileReader e BufferedReader
*
*/

public class Program {
    public static void main(String[] args) throws Exception {
        
        String path = "C:\\Users\\slbia\\OneDrive\\Área de Trabalho\\JAVA\\ws-eclipse\\File\\dados.txt";
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("error: "+ e.getMessage());
        }
        finally{
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
