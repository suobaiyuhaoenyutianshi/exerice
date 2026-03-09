package onelink;
//保存
public class simpleTailLimk
{
    private static class Node{
        int item;
        Node next;

        public Node(int item){
            this.item = item;
        }
    }
    private int linkNum;
    private Node head;
    private Node tail;

    public int getLinkNum() {
        return linkNum;
    }

    public int getHeadItem() {
        return head.item;
    }

    public int getTailIteam() {
        return head.item;
    }

    public simpleTailLimk(int x){
        head = new Node(x);
        tail = head;
        linkNum += 1;
    }

    public void addDate(int x){
        tail.next = new Node(x);
        tail = tail.next;
        linkNum += 1;
    }

    public void paint(){
        Node i = head;
        while(i != null){
            System.out.print(i.item+" ");
            i = i.next;
        }
        System.out.println();
    }

    public int last(){
        return tail.item;
    }



    //先写个简单的删除，如默认删除最后的//最前的
    public void simpledeleteTail(){
        //找到倒数第二个对象。写个辅助方法findnode
        Node lastButOne = findNode(this.head);
        lastButOne.next = null;
        this.tail = lastButOne;
        this.linkNum -= 1;
    }

    //ok,再写个指定删除节点的
    public void simpledeleteTail(int x){
        //删除零节点
        Node findObjct = this.head;
        if(x== 0){
            this.head = this.head.next;
            findObjct.next = null;
            return;
        }
        // 辅助方法searchprevObiect,寻找对象的前个节点


        Node findPrevObjct = searchprevObject(x);
        //删除指定节点
        findObjct = findPrevObjct.next;
        findPrevObjct.next = findPrevObjct.next.next;
        findObjct.next = null;

//Linkmum == 3,意味着有[0][1][2]，2对的是3
        if(x == linkNum - 1){
            this.tail = findPrevObjct;

        }
        this.linkNum--;
    }
//啊啊，试试试试先搜索
// 辅助方法searchprevObiect,寻找对象的前个节点，以后还有用，如插入等，输入3,他就会返回第二节点
    private Node searchprevObject(int x){
        if(x < 1 || x >= this.linkNum){
            throw new IndexOutOfBoundsException("索引越界: " + x);
        }
        Node findObjct = this.head;
        while(x != 1) {
            findObjct = findObjct.next;
            x--;
        }
        return  findObjct;
    }

//十分丑陋，想用递归，还不如直接计数
    private Node findNode(Node x){

        if(x.next.next == null){
            return x;
        }
        return findNode(x.next);
    }

}
