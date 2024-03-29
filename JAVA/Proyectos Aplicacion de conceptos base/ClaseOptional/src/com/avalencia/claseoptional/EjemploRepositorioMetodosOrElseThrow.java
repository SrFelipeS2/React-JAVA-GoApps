package com.avalencia.claseoptional;

import com.avalencia.claseoptional.models.Computador;
import com.avalencia.claseoptional.repositorio.ComputadorRepositorio;
import com.avalencia.claseoptional.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();


        Computador pc = repositorio.filtrar("rog").
                orElseThrow(IllegalStateException::new);
        System.out.println(pc);
        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a->a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".")+1))
                .orElseThrow();
        System.out.println(extension);


    }


}
