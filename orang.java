/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasQueue;

public class orang {
    String nama;
    int prioritas;
    orang next, prev;
    
    public orang(String n, int p) {
        nama = n;
        prioritas = p;
        next = prev = null;
    }
}
