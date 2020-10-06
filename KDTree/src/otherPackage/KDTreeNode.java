package otherPackage;

import java.util.List;

public class KDTreeNode
{
    private int dimension;
    private int level;
    private int [] data;
    private KDTreeNode parent;
    private KDTreeNode leftChild;
    private KDTreeNode rightChild;

    public KDTreeNode(int dimension, int[] data, KDTreeNode parent, KDTreeNode leftChild, KDTreeNode rightChild) {
        this.dimension = dimension;
        this.data = new int [this.dimension];
        for(int i=0; i<this.dimension; i++)
        {
            this.data[i] = data [i];
        }
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getDimension() {
        return dimension;
    }

    public int[] getData() {
        return data;
    }

    public KDTreeNode getParent() {
        return parent;
    }

    public void setParent(KDTreeNode parent) {
        this.parent = parent;
    }

    public KDTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(KDTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public KDTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(KDTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
