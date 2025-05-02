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
        // letter
        String finalStr = "";
        for (int i = 0; i < input.length(); i++){
            finalStr = finalStr + encodeChar(input.charAt(i), "", root);
            finalStr = finalStr + "|";
        }
        return finalStr;
    }

    public String encodeChar(char input, String output, TreeNode<Character> node){
        // letter

        if (node.getElement() == input){
            return output;
        }
        else{
            if (node.getLeft() == null && node.getRight() == null){
                return "";
            } else if (node.getLeft() != null && node.getRight() == null){
                return encodeChar(input, output + "o", node.getLeft());
            } else if (node.getLeft() == null && node.getRight() != null){
                return encodeChar(input, output + "-", node.getRight());
            } else{
                return encodeChar(input, output + "o", node.getLeft()) + encodeChar(input, output + "-", node.getRight());
            }
        }
    }

    public String decoder(String input){
        // for loop for entire string 
        String[] splitStrings = input.split("/|");
        String finalStr = "";
        for (int i = 0; i < splitStrings.length; i++){
            String temp = decodeChar(splitStrings[i]);
            finalStr = finalStr + temp;
        }
        
        return finalStr;
    }

    public String decodeChar(String input){
        // if a dot, go left, if  a dash, go right.
        // step thru the tree
        
        TreeNode<Character> temp = root;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == 'o'){
                temp = temp.getLeft();
            }
            else if (input.charAt(i) == '-'){
                temp = temp.getRight();
            }
        }

        return temp.getElement() + "";
    }
}
