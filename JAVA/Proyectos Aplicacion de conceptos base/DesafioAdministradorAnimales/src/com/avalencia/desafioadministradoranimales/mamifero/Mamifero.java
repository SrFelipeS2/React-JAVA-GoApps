package com.avalencia.desafioadministradoranimales.mamifero;

abstract public class Mamifero {
    protected String habitad;
    protected float altura;
    protected float largo;
    protected float peso;
    protected String nombreCientifico;

    public Mamifero() {
    }

    public Mamifero(String habitad, float altura, float largo, float peso, String nombreCientifico) {
        this();
        this.habitad = habitad;
        this.altura = altura;
        this.largo = largo;
        this.peso = peso;
        this.nombreCientifico = nombreCientifico;
    }

    public String getHabitad() {
        return habitad;
    }

    public float getAltura() {
        return altura;
    }

    public float getLargo() {
        return largo;
    }

    public float getPeso() {
        return peso;
    }


    public String getNombreCientifico() {
        return nombreCientifico;
    }


    abstract public String comer();
    abstract public String dormir();
    abstract public String correr();
    abstract public String comunicarse();
}
