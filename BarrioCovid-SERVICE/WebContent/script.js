$(document).ready(function(){

    $.ajax({

        url: '/BarrioCovid-SERVICE/rest/COVID',

        type: 'get',

        dataType: 'JSON',

        success: function(response){

            var len = response.length;

            for(var i=0; i<len; i++){

                var email = response[i].email;

                var name = response[i].name;

              

                var tr_str = "<tr>" +

                    "<td align='center'>" + email + "</td>" +

                    "<td align='center'>" + name + "</td>" +


                    "</tr>";


                $("#userTable tbody").append(tr_str);

            }


        }

    });

});