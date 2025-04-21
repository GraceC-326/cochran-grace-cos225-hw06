// Grace Cochran, 4/11-18/25
//Tree Demo!

public class TreeNode<T>{
    
    private T element;
    private TreeNode<T> left;
    private TreeNode<T> right;

    // O (1)
    public TreeNode(T element){
        this.element = element;
    }

    // Getters:
    // O (1)
    public T getElement(){
        return element;
    }

    // O (1)
    public TreeNode<T> getLeft(){
        return left;
    }

    // O (1)
    public TreeNode<T> getRight(){
        return right;
    }

    // Setters:
    // O (1)
    public void setElement(T element){
        this.element = element;
    }

    // O (1)
    public void setLeft(TreeNode<T> left){
        this.left = left;
    }

    // O (1)
    public void setRight(TreeNode<T> right){
        this.right = right;
    }

    
    // O (n)
    public void inOrder(TreeNode<T> node){
        if (node == null){
            return;
        } 
        inOrder(node.getLeft());
        System.out.println(node.getElement());
        inOrder(node.getRight());
    }

    // O (n)
    public void preOrder(TreeNode<T> node){
        if (node == null){
            return;
        } 
        System.out.println(node.getElement());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    // O (n)
    public void postOrder(TreeNode<T> node){
        if (node == null){
            return;
        } 
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getElement());
    }

    // O (n)    
    // null node = -1, leaf node = 0, any other case = 1+
    public int height(){
        if (left == null && right == null){
            return 0;
        } 
        else if (left != null && right == null){
            return 1 + this.getLeft().height();
        } 
        else if (left == null && right != null) {
            return 1 + this.getRight().height();
        } 
        else {
            return 1 + Math.max(this.getLeft().height(), this.getRight().height());
        }
    }

    // O (n)
    // we will want to check for balance at certain points in the tree 
    public boolean isBalanced(){
        if (left == null && right == null){
            return true;
        } 
        else if (left != null && right == null){
            return this.getLeft().height() == 0;
        } 
        else if (left == null && right != null) {
            return this.getRight().height() == 0;
        } 
        else {
            return Math.abs(this.getLeft().height() - this.getRight().height()) <= 1;
        }
    }

    // O (n)
    public boolean isIn(T target){
        if (this.getElement().equals(target)){
            return true;
        } else if (this.getLeft() == null && this.getRight() == null){
            return false;
        } else {
            if (this.getRight() != null && this.getLeft() != null){
                return this.getLeft().isIn(target) || this.getRight().isIn(target);
            } else if (this.getRight() == null && this.getLeft() != null) {
                return this.getLeft().isIn(target);
            } else if (this.getRight() != null && this.getLeft() == null){
                return this.getRight().isIn(target);
            } else {
                return false;
            }
        }
    }

    // O (1)
    public void insertLeft(T element){
        if (this.getLeft() == null){
            this.setLeft(new TreeNode<>(element));
        } else {
            System.out.println("Cannot insert to left.");
        }
    }

    // O (1)
    public void insertRight(T element){
        if (this.getRight() == null){
            this.setRight(new TreeNode<>(element));
        } else {
            System.out.println("Cannot insert to right.");
        }
    }

    // O (n log n) n = number of nodes
    public void balancedInsert(T element){
        if (this.getLeft() == null){
            this.setLeft(new TreeNode<>(element));
        } else if (this.getRight() == null) { // also means if (this.getLeft() != null)
            this.setRight(new TreeNode<>(element));
        } else { // also means if (this.getLeft == null && this.getRight == null)
            if (this.getLeft().height() <= this.getRight().height()) {
                this.getLeft().balancedInsert(element);
            } else {
                this.getRight().balancedInsert(element);
            }
        }
    }

    // O (n)
    public void badRemoval(T element){ // can and will cut off branches and not free shit
        if (this.getLeft().getElement().equals(element)){
            this.setLeft(null);
        } else if (this.getRight().getElement().equals(element)){
            this.setRight(null);
        } else {
            this.getLeft().badRemoval(element);
            this.getRight().badRemoval(element);
        }
    }

    
}