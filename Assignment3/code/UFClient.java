package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UFClient {
    public UFClient() {
    }

    public int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n, false);
        int count = 0; // The number of connection
        int a, b; // Random pairs of integers between 0 and n-1
        while (uf.components() > 1) {
            a = getRandomNum(n);
            b = getRandomNum(n);
            uf.connect(a, b);
            count++;
        }
        return count;
    }

    private int getRandomNum(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }
    private static int getInputNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter n: ");

        //exception for no Num in
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter Integer! ");
            System.out.println("Please enter n: ");
            scanner = new Scanner(System.in);
        }
        int n = scanner.nextInt();
        scanner.close();
        return n;
    }

    private static int getMeanTime(int num){
        UFClient ufclient = new UFClient();
        int total = 0;
        int time = 100;
        for (int i = 0; i < time; i++) {
            total += ufclient.count(num);
        }
        return total/time;
    }

    public static void main(String[] args) {
        // Runs the experiment for a fixed set of n values
        System.out.println("number," + " connections number," + " 1/2Nln(N)");
        for(int i = 50; i <= 5000; i += 50){
            int meanTime = getMeanTime(i);
            System.out.println(i + "    " + meanTime + "    " + 0.5 * i * Math.log(i));
        }
    }

}
