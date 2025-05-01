// Grace Cochran
// COS 225 - HW6
public class MorseTree {
    
    public TreeNode<Character> root;

    public MorseTree(){
        root = new TreeNode<>(null);
    }

    public void morsePreorder(){
        root.preOrder(root);
    }    

    public void morsePostorder(){
        root.postOrder(root);
    }    

    public String encoder(String input){

        return "a";
    }

    public String decoder(String input){
        
        
        return "b";
    }

}
