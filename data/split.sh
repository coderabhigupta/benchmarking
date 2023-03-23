#!/bin/bash
#
# Script to split a string based on the delimiter

IFS=',' read -ra my_array <<< "$my_string"

#Print the split string
for i in "${my_array[@]}"
do
    echo $i
done
