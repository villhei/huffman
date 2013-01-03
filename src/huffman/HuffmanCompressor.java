/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Ville Heikkinen
 */
public class HuffmanCompressor {

    private final int ALPHABET_SIZE = 256;
    private int[] frequencies;
    private String[] codewords;
    private PriorityQueue<Node> heap;
    private FileInputStream inputstream;
    private BufferedReader buffer;
    private File inputfile;
    private InputStreamReader ioreader;

    public HuffmanCompressor(String filepath) {
        inputfile = new File(filepath);
        try {
            inputstream = new FileInputStream(inputfile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found! " + e);
            System.exit(1);
        }
    }

    public void createHuffmanTree() {
        try {
            readFrequenciesFromFile();
            //printFrequencies();
            constructHeap();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        buildTreeFromHeap();
        createCodeWords();
    }

    public void writeFile(String filename) {
    }

    private void constructHeap() {
        heap = new PriorityQueue<>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] == 0) {
                continue;
            }
            heap.add(new Node((char) i, frequencies[i]));
        }
        System.out.println(heap);
        System.out.println(heap.size());
    }

    private void readFrequenciesFromFile() throws IOException {
        int input;
        frequencies = new int[ALPHABET_SIZE];
        while ((input = inputstream.read()) != -1) {
            frequencies[input]++;
        }
    }

    public void printFrequencies() {
        System.out.println();
        for (int i = 0; i < frequencies.length; ++i) {
            if (frequencies[i] != 0) {
                System.out.println((char) i + " : " + frequencies[i]);
            }
        }
    }

    private void buildTreeFromHeap() {
        while (heap.size() >= 2) {
            Node newnode = new Node(null, null);
            newnode.left = heap.remove();
            newnode.right = heap.remove();
            newnode.frequency = newnode.left.frequency + newnode.right.frequency;
            heap.add(newnode);
        }
    }

    private void createCodeWords() {
        codewords = new String[ALPHABET_SIZE];
        Node tree = heap.remove();
        treeWalk(tree, null);
    }

    private void treeWalk(Node node, String code) {
        if (node == null) {
            return;
        }
        if (code == null) {
            code = "";
        }
        if (node.value != null) {
            codewords[(int) node.value] = code;
            return;
        }
        treeWalk(node.left, code + '0');
        treeWalk(node.right, code + '1');
    }
}
