$(document).ready(function(){
    $("#update_odontologo_form").submit(function(evt) {
        evt.preventDefault();
        try {
            let odontologoId = $("#odontologo_id").val();
            
        let formData = {
            id: $("#odontologo_id").val(),
            name : $("#nombre").val(),
            lastname :  $("#apellido").val(),
            enrollment : $("#matricula").val(),
        }
            
            $.ajax({
                url: '/api/dentist/update',
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                //async: false,
                //cache: false,
                success: function (response) {
                    let odontologo = response;
        
                    let successAlert = '<div class="alert alert-success alert-dismissible">' + 
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong>Dentist Updated</strong></div>'

                 
                    $("#tr_" + odontologoId + " td.td_first_name").text(odontologo.name.toUpperCase());
                    $("#tr_" + odontologoId + " td.td_last_name").text(odontologo.lastname.toUpperCase());
                    $("#tr_" + odontologoId + " td.td_matricula").text(odontologo.enrollment);

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' + 
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong> Error </strong></div>';

                    $("#response").empty();                                    
                    $("#response").append(errorAlert);
                    $("#response").css({"display": "block"});
                }
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_id", function(){
        let id_of_button = (event.srcElement.id);
        let odontologoId = id_of_button.split("_")[2];
  
        $.ajax({
            url: 'api/dentist/' + odontologoId,
            type: 'GET',
            success: function(response) {
                let odontologo = response;                
                $("#odontologo_id").val(odontologo.id);
                $("#nombre").val(odontologo.name);
                $("#apellido").val(odontologo.lastname);
                $("#matricula").val(odontologo.enrollment);
                $("#div_odontologo_updating").css({"display": "block"});
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });        
    });
});