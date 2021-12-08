/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xadrez.Pecas;

/**
 *
 * @author Usuario
 */
public class Bispo extends PecasXadrez{
    
    public Bispo(int PosicaoX, int PosicaoY, String cor) {
        super(PosicaoX, PosicaoY, cor);
        setNome("Bispo");
        if(cor.equals("branco"))setImagem("xadrez/ImagensPecas/bispo_brancachave.png");
        else if(cor.equals("preto")) setImagem("xadrez/ImagensPecas/bispo_pretachave.png");  
    }
    
}
