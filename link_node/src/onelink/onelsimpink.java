package onelink;

public class onelsimpink {
    private node first;
    private static class node{
        private int item; //之后改成private，在创建访问方式
        private node next; //之后改成private

        public node(int i,node n){
            this.item = i;
            this.next = n;
        }
        //创建访问方式，在node类节点中才能访问，在外部：nade a->需要a.getItem()才能得到，而不能a.item
        public int getItem(){
            return this.item;
        }

        public node getNext() {
            return this.next;
        }
    }


// 头插法
    public onelsimpink(int x){
        first = new node(x,null);
    }

    public void addFirst(int x){
        first = new node(x,first);
    }




    public void printLink(){
        node i = first;
        while(i != null){
            System.out.print(i.item+" ");
            i = i.next;
        }
        System.out.println();
    }

    public int getFirst(){
        return first.item;
    }

    public static void main(String[] args) {
    onelsimpink L = new onelsimpink(4);
    L.addFirst(5);
    L.addFirst((10));
    L.addFirst(30);
    System.out.println("这是头插法的第一元素："+L.getFirst());
    L.printLink();

    }

}
