Huffman coding algorithm for input files, written in Java
=========================================================

Work in progress.

Huffman is a character frequency calculating algorithm working in O(n log n)time.

The idea of Huffman alogrithm is to construct a 'Huffman Tree', which then can be used
to compress an input string on byte-level. 

This implementation of Huffman coding is going to use homebrew data structures:
- Priority queue or a minimum heap
- Huffman tree

This program will support two operations
- Compression of an input file of characters
- Decompression to an output file
