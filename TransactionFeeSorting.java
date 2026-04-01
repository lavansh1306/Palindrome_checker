// Problem 1: Transaction Fee Sorting for Audit Compliance
// Goal: Sort banking transactions by fee amount for compliance reviews.
// Key Concepts: Bubble Sort (adjacent swaps, early termination),
//               Insertion Sort (shift operations, composite key),
//               Stability, Time Complexity O(n²), High-fee outlier detection.

import java.util.ArrayList;

public class TransactionFeeSorting {

    private static final double HIGH_FEE_THRESHOLD = 50.0;

    static class Transaction {
        String id;
        double fee;
        String timestamp;
        int timestampMinutes; // pre-parsed for efficient numeric comparison

        Transaction(String id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
            String[] parts = timestamp.split(":");
            this.timestampMinutes = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }

        @Override
        public String toString() {
            return id + ":" + fee + "@" + timestamp;
        }
    }

    // Bubble Sort by fee ascending — for small batches (n <= 100).
    // Returns [passes, swaps] for performance reporting.
    static int[] bubbleSort(ArrayList<Transaction> list) {
        int n = list.size();
        int passes = 0, swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swaps++;
                    swapped = true;
                }
            }
            passes++;
            if (!swapped) break; // early termination when already sorted
        }
        return new int[]{passes, swaps};
    }

    // Insertion Sort by fee (primary) + timestamp (secondary) — for medium batches (100–1,000).
    // Stable: equal-fee transactions retain their original timestamp order.
    static void insertionSort(ArrayList<Transaction> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Transaction key = list.get(i);
            int j = i - 1;
            while (j >= 0 && (Double.compare(list.get(j).fee, key.fee) > 0
                    || (Double.compare(list.get(j).fee, key.fee) == 0
                        && list.get(j).timestampMinutes > key.timestampMinutes))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    // Flag transactions with fee > $50 as high-fee outliers.
    static ArrayList<Transaction> flagOutliers(ArrayList<Transaction> list) {
        ArrayList<Transaction> outliers = new ArrayList<>();
        for (Transaction t : list) {
            if (t.fee > HIGH_FEE_THRESHOLD) {
                outliers.add(t);
            }
        }
        return outliers;
    }

    public static void main(String[] args) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("id1", 10.5,  "10:00"));
        transactions.add(new Transaction("id2", 25.0,  "09:30"));
        transactions.add(new Transaction("id3",  5.0,  "10:15"));

        System.out.println("Input transactions:");
        for (Transaction t : transactions) {
            System.out.println("  " + t.id + ", fee=" + t.fee + ", ts=" + t.timestamp);
        }

        // --- Bubble Sort (small batch demo) ---
        ArrayList<Transaction> bubbleList = new ArrayList<>(transactions);
        int[] stats = bubbleSort(bubbleList);
        System.out.print("BubbleSort (fees): [");
        for (int i = 0; i < bubbleList.size(); i++) {
            System.out.print(bubbleList.get(i).id + ":" + bubbleList.get(i).fee);
            if (i < bubbleList.size() - 1) System.out.print(", ");
        }
        System.out.println("] // " + stats[0] + " passes, " + stats[1] + " swaps");

        // --- Insertion Sort (medium batch demo) ---
        ArrayList<Transaction> insertionList = new ArrayList<>(transactions);
        insertionSort(insertionList);
        System.out.print("InsertionSort (fee+ts): [");
        for (int i = 0; i < insertionList.size(); i++) {
            System.out.print(insertionList.get(i).id + ":"
                    + insertionList.get(i).fee + "@" + insertionList.get(i).timestamp);
            if (i < insertionList.size() - 1) System.out.print(", ");
        }
        System.out.println("]");

        // --- High-fee outlier detection ---
        ArrayList<Transaction> outliers = flagOutliers(bubbleList);
        if (outliers.isEmpty()) {
            System.out.println("High-fee outliers (> $50): none");
        } else {
            System.out.print("High-fee outliers (> $50): [");
            for (int i = 0; i < outliers.size(); i++) {
                System.out.print(outliers.get(i).id + ":" + outliers.get(i).fee);
                if (i < outliers.size() - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        // --- Outlier demo with a high-fee transaction ---
        System.out.println("\n-- Outlier demo (adding id4, fee=75.0) --");
        ArrayList<Transaction> withOutlier = new ArrayList<>(transactions);
        withOutlier.add(new Transaction("id4", 75.0, "11:00"));
        bubbleSort(withOutlier);
        ArrayList<Transaction> demoOutliers = flagOutliers(withOutlier);
        System.out.print("High-fee outliers (> $50): [");
        for (int i = 0; i < demoOutliers.size(); i++) {
            System.out.print(demoOutliers.get(i).id + ":" + demoOutliers.get(i).fee);
            if (i < demoOutliers.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
