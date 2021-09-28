
public class Grafo 
{
	private int[][] mAdyacencia;
	private int orden;
	private Vertice vertices[];
	private int limite;
	
	private int indices[];
	private Etiqueta etiquetas[];
	
	public Grafo(int limite)
	{
		mAdyacencia = new int [limite][limite];
		orden = 0;
		vertices = new Vertice[limite];
		this.limite = limite;
		indices = new int[limite];
		etiquetas = new Etiqueta[limite];
	}
	
	public boolean agregarVertice(Vertice vertice)
	{
		if(!estaLleno())
		{
			vertices[orden++] = vertice;
			return true;
		}
		return false;
	}
	
	public boolean agregarArista(Arista arista)
	{
		int p1 = buscarVertice(arista.getV1());
		int p2 = buscarVertice(arista.getV2());

		if((p1 != -1) && (p2 != -1) && (p1 != p2))
		{
			mAdyacencia [p1][p2] = arista.getPeso();
			mAdyacencia [p2][p1] = arista.getPeso();
			
			return true;
		}
		
		return false;
	}
	
	public void mostrarVertices()
	{
		for(int i = 0; i < orden; i++)
		{
			System.out.println("Arista: " + vertices[i].getNombre());
		}
	}
	
	public void mostrarMAdyacencia()
	{
		for(int i = 0; i < orden ; i++)
		{
			for(int j = 0; j < orden ; j++)
			{
				System.out.print(mAdyacencia[i][j] + " ");
			}
			System.out.println();
		}
	}
	private void dijkstra(Vertice source)
	{
		//dist[0] = 0;
		indices[0] = buscarVertice(source);
		etiquetas[0] = new Etiqueta(source,source,0);
		
		for(int i = 1; i < orden; i++)
		{
			recorrido(i);
		}
		
	}
	
	public void recorrido(int limite)
	{
		Etiqueta etiqueta = null;
		Etiqueta etiquetaAux = null;
		
		for(int i = 0; i < limite ; i++)
		{
			etiquetaAux = buscarValorMasChico(indices[i],limite);
			if((etiquetaAux != null))
			{
				if(etiqueta == null) etiqueta = etiquetaAux;
				if(etiquetaAux.peso < etiqueta.peso)etiqueta = etiquetaAux;
			}
			else
				continue;
		}

		indices[limite] = buscarVertice(etiqueta.vFinal);
		etiquetas[limite] = etiqueta;
	}
	
	private Etiqueta buscarValorMasChico(int indice, int limite)
	{
		int masChico = buscarUnValor(indice,limite);
		if(masChico == 0)return null;
		int costoAnterior = buscarValorEtiqueta(vertices[indice],limite);
		masChico += costoAnterior;
		int auxI = 0;
		
		for(int i = 0; i < orden; i++)
		{
			if(buscarVisitado(i,limite))continue;
			
			if(mAdyacencia[indice][i] != 0)
			{
				if(masChico >= (mAdyacencia[indice][i] + costoAnterior)) 
				{
					masChico = mAdyacencia[indice][i] + costoAnterior;
					auxI = i;
				}
			}
			
		}
		
		return new Etiqueta(vertices[indice],vertices[auxI],masChico);
	}
	
	private int buscarValorEtiqueta(Vertice vIndice,int limite)
	{
		int costo = 0;
		for(int i = 0 ;i < limite; i++)
		{
			if(etiquetas[i].vFinal.getNombre().equals(vIndice.getNombre()))costo = etiquetas[i].peso;
		}
	
		return costo;
	}
	
	public int buscarUnValor(int indice, int limite)
	{
		for(int i = 0; i < orden;i++)
		{
			if(buscarVisitado(i,limite))continue;
			
			if(mAdyacencia[indice][i] != 0)return mAdyacencia[indice][i];
		}
		return 0;
	}
	
	private boolean buscarVisitado(int numero, int limite)
	{
		for(int i = 0; i < limite ; i++)
		{
 			if(indices[i] == numero)return true;
		}
		return false;
	}
	
	public void mostrarDijkstra(Vertice source)
	{
		if(buscarVertice(source) == -1)
		{
			System.out.println("Ese vertice no existe!!!.");
			return;
		}
		
		dijkstra(source);
		
		for(int i = 0; i < orden; i++)
		{
			System.out.println("Vertice: " + vertices[indices[i]].getNombre() + "(" + indices[i]+")"+ " Distancia: " + etiquetas[i].peso /*+ dist[i]*/);
		}
	}
	
	private int buscarVertice(Vertice vertice)
	{
		
		for(int i = 0; i < orden ; i++)
		{
			if(vertices[i].getNombre().equals(vertice.getNombre()))return i;
		}
		
		return -1;
	}
	
	public boolean estaLleno()
	{
		return orden == limite;
	}
}
