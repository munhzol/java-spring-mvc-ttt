<html>
    <head>
        <title>My JSP Page</title>
        <script defer src="/demo2/static/js/main.js"></script>

        <style>
            .btnTT {
            width: 40px;   /* button width */
            height: 40px;   /* button height */
            }

            #result {
                color: red;
            }
        </style>
    </head>
<body>
    
<h2>Tic Tac Toe!</h2>
<table>
    <tr>
        <td><button class="btnTT" id="0"></button></td>
        <td><button class="btnTT" id="1"></button></td>
        <td><button class="btnTT" id="2"></button></td>
    </tr>
    <tr>
        <td><button class="btnTT" id="3"></button></td>
        <td><button class="btnTT" id="4"></button></td>
        <td><button class="btnTT" id="5"></button></td>
    </tr>
    <tr>
        <td><button class="btnTT" id="6"></button></td>
        <td><button class="btnTT" id="7"></button></td>
        <td><button class="btnTT" id="8"></button></td>
    </tr>
</table>

<!-- <button id="btnFirstinJava">Click Me</button>
<button id="btnSecond">btnSecond</button> -->
<div><button id="btnReset">Reset</button></div>
<div id="result"></div>

</body>
</html>
