
public class Arista 
{
	private Vertice vertice1;
	private Vertice vertice2;
	private int peso;
	
	public Arista(Vertice v1, Vertice v2, int p)
	{
		vertice1 = v1;
		vertice2 = v2;
		peso = p;
	}
	
	public Vertice getV1()
	{
		return vertice1;
	}
	
	public Vertice getV2()
	{
		return vertice2;
	}
	
	public void setPeso(int p)
	{
		peso = p;
	}
	
	public int getPeso()
	{
		return peso;
	}
	
	public Vertice getV(Vertice vertice)
	{
		if(vertice1.equals(vertice.getNombre()))return vertice2;
		
		if(vertice.getNombre().equals(vertice2))return vertice1;
		
		return null;
	}
}
