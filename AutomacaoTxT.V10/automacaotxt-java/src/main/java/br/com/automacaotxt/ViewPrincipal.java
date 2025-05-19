/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.automacaotxt;

import javax.swing.*;//Importa todas as classes do pacote javax.swing, que são usadas para criar componentes de interface gráfica, como janelas, botões e campos de texto.
import java.awt.*;//: Importa todas as classes do pacote java.awt, que são usadas para o layout e componentes gráficos de baixo nível.
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

//Declara uma classe pública chamada view.
public class ViewPrincipal {

    private JButton btnVendaSimples;

    private JButton btnPreSelecaodeParametros;

    public JButton getBtnVendaSimples() {
        return btnVendaSimples;
    }

    public JButton getBtnPreSelecaodeParametros() {
        return btnPreSelecaodeParametros;
    }

    private JButton btnHistoricodeVendas;

//A variavel do tipo "JFrame" é a janela principal da interface gráfica.
    private JFrame framePrincipal;

    private JLabel displayLabel;
    private JTextArea messageArea;

    private JFormattedTextField valorFieldVendaSimples003;

    private Req reqInstance;
    private Resp respInstance;
    private Processamento process;
    private ViewSecundaria viewSecu;
    private LeituraResp leitura;

    public void setMessageArea(JTextArea messageArea) {
        this.messageArea = messageArea;
    }

    public JTextArea getMessageArea() {
        return messageArea;
    }

    private final Logger logger = Logger.getLogger(ViewPrincipal.class.getName());

    public ViewPrincipal(Req reqInstance, Resp respInstance, Processamento process, ViewSecundaria viewSecu, LeituraResp leitura) {
        this.reqInstance = reqInstance;
        this.respInstance = respInstance;
        this.process = process;
        this.viewSecu = viewSecu;
        this.leitura = leitura;
    }

    public void iniciarAplicacao() {
        criarJanelaPrincipal();
        process.processaQuedaDeEnergia();

    }

    public Boolean confirmarTransacao() {
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");

        int resposta = JOptionPane.showConfirmDialog(
                null,
                "Você deseja enviar a confirmação da transação?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.CLOSED_OPTION) {
            return null;
        }

        return resposta == JOptionPane.YES_OPTION;
    }

    public void exibirMensagemConfirmacao(boolean confirmacao) {

        if (messageArea != null) {
            if (confirmacao) {
                messageArea.append(
                        "Confirmação enviada.\n"
                        + "Transação finalizada.\n"
                        + "Transação concluída com sucesso!\n"
                        + "\n\n\n");
            } else {
                messageArea.append("Cancelamento enviado\n");
                messageArea.append("Transação finalizada!\n\n\n");
            }
        }
    }

    public void exibirMensagemDesfazimento() {

        if (messageArea != null) {

            messageArea.append("Cancelamento enviado\n");
            messageArea.append("Transação finalizada!\n\n\n");

        }
    }

    private void criarJanelaPrincipal() {
        framePrincipal = new JFrame("Automação TxT - V 1.0");
        framePrincipal.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE); // esta correto com o nome completo da classe base
        //so para quando clicar no X

        //Esse tipo de layout permite um controle mais flexível sobre a posição e o tamanho dos componentes, permitindo que eles sejam organizados em uma grade, mas com mais opções de personalização.
        framePrincipal.setLayout(new GridBagLayout());
        //Cria um objeto GridBagConstraints, que será usado para definir as restrições de posicionamento dos componentes dentro do layout.
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Criação do botão para abrir a janela secundária
        JButton btnPreSelecaodeParametros = new JButton("PRÉ-SELEÇÃO DE PARÂMETROS");
        this.btnPreSelecaodeParametros = btnPreSelecaodeParametros;
        gbc.gridx = 1; // Segunda coluna
        gbc.gridy = 0; // Mesma linha do botão anterior
        gbc.gridwidth = 1; // Ocupa apenas uma coluna
        gbc.weightx = 0.5; // Peso horizontal igual ao botão anterior
        gbc.weighty = 0; // Sem peso vertical
        gbc.fill = GridBagConstraints.BOTH; // Preenche o espaço disponível
        framePrincipal.add(btnPreSelecaodeParametros, gbc);

