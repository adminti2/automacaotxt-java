/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.automacaotxt;

import java.io.File;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mateus.costa
 */
public class Resp {

    private LeituraResp leitura;

    public Resp(LeituraResp leitura) {
        this.leitura = leitura;

    }

    private final Logger logger = Logger.getLogger(Resp.class.getName());

    //funcao ler arquivo e capturar os atributos de resposta  
    //criar um loop do while e se tiver o arquivo sair do loop (sleep = pesquisar sobre)+ botão de confirmaçao
    // Método para verificar se o arquivo foi gerado em até 7 segundos e exibir o resultado na interface gráfica
    public void monitorarArquivoSts() throws IllegalArgumentException {
// Define o caminho absoluto do arquivo que será monitorado.
        String filePath = "C:\\PAYGO\\Resp\\intpos.Sts";
// Loga o caminho do arquivo para depuração
        logger.log(Level.INFO, "Caminho completo do arquivo: {0}", filePath);

// Cria um objeto File que representa o arquivo no sistema de arquivos.
        // Isso não cria o arquivo fisicamente, apenas referencia seu caminho.
        File file = new File(filePath);
        // Define o tempo limite de espera (7 segundos) para o arquivo ser gerado.
        long timeoutInMillis = 7000;
        // Captura o tempo inicial da execução para controle do timeout.
        long startTime = System.currentTimeMillis();

        // Loop de monitoramento: verifica repetidamente se o arquivo foi criado,
        // desde que o tempo decorrido ainda esteja dentro do limite estabelecido.
        while ((System.currentTimeMillis() - startTime) < timeoutInMillis) {
            // Verifica se o arquivo já foi criado e se realmente é um arquivo (não um diretório).
            if (file.exists() && file.isFile()) {
                // Loga que o arquivo foi encontrado dentro do tempo limite
                logger.log(Level.INFO, "Arquivo gerado dentro do tempo limite.");

                // Sai do método, pois o objetivo foi alcançado
                return;
            }

            try {
                //Faz a thread "dormir" (pausar a execução) por 500 milissegundos antes de verificar novamente se o arquivo foi criado.
                //Isso evita que o programa fique verificando constantemente e sobrecarregue o processador.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Se a thread for interrompida durante a espera, define o status de interrupção novamente.

                Thread.currentThread().interrupt();
                // Loga a interrupção para depuração
                logger.log(Level.WARNING, "Thread foi interrompida.");
                // Lança uma exceção informando que o monitoramento foi interrompido.
                throw new IllegalArgumentException("Thread interrompida durante a monitoramento do arquivo.", e);

            }
        }
        // Se o loop terminar sem encontrar o arquivo, significa que ele não foi gerado no tempo limite.
        // Loga um aviso informando o problema.
        logger.log(Level.WARNING, "Arquivo nao gerado dentro do tempo limite, ou seja, não possui transação pendente");
        JOptionPane.showMessageDialog(null, "Arquivo " + filePath + " não foi gerado dentro do tempo limite, ou seja, não possui transação pendente",
                "Aviso", JOptionPane.WARNING_MESSAGE);

        // Lança uma exceção para indicar falha no monitoramento.
        throw new IllegalArgumentException("Erro: Arquivo nao gerado no tempo limite.");
    }

    public void monitoraResp001() throws IllegalArgumentException {
// Define o caminho absoluto do arquivo que será monitorado.
        String filePath = "C:\\PAYGO\\Resp\\IntPos.001";
// Loga o caminho do arquivo para depuração
        logger.log(Level.INFO, "Caminho completo do arquivo: {0}", filePath);

// Cria um objeto File que representa o arquivo no sistema de arquivos.
        // Isso não cria o arquivo fisicamente, apenas referencia seu caminho.
        File file = new File(filePath);
        // Define o tempo limite de espera (7 segundos) para o arquivo ser gerado.
        long timeoutInMillis = 7000;
        // Captura o tempo inicial da execução para controle do timeout.
        long startTime = System.currentTimeMillis();

        // Loop de monitoramento: verifica repetidamente se o arquivo foi criado,
        // desde que o tempo decorrido ainda esteja dentro do limite estabelecido.
        while ((System.currentTimeMillis() - startTime) < timeoutInMillis) {
            // Verifica se o arquivo já foi criado e se realmente é um arquivo (não um diretório).
            if (file.exists() && file.isFile()) {
                // Loga que o arquivo foi encontrado dentro do tempo limite
                logger.log(Level.INFO, "Arquivo gerado dentro do tempo limite.");

                // Sai do método, pois o objetivo foi alcançado
                return;
            }

            try {
                //Faz a thread "dormir" (pausar a execução) por 500 milissegundos antes de verificar novamente se o arquivo foi criado.
                //Isso evita que o programa fique verificando constantemente e sobrecarregue o processador.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Se a thread for interrompida durante a espera, define o status de interrupção novamente.

                Thread.currentThread().interrupt();
                // Loga a interrupção para depuração
                logger.log(Level.WARNING, "Thread foi interrompida.");
                // Lança uma exceção informando que o monitoramento foi interrompido.
                throw new IllegalArgumentException("Thread interrompida durante a monitoramento do arquivo.", e);

            }
        }
        // Se o loop terminar sem encontrar o arquivo, significa que ele não foi gerado no tempo limite.
        // Loga um aviso informando o problema.
        logger.log(Level.WARNING, "Arquivo nao gerado dentro do tempo limite.");
        // Lança uma exceção para indicar falha no monitoramento.
        throw new IllegalArgumentException("Erro: Arquivo nao gerado no tempo limite.");
    }

