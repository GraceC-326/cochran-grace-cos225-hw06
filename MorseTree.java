// Grace Cochran
// COS 225 - HW6
public class MorseTree {
    
    public TreeNode<Character> root;

    public MorseTree(){
        root = new TreeNode<>('_');
    }

    public void morsePreorder(){
        root.preOrder(root);
    }    

    public void morsePostorder(){
        root.postOrder(root);
    }    

    // calls encodeChar for every letter in the string, sepparating the encoded characters by "|"
    public String encoder(String input){

        String finalStr = "";
        for (int i = 0; i < input.length(); i++){
            finalStr = finalStr + encodeChar(input.charAt(i), "", root);
            finalStr = finalStr + "|";
        }
        return finalStr;
    }

    // given the morse tree and a character of the string to be encoded, it checks if the character matches a node in the morse tree, if not it adds a dot or dash depending on how the inputted character is searched through the tree. 
    public String encodeChar(char input, String output, TreeNode<Character> node){
        
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

    // first splits the encoded input by "|", then calls decodeChar for every encoded letter in the string array.
    public String decoder(String input){
        // for loop for entire string 
        String[] splitStrings = input.split("\\|");
        String finalStr = "";
        for (int i = 0; i < splitStrings.length; i++){
            String temp = decodeChar(splitStrings[i]);
            finalStr = finalStr + temp;
        }
        
        return finalStr;
    }

    // Steps through the morse code tree to find a letter given its encoded self, moving left & right down the string based on if the string has a dot or dash.
    public String decodeChar(String input){
        
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
