
/*
Вместимость рюкзака - 50

 60 / 10 = 6
 100 / 20 = 5
 120 / 30 = 4

 Разновидность задачи 1 - слитки не повторяются, распиливать нельзя

 Берём 1 слиток.
 Оставшаяся вместимость 50 - 10 = 40. Ценность - 60.
 Берём 2 слиток.
 Оставшаяся вместимость 40 - 20 = 20. Ценность - 60 + 100 = 160.
 Третий слиток положить не можем.
 Результат - 160.

 Разновидность задачи 2 - слитки повторяются.

 Берём 1 слиток 5 раз.
 Результат - 5 * 60 = 300.

 Разновидность задачи 3 - слитки не повторяются, распиливать можно
 Берём 1 слиток.
 Оставшаяся вместимость 50 - 10 = 40. Ценность - 60.
 Берём 2 слиток.
 Оставшаяся вместимость 40 - 20 = 20. Ценность - 60 + 100 = 160.
 От 3 слитка отпиливаем кусок весом 20 и вычисляем его стоимость.
 20 * 4 = 80.
 Итого результат - 160 + 80 = 240.

*/

const weight = [10, 30, 20];
const value = [60, 120, 100];
const totalSpace = 50;

function fillBackpack(weight, value, capacity) {

    debugger;
    let items = [];
    for (let i = 0; i < weight.length; i++) {
        items.push({
            weight: weight[i],
            value: value[i],
            cost: value[i] / weight[i]
        });
    }
    items.sort((a, b) => b.cost - a.cost);

    let totalValue = 0;
    let backpack = [];

    for (let i = 0; i < items.length; i++) {
        let item = items[i];
        let curWeight = item.weight;
        let curValue = item.value;

        if (capacity >= curWeight) {
            capacity -= curWeight;
            totalValue += curValue;
            backpack.push(item);
            item.fraction = curWeight;
        } else {
            let fraction = capacity;
            totalValue += fraction * item.cost;
            item.fraction = fraction;
            backpack.push(item);
            break;
        }
    }

    console.log(backpack);
    console.log(totalValue);
}

fillBackpack(weight, value, totalSpace);