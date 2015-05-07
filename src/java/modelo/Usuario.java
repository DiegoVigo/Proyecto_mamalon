package modelo;

/**
 *
 * @author jviveros
 */
public class Usuario {
    private String UsuarioID;
    private String UsuarioNombre;
    private String Rol;
    private String Contrasena;
    private String SucursalID;
    
    public Usuario(){}
    public Usuario(String usuarioID,  String usuarionombre, String rol, 
                   String contrasena, String sucursalID){
        this.UsuarioID = usuarioID;
        this.UsuarioNombre = usuarionombre;
        this.Rol = rol;
        this.Contrasena = contrasena;
        this.SucursalID = sucursalID;
    }
    public String getUsuarioID(){
        return UsuarioID;
    }
    public String getUsuarioNombre(){
        return UsuarioNombre;
    }
    public String getRol(){
        return Rol;
    }
    public String getContrasena(){
        return Contrasena;
    }
    public String getSucursalID(){
        return SucursalID;
    }
}
