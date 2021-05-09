/**
 * muestra una tabla con todos los USUARIOs de la base de datos.
 */
$(document).ready(function(){
    $.ajax({
        url: '/BarrioCovid-SERVICE/rest/USUARIOs',
        type: 'get',
        dataType: 'JSON',
        success: function(response){
            var len = response.length;
            for(var i=0; i<len; i++){
                var email = response[i].email;
                var zona = response[i].zona;
                var direccion = response[i].direccion;
                var rol = response[i].rol;
                var pedidosRealizados = response[i].pedidosRealizados;
                var pedidosEntregados = response[i].pedidosEntregados;
                var idUsuario = response[i].idUsuario;
                var tr_str = "<tr>" +
                    "<td align='center'>" + email + "</td>" +
                    "<td align='center'>" + zona + "</td>" +
                    "<td align='center'>" + direccion + "</td>" +
                    "<td align='center'>" + rol + "</td>" +
                    "<td align='center'>" + pedidosRealizados + "</td>" +
                    "<td align='center'>" + pedidosEntregados + "</td>" +
                    "<td align='center'>" + idUsuario + "</td>" +
                    "</tr>";
                $("#userTable tbody").append(tr_str);
            }
        }
    });
});