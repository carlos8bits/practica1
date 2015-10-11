package practica1;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class LSLCNC {
    
    public nodoSimple primero,ultimo;
    
    public LSLCNC(){
        primero =ultimo=null;
   
    }
 
    public boolean esVacia(){
        return primero==null;
    }
    public nodoSimple primerNodo(){
        return primero;
    }
    public nodoSimple ultimoNodo(){
        return ultimo;
    }
    nodoSimple anterior(nodoSimple x){
        nodoSimple p;
        p = primero;
        if(x==primero){
            return null;
        }
        else{
             while(finDeRecorrido(p)==false){
                if(p.retornaLiga()==x){
                return p;
                }
                p=p.retornaLiga();
            }
        }
       return null;
    }
    
    public boolean finDeRecorrido(nodoSimple x){
        return x==null;
    }
    public void recorre(){
        nodoSimple p;
        p = primerNodo();
        while(this.finDeRecorrido(p)==false){
           p=p.retornaLiga();
        }
    }
    
    public void insertar(String d, nodoSimple y){
        nodoSimple x;
        x = new nodoSimple(null,d);
        conectar(x,y);
    }
    
    public void InsertarLista(ArrayList<String> lstPermutaciones)
    {
        nodoSimple p = primero;
        for (String obj : lstPermutaciones) {
            insertar(obj, p);
            p=ultimo;
        }
    
    }
    
    void conectar(nodoSimple x, nodoSimple y){
        if(y!=null){
            x.asignaLiga(y.retornaLiga());
            y.asignaLiga(x);
            if(y==ultimo){
                ultimo=x;
            }
        }
        else{
             x.asignaLiga(primero);
             if(primero==null){
                 ultimo = x;
             }
             primero = x;
        }      
    }
    nodoSimple buscarDato(String d){
        nodoSimple x = primerNodo();
        nodoSimple y = anterior(x);
        
        while(this.finDeRecorrido(x)==false){
            if(x.retornaPermutacion().equals(d)){
                return x;
            }
            y = x;
            x = x.retornaLiga();
        }
        
        JOptionPane.showMessageDialog(null, "no se encontro el nodo");
        return null;
        
    }
    
    void borrar(nodoSimple x){
        x = this.buscarDato(x.retornaPermutacion());
        if(x!=null){
            desconectar(x);
        }
     
    }
    void desconectar(nodoSimple x){
      
        nodoSimple y = this.anterior(x);
        
        if(x!=primero){
            y.asignaLiga(x.retornaLiga());
            if(x==ultimo){
                ultimo = y;
            }
        }
               
        
            primero = primero.retornaLiga();
            if(primero==null){
                ultimo=null;
            }
        
    }
    /*
    String imprimir(){
      
        nodoSimple p = primero;
        String st = "";
        
        while(this.finDeRecorrido(p)==false){
            
            st = st + p.retornaPermutacion() + "\n ";
            p = p.retornaLiga();
        }
        
        return st;
    }
    */
    void ordenInverso(){
        nodoSimple p = primero;
        nodoSimple y = this.anterior(p);
        ultimo = primero;
        while(finDeRecorrido(p)==false){
            nodoSimple aux = p.retornaLiga();
            p.asignaLiga(y);
            primero = p;
            y = p;
            p = aux;
            
        }
        
        
    }
}








