<%--
  Created by IntelliJ IDEA.
  User: Saurabh
  Date: 4/3/2016
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="hiddenform" method="post">
    Enter the name: <input type="text" name="name"><br>
    Enter the password: <input type="text" name="pass"><br>
    <input type="submit">


</form>

<div>
    <p>
        Http is a stateless protocol. A client opens the connection and request some resources or information.
        The server response with the requested resource if available or sends error status and then closes the
        connection.
    </p>
    <p>
        After closing the connection the server does not remember any information about the client. So the server is
        considers the next request from same client as a fresh request, with no relation to previous requests. This is
        what makes http a stateless protocol.
    </p>
    <p>
        for implementing flexible business transaction across multiple request and response, we need two facilities:-
        1. session- the server should be able to identify that a series of requests are from a single working session.
        2. state - the server should be able to remember information related to the previous request and other business
        decisions that are made for the request.
    </p>
    <h3>how does the server know who the client is?</h3>
    <p>
        client needs a unique session ID. The idea is simple, on the client first request the containers generates a
        unique
        session ID and gives it back to the client with response.
    </p>

    <p>
        The client sent back the session ID with each subsequent request. The container sees the ID, finds the matching
        session and Associate the session with the request.
    </p>

    <h3>3 ways to track session</h3>
    <p> 1. cookies
        2. URL rewriting
        3. hidden form field

    </p>
    <h3>Cookies</h3>
    <p>

        cookies and special object which are used to store client related information on a client's machine.
        they will be attached automatically to the URL through which they are written in a browser.

        HttpSession session = request.getSession();

        through this method we asked the request for a session and the container we create or
        use session and take care of generating session ID, creating a new cookie object, stuffing the session ID in the
        cookie and sending the cookie as part of the response.

        everything is done by the container
        1. you dont make the new HttpSession object yourself
        2. you dont generate the unique session ID
        3. you don't make the new cookie object
        4. you don't associate the session ID with cookie
        5. you don't send cookie in the response
    </p>
    <h3>url rewriting</h3>
    <p>

        if cookies are not enabled in the
        browser, it means the client will never join the session. in other words the session isNew() always return true.
        a client with cookies disabled will ignore set-cookie response header. if that client will not take cookies, you
        can use URL rewriting as a backup. We add the session ID to the end of all urls. In the HTML we send back in the
        response. URL rewriting kicks in only if cookies fail and only if you ask response to encode the URL.
        for encoding the URL use the following method of http servlet response methods

    </p>
    <h3>hidden form field</h3>
    <p>

        it is similar to URL rewriting but in this case each request should include a form submission.
    </p>

    <h3> there are three ways in which session Can Die</h3>
    <p>

        1. it timeout
        2. you called invalidate() on session object
        3. application goes down
    </p>
</div>
</body>
</html>
