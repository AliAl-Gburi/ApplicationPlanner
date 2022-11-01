<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aliam
  Date: 20/01/2022
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="${business.name}"/>
</jsp:include>
<body>
<div class="container">
    <jsp:include page="header.jsp">
        <jsp:param name="active" value="active"/>
    </jsp:include>
    <div id="calendarcontainer">
        <div id="calendar">
            <div id="innercal">
                <div id="calendarHeader">
                    <button id="pre"> < </button>
                        <span id="monthdiv"></span>
                    <button id="nex"> > </button>
                </div>


                <div id="calendartable"></div>

            </div>

        </div>
        <div class="timeslots">
            <ul id="timelist">

            </ul>
        </div>
    </div>
    </div>


<script >
    let localdate = new Date()
    let currentmonth = localdate.getMonth()
    let currentyear = localdate.getFullYear()
    let startdiv = document.getElementById("calendar");
    let innercal = document.getElementById("innercal");
    let pre = document.getElementById("pre");
    let nex = document.getElementById("nex");
    let monthdiv = document.getElementById("monthdiv");
    let caltable = document.getElementById("calendartable");
    let tl = document.getElementById("timelist");
    let mapper = new Map();

    <c:forEach items="${gotta}" var="day">
        <c:forEach items="${day}" var="timeSlot">
            if(!mapper.has("${timeSlot.getSimpleDate()}")) {
                let arr = []
                arr.push("${timeSlot.getSimpleTime()}");
                mapper.set("${timeSlot.getSimpleDate()}", arr)

            } else {
                mapper.get("${timeSlot.getSimpleDate()}").push("${timeSlot.getSimpleTime()}")
            }
        </c:forEach>
    </c:forEach>




    window.addEventListener("load", function () {
        buildCalendar(currentmonth, currentyear)
        enableCalButtons()


        pre.addEventListener("click", function () {
            caltable.innerHTML = "";
            if(currentmonth === 0) {
                currentmonth = 11
                currentyear--
            } else {
                currentmonth--
            }

            buildCalendar(currentmonth, currentyear)
            enableCalButtons()
            emptyTimeSlots()


        })



        nex.addEventListener("click", function (){
            caltable.innerHTML = "";
            if(currentmonth === 11) {
                currentmonth = 0
                currentyear++
            } else {
                currentmonth++
            }

            buildCalendar(currentmonth, currentyear)
            enableCalButtons()
            emptyTimeSlots()
        })

    })





    function buildCalendar(month, year) {


        let table = document.createElement("table")
        let weekdaysrow = document.createElement("thead")

        let monthtext = getMonthText(month)




        monthdiv.innerHTML = monthtext + " " + year




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

        let daysInMonth = new Date(year, month+1, 0).getDate();

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

        let daysinlastmonth = new Date(lastmonthdate.getFullYear(), lastmonthdate.getMonth()+1, 0).getDate();
        console.log(daysinlastmonth)
        console.log(daysInMonth)



        for(let i = 0; i < firstdayofmonthdate.getDay(); i++) {
            let day = daysinlastmonth - firstdayofmonthdate.getDay() + i+1
            let lastmonth = lastmonthdate.getMonth()+1
            let monthtext = ""
            if(lastmonth < 10) {
                monthtext = 0 + lastmonth.toString();
            } else  {
                monthtext = lastmonth.toString();
            }
            let datestring =lastmonthdate.getFullYear() +"-"+monthtext+ "-" + day

            let daytd = document.createElement("td")
            let daybtn = document.createElement("button")
            daybtn.setAttribute("disabled", "disabled");
            daybtn.classList.add("calButton");
            daybtn.innerHTML = day.toString()
            daybtn.name = datestring
            daybtn.id = datestring
            daybtn.onclick = function () {
                emptyTimeSlots()
                <c:forEach items="${gotta}" var="dates">
                    <c:forEach items="${dates}" var="timeslot">
                        if(datestring === "${timeslot.getSimpleDate()}") {
                        let li = document.createElement("li");
                        let anc = document.createElement("a");
                        anc.setAttribute("href", 'Controller?command=MakeAppointment&sid=${currentService.serviceid}&date='+datestring+'&time=${timeslot.getSimpleTime()}')
                            anc.innerText = "${timeslot.getSimpleTime()}"
                        li.append(anc)
                        tl.append(li)
                            removeSelectedDay()
                            daybtn.classList.add("selectedday");
                        }
                    </c:forEach>

                </c:forEach>
            }


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
            let actualmonth = month+1;
            if(actualmonth < 10) {
                monthtext = 0 + actualmonth.toString();
            } else {
                monthtext = actualmonth.toString();
            }
            let datestring =  year+"-" + monthtext + "-" + day


            if(dayinweek > 6) {
                table.appendChild(weekrow)
                weekrow = document.createElement("tr");

                dayinweek = 0
            }

            let daytd = document.createElement("td")
            let daybtn = document.createElement("button")
            daybtn.setAttribute("disabled", "disabled");
            daybtn.classList.add("calButton");
            daybtn.innerHTML = day
            daybtn.name = datestring
            daybtn.id = datestring
            daybtn.onclick = function () {
                emptyTimeSlots()
                <c:forEach items="${gotta}" var="dates">
                <c:forEach items="${dates}" var="timeslot">
                if(datestring === "${timeslot.getSimpleDate()}") {

                    let li = document.createElement("li");
                    let anc = document.createElement("a");
                    anc.setAttribute("href", 'Controller?command=MakeAppointment&sid=${currentService.serviceid}&date='+datestring+'&time=${timeslot.getSimpleTime()}')
                    anc.innerText = "${timeslot.getSimpleTime()}"
                    li.append(anc)
                    tl.append(li)
                    removeSelectedDay()
                    daybtn.classList.add("selectedday");
                }
                </c:forEach>

                </c:forEach>
            }


            daytd.appendChild(daybtn)
            weekrow.appendChild(daytd)


            dayinweek++


        }

        table.appendChild(weekrow);
        caltable.appendChild(table);



    }

    function removeSelectedDay() {
        calButtons = document.getElementsByClassName("calButton");

        for (let i = 0; i < calButtons.length; i++) {
            calButtons[i].classList.remove("selectedday");
        }
    }

    function enableCalButtons() {
        calButtons = document.getElementsByClassName("calButton");

        for(i = 0; i < calButtons.length; i++) {
            for(j = 0; j < mapper.size; j++) {
                if(mapper.has(calButtons[i].getAttribute("name"))) {
                    calButtons[i].removeAttribute("disabled");
                    calButtons[i].classList.add("hasdates");
                }
            }
        }

    }

    function loadAvailableSlots(day) {
        <c:forEach items="${gotta}" var="dates">
            <c:forEach items="${dates}" var="timeslot">
                if(day === "${timeslot.getSimpleDate()}") {
                    let li = document.createElement("li");
                    li.innerHTML = "${timeslot.getSimpleTime()}"
                    tl.append(li)
                }
            </c:forEach>

        </c:forEach>
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
    function emptyTimeSlots() {
        tl.innerHTML = ""
    }
</script>

</body>
</html>
