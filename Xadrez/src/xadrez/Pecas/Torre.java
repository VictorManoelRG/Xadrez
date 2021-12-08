/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xadrez.Pecas;

/**
 *
 * @author Usuario
 */
public class Torre extends PecasXadrez{
   
    public Torre(int PosicaoX, int PosicaoY, String cor) {
        super(PosicaoX, PosicaoY, cor);
        setNome("Torre");
        if(cor.equals("branco")) setImagem("xadrez/ImagensPecas/torre_brancachave.png");
        else if(cor.equals("preto")) setImagem("xadrez/ImagensPecas/torre_pretachave.png");       
    }  
}