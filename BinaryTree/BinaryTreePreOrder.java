package BinaryTree;

public class BinaryTreePreOrder {
    public static void preOrder(BinaryTree root){
        if (root!=null){
            System.out.print(root.data+"-");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args){
        int[] array={12,76,35,22,16,48,90,46,9,40};
        BinaryTree root=new BinaryTree(array[0]);
        for (int i=1;i<array.length;i++){
            root.insert(root,array[i]);
        }
        System.out.print("先根遍历");
        preOrder(root);
    }
}
