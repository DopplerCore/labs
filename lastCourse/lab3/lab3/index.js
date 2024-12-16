let tasks = [
    {
        text:"Задан бесконечный цикл. С помощью двух отдельных вызовов функции prompt() вводит два числа. Числа сравниваются между собой, после чего пользователю отображается одна из трёх фраз: «числа равны», «первое число меньше», «второе число меньше». При введении пользователем не числовых значений, в зависимости от введённых данных пользователь может увидеть фразы «первый или второй ввод - не число». Выполнение скрипта прекращается при вводе пользователем в первом или втором вводе значения q без учёта регистра",
        realization: realization1
    },
    {
        text:"Дан многоквартирный жилой дом. У ждома присутствуют три характеристики: количество этажей (1-20), число подъездов (1-15), количество квартир на лестничной площадке (1-5). Пользовательский скрипт запрашивает харакеристики, а также квартиры. Необходимо рассчитать и вывести на экран номер подъезда, в котором находится запрашиваемая квартира. Если пользователь вводит некорректиные значения предусмотреть генерацию исключения, с выводом информации об ошибке на экран.",
        realization:realization2
    },
    {
        text:"22 марта 2022 был вторник. Написать скрипт который будет спрашивать у пользователя номер месяца в интервале “1..12”, а так же число в этом месяце “1..31”. Результатом работы скрипта является вывод на экран названия дня недели (например, «среда») для введённого пользователем числа и месяца.",
        realization:realization3
    },
    {
        text:"Вам необходимо создать функцию, которая будет получать на вход два любых числа. При условии если оба введённых числа чётные - необходимо венуть их произведение. При нечётных числах возвращаем сумму. В варианте при котором первое число чётное, а второе нечётное - возвращаем нечётное число, в обратном случае возвращаем чётное.",
        realization:realization4
    },
    {
        text:"Необходмо создать функцию, которая будет возвращать сумму любого введённого количества чисел. Обратите внимание на то как должна вызываться данная функция: result = sum(3)(1)(1); // результат 5",
        realization:realization5
    },
    {
        text:"Реализуйте функцию range(), которая будет принимать на вход два аргумента: “старт” и “финиш” диапазона. Функция возвращать массив, содержащий все числа ввдеённого диапазона, включая начальное и конечное. При этом необходимо предусмотреть необязательный аргумент – шаг для построения массива который может быть как положительным так и отрицательным. Если шаг явно не задан – он равен 1. Результатом работы range(7, 4, -2) будет [7, 5].",
        realization:realization6
    },
    {
        text:"Необходимо реализовать функцию создания матрицы, принимающую в качестве аргументов количество строк и количество столбцов. Эта функция должна отображать на экране матрицу, заполненную случайными числами в диапазоне от 0 до 100. Так же необходимо написать другую функцию, которая будет выполнять суммирование двух различных по значению “первых матриц”.",
        realization:realization7
    },
    {
        text:"Создайте функцию, которая будет объединять уникальные элементы всех одномерных массивов, переданных ей в качестве параметра. Если вводимый пользователем массив многомерный, то необходимо выдать пользователю сообщение о том что функция работает только с одномерными массива и указать размерность введённого массива. MyUnionFuic([1, 5, 5, 3], [10, 5, 1, 10], [5, 1]) вернёт[1, 3, 5, 10].",
        realization:realization8
    },
    {
        text:"Создайте функцию, которая в качестве агрумента может принимать массив с уровнями вложенности элементов любой глубины, выполнит приведение его к “плоскому” виду. Если элементы массива не имеют вложенности, то функция просто выводит его на экран без изменений. MyArrayFlattenFunc([1, [2], [[5], [3, [4]]]]) вернёт [1, 2, 3, 4, 5].",
        realization:realization9
    },
    {
        text:'Реализовать функцию которая принимает на вход в качестве параметра массив или объект, подобный массиву, а так же параметр который отвечает за количество повторений. Возвращаемое функцией значение это массив, в котором удалены повторяющиеся знаачения. var furstResult= MyFunctionUnique([1, 2, 1, 5, 1, 5, 1, 4], 3); // furstResult = [2, 4, 5]',
        realization:realization10
    }
];
let i = -1;
function showNextTask(){
    i++;
    if(i>9)i=0;
    let task = tasks[i];
    let text = document.querySelector(".text");
    let container = document.querySelector(".container");
    let output = document.querySelector(".output");

    text.textContent = task.text;
    container.innerHTML = "";
    output.textContent = "";
    container.appendChild(task.realization());
}
document.querySelector(".submit").onclick = showNextTask;
showNextTask();

