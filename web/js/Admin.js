//(function () {
//    var $listaUsuarios = $('.js-listaUsuarios');
//   
//    $.post('ListaUsuarios', {//muestra el select de las salas existentes
//    }, function (responseText) {
//        $listaUsuarios.html("responseText");
//    });
//    
// })();   
    function DatosModificarUsuario(){
        var nombre = $('#nombreUsuario').val();
        $.post('ListaUsuarios', {  
            op : 3,
            mUsuario : nombre
        }, function(responseText){
            $('#modificarUsuario').html(responseText);
        });
    }
    
    function MostrarInfoUsuario(){
        var nombre = $('#elimUsuario').val();
        $.post('ListaUsuarios', {  
            op : 3,
            eUsuario : nombre
        }, function(responseText){
            $('#infoUsuarioEliminar').html(responseText);
        });
    }
    
    function MostrarInfoProducto(){
        var productoID = $('#elimProducto').val();
        $.post('ListaUsuarios', {  
            op : 5,
            eProducto : productoID
        }, function(responseText){
            $('#infoProductoEliminar').html(responseText);
        });
    }
    
    function ModificarInfoProducto(){
        var productoIDm = $('#modProducto').val();
        $.post('ListaUsuarios', {  
            op : 7,
            mProducto : productoIDm
        }, function(responseText){
            $('#infoProductoModificar').html(responseText);
        });
    }
    
$(document).ready(function(){
    listaUsuarios();
    listaProductos();
    listaNombreUsuarios();
    listaNombreUsuariosEliminar();
    listaProductosEliminar();
    listaProductosModificar();
    
    function listaUsuarios(){
        $.post('ListaUsuarios', {  
            op : 1
        }, function(responseText){
            $('#listaSucursal').html(responseText);
        });
    }
    
    function listaProductos(){
        $.post('ListaUsuarios', {  
            op : 8
        }, function(responseText){
            $('#listaProductos').html(responseText);
        });
    }
    
    function listaNombreUsuarios(){
        $.post('ListaUsuarios', {  
            op : 2
        }, function(responseText){
            $('#listaNombreUsuarios').html(responseText);
        });
    }
    
    function listaNombreUsuariosEliminar(){
        $.post('ListaUsuarios', {  
            op : 2
        }, function(responseText){
            $('#listaNombreUsuariosEliminar').html(responseText);
        });
    }
    
    function listaProductosEliminar(){
        $.post('ListaUsuarios', {  
            op : 4
        }, function(responseText){
            $('#listaProductosEliminar').html(responseText);
        });
    }
    
    function listaProductosModificar(){
        $.post('ListaUsuarios', {  
            op : 6
        }, function(responseText){
            $('#listaProductosModificar').html(responseText);
        });
    }
});