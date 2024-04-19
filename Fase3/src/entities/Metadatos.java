/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Jose Luis Ochoa
 */
public class Metadatos {
    private String uuid;
    private String rfcEmisor;
    private String nombreEmisor;
    private String rfcReceptor;
    private String nombreReceptor;
    private String rfcPac;
    private String fechaEmision;
    private String fechaCertificacionSat;
    private String monto;
    private String efectoComprobante;
    private String estatus;
    private String fechaCancelacion;
    
    public Metadatos(String uuid, String rfcEmisor, String nombreEmisor, String rfcReceptor, String nombreReceptor, String rfcPac
            , String fechaEmision, String fechaCertificacionSat, String monto, String efectoComprobante, String estatus, String fechaCancelacion){
        this.uuid = uuid;
        this.rfcEmisor = rfcEmisor;
        this.nombreEmisor = nombreEmisor;
        this.rfcReceptor = rfcReceptor;
        this.nombreReceptor = nombreReceptor;
        this.rfcPac = rfcPac;
        this.fechaEmision = fechaEmision;
        this.fechaCertificacionSat = fechaCertificacionSat;
        this.monto = monto;
        this.efectoComprobante = efectoComprobante;
        this.estatus = estatus;
        this.fechaCancelacion = fechaCancelacion;
    }
    public Metadatos(String uuid, String rfcEmisor, String nombreEmisor, String rfcReceptor, String nombreReceptor, String rfcPac
            , String fechaEmision, String fechaCertificacionSat, String monto, String efectoComprobante, String estatus){
        this.uuid = uuid;
        this.rfcEmisor = rfcEmisor;
        this.nombreEmisor = nombreEmisor;
        this.rfcReceptor = rfcReceptor;
        this.nombreReceptor = nombreReceptor;
        this.rfcPac = rfcPac;
        this.fechaEmision = fechaEmision;
        this.fechaCertificacionSat = fechaCertificacionSat;
        this.monto = monto;
        this.efectoComprobante = efectoComprobante;
        this.estatus = estatus;
    }
    public Metadatos(){
        
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the rfcEmisor
     */
    public String getRfcEmisor() {
        return rfcEmisor;
    }

    /**
     * @param rfcEmisor the rfcEmisor to set
     */
    public void setRfcEmisor(String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }

    /**
     * @return the nombreEmisor
     */
    public String getNombreEmisor() {
        return nombreEmisor;
    }

    /**
     * @param nombreEmisor the nombreEmisor to set
     */
    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    /**
     * @return the rfcReceptor
     */
    public String getRfcReceptor() {
        return rfcReceptor;
    }

    /**
     * @param rfcReceptor the rfcReceptor to set
     */
    public void setRfcReceptor(String rfcReceptor) {
        this.rfcReceptor = rfcReceptor;
    }

    /**
     * @return the nombreReceptor
     */
    public String getNombreReceptor() {
        return nombreReceptor;
    }

    /**
     * @param nombreReceptor the nombreReceptor to set
     */
    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    /**
     * @return the rfcPac
     */
    public String getRfcPac() {
        return rfcPac;
    }

    /**
     * @param rfcPac the rfcPac to set
     */
    public void setRfcPac(String rfcPac) {
        this.rfcPac = rfcPac;
    }

    /**
     * @return the fechaEmision
     */
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     * @param fechaEmision the fechaEmision to set
     */
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * @return the fechaCertificacionSat
     */
    public String getFechaCertificacionSat() {
        return fechaCertificacionSat;
    }

    /**
     * @param fechaCertificacionSat the fechaCertificacionSat to set
     */
    public void setFechaCertificacionSat(String fechaCertificacionSat) {
        this.fechaCertificacionSat = fechaCertificacionSat;
    }

    /**
     * @return the monto
     */
    public String getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(String monto) {
        this.monto = monto;
    }

    /**
     * @return the efectoComprobante
     */
    public String getEfectoComprobante() {
        return efectoComprobante;
    }

    /**
     * @param efectoComprobante the efectoComprobante to set
     */
    public void setEfectoComprobante(String efectoComprobante) {
        this.efectoComprobante = efectoComprobante;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the fechaCancelacion
     */
    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    /**
     * @param fechaCancelacion the fechaCancelacion to set
     */
    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }
    
}
