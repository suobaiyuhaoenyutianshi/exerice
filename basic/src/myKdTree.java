public class myKdTree {
    private Node root;//开头
    private int size;//一共多少节点
    private final int dimens; //多少维度
    /**一个节点要有很多功能：深度->得应该比较的维度，// 左/右子树（或下/上子树）该节点存储的点 double[]
     比较目标点与当前节点在划分维度上的大小
     计算当前节点到目标点的欧几里得距离平方（避免开方）
     */
    private class Node {
        final double[] ponit;//维度坐标
        private Node left,right;
        private int depth;// 节点在树中的深度，用于决定划分维度
        public Node(double[] ponit,int depth){
            this.ponit = ponit;
            this.depth = depth;
        }
        //返回当前节点的划分维度 注：1维0，2维1。。。因为我是用double存的坐标
        public int spiltDim(){
            return depth % dimens;
        }
        //返回与目标的坐标的该维度比较大小，大于0说明应是是本节点的右侧，right
        public int compareSplitDim(double that[]){
            int spilitDem = spiltDim();
            return Double.compare(that[spilitDem], this.ponit[spilitDem]);
        }
        /** 当前节点到目标点的欧氏距离平方 */
        public double distanceSquaredTo(Node that){
            double[] thatPoint = that.ponit;
            double sum =0;
            for(int i = 0;i < dimens;i++){
                double correspondDimData = ponit[i] - thatPoint[i];
                sum += correspondDimData * correspondDimData;
            }
            return sum;
        }

    }


    public myKdTree(int dimens){
        this.root = null;
        this.dimens =dimens;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    //插入
    public void insert(double[] point){
        Node fatherNode =null;
        Node fath
        root = insertHelp(point,root,0);
    }
    //传的是当前节点,父节点，父节点的父节点
    private Node insertHelp(double[] point,Node curr,int depth){
        if(curr == null){
            return new Node(point,depth);
        }
        int comp = curr.compareSplitDim(point);
        if(comp > 0){
            curr.right = insertHelp(point,curr.right,depth+1);
        } else if (comp < 0) {
            curr.left = insertHelp(point,curr.left,depth+1);
        }else {

                // 完全相等的情况：可以选择替换或者忽略。这里简单忽略重复点。
                // 实际应用可能需要存储重复或更新值。
        }
        return curr;

    }




















}