        // Área de mensagens
        messageArea = new JTextArea(5, 30); // 5 linhas e 30 colunas

        messageArea.setEditable(false);  // Deixa a área de texto somente leitura( O usuário não pode editar)
        JScrollPane scrollPane = new JScrollPane(messageArea); // Adiciona barra de rolagem

        // Configuração do ScrollPane no layout
        gbc.gridx = 0; // Primeira coluna

        gbc.gridy = 2; // Segunda linha, abaixo dos botões
        gbc.gridwidth = 2; // Ocupa as duas colunas (centralizado abaixo dos botões)
        gbc.gridheight = 1; // Apenas 1 linha de altura
        gbc.weightx = 1.0; // Peso horizontal máximo
        gbc.weighty = 1.0; // Peso vertical maior que os botões
        gbc.fill = GridBagConstraints.BOTH; // Preenche todo o espaço disponível
        framePrincipal.add(scrollPane, gbc);

        // Ouvinte para abrir a janela secundária
        btnPreSelecaodeParametros.addActionListener(e -> {

            btnPreSelecaodeParametros.setEnabled(false);
            btnVendaSimples.setEnabled(false);

            viewSecu.criarGUI();

        });

        JButton btnVendaSimples = new JButton("VENDA");
        this.btnVendaSimples = btnVendaSimples;
        gbc.gridx = 0;//segunda coluna
        gbc.gridy = 0;//mesma linha do botão anterior

        gbc.gridwidth = 1; // Ocupa apenas uma coluna
        gbc.weightx = 0.5; // Peso horizontal igual para os botões
        gbc.weighty = 0; // Sem peso vertical
        gbc.fill = GridBagConstraints.BOTH; // Preenche o espaço disponível
        framePrincipal.add(btnVendaSimples, gbc);

