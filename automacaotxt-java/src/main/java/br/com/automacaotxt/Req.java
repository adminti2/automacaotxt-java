package br.com.automacaotxt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import java.nio.file.*;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus.costa
 */
public class Req {

    private Processamento process;
    private LeituraResp leitura;

    public Req(Processamento process, LeituraResp leitura) {
        this.process = process;
        this.leitura = leitura;

    }

    private static final String COD_000 = "000-000 = "; //O modificador final garante que o valor não possa ser alterado após a inicialização, e o static permite que a constante pertença à classe em vez de a uma instância específica.
    private String val000 = "";
    private static final String COD_001 = "001-000 = ";
    private String val001 = "";
    private static final String COD_002 = "002-000 = ";
    private String val002 = "";
    private static final String COD_003 = "003-000 = ";
    private String val003 = "";
    private static final String VENDA_SIMPLES_COD_003 = "003-000 = ";
    private String vendaSimplesVal003 = "";
    private static final String COD_004 = "004-000 = ";
    private String val004 = "";
    private static final String COD_010 = "010-000 = ";
    private String val010 = "";
    private static final String COD_012 = "012-000 = ";
    private String val012 = "";
    private static final String COD_018 = "018-000 = ";
    private String val018 = "";
    private static final String COD_022 = "022-000 = ";
    private String val022 = "";
    private static final String COD_023 = "023-000 = ";
    private String val023 = "";
    private static final String COD_706 = "706-000 = ";
    private String val706 = "";
    private static final String COD_716 = "716-000 = ";
    private String val716 = "";
    private static final String COD_726 = "726-000 = ";
    private String val726 = "";
    private static final String COD_731 = "731-000 = ";
    private String val731 = "";
    private static final String COD_732 = "732-000 = ";
    private String val732 = "";
    private static final String COD_733 = "733-000 = ";
    private String val733 = "";
    private static final String COD_735 = "735-000 = ";
    private String val735 = "";
    private static final String COD_736 = "736-000 = ";
    private String val736 = "";
    private static final String COD_738 = "738-000 = ";
    private String val738 = "";
    private static final String COD_749 = "749-000 = ";
    private String val749 = "";
    private static final String COD_999 = "999-999 = ";
    private String val999 = "";

    public String getVal000() {
        return val000;
    }

    public void setVal000(String val000) {
        this.val000 = val000;
    }

    public String getVal001() {
        return val001;
    }

    public void setVal001(String val001) {
        this.val001 = val001;
    }

    public String getVal002() {
        return val002;
    }

    public void setVal002(String val002) {
        this.val002 = val002;
    }

    public String getVal003() {
        return val003;
    }

    public void setVal003(String val003) {
        this.val003 = val003;
    }

    public String getVendaSimplesval003() {
        return vendaSimplesVal003;
    }

    public void setVendaSimplesval003(String val003) {
        this.vendaSimplesVal003 = val003;
    }

    public String getVal004() {
        return val004;
    }

    public void setVal004(String val004) {
        this.val004 = val004;
    }

    public String getVal010() {
        return val010;
    }

    public void setVal010(String val010) {
        this.val010 = val010;
    }

    public String getVal012() {
        return val012;
    }

    public void setVal012(String val012) {
        this.val012 = val012;
    }

    public String getVal018() {
        return val018;
    }

    public void setVal018(String val018) {
        this.val018 = val018;
    }

    public String getVal022() {
        return val022;
    }

    public void setVal022(String val022) {
        this.val022 = val022;
    }

    public String getVal023() {
        return val023;
    }

    public void setVal023(String val023) {
        this.val023 = val023;
    }

    public String getVal706() {
        return val706;
    }

    public void setVal706(String val706) {
        this.val706 = val706;
    }

    public String getVal716() {
        return val716;
    }

    public void setVal716(String val716) {
        this.val716 = val716;
    }

    public String getVal726() {
        return val726;
    }

    public void setVal726(String val726) {
        this.val726 = val726;
    }

    public String getVal731() {
        return val731;
    }

    public void setVal731(String val731) {
        this.val731 = val731;
    }

    public String getVal732() {
        return val732;
    }

    public void setVal732(String val732) {
        this.val732 = val732;
    }

    public String getVal733() {
        return val733;
    }

    public void setVal733(String val733) {
        this.val733 = val733;
    }

    public String getVal735() {
        return val735;
    }

    public void setVal735(String val735) {
        this.val735 = val735;
    }

    public String getVal736() {
        return val736;
    }

    public void setVal736(String val736) {
        this.val736 = val736;
    }

    public String getVal738() {
        return val738;
    }

    public void setVal738(String val738) {
        this.val738 = val738;
    }

