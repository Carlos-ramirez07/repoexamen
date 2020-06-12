package examenes;

public class PilaExamen {
        private ListaEnlazada Esq;

    public PilaExamen(){
        Esq = new ListaEnlazada();
    }
    public void ApilacionP(int n) throws  DesbordamientoPila{
        Esq.AgregacionInical(new NodExamen(null,n));
    }
    public NodExamen SacarP() throws SubdesPilas{
        NodExamen esacar = Esq.EliminacionInicial();
        return esacar;
    }
}
