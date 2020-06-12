package examenes;

public class ListaEnlazada {
    
    private NodExamen Inicio;
    private NodExamen Fin;
    private int SinElementos;
    
    public ListaEnlazada(){
      Inicio=null;
      Fin=null;
      SinElementos=0;
    }
    public int getNoElementos(){
        return SinElementos;
    }
    public void AgregacionInical(NodExamen Agregacion){
        if(Inicio==null){
            Inicio=Agregacion;
            Fin=Agregacion;
            SinElementos++;
        }else {
            Agregacion.Sig=Inicio;
            Inicio=Agregacion;
            SinElementos++;
        }
    }
    public void AgregacionFinal(NodExamen Agregacion){
        if(Fin==null){
            Fin=Agregacion;
            Inicio=Agregacion;
            SinElementos++;
        }else {
            Fin.Sig=Agregacion;
            Fin=Agregacion;
            SinElementos++;
        }
    }
    public boolean Buscar (NodExamen Busqueda){
        if (Busqueda!=null){
            NodExamen ref=Inicio;
            boolean Encontrado = false;
        while((ref!=null) && !Encontrado){
                if(ref.getData()==Busqueda.getData()){
                    Encontrado=true;
                  }
                  ref=ref.Sig;
         }
          return Encontrado;
        }
        return false;
    }
    public NodExamen EliminacionInicial(){
        if(Inicio == null){
           return null;
        }else {
            NodExamen Ret = Inicio;
            Inicio = Inicio.Sig;
            Ret.Sig = null;
            SinElementos--;
            return Ret;
        }
    }
    public NodExamen EliminacionFinal(){
        if(Fin == null){
            return null;
        }else {
            NodExamen ref = Inicio;
            boolean Find = false;
            while ((ref != null) && !Find){
                if(ref.Sig == Fin){
                    Find = true;
                }
                if(!Find){
                    ref = ref.Sig;
                }
            }
            SinElementos--;
            NodExamen eliminar = Fin;
            Fin = ref;
            ref.Sig = null;
            return eliminar;
        }
    }
    public NodExamen EliminaroPrNodo(NodExamen a){
        if(a == null){
           return null;
        }
        if(Fin == null){
           return null;
        }else {
            NodExamen refRojo = Inicio;
            NodExamen refAzul = null;
            NodExamen refElim = null;
            boolean Find = false;
       while((refRojo != null) && !Find){
              if(refRojo.getData() == a.getData()){
                    Find = true;
                    refElim = refRojo;
                    SinElementos--;
                }
              if(!Find){
                 refAzul=refRojo;
                 refRojo=refRojo.Sig;
                }else {
                    refAzul.Sig=refRojo.Sig;
                    refElim.Sig=null;
             }
           }
            return refElim;
        }
    }
    public NodExamen PorIndice(int p){
        if(Inicio == null){
            return null;
        }
        if (p>= SinElementos){
            return null;
        }
        if (p< 0){
            return null;
        }
        int i = 0;
        NodExamen ref = Inicio;
        for(;i<p;i++){
            ref = ref.Sig;
        }
        ref=new NodExamen(null,ref.getData());
        return ref;
    }
}
