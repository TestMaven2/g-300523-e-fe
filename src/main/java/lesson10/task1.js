function max_sum_of_subarray(k, array) {
    debugger;
    let maxSum = 0;
    let windowSum = 0;
    let start = 0;

    for (let end = 0; end < array.length; end++) {
        windowSum += array[end];
        if (end >= k - 1) {
            maxSum = Math.max(maxSum, windowSum);
            windowSum -= array[start];
            start++;
        }
    }
    console.log(maxSum);
}

let array = [1, 45, 2, 10, 23, 3, 1, 0, 20];
let k = 4;
max_sum_of_subarray(k, array);