function realization1(){
    let output = document.querySelector(".output");
    let button = document.createElement("button");
    button.style.margin = "0";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    button.onclick = function(){
        while(true){
            let first = prompt();
            if(first=='q')break;
            if(isNaN(parseInt(first))) output.textContent= "Ответ: первый ввод - не число";
            else{
                let second = prompt();
                if(second=='q')break;
                if(isNaN(parseInt(second))) output.textContent= "Ответ: второй ввод - не число";
                else{
                    if(first==second) output.textContent= "Ответ: числа равны";
                    else if(first<second) output.textContent= "Ответ: первое число меньше";
                    else output.textContent= "Ответ: второе число меньше";
                }
            }
            
        }
    }
    return button;
}

function realization2(){
    let output = document.querySelector(".output");
    let div = document.createElement("div");
    div.style.margin = 0;
    let apartmentInput = document.createElement("input");
    apartmentInput.placeholder = "Номер квартиры";
    let floorNumberInput = document.createElement("input");
    floorNumberInput.placeholder = "Количество этажей";
    let entranceNumberInput = document.createElement("input");
    entranceNumberInput.placeholder = "Число подъездов";
    let apartmentsNumberInput = document.createElement("input");
    apartmentsNumberInput.placeholder = "Количество квартир на лестничной площадке";
    let button = document.createElement("button");
    button.style.margin = "0";
    button.style.marginTop = "20px";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    button.onclick = function(){
        let apartment = apartmentInput.value;
        let floorNum = floorNumberInput.value;
        let entranceNum = entranceNumberInput.value;
        let apartmentsNum = apartmentsNumberInput.value;
        if(isNaN(parseInt(apartment))) output.textContent = 'Ошибка: В поле "Номер квартиры" введено не число!!!';
        else if(isNaN(parseInt(floorNum))) output.textContent = 'Ошибка: В поле "Количество этажей" введено не число!!!';
        else if(isNaN(parseInt(entranceNum))) output.textContent = 'Ошибка: В поле "Число подъездов" введено не число!!!';
        else if(isNaN(parseInt(apartmentsNum))) output.textContent = 'Ошибка: В поле "Количество квартир на лестничной площадке" введено не число!!!';
        else if(apartment<0) output.textContent = 'Ошибка: В поле "Номер квартиры" необходимо ввести значение больше 0!!!';
        else if(floorNum<1||floorNum>20) output.textContent = 'Ошибка: В поле "Количество этажей" необходимо ввести значение от 1 до 20!!!';
        else if(entranceNum<1||entranceNum>15) output.textContent = 'Ошибка: В поле "Число подъездов" необходимо ввести значение от 1 до 15!!!';
        else if(apartmentsNum<1||apartmentsNum>5) output.textContent = 'Ошибка: В поле "Количество квартир на лестничной площадке" необходимо ввести значение от 1 до 5!!!';
        else {
            let i = 0;
            while(apartment>0){
                apartment-=floorNum*apartmentsNum;
                i++;
            }
            if(i>entranceNum) output.textContent = `Ошибка: Квартиры с таким номером нету в доме!!!`;
            else output.textContent = `Ответ: Кварира находится в ${i} подъезде!!!`;
        }
    }
    div.appendChild(apartmentInput);
    div.appendChild(floorNumberInput);
    div.appendChild(entranceNumberInput);
    div.appendChild(apartmentsNumberInput);
    div.appendChild(button);
    return div;
}

function realization3(){
    let output = document.querySelector(".output");
    let div = document.createElement("div");
    div.style.margin = 0;
    let monthInput = document.createElement("input");
    monthInput.placeholder = "Номер месяца";
    let floorNumberInput = document.createElement("input");
    floorNumberInput.placeholder = "Число месяца"; 
    let button = document.createElement("button");
    button.style.margin = "0";
    button.style.marginTop = "20px";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    button.onclick = function(){
        let month = monthInput.value;
        let day = floorNumberInput.value;
        if(isNaN(parseInt(month))) output.textContent = 'Ошибка: В поле "Номер месяца" введено не число!!!';
        else if(isNaN(parseInt(day))) output.textContent = 'Ошибка: В поле "Число месяца" введено не число!!!';
        else if(month<0||month>12) output.textContent = 'Ошибка: В поле "Номер месяца" необходимо ввести значение от 1 до 12!!!';
        else if(day<1||day>31) output.textContent = 'Ошибка: В поле "Число месяца" необходимо ввести значение от 1 до 31!!!';
        else {
            let date = new Date(`2024-${month}-${day}`);
            let options = {weekday:'long'};
            let dayOfWeek = date.toLocaleString('ru-RU',options);
            output.textContent = dayOfWeek;
        }
    }
    div.appendChild(monthInput);
    div.appendChild(floorNumberInput);
    div.appendChild(button);
    return div;
}