        JPanel panelVendaSimples003 = new JPanel();
        panelVendaSimples003.setLayout(new GridLayout(1, 2));
        JLabel valorLabelVendaSimples003 = new JLabel("VALOR TOTAL (003-000):*");
        valorFieldVendaSimples003 = new JFormattedTextField();
        valorFieldVendaSimples003.setColumns(20);
        valorFieldVendaSimples003.setText("1,00");
        gbc.gridx = 0;
        gbc.gridy = 3;
        framePrincipal.add(valorLabelVendaSimples003, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        framePrincipal.add(valorFieldVendaSimples003, gbc);
        displayLabel = new JLabel(); // Inicialização
        // Configuração da interface gráfica
        framePrincipal.add(displayLabel);
        framePrincipal.setVisible(true);
        framePrincipal.pack();
        framePrincipal.setSize(600, 400); // Configurar uma largura e altura fixas
        framePrincipal.setLocationRelativeTo(null); // Centralizar a janela

        JButton btnHistoricodeVendas = new JButton("HISTÓRICO DE VENDAS");
        this.btnHistoricodeVendas = btnHistoricodeVendas;

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 3; // Ocupa apenas uma coluna
        gbc.weightx = 0.5; // Peso horizontal igual para os botões
        gbc.weighty = 0; // Sem peso vertical

        framePrincipal.add(btnHistoricodeVendas, gbc);

        btnHistoricodeVendas.addActionListener(e -> {
            process.abrirComprovante();

        });

        btnVendaSimples.addActionListener(e -> {
            desabilitarBtnViewPrincipal();


            /*A função SwingUtilities.invokeLater é usada para garantir que a atualização do messageArea seja feita na thread de interface gráfica.*/
            SwingUtilities.invokeLater(() -> {
                messageArea.append("────────────────────────────────────────────────\n");
                messageArea.append("Transação de pagamento iniciada" + "\n");
                messageArea.append("Valor: R$" + valorFieldVendaSimples003.getText() + "\n");

                setMessageArea(messageArea); // Definir a referência ao JTextArea
            });

            /*O SwingWorker é usado para realizar tarefas em segundo plano e evitar que a interface gráfica trave durante o processamento. Ele tem três métodos principais:
            doInBackground(): Executa o trabalho em segundo plano.
            process(): Atualiza a interface gráfica com o progresso.
            done(): Executado quando o trabalho em segundo plano for concluído.*/
            SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    try {
                        limparComprovante();
                        // Coloque aqui todos os métodos e processos que precisam ser concluídos
                        reqInstance.setVendaSimplesval003(valorFieldVendaSimples003.getText());
                        process.processaVendaSimples();
                    } catch (IllegalArgumentException ex) {
                        // Se houver exceção, publicamos uma mensagem no messageArea
                        //   messageArea.append("OPERAÇÃO CANCELADA");//resolvido para nao aparecer cancelado duas vezes

                        mensagemResultado();
                    }
                    return null;
                }

                @Override
                protected void process(java.util.List<String> chunks) {//chunks é uma lista de mensagens de status para a interface grafica
                    // Atualizar a interface com as mensagens publicadas pelo método process()
                    for (String message : chunks) {
                        messageArea.append(message + "\n");
                    }
                }

                @Override
                protected void done() {
                    // Esta parte é chamada após o processo terminar, você pode adicionar outras finalizações aqui
                    habilitarBtnViewPrincipal();

                }
            };

            // Iniciar o SwingWorker
            worker.execute();
        });

    }

    public void desabilitarBtnViewPrincipal() {
        // Desabilitar os botões nas duas janelas
        btnVendaSimples.setEnabled(false);
        btnPreSelecaodeParametros.setEnabled(false);
        btnHistoricodeVendas.setEnabled(false);

    }

    public void habilitarBtnViewPrincipal() {
        // Reabilitar os botões nas duas janelas
        btnVendaSimples.setEnabled(true);
        btnPreSelecaodeParametros.setEnabled(true);
        btnHistoricodeVendas.setEnabled(true);

    }

    public void limparComprovante() {//melhorar o nome
        if (messageArea != null) {
            messageArea.setText(null); // Define como null, que limpa o conteúdo
            messageArea.repaint(); // Força a atualização da interface gráfica
        }
    }

    /*Ele verifica se a área de mensagens messageArea está configurada (não nula), e, se estiver, ele chama o método capturarValoresDoArquivo() para capturar os valores do arquivo.*/
    public void obtemComprovante() {
        // Verifica se a área de mensagens (messageArea) não foi inicializada.
        // Se for null, registra um erro no logger e encerra o método.
        if (messageArea == null) {
            logger.log(Level.SEVERE, "Area de mensagem não configurada.");
            return;
        }
// Captura os valores do arquivo e os armazena no mapa valoresCapturados.
        Map<String, String> valoresCapturados = respInstance.capturarValoresDoArquivo();

        // Verifica se o mapa de valores capturados está vazio.
        // Se não houver dados, exibe a mensagem "Nenhum dado encontrado." na área de mensagens e encerra o método.
        if (valoresCapturados.isEmpty()) {
            messageArea.append("Nenhum dado encontrado.\n");
            return;
        }
//exibe o comprovante na interface
        exibirValoresDoComprovante(valoresCapturados);
        process.salvarComprovanteEmArquivo(valoresCapturados);
    }

    public String gerarTextoComprovanteDEMO(Map<String, String> valores) {
        StringBuilder comprovante = new StringBuilder(); // StringBuilder para armazenar o texto do comprovante.
        int larguraTotal = 44; // Define a largura total das linhas do comprovante.
        boolean exibiuCupom = false; // Controla se o título "Cupom reduzido" já foi exibido.
        boolean exibiuReciboLojista = false; // Controla se o título "Recibo para o lojista" já foi exibido.
        boolean exibiuReciboCliente = false; // Controla se o título "Recibo para o cliente" já foi exibido.

        // Define a fonte da área de mensagens como monoespaçada para manter o alinhamento do texto.
        messageArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
        // Percorre o mapa contendo os valores capturados do arquivo.
        for (Map.Entry<String, String> entry : valores.entrySet()) {
            String campo = entry.getKey(); // Obtém a chave (código do campo).
            String valor = entry.getValue(); // Obtém o valor correspondente.
            if (valor == null || valor.trim().isEmpty()) {
                continue;
            }

            // Se o campo "711-001" aparecer pela primeira vez, insere o título "Cupom reduzido".
            if (!exibiuCupom && campo.equals("711-001")) {
                comprovante.append("───────────────────────────────────────────────────\n");
                comprovante.append(respInstance.centralizarTexto("Cupom reduzido", larguraTotal)).append("\n");
                comprovante.append("───────────────────────────────────────────────────\n");
                exibiuCupom = true;
            }

            if (!exibiuReciboLojista && campo.equals("713-001")) {
                comprovante.append("───────────────────────────────────────────────────\n");
                comprovante.append(respInstance.centralizarTexto("Recibo para o cliente", larguraTotal)).append("\n");
                comprovante.append("───────────────────────────────────────────────────\n");
                exibiuReciboLojista = true;
            }

            if (!exibiuReciboCliente && campo.equals("715-001")) {
                comprovante.append("───────────────────────────────────────────────────\n");
                comprovante.append(respInstance.centralizarTexto("Recibo para o lojista", larguraTotal)).append("\n");
                comprovante.append("───────────────────────────────────────────────────\n");
                exibiuReciboCliente = true;
            }
// Adiciona o valor do campo formatado no comprovante.
            comprovante.append(respInstance.formatarTextoComBarras(valor, larguraTotal)).append("\n");
        }
        // Adiciona uma linha de separação no final do comprovante.
        comprovante.append("--------------------------------------------\n");
        // Retorna a String do comprovante gerado.
        return comprovante.toString();
    }

    public String gerarTextoComprovanteREDE(Map<String, String> valores) {
        StringBuilder comprovante = new StringBuilder();
        int larguraTotal = 44;
        boolean exibiuCupom = false;
        boolean exibiuReciboLojista = false;
        boolean exibiuReciboCliente = false;

        messageArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));

        for (Map.Entry<String, String> entry : valores.entrySet()) {
            String campo = entry.getKey(); // Obtém a chave (código do campo).
            String valor = entry.getValue(); // Obtém o valor correspondente.
            if (valor == null || valor.trim().isEmpty()) {
                continue;
            }

          
            if (!exibiuCupom && campo.equals("711-001")) {
                comprovante.append("───────────────────────────────────────────────────\n");
                comprovante.append(respInstance.centralizarTexto("Cupom reduzido", larguraTotal)).append("\n");
                comprovante.append("───────────────────────────────────────────────────\n");
                exibiuCupom = true;
            }
            // Cabeçalho do recibo para o lojista
            if (!exibiuReciboLojista && campo.equals("713-001")) {
                comprovante.append("───────────────────────────────────────────────────\n");
                comprovante.append(respInstance.centralizarTexto("Recibo para o cliente", larguraTotal)).append("\n");
                comprovante.append("───────────────────────────────────────────────────\n");
                exibiuReciboLojista = true;
            }

            // Cabeçalho do recibo para o cliente
            if (!exibiuReciboCliente && campo.equals("715-001")) {
                comprovante.append("───────────────────────────────────────────────────\n");
                comprovante.append(respInstance.centralizarTexto("Recibo para o lojista", larguraTotal)).append("\n");
                comprovante.append("───────────────────────────────────────────────────\n");
                exibiuReciboCliente = true;
            }

            comprovante.append(respInstance.formatarTextoComBarras(valor, larguraTotal)).append("\n");

        }

        comprovante.append("───────────────────────────────────────────────────\n");

        return comprovante.toString();
    }

    public void exibirValoresDoComprovante(Map<String, String> valores) {
        if (leitura.getRespVal010().equals("DEMO")) {
            String comprovante = gerarTextoComprovanteDEMO(valores);
            messageArea.append(comprovante);
        } else if (leitura.getRespVal010().equals("REDECARD")) {
            String comprovante = gerarTextoComprovanteREDE(valores);
            messageArea.append(comprovante);
        } else {
            String comprovante = gerarTextoComprovanteREDE(valores);
            messageArea.append(comprovante);
        }
    }

    public void mensagemResultado() {

        String valor030000 = leitura.getRespVal030(); // Obtém o valor pelo getter

        if (getMessageArea() != null) {
            if (valor030000 != null) {
                getMessageArea().append(valor030000 + "\n");
            } else {
                getMessageArea().append("O campo 030-000 nao foi encontrado no arquivo.\n");
            }
        }
    }

}
