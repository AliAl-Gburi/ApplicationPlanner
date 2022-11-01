let localdate = new Date()
let startdiv = document.getElementById("calendar");

window.addEventListener("load", function () {
    buildCalendar(localdate.getMonth(), localdate.getFullYear())
})





function buildCalendar(month, year) {
    let innercal = document.createElement("div")
    let monthdiv = document.createElement("div")
    let table = document.createElement("table")
    let weekdaysrow = document.createElement("thead")

    let monthtext = getMonthText(month)

    monthdiv.innerHTML = monthtext

    innercal.appendChild(monthdiv)

    let trsunday = document.createElement("th")
    let trmonday = document.createElement("th")
    let trtue = document.createElement("th")
    let trwed = document.createElement("th")
    let trth = document.createElement("th")
    let trfr = document.createElement("th")
    let trsa = document.createElement("th")

    trsunday.innerHTML = "su"
    trmonday.innerHTML = "mo"
    trtue.innerHTML = "tu"
    trwed.innerHTML = "we"
    trth.innerHTML = "th"
    trfr.innerHTML = "fr"
    trsa.innerHTML = "sa"

    weekdaysrow.appendChild(trsunday)
    weekdaysrow.appendChild(trmonday)
    weekdaysrow.appendChild(trtue)
    weekdaysrow.appendChild(trwed)
    weekdaysrow.appendChild(trth)
    weekdaysrow.appendChild(trfr)
    weekdaysrow.appendChild(trsa)

    table.appendChild(weekdaysrow)

    let daysInMonth = new Date(year, month, 0).getDate();

    let weekrow = document.createElement("tr")


    let dayinweek = 0
    let firstdayofmonthdate = new Date(getMonthText(month) + ' 01, ' + year)

    let lastmonthdate

    if(month === 0) {
        let lyear = year-1
        lastmonthdate = new Date(getMonthText(11) + ' 01, ' + lyear)
    } else {
        lastmonthdate = new Date(getMonthText(month - 1) + ' 01, ' + year)
    }
    console.log(lastmonthdate)

    let daysinlastmonth = new Date(lastmonthdate.getFullYear(), lastmonthdate.getMonth() +1, 0).getDate();
    console.log(daysinlastmonth)
    console.log(daysInMonth)



    for(let i = 0; i < firstdayofmonthdate.getDay(); i++) {
        let day = daysinlastmonth - firstdayofmonthdate.getDay() + i+1
        let lastmonth = lastmonthdate.getMonth()+1
        let datestring = day+"-"+lastmonth+ "-" + lastmonthdate.getFullYear()

        let daytd = document.createElement("td")
        let daybtn = document.createElement("button")
        daybtn.innerHTML = day.toString()
        daybtn.name = datestring
        daybtn.id = datestring

        daytd.appendChild(daybtn)
        weekrow.appendChild(daytd)
        dayinweek++;

    }

    for(let i = 1; i <= daysInMonth; i++){
        let day = ""
        if(i < 10) {
            day = 0 + i.toString();
        } else {
            day = i.toString()
        }
        let monthtext = ""

        if(month+1 < 10) {
            monthtext = "0" + month+1
        } else {
            monthtext = month+1
        }
        let datestring = day +"-" + monthtext + "-" + year


        if(dayinweek > 6) {
            table.appendChild(weekrow)
            weekrow = document.createElement("tr");

            dayinweek = 0
        }

        let daytd = document.createElement("td")
        let daybtn = document.createElement("button")
        daybtn.innerHTML = day
        daybtn.name = datestring
        daybtn.id = datestring

        daytd.appendChild(daybtn)
        weekrow.appendChild(daytd)


        dayinweek++


    }

    table.appendChild(weekrow);

    innercal.appendChild(table)

    startdiv.appendChild(innercal)

}



function getMonthText(i) {
    let textmonth = "";
    switch (i) {
        case 0:
            textmonth = "January";
            break;
        case 1:
            textmonth = "February";
            break;
        case 2:
            textmonth = "March";
            break;
        case 3:
            textmonth = "April";
            break;
        case 4:
            textmonth = "May";
            break;
        case 5:
            textmonth = "June";
            break;
        case 6:
            textmonth = "July";
            break;
        case 7:
            textmonth = "August";
            break;
        case 8:
            textmonth = "September";
            break;
        case 9:
            textmonth = "October";
            break;
        case 10:
            textmonth = "November";
            break;
        case 11:
            textmonth = "December";
            break;

    }
    return textmonth;
}
