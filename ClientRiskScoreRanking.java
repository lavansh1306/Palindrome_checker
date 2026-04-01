// Problem 2: Client Risk Score Ranking
// Goal: Sort client risk scores for priority review by the risk management team.
// Key Concepts: Bubble Sort (in-place, swap visualisation),
//               Insertion Sort (adaptive, nearly-sorted data),
//               Space Complexity O(1), Top-N extraction.

public class ClientRiskScoreRanking {

    static class Client {
        String name;
        double riskScore;
        double accountBalance;

        Client(String name, double riskScore, double accountBalance) {
            this.name = name;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }

        @Override
        public String toString() {
            return name + "(risk=" + riskScore + ", bal=" + accountBalance + ")";
        }
    }

    // Bubble Sort by riskScore ascending — visualises each swap for demos.
    static void bubbleSort(Client[] clients) {
        int n = clients.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (Double.compare(clients[j].riskScore, clients[j + 1].riskScore) > 0) {
                    System.out.println("  Swap: " + clients[j].name
                            + " (risk=" + clients[j].riskScore + ") <-> "
                            + clients[j + 1].name
                            + " (risk=" + clients[j + 1].riskScore + ")");
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // early termination
        }
    }

    // Insertion Sort by riskScore DESC (primary) + accountBalance ASC (secondary).
    // Excels on nearly-sorted data; stable for equal risk scores.
    static void insertionSort(Client[] clients) {
        int n = clients.length;
        for (int i = 1; i < n; i++) {
            Client key = clients[i];
            int j = i - 1;
            while (j >= 0 && (Double.compare(clients[j].riskScore, key.riskScore) < 0
                    || (Double.compare(clients[j].riskScore, key.riskScore) == 0
                        && Double.compare(clients[j].accountBalance, key.accountBalance) > 0))) {
                clients[j + 1] = clients[j];
                j--;
            }
            clients[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Client[] clients = {
            new Client("Alice",    72.5, 15000.0),
            new Client("Bob",      45.0, 32000.0),
            new Client("Charlie",  88.0,  8500.0),
            new Client("Diana",    63.5, 22000.0),
            new Client("Eve",      91.0,  5000.0),
            new Client("Frank",    55.5, 18000.0),
            new Client("Grace",    78.0, 11000.0),
            new Client("Hank",     39.0, 40000.0),
            new Client("Iris",     82.5, 13000.0),
            new Client("Jack",     60.0, 25000.0),
            new Client("Karen",    95.0,  3000.0),
            new Client("Leo",      47.5, 35000.0)
        };

        // --- Bubble Sort: riskScore ascending (with swap visualisation) ---
        System.out.println("=== Bubble Sort: riskScore Ascending ===");
        System.out.println("Swaps performed:");
        Client[] bubbleClients = clients.clone();
        bubbleSort(bubbleClients);
        System.out.println("Sorted order:");
        for (Client c : bubbleClients) {
            System.out.println("  " + c);
        }

        // --- Insertion Sort: riskScore DESC + accountBalance ASC ---
        System.out.println("\n=== Insertion Sort: riskScore DESC + accountBalance ASC ===");
        Client[] insertionClients = clients.clone();
        insertionSort(insertionClients);
        System.out.println("Sorted order:");
        for (Client c : insertionClients) {
            System.out.println("  " + c);
        }

        // --- Top 10 highest-risk clients (from DESC-sorted array) ---
        System.out.println("\n=== Top 10 Highest Risk Clients ===");
        int limit = Math.min(10, insertionClients.length);
        for (int i = 0; i < limit; i++) {
            System.out.println("  " + (i + 1) + ". " + insertionClients[i]);
        }
    }
}
