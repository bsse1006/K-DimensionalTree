package mainPackage;

import otherPackage.KDTree;
import otherPackage.KDTreeNode;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    private static int dimension;

    public static void main(String[] args)
    {
        Scanner cin  = new Scanner(System.in);

        System.out.print("Tree Dimension: ");
        dimension = cin.nextInt();
        KDTree tree = new KDTree(dimension);

        while(true)
        {
            System.out.println("1. Insert\n2. Search\n3. Print\n4. Exit\n");
            int choice;
            choice = cin.nextInt();

            if (choice==1)
            {
                tree.insert(createNode());
            }
            else if(choice==2)
            {
                tree.search(createNode());
            }
            else if(choice==3)
            {
                tree.print();
            }
            else if(choice==4)
            {
                break;
            }
        }
    }

    private static KDTreeNode createNode()
    {
        Scanner cin  = new Scanner(System.in);
        System.out.println("Enter node values: ");

        int [] data = new int [dimension];
        for (int i=0; i<dimension; i++)
        {
            data[i] = cin.nextInt();
        }

        return new KDTreeNode(dimension, data,null,null,null);
    }
}
