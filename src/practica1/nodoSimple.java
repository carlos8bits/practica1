package practica1;


public class nodoSimple {
    
    private nodoSimple liga;
    private String per;

    nodoSimple(nodoSimple l,String p){
        liga = l;
        per = p;
    }
    public void asignaLiga(nodoSimple l){
        liga = l;
    }
    public void asignaPermutacion(String p){
        per = p;
    }
    public nodoSimple retornaLiga(){
        return liga;
    }
    public String retornaPermutacion(){
        return per;
    }
}
