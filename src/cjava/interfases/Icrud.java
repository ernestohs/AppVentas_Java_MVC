package cjava.interfases;

import java.util.List;

public interface Icrud<T> {

    //definir las firmas
    boolean Create(T o) throws Exception;
//throws Exception para manejo de excepciones
    boolean Update(T o) throws Exception;

    boolean Delete(T o) throws Exception;

    List<T> readAll() throws Exception;

    T query(String id) throws Exception;
    
   

}
