package Module1;

public class BST {


    private static class BSTNode{
        String locationName;
        BSTNode left, right;

        BSTNode(String name) {
            this.locationName = name;
            this.left = null;
            this.right = null;
        }
        private BSTNode root;


        public BST() {
            root = null;
        }
        public void insert(String name) {
            root = insertRec(root, name);
        }







    }



}
