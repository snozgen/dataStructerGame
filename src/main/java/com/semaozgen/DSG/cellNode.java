/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semaozgen.DSG;

import javax.swing.JButton;

/**
 *
 * @author sozgen
 */
public class cellNode {
    public JButton button;
    public String cellType;
    public cellNode next;
    public cellNode prev; // <-- Çift yönlü için eklendi

    public cellNode(JButton button, String cellType) {
        this.button = button;
        this.cellType = cellType;
        this.next = null;
        this.prev = null;
    }


}