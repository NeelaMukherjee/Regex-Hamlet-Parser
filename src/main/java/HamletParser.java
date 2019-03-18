import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser() {
        this.hamletData = loadFile();
    }

    private String loadFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData() {
        return hamletData;
    }

    public void changeHamletToLeon() {
        hamletData = findAndReplace("Hamlet", "Leon", hamletData);
        hamletData = findAndReplace("HAMLET", "LEON", hamletData);

    }

    public void changeHoratioToTariq() {
        hamletData = findAndReplace("Horatio", "Tariq", hamletData);
        hamletData = findAndReplace("HORATIO", "TARIQ", hamletData);

    }

    public String findAndReplace(String toBeReplaced, String replacedWith, String file) {

        Pattern pattern = Pattern.compile(toBeReplaced);
        Matcher matcher = pattern.matcher(file);
        return matcher.replaceAll(replacedWith);
    }

    public boolean findHamlet(String file) {

        Pattern pattern1 = Pattern.compile("Hamlet");

        return (pattern1.matcher(file).find());

    }

    public boolean findHoratio(String file) {
        Pattern pattern1 = Pattern.compile("Horatio");

        return (pattern1.matcher(file).find());

    }

}
