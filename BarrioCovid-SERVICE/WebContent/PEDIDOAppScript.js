/**
 * muestra una tabla con todos los PEDIDOs de la base de datos.
 */
$(document).ready(function(){
    $.ajax({
        url: '/BarrioCovid-SERVICE/rest/PEDIDOs',
        type: 'get',
        dataType: 'JSON',
        success: function(response){
            var len = response.length;
            for(var i=0; i<len; i++){
                var comprador = response[i].comprador;
                var vendedor = response[i].vendedor;
                var voluntario = response[i].voluntario;
                var idped = response[i].idped;
                var status = response[i].status;
                var tr_str = "<tr>" +
                    "<td align='center'>" + comprador + "</td>" +
                    "<td align='center'>" + vendedor + "</td>" +
                    "<td align='center'>" + voluntario + "</td>" +
                    "<td align='center'>" + idped + "</td>" +
                    "<td align='center'>" + status + "</td>" +
                    "</tr>";
                $("#userTable tbody").append(tr_str);
            }
        }
    });
});