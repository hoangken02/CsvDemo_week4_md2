import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvWrite {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,name,age";

    public static void main(String[] args) {
        String fileName = "C:/CodeGym/module2/lesson/CSV/peoples.csv";
        writeCsvFile(fileName);
    }

    public static void writeCsvFile(String fileName){
        People people1 = new People(1,"ken",18);
        People people2 = new People(1,"ken",18);
        People people3 = new People(2,"boom",30);

        List<People> peoples = new ArrayList<>();
        peoples.add(people1);
        peoples.add(people2);
        peoples.add(people3);

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (People people :
                 peoples) {
                fileWriter.append(String.valueOf(people.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(people.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(people.getName());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
