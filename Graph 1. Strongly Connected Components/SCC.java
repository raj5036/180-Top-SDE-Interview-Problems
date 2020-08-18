import java.util.*;
class Graph{
	int V;
	LinkedList<Integer> adjList[];
	@SuppressWarnings("unchecked")
	Graph(int V){
		this.V=V;
		adjList=new LinkedList[V];
		for(int i=0;i<V;i++)
			adjList[i]=new LinkedList();
	}
	void addEdge(Graph graph,int source,int destination){
		graph.adjList[source].add(destination);
	}
	void topoLogicalSort(Graph graph,int node,boolean[] visited,Stack<Integer> stack){
		visited[node]=true;
		Iterator<Integer> it=graph.adjList[node].listIterator();
		while(it.hasNext()){
			int next=it.next();
			if(!visited[next])
				topoLogicalSort(graph,next,visited,stack);
		}
		stack.push(new Integer(node));
	}
	Graph getTranspose(Graph graph){
		Graph gr=new Graph(graph.V);
		for(int i=0;i<graph.V;i++){
			Iterator<Integer> it=graph.adjList[i].listIterator();
			while(it.hasNext())
				gr.adjList[it.next()].add(i);
		}
		return gr;
	}
	void DFSUtil(Graph gr,int node,boolean[] visited){
		visited[node]=true;
		System.out.print(node+" ");
		Iterator<Integer> it=gr.adjList[node].listIterator();
		while(it.hasNext()){
			int next=it.next();
			if(!visited[next])
				DFSUtil(gr,next,visited);
		}
	}
	void printSCC(Graph graph){
		Stack<Integer> stack=new Stack<>();
		boolean[] visited=new boolean[graph.V];
		Arrays.fill(visited,false);
		for(int i=0;i<graph.V;i++)
			if(!visited[i])
				graph.topoLogicalSort(graph,i,visited,stack); //1
		Graph gr=graph.getTranspose(graph); //2
		Arrays.fill(visited,false);

		System.out.println("SCC");
		int count=0;
		while(!stack.isEmpty()){//3
			int node=(int)stack.pop();
			if(!visited[node]){
				System.out.println(++count+"--------");
				gr.DFSUtil(gr,node,visited);
				System.out.println();
			}
		}
	}
}
public class SCC{
	public static void main(String[] args){
		Graph g=new Graph(5);
		g.addEdge(g,1, 0); 
        g.addEdge(g,0, 2); 
        g.addEdge(g,2, 1); 
        g.addEdge(g,0, 3); 
        g.addEdge(g,3, 4);
		g.printSCC(g);
	}
}