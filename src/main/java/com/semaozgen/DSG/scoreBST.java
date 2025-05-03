/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semaozgen.DSG;

/**
 *
 * @author sozgen
 */
public class scoreBST {

    class Node {
        String username;
        String level;
        int score;
        Node left, right;

        Node(String username, String level, int score) {
            this.username = username;
            this.level = level;
            this.score = score;
        }
    }

    private Node root;

    public void insert(String username, String level, int score) {
        root = insertRec(root, username, level, score);
    }

    private Node insertRec(Node root, String username, String level, int score) {
        if (root == null) return new Node(username, level, score);
        if (score < root.score) root.left = insertRec(root.left, username, level, score);
        else root.right = insertRec(root.right, username, level, score);
        return root;
    }

    // In-order (sol-orta-sağ) sıralı yazdırma
    public void appendInOrder(StringBuilder sb) {
        appendInOrderRec(root, sb);
    }

    private void appendInOrderRec(Node root, StringBuilder sb) {
        if (root != null) {
            appendInOrderRec(root.left, sb);
            sb.append(root.username)
              .append(" - ")
              .append(root.level)
              .append(" - ")
              .append(root.score)
              .append("\n");
            appendInOrderRec(root.right, sb);
        }
    }

    // En yüksek skoru bul
    public Node getBestScore() {
        Node current = root;
        if (current == null) return null;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    // En düşük skoru bul
    public Node getWorstScore() {
        Node current = root;
        if (current == null) return null;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Skorları ve en iyi/en kötü skoru yazdır
    public String printScoresWithBestWorst() {
        StringBuilder sb = new StringBuilder();
        appendInOrder(sb);

        Node best = getBestScore();
        Node worst = getWorstScore();

        if (best != null) {
            sb.append("\nBest score : ")
              .append(best.score)
              .append(" (")
              .append(best.level)
              .append(")\n");
        }
        if (worst != null) {
            sb.append("Worst score : ")
              .append(worst.score)
              .append(" (")
              .append(worst.level)
              .append(")\n");
        }
        return sb.toString();
    }
}