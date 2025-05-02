// Grace Cochran
// COS 225 - HW6
public class MorseTester {
    public static void main() {

        MorseTree morsecoder = new MorseTree();

        morsecoder.root.insertLeft('e');
        morsecoder.root.insertRight('t');

        morsecoder.root.getLeft().insertLeft('i');
        morsecoder.root.getLeft().insertRight('a');
        morsecoder.root.getRight().insertLeft('n');      
        morsecoder.root.getRight().insertRight('m');   

        morsecoder.root.getLeft().getLeft().insertLeft('s');
        morsecoder.root.getLeft().getLeft().insertRight('u');
        morsecoder.root.getLeft().getRight().insertLeft('r');
        morsecoder.root.getLeft().getRight().insertRight('w');
        morsecoder.root.getRight().getLeft().insertLeft('d');      
        morsecoder.root.getRight().getLeft().insertRight('k'); 
        morsecoder.root.getRight().getRight().insertLeft('g');      
        morsecoder.root.getRight().getRight().insertRight('o'); 
        
        morsecoder.root.getLeft().getLeft().getLeft().insertLeft('h');
        morsecoder.root.getLeft().getLeft().getLeft().insertRight('v');
        morsecoder.root.getLeft().getLeft().getRight().insertLeft('f');
        morsecoder.root.getLeft().getRight().getLeft().insertLeft('l');
        morsecoder.root.getLeft().getRight().getRight().insertLeft('p');
        morsecoder.root.getLeft().getRight().getRight().insertRight('j');
        morsecoder.root.getRight().getLeft().getLeft().insertLeft('b');
        morsecoder.root.getRight().getLeft().getLeft().insertRight('x');
        morsecoder.root.getRight().getLeft().getRight().insertLeft('c');
        morsecoder.root.getRight().getLeft().getRight().insertRight('y');
        morsecoder.root.getRight().getRight().getLeft().insertLeft('z');
        morsecoder.root.getRight().getRight().getLeft().insertRight('q');

        morsecoder.morsePreorder();
        morsecoder.morsePostorder();

        String testString = "go watch a playthrough of rolypolys no nanakorobi yaoki";
        // this is a relevant reference i swear

        String encodedStr = morsecoder.encoder(testString);
        System.out.println(encodedStr);
        String decodedStr = morsecoder.encoder(encodedStr);
        System.out.println(decodedStr);
        
    }
}
