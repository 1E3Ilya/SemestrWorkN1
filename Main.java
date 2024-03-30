import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("result.txt");
        writer.write("countOfNum countOfIterations time\n");
        for (int i = 0; i < 50; i++) {
            int[] array = DataGenerator.readDataFromFile("C:/SemestrWorkN1/datas/data_" + i + ".txt");
            long start = System.nanoTime();
            Introsort.sort(array);
            writer.write(array.length + " " + Introsort.count + " " + (System.nanoTime() - start) / 5  +  "\n");
        }
        writer.close();
    }
}
