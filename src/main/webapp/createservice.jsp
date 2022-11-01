<%--
  Created by IntelliJ IDEA.
  User: aliam
  Date: 18/01/2022
  Time: 08:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<div class="container">
    <jsp:include page="header.jsp">
        <jsp:param name="active" value="active"/>
    </jsp:include>

    <form action="Controller?command=CreateService&bid=${bid}" method="post">
        <div class="card mycard">
            <h2 class="text-center mt-3">Create Service</h2>
            <div class="mb-3">
                <label class="form-label" for="servicename">Name <span class="required">*</span></label><input
                    type="text" name="servicename" class="form-control" id="servicename">
            </div>
            <h4>Days and Hours</h4>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="monday" value="monday" id="monday">
                <label class="form-check-label" for="monday">
                    Monday
                </label>
                <div class="mb-3 display-none" id="mondaytimeintervals">
                    <label class="form-label" for="mondayintervals">Time Intervals: </label><input
                        type="number" name="mondayintervals"  class="form-control timeinput" min="1" max="5" id="mondayintervals">
                </div>

                <div class="md-form mondayintervalslist display-none">
                    <span class="inlabel">Interval 1</span>
                    <label for="starttimemonday1">Start Time: </label>
                    <input type="time" id="starttimemonday1" name="starttimemonday1" class="form-control timeinput">
                    <label class="endlabel" for="endtimemonday1">End Time: </label>
                    <input type="time" id="endtimemonday1" name="endtimemonday1" class="form-control timeinput">
                </div>
                <div class="md-form mondayintervalslist display-none">
                    <span class="inlabel">Interval 2</span>
                    <label for="starttimemonday2">Start Time: </label>
                    <input type="time" id="starttimemonday2" name="starttimemonday2" class="form-control timeinput">
                    <label class="endlabel" for="endtimemonday2">End Time: </label>
                    <input type="time" id="endtimemonday2" name="endtimemonday2" class="form-control timeinput">
                </div>
                <div class="md-form mondayintervalslist display-none">
                    <span class="inlabel">Interval 3</span>
                    <label for="starttimemonday3">Start Time: </label>
                    <input type="time"  id="starttimemonday3" name="starttimemonday3" class="form-control timeinput">
                    <label class="endlabel" for="endtimemonday3">End Time: </label>
                    <input type="time" id="endtimemonday3" name="endtimemonday3" class="form-control timeinput">
                </div>
                <div class="md-form mondayintervalslist display-none">
                    <span class="inlabel">Interval 4</span>
                    <label for="starttimemonday4">Start Time: </label>
                    <input type="time" id="starttimemonday4" name="starttimemonday4" class="form-control timeinput">
                    <label class="endlabel" for="endtimemonday4">End Time: </label>
                    <input type="time" id="endtimemonday4" name="endtimemonday4" class="form-control timeinput">
                </div>
                <div class="md-form mondayintervalslist display-none">
                    <span class="inlabel">Interval 5</span>
                    <label for="starttimemonday5">Start Time: </label>
                    <input type="time" id="starttimemonday5" name="starttimemonday5" class="form-control timeinput">
                    <label class="endlabel" for="endtimemonday5">End Time: </label>
                    <input type="time" id="endtimemonday5" name="endtimemonday5" class="form-control timeinput">
                </div>
            </div>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="tuesday" value="tuesday" id="tuesday">
                <label class="form-check-label" for="tuesday">
                    Tuesday
                </label>
                <div class="mb-3 display-none" id="tuesdaytimeintervals">
                    <label class="form-label" for="tuesdayintervals">Time Intervals: </label><input
                        type="number" name="tuesdayintervals"  class="form-control timeinput" min="1" max="5" id="tuesdayintervals">
                </div>

                <div class="md-form tuesdayintervalslist display-none">
                    <span class="inlabel">Interval 1</span>
                    <label for="starttimetuesday1">Start Time: </label>
                    <input type="time" id="starttimetuesday1" name="starttimetuesday1" class="form-control timeinput">
                    <label class="endlabel" for="endtimetuesday1">End Time: </label>
                    <input type="time" id="endtimetuesday1" name="endtimetuesday1" class="form-control timeinput">
                </div>
                <div class="md-form tuesdayintervalslist display-none">
                    <span class="inlabel">Interval 2</span>
                    <label for="starttimetuesday2">Start Time: </label>
                    <input type="time" id="starttimetuesday2" name="starttimetuesday2" class="form-control timeinput">
                    <label class="endlabel" for="endtimetuesday2">End Time: </label>
                    <input type="time" id="endtimetuesday2" name="endtimetuesday2" class="form-control timeinput">
                </div>
                <div class="md-form tuesdayintervalslist display-none">
                    <span class="inlabel">Interval 3</span>
                    <label for="starttimetuesday3">Start Time: </label>
                    <input type="time" id="starttimetuesday3" name="starttimetuesday3" class="form-control timeinput">
                    <label class="endlabel" for="endtimetuesday3">End Time: </label>
                    <input type="time" id="endtimetuesday3" name="endtimetuesday3" class="form-control timeinput">
                </div>
                <div class="md-form tuesdayintervalslist display-none">
                    <span class="inlabel">Interval 4</span>
                    <label for="starttimetuesday4">Start Time: </label>
                    <input type="time" id="starttimetuesday4" name="starttimetuesday4" class="form-control timeinput">
                    <label class="endlabel" for="endtimetuesday4">End Time: </label>
                    <input type="time" id="endtimetuesday4" name="endtimetuesday4" class="form-control timeinput">
                </div>
                <div class="md-form tuesdayintervalslist display-none">
                    <span class="inlabel">Interval 5</span>
                    <label for="starttimetuesday5">Start Time: </label>
                    <input type="time" id="starttimetuesday5" name="starttimetuesday5" class="form-control timeinput">
                    <label class="endlabel" for="endtimetuesday5">End Time: </label>
                    <input type="time" id="endtimetuesday5" name="endtimetuesday5" class="form-control timeinput">
                </div>
            </div>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="wednesday" value="wednesday" id="wednesday">
                <label class="form-check-label" for="wednesday">
                    Wednesday
                </label>
                <div class="mb-3 display-none" id="wednesdaytimeintervals">
                    <label class="form-label" for="wednesdayintervals">Time Intervals: </label><input
                        type="number" name="wednesdayintervals"  class="form-control timeinput" min="1" max="5" id="wednesdayintervals">
                </div>

                <div class="md-form wednesdayintervalslist display-none">
                    <span class="inlabel">Interval 1</span>
                    <label for="starttimewednesday1">Start Time: </label>
                    <input type="time" id="starttimewednesday1" name="starttimewednesday1" class="form-control timeinput">
                    <label class="endlabel" for="endtimewednesday1">End Time: </label>
                    <input type="time" id="endtimewednesday1" name="endtimewednesday1" class="form-control timeinput">
                </div>
                <div class="md-form wednesdayintervalslist display-none">
                    <span class="inlabel">Interval 2</span>
                    <label for="starttimewednesday2">Start Time: </label>
                    <input type="time" id="starttimewednesday2" name="starttimewednesday2" class="form-control timeinput">
                    <label class="endlabel" for="endtimewednesday2">End Time: </label>
                    <input type="time" id="endtimewednesday2" name="endtimewednesday2" class="form-control timeinput">
                </div>
                <div class="md-form wednesdayintervalslist display-none">
                    <span class="inlabel">Interval 3</span>
                    <label for="starttimewednesday3">Start Time: </label>
                    <input type="time" id="starttimewednesday3" name="starttimewednesday3" class="form-control timeinput">
                    <label class="endlabel" for="endtimewednesday3">End Time: </label>
                    <input type="time" id="endtimewednesday3" name="endtimewednesday3" class="form-control timeinput">
                </div>
                <div class="md-form wednesdayintervalslist display-none">
                    <span class="inlabel">Interval 4</span>
                    <label for="starttimewednesday4">Start Time: </label>
                    <input type="time" id="starttimewednesday4" name="starttimewednesday4" class="form-control timeinput">
                    <label class="endlabel" for="endtimewednesday4">End Time: </label>
                    <input type="time" id="endtimewednesday4" name="endtimewednesday4" class="form-control timeinput">
                </div>
                <div class="md-form wednesdayintervalslist display-none">
                    <span class="inlabel">Interval 5</span>
                    <label for="starttimewednesday5">Start Time: </label>
                    <input type="time" id="starttimewednesday5" name="starttimewednesday5" class="form-control timeinput">
                    <label class="endlabel" for="endtimewednesday5">End Time: </label>
                    <input type="time" id="endtimewednesday5" name="endtimewednesday5" class="form-control timeinput">
                </div>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="thursday" value="thursday" id="thursday">
                <label class="form-check-label" for="thursday">
                    Thursday
                </label>
                <div class="mb-3 display-none" id="thursdaytimeintervals">
                    <label class="form-label" for="thursdayintervals">Time Intervals: </label><input
                        type="number" name="thursdayintervals"  class="form-control timeinput" min="1" max="5" id="thursdayintervals">
                </div>

                <div class="md-form thursdayintervalslist display-none">
                    <span class="inlabel">Interval 1</span>
                    <label for="starttimethursday1">Start Time: </label>
                    <input type="time" id="starttimethursday1" name="starttimethursday1" class="form-control timeinput">
                    <label class="endlabel" for="endtimethursday1">End Time: </label>
                    <input type="time" id="endtimethursday1" name="endtimethursday1" class="form-control timeinput">
                </div>
                <div class="md-form thursdayintervalslist display-none">
                    <span class="inlabel">Interval 2</span>
                    <label for="starttimethursday2">Start Time: </label>
                    <input type="time" id="starttimethursday2" name="starttimethursday2" class="form-control timeinput">
                    <label class="endlabel" for="endtimethursday2">End Time: </label>
                    <input type="time" id="endtimethursday2" name="endtimethursday2" class="form-control timeinput">
                </div>
                <div class="md-form thursdayintervalslist display-none">
                    <span class="inlabel">Interval 3</span>
                    <label for="starttimethursday3">Start Time: </label>
                    <input type="time" id="starttimethursday3" name="starttimethursday3" class="form-control timeinput">
                    <label class="endlabel" for="endtimethursday3">End Time: </label>
                    <input type="time" id="endtimethursday3" name="endtimethursday3" class="form-control timeinput">
                </div>
                <div class="md-form thursdayintervalslist display-none">
                    <span class="inlabel">Interval 4</span>
                    <label for="starttimethursday4">Start Time: </label>
                    <input type="time" id="starttimethursday4" name="starttimethursday4" class="form-control timeinput">
                    <label class="endlabel" for="endtimethursday4">End Time: </label>
                    <input type="time" id="endtimethursday4" name="endtimethursday4" class="form-control timeinput">
                </div>
                <div class="md-form thursdayintervalslist display-none">
                    <span class="inlabel">Interval 5</span>
                    <label for="starttimethursday5">Start Time: </label>
                    <input type="time" id="starttimethursday5" name="starttimethursday5" class="form-control timeinput">
                    <label class="endlabel" for="endtimethursday5">End Time: </label>
                    <input type="time" id="endtimethursday5" name="endtimethursday5" class="form-control timeinput">
                </div>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="friday" value="friday" id="friday">
                <label class="form-check-label" for="friday">
                    Friday
                </label>
                <div class="mb-3 display-none" id="fridaytimeintervals">
                    <label class="form-label" for="fridayintervals">Time Intervals: </label><input
                        type="number" name="fridayintervals"  class="form-control timeinput" min="1" max="5" id="fridayintervals">
                </div>

                <div class="md-form fridayintervalslist display-none">
                    <span class="inlabel">Interval 1</span>
                    <label for="starttimefriday1">Start Time: </label>
                    <input type="time" id="starttimefriday1" name="starttimefriday1" class="form-control timeinput">
                    <label class="endlabel" for="endtimefriday1">End Time: </label>
                    <input type="time" id="endtimefriday1" name="endtimefriday1" class="form-control timeinput">
                </div>
                <div class="md-form fridayintervalslist display-none">
                    <span class="inlabel">Interval 2</span>
                    <label for="starttimefriday2">Start Time: </label>
                    <input type="time" id="starttimefriday2" name="starttimefriday2" class="form-control timeinput">
                    <label class="endlabel" for="endtimefriday2">End Time: </label>
                    <input type="time" id="endtimefriday2" name="endtimefriday2" class="form-control timeinput">
                </div>
                <div class="md-form fridayintervalslist display-none">
                    <span class="inlabel">Interval 3</span>
                    <label for="starttimefriday3">Start Time: </label>
                    <input type="time" id="starttimefriday3" name="starttimefriday3" class="form-control timeinput">
                    <label class="endlabel" for="endtimefriday3">End Time: </label>
                    <input type="time" id="endtimefriday3" name="endtimefriday3" class="form-control timeinput">
                </div>
                <div class="md-form fridayintervalslist display-none">
                    <span class="inlabel">Interval 4</span>
                    <label for="starttimefriday4">Start Time: </label>
                    <input type="time" id="starttimefriday4" name="starttimefriday4" class="form-control timeinput">
                    <label class="endlabel" for="endtimefriday4">End Time: </label>
                    <input type="time" id="endtimefriday4" name="endtimefriday4" class="form-control timeinput">
                </div>
                <div class="md-form fridayintervalslist display-none">
                    <span class="inlabel">Interval 5</span>
                    <label for="starttimefriday5">Start Time: </label>
                    <input type="time" id="starttimefriday5" name="starttimefriday5" class="form-control timeinput">
                    <label class="endlabel" for="endtimefriday5">End Time: </label>
                    <input type="time" id="endtimefriday5" name="endtimefriday5" class="form-control timeinput">
                </div>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="saturday" value="saturday" id="saturday">
                <label class="form-check-label" for="saturday">
                    Saturday
                </label>
                <div class="mb-3 display-none" id="saturdaytimeintervals">
                    <label class="form-label" for="saturdayintervals">Time Intervals: </label><input
                        type="number" name="saturdayintervals"  class="form-control timeinput" min="1" max="5" id="saturdayintervals">
                </div>

                <div class="md-form saturdayintervalslist display-none">
                    <span class="inlabel">Interval 1</span>
                    <label for="starttimesaturday1">Start Time: </label>
                    <input type="time" id="starttimesaturday1" name="starttimesaturday1" class="form-control timeinput">
                    <label class="endlabel" for="endtimesaturday1">End Time: </label>
                    <input type="time" id="endtimesaturday1" name="endtimesaturday1" class="form-control timeinput">
                </div>
                <div class="md-form saturdayintervalslist display-none">
                    <span class="inlabel">Interval 2</span>
                    <label for="starttimesaturday2">Start Time: </label>
                    <input type="time" id="starttimesaturday2" name="starttimesaturday2" class="form-control timeinput">
                    <label class="endlabel" for="endtimesaturday2">End Time: </label>
                    <input type="time" id="endtimesaturday2" name="endtimesaturday2" class="form-control timeinput">
                </div>
                <div class="md-form saturdayintervalslist display-none">
                    <span class="inlabel">Interval 3</span>
                    <label for="starttimesaturday3">Start Time: </label>
                    <input type="time" id="starttimesaturday3" name="starttimesaturday3" class="form-control timeinput">
                    <label class="endlabel" for="endtimesaturday3">End Time: </label>
                    <input type="time" id="endtimesaturday3" name="endtimesaturday3" class="form-control timeinput">
                </div>
                <div class="md-form saturdayintervalslist display-none">
                    <span class="inlabel">Interval 4</span>
                    <label for="starttimesaturday4">Start Time: </label>
                    <input type="time" id="starttimesaturday4" name="starttimesaturday4" class="form-control timeinput">
                    <label class="endlabel" for="endtimesaturday4">End Time: </label>
                    <input type="time" id="endtimesaturday4" name="endtimesaturday4" class="form-control timeinput">
                </div>
                <div class="md-form saturdayintervalslist display-none">
                    <span class="inlabel">Interval 5</span>
                    <label for="starttimesaturday5">Start Time: </label>
                    <input type="time" id="starttimesaturday5" name="starttimesaturday5" class="form-control timeinput">
                    <label class="endlabel" for="endtimesaturday5">End Time: </label>
                    <input type="time" id="endtimesaturday5" name="endtimesaturday5" class="form-control timeinput">
                </div>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="sunday" value="sunday" id="sunday">
                <label class="form-check-label" for="sunday">
                    Sunday
                </label>
                <div class="mb-3 display-none" id="sundaytimeintervals">
                    <label class="form-label" for="sundayintervals">Time Intervals: </label><input
                        type="number" name="sundayintervals"  class="form-control timeinput" min="1" max="5" id="sundayintervals">
                </div>

                <div class="md-form sundayintervalslist display-none">
                    <span class="inlabel">Interval 1</span>
                    <label for="starttimesunday1">Start Time: </label>
                    <input type="time" id="starttimesunday1" name="starttimesunday1" class="form-control timeinput">
                    <label class="endlabel" for="endtimesunday1">End Time: </label>
                    <input type="time" id="endtimesunday1" name="endtimesunday1" class="form-control timeinput">
                </div>
                <div class="md-form sundayintervalslist display-none">
                    <span class="inlabel">Interval 2</span>
                    <label for="starttimesunday2">Start Time: </label>
                    <input type="time" id="starttimesunday2" name="starttimesunday2" class="form-control timeinput">
                    <label class="endlabel" for="endtimesunday2">End Time: </label>
                    <input type="time" id="endtimesunday2" name="endtimesunday2" class="form-control timeinput">
                </div>
                <div class="md-form sundayintervalslist display-none">
                    <span class="inlabel">Interval 3</span>
                    <label for="starttimesunday3">Start Time: </label>
                    <input type="time" id="starttimesunday3" name="starttimesunday3" class="form-control timeinput">
                    <label class="endlabel" for="endtimesunday3">End Time: </label>
                    <input type="time" id="endtimesunday3" name="endtimesunday3" class="form-control timeinput">
                </div>
                <div class="md-form sundayintervalslist display-none">
                    <span class="inlabel">Interval 4</span>
                    <label for="starttimesunday4">Start Time: </label>
                    <input type="time" id="starttimesunday4" name="starttimesunday4" class="form-control timeinput">
                    <label class="endlabel" for="endtimesunday4">End Time: </label>
                    <input type="time" id="endtimesunday4" name="endtimesunday4" class="form-control timeinput">
                </div>
                <div class="md-form sundayintervalslist display-none">
                    <span class="inlabel">Interval 5</span>
                    <label for="starttimesunday5">Start Time: </label>
                    <input type="time" id="starttimesunday5" name="starttimesunday5" class="form-control timeinput">
                    <label class="endlabel" for="endtimesunday5">End Time: </label>
                    <input type="time" id="endtimesunday5" name="endtimesunday5" class="form-control timeinput">
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label" for="appointmentintervals">Appointment period: </label><input
                    type="number" name="appointmentintervals"  class="form-control timeinput" id="appointmentintervals">
            </div>




            <div class="mb-3">
                <input type="submit" class="form-control btn btn-primary" id="submit" value="Create">
            </div>
        </div>
    </form>
</div>

</body>
<script src="scripts/scripts.js"></script>
</html>
