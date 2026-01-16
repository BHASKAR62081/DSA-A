import java.util.LinkedList;
import java.util.Queue;

public class BTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
        //preorder
        public void preOrder(Node root){
            if(root == null){
                //System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        //inorder
        public void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
        //postorder
        public void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        //levelorder
        public void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        //height
        public int height (Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            int height = Math.max(lh,rh) + 1;
            return height;
        }
        //countnode
        public int countNode(Node root){
            if(root == null){
                return 0;
            }

            int lc = countNode(root.left);
            int rc = countNode(root.right);
            int count = lc + rc + 1;
            return count;
        }
        //sum
        public int sum(Node root){
            if(root == null){
                return 0;
            }

            int ls = sum(root.left);
            int rs = sum(root.right);
            return ls + rs+ root.data;
        }
        //diameter 1 --> O(N^2)
        public int diameter(Node root){
            if(root == null){
                return 0;
            }
            int leftDiam = diameter(root.left);
            int rightDiam = diameter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            int selfDiam = (lh+rh+1);
            return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
        }

        //diameter 2 --> O(N)
        static class Info{
            int diam;
            int ht;

            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }
        public Info diameter2(Node root){
            if(root == null){
                return new Info(0, 0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);
            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
            return new Info(diam, ht);
        }
    }
     

    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        //System.out.println(root.data);
        System.out.println("Preorder: ");
        tree.preOrder(root);
        System.out.println();
        System.out.println("Inorder: ");
        tree.inOrder(root);
        System.out.println();
        System.out.println("Postorder: ");
        tree.postOrder(root);
        System.out.println();
        System.out.println("Levelorder: ");
        tree.levelOrder(root);
        System.out.println("Height: ");
        System.out.println(tree.height(root));
        System.out.println("Node Count: ");
        System.out.println(tree.countNode(root));
        System.out.println("Sum of Nodes: ");
        System.out.println(tree.sum(root));
        System.out.println("Diameter1 of Tree(O(N^2)): ");
        System.out.println(tree.diameter(root));
        System.out.println("Diameter2 of Tree(O(N)): ");
        System.out.println(tree.diameter2(root).diam);
    }
}
