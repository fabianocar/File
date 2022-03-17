package application;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Program {
    public static void main(String[] args) throws Exception {
        
        String [] lines = new String[] {"Good Morning", "Good Afternoon", "Good Night"};

        String path = "C:\\Users\\slbia\\OneDrive\\área de Trabalho\\JAVA\\ws-eclipse\\File\\dadosaida.txt";

        //try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) { Arquivo novo sempre
        //mesmo arquivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) { 
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
