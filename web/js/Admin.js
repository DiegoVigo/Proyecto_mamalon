    function MostrarInfoUsuario(){
        var nombre = $('#elimUsuario').val();
        $.post('MostrarInformacion', {  
            op : 1,
            eUsuario : nombre
        }, function(responseText){
            $('#infoUsuarioEliminar').html(responseText);
        });
    }
    
    function MostrarInfoProducto(){
        var productoID = $('#elimProducto').val();
        $.post('MostrarInformacion', {  
            op : 2,
            eProducto : productoID
        }, function(responseText){
            $('#infoProductoEliminar').html(responseText);
        });
    }
    
    function ModificarInfoProducto(){
        var productoIDm = $('#modProducto').val();
        $.post('MostrarInformacion', {  
            op : 3,
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
        $.post('Listas', {  
            op : 1
        }, function(responseText){
            $('#listaSucursal').html(responseText);
        });
    }
    
    function listaProductos(){
        $.post('Listas', {  
            op : 5
        }, function(responseText){
            $('#listaProductos').html(responseText);
        });
    }
    
    function listaNombreUsuarios(){
        $.post('Listas', {  
            op : 2
        }, function(responseText){
            $('#listaNombreUsuarios').html(responseText);
        });
    }
    
    function listaNombreUsuariosEliminar(){
        $.post('Listas', {  
            op : 2
        }, function(responseText){
            $('#listaNombreUsuariosEliminar').html(responseText);
        });
    }
    
    function listaProductosEliminar(){
        $.post('Listas', {  
            op : 3
        }, function(responseText){
            $('#listaProductosEliminar').html(responseText);
        });
    }
    
    function listaProductosModificar(){
        $.post('Listas', {  
            op : 4
        }, function(responseText){
            $('#listaProductosModificar').html(responseText);
        });
    }
});