function realization4(){
    let output = document.querySelector(".output");
    let div = document.createElement("div");
    div.style.margin = 0;
    let firstInput = document.createElement("input");
    firstInput.placeholder = "Первое число";
    let secondInput = document.createElement("input");
    secondInput.placeholder = "Второе число"; 
    let button = document.createElement("button");
    button.style.margin = "0";
    button.style.marginTop = "20px";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    button.onclick = function(){
        let first = firstInput.value;
        let second = secondInput.value;
        if((first%2==0)&&(second%2==0)) output.textContent = `Ответ: ${parseInt(first)*parseInt(second)}`
        else if((first%2!=0)&&(second%2!=0)) output.textContent = `Ответ: ${parseInt(first)+parseInt(second)}`
        else if(((first%2==0)&&(second%2!=0))||((first%2!=0)&&(second%2==0))) output.textContent = `Ответ: ${parseInt(second)}`
    }
    div.appendChild(firstInput);
    div.appendChild(secondInput);
    div.appendChild(button);
    return div;
}

function realization5(){
    let output = document.querySelector(".output");
    let div = document.createElement("div");
    div.style.margin = 0;
    let arrInput = document.createElement("input");
    arrInput.placeholder = "Числа";
    let button = document.createElement("button");
    button.style.margin = "0";
    button.style.marginTop = "20px";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    button.onclick = function(){
        let arr = arrInput.value.split(", ").map(e=>{return parseInt(e)});
        let answer = 0;
        for(let i =0;i<arr.length;i++)answer+=arr[i]; 
        output.textContent = `Ответ: ${answer}`;
    }
    div.appendChild(arrInput);
    div.appendChild(button);
    return div;
}

function realization6(){
    let output = document.querySelector(".output");
    let div = document.createElement("div");
    div.style.margin = 0;
    let startInput = document.createElement("input");
    startInput.placeholder = "Старт";
    let finishInput = document.createElement("input");
    finishInput.placeholder = "Финиш"; 
    let stepInput = document.createElement("input");
    stepInput.placeholder = "Шаг"; 
    let button = document.createElement("button");
    button.style.margin = "0";
    button.style.marginTop = "20px";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    function range(){
        let arr = [];
        if(!arguments[2]) arguments[2]=1;
        if(arguments[0]<arguments[1])for(let i=arguments[0];i<arguments[1];i+=arguments[2])arr.push(i);
        else for(let i=arguments[0];i>arguments[1];i+=arguments[2])arr.push(i);
        return arr;
    }
    button.onclick = function(){
        let start = parseInt(startInput.value);
        let finish = parseInt(finishInput.value);
        let step = parseInt(stepInput.value);
        output.textContent = range(start,finish,step);
    }
    div.appendChild(startInput);
    div.appendChild(finishInput);
    div.appendChild(stepInput);
    div.appendChild(button);
    return div;
}

