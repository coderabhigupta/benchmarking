import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    static void selectionSort(int[] arr, int n) {
        // System.out.println("Array before sorting: ");
        // printArray(arr);
        
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < n; ++i) {
            int minIndex = i;
            for(int j = i; j < n; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        long endTime = System.currentTimeMillis();
        float elapsedTime = (endTime - startTime) / 1000F;

        // System.out.println("Array after sorting: ");
        // printArray(arr);

        System.out.println("Selection sort in Java took: " + elapsedTime + " seconds");
    }

    private static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    static void readFile(String filename, int[] arr) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            String[] numbers = line.split(", ");
            for(int i = 0; i < numbers.length; ++i) {
                arr[i] = Integer.parseInt(numbers[i]);
            }
            reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        int[] arr = new int[10000];
        readFile("/Users/abhigupta/Development/benchmarking/data/numbers.txt", arr);
        selectionSort(arr, arr.length);
    }
}