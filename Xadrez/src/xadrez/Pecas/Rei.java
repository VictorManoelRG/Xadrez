/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xadrez.Pecas;

/**
 *
 * @author Usuario
 */
public class Rei extends PecasXadrez{
   
    public Rei(int PosicaoX, int PosicaoY, String cor) {
        super(PosicaoX, PosicaoY, cor);
        setNome("Rei");
        if(cor.equals("branco")) setImagem("xadrez/ImagensPecas/rei_brancachave.png");
        else if(cor.equals("preto")) setImagem("xadrez/ImagensPecas/rei_pretachave.png");       
    }  
}
