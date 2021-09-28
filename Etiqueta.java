
public class Etiqueta 
{
	public Vertice vOrigen;
	public Vertice vFinal;
	public int peso;
	
	Etiqueta(Vertice vOrigen, Vertice vFinal, int costo)
	{
		this.vOrigen = vOrigen;
		this.vFinal = vFinal;
		this.peso = costo;
	}
}
