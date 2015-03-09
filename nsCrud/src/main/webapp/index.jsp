<!DOCTYPE html>
<html>
<head>
    <title>NS TEST</title>

    <link href="js/jtable.2.4.0/themes/lightcolor/blue/jtable.min.css" rel="stylesheet" type="text/css" />
    <link href="js/jquery-ui-1.11.3/jquery-ui.min.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-2.1.3.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui-1.11.3/jquery-ui.min.js" type="text/javascript"></script>
    <script src="js/jtable.2.4.0/jquery.jtable.min.js" type="text/javascript"></script>

    <!-- Mensagens personalizadas do jTable -->
    <script src="js/jtable.2.4.0/localization/jquery.jtable.pt-BR.js" type="text/javascript"></script>

    <script src="js/tabela.js" type="text/javascript"></script>

    <script>
        $(document).ready(function() {

            $('#botaoPesquisar').click(function (e) {
                e.preventDefault();
                $('#tabelaResultados').jtable('load', {

                });
            });

        });
    </script>

</head>
<body>
<div>
    <h2>Consulta endereços</h2>
    <br>
    <div style="width: 800px">
        <div id="tabelaResultados"></div>
        <br>
        <div align="right">
            <a href="incluir.jsp"><button type="button"> Incluir Novo</button></a>&nbsp;
            <button type="submit" id="botaoPesquisar">Pesquisar</button>
        </div>
    </div>
</div>
</body>
</html>