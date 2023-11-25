function getMinRotations(current, unlock) {

    let rotations = 0;
    let current_digit;
    let unlock_digit;

    while (current > 0 || unlock > 0) {

        current_digit = current % 10;
        unlock_digit = unlock % 10;

        let currentRotations = Math.abs(current_digit - unlock_digit);

        if (currentRotations > 5) {
            currentRotations = 10 - currentRotations;
        }

        current = Math.floor(current / 10);
        unlock = Math.floor(unlock / 10);
        rotations += currentRotations;
    }

    console.log(rotations);
}

getMinRotations(2345, 5432);
getMinRotations(1919, 0000);