import comparators.NumComparator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {

        Scanner sc = null;
        Map<Integer, Integer> numLen = new HashMap<>();

        try {
            sc = new Scanner(new FileReader(Constants.FILE_PATH));

            while (sc.hasNext()) {
                String str = sc.nextLine();
                String[] points = str.split(Constants.REGEX);

                float x1 = Float.parseFloat(points[Constants.X1]);
                float y1 = Float.parseFloat(points[Constants.Y1]);
                float x2 = Float.parseFloat(points[Constants.X2]);
                float y2 = Float.parseFloat(points[Constants.Y2]);

                int len = (int) Math.round(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));

                int num = numLen.containsKey(len) ? numLen.get(len) : 0;
                numLen.put(len, num + 1);

            }
            ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry: numLen.entrySet()) {
                list.add(entry);
            }
            Collections.sort(list, new NumComparator());

            for (Map.Entry<Integer, Integer> entry: list) {
                System.out.println(entry.getKey() + ";" + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.err.println(Constants.ERROR_FILE_FOUND);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }
}