$(document).ready(function() {
    $('#tabelaResultados').jtable({
        title : 'Lista de Endereços',
        actions : {
            listAction : 'listarEnderecos',
            deleteAction : 'apagarEndereco',
            updateAction : 'atualizarEndereco'
        },
        fields : {
            id : {
                title : 'Id',
                width : '5%',
                key : true,
                list : true,
                edit : false,
                create : false
            },
            cep : {
                title : 'CEP',
                width : '20%',
                edit : true
            },
            rua : {
                title : 'Rua',
                width : '30%',
                edit : true
            },
            numero : {
                title : 'Número',
                width : '10%',
                edit : true
            },
            cidade : {
                title : 'Cidade',
                width : '20%',
                edit : true
            },
            estado : {
                title : 'UF',
                width : '5%',
                edit : true
            },
            bairro : {
                title : 'Bairro',
                width : '20%',
                edit : true
            },
            complemento : {
                title : 'Complemento',
                width : '20%',
                edit : true
            }
        }
    });

    $('#tabelaResultados').jtable('load');
});