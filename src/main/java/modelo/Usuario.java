/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author SAID
 */
public class Usuario {
    
     private int idusuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String rol;
    
    
    
     public Usuario(){
    
    this.idusuario=idusuario=0;
    this.nombre=nombre="";
    this.apellido=apellido="";
    this.usuario=usuario="";
    this.password=password="";
    this.rol=rol="";
    }

    public Usuario(int idusuario, String nombre, String apellido, String usuario, String password, String rol) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
     
     
     
    
    
    
    
    
}
