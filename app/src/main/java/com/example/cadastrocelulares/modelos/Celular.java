package com.example.cadastrocelulares.modelos;

/**
 * @author Larissa Fraga
 */
public class Celular {
    
    private Integer idCelular; 
    private Integer marcaId;
    private String modelo;

    public Integer getIdCelular() {
        return idCelular;
    }

    public void setIdCelular(Integer idCelular) {
        this.idCelular = idCelular;
    }

    public Integer getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }  
}
