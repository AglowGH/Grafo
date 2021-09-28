
public class TestGrafo 
{
	public static void main(String[] args) 
	{
		Grafo grafo = new Grafo(10);
		
		
		Vertice vA = new Vertice("A");
		Vertice vB = new Vertice("B");
		Vertice vC = new Vertice("C");
		Vertice vD = new Vertice("D");
		Vertice vE = new Vertice("E");
		Vertice vF = new Vertice("F");
		Vertice vG = new Vertice("G");
		Vertice vH = new Vertice("H");
		Vertice vI = new Vertice("I");
		Vertice vJ = new Vertice("J");
		
		grafo.agregarVertice(vA);
		grafo.agregarVertice(vB);
		grafo.agregarVertice(vC);
		grafo.agregarVertice(vD);
		grafo.agregarVertice(vE);
		grafo.agregarVertice(vF);
		grafo.agregarVertice(vG);
		grafo.agregarVertice(vH);
		grafo.agregarVertice(vI);
		grafo.agregarVertice(vJ);

		Arista a1 = new Arista(vA,vB,3);
		Arista a2 = new Arista(vA,vG,5);
		Arista a3 = new Arista(vB,vC,2);
		Arista a4 = new Arista(vB,vD,3);
		Arista a5 = new Arista(vC,vA,2);
		Arista a6 = new Arista(vC,vE,6);
		Arista a7 = new Arista(vD,vE,8);
		Arista a8 = new Arista(vD,vF,5);
		Arista a9 = new Arista(vF,vG,4);
		Arista a10 = new Arista(vF,vJ,10);
		Arista a11 = new Arista(vG,vH,1);
		Arista a12 = new Arista(vH,vI,2);
		Arista a13 = new Arista(vI,vF,5);
		Arista a14 = new Arista(vI,vJ,4);
		
		grafo.agregarArista(a1);
		grafo.agregarArista(a2);
		grafo.agregarArista(a3);
		grafo.agregarArista(a4);
		grafo.agregarArista(a5);
		grafo.agregarArista(a6);
		grafo.agregarArista(a7);
		grafo.agregarArista(a8);
		grafo.agregarArista(a9);
		grafo.agregarArista(a10);
		grafo.agregarArista(a11);
		grafo.agregarArista(a12);
		grafo.agregarArista(a13);
		grafo.agregarArista(a14);
		
		grafo.mostrarMAdyacencia();
		grafo.mostrarVertices();
		
		grafo.mostrarDijkstra(vA);
		
	}
}
