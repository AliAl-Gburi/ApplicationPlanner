let mondayintervals = document.getElementById("mondaytimeintervals");
let mondayintervalinput = document.getElementById("mondayintervals");
let mondaycheck = document.getElementById("monday");
let mondayintervallist = document.getElementsByClassName("mondayintervalslist");

let tuesdayintervals = document.getElementById("tuesdaytimeintervals");
let tuesdayintervalinput = document.getElementById("tuesdayintervals");
let tuesdaycheck = document.getElementById("tuesday");
let tuesdayintervallist = document.getElementsByClassName("tuesdayintervalslist");

let wednesdayintervals = document.getElementById("wednesdaytimeintervals");
let wednesdayintervalinput = document.getElementById("wednesdayintervals");
let wednesdaycheck = document.getElementById("wednesday");
let wednesdayintervallist = document.getElementsByClassName("wednesdayintervalslist");

let thursdayintervals = document.getElementById("thursdaytimeintervals");
let thursdayintervalinput = document.getElementById("thursdayintervals");
let thursdaycheck = document.getElementById("thursday");
let thursdayintervallist = document.getElementsByClassName("thursdayintervalslist");

let fridayintervals = document.getElementById("fridaytimeintervals");
let fridayintervalinput = document.getElementById("fridayintervals");
let fridaycheck = document.getElementById("friday");
let fridayintervallist = document.getElementsByClassName("fridayintervalslist");

let saturdayintervals = document.getElementById("saturdaytimeintervals");
let saturdayintervalinput = document.getElementById("saturdayintervals");
let saturdaycheck = document.getElementById("saturday");
let saturdayintervallist = document.getElementsByClassName("saturdayintervalslist");

let sundayintervals = document.getElementById("sundaytimeintervals");
let sundayintervalinput = document.getElementById("sundayintervals");
let sundaycheck = document.getElementById("sunday");
let sundayintervallist = document.getElementsByClassName("sundayintervalslist");

window.addEventListener("load", function () {
    mondaycheck.addEventListener("input", showMondayInterval);
    mondayintervalinput.addEventListener("input", showMondayIntervalList);

    tuesdaycheck.addEventListener("input", showtuesdayInterval);
    tuesdayintervalinput.addEventListener("input", showtuesdayIntervalList);

    wednesdaycheck.addEventListener("input", showwednesdayInterval);
    wednesdayintervalinput.addEventListener("input", showwednesdayIntervalList);

    thursdaycheck.addEventListener("input", showthursdayInterval);
    thursdayintervalinput.addEventListener("input", showthursdayIntervalList);

    fridaycheck.addEventListener("input", showfridayInterval);
    fridayintervalinput.addEventListener("input", showfridayIntervalList);

    saturdaycheck.addEventListener("input", showsaturdayInterval);
    saturdayintervalinput.addEventListener("input", showsaturdayIntervalList);

    sundaycheck.addEventListener("input", showsundayInterval);
    sundayintervalinput.addEventListener("input", showsundayIntervalList);
})

function showMondayInterval() {
    if(document.querySelector("#monday:checked")) {
        mondayintervals.classList.add("display-block");
        mondayintervals.classList.remove("display-none");
    } else {
        mondayintervals.classList.add("display-none");
        mondayintervals.classList.remove("display-block");
        hidemondayintervals();
        mondayintervalinput.value = "";
    }
}
function hidemondayintervals() {
    for(let i = 0; i < 5; i++) {
        mondayintervallist[i].classList.add("display-none");
        mondayintervallist[i].classList.remove("display-block");
    }
}

function showMondayIntervalList() {
    for(let i = 0; i < mondayintervalinput.value; i++) {
            mondayintervallist[i].classList.add("display-block");
            mondayintervallist[i].classList.remove("display-none");

    }
    for(let i = mondayintervalinput.value+1; i < 5; i++) {
        mondayintervallist[i].classList.add("display-none");
        mondayintervallist[i].classList.remove("display-block");
    }
    for(let i = 4; i >= mondayintervalinput.value; i--) {
        mondayintervallist[i].classList.add("display-none");
        mondayintervallist[i].classList.remove("display-block");
    }
    if(mondayintervalinput.value === "") {
        for(let i = 0; i < 5; i++) {
            mondayintervallist[i].classList.add("display-none");
            mondayintervallist[i].classList.remove("display-block");
        }
    }
}