    public void verificaResp001() {
        // Define o caminho do diretório onde o arquivo será monitorado.
        String directoryPath = "C:\\PAYGO\\Resp";
// Nome do arquivo que será monitorado dentro do diretório.
        String fileName = "IntPos.001";
        try {

            // Cria um objeto Path que representa o diretório monitorado.
            Path dir = Paths.get(directoryPath);

            // Cria um novo WatchService, que permite monitorar eventos em arquivos e diretórios. 
            //FileSystems.getDefault() retorna o sistema de arquivos padrão, e newWatchService() cria o serviço de monitoramento de eventos.
            WatchService watchService = FileSystems.getDefault().newWatchService();

            // Registra o serviço para monitorar criação de novos arquivos
            dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            logger.log(Level.INFO, "Aguardando geracao do arquivo {0} no diretorio {1}", new Object[]{fileName, directoryPath});

            // Laço infinito para esperar pela criação do arquivo
            while (true) {
                // Aguarda por eventos de alteração no diretório
                WatchKey key = watchService.take();

                // verifica os eventos registrados
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    // Verifica se um arquivo foi criado
                    if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                        // Verifica se o arquivo criado é o que estamos aguardando
                        Path createdFilePath = (Path) event.context();
                        if (createdFilePath.toString().equals(fileName)) {
                            // Exibe mensagem de sucesso
                            logger.log(Level.INFO, "Arquivo {0} gerado!", fileName);
                            JOptionPane.showMessageDialog(null, "Arquivo " + fileName + " gerado com sucesso!");

                            // Aqui você pode adicionar qualquer lógica adicional após a criação do arquivo
                            // Por exemplo, leitura do arquivo ou execução de outras ações
                            // Sai do método, pois o objetivo foi alcançado.
                            return;
                        }
                    }
                }

                // Reseta a chave para continuar recebendo eventos
                boolean valid = key.reset();
                //Se a chave não for válida (por exemplo, se o diretório monitorado for removido ou houver algum erro), o laço while é interrompido com o break.
                if (!valid) {

                    break; // Sai do laço se o monitoramento falhar
                }
            }
        } catch (IOException | InterruptedException e) {
            // Exibe uma mensagem de erro caso ocorra alguma exceção.
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
            // Se a exceção for do tipo InterruptedException, a thread é reinterrompida para preservar o estado de interrupção.
            if (e instanceof InterruptedException) {
                // Reinterrompe a thread para preservar o estado de interrupção
                Thread.currentThread().interrupt();
            }
        }
    }

    public void obtemResultadoTransacao() throws IllegalArgumentException {
        leitura.lerArquivo();  // Chama o método lerArquivo() da classe leitura para garantir que os valores do arquivo foram carregados antes da verificação.

        // Obtém o valor do campo 009-000 após a leitura do arquivo.
        String valor009 = leitura.getRespVal009(); // Obtém o valor do campo 009-000

        // Verifica se o valor do campo 009-000 é diferente de "0".
        if (!"0".equals(valor009)) {
            // Exibe uma mensagem de erro informando que o valor esperado não foi encontrado.
            JOptionPane.showMessageDialog(null, "Erro: O valor do campo 009-000 nao e igual a 0", "Erro", JOptionPane.ERROR_MESSAGE);
            // Lança uma exceção para interromper o fluxo da aplicação e indicar o erro.
            throw new IllegalArgumentException("Campo 009-000 possui valor incorreto.");
        }

        // Se o valor do campo 009-000 for "0", exibe uma mensagem informando que a configuração está correta.
        JOptionPane.showMessageDialog(null, "O campo 009-000 esta corretamente configurado.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

// Método para capturar valores do arquivo e retorná-los em um mapa
    public Map<String, String> capturarValoresDoArquivo() {
        // Mapa para armazenar os valores capturados do arquivo
        Map<String, String> valores = new LinkedHashMap<>();
        // Definição da largura total e alinhamento para formatação
        // Captura os valores de cada campo e os coloca no    mapa
        valores.put("711-001", leitura.getRespVal711_001());
        valores.put("711-002", leitura.getRespVal711_002());
        valores.put("711-003", formatarLinha(leitura.getRespVal711_003()));
        valores.put("711-004", leitura.getRespVal711_004());
        valores.put("711-005", formatarLinha(leitura.getRespVal711_005()));
        valores.put("713-001", leitura.getRespVal713_001());
        valores.put("713-002", leitura.getRespVal713_002());
        valores.put("713-003", formatarLinha(leitura.getRespVal713_003()));
        valores.put("713-004", leitura.getRespVal713_004());
        valores.put("713-005", formatarLinha(leitura.getRespVal713_005()));
        valores.put("713-006", formatarLinha(leitura.getRespVal713_006()));
        valores.put("713-007", formatarLinha(leitura.getRespVal713_007()));
        valores.put("713-008", leitura.getRespVal713_008());
        valores.put("713-009", leitura.getRespVal713_009());
        valores.put("713-010", formatarLinha(leitura.getRespVal713_010()));
        valores.put("713-011", formatarLinha(leitura.getRespVal713_011()));
        valores.put("713-012", formatarLinha(leitura.getRespVal713_012()));
        valores.put("713-013", formatarLinha(leitura.getRespVal713_013()));
        valores.put("713-014", leitura.getRespVal713_014());
        valores.put("713-015", formatarLinha(leitura.getRespVal713_015()));
        valores.put("713-016", leitura.getRespVal713_016());
        valores.put("713-017", leitura.getRespVal713_017());
        valores.put("713-018", leitura.getRespVal713_018());
        valores.put("713-019", formatarLinha(leitura.getRespVal713_019()));
        valores.put("713-020", formatarLinha(leitura.getRespVal713_020()));
        valores.put("713-021", leitura.getRespVal713_021());
        valores.put("713-022", leitura.getRespVal713_022());
        valores.put("715-001", leitura.getRespVal715_001());
        valores.put("715-002", leitura.getRespVal715_002());
        valores.put("715-003", formatarLinha(leitura.getRespVal713_003()));
        valores.put("715-004", leitura.getRespVal715_004());
        valores.put("715-005", formatarLinha(leitura.getRespVal715_005()));
        valores.put("715-006", formatarLinha(leitura.getRespVal715_006()));
        valores.put("715-007", formatarLinha(leitura.getRespVal715_007()));
        valores.put("715-008", formatarLinha(leitura.getRespVal715_008()));
        valores.put("715-009", leitura.getRespVal715_009());
        valores.put("715-010", formatarLinha(leitura.getRespVal715_010()));
        valores.put("715-011", formatarLinha(leitura.getRespVal715_011()));
        valores.put("715-012", leitura.getRespVal715_012());
        valores.put("715-013", leitura.getRespVal715_013());
        valores.put("715-014", leitura.getRespVal715_014());
        valores.put("715-015", formatarLinha(leitura.getRespVal715_015()));
        valores.put("715-016", leitura.getRespVal715_016());
        valores.put("715-017", leitura.getRespVal715_017());
        valores.put("715-018", leitura.getRespVal715_018());
        valores.put("715-019", formatarLinha(leitura.getRespVal715_019()));
        valores.put("715-020", formatarLinha(leitura.getRespVal715_020()));
        valores.put("715-021", leitura.getRespVal715_021());
        valores.put("715-022", leitura.getRespVal715_022());
// Retorna o mapa com todos os valores capturados
        return valores;
    }

// Método auxiliar para formatar texto com barras laterais
    public String formatarTextoComBarras(String texto, int larguraTotal) {
        texto = texto.replace("\"", "");// Remove as aspas
        int espacoBranco = larguraTotal - texto.length() - 2; // Espaço necessário para as barras laterais
        int espacoEsquerda = espacoBranco / 2;// Calcula o espaço à esquerda
        int espacoDireita = espacoBranco - espacoEsquerda;// Espaço à direita

        // Retorna o texto formatado com barras laterais
        return "|" + " ".repeat(espacoEsquerda) + texto + " ".repeat(espacoDireita) + "|";
    }

    // Método auxiliar para centralizar o texto (usado para os títulos)
    public String centralizarTexto(String texto, int larguraTotal) {
        texto = texto.replace("\"", "");// Remove as aspas
        int espacoBranco = larguraTotal - texto.length(); // Cálculo do espaço necessário para centralizar
        int espacoEsquerda = espacoBranco / 2; // Espaço à esquerda
        int espacoDireita = espacoBranco - espacoEsquerda; // Espaço à direita

        // Retorna o texto centralizado com os espaços adequados
        return " ".repeat(espacoEsquerda) + texto + " ".repeat(espacoDireita);
    }
    // Método para formatar linha com base no alinhamento e barras laterais

    public String formatarLinha(String texto) {
        int larguraTotal = 40;
        texto = texto.replace("\"", "").trim();

        int espacos = Math.max(0, larguraTotal - texto.length());
        String resultado = texto + " ".repeat(espacos); // alinhamento à esquerda

        return resultado; // sem barras, já que comBarras = false
    }
}
