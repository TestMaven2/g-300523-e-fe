function twoPointers(array, target) {

    debugger;
    let left = 0;
    let right = array.length - 1;

    while(left < right) {
        let sum = array[left] + array[right];

        if (sum === target) {
            console.log([array[left], array[right]]);
            return;
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

    console.log('Решение не найдено');
}

let array = [1, 3, 5, 6, 7, 9, 12, 13, 16, 18, 20];
let target = 20;
twoPointers(array, target);