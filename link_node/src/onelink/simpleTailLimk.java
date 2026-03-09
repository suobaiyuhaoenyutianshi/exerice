package onelink;

public class simpleTailLimk
{
    private static class Node{
        int item;
        Node next;

        public Node(int item){
            this.item = item;
        }
    }

    Node head;
    Node tail;

    public simpleTailLimk(int x){
        head = new Node(x);
        tail = head;
    }

    public void addDate(int x){
        tail.next = new Node(x);
        tail = tail.next;
    }

    public void paint(){
        Node i = head;
        while(i != null){
            System.out.print(i.item+" ");
            i = i.next;
        }
    }

    public int last(){
        return tail.item;
    }

    public static void main(String[] args){
        simpleTailLimk L = new simpleTailLimk(20);
        L.addDate(30);
        L.addDate(48);
        L.addDate(100);
        L.paint();
        System.out.println("尾插的最后一元素："+L.last());
    }

    //ok,再写个指定删除节点的
    
//十分丑陋，想用递归，还不如直接计数
    private Node findNode(Node x){

        if(x.next.next == null){
            return x;
        }
        return findNode(x.next);
    }

}
