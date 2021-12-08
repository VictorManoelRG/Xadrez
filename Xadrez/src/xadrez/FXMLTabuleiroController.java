package xadrez;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import xadrez.Pecas.*;
//import javafx.scene.image.ImageView;

public class FXMLTabuleiroController implements Initializable { 
    private int acabou = 0;
    private int rodada = 0;
    
    // Variaveis jogadores
    private Jogador Jogador1 = new Jogador();
    private Jogador Jogador2 = new Jogador();
    private PecasXadrez MatrizPecas[][] = new PecasXadrez[8][8];
    private Button MatrizBotoes[][] = new Button[8][8];
    private ArrayList<Button> CasasPossiveis = new ArrayList<Button>();
    
    @FXML
    private Text nomeJogador1;
    @FXML
    private Text nomeJogador2;   
    @FXML
    private GridPane tabuleiroGrid;
    @FXML
    private Pane infoJogador1;   
    @FXML
    private Pane infoJogador2;
   
    @FXML
    private ArrayList<Button> PecasJogador1 = new ArrayList<>();
    @FXML
    private ArrayList<Button> PecasJogador2 = new ArrayList<>();
    @FXML
    private Button pecaSelecionada = new Button();
    
    private Button desistirJogador1;
    private Button desistirJogador2;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lerJogadores();
        limpaTXT();
        joga();
    }    
   
    public void lerJogadores()
    {
        try{
            File arquivo = new File("D:\\Usuario\\Documents\\PUC-Campinas\\4 semestre\\Paradigmas B\\Xadrez\\Xadrez\\src\\xadrez/ArquivoAux.txt");     
            Scanner leitura = new Scanner(arquivo);
                    
            while(leitura.hasNextLine())
            {
                Jogador1.setNome(leitura.nextLine());
                Jogador2.setNome(leitura.nextLine());
            }
        }catch(IOException Ex){
               Ex.printStackTrace();          
        }   
        nomeJogador1.setText(Jogador1.getNome());
        nomeJogador2.setText(Jogador2.getNome());
    }
    
    public void desenhaTabuleiro(){
        int cor = 0;
        int cordX, cordY;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Button botao = new Button();
                botao.setPrefSize(85, 85);
                botao.setId("casas");
                if(cor == 0){
                    botao.setId("CasaClara");
                    cor++;
                }               
                else if (cor == 1){
                    botao.setId("CasaEscura");
                    cor--;
                }
                tabuleiroGrid.add(botao, j, i);    
                botao.setOnAction(e->{
                    movePeca(tabuleiroGrid.getRowIndex(botao),tabuleiroGrid.getColumnIndex(botao));   
                });
                
            }
            if(i%2 == 0)cor++;
            else cor--; 
        }
    }
    
    public void desenhaPecas(){  
        for(int i=0; i<8; i++)
        {            
            for(int j=0; j<8; j++){
                if(i == 0){
                    Button botaobranca = new Button();                 
                    botaobranca.setId("pecas");
                    if(j == 0 || j == 7){
                        Torre TorreBranco = new Torre(i,j,"branco");
                        estilizaBotaoPecas(botaobranca, TorreBranco);
                        MatrizPecas[i][j] = TorreBranco;
                    }
                    
                    if(j == 1){
                        Cavalo CavaloBranco = new Cavalo(i,j,"branco", 0);
                        estilizaBotaoPecas(botaobranca, CavaloBranco);
                        MatrizPecas[i][j] = CavaloBranco;
                    }
                    
                    if(j == 3){
                        Rainha RainhaBranco = new Rainha(i,j,"branco");
                        estilizaBotaoPecas(botaobranca, RainhaBranco);
                        MatrizPecas[i][j] = RainhaBranco;
                    }
                    
                    if(j == 4){
                        Rei ReiBranco = new Rei(i,j,"branco");
                        estilizaBotaoPecas(botaobranca, ReiBranco);
                        MatrizPecas[i][j] = ReiBranco;
                    }
                    
                    if(j == 2 || j == 5){
                        Bispo BispoBranco = new Bispo(i,j,"branco");
                        estilizaBotaoPecas(botaobranca, BispoBranco);
                        MatrizPecas[i][j] = BispoBranco;
                    }
                                                         
                    if(j == 6){
                        Cavalo CavaloBranco = new Cavalo(i,j,"branco", 1);
                        estilizaBotaoPecas(botaobranca, CavaloBranco);
                        MatrizPecas[i][j] = CavaloBranco;
                    }
                    tabuleiroGrid.add(botaobranca, j, i);   
                    PecasJogador1.add(botaobranca);
                    MatrizBotoes[i][j] = botaobranca;
                }
                
                // PEÇAS PRETAS
                if(i == 7){
                    Button botaopreta = new Button();
                    botaopreta.setId("pecas");
                    if(j == 0 || j == 7){
                        Torre TorrePreto = new Torre(i,j,"preto");
                        estilizaBotaoPecas(botaopreta, TorrePreto);  
                        MatrizPecas[i][j] = TorrePreto;
                    }
                    
                    if(j == 1){
                        Cavalo CavaloPreto = new Cavalo(j,i,"preto", 0);
                        estilizaBotaoPecas(botaopreta, CavaloPreto);
                        MatrizPecas[i][j] = CavaloPreto;
                    }
                    
                    if(j == 3){
                        Rainha RainhaPreto = new Rainha(i,j,"preto");
                        estilizaBotaoPecas(botaopreta, RainhaPreto);
                        MatrizPecas[i][j] = RainhaPreto;
                    }
                    
                    if(j == 4){
                        Rei ReiPreto = new Rei(i,j,"preto");
                        estilizaBotaoPecas(botaopreta, ReiPreto);
                        MatrizPecas[i][j] = ReiPreto;
                    }
                    
                    if(j == 2 || j == 5){
                        Bispo BispoPreto = new Bispo(i,j,"preto");
                        estilizaBotaoPecas(botaopreta, BispoPreto);
                        MatrizPecas[i][j] = BispoPreto;
                    }
                                                         
                    if(j == 6){
                        Cavalo CavaloPreto = new Cavalo(i,j,"preto", 1);
                        estilizaBotaoPecas(botaopreta, CavaloPreto);  
                        MatrizPecas[i][j] = CavaloPreto;
                    }
                    tabuleiroGrid.add(botaopreta, j, i);      
                    PecasJogador2.add(botaopreta);
                    MatrizBotoes[i][j] = botaopreta;
                }
                
                if(i == 1){
                    Button botao = new Button();
                    Peao PeaoBranco = new Peao(i,j,"branco");
                    botao.setId("pecas");
                    estilizaBotaoPecas(botao, PeaoBranco); 
                    tabuleiroGrid.add(botao, j, i);    
                    PecasJogador1.add(botao);
                    MatrizBotoes[i][j] = botao;
                    MatrizPecas[i][j] = PeaoBranco;
                }
                
                else if (i == 6){
                    Button botao = new Button();
                    Peao PeaoPreto = new Peao(i,j,"preto");
                    botao.setId("pecas");
                    estilizaBotaoPecas(botao, PeaoPreto);
                    tabuleiroGrid.add(botao, j, i);     
                    PecasJogador2.add(botao);
                    MatrizBotoes[i][j] = botao;
                    MatrizPecas[i][j] = PeaoPreto;
                }                   
            }
        }
    }   

    public Button estilizaBotaoPecas(Button botao, PecasXadrez peca){
        ImageView imagem = new ImageView(peca.getImagem());
        imagem.setFitHeight(75);
        imagem.setFitWidth(64);
        botao.setGraphic(imagem);
        botao.setPrefSize(200, 200);
        return botao;
    }
    
    @FXML
    public void alteraTurno(){
        if(rodada %2 == 0){
            infoJogador1.setVisible(true);
            infoJogador2.setVisible(false);
            for(int i=0; i<16; i++){
                Jogador1.getPecas().get(i).setDisable(false);
                Jogador2.getPecas().get(i).setDisable(true);
            }
        }
        else{
            infoJogador1.setVisible(false);
            infoJogador2.setVisible(true);
            for(int i=0; i<16; i++){
                Jogador1.getPecas().get(i).setDisable(true);
                Jogador2.getPecas().get(i).setDisable(false);
            }
        }
        rodada++;
    }
       
    // J1 -> quem vai jogar no turno
    public void joga(){
        Jogador1.setPecas(PecasJogador1);
        Jogador2.setPecas(PecasJogador2);
        
        desenhaTabuleiro();
        desenhaPecas();
        funcaoBotaoPecas();
               
        while(acabou < 1){   
            alteraTurno();
            acabou++;
        }
    }
      
    public void funcaoBotaoPecas(){
        for(int i=0; i<Jogador1.getPecas().size(); i++){
            Jogador1.getPecas().get(i).setOnAction(e->{
                pecaSelecionada = (Button)e.getSource();
                //mostraPossibilidades();
            });
        }
        for(int i=0; i<Jogador2.getPecas().size(); i++){
            Jogador2.getPecas().get(i).setOnAction(e->{
                pecaSelecionada = (Button)e.getSource();
                //mostraPossibilidades();              
            });
        }
    }
    
    /*public void mostraPossibilidades(){
        int X = tabuleiroGrid.getRowIndex(pecaSelecionada);
        int Y = tabuleiroGrid.getColumnIndex(pecaSelecionada);  
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(MatrizPecas[X][Y].validaMovimento(i, j, MatrizPecas) == true){
                    Button a = new Button();
                    CasasPossiveis.add(a);
                    a.setId("teste");
                    tabuleiroGrid.add(a, i, j);
                }
            }
        }
    }*/
    
    public void verificaAcabou(){
        if(PecasJogador1.isEmpty()){
            System.out.println("acabou, jogador 2 ganhou");
            acabou++;
        }
        else if(PecasJogador2.isEmpty()){
            System.out.println("acabou, jogador 1 ganhou");
            acabou++;
        }
        
        if(rodada == 50){
            System.out.println("acabou rodadas");
            acabou++;
        }
    }
    
    public void movePeca(int x, int y){
        int xantigo, yantigo;
        tabuleiroGrid.getChildren().removeAll(CasasPossiveis);
        if(pecaSelecionada != null){
            xantigo = tabuleiroGrid.getRowIndex(pecaSelecionada);
            yantigo = tabuleiroGrid.getColumnIndex(pecaSelecionada);
            
            if(MatrizBotoes[x][y] != null && (MatrizPecas[x][y].getCor() != MatrizPecas[xantigo][yantigo].getCor())){
                if(MatrizPecas[x][y].getNome().equals("Rei")){
                    acabou++;
                    xeque(MatrizPecas[xantigo][yantigo].getCor());
                }
                tabuleiroGrid.getChildren().remove(MatrizBotoes[x][y]);   
                if(MatrizPecas[x][y].getCor().equals("branco"))PecasJogador1.remove(MatrizPecas[x][y]);
                else PecasJogador2.remove(MatrizPecas[x][y]);
            }
            tabuleiroGrid.getChildren().remove(pecaSelecionada);    
            tabuleiroGrid.add(pecaSelecionada,y,x); 
            
            MatrizBotoes[xantigo][yantigo] = null;
            MatrizBotoes[x][y] = pecaSelecionada;
            
            MatrizPecas[x][y] = MatrizPecas[xantigo][yantigo];
            MatrizPecas[xantigo][yantigo] = null;
            MatrizPecas[x][y].setPosicaoX(x);
            MatrizPecas[x][y].setPosicaoY(y);
            try {
                escreveJogada(MatrizPecas[x][y]);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            alteraTurno();
            pecaSelecionada = null;
        }
    }
    
    public void escreveJogada(PecasXadrez peca) throws IOException
    {
        String nomeJogador;
        if(peca.getCor().equals("branco"))nomeJogador = Jogador1.getNome();
        else nomeJogador = Jogador2.getNome();
        FileWriter Arquivo = new FileWriter("D:\\Usuario\\Documents\\PUC-Campinas\\4 semestre\\Paradigmas B\\Xadrez\\Xadrez\\src\\xadrez/LogJogadas.txt", true);
        PrintWriter PW = new PrintWriter(Arquivo);
        PW.println("(" + nomeJogador + ") " + peca.getNome() + "-> " + peca.letraCorrespondente() +  peca.getY());
        PW.flush();
        Arquivo.close();
        PW.close();
    }  
    
    public void limpaTXT(){
        try{
            FileWriter Arquivo = new FileWriter("D:\\Usuario\\Documents\\PUC-Campinas\\4 semestre\\Paradigmas B\\Xadrez\\Xadrez\\src\\xadrez/LogJogadas.txt", false);
            PrintWriter PW = new PrintWriter(Arquivo);
            Arquivo.close();
            PW.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void botao_desistir(ActionEvent event){
        String vencedor, perdedor;
        if((Button)event.getSource() == desistirJogador1){
            vencedor = Jogador2.getNome();
            perdedor = Jogador1.getNome();
        }
        else{
            vencedor = Jogador1.getNome();
            perdedor = Jogador2.getNome();
        }
        
        Alert Aviso = new Alert(Alert.AlertType.WARNING);      
        Aviso.setTitle("VITÓRIA!");
        Aviso.setHeaderText(vencedor + " deu uma surra e \n" + perdedor + " desistiu!");
        Aviso.showAndWait();     
    }
    
    public void botao_empate(ActionEvent event){
        String j1;
        if((Button)event.getSource() == desistirJogador1){
            j1 = Jogador2.getNome();
        }
        else{
            j1 = Jogador1.getNome();
        }
        
        Alert Aviso = new Alert(Alert.AlertType.WARNING);      
        Aviso.setTitle("EMPATE!");
        Aviso.setHeaderText(j1 + " propôs um empate \n");
        Aviso.showAndWait();     
    }
    
    public void xeque(String cor){
        String ganhador;
        if(cor == "branco")ganhador = Jogador1.getNome();
        else ganhador = Jogador2.getNome();
        
        Alert Aviso = new Alert(Alert.AlertType.WARNING);      
        Aviso.setTitle("VITÓRIA!");
        Aviso.setHeaderText(ganhador + " deu uma surra");
        Aviso.showAndWait();    
    }
}
