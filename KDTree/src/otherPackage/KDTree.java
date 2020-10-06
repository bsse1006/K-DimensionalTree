package otherPackage;

public class KDTree
{
    private int dimension;
    private KDTreeNode root = null;
    String indent = "";
    int flag = 0;

    public KDTree(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public KDTreeNode getRoot() {
        return root;
    }

    public void insert (KDTreeNode node)
    {
        if(root==null)
        {
            root=node;
            root.setLevel(0);
        }
        else
        {
            KDTreeNode currentRoot = root;

            for(int l=0; ; l++)
            {
                if (node.getData()[l%dimension]<currentRoot.getData()[l%dimension])
                {
                    if(currentRoot.getLeftChild()==null)
                    {
                        currentRoot.setLeftChild(node);
                        node.setParent(currentRoot);
                        node.setLevel(currentRoot.getLevel()+1);
                        break;
                    }
                    else
                    {
                        currentRoot = currentRoot.getLeftChild();
                    }
                }
                else
                {
                    if(currentRoot.getRightChild()==null)
                    {
                        currentRoot.setRightChild(node);
                        node.setParent(currentRoot);
                        node.setLevel(currentRoot.getLevel()+1);
                        break;
                    }
                    else
                    {
                        currentRoot = currentRoot.getRightChild();
                    }
                }
            }
        }
    }

    private boolean match (int [] a, int [] b)
    {
        for (int i=0; i<a.length; i++)
        {
            if(a[i]!=b[i])
            {
                return false;
            }
        }
        return true;
    }

    private void searchMatch (KDTreeNode node, KDTreeNode currentNode)
    {
        if(match(node.getData(), currentNode.getData()))
        {
            System.out.println("Node found");
            System.out.println("Level: " + currentNode.getLevel());
            flag = 1;
            return;
        }
        else
        {
            if(currentNode.getRightChild()!=null)
            {
                searchMatch(node, currentNode.getRightChild());
            }
            if(currentNode.getLeftChild()!=null)
            {
                searchMatch(node, currentNode.getLeftChild());
            }
        }
    }

    public void search (KDTreeNode node)
    {
        searchMatch(node, root);
        if (flag == 0)
        {
            System.out.println("Node not found");
        }
        flag = 0;
    }

    private void printNode (KDTreeNode node)
    {
        if (node==root)
        {
            System.out.print("Root: ");
        }
        else if (node.getParent().getLeftChild()==node)
        {
            System.out.print("Left Child: ");
        }
        else if (node.getParent().getRightChild()==node)
        {
            System.out.print("Right Child: ");
        }
        for(int i=0; i<node.getData().length; i++)
        {
            System.out.print(node.getData()[i] + " ");
        }
        System.out.println("Level: " + node.getLevel());
        if(node.getLeftChild()!=null)
        {
            indent = indent + "----";
            System.out.print(indent);
            printNode(node.getLeftChild());
            indent = indent.substring(0,indent.length()-4);
        }
        if(node.getRightChild()!=null)
        {
            indent = indent + "----";
            System.out.print(indent);
            printNode(node.getRightChild());
            indent = indent.substring(0,indent.length()-4);
        }
    }

    public void print ()
    {
        printNode(root);
    }
}
