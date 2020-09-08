import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        ladeDatei("levels.txt");
    }

    private static Map<Integer, Map<String, String>> ladeDatei(String datName) { 

        BufferedReader in = null;
        
        Map<Integer, Map<String, String>> allLevelsJSON = new HashMap<Integer, Map<String, String>>();
        Map<Integer, String> allLevelsString = new HashMap<Integer, String>();
        
        try { 
            in = new BufferedReader(new FileReader(datName)); 
            String zeile = null;
            int level = 0;
            StringBuilder builder = new StringBuilder();

            while ((zeile = in.readLine()) != null) {
                if (zeile.equals("") || zeile.equals("ende")) {
                    allLevelsString.put(level, builder.toString());
                    builder.delete(0, builder.length());
                    level++;
                } else {
                    String[] split = zeile.split("=");
                    builder.append(split[0]+":"+split[1]+"/");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try { 
                    in.close(); 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < allLevelsString.size(); i++) {
            String currentString = allLevelsString.get(i);
            Map<String, String> currentLevelJSON = new HashMap<String, String>();

            String[] allKeysAndVals = currentString.split("/");

            for (int j = 0; j < allKeysAndVals.length; j++) {
                String[] currentKeyAndVal = allKeysAndVals[j].split(":");
                currentLevelJSON.put(currentKeyAndVal[0], currentKeyAndVal[1]);
            }

            allLevelsJSON.put(i, currentLevelJSON);
        }

        return allLevelsJSON;
    }
}
