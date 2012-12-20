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

    final private int ALPHABET_SIZE = 256;
    private int[] frequencies;
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

    void createHuffmanTree() {
        try {
            readFrequenciesFromFile();
            //printFrequencies();
            constructHeap();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
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
}