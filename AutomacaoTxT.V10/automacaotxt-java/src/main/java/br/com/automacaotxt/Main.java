/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.com.automacaotxt;

/**
 *
 * @author mateus.costa
 */
public class Main {

    public static void main(String[] args) {
        LeituraResp leitura  = new LeituraResp();
        Resp resp = new Resp(leitura); // Criando a instância de Resp

        Processamento process = new Processamento(); // Criando a instância de Processamento

        // Criando Req depois de Processamento|
        Req req = new Req(process, leitura);

        // Inicializando as dependências
        // Criando ViewPrincipal
        ViewSecundaria viewSecundaria = new ViewSecundaria();
     

        ViewPrincipal view = new ViewPrincipal(req, resp, process, viewSecundaria, leitura);

        viewSecundaria.inicializar(req, view, process);
        process.inicializar(req, resp, view, leitura);

        view.iniciarAplicacao();  // Chama o método iniciarAplicacao() na instância de ViewPrincipal.

    }
}
