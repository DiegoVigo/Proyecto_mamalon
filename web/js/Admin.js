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
    
    function listaProductosAlmacen(){
        $.post('Listas', {  
            op : 6
        }, function(responseText){
            $('#listaProductosAlmacen').html(responseText);
        });
    }
    
    function listaAlmacenTo(){
        var a_from = $('#AlmacenFrom').val();
        $.post('Listas', {  
            almacenFrom : a_from,
            op : 8
        }, function(responseText){
            $('#listaAlmacenTo').html(responseText);
        });
    }
    
    function MostrarInfoProductoAlmacen(){
        var a_from = $('#AlmacenFrom').val();
        var p_id = $('#AlmacenProductoID').val();
        $.post('MostrarInformacion', {  
            almacenFrom : a_from,
            productoID : p_id,
            op : 4
        }, function(responseText){
            $('#infoProductoAlmacen').html(responseText);
        });
    }
    
    function MostrarInfoProductoTienda(){
        var a_from = $('#Tienda').val();
        var p_id = $('#TiendaProductoID').val();
        $.post('MostrarInformacion', {  
            almacenFrom : a_from,
            productoID : p_id,
            op : 4
        }, function(responseText){
            $('#infoProductoTienda').html(responseText);
        });
    }
    
    
$(document).ready(function(){
    listaUsuarios();
    listaProductos();
    listaProductosAlmacen();
    listaNombreUsuarios();
    listaNombreUsuariosEliminar();
    listaProductosEliminar();
    listaProductosModificar();
    listaAlmacenFrom();
    listaTienda();
    listaTiendaProducto();
    
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
    
    function listaAlmacenFrom(){
        $.post('Listas', {  
            op : 7
        }, function(responseText){
            $('#listaAlmacenFrom').html(responseText);
        });
    }
    function listaTienda(){
        $.post('Listas', {  
            op : 9
        }, function(responseText){
            $('#listaTienda').html(responseText);
        });
    }
    function listaTiendaProducto(){
        $.post('Listas', {  
            op : 10
        }, function(responseText){
            $('#listaTiendaProducto').html(responseText);
        });
    }
});