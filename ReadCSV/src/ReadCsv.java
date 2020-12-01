import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {
    private static final String COMMA_DELIMITER = ",";

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    private static void printContry(List<String> country) {
        System.out.println(
                "Country [id= "
                        + country.get(0)
                        + ", code= " + country.get(1)
                        + " , name=" + country.get(2)
                        + "]");
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader("C:\\CodeGym\\module2\\lesson\\CSV\\peoples.csv"));
            while ((line = bufferedReader.readLine()) != null) {
                printContry(parseCsvLine(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
                try {
                    if (bufferedReader != null){
                        bufferedReader.close();
                    }
                }catch (IOException crunchifyException){
                    crunchifyException.printStackTrace();
                }
        }
    }
}

