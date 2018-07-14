/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            sb.append('X');
        else {
            sb.append(root.val);
            sb.append('#');
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    sb.append(temp.left.val);
                    sb.append('#');
                    queue.offer(temp.left);
                }
                else {
                    sb.append('X');
                    sb.append('#');

                }
                if(temp.right != null) {
                    sb.append(temp.right.val);
                    sb.append('#');
                    queue.offer(temp.right);
                }
                else {
                    sb.append('X');
                    sb.append('#');
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        int i = 0;
        index = data.indexOf('#');
        if(data.charAt(i) == 'X')
            return null;
        root = new TreeNode(Integer.parseInt(data.substring(0, index)));
        queue.offer(root);
        i = index+1;
        while(i < data.length()) {
            int len = queue.size();
            for(int j = 0; j < len; j++) {
                TreeNode temp = queue.poll();
                index = data.indexOf('#', i);
                if(data.charAt(i) == 'X')
                    temp.left = null;
                else {
                    temp.left = new TreeNode(Integer.parseInt(data.substring(i, index)));
                    queue.offer(temp.left);
                }    
                i = index+1;
                index = data.indexOf('#', i);
                if(data.charAt(i) == 'X')
                    temp.right = null;
                else {
                    temp.right = new TreeNode(Integer.parseInt(data.substring(i, index)));
                    queue.offer(temp.right);
                }    
                i = index+1;
            }
            
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
