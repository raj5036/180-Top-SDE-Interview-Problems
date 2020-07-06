class Tree
{
    void leftView(Node root){
    if(root==null)
            return;
      Queue<Node> queue=new LinkedList<>();
      queue.add(root);
      Node cur;
      while(!queue.isEmpty()){
          int size=queue.size();
          int i=0;
          while(i++<size){
              cur=queue.poll();
              // if this is first node of current level, print it
              if(i==1)
                System.out.print(cur.data+" ");
              if(cur.left!=null) queue.add(cur.left);
              if(cur.right!=null) queue.add(cur.right);
          }
      }
    }
}