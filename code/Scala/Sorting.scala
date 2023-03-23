import scala.compiletime.ops.string
import scala.io.Source

object Sorting {
    def selectionSort(arr: Array[Int], n: Int) = {
        // println("Array before sorting: ");
        // printArray(arr);
        
        val startTime = System.currentTimeMillis();

        for (i <- 0 until n) {
            var minIndex = i;
            for(j <- i until n if arr(j) < arr(minIndex)) minIndex = j
            val temp = arr(i);
            arr(i) = arr(minIndex);
            arr(minIndex) = temp;
        }

        val endTime = System.currentTimeMillis();
        val elapsedTime = (endTime - startTime) / 1000F;

        // println("Array after sorting: ");
        // printArray(arr);

        println("Selection sort in Scala took: " + elapsedTime + " seconds");
    }

    def printArray(arr: Array[Int]) = {
        for(a <- arr) print(s"$a ")
    }

    def readFile(filename: String, arr: Array[Int]) = {
        val bufferedSource = Source.fromFile(filename);
        val numbers: Array[String] = bufferedSource.getLines.mkString.split(", ");
        bufferedSource.close;
        for(i <- 0 until numbers.length) arr(i) = numbers(i).toInt
    }

    def main(args: Array[String]) = {
        var arr = new Array[Int](10000);
        readFile("/Users/abhigupta/Development/benchmarking/data/numbers.txt", arr);
        selectionSort(arr, arr.length);
    }
}