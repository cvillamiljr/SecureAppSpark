var apiclient =(function (){

    function getValues(){
        var pas= document.getElementById("contrasena").value;
        window.alert(pas);

    }

    return{
        getData:getValues()
    }

})();