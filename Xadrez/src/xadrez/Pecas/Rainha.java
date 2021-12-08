/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xadrez.Pecas;

/**
 *
 * @author Usuario
 */
public class Rainha extends PecasXadrez{
   
    public Rainha(int PosicaoX, int PosicaoY, String cor) {
        super(PosicaoX, PosicaoY, cor);
        setNome("Rainha");
        if(cor.equals("branco")) setImagem("xadrez/ImagensPecas/rainha_brancachave.png");
        else if(cor.equals("preto")) setImagem("xadrez/ImagensPecas/rainha_pretachave.png");       
    }  
}
