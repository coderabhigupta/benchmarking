const { start } = require('repl');

function selectionSort(arr, n)
{
    // console.log("Array before sorting: #{arr}")
    // printArray(arr, n);
    var startTime, endTime;

    startTime = new Date();

    var i, j, minIndex;
    for(i = 0; i < n; i++) {
        minIndex = i;
        for(j = i; j < n; ++j) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    endTime = new Date();
    var execution_time = ((endTime - startTime)/1000).toFixed(3);

    // console.log("Array after sorting: #{arr}")
    // printArray(arr, n);
    console.log("Selection sort in JavaScript took: " + execution_time + " seconds")
}

function readFile(filename)
{
    var fs = require('fs');
    data = fs.readFileSync(filename).toString().split(',');
    return data.map(function (x) { 
        return parseInt(x, 10); 
    });
}

function printArray(arr) 
{
    for(i = 0; i < arr.length; ++i) {
        process.stdout.write(arr[i] + " ");
    }
    console.log();
}

arr = readFile("/Users/abhigupta/Development/benchmarking/data/numbers.txt")
selectionSort(arr, arr.length)