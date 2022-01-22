/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaban;

/**
 *
 * @author Usuario
 */
public class Datos {
    private String fecha;
    private String Nombres;
    private String Apellidos;
    private int tele;
    private String direcc;
    private String ciuda;
    private float monto;
    
    public Datos (){
        
    }

    public Datos(String fecha, String Nombres, String Apellidos, int tele, String direcc, String ciuda, float monto) {
        this.fecha = fecha;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.tele = tele;
        this.direcc = direcc;
        this.ciuda = ciuda;
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public String getDirecc() {
        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }

    public String getCiuda() {
        return ciuda;
    }

    public void setCiuda(String ciuda) {
        this.ciuda = ciuda;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    
    
}
