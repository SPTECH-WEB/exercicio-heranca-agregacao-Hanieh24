package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

import javax.swing.*;

public class DesenvolvedorWeb extends Desenvolvedor {
    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public Double calcularSalario(){
        return (getValorHora()*getQtdHoras())+(horasMentoria*300);
    }

    public Boolean isFullstack(){
        return frontend != null && backend != null && sgbd != null && horasMentoria != null;
    }

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }
}