function showtuesdayInterval() {
    if(document.querySelector("#tuesday:checked")) {
        tuesdayintervals.classList.add("display-block");
        tuesdayintervals.classList.remove("display-none");
    } else {
        tuesdayintervals.classList.add("display-none");
        tuesdayintervals.classList.remove("display-block");
        hidetuesdayintervals();
        tuesdayintervalinput.value = "";
    }
}
function hidetuesdayintervals() {
    for(let i = 0; i < 5; i++) {
        tuesdayintervallist[i].classList.add("display-none");
        tuesdayintervallist[i].classList.remove("display-block");
    }
}

function showtuesdayIntervalList() {
    for(let i = 0; i < tuesdayintervalinput.value; i++) {
        tuesdayintervallist[i].classList.add("display-block");
        tuesdayintervallist[i].classList.remove("display-none");

    }
    for(let i = tuesdayintervalinput.value+1; i < 5; i++) {
        tuesdayintervallist[i].classList.add("display-none");
        tuesdayintervallist[i].classList.remove("display-block");
    }
    for(let i = 4; i >= tuesdayintervalinput.value; i--) {
        tuesdayintervallist[i].classList.add("display-none");
        tuesdayintervallist[i].classList.remove("display-block");
    }
    if(tuesdayintervalinput.value === "") {
        for(let i = 0; i < 5; i++) {
            tuesdayintervallist[i].classList.add("display-none");
            tuesdayintervallist[i].classList.remove("display-block");
        }
    }
}



function showwednesdayInterval() {
    if(document.querySelector("#wednesday:checked")) {
        wednesdayintervals.classList.add("display-block");
        wednesdayintervals.classList.remove("display-none");
    } else {
        wednesdayintervals.classList.add("display-none");
        wednesdayintervals.classList.remove("display-block");
        hidewednesdayintervals();
        wednesdayintervalinput.value = "";
    }
}
function hidewednesdayintervals() {
    for(let i = 0; i < 5; i++) {
        wednesdayintervallist[i].classList.add("display-none");
        wednesdayintervallist[i].classList.remove("display-block");
    }
}

function showwednesdayIntervalList() {
    for(let i = 0; i < wednesdayintervalinput.value; i++) {
        wednesdayintervallist[i].classList.add("display-block");
        wednesdayintervallist[i].classList.remove("display-none");

    }
    for(let i = wednesdayintervalinput.value+1; i < 5; i++) {
        wednesdayintervallist[i].classList.add("display-none");
        wednesdayintervallist[i].classList.remove("display-block");
    }
    for(let i = 4; i >= wednesdayintervalinput.value; i--) {
        wednesdayintervallist[i].classList.add("display-none");
        wednesdayintervallist[i].classList.remove("display-block");
    }
    if(wednesdayintervalinput.value === "") {
        for(let i = 0; i < 5; i++) {
            wednesdayintervallist[i].classList.add("display-none");
            wednesdayintervallist[i].classList.remove("display-block");
        }
    }
}



function showthursdayInterval() {
    if(document.querySelector("#thursday:checked")) {
        thursdayintervals.classList.add("display-block");
        thursdayintervals.classList.remove("display-none");
    } else {
        thursdayintervals.classList.add("display-none");
        thursdayintervals.classList.remove("display-block");
        hidethursdayintervals();
        thursdayintervalinput.value = "";
    }
}
function hidethursdayintervals() {
    for(let i = 0; i < 5; i++) {
        thursdayintervallist[i].classList.add("display-none");
        thursdayintervallist[i].classList.remove("display-block");
    }
}

function showthursdayIntervalList() {
    for(let i = 0; i < thursdayintervalinput.value; i++) {
        thursdayintervallist[i].classList.add("display-block");
        thursdayintervallist[i].classList.remove("display-none");

    }
    for(let i = thursdayintervalinput.value+1; i < 5; i++) {
        thursdayintervallist[i].classList.add("display-none");
        thursdayintervallist[i].classList.remove("display-block");
    }
    for(let i = 4; i >= thursdayintervalinput.value; i--) {
        thursdayintervallist[i].classList.add("display-none");
        thursdayintervallist[i].classList.remove("display-block");
    }
    if(thursdayintervalinput.value === "") {
        for(let i = 0; i < 5; i++) {
            thursdayintervallist[i].classList.add("display-none");
            thursdayintervallist[i].classList.remove("display-block");
        }
    }
}



