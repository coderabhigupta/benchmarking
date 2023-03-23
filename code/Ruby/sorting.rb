def selection_sort(arr, n)
    # print("Array before sorting: #{arr}\n")
    start_at = Time.now
    arr.each_index do |i|
        min_index = i
        k = i + 1
        arr[k..-1].each_index do |j|
            min_index = j+k if arr[j+k] < arr[min_index]
        end
        arr[i], arr[min_index] = arr[min_index], arr[i]
    end
    end_at = Time.now
    execution_time = (end_at - start_at).round(3)
    # print("Array after sorting: #{arr}\n")
    puts("Selection sort in Ruby took: #{execution_time} seconds")
end

def read_file(filename)
    data = File.read(filename)
    return data.split(',').map(&:to_i)
end

arr = read_file("/Users/abhigupta/Development/benchmarking/data/numbers.txt")
selection_sort(arr, arr.count)