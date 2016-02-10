<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Freelancer - Start Bootstrap Theme</title>

        <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/freelancer.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="css/personalizada.css" rel="stylesheet" type="text/css">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        
        <!-- boton subir archivo-->
        <link href="css/botones.css" rel="stylesheet" type="text/css">

        <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    </head>

    <body id="page-top" class="index">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-fixed-top" id="color-nav">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <img src="img/logoEscom.png" class="navbar-left"/>
                    <a class="navbar-brand" id="color-titulo" style="margin-left: 15px;" href="#page-top">Escuela Superior de Cómputo</a>
                </div>
            </div>
            <!-- /.container-fluid -->
        </nav>

        <!-- Header -->
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!--<img class="img-responsive" src="img/profile.png" alt="">-->
                        <div class="intro-text">
                            <span class="name" id="titulo">Sistema de evaluación institucional para la equidad de género</span>
                            <br/>
                            <span class="name" id="titulo">Registro SIP: 20151405</span>
                            <hr class="star-light">
                        </div>
                        <form action="LogicaArchivos" method="post" enctype="multipart/form-data" name="formData">
                            <br/>
                            <img src="img/n1.png" class="numero1"/>
                            <label style="margin-left: 10px;">Selecciona el archivo(xls) a analizar:</label>
                            <div style="margin-top:5px;">
                                <input type="file" name="excel" id="file-5" class="inputfile inputfile-4"/>
                                <label for="file-5">
                                    <figure>
                                        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17">
                                        <path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z">
                                        </path>
                                        </svg>
                                    </figure>
                                    <span>Subir archivo&hellip;</span></label>
                            </div>
                            <img src="img/n2.png" class="numero2"/>
                            <label style="margin-left: 10px;">Genera el reporte:</label>
                            <br/>
                            <input type="submit" value="Generar PDF" class="btn btn-lg btn-outline"/>
                        </form>
                    </div>
                </div>
            </div>
        </header>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="js/freelancer.js"></script>

        <!-- boton subir archivo-->
        <script src="js/custom-file-input.js"></script>
    </body>

</html>
