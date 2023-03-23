using System;

public class Sorting {
    static void selectionSort(int[] arr, int n) {
        // Console.WriteLine("Array before sorting: ");
        // printArray(arr);
        
        var watch = new System.Diagnostics.Stopwatch();
        
        watch.Start();

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

        watch.Stop();

        decimal elapsedTime = ((decimal) watch.ElapsedMilliseconds) / 1000;

        // Console.WriteLine("Array after sorting: ");
        // printArray(arr);

        Console.WriteLine("Selection sort in C# took: " + elapsedTime + " seconds");
    }

    static void printArray(int []arr) {
        for(int i = 0; i < arr.Length; ++i) {
            Console.WriteLine(arr[i] + " ");
        }
    }

    static void readFile(string filename, int []arr) {
        string text = System.IO.File.ReadAllText(filename);
        var numbers = text.Split(',')?.Select(Int32.Parse)?.ToList();
        if (numbers is not null) {
            for(int i = 0; i < numbers.Count; ++i) {
                arr[i] = numbers[i];
            }
        }
    }

    static void Main(string[] args) {
        int []arr = new int[10000];
        Sorting.readFile("/Users/abhigupta/Development/benchmarking/data/numbers.txt", arr);
        Sorting.selectionSort(arr, arr.Length);
    }
}
