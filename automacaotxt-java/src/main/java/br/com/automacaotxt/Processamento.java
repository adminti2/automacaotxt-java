/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.automacaotxt;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus.costa
 */
public class Processamento {

    private final Logger logger = Logger.getLogger(Processamento.class.getName());

    private Req reqInstance;
    private Resp respInstance;
    private ViewPrincipal view;
    private LeituraResp leitura;

    private final String caminhoArquivo = "C:\\COMPROVANTE\\comprovante.txt";

    public void inicializar(Req reqInstance, Resp respInstance, ViewPrincipal view, LeituraResp leitura) {
        this.reqInstance = reqInstance;
        this.respInstance = respInstance;
        this.view = view;
        this.leitura = leitura;
    }

    public void processaVendaSimples() {
        validareExcluirComprovante();

        reqInstance.apagarArquivosDentroDoDiretorio();

        reqInstance.criarArquivoVendaSimples();

        respInstance.monitorarArquivoSts();

        respInstance.verificaResp001();

        leitura.lerArquivo();

        respInstance.obtemResultadoTransacao();

        view.obtemComprovante();

        view.mensagemResultado();

        reqInstance.requerConfirmacao();

    }

    public void processaPreSelecaodeParametros() {
        validareExcluirComprovante();
        reqInstance.apagarArquivosDentroDoDiretorio();
        reqInstance.createFileWithText();

        respInstance.monitorarArquivoSts();
        respInstance.verificaResp001();
        respInstance.obtemResultadoTransacao();

        view.obtemComprovante();

        view.mensagemResultado();
        reqInstance.requerConfirmacao();

    }

    public void enviarConfirmacao() {

        Boolean confirmacao = view.confirmarTransacao();
        //Pode conter os valores: true, false, ou null.

        if (confirmacao == null) {
            // Não faz nada, usuário clicou no X
            return;
        }

        if (confirmacao) {

            reqInstance.criarArquivoRequisicaoConfirmacao();
            respInstance.monitorarArquivoSts();
        } else {

            reqInstance.criarArquivoRequisicaoDesfazimento();
        }

        view.exibirMensagemConfirmacao(confirmacao);
    }

    public void salvarComprovanteEmArquivo(Map<String, String> valoresComprovante) {

// Verifica se o mapa de valores está nulo ou vazio. Se estiver, registra um aviso no log e encerra o método.
        if (valoresComprovante == null || valoresComprovante.isEmpty()) {
            logger.log(Level.WARNING, "Nenhum dado para salvar no arquivo.");
            return;
        }
        // Gera o texto do comprovante a partir dos valores fornecidos, utilizando um método da view
        String textoComprovante = view.gerarTextoComprovanteDEMO(valoresComprovante);
        // Tenta abrir o arquivo e escrever o conteúdo do comprovante nele
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            // Escreve o texto do comprovante no arquivo
            writer.write(textoComprovante);

            writer.newLine(); // Linha em branco
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.newLine();
            logger.log(Level.INFO, "Comprovante salvo em: {0}", caminhoArquivo);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao salvar o comprovante no arquivo.", e);
        }
    }

    public void abrirComprovante() {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            logger.log(Level.WARNING, "Arquivo nao encontrado: {0}", caminhoArquivo);
            return;
        }

        if (!Desktop.isDesktopSupported()) {
            logger.log(Level.SEVERE, "Abertura de arquivos nao suportada neste sistema.");
            return;
        }

        try {
            Desktop.getDesktop().open(arquivo);
            logger.log(Level.INFO, "Arquivo aberto: {0}", caminhoArquivo);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao abrir o arquivo.", e);
        }
    }

    public void validareExcluirComprovante() {

        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            logger.log(Level.INFO, "O arquivo de comprovante nao existe.");
            return;
        }

        try {
            Path path = arquivo.toPath();
            BasicFileAttributes atributos = Files.readAttributes(path, BasicFileAttributes.class);

            // Obter data de criação do arquivo
            Instant dataCriacao = atributos.creationTime().toInstant();
            Instant agora = Instant.now();

            // Verificar se o arquivo tem mais de 24 horas
            long diferencaHoras = ChronoUnit.HOURS.between(dataCriacao, agora);
            if (diferencaHoras >= 24) {
                if (arquivo.delete()) {
                    logger.log(Level.INFO, "Comprovante excluído, pois tinha mais de um dia.");
                } else {
                    logger.log(Level.WARNING, "Falha ao excluir o comprovante.");
                }
            } else {
                logger.log(Level.INFO, "O comprovante ainda nao atingiu 24 horas.");
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao verificar a data do arquivo.", e);
        }
    }

    public void processaQuedaDeEnergia() {

        respInstance.monitorarArquivoSts();

        respInstance.monitoraResp001();

        leitura.lerArquivo();

        reqInstance.criarArquivoRequisicaoDesfazimento();

        view.exibirMensagemDesfazimento();

    }
}
