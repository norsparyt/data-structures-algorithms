import java.util.*;

public class Main {
    public static void main(String[] args) {
        //triangle(5);
        //prime1(37);
        //prime2(101);
//        countDistinctElements();
        maxSumOfK(new int[]{16,12,9,19,11,8}, 3);

//        int arr[] = new int[]{5, 8, -4, -4,9,-2, 2};
        //int arr[] = new int[]{8, 3, 1, 5, -6,6,2, 2};
//        int n = arr.length;
//        int sum = 4;

//        System.out.println(largestSubarrayWithSumX(arr, n, sum));
//        Deque dq = new Deque(5);
//        dq.insertRear(1);
//        dq.insertRear(2);
//        dq.insertRear(3);
//        dq.print();
//        dq.insertFront(4);
//        dq.print();
//        dq.insertFront(5);
//        dq.print();
//        dq.deleteRear();
//        dq.print();
//        dq.deleteFront();
//        dq.print();

//        Tree t = new Tree();
//        int[] i={4,8,2,5,1,6,3,7};
//        int[] p={8,4,5,2,6,7,3,1};
//        System.out.println(t.buildTree(i,p).data);

//        System.out.println(t.findSpiral());
//        System.out.println(t.lcaRec(t.root,5,6));

    }

    private static void maxSumOfK(int[] arr, int k) {
        int maxSum=0;
        for(int i=0;i<k;i++){
            maxSum=maxSum+arr[i];
        }
        int sum = maxSum;
        for (int j = k; j < arr.length; j++) {
            sum = sum + arr[j] - arr[j-k];
            maxSum = Math.max(sum, maxSum);
        }
        System.out.println("Max sum of k consecutive elements in array is"+maxSum);
    }

    private static void countDistinctElements(int[] arr) {
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            boolean flag=false;
            for (int j = 0; j < i; j++) {
                if(arr[i]== arr[j]){
                    flag=true;
                    break;
                }
            }
            if(!flag) {
                count++;
            }
        }
        System.out.println(count);
    }

    //1
    private static void triangle(int n) {
        int i=1;
        while(i<=n*2-1){
            int j=1;
            while (j<=(n*2-1)-i){
                System.out.print(" ");
                j=j+2;
            }
            int k=1;
            while (k<=i){
                k++;
                System.out.print("*");
            }
            i=i+2;
            System.out.println();
        }
    }
    //2
    private static void prime1(int n) {
        //optimised approach O(nˆ1/2)
        for (int i = 2; i*i <=n; i++)
            if (n % i == 0) {
                System.out.println("not prime");
                return;
            }
        System.out.println("prime");
    }
    //3
    private static void prime2(int n) {
        //more optimised approach : 1/3rd iterations
        if(n==1){
            System.out.println("not prime");
            return;
        }
        if(n==2||n==3){
            System.out.println("prime");
            return;
        }
        if(n%2==0||n%3==0){
            System.out.println("not prime");
            return;
        }
        for (int i = 5; i*i <=n; i=i+6)
            if (n % i == 0||n % (i+2) == 0) {
                System.out.println("not prime");
                return;
            }
        System.out.println("prime");
    }

    static int largestSubarrayWithSumX(int[] arr, int n, int k)
    {
        // HashMap to store (sum, index) tuples
        HashSet< Integer> map = new HashSet<>();
        int sum = 0, maxLen = 0,len=-1;

        // traverse the given array
        for (int i = 0; i < n; i++) {

            len++;
            sum += arr[i];
            if (sum == k)
            {
                maxLen=len>maxLen?len:maxLen;
                len=0;
            }

            if (map.contains(sum-k)) {
                maxLen=len>maxLen?len:maxLen;
                len=0;
            }
            map.add(sum);
            System.out.print("i"+i);
            System.out.print("len"+len);
            System.out.print("sum"+sum);
            System.out.println("maxlen"+maxLen);
        }

        return maxLen;
    }
}

