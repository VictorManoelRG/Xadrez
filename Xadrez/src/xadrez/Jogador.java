/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xadrez;

import java.util.ArrayList;
import javafx.scene.control.Button;
import xadrez.Pecas.PecasXadrez;

/**
 *
 * @author Usuario
 */
public class Jogador {
    private String nome;
    ArrayList<Button> pecas = new ArrayList<Button>();

    public void setPecas(ArrayList<Button> pecas) {
        this.pecas = pecas;
    }
    
    public ArrayList<Button> getPecas() {
        return pecas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
