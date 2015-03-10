<!DOCTYPE html>
<html>
<head>
    <title>NS TEST</title>

    <script src="js/jquery-2.1.3.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui-1.11.3/jquery-ui.min.js" type="text/javascript"></script>

    <style>
        .obrigatorio {
            outline-color: #000000;
        }
        .form-input {
            font-family: Verdana,Arial,Helvetica,sans-serif;
            font-size: 11px;
            font-weight: 400;
            padding: 2px;
            border-width: 3px;
            display: block;
        }
    </style>

    <!-- serializar form em json -->
    <script src="js/jquery.serializeObject.min.js" type="text/javascript"></script>

    <script>
        $(document).ready(function() {

            $.support.cors = true;

            // Using jQuery
            $.ajaxSetup({
                xhrFields: {
                    withCredentials: true
                }
            });

            $('#botaoCep').click(function (e) {

                //limparCampos
                limparCampos();

                var cep = $('#cep').val().trim();
                if (!validaCep(cep)) {
                    return;
                }

                //Url do servico
                //var url = "http://54.207.15.43:8080/nsRest/rest/servicoCEP/consultar/" + $('#cep').val(); //Amazon
                //var url = "http://localhost:9999/rest/servicoCEP/consultar/" + $('#cep').val(); //Teste Local


                //consulta cep
                $.ajax({
                    url : 'consultarCEP',
                    type : 'GET',
                    data : 'cep=' + $('#cep').val(),
                    dataType: 'json',
                    success: function(data){
                        if(data.status == "OK"){
                            $('#cep').val(data.result.id);
                            $('#rua').val(data.result.rua);
                            $('#cidade').val(data.result.cidade);
                            $('#estado').val(data.result.estado);
                            $('#numero').focus();
                            $('#mensagemErro').html("");

                        } else {
                            $('#mensagemErro').html(data.status);
                        }
                    },
                    error: function(xhr, status, error) {
                        console.log("erro: " + error);
                        $('#mensagemErro').html("Erro ao processar insert!");
                    }
                });
                return false;
            });

            $('#botaoEnviar').click(function (e) {

                var cep = $('#cep').val().trim();
                if (!validaCep(cep)) {
                    return false;
                }

                //Valida dados
                var cont = 0;
                $('.obrigatorio').each(function(index, ele){
                    if ($(ele).val() == "") {
                        cont++;
                    }
                });

                if (cont > 0) {
                   alert("Preencher todos os campos obrigatórios (*).");
                    return false;

                } else {

                    var data = $("#form").serializeObject();

                    //realiza cadastro
                    //consulta cep
                    $.ajax({
                        url : "incluirEndereco",
                        type : 'POST',
                        dataType: 'json',
                        data : data,
                        success: function(data){
                            if(data.Result == "OK"){
                                document.location.href = "index.jsp";
                            } else {
                                $('#mensagemErro').html(data.Result);
                            }
                        },
                        error: function(xhr, status, error) {
                            console.log("erro: " + error);
                            $('#mensagemErro').html("Erro no processamento!");
                        }
                    });
                }
            });

            function validaCep(cep) {
                if (cep == "") {
                    alert("Preencher o CEP!");
                    $('#cep').focus();
                    return false;
                } else {
                    //formato do cep 99999999
                    var regEx = /^[0-9]{5}[0-9]{3}$/;
                    if (!regEx.test(cep)) {
                        alert("Formato inválido!\nUtilizar o formato: 99999999.");
                        $('#cep').focus();
                        return false;
                    }
                }
                return true;
            }

            function limparCampos() {
                $('input').each(function(index, ele){
                    if ($(ele).attr('name') != "cep"
                            && $(ele).attr('name') != "wsUrl") {
                        $(ele).val("");
                    }
                });
            }

        });

    </script>

</head>
<body>
<div>
    <h2>Incluir endereço</h2>

    <div style="width: 800px; padding: 2px">

        <div><span id="mensagemErro" style="color: red"></span></div>

        <form id="form">
            <div class="form-input">
                <b>CEP*:</b> <input type="text" name="cep" id="cep" maxlength="8" width="100px" class="obrigatorio"> <button type="button" name="botaoCep" id="botaoCep">Consultar CEP</button><br/>
            </div>
            <div class="form-input">
                <b>Rua*:</b> <input type="text" name="rua" id="rua" maxlength="50" style="width: 300px" class="obrigatorio">&nbsp;
                <b>Número*:</b> <input type="text" name="numero" id="numero" maxlength="5" style="width: 50px" class="obrigatorio">
            </div>
            <div class="form-input">
                <b> Cidade*:</b> <input type="text" name="cidade" id="cidade"  maxlength="20" style="width: 200px" class="obrigatorio">&nbsp;
                <b> Estado*:</b> <input type="text" name="estado" id="estado"  maxlength="2" style="width: 50px" class="obrigatorio">
            </div>
            <div class="form-input">
                <b> Bairro:</b> <input type="text" name="bairro" id="bairro"  maxlength="20" style="width: 180px">&nbsp;
                <b> Complemento:</b> <input type="text" name="complemento" id="complemento" maxlength="50" style="width: 180px">
            </div>
        </form>
        <br>
        <div>
        <a href="index.jsp"><button type="button" name="botaoVoltar" id="botaoVoltar">Voltar</button></a>
        &nbsp;<button type="button" name="botaoEnviar" id="botaoEnviar">Enviar</button>
        </div>

        </div>
        <br>
        <div><b>* Campos Obrigatórios</b></div>
    </div>

</div>
</body>
</html>