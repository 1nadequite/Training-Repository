import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.NumLen;
import by.gsu.epamlab.comparators.NumComparator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class RunnerTreeSet2 {
    public static void main(String[] args) {

        Scanner sc = null;
        ArrayList<String> str_list = new ArrayList<>();
        try {
            sc = new Scanner(new FileReader(Constants.FILE_PATH));

            while (sc.hasNext()) {
                String str = sc.nextLine();
                str_list.add(str);
            }

        } catch (FileNotFoundException e) {
            System.err.println(Constants.ERROR_FILE_FOUND);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        long start = System.currentTimeMillis();
        NumLen numLen, floorNumLen;
        NavigableSet<NumLen> sortedSetNumLen = new TreeSet<>();

        for (String str : str_list) {
            String[] points = str.split(Constants.REGEX);

            float x1 = Float.parseFloat(points[Constants.X1]);
            float y1 = Float.parseFloat(points[Constants.Y1]);
            float x2 = Float.parseFloat(points[Constants.X2]);
            float y2 = Float.parseFloat(points[Constants.Y2]);

            int len = (int)Math.round(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));

            numLen = new NumLen(len);

            floorNumLen = sortedSetNumLen.floor(numLen);
            if(floorNumLen == null || floorNumLen.getLen() != numLen.getLen()) {
                sortedSetNumLen.add(numLen);
            } else {
                floorNumLen.increaseNum();
            }
        }
        ArrayList<NumLen> list = new ArrayList<>();
        for (NumLen n: sortedSetNumLen) {
            list.add(n);
        }

        Collections.sort(list, new NumComparator());

        /*for (NumLen d: list) {
            System.out.println(d);
        }*/

        long time = System.currentTimeMillis() - start;
        System.out.println("time: " + time);

    }
}