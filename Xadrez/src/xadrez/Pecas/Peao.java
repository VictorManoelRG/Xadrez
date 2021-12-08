/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xadrez.Pecas;

/**
 *
 * @author Usuario
 */
public class Peao extends PecasXadrez{
   
    private boolean primeiroMov=true;
    
    public Peao(int PosicaoX, int PosicaoY, String cor) {
        super(PosicaoX, PosicaoY, cor);
        setNome("Peão");
        if(cor.equals("branco"))setImagem("xadrez/ImagensPecas/peao_brancachave.png");
        else if(cor.equals("preto"))setImagem("xadrez/ImagensPecas/peao_pretachave.png");
    }  
    
    /*public boolean validaMovimento(int x, int y, PecasXadrez[][] tab){
        System.out.println(getPosicaoX() + " " + getPosicaoY());
        if(getCor().equals("branco"))
        {
            if(primeiroMov == true){
                if(getPosicaoX() - y <= 2 && getPosicaoY() == x){
                    return true;
                }
                else return false;
            }
            else{
                if(getPosicaoY() - y == 1){
                    if(getPosicaoY() - x == 0)return true;
                    else if(tab[x][y].getCor().equals("preto") && (getPosicaoY() == x+1  || getPosicaoY() == x-1)){
                        return true;
                    }
                }
            }
        }
        else{
            if(primeiroMov == true){
                if(getPosicaoX() - y >= 2 && getPosicaoY() == x){
                    return true;
                }
                else return false;
            }
            else{
                if(getPosicaoX() - y == -1){
                    if(getPosicaoY() - x == 0)return true;
                    else if(tab[x][y].getCor().equals("preto") && (getPosicaoY() == x+1  || getPosicaoY() == x-1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }*/
}