    public String getVal749() {
        return val749;
    }

    public void setVal749(String val749) {
        this.val749 = val749;
    }

    public String getVal999() {
        return val999;
    }

    public void setVal999(String val999) {
        this.val999 = val999;
    }
// Define uma constante estática que armazena o nome do arquivo
    private final String FILE_NAME = "intpos.001";

// para gerar números aleatórios
    private final Random random = new Random();

    private final Logger logger = Logger.getLogger(Req.class.getName());

    public void apagarArquivosDentroDoDiretorio() {
        // Cria um objeto Path que representa o caminho especificado para um diretório ou arquivo
// "C:\\PAYGO\\Resp" é o caminho absoluto no sistema de arquivos
        Path caminho = Paths.get("C:\\PAYGO\\Resp");

        try {
            // Utiliza walkFileTree para percorrer todos os arquivos e subdiretórios dentro do diretório especificado
            Files.walkFileTree(caminho, new SimpleFileVisitor<>() {
                // Método chamado para cada arquivo encontrado dentro do diretório
                @Override
                public FileVisitResult visitFile(Path arquivo, BasicFileAttributes attrs) throws IOException {
                    Files.delete(arquivo); // Apaga o arquivo encontrado
                    // Registra no log que o arquivo foi apagado com sucesso
                    logger.log(Level.INFO, "O arquivo {0} foi apagado com sucesso!", arquivo.getFileName());//colocar log

                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (NoSuchFileException e) {
            logger.log(Level.INFO, "A pasta {0} não existe.", caminho);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao apagar arquivos: {0}", e.getMessage());
        }
    }

    public void criarArquivoVendaSimples() {
        String directoryPath = "C:\\PAYGO\\Req";

        String valorSemVirgulaVendaSimples = vendaSimplesVal003.replace(",", "");

        int valorAleatorio = random.nextInt(100000);

        // Construindo o caminho do arquivo
        Path filePath = Paths.get(directoryPath, FILE_NAME);

        // Conteúdo do arquivo
        StringBuilder fileContent = new StringBuilder();
        fileContent.append("000-000 = CRT").append("\n");//sempre ficar atento com os espaços, se tiver espaço no conteudo do valor, o paygo windows nao inicia a venda
        fileContent.append("001-000 = ").append(valorAleatorio).append("\n");
        fileContent.append(VENDA_SIMPLES_COD_003).append(valorSemVirgulaVendaSimples).append("\n");
        fileContent.append("004-000 = 0").append("\n");
        fileContent.append("706-000 = 511").append("\n");
        fileContent.append("716-000 = SETIS AUTOMACAO E SISTEMAS LTDA.").append("\n");
        fileContent.append("726-000 = pt").append("\n");
        fileContent.append("733-000 = 0").append("\n");
        fileContent.append("735-000 = PDVS exemplo").append("\n");
        fileContent.append("736-000 = v1.0").append("\n");
        fileContent.append("738-000 = 1234").append("\n");
        fileContent.append("999-999 = 0").append("\n");

        // Escrevendo o conteúdo no arquivo
        try (FileWriter writer = new FileWriter(filePath.toFile())) {//fileWriter esta escrevendo o conteudo da caixa em um arquivo 
            writer.write(fileContent.toString()); //transforma tudo dentro do stringbuilder(caixa) em uma string

            logger.info("Arquivo criado com sucesso!");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "erro na criacao do arquivo: {0}", e.getMessage());
        }
    }

    public void createFileWithText() {
        String directoryPath = "C:\\PAYGO\\Req";

        String valorSemVirgula = val003.replace(",", "");

        // Usando Paths para construir o caminho do arquivo
        Path filePath = Paths.get(directoryPath, FILE_NAME);
        StringBuilder fileContent = new StringBuilder();

        fileContent.append(COD_000).append(val000).append("\n");
        fileContent.append(COD_001).append(val001).append("\n");
        fileContent.append(COD_002).append(val002).append("\n");
        fileContent.append(COD_003).append(valorSemVirgula).append("\n");
        fileContent.append(COD_004).append(val004).append("\n");

        fileContent.append(COD_010).append(val010).append("\n");
        fileContent.append(COD_012).append(val012).append("\n");

        fileContent.append(COD_018).append(val018).append("\n");
        fileContent.append(COD_022).append(val022).append("\n");
        fileContent.append(COD_023).append(val023).append("\n");

        fileContent.append(COD_706).append(val706).append("\n");
        fileContent.append(COD_716).append(val716).append("\n");
        fileContent.append(COD_726).append(val726).append("\n");
        fileContent.append(COD_731).append(val731).append("\n");
        fileContent.append(COD_732).append(val732).append("\n");
        fileContent.append(COD_733).append(val733).append("\n");
        fileContent.append(COD_735).append(val735).append("\n");
        fileContent.append(COD_736).append(val736).append("\n");
        fileContent.append(COD_738).append(val738).append("\n");
        fileContent.append(COD_749).append(val749).append("\n");
        fileContent.append(COD_999).append(val999).append("\n");

        try (FileWriter writer = new FileWriter(filePath.toFile())) {
            writer.write(fileContent.toString());
            logger.log(Level.INFO, "Arquivo criado com sucesso!");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro na criacao do arquivo: {0}", e.getMessage());
        }
    }

    public void requerConfirmacao() {
        // Instancia a classe de leitura

        // Obtém o valor do campo 729-000 usando o getter
        String valor729000 = leitura.getRespVal729_000();

        // Se o campo não foi encontrado, exibe erro e encerra o método
        if (valor729000 == null) {
            JOptionPane.showMessageDialog(null, "Erro: Campo 729-000 não encontrado no arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Se o valor do campo for "1", sai do método sem fazer nada (não requer confirmação)
        if (valor729000.equals("1")) {
            return;
        }

        // Se o valor do campo for "2", envia a confirmação
        if (valor729000.equals("2")) {
            process.enviarConfirmacao();
        }
    }

    public Map<String, String> obterValoresRequisicao() {

        Map<String, String> valores = new LinkedHashMap<>();
        int valorAleatorio = random.nextInt(100000);

        valores.put("000-000", "000-000 = CNF");

        valores.put("001-000", "001-000 = " + valorAleatorio);

        valores.put("010-000", "010-000 = " + leitura.getRespVal010());
        valores.put("027-000", "027-000 = " + leitura.getRespVal027());
        valores.put("999-999", "999-999 = " + leitura.getRespVal999_999());

        return valores;
    }

    public void criarArquivoRequisicaoConfirmacao() {
        String outputDirectory = "C:\\PAYGO\\Req";

        // Obter os valores a partir dos atributos da classe Leitura
        Map<String, String> valoresCapturados = obterValoresRequisicao();
        //Aqui, o parâmetro "000-000" é explicitamente adicionado ao Map com o valor "000-000 = CNF"

        try {
            apagarArquivosDentroDoDiretorio();
            logger.log(Level.INFO, "Todos os arquivos foram apagados com sucesso.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao apagar os arquivos: {0}", e.getMessage());
            return;
        }

        // Criar o conteúdo do arquivo de requisição
        StringBuilder fileContent = new StringBuilder();
        for (String linhaCompleta : valoresCapturados.values()) {
            fileContent.append(linhaCompleta).append("\n");
        }

        Path outputPath = Paths.get(outputDirectory, FILE_NAME);

        try (FileWriter writer = new FileWriter(outputPath.toFile())) {
            writer.write(fileContent.toString());
            logger.log(Level.INFO, "Arquivo de requisicao criado com sucesso: {0}", outputPath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao criar o arquivo de requisição: {0}", e.getMessage());
        }
    }

    public Map<String, String> obterValoresRequisicaoDesfazimento() {
        Map<String, String> valores = new LinkedHashMap<>();
        int valorAleatorio = random.nextInt(100000);
        // Lista de parâmetros esperados
        valores.put("000-000", "000-000 = NCN");
        valores.put("001-000", "001-000 = " + valorAleatorio);
        valores.put("010-000", "010-000 = " + leitura.getRespVal010());
        valores.put("027-000", "027-000 = " + leitura.getRespVal027());
        valores.put("999-999", "999-999 = " + leitura.getRespVal999_999());

        return valores;
    }

    public void criarArquivoRequisicaoDesfazimento() {
        String outputDirectory = "C:\\PAYGO\\Req";
        Map<String, String> valoresCapturados = obterValoresRequisicaoDesfazimento();

        try {
            apagarArquivosDentroDoDiretorio();
            logger.log(Level.INFO, "Todos os arquivos foram apagados com sucesso.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao apagar os arquivos: {0}", e.getMessage());
            return;
        }

        // Criar o conteúdo do arquivo de requisição
        StringBuilder fileContent = new StringBuilder();
        for (String linhaCompleta : valoresCapturados.values()) {
            fileContent.append(linhaCompleta).append("\n");
        }

        Path outputPath = Paths.get(outputDirectory, FILE_NAME);

        try (FileWriter writer = new FileWriter(outputPath.toFile())) {
            writer.write(fileContent.toString());
            logger.log(Level.INFO, "Arquivo de requisicao criado com sucesso: {0}", outputPath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao criar o arquivo de requisicao: {0}", e.getMessage());
        }
    }
}
