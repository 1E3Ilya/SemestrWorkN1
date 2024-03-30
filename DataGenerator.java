import java.io.*;
import java.util.Random;
import java.io.IOException;

public class DataGenerator {
    public static void main(String[] args) {
        generateDataFiles(50, 100, 10000);
    }

    public static void generateDataFiles(int numFiles, int minSize, int maxSize) {
        Random random = new Random();
        for (int i = 0; i < numFiles; i++) {
            int dataSize = random.nextInt(maxSize - minSize + 1) + minSize;
            int[] data = new int[dataSize];
            for (int j = 0; j < dataSize; j++) {
                data[j] = random.nextInt();
            }
            writeDataToFile("datas/data_" + i + ".txt", data);
        }
    }

    public static void writeDataToFile(String filename, int[] data) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (int i = 0; i < data.length; i++) {
                writer.write(data[i] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int[] readDataFromFile(String filename) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int count = 0;
        while (reader.readLine() != null) {
            count++;
        }
        int[] data = new int[count];
        reader.close();

        reader = new BufferedReader(new FileReader(filename));
        for (int i = 0; i < count; i++) {
            line = reader.readLine();
            data[i] = Integer.parseInt(line);
        }
        reader.close();

        return data;
    }
}

