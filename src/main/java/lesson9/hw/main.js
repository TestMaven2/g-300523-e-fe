let elOneFloor = randomInteger(0, 9);
let elTwoFloor = randomInteger(0, 9);
let passengerFloor = randomInteger(0, 9);


const elevatorOne = document.querySelector('.el-1 img');
const elevatorTwo = document.querySelector('.el-2 img');
const positionElevatorsBtn = document.querySelector('#elevators');
const getPassengerBtn = document.querySelector('#passenger');

// service function - get random integer
function randomInteger(min, max) {
    let rand = min + Math.random() * (max + 1 - min);
    return Math.floor(rand);
}

const moveElevator = (floor, elevator) => {
    const corrector = floor > 0 ? 20 : 0;
    elevator.style.transform = `translate(0px, calc(${floor*10}vh - ${corrector}px))`;
    elevator.style.transitionDuration = '3s, 5s, 3s, 5s';
}

const getPassenger = (floor) => {
    const oldPassenger = document.querySelector('.pass img');
    if (oldPassenger) {
        oldPassenger.remove()
    }
    const passenger = document.createElement('img');
    passenger.src = 'image/human.png';
    getPassengerBtn.after(passenger);
    passenger.style.top = `${floor*10}vh`;
    passenger.addEventListener('click', () => {
        if (Math.abs(passengerFloor - elOneFloor) < Math.abs(passengerFloor - elTwoFloor)) {
            moveElevator(passengerFloor, elevatorOne);
            elOneFloor = passengerFloor;
        } else {
            moveElevator(passengerFloor, elevatorTwo);
            elTwoFloor = passengerFloor;
        }
    });
}

moveElevator(elOneFloor, elevatorOne);
moveElevator(elTwoFloor, elevatorTwo);


getPassengerBtn.addEventListener('click', () => {
    passengerFloor = randomInteger(0, 9);
    getPassenger(passengerFloor);
});

positionElevatorsBtn.addEventListener('click', () => {
    elOneFloor = randomInteger(0, 9);
    elTwoFloor = randomInteger(0, 9);
    moveElevator(elOneFloor, elevatorOne);
    moveElevator(elTwoFloor, elevatorTwo);
});