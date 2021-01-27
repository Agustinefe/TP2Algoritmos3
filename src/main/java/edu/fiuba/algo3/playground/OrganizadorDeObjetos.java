package edu.fiuba.algo3.playground;/* Author: firmapaz ;created on 15/12/20*/

import edu.fiuba.algo3.excepciones.OrganizadorOcupadoException;

import java.util.ArrayList;

public class OrganizadorDeObjetos<T> {

    private ArrayList<T> manoAdministradora;

    public OrganizadorDeObjetos(){

        this.manoAdministradora = new ArrayList<T>();

    }

    public void agarrarSucesionDeObjetosDe(ArrayList<T> listaDeBloques, int posicion) throws OrganizadorOcupadoException {

        if(!manoAdministradora.isEmpty()){

            throw new OrganizadorOcupadoException();

        }

        while(posicion < listaDeBloques.size()) { this.manoAdministradora.add(listaDeBloques.remove(posicion)); }

    }

    public void soltarSucesionDeObjetosEn(ArrayList<T> listaDeBloques, int posicion){

        listaDeBloques.addAll(posicion, this.manoAdministradora);
        this.manoAdministradora.clear();

    }

    public void soltarSucesionDeObjetosEnLaBasura(){

        this.manoAdministradora.clear();

    }


}