class Deque{
    int size,front,capacity;
    int [] arr;
    public Deque(int c){
        arr=new int[c];
        front=0;
        size=0;
        capacity=c;
    }
    void insertRear(int x){
        if(isFull()){
            System.out.println("queue full");return;}
        int rear=(front+size-1)%capacity;
        arr[++rear]=x;
        size++;
    }
    void insertFront(int x){
        if(isFull()){
            System.out.println("queue full");return;}
        front=(front-1+capacity)%capacity;
        arr[front]=x;
        size++;
    }
    void deleteFront(){
        if(isEmpty()){
            System.out.println("queue Empty");return;}
        int  res=arr[front];
        System.out.println(res);
        arr[front]=0;
        front=(front+1)%capacity;
        size--;
    }
    void deleteRear(){
        if(isEmpty()){
            System.out.println("queue Empty");return;}
        int rear=(front+size-1)%capacity;
        System.out.println(arr[rear]);
        arr[rear]=0;
        size--;
    }
    boolean isEmpty(){
        return size==0;
    }
    boolean isFull(){
        return size==capacity;
    }
    void print(){
        System.out.println("arr"+ Arrays.toString(arr));
        System.out.print("front"+ front);
        System.out.println("size"+ size);
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node root;

    Tree() {
        // Hardcoded binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }
    public ArrayList<Integer> findSpiral() {
        // wrong
        ArrayList<Integer> arr=new ArrayList<Integer> ();
        if(root==null) return arr;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        q.add(null);
        boolean odd=true;
        while(q.size()>1){
            Node poll;
            if(odd)
            {poll=q.poll();}
            else {
                poll= ((LinkedList<Node>) q).get(q.size()-1);
                q.remove(poll);
            }
            if(poll==null){
                q.add(null);
                odd=!odd;
            }
            else{
                arr.add(poll.data);
                if(poll.left!=null)q.add(poll.left);
                if(poll.right!=null)q.add(poll.right);
            }
        }
        return arr;
    }

    int lcaRec(Node root,int n1, int n2){
        if(root==null) return 0;

        int left= lcaRec(root.left,n1, n2);
        int right= lcaRec(root.right,n1, n2);
        int count=left+right;
        if(count==2)
            System.out.println("this one"+root.data);

        if(root.data==n1 || root.data==n2)
            return 1+count;
        else
            return count;
    }

    Node buildTree(int[] inorder, int[] postorder) {
        // code here
        Map<Integer,Integer> postSeq=new HashMap<>();
        ArrayList<Integer> tree=new ArrayList<Integer>();

        for(int i=0;i<postorder.length;i++){
            postSeq.put(postorder[i],i);
            tree.add(inorder[i]);
        }// create map order

        return createTree(postorder[postorder.length-1],postSeq,tree);
    }
    Node createTree(int r, Map<Integer,Integer> postSeq,ArrayList<Integer> tree){
        Node root=new Node(r);
        ArrayList<Integer> lTree=new ArrayList<Integer>();
        ArrayList<Integer> rTree=new ArrayList<Integer>();
        int lRoot=0;
        int rRoot=0;
        int max=0;
        for(int i=0;i<tree.indexOf(r);i++){
            lTree.add(tree.get(i));
            if(postSeq.get(tree.get(i))>max)
            {
                lRoot=tree.get(i);
                max=postSeq.get(tree.get(i));
            }
        }
        max=0;
        for(int j=tree.indexOf(r)+1;j<tree.size() ;j++){
            rTree.add(tree.get(j));
            if(postSeq.get(tree.get(j))>max)
            {
                rRoot=tree.get(j);
                max=postSeq.get(tree.get(j));
            }
        }
        System.out.println("ltree "+lTree);
        System.out.println("rtree "+rTree);
        System.out.println("l root"+lRoot);
        System.out.println("r root"+rRoot);

        //assign left and right subtrees and roots
        if(lTree.size()!=0)
            root.left=createTree(lRoot, postSeq, lTree);
        if(rTree.size()!=0)
            root.right=createTree(rRoot, postSeq, rTree);
        return root;
    }
}