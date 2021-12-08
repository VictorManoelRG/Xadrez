/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xadrez.Pecas;

/**
 *
 * @author Usuario
 */
public class Cavalo extends PecasXadrez{
    int lado;
     
    public Cavalo(int PosicaoX, int PosicaoY, String cor, int lado) {
        super(PosicaoX, PosicaoY, cor);
        setNome("Cavalo");
        if(cor.equals("branco")){
            if(lado==1)setImagem("xadrez/ImagensPecas/cavaloE_brancachave.png");
            else setImagem("xadrez/ImagensPecas/cavaloD_brancachave.png");
        }
        else{
            if(lado==1)setImagem("xadrez/ImagensPecas/cavaloE_pretachave.png");
            else setImagem("xadrez/ImagensPecas/cavaloD_pretachave.png");
        }
    }
    
}
