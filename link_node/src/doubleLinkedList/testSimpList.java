package doubleLinkedList;

public class testSimpList {
    public static void main(String[] args){
        simpList Z = new simpList(3);
        Z.addItem(22);
        Z.addItem(98);
        Z.addItem(100);
        System.out.println("这列表的第一个元素：" + Z.getHeadItem());
        System.out.println("这是列表最后一个元素：" + Z.getLastItem());
        System.out.println("这是列表内数目" + Z.getListnum());
        Z.paintHead_last();
        Z.paintLast_head();
        System.out.println(Z.size());

    }
}
