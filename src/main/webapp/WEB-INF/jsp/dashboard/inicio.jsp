<%-- 
    Document   : inicio
    Created on : 3/07/2019, 04:30:56 PM
    Author     : deivi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title></title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </head>
    
        ${estilo}
    
    <body id="principal">

        <nav class="navbar navbar-light bg-light">
          <a class="navbar-brand" href="#">
            <img src="../complementos/img/eclipse.svg" width="50" height="50" alt="">
          </a>
          <a href="${pageContext.request.contextPath}/"><i class="fa fa-power-off"></i> Salir</a>
        </nav>
        <h1>Bienvenido!</h1>

        ${dashboard}

        <footer class="row">
            <div class="col-md-6">
                <p>© Copyright no one at all. Go to town.</p>
            </div>
            <div class="col-md-6">
                <ul class="nav nav-pills pull-right">
                    <li><a href="#">Section 1</a></li>
                    <li><a href="#">Section 2</a></li>
                    <li><a href="#">Section 3</a></li>
                    <li><a href="#">Section 4</a></li>
                    <li><a href="#">Section 5</a></li>
                    <li><a href="#">Section 6</a></li>
                </ul>
            </div>
        </footer>

        <script>

            $( document ).ready(function() {
                var col1 = "${color1}";
                var split1 = col1.split(',')[0] + "CC";
                var split2 = col1.split(',')[0];
                //console.log("1: " + split1 + " 2: " + split2);

                document.getElementById('principal').style.backgroundColor = col1.split(',')[1] + "3F";
                document.getElementById('color1').style.backgroundColor = col1.split(',')[0];
                document.getElementById('color2').style.backgroundColor = col1.split(',')[0] + "5C";

                if (document.getElementById('color3') !=null) {
                    document.getElementById('color3').style.backgroundColor = col1.split(',')[0] + "CC";
                }

                if (document.getElementById('color4') !=null) {
                    document.getElementById('color4').style.backgroundColor = col1.split(',')[0] + "1F";
                }
                
                if (document.getElementById('color5') !=null) {
                    document.getElementById('color5').style.backgroundColor = col1.split(',')[0] + "82";
                }

                if (document.getElementById('color6') !=null) {
                    document.getElementById('color6').style.backgroundColor = col1.split(',')[0] + "2A";
                }
                
            });
            
        </script>

    </body>
</html>
