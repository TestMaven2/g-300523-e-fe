// service function - get random integer
function randomInteger(min, max) {
    let rand = min + Math.random() * (max + 1 - min);
    return Math.floor(rand);
}

// service function - get application cost
function getApplicationCost(startTime, endTime) {
    let cheapTime = 0;
    let expensiveTime = 0;
    if (startTime < 13) {
        cheapTime = 13 - startTime;
    }
    if (endTime >= 13) {
        expensiveTime = endTime - 13;
    }
    return cheapTime > expensiveTime ? 1 : 2;
}

// timetable visualization
const arrOfHours = [];
let hours = document.querySelector('.hours');
for (let i = 9; i <= 17; i++) {
    const newSpanEl = document.createElement('span');
    newSpanEl.innerText = `${i}:00`;
    arrOfHours.push(newSpanEl);
    hours.append(...arrOfHours);
}

// making array of random events
let arrOfEvents = [];

const getArratOfEventsApplications = () => {
    for (let i = 0; i < 12; i++) {
        const newEvent = {};
        newEvent.startTime = randomInteger(9, 17);
        newEvent.endTime = randomInteger(newEvent.startTime, 17);
        if (newEvent.endTime === newEvent.startTime) {
            newEvent.endTime = newEvent.endTime + 1;
        }
        if (newEvent.endTime > 17) {
            newEvent.endTime = newEvent.endTime - 1;
            newEvent.startTime = newEvent.startTime - 1;
        }
        newEvent.cost = getApplicationCost(newEvent.startTime, newEvent.endTime);
        newEvent.description = `C ${newEvent.startTime}:00 до ${newEvent.endTime}:00 / ${newEvent.cost} евро`;
        arrOfEvents.push(newEvent);
    }
    arrOfEvents = arrOfEvents.map(event => JSON.stringify(event));
    arrOfEvents = [...new Set(arrOfEvents)];
    arrOfEvents = arrOfEvents.map(event => JSON.parse(event));
}


//visualization of random events
const renderEventsApplications = () => {
    arrOfEvents = [];
    getArratOfEventsApplications();
    const eventsContainer = document.querySelector('.events');
    eventsContainer.innerText = '';
    const arrOfEventsContainer = arrOfEvents.map(evt => {
        const newEventContainer = document.createElement('div');
        newEventContainer.style.marginLeft = `${(evt.startTime - 8) * 10}%`;
        newEventContainer.style.width = `${(evt.endTime - evt.startTime) * 10}%`;
        const newTextContainer = document.createElement('span');
        newTextContainer.innerText = evt.description;
        newEventContainer.append(newTextContainer);
        return newEventContainer;
    });
    eventsContainer.append(...arrOfEventsContainer);
};


// detection and visualization of the best events
const chooseBestEvents = () => {

    // detection of the best events
    const bestEvents = [];
    let arrOfEventsCopy = [...arrOfEvents];

    while (arrOfEventsCopy.length > 0) {
        arrOfEventsCopy.sort((a, b) => b.startTime - a.startTime);
        const startOfPlannedEvent = arrOfEventsCopy[0].startTime;
        bestEvents.push(arrOfEventsCopy[0]);
        arrOfEventsCopy = arrOfEventsCopy.filter(event => event.endTime <= startOfPlannedEvent);
    }

    // visualization of the best events
    const arrayOfDescriptions = bestEvents.map(event => event.description);
    [...document.querySelectorAll('.events > div')].forEach(event => {
        if (arrayOfDescriptions.includes(event.innerText)) {
            event.classList.add('choosen-event');
        }
    })
}

document.querySelector('.btn-generate-events').addEventListener('click', renderEventsApplications);
document.querySelector('.btn-choose-events').addEventListener('click', chooseBestEvents);