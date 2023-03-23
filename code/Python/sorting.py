import time

def selection_sort(arr, n):
    # print("Array before sorting:", arr)
    start = time.perf_counter()
    for i in range(n):
        minIndex = i
        for j, numJ in enumerate(arr[i+1:], start=i+1):
            if numJ < arr[minIndex]:
                minIndex = j

        arr[i], arr[minIndex] = arr[minIndex], arr[i]
                    
    end = time.perf_counter()
    # print("Array after sorting:", arr)
    print(f"Selection sort in Python took: {end - start:0.3f} seconds")

def read_file(filename):
    with open(filename, "r") as file:
        data = file.read().rstrip()
        file.close()
    
    return list(map(int, data.split(',')))

arr = read_file("/Users/abhigupta/Development/benchmarking/data/numbers.txt")
selection_sort(arr, len(arr))