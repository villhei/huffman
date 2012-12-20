/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Ville Heikkinen
 */
public class Huffman {

    public static void main(String[] args) {

        HuffmanCompressor hc = new HuffmanCompressor("inputs/testfile");
        hc.createHuffmanTree();
    }
}