function showfridayInterval() {
    if(document.querySelector("#friday:checked")) {
        fridayintervals.classList.add("display-block");
        fridayintervals.classList.remove("display-none");
    } else {
        fridayintervals.classList.add("display-none");
        fridayintervals.classList.remove("display-block");
        hidefridayintervals();
        fridayintervalinput.value = "";
    }
}
function hidefridayintervals() {
    for(let i = 0; i < 5; i++) {
        fridayintervallist[i].classList.add("display-none");
        fridayintervallist[i].classList.remove("display-block");
    }
}

function showfridayIntervalList() {
    for(let i = 0; i < fridayintervalinput.value; i++) {
        fridayintervallist[i].classList.add("display-block");
        fridayintervallist[i].classList.remove("display-none");

    }
    for(let i = fridayintervalinput.value+1; i < 5; i++) {
        fridayintervallist[i].classList.add("display-none");
        fridayintervallist[i].classList.remove("display-block");
    }
    for(let i = 4; i >= fridayintervalinput.value; i--) {
        fridayintervallist[i].classList.add("display-none");
        fridayintervallist[i].classList.remove("display-block");
    }
    if(fridayintervalinput.value === "") {
        for(let i = 0; i < 5; i++) {
            fridayintervallist[i].classList.add("display-none");
            fridayintervallist[i].classList.remove("display-block");
        }
    }
}



function showsaturdayInterval() {
    if(document.querySelector("#saturday:checked")) {
        saturdayintervals.classList.add("display-block");
        saturdayintervals.classList.remove("display-none");
    } else {
        saturdayintervals.classList.add("display-none");
        saturdayintervals.classList.remove("display-block");
        hidesaturdayintervals();
        saturdayintervalinput.value = "";
    }
}
function hidesaturdayintervals() {
    for(let i = 0; i < 5; i++) {
        saturdayintervallist[i].classList.add("display-none");
        saturdayintervallist[i].classList.remove("display-block");
    }
}

function showsaturdayIntervalList() {
    for(let i = 0; i < saturdayintervalinput.value; i++) {
        saturdayintervallist[i].classList.add("display-block");
        saturdayintervallist[i].classList.remove("display-none");

    }
    for(let i = saturdayintervalinput.value+1; i < 5; i++) {
        saturdayintervallist[i].classList.add("display-none");
        saturdayintervallist[i].classList.remove("display-block");
    }
    for(let i = 4; i >= saturdayintervalinput.value; i--) {
        saturdayintervallist[i].classList.add("display-none");
        saturdayintervallist[i].classList.remove("display-block");
    }
    if(saturdayintervalinput.value === "") {
        for(let i = 0; i < 5; i++) {
            saturdayintervallist[i].classList.add("display-none");
            saturdayintervallist[i].classList.remove("display-block");
        }
    }
}




function showsundayInterval() {
    if(document.querySelector("#sunday:checked")) {
        sundayintervals.classList.add("display-block");
        sundayintervals.classList.remove("display-none");
    } else {
        sundayintervals.classList.add("display-none");
        sundayintervals.classList.remove("display-block");
        hidesundayintervals();
        sundayintervalinput.value = "";
    }
}
function hidesundayintervals() {
    for(let i = 0; i < 5; i++) {
        sundayintervallist[i].classList.add("display-none");
        sundayintervallist[i].classList.remove("display-block");
    }
}

function showsundayIntervalList() {
    for(let i = 0; i < sundayintervalinput.value; i++) {
        sundayintervallist[i].classList.add("display-block");
        sundayintervallist[i].classList.remove("display-none");

    }
    for(let i = sundayintervalinput.value+1; i < 5; i++) {
        sundayintervallist[i].classList.add("display-none");
        sundayintervallist[i].classList.remove("display-block");
    }
    for(let i = 4; i >= sundayintervalinput.value; i--) {
        sundayintervallist[i].classList.add("display-none");
        sundayintervallist[i].classList.remove("display-block");
    }
    if(sundayintervalinput.value === "") {
        for(let i = 0; i < 5; i++) {
            sundayintervallist[i].classList.add("display-none");
            sundayintervallist[i].classList.remove("display-block");
        }
    }
}




