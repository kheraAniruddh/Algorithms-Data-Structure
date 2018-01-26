import java.util.*;

class Graph {
	public Edge edges[];
	public int edge;
	public int vertices;

	Graph(int v, int e) {
		edges = new Edge[e];
		edge  = e;
		vertices = v; 
		for(int i =0; i<e;i++)
			edges[i] = new Edge();

	}
	

	class Edge implements Comparable<Edge> {
		public int start;
		public int weight;
		public int end;

		public int compareTo(Edge that) {
			return this.weight - that.weight;
		}

	}

	class Subset {
		int parent;
		int rank;
	}

	int find(Subset subsets[], int x) {
		if(subsets[x].parent !=x)
			subsets[x].parent = find(subsets,subsets[x].parent);
		return subsets[x].parent;	
	}

	void union(Subset subsets[], int x, int y) {
		int xroot = find(subsets,x);
		int yroot= find(subsets,y);

		if(subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if(subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
				 
	}



	public Edge[] kruskalMST()
    {
        Edge mst[] = new Edge[vertices];  // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i=0; i<vertices; i++)
            mst[i] = new Edge();

 
        // Allocate memory for creating V ssubsets
        Subset subsets[] = new Subset[vertices];
        for(i=0; i<vertices; i++)
            subsets[i]=new Subset();
 
        // Create V subsets with single elements
        for (int v = 0; v < vertices; v++)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0;  // Index used to pick next edge
 
        // Number of edges to be taken is equal to V-1
        while (e < vertices- 1)
        {
            // Step 2: Pick the smallest edge. And increment 
            // the index for next iteration
            Edge next_edge = new Edge();
            next_edge = edges[i++];
 
            int x = find(subsets, next_edge.start);
            int y = find(subsets, next_edge.end);
 
            // If including this edge does't cause cycle,
            // include it in result and increment the index 
            // of result for next edge
            if (x != y)
            {
                mst[e++] = next_edge;
                union(subsets, x, y);
            }
            // Else discard the next_edge
        }
 
        // print the contents of result[] to display
     

		return mst;
	}

	public static void main(String[] args) {

		int vertices = 4;
		int edges =5;

		Graph gr = new Graph(vertices,edges);
		/*
		  10
		0------1
		| \    |
		|   \5 | 15
	   6|    \ |
	   	|_____\|
	   	2  4  3
		*/
		//add edge 0-1
		gr.edges[0].start = 0;
		gr.edges[0].end =1;
		gr.edges[0].weight = 10;

		//add edge 0-2
		gr.edges[1].start=0;
		gr.edges[1].end=2;
		gr.edges[1].weight=6;

		//add edge 0-3
		gr.edges[2].start=0;
		gr.edges[2].end=3;
		gr.edges[2].weight=5;

		//add edge 1-3
		gr.edges[3].start=1;
		gr.edges[3].end=3;
		gr.edges[3].weight=15;

		//add edge 2-3
		gr.edges[4].start=2;
		gr.edges[4].end=3;
		gr.edges[4].weight=4;


		for(int i = 0;i<gr.edges.length;i++) {
			System.out.println("start: " +gr.edges[i].start+" end: "+gr.edges[i].end+ " weight: "+ gr.edges[i].weight);
		}

		Arrays.sort(gr.edges);
		System.out.println();

		//After sort by weights
		for(int i = 0;i<gr.edges.length;i++) {
			System.out.println("start: " +gr.edges[i].start+" end: "+gr.edges[i].end+ " weight: "+ gr.edges[i].weight);
		}

		Edge mst[] = gr.kruskalMST();
			System.out.println();
		for(int i = 0;i<mst.length-1;i++) {
			System.out.println("start: " +mst[i].start+" end: "+mst[i].end+ " weight: "+ mst[i].weight);
		}
		
	}
}