function realization7(){
    let output = document.querySelector(".output");
    let div = document.createElement("div");
    div.style.margin = 0;
    let rowInput = document.createElement("input");
    rowInput.placeholder = "Количество строк";
    let columnInput = document.createElement("input");
    columnInput.placeholder = "Количество столбцов"; 
    let button = document.createElement("button");
    button.style.margin = "0";
    button.style.marginTop = "20px";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    button.onclick = function(){
        let row = parseInt(rowInput.value);
        let column = parseInt(columnInput.value);
        let table1 = document.createElement("table");
        let table2 = document.createElement("table");
        let table3 = document.createElement("table");
        table1.style.border = "2px solid black";
        table2.style.border = "2px solid black";
        table3.style.border = "2px solid black";
        for(let i=0;i<row;i++){
            let tr = document.createElement("tr");
            for(let j=0;j<column;j++){
                let th = document.createElement("th");
                th.textContent = Math.floor(Math.random()*101);
                tr.appendChild(th);
            }
            table1.appendChild(tr);
        }
        output.appendChild(table1);
        for(let i=0;i<row;i++){
            let tr = document.createElement("tr");
            for(let j=0;j<column;j++){
                let th = document.createElement("th");
                th.textContent = Math.floor(Math.random()*101);
                tr.appendChild(th);
            }
            table2.appendChild(tr);
        }
        output.appendChild(table2);

        let trs1 = table1.querySelectorAll("tr");
        let trs2 = table2.querySelectorAll("tr");
        for(let i=0;i<row;i++){
            let tr = document.createElement("tr");
            let ths1 = trs1[i].querySelectorAll("th");
            let ths2 = trs2[i].querySelectorAll("th");
            for(let j=0;j<column;j++){
                let th = document.createElement("th");
                th.textContent = parseInt(ths1[j].textContent)+parseInt(ths2[j].textContent);
                tr.appendChild(th);
            }
            table3.appendChild(tr);
        }
        output.appendChild(table3);


    }
    div.appendChild(rowInput);
    div.appendChild(columnInput);
    div.appendChild(button);
    return div;
}

function realization8(){
    let output = document.querySelector(".output");
    let div = document.createElement("div");
    div.style.margin = 0;
    let arrsInput = document.createElement("input");
    arrsInput.placeholder = "Массивы";
    let button = document.createElement("button");
    button.style.margin = "0";
    button.style.marginTop = "20px";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    button.onclick = function(){
        let arrs = arrsInput.value.split(",[");
        let matches = 0;
        let arr = [];
        let regexp = /\]/g;
        for(let i=0;i<arrs.length;i++){
            console.log(arrs[i].match(regexp));
            let tmp = arrs[i].match(regexp).length;
            if(tmp>matches)matches=tmp;
            let tmpArr = arrs[i].replace('[','').replace(']','').split(", ");
            console.log(tmpArr);
            tmpArr.forEach(e=>{arr.push(parseInt(e))});
        }
        let uniqArr = [...new Set(arr)];
        if(matches<1)output.textContent = "Ошибка: Массив ввведён не верно!!!";
        else if(matches>1)output.textContent = `Ошибка: Необходимо вводить одномерные массивы. Введён массив размерностью ${matches}!!!`;
        else output.textContent = `Ответ: [${uniqArr}]`;
    }
    div.appendChild(arrsInput);
    div.appendChild(button);
    return div;
}

function realization9(){
    let output = document.querySelector(".output");
    let div = document.createElement("div");
    div.style.margin = 0;

    let button = document.createElement("button");
    let arrInput = document.createElement("input");
    arrInput.placeholder = "Массив";
    button.style.margin = "0";
    button.style.marginTop = "20px";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    button.onclick = function(){
        let arrs = arrInput.value;
        let arr = [];
        arrs = arrs.replace(/\[/g,'').replace(/\]/g,'').split(", ");
        arrs.forEach(e=>{arr.push(parseInt(e))});
        arr.sort();
        output.textContent = `Ответ: [${arr}]`;
    }
    div.appendChild(arrInput);
    div.appendChild(button);
    return div;
}

function realization10(){
    let output = document.querySelector(".output");
    let div = document.createElement("div");
    div.style.margin = 0;
    let arrInput = document.createElement("input");
    arrInput.placeholder = "Массив";
    let numInput = document.createElement("input");
    numInput.placeholder = "Число повторений"; 
    let button = document.createElement("button");
    button.style.margin = "0";
    button.style.marginTop = "20px";
    button.textContent = "НАЧАТЬ"
    button.style.width = "100px";
    button.type = "button";
    button.onclick = function(){
        let arr = arrInput.value;
        let num = numInput.value;
        let tmpArr = [];
        arr.replace('[','').replace(']','').split(", ").forEach(e=>{tmpArr.push(parseInt(e))});;
        let result = [...new Set(tmpArr)];
        let resultTmp = [...result];
        for(let i=0;i<result.length;i++){
            let regexp = new RegExp( result[i], 'g' );
            if(arr.match(regexp).length==num) resultTmp = resultTmp.filter(e=>e!=result[i]);
        }
        result = resultTmp;
        output.textContent = `Ответ: ${result}`
    }
    div.appendChild(arrInput);
    div.appendChild(numInput);
    div.appendChild(button);
    return div;
}