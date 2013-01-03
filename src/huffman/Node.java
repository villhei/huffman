/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author Ville Heikkinen
 */
public class Node implements Comparable<Node>{

    public Character value;
    public Integer frequency;
    public Node left;
    public Node right;
    public Node parent;

    public Node(Character value, Integer frequency) {
        this.value = value;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
    
    @Override
    public String toString() {
        return this.value + " : " + this.frequency;
    }

    @Override
    public int compareTo(Node other) {
        if(this.frequency < other.frequency) {
            return -1;
        }
        if(this.frequency > other.frequency) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
