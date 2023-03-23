<?php

function printArray($arr) 
{
    foreach ($arr as $a) {
        print "$a ";
    }
    print "\n";
}

function selectionSort($arr, $n)
{
    // print "Array before sorting: ";
    // printArray($arr);

    $startTime = microtime(true);

    for($i = 0; $i < $n; $i++) {
        $minIndex = $i;
        for($j = $i; $j < $n; $j++) {
            if ($arr[$j] < $arr[$minIndex]) {
                $minIndex = $j;
            }
        }
        $temp = $arr[$i];
        $arr[$i] = $arr[$minIndex];
        $arr[$minIndex] = $temp;
    }

    $execution_time = round((microtime(true) - $startTime), 3);

    // print "Array after sorting: ";
    // printArray($arr);
    print "Selection sort in PHP took: $execution_time seconds\n";
}

function readFileIntoArray($filename, &$arr)
{
    $myfile = fopen($filename, "r");
    $arr = explode(",", fread($myfile, filesize($filename)));
    fclose($myfile);
}


$arr = [];
readFileIntoArray("/Users/abhigupta/Development/benchmarking/data/numbers.txt", $arr);
selectionSort($arr, 10000);

?>