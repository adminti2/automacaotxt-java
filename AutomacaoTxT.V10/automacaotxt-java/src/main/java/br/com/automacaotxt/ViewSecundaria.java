/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.automacaotxt;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 *
 * @author mateus.costa
 */
public class ViewSecundaria {

    private JButton btnTransacao;

    public JButton getBtnTransacao() {
        return btnTransacao;
    }

    public void setBtnTransacao(JButton btnTransacao) {
        this.btnTransacao = btnTransacao;
    }

    private JFrame frameSecundario;
    private JLabel displayLabel;
    //A variavel do tipo "JFormattedTextField" é um campo de texto para a entrada de numeros ou valores especificos 
    private JFormattedTextField valorField001;
    private JFormattedTextField valorField002;
    private JFormattedTextField valorField003;
    private JFormattedTextField valorField004;

    private JFormattedTextField valorField010;
    private JFormattedTextField valorField012;

    private JFormattedTextField valorField018;
    private JFormattedTextField valorField022;
    private JFormattedTextField valorField023;

    private JFormattedTextField valorField706;
    private JFormattedTextField valorField716;
    private JFormattedTextField valorField726;
    private JFormattedTextField valorField731;
    private JFormattedTextField valorField732;
    private JFormattedTextField valorField733;
    private JFormattedTextField valorField735;
    private JFormattedTextField valorField736;
    private JFormattedTextField valorField738;

    private JFormattedTextField valorField999;
    private Req reqInstance;

    private Processamento process;
    private ViewPrincipal view;

    public void inicializar(Req reqInstance, ViewPrincipal view, Processamento process) {
        this.reqInstance = reqInstance;

        this.view = view;
        this.process = process;
    }

