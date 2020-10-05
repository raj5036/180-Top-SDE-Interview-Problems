import java.util.*;
class Tree
{
 // Method that returns the bottom view.
    public ArrayList <Integer> bottomView(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
            return ans;
        class QueueObj{
            Node node;
            int hd;
            QueueObj(Node node,int hd){
                this.node=node;
                this.hd=hd;
            }
        }
        Queue<QueueObj> q=new LinkedList<QueueObj>();
        Map<Integer,Node> map=new HashMap<>();
        q.add(new QueueObj(root,0));
        while(!q.isEmpty()){
            QueueObj temp=q.poll();
            map.put(temp.hd,temp.node); //************************************
            if(temp.node.left!=null)
                q.add(new QueueObj(temp.node.left,temp.hd-1));
            if(temp.node.right!=null)
                q.add(new QueueObj(temp.node.right,temp.hd+1));
        }
        
        for(Map.Entry<Integer,Node> entry: map.entrySet()){
            //System.out.println("Key="+entry.getKey()+"Values ="+ entry.getValue().data);
            ans.add(entry.getKey());
        }
        
        //To get the proper sequence
        Collections.sort(ans);
        //System.out.println(ans);
        Iterator it=ans.iterator();
        ArrayList<Integer> ans1=new ArrayList<>();
        for(Integer num:ans)
            ans1.add(map.get(it.next()).data);
        ans.clear();
        return ans1;
    }
    public static void main(String[] args){

    }
}