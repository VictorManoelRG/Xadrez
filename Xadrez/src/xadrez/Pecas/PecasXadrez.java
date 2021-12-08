/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xadrez.Pecas;

public class PecasXadrez {
    private String nome;
    private int PosicaoX;
    private int PosicaoY;
    private String cor;
    private String imagem;
    public int selecionado=0;
    
    public PecasXadrez(int PosicaoX, int PosicaoY, String cor) {
        this.PosicaoX = PosicaoX;
        this.PosicaoY = PosicaoY;
        this.cor = cor;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getPosicaoX() {
        return PosicaoX;
    }

    public int getPosicaoY() {
        return PosicaoY;
    }

    public void setPosicaoX(int PosicaoX) {
        this.PosicaoX = PosicaoX;
    }

    public void setPosicaoY(int PosicaoY) {
        this.PosicaoY = PosicaoY;
    }
    
    /*public boolean validaMovimento(int x, int y, PecasXadrez[][] tab){
        return true;
    }*/
    
    public char letraCorrespondente(){
        switch (PosicaoY) {
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
        }
        return 0;
    }
    
    public int getY(){
        switch (PosicaoX){
            case 0:
                return 8;
            case 1:
                return 7;
            case 2:
                return 6;
            case 3:
                return 5;
            case 4:
                return 4;
            case 5:
                return 3;
            case 6:
                return 2;
            case 7:
                return 1;
        }
        return 0;
    } 
}