    private void configurarFrame() {
        //Cria um novo objeto JFrame com o título "Automação"
        frameSecundario = new JFrame("PRÉ-SELEÇÃO DE PARÂMETROS");
        //Define a operação padrão ao fechar a janela. JFrame.EXIT_ON_CLOSE faz com que o aplicativo seja encerrado ao fechar a janela.
        frameSecundario.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);// Usando o nome completo da classe base 
        frameSecundario.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Reabilita o botão quando a janela for fechada
                view.getBtnPreSelecaodeParametros().setEnabled(true);
                view.getBtnVendaSimples().setEnabled(true);

            }
        });
    }

    private void habilitarCampos(JTextField[] campos) {
        for (JTextField campo : campos) {
            campo.setEnabled(true);
        }
    }

    private void desabilitarCampos(JTextField[] campos) {
        for (JTextField campo : campos) {
            campo.setEnabled(false);
        }
    }

    public void criarGUI() {
        configurarFrame();

        JPanel panelConteudo = new JPanel();
        panelConteudo.setLayout(new GridBagLayout()); // Manter o layout atual
        // Criar um painel principal para os componentes
        JPanel panelSecundario = new JPanel();
        panelSecundario.setLayout(new GridBagLayout()); // Usar GridBagLayout para adicionar os componentes

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        // Criar o JScrollPane para rolar o painel
        JScrollPane scrollPaneSecundario = new JScrollPane(panelConteudo);
        scrollPaneSecundario.setPreferredSize(new Dimension(520, 620)); //ajuste caso queira definir o tamanho limite da tela para exibicao do SCROLL, caso queira, é necessário diminuir para a tela ser exibida

        frameSecundario.getContentPane().setLayout(new GridBagLayout()); // Certificar-se de que o layout está correto
        frameSecundario.getContentPane().add(scrollPaneSecundario, gbc);

        // Criar o JLabel
        JLabel valorLabel000 = new JLabel("COMANDO (000-000):");

        // Criar as opções para o JComboBox
        String[] opcoes000 = {"CRT", "ADM", "CNC"};
        JComboBox<String> valorComboBox000 = new JComboBox<>(opcoes000);
        valorComboBox000.setSelectedItem("CRT"); // Define a opção inicial
        // Adicionar o JLabel e JComboBox ao frame
        gbc.gridx = 0; // coluna
        gbc.gridy = 0; // linha

        panelConteudo.add(valorLabel000, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;

        panelConteudo.add(valorComboBox000, gbc);

        JLabel valorLabel001 = new JLabel("IDENTIFICADOR (001-000):");
        NumberFormat format = NumberFormat.getIntegerInstance();
        valorField001 = new JFormattedTextField(format);
        valorField001.setColumns(20);
        valorField001.setValue(null);
        gbc.gridx = 0;
        gbc.gridy = 1;

        panelConteudo.add(valorLabel001, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;

        panelConteudo.add(valorField001, gbc);

        JLabel valorLabel002 = new JLabel("DOCUMENTO FISCAL (002-000):");

        valorField002 = new JFormattedTextField(format);
        valorField002.setColumns(20);
        gbc.gridx = 0;
        gbc.gridy = 2;

        panelConteudo.add(valorLabel002, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;

        panelConteudo.add(valorField002, gbc);

        JLabel valorLabel003 = new JLabel("VALOR TOTAL (003-000):*");

        valorField003 = new JFormattedTextField(format);
        valorField003.setColumns(20);
        valorField003.setText("1,00");
        gbc.gridx = 0;
        gbc.gridy = 3;

        panelConteudo.add(valorLabel003, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;

        panelConteudo.add(valorField003, gbc);

        JLabel valorLabel004 = new JLabel("MOEDA (004-000):");

        valorField004 = new JFormattedTextField(format);
        valorField004.setColumns(20);
        valorField004.setText("0");
        gbc.gridx = 0;
        gbc.gridy = 4;

        panelConteudo.add(valorLabel004, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;

        panelConteudo.add(valorField004, gbc);

        JLabel valorLabel010 = new JLabel("REDE ADQUIRENTE (010-000):");
        valorField010 = new JFormattedTextField();
        valorField010.setColumns(20);
        gbc.gridx = 0;
        gbc.gridy = 7;

        panelConteudo.add(valorLabel010, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;

        panelConteudo.add(valorField010, gbc);

        JLabel valorLabel012 = new JLabel("NSU (012-000):");
        valorField012 = new JFormattedTextField();
        valorField012.setColumns(20);
        gbc.gridx = 0;
        gbc.gridy = 8;

        panelConteudo.add(valorLabel012, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;

        panelConteudo.add(valorField012, gbc);

        JLabel valorLabel018 = new JLabel("QUANTIDADE DE PARCELAS (018-000):");
        valorField018 = new JFormattedTextField(format);
        valorField018.setColumns(20);
        gbc.gridx = 0;
        gbc.gridy = 10;

        panelConteudo.add(valorLabel018, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;

        panelConteudo.add(valorField018, gbc);

        JLabel valorLabel022 = new JLabel("DATA NO COMPROVANTE (022-000):");
        valorField022 = new JFormattedTextField(format);
        valorField022.setColumns(20);
        gbc.gridx = 0;
        gbc.gridy = 11;

        panelConteudo.add(valorLabel022, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;

        panelConteudo.add(valorField022, gbc);

        JLabel valorLabel023 = new JLabel("HORA NO COMPROVANTE (023-000):");
        valorField023 = new JFormattedTextField(format);
        valorField023.setColumns(20);
        gbc.gridx = 0;
        gbc.gridy = 12;

        panelConteudo.add(valorLabel023, gbc);

        gbc.gridx = 1;
        gbc.gridy = 12;

        panelConteudo.add(valorField023, gbc);

        JLabel valorLabel706 = new JLabel("CAPACIDADES DA AUTOMAÇÃO (706-000):");
        valorField706 = new JFormattedTextField(format);
        valorField706.setColumns(20);
        valorField706.setText("511");
        gbc.gridx = 0;
        gbc.gridy = 14;

        panelConteudo.add(valorLabel706, gbc);

        gbc.gridx = 1;
        gbc.gridy = 14;

        panelConteudo.add(valorField706, gbc);

        JLabel valorLabel716 = new JLabel("EMPRESA DA AUTOMAÇÃO (716-000):");
        valorField716 = new JFormattedTextField();
        valorField716.setColumns(20);
        valorField716.setText("SETIS AUTOMACAO E SISTEMAS LTDA.");
        gbc.gridx = 0;
        gbc.gridy = 15;
        panelConteudo.add(valorLabel716, gbc);

        gbc.gridx = 1;
        gbc.gridy = 15;

        panelConteudo.add(valorField716, gbc);

        JLabel valorLabel726 = new JLabel("IDIOMA DO CLIENTE (726-000):");
        valorField726 = new JFormattedTextField();
        valorField726.setColumns(20);
        valorField726.setText("pt");
        gbc.gridx = 0;
        gbc.gridy = 16;

        panelConteudo.add(valorLabel726, gbc);

        gbc.gridx = 1;
        gbc.gridy = 16;

        panelConteudo.add(valorField726, gbc);

        JLabel valorLabel731 = new JLabel("TIPO DE CARTÃO (731-000):");
        valorField731 = new JFormattedTextField(format);
        valorField731.setColumns(20);
        valorField731.setText("0");
        gbc.gridx = 0;
        gbc.gridy = 17;

        panelConteudo.add(valorLabel731, gbc);

        gbc.gridx = 1;
        gbc.gridy = 17;

        panelConteudo.add(valorField731, gbc);

        JLabel valorLabel732 = new JLabel("TIPO DE FINANCIAMENTO (732-000):");
        valorField732 = new JFormattedTextField(format);
        valorField732.setColumns(20);
        valorField732.setText("0");
        gbc.gridx = 0;
        gbc.gridy = 18;

        panelConteudo.add(valorLabel732, gbc);

        gbc.gridx = 1;
        gbc.gridy = 18;

        panelConteudo.add(valorField732, gbc);

        JLabel valorLabel733 = new JLabel("VERSÃO DA INTERFACE (733-000):*");
        valorField733 = new JFormattedTextField(format);
        valorField733.setColumns(20);
        valorField733.setText("0");
        gbc.gridx = 0;
        gbc.gridy = 19;

        panelConteudo.add(valorLabel733, gbc);

        gbc.gridx = 1;
        gbc.gridy = 19;

        panelConteudo.add(valorField733, gbc);

        JLabel valorLabel735 = new JLabel("NOME DA AUTOMAÇÃO (735-000):");
        valorField735 = new JFormattedTextField();
        valorField735.setColumns(20);
        valorField735.setText("PDVS exemplo");
        gbc.gridx = 0;
        gbc.gridy = 20;

        panelConteudo.add(valorLabel735, gbc);

        gbc.gridx = 1;
        gbc.gridy = 20;

        panelConteudo.add(valorField735, gbc);

        JLabel valorLabel736 = new JLabel("VERSÃO DA AUTOMAÇÃO (736-000):");
        valorField736 = new JFormattedTextField();
        valorField736.setColumns(20);
        valorField736.setText("v1.0");
        gbc.gridx = 0;
        gbc.gridy = 21;

        panelConteudo.add(valorLabel736, gbc);

        gbc.gridx = 1;
        gbc.gridy = 21;

        panelConteudo.add(valorField736, gbc);

        JLabel valorLabel738 = new JLabel("REGISTRO DE CERTIFICAÇÃO (738-000):");
        valorField738 = new JFormattedTextField();
        valorField738.setColumns(20);
        valorField738.setText("1234");
        gbc.gridx = 0;
        gbc.gridy = 22;

        panelConteudo.add(valorLabel738, gbc);

        gbc.gridx = 1;
        gbc.gridy = 22;

        panelConteudo.add(valorField738, gbc);

        Map<String, String> opcoes749 = new LinkedHashMap<>();
        opcoes749.put("Não especificado", "0");
        opcoes749.put("Cartão", "1");
        opcoes749.put("Dinheiro", "2");
        opcoes749.put("Cheque", "4");
        opcoes749.put("Carteira digital", "8");

        // Criar o JLabel
        JLabel valorLabel749 = new JLabel("FORMA DE PAGAMENTO (749-000):");

        JComboBox<String> valorComboBox749 = new JComboBox<>(opcoes749.keySet().toArray(String[]::new));
        // Adicionar o JLabel e JComboBox ao frame
        gbc.gridx = 0; // coluna
        gbc.gridy = 23; // linha

        panelConteudo.add(valorLabel749, gbc);

        gbc.gridx = 1;
        gbc.gridy = 23;

        panelConteudo.add(valorComboBox749, gbc);

        JLabel valorLabel999 = new JLabel("REGISTRO FINALIZADOR (999-999):");
        valorField999 = new JFormattedTextField(format);
        valorField999.setColumns(20);
        valorField999.setText("0");
        gbc.gridx = 0;
        gbc.gridy = 24;

        panelConteudo.add(valorLabel999, gbc);

        gbc.gridx = 1;
        gbc.gridy = 24;

        panelConteudo.add(valorField999, gbc);

        //Cria um botão com o texto "CARTAO".
        JButton btnTransacao = new JButton("EFETUAR TRANSAÇÃO");
        this.btnTransacao = btnTransacao;

        gbc.gridx = 0;
        gbc.gridy = 25;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER; // Alinha o botão no centro

        frameSecundario.add(btnTransacao, gbc);

        displayLabel = new JLabel(); // Inicialização
        // Configuração da interface gráfica
        frameSecundario.add(displayLabel);

        valorComboBox000.addActionListener(e -> {
            String selectedItem = (String) valorComboBox000.getSelectedItem();

            // Lista de todos os campos (sempre ativados antes de aplicar restrições)
            JTextField[] todosOsCampos = {
                valorField001, valorField002, valorField003, valorField004,
                valorField010, valorField012, valorField018, valorField022, valorField023,
                valorField706, valorField716, valorField726, valorField731, valorField732,
                valorField733, valorField735, valorField736, valorField738, valorField999
            };

            // Primeiro, habilita todos os campos
            habilitarCampos(todosOsCampos);

            // Define quais campos devem ser desativados com base na seleção
            JTextField[] camposParaDesativar = new JTextField[0]; // Inicializa como vazio

            if ("CRT".equals(selectedItem)) {
                camposParaDesativar = new JTextField[]{valorField012, valorField022, valorField023};
            } else if ("ADM".equals(selectedItem)) {
                camposParaDesativar = new JTextField[]{valorField003, valorField004, valorField012, valorField022, valorField023};
            } else if ("CNC".equals(selectedItem)) {
                camposParaDesativar = new JTextField[]{valorField732};
            }

            // Desabilita os campos necessários
            desabilitarCampos(camposParaDesativar);

        });

        // Dispara a atualização dos campos conforme a seleção inicial
        valorComboBox000.setSelectedItem(valorComboBox000.getSelectedItem());

        //e: parâmetro que representa o evento.
        //->: indica a separação entre o parâmetro e o corpo da lambda.
        btnTransacao.addActionListener(e -> {
            String selectedItem = (String) valorComboBox000.getSelectedItem();
            // Obter a chave selecionada
            String textoSelecionado = (String) valorComboBox749.getSelectedItem();
            // Obter o valor correspondente para salvar no arquivo
            //String valorSelecionado = opcoes749.get(textoSelecionado); //verificar se essa linha e necessaria
            view.desabilitarBtnViewPrincipal();
            getBtnTransacao().setEnabled(false);

            SwingUtilities.invokeLater(() -> {

                view.getMessageArea().append("────────────────────────────────────────────────\n");

                view.getMessageArea().append("Transação de pagamento iniciada" + "\n");

                view.getMessageArea().append("Valor: R$" + valorField003.getText() + "\n");

            });

            // Criar um SwingWorker para executar os processos em segundo plano
            SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    try {
                        view.limparComprovante();

                        //Obtém o texto digitado no campo valorField.
                        reqInstance.setVal000(valorComboBox000.getSelectedItem().toString());

                        reqInstance.setVal001(valorField001.getText());

                        reqInstance.setVal002(valorField002.getText());
                        reqInstance.setVal003(valorField003.getText());

                        reqInstance.setVal004(valorField004.getText());

                        reqInstance.setVal010(valorField010.getText());
                        reqInstance.setVal012(valorField012.getText());

                        reqInstance.setVal018(valorField018.getText());
                        reqInstance.setVal022(valorField022.getText());
                        reqInstance.setVal023(valorField023.getText());

                        reqInstance.setVal706(valorField706.getText());
                        reqInstance.setVal716(valorField716.getText());
                        reqInstance.setVal726(valorField726.getText());
                        reqInstance.setVal731(valorField731.getText());
                        reqInstance.setVal732(valorField732.getText());
                        reqInstance.setVal733(valorField733.getText());
                        reqInstance.setVal735(valorField735.getText());
                        reqInstance.setVal736(valorField736.getText());
                        reqInstance.setVal738(valorField738.getText());

                        reqInstance.setVal749(opcoes749.get(textoSelecionado));

                        reqInstance.setVal999(valorField999.getText());
                        // Chama o método de validação apenas quando o botão for pressionado

                        if (!validarCamposObrigatorios(selectedItem)) { // Se a validação falhar, exibe mensagem de erro e retorna, interrompendo a execução 
                            JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);

                            view.getMessageArea().append("OPERAÇÃO CANCELADA");

                        } else {

                            process.processaPreSelecaodeParametros();

                        }

                    } catch (IllegalArgumentException ex) {
                        ex.printStackTrace();
                        // Se houver exceção, publicamos uma mensagem no messageArea

                        view.mensagemResultado();
                    }
                    //Isso apenas encerra a execução do método sem retornar nada útil.
                    return null;
                }

                @Override
                protected void process(java.util.List<String> chunks) {
                    // Atualizar a interface com as mensagens publicadas pelo método process()
                    for (String message : chunks) {

                        view.getMessageArea().append(message + "\n");
                    }
                }

                @Override
                protected void done() {
                    // Esta parte é chamada após o processo terminar, você pode adicionar outras finalizações aqui
                    view.habilitarBtnViewPrincipal();
                    getBtnTransacao().setEnabled(true);

                }
            };

            // Iniciar o SwingWorker
            worker.execute();
        });

        frameSecundario.setLocationRelativeTo(null); // Centralizar na tela
        //Torna a janela visível.
        frameSecundario.setVisible(true);

        frameSecundario.pack();
    }

    // Método para validar os campos obrigatórios
    private boolean validarCamposObrigatorios(String selectedItem) {
        Map<JTextField, String> camposObrigatorios = new HashMap<>();

        if ("CRT".equals(selectedItem)) {
            camposObrigatorios.put(valorField001, "Campo 001-000");
            camposObrigatorios.put(valorField003, "Campo 003-000");
            camposObrigatorios.put(valorField004, "Campo 004-000");
            camposObrigatorios.put(valorField706, "Campo 706-000");
            camposObrigatorios.put(valorField716, "Campo 716-000");
            camposObrigatorios.put(valorField733, "Campo 733-000");
            camposObrigatorios.put(valorField735, "Campo 735-000");
            camposObrigatorios.put(valorField736, "Campo 736-000");
            camposObrigatorios.put(valorField738, "Campo 738-000");
            camposObrigatorios.put(valorField999, "Campo 999-000");
        } else if ("ADM".equals(selectedItem)) {
            camposObrigatorios.put(valorField001, "Campo 001-000");
            camposObrigatorios.put(valorField706, "Campo 706-000");
            camposObrigatorios.put(valorField716, "Campo 706-000");
            camposObrigatorios.put(valorField733, "Campo 733-000");
            camposObrigatorios.put(valorField735, "Campo 735-000");
            camposObrigatorios.put(valorField736, "Campo 736-000");
            camposObrigatorios.put(valorField738, "Campo 738-000");
            camposObrigatorios.put(valorField999, "Campo 999-000");
        } else if ("CNC".equals(selectedItem)) {
            camposObrigatorios.put(valorField001, "Campo 001-000");
            camposObrigatorios.put(valorField003, "Campo 003-000");
            camposObrigatorios.put(valorField004, "Campo 004-000");
            camposObrigatorios.put(valorField012, "Campo 012-000");
            camposObrigatorios.put(valorField022, "Campo 022-000");
            camposObrigatorios.put(valorField023, "Campo 023-000");
            camposObrigatorios.put(valorField706, "Campo 706-000");
            camposObrigatorios.put(valorField716, "Campo 716-000");
            camposObrigatorios.put(valorField733, "Campo 733-000");
            camposObrigatorios.put(valorField735, "Campo 735-000");
            camposObrigatorios.put(valorField736, "Campo 736-000");
            camposObrigatorios.put(valorField738, "Campo 738-000");
            camposObrigatorios.put(valorField999, "Campo 999-000");
        }

        List<String> camposVazios = new ArrayList<String>();
        for (Map.Entry<JTextField, String> entry : camposObrigatorios.entrySet()) {
            if (entry.getKey().getText().trim().isEmpty()) {
                camposVazios.add(entry.getValue());
            }
        }

        if (!camposVazios.isEmpty()) {
            String mensagem = "Preencha os seguintes campos obrigatórios:\n" + String.join("\n", camposVazios);
            JOptionPane.showMessageDialog(null, mensagem, "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
            return false;// O return false; ocorre se houver campos obrigatórios não preenchidos.
//Isso impede que o código continue, pois os campos essenciais não foram preenchidos.
        }

        return true;
    }

}
