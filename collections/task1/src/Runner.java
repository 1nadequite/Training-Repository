import by.gsu.epamlab.Constants;
import by.gsu.epamlab.WeekDay;
import by.gsu.epamlab.beans.*;
import by.gsu.epamlab.factories.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class Runner {
    private static <K, V> void printMap(Map<K, V> map, String title) {
        System.out.println(title);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    private static <K, V> void searchItem(Map<K, V> map, K key, String title) {
        V value = map.get(key);
        System.out.printf("%s for %s %s\n", title, key, (value != null) ?
                Constants.ITEM_FOUND + value : Constants.ITEM_NOT_FOUND);
    }

    private static void removeEntries(Map<Purchase, WeekDay> map, EntryChecker checker) {
        for(Iterator<Map.Entry<Purchase, WeekDay>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Purchase, WeekDay> entry = it.next();
            if (checker.check(entry)) {
                it.remove();
            }
        }
    }

    private static Byn getTotalCost(List<? extends Purchase> purchases) {
        Byn totalCost = new Byn();
        for (Purchase purchase : purchases) {
            totalCost.add(purchase.getCost());
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader(Constants.FILE_PATH));

            Map<Purchase, WeekDay> firstPurchaseOfWeek = new HashMap<>();
            Map<Purchase, WeekDay> lastPurchaseOfWeek = new HashMap<>();
            List<PricePurchase> listOfPricePurchases = new ArrayList<>();
            EnumMap<WeekDay, List<Purchase>> weekDayPurchases = new EnumMap<>(WeekDay.class);

            while (sc.hasNext()) {
                Purchase purchase = PurchasesFactory.getClassFromFactory(sc.nextLine());
                WeekDay weekDay = WeekDay.valueOf(sc.nextLine());

                lastPurchaseOfWeek.put(purchase, weekDay);

                if (!firstPurchaseOfWeek.containsKey(purchase)) {
                    firstPurchaseOfWeek.put(purchase, weekDay);
                }

                if (purchase instanceof PricePurchase) {
                    listOfPricePurchases.add((PricePurchase) purchase);
                }

                List<Purchase> purchasesOfDay = weekDayPurchases.get(weekDay);
                if (purchasesOfDay == null)
                    weekDayPurchases.put(weekDay, purchasesOfDay = new ArrayList<>());
                purchasesOfDay.add(purchase);
            }

            printMap(firstPurchaseOfWeek, "First purchase map");

            printMap(lastPurchaseOfWeek, "Last purchase map");

            final Purchase BREAD1 = new Purchase("bread", 155, 0);
            searchItem(firstPurchaseOfWeek, BREAD1, "the first week day");
            searchItem(lastPurchaseOfWeek, BREAD1, "the last week day");

            final Purchase BREAD2 = new Purchase("bread", 170, 0);
            searchItem(firstPurchaseOfWeek, BREAD2, "the first week day");
            System.out.println();

            final EntryChecker checker1 = new EntryCheckerPurchaseAndWeekDay<>(new Purchase("meat"));
            removeEntries(lastPurchaseOfWeek, checker1);
            final EntryChecker checker2 = new EntryCheckerPurchaseAndWeekDay<>(WeekDay.MONDAY);
            removeEntries(firstPurchaseOfWeek, checker2);

            // possible tests for remove
            final EntryChecker checker3 = new EntryCheckerPurchaseAndWeekDay<>(191);
            removeEntries(lastPurchaseOfWeek, checker3);
            final EntryChecker checker4 = new EntryCheckerPurchaseAndWeekDay<>(new Purchase("butter"), WeekDay.SUNDAY, 0);
            removeEntries(firstPurchaseOfWeek, checker4);
            final EntryChecker checker5 = new EntryCheckerPurchaseAndWeekDay<>(new Purchase("bread"), null, 462);
            removeEntries(firstPurchaseOfWeek, checker5);
            final EntryChecker checker6 = new EntryCheckerPurchaseAndWeekDay<>(new PricePurchase(null, 0, 0, 10), WeekDay.MONDAY, 0);
            removeEntries(lastPurchaseOfWeek, checker6);

            printMap(firstPurchaseOfWeek, "First purchase map");

            printMap(lastPurchaseOfWeek, "Last purchase map");

            System.out.printf("total cost of all price purchases is %s\n", getTotalCost(listOfPricePurchases));

            System.out.println();
            printMap(weekDayPurchases, "Enumerated map");

            for (WeekDay weekDay : weekDayPurchases.keySet()) {
                List<Purchase> listForOneDay = weekDayPurchases.get(weekDay);
                System.out.printf("total cost of all purchases on %s is %s\n", weekDay, getTotalCost(listForOneDay));
            }
            System.out.println();

            searchItem(weekDayPurchases, WeekDay.MONDAY, "list of all purchases");

        } catch (FileNotFoundException e) {
            System.err.println(Constants.ERROR_FILE_FOUND);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}