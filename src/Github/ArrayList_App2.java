package Github;

import java.util.ArrayList;

public class ArrayList_App2 {

    boolean nguyento(int x) {
        if (x < 2)
            return false;
        else {
            for (int i = 2; i <= Math.sqrt(x); i++)
                if (x % i == 0)
                    return false;

            return true;
        }
    }

    void lietke_nguyento(int n) {
        System.out.print("\n Cac so nguyen to <= " + n + ":");
        for (int i = 2; i <= n; i++)
            if (nguyento(i))
                System.out.print(i + " ");
    }

    void dem_cacsonguyento(int n) {
        int d = 0;
        for (int i = 2; i <= n; i++)
            if (nguyento(i))
                d++;
        System.out.println("\n So nguyen to tu 2 den " + n + " la: " + d);
    }

    void Eratosthene(int n) {
        ArrayList<Boolean> a = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            a.add(true);
        int p = 2;
        while (p <= Math.sqrt(n)) {
            if (a.get(p) == true) {
                int j = p + p;
                while (j <= n) {
                    a.set(j, false);
                    j = j + p;
                }
            }
            p = p + 1;
        }
        System.out.print("\n Danh sach cac so nguyen to <= " + n + ":\n");
        for (int i = 2; i <= n; i++)
            if (a.get(i))
                System.out.print(" " + i);
    }

    public static void main(String[] args) {
        ArrayList_App2 m = new ArrayList_App2();
        int n = 100;
        long startTime = System.currentTimeMillis();
        m.lietke_nguyento(n);
        System.out.print("\ntry programiz.pro");
        m.dem_cacsonguyento(n);
        m.Eratosthene(n);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        double executionTimeInSeconds = executionTime / 1000.0;
        System.out.println("\nThoi gian chay la: " + executionTimeInSeconds + " giay");
    }
}
