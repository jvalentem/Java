/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Joaov
 */
public class Observacao {

    private int id;
    private int id_aluno;
    private int id_professor;
    private String titulo;
    private String conteudo;
    private String publidata;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setPublidata(String publidata) {
        this.publidata = publidata;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getPubliData() {
        return publidata;
    }
}
