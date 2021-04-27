package com.mycompany.models;

import java.sql.Date;

/**
 *
 * @author CARLOS
 */
public class Gastos {
    private int N_factura;
    private String proveedor;
    private int cantidad;
    private Date fecha;
    private int id_tipo_gasto;
    private int id_inmueble;

    public Gastos() {
    }

    public Gastos(int N_factura, String proveedor, int cantidad, Date fecha, int id_tipo_gasto, int id_inmueble) {
        this.N_factura = N_factura;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.id_tipo_gasto = id_tipo_gasto;
        this.id_inmueble = id_inmueble;
    }

    public int getN_factura() {
        return N_factura;
    }

    public String getProveedor() {
        return proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getId_tipo_gasto() {
        return id_tipo_gasto;
    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setN_factura(int N_factura) {
        this.N_factura = N_factura;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setId_tipo_gasto(int id_tipo_gasto) {
        this.id_tipo_gasto = id_tipo_gasto;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gastos{N_factura=").append(N_factura);
        sb.append(", proveedor=").append(proveedor);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", fecha=").append(fecha);
        sb.append(", id_tipo_gasto=").append(id_tipo_gasto);
        sb.append(", id_inmueble=").append(id_inmueble);
        sb.append('}');
        return sb.toString();
    }
    
    
}
