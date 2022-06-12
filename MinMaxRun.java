import java.util.Vector;
  

 class treeNode{
  public int nodeVal; 
  public Vector<treeNode> childNodes;
  public boolean leaf;

  treeNode(){
	nodeVal = -1;
	childNodes = new Vector<treeNode>();
	leaf = false;
	}

  treeNode(int val){
	nodeVal = val;
	childNodes = null;
	leaf = true;
	}
}

class MinMax{ 

  public treeNode root;

  public void createTree(){
	root = new treeNode(); //creating root node
	root.childNodes.add(new treeNode()); //creating child1 of root node
	root.childNodes.add(new treeNode()); //creating child2 of root node
	root.childNodes.add(new treeNode()); //creating child3 of root node
	root.childNodes.elementAt(0).childNodes.add(new treeNode(3)); //creating leaf node of child1 node
	root.childNodes.elementAt(0).childNodes.add(new treeNode(12)); //creating leaf node of child1 node
	root.childNodes.elementAt(0).childNodes.add(new treeNode(8)); //creating leaf node of child1 node
	root.childNodes.elementAt(1).childNodes.add(new treeNode(2)); //creating leaf node of child2 node
	root.childNodes.elementAt(1).childNodes.add(new treeNode(4)); //creating leaf node of child2 node
	root.childNodes.elementAt(1).childNodes.add(new treeNode(6)); //creating leaf node of child2 node
	root.childNodes.elementAt(2).childNodes.add(new treeNode(14)); //creating leaf node of child3 node
	root.childNodes.elementAt(2).childNodes.add(new treeNode(5)); //creating leaf node of child3 node
	root.childNodes.elementAt(2).childNodes.add(new treeNode(2)); //creating leaf node of child3 node
	}

  public void displayTree(){
	System.out.println();
	System.out.print(root.nodeVal);
	System.out.println();

	for(int i=0; i<root.childNodes.size(); i++)
		System.out.print(root.childNodes.elementAt(i).nodeVal+" ");

	System.out.println();
	
	for(int i=0; i<root.childNodes.size(); i++)
		for(int j=0; j<root.childNodes.elementAt(i).childNodes.size(); j++)
			System.out.print(root.childNodes.elementAt(i).childNodes.elementAt(j).nodeVal+" ");
	System.out.println();	 
	}


public void MinMaxDec(){
	root.nodeVal = Max_Val(root);  //Value assignments to nodes at Max-level
	}

int Max_Val(treeNode N){
	if(N.leaf) return N.nodeVal;
	int V = -9999;
	for(int i = 0; i<N.childNodes.size(); i++)
		V = Math.max(V,Min_Val(N.childNodes.elementAt(i)));
	N.nodeVal = V;  //Value assignments to nodes at Max-level
	return V;
	}

int Min_Val(treeNode N){
	if(N.leaf) return N.nodeVal;
	int V = 9999;
	for(int i = 0; i<N.childNodes.size(); i++)
		V = Math.min(V,Max_Val(N.childNodes.elementAt(i)));
	N.nodeVal = V;	//Value assignments to nodes at Min-level
	return V;
	}

}

class MinMaxRun{
public static void main(String args[]){
 MinMax dummy = new MinMax();
 dummy.createTree();
 dummy.displayTree();
 dummy.MinMaxDec();
 dummy.displayTree();

 }
}  
