package doubleLinkedList;

public class simpList {
    private int Listnum ;

    public int getListnum() {
        return Listnum;
    }

    private static class Node{
        private int item;
        private Node prev;
        private Node next;

        public Node(int item, Node prev){
            this.item = item;
            this.prev = prev;
        }
    }

    private Node head;
    private Node last;

    public int getHeadItem() {
        return head.item;
    }

    public int getLastItem() {
        return last.item;
    }

    public simpList(int item){
        this.head = new Node(item,null);
        this.last = this.head;
        this.last.next = null;//这没必要写的，因为类的实例变量不构造，就是默认null
        Listnum += 1;
    }

    public void addItem(int item){
        this.last.next = new Node(item, this.last);
        this.last = this.last.next;
        this.Listnum += 1;
    }

    public void paintHead_last(){
        System.out.println("这是顺时打印" );
        Node x = this.head;
        while(x != null){
            System.out.print(x.item + "——> ");
            x = x.next;
        }
        System.out.println("null");
    }

    public void paintLast_head(){
        System.out.println("这是逆时打印" );
        Node x = this.last;
        while(x != null){
            System.out.print(x.item + "——> ");
            x = x.prev;
        }
        System.out.println("null");
    }

    // 计算列表大小（使用私有辅助方法的递归版本）
    private static int size(Node first){
        if(first == null){
            return 0;
        }
        return size(first.next) + 1;
    }
    public int size(){
        return size(this.head);
    }

}



