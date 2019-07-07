<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">


        <link rel="icon" type="image/png" sizes="16x16" href="complementos/img/eclipse.png">
        <title>Hackapalooza</title>
        <!-- Bootstrap Core CSS -->
        <link href="complementos/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="complementos/css/styles.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <script src="complementos/js/jquery.js"></script>
        <script src="complementos/js/test.js"></script>
        <script src="complementos/js/randomColor.js"></script>

    </head>

    <style media="screen">
        /* Generated from SCSS and GULP autoprefixer */
        html,
        body {
            height: 100%
        }

        .can{

        margin-left: 25%;

        }

        .login__group{

          text-align: center;
          padding-top: 1%;
          padding-bottom:1%;

        }

        body {
            display: -webkit-box;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-align: start;
            -ms-flex-align: start;
            align-items: flex-start
        }
        .login__form {
            background: #fff;
            color: #333;
            font-family: "Open Sans", sans-serif;
            border-radius: 5px
        }
        .login__form .login__header {
            padding-top: 30px;
            text-align: center;
            margin-bottom: 60px
        }
        .login__form .login__header .login__title {
            font-size: 24px;
            font-weight: 400
        }
        .login__form .login__main {
            max-width: 80%;
            margin-left: auto;
            margin-right: auto
        }
        .login__form .login__main .login__group {
            position: relative
        }
        .login__form .login__main .login__group .login__input {
            margin-top: 50px;
            padding: 10px 10px 10px 5px;
            color: #333;
            font-family: "Open Sans", sans-serif;
            width: 100%;
            font-size: 16px;
            display: block;
            border: none;
            border-bottom: 1px solid #d0dce7;
            -webkit-box-sizing: border-box;
            box-sizing: border-box
        }
        .login__form .login__main .login__group .login__input:focus {
            outline: none
        }
        .login__form .login__main .login__group .login__input:focus ~ label,
        .login__form .login__main .login__group .login__input:valid ~ label {
            top: -20px;
            font-size: 12px;
            text-transform: uppercase
        }
        .login__form .login__main .login__group .login__label {
            color: #333;
            font-family: "Open Sans", sans-serif;
            font-size: 16px;
            font-weight: 400;
            position: absolute;
            pointer-events: none;
            left: 5px;
            top: 10px;
            -webkit-transition: .2s ease all;
            transition: .2s ease all
        }
        .login__form .login__main .login__terms {
            font-size: 14px;
            color: #a8b8c4;
            margin: 40px auto;
            line-height: 19px;
        }
        .login__form .login__main .login__terms a {
            text-decoration: none;
            color: #98b28c;
        }
        .login__form .login__button {
            font-family: "Open Sans", sans-serif;
            font-weight: 700;
            text-transform: uppercase;
            width: 100%;
            background: #98b28c;
            border: none;
            border-radius: 5px;
            color: #fff;
            height: 45px;
            font-size: 14px;
            bottom: 0;
            position: absolute
        }

        .login__button:hover {
          cursor: pointer;
        }

        .login__bar {
            position: relative;
            display: block
        }
        .login__bar:before,
        .login__bar:after {
            content: '';
            height: 2px;
            width: 0;
            bottom: 1px;
            position: absolute;
            background: #007ee5;
            transition: .2s ease all;
            -moz-transition: .2s ease all;
            -webkit-transition: .2s ease all
        }
        .login__bar:before {
            left: 50%
        }
        .login__bar:after {
            right: 50%
        }
        input:focus ~ .login__bar:before,
        input:focus ~ .login__bar:after {
            width: 50%
        }
        @media (min-width: 620px) {
            body {
                background: url("https://unsplash.it/800/410") no-repeat;
                background-attachment: fixed;
                background-position: center;
                background-size: cover;
                -webkit-box-align: center;
                -ms-flex-align: center;
                align-items: center
            }
            .login__form {
                max-width: 400px;
                height: auto;
                margin-left: auto;
                margin-right: auto;
                padding-bottom: 3%;
                width: 80%!important;
            }
            .login__title {
                position: relative
            }
            .login__footer {
                text-align: center
            }
            .login__footer .login__button {
                bottom: initial;
                position: initial;
                width: 320px
            }
        }

    </style>

    <body >
        
        <!--<header class="navbar navbar-dark bg-dark">
            <a class="navbar-brand" href="#">
              <img src="complementos/img/eclipse.svg" width="100" height="100" alt="">
            </a>
        </header>-->

        <form class="login__form" method="POST" name="form" action="#">
           <header class="login__header">
             <div class="col">
               <div class="col">
                 <video id="video" width="100%" height="300" autoplay></video>
               </div>

               <div class="col can" style="display: none">
                 <canvas id="canvas" width="360" height="80"></canvas>
               </div>


             </div>
              <h1 class="login__title">Login</h1>
           </header>
           <main class="login__main">
              <div class="login__group">
                 <button type="button" class="btn btn-info" id="snap">Tomar Foto</button>
              </div>
              <!--<div class="login__group">
                 <button type="button" class="btn btn-info" id="btndownload" >Descargar</button>
              </div>-->
              <p class="login__terms">Al entrar acepta los <a href="#">Terminos</a> y la <a href="#">Politica de privacidad</a></p>
           </main>
           <footer class="login__footer">

           </footer>
        </form>  

        <!--<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
            <input type="file" name="image"/><br/><br/>
            <input type="submit" value="Submit" id="btnSubmit"/>
        </form>-->

    </body>

    <script>
        
        $(document).ready(function () {

    $("#btnSubmit").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        // Get form
        var form = $('#fileUploadForm')[0];

        // Create an FormData object 
        var data = new FormData(form);

        // If you want to add an extra field for the FormData
        data.append("CustomField", "This is some extra data, testing");

        // disabled the submit button
        $("#btnSubmit").prop("disabled", true);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "http://localhost:8080/HackaProject/nuevoPost",
            //url: "http://max-facial-emotion-classifier.max.us-south.containers.appdomain.cloud/model/predict",
            //url: "http://max-facial-age-estimator.max.us-south.containers.appdomain.cloud/model/predict",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                //console.log(data);
                var valores = JSON.stringify(data);
                console.log(valores);
                

            },
            error: function (e) {

                console.log("ERROR : " + e);

            }
        });

    });

});

    </script>

    <script>

        // Grab elements, create settings, etc.
        var video = document.getElementById('video');

        // Get access to the camera!
        if(navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
            // Not adding `{ audio: true }` since we only want video now
            navigator.mediaDevices.getUserMedia({ video: true }).then(function(stream) {
                //video.src = window.URL.createObjectURL(stream);
                video.srcObject = stream;
                video.play();
            });
        }

        // Elements for taking the snapshot
        var canvas = document.getElementById('canvas');
        var context = canvas.getContext('2d');
        var video = document.getElementById('video');


        // Trigger photo take
        document.getElementById("snap").addEventListener("click", function() {
            context.drawImage(video, 0, 0, 160, 80);

            var dataURL = canvas.toDataURL();
            /*var data = new FormData();
            data.append("image", imagen);*/

            var blobBin = atob(dataURL.split(',')[1]);
            var array = [];
            for(var i = 0; i < blobBin.length; i++) {
                array.push(blobBin.charCodeAt(i));
            }
            var file=new File([new Uint8Array(array)],"foto.png", {type: "application/octet-stream"});


            var formdata = new FormData();
            formdata.append("image", file);
            //console.log("imagen: " + img);

            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "http://localhost:8080/HackaProject/nuevoPost",
                //url: "http://max-facial-emotion-classifier.max.us-south.containers.appdomain.cloud/model/predict",
                //url: "http://max-facial-age-estimator.max.us-south.containers.appdomain.cloud/model/predict",
                data: formdata,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {

                    //console.log(data);
                    //var valores = JSON.stringify(data);
                    window.location = "http://localhost:8080/HackaProject/dashboard/inicio";
                    //console.log(data);
                    

                },
                error: function (e) {

                    console.log("ERROR : " + e);

                }
            });
        });


    </script>

    <script type="text/javascript">
        // Initializing
        /*window.onload = function(){
            var dwn = document.getElementById('btndownload'),
            canvas = document.getElementById('canvas'),
            context = canvas.getContext('2d');

            // Event handler for download
            dwn.onclick = function(){
            download(canvas, 'myimage.png');
            }
        }*/

        /* Canvas Donwload */
        function download(canvas, filename) {

            /// create an "off-screen" anchor tag
            var lnk = document.createElement('a'), e;

            /// the key here is to set the download attribute of the a tag
            lnk.download = filename;

            /// convert canvas content to data-uri for link. When download
            /// attribute is set the content pointed to by link will be
            /// pushed as "download" in HTML5 capable browsers
            lnk.href = canvas.toDataURL("image/png;base64");

            /// create a "fake" click-event to trigger the download
            if (document.createEvent) {
                e = document.createEvent("MouseEvents");
                e.initMouseEvent("click", true, true, window,
                0, 0, 0, 0, 0, false, false, false,
                false, 0, null);

                lnk.dispatchEvent(e);
            } else if (lnk.fireEvent) {
                lnk.fireEvent("onclick");
            }
        }
    </script>

</html>