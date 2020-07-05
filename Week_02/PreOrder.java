//N叉树的前序遍历

public List<Integer> preorder(Node root) {
        //前序遍历：根-左-右
        List<Integer> res=new ArrayList();
        retree(root,res);
        return res;
        }
public void retree(Node root,List<Integer> res){
        if(root!=null){
        res.add(root.val);
        if(root.children.size()!=0){
        for(Node node:root.children){
        retree(node,res);
        }
        }
        }
        }