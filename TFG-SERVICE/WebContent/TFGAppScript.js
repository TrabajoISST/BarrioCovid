$(document).ready(function(){

    $.ajax({

        url: '/TFG-SERVICE/rest/TFGs',

        type: 'get',

        dataType: 'JSON',

        success: function(response){

            var len = response.length;

            for(var i=0; i<len; i++){

                var email = response[i].email;

                var name = response[i].name;

                var title = response[i].title;

                var status = response[i].status;
                
                var document = response[i].document;
                
                var mark = response[i].mark;


                var advisor = response[i].advisor;

                var tr_str = "<tr>" +

                    "<td align='center'>" + email + "</td>" +

                    "<td align='center'>" + name + "</td>" +

                    "<td align='center'>" + title + "</td>" +

                    "<td align='center'>" + status + "</td>" +

                    "<td align='center'>" + mark + "</td>" +
                    "<td align='center'>" + advisor + "</td>" +

                    "</tr>";


                $("#userTable tbody").append(tr_str);

            }


        }

    });

});