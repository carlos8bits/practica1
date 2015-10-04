package practica1;


public class LSLCNC {
    
    public nodoSimple primero,ultimo;
    
    public LSLCNC(){
        primero=ultimo=null;
    }
    public LSLCNC(nodoSimple p,nodoSimple u){
        primero = p;
        ultimo = u;
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
        p = primerNodo();
        if(x==primero){
            return null;
        }
        else{
             while(finDeRecorrido(p)==false){
                if(p.retornaLiga()==x){
                return p;
                }
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
    nodoSimple buscarDato(String d,nodoSimple y){
        nodoSimple x;
        x = primerNodo();
        y = anterior(x);
        
        while(finDeRecorrido(x)==false&&x.retornaPermutacion()!=d){
            y = x;
            x = x.retornaLiga();
        }
        return x;
    }
    
    void borrar(nodoSimple x, nodoSimple y){
        if(x==null){
            System.out.println("no existe");
        }
        desconectar(x,y);
    }
    void desconectar(nodoSimple x, nodoSimple y){
        if(x!=primero){
            y.asignaLiga(x.retornaLiga());
            if(x==ultimo){
                ultimo = y;
            }
        }
        else{
            primero = primero.retornaLiga();
            if(primero==null){
                ultimo = null;
            }
        }
    }
}