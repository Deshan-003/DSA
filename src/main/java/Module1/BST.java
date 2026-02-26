package Module1;

public class BST {


    private static class BSTNode {
        String locationName;
        BSTNode left, right;

        BSTNode(String name) {
            this.locationName = name;
            this.left = null;
            this.right = null;
        }
    }
        private BSTNode root;


        public BST() {
            root = null;
        }
        public void insert(String name) {
            root = insertRec(root, name);
        }
        
        private BSTNode insertRec(BSTNode node, String name){
            if (node == null) return new BSTNode(name);
            int cmp = name.compareToIgnoreCase(node.locationName);
            if (cmp<0)
                node.left=insertRec(node.left,name);
            else if (cmp>0)
                node.right= insertRec(node.right,name);
            return node ;
        }
        public boolean search(String name) {
        return searchRec(root, name);
        }
        private boolean searchRec(BSTNode node,String name){
            if (node==null ) return false;
            int cmp= name.compareToIgnoreCase(node.locationName);
            if(cmp==0) return true;
            else if (cmp<0)return searchRec(node.left,name);
            else return searchRec(node.right,name);
        }

        public void delete( String name){
            root= deleteRec(root, name);
        }
        private BSTNode deleteRec(BSTNode node, String name){
            if (node==null) return null ;
            int cmp = name.compareToIgnoreCase(node.locationName);
            if (cmp < 0) {
                node.left = deleteRec(node.left, name);
            }
            else if (cmp > 0) {
                node.right = deleteRec(node.right, name);
            }
            else {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;

                BSTNode successor = findMin(node.right);
                node.locationName = successor.locationName;
                node.right = deleteRec(node.right, successor.locationName);
            }
            return node;
        }
            private BSTNode findMin(BSTNode node) {
            while (node.left != null) node = node.left;
            return node;
    }
        public void displayInOrder(){
            System.out.print("location in BST(aplphabetical : )");
            inOrderRec(root);
            System.out.println();

        }
        private void inOrderRec(BSTNode node){
            if (node== null) return;
            inOrderRec(node.left);
            System.out.print("["+ node.locationName+ "]");
            inOrderRec(node.right);
        }








}
