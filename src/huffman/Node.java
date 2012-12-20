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

    private char value;
    private int frequency;
    public Node left;
    public Node right;
    public Node parent;

    public Node(char value, int frequency) {
        this.value = value;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public void incrementFrequency() {
        this.frequency++;
    }

    public int getFrequency() {
        return this.frequency;
    }
    
    public char getValue() {
        return this.value;
    }
    
    @Override
    public String toString() {
        return this.value + " : " + this.frequency;
    }

    @Override
    public int compareTo(Node other) {
        if(this.frequency < other.frequency) {
            return 1;
        }
        if(this.frequency > other.frequency) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
