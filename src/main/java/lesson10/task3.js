function fast_and_slow_frog(array) {

    debugger;
    let slow = 0;
    let fast = 0;

    while(fast != undefined) {

        fast = array[fast];

        if (fast === slow) {
            console.log('В массиве есть петля!');
            return;
        }

        fast = array[fast];

        if (fast === slow) {
            console.log('В массиве есть петля!');
            return;
        }

        slow = array[slow];
    }

    console.log('В массиве нет петли!');
}

let array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 2];
fast_and_slow_frog(array);