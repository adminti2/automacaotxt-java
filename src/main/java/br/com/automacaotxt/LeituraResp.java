/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.automacaotxt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus.costa
 */
public class LeituraResp {

    private static final Logger logger = Logger.getLogger(LeituraResp.class.getName());

    private String respVal000 = "";
    private String respVal001 = "";
    private String respVal002 = "";
    private String respVal003 = "";
    private String respVal004 = "";
    private String respVal006 = "";

    private String respVal009 = "";
    private String respVal010 = "";
    private String respVal011 = "";
    private String respVal012 = "";
    private String respVal013 = "";
    private String respVal017 = "";
    private String respVal018 = "";
    private String respVal022 = "";
    private String respVal023 = "";
    private String respVal024 = "";
    private String respVal025 = "";
    private String respVal026 = "";
    private String respVal027 = "";
    private String respVal028 = "";
    private String respVal029 = "";
    private String respVal030 = "";
    private String respVal040 = "";
    private String respVal710 = "";
    private String respVal711_001 = "";
    private String respVal711_002 = "";
    private String respVal711_003 = "";
    private String respVal711_004 = "";
    private String respVal711_005 = "";
    private String respVal712_000 = "";
    private String respVal713_001 = "";
    private String respVal713_002 = "";
    private String respVal713_003 = "";
    private String respVal713_004 = "";
    private String respVal713_005 = "";
    private String respVal713_006 = "";
    private String respVal713_007 = "";
    private String respVal713_008 = "";
    private String respVal713_009 = "";
    private String respVal713_010 = "";
    private String respVal713_011 = "";
    private String respVal713_012 = "";
    private String respVal713_013 = "";
    private String respVal713_014 = "";
    private String respVal713_015 = "";
    private String respVal713_016 = "";
    private String respVal713_017 = "";
    private String respVal713_018 = "";
    private String respVal713_019 = "";
    private String respVal713_020 = "";
    private String respVal713_021 = "";
    private String respVal713_022 = "";

    private String respVal714_000 = "";
    private String respVal715_001 = "";
    private String respVal715_002 = "";
    private String respVal715_003 = "";
    private String respVal715_004 = "";
    private String respVal715_005 = "";
    private String respVal715_006 = "";
    private String respVal715_007 = "";
    private String respVal715_008 = "";
    private String respVal715_009 = "";
    private String respVal715_010 = "";
    private String respVal715_011 = "";
    private String respVal715_012 = "";
    private String respVal715_013 = "";
    private String respVal715_014 = "";
    private String respVal715_015 = "";
    private String respVal715_016 = "";
    private String respVal715_017 = "";
    private String respVal715_018 = "";
    private String respVal715_019 = "";
    private String respVal715_020 = "";
    private String respVal715_021 = "";
    private String respVal715_022 = "";
    private String respVal718_000 = "";
    private String respVal719_000 = "";
    private String respVal729_000 = "";
    private String respVal730_000 = "";
    private String respVal731_000 = "";
    private String respVal732_000 = "";
    private String respVal733_000 = "";
    private String respVal735_000 = "";
    private String respVal736_000 = "";
    private String respVal738_000 = "";
    private String respVal737_000 = "";
    private String respVal739_000 = "";
    private String respVal740_000 = "";
    private String respVal747_000 = "";
    private String respVal748_000 = "";
    private String respVal999_999 = "";

    public String getRespVal000() {
        return respVal000;
    }

    public String getRespVal001() {
        return respVal001;
    }

    public String getRespVal002() {
        return respVal002;
    }

    public String getRespVal003() {
        return respVal003;
    }

    public String getRespVal004() {
        return respVal004;
    }

    public String getRespVal006() {
        return respVal006;
    }

    public String getRespVal009() {
        return respVal009;
    }

    public String getRespVal010() {
        return respVal010;
    }

    public String getRespVal011() {
        return respVal011;
    }

    public String getRespVal012() {
        return respVal012;
    }

    public String getRespVal013() {
        return respVal013;
    }

    public String getRespVal017() {
        return respVal017;
    }

    public String getRespVal018() {
        return respVal018;
    }

    public String getRespVal022() {
        return respVal022;
    }

    public String getRespVal023() {
        return respVal023;
    }

    public String getRespVal024() {
        return respVal024;
    }

    public String getRespVal025() {
        return respVal025;
    }

    public String getRespVal026() {
        return respVal026;
    }

    public String getRespVal027() {
        return respVal027;
    }

    public String getRespVal028() {
        return respVal028;
    }

    public String getRespVal029() {
        return respVal029;
    }

    public String getRespVal030() {
        return respVal030;
    }

    public String getRespVal040() {
        return respVal040;
    }

    public String getRespVal710() {
        return respVal710;
    }

    public String getRespVal711_001() {
        return respVal711_001;
    }

    public String getRespVal711_002() {
        return respVal711_002;
    }

    public String getRespVal711_003() {
        return respVal711_003;
    }

    public String getRespVal711_004() {
        return respVal711_004;
    }

    public String getRespVal711_005() {
        return respVal711_005;
    }

    public String getRespVal712_000() {
        return respVal712_000;
    }

    public String getRespVal713_001() {
        return respVal713_001;
    }

    public String getRespVal713_002() {
        return respVal713_002;
    }

    public String getRespVal713_003() {
        return respVal713_003;
    }

    public String getRespVal713_004() {
        return respVal713_004;
    }

    public String getRespVal713_005() {
        return respVal713_005;
    }

    public String getRespVal713_006() {
        return respVal713_006;
    }

    public String getRespVal713_007() {
        return respVal713_007;
    }

    public String getRespVal713_008() {
        return respVal713_008;
    }

    public String getRespVal713_009() {
        return respVal713_009;
    }

    public String getRespVal713_010() {
        return respVal713_010;
    }

    public String getRespVal713_011() {
        return respVal713_011;
    }

    public String getRespVal713_012() {
        return respVal713_012;
    }

    public String getRespVal713_013() {
        return respVal713_013;
    }

    public String getRespVal713_014() {
        return respVal713_014;
    }

    public String getRespVal713_015() {
        return respVal713_015;
    }

    public String getRespVal713_016() {
        return respVal713_016;
    }

    public String getRespVal713_017() {
        return respVal713_017;
    }

    public String getRespVal713_018() {
        return respVal713_018;
    }

    public String getRespVal713_019() {
        return respVal713_019;
    }

    public String getRespVal713_020() {
        return respVal713_020;
    }

    public String getRespVal713_021() {
        return respVal713_021;
    }

    public String getRespVal713_022() {
        return respVal713_022;
    }

    public String getRespVal714_000() {
        return respVal714_000;
    }

    public String getRespVal715_001() {
        return respVal715_001;
    }

    public String getRespVal715_002() {
        return respVal715_002;
    }

    public String getRespVal715_003() {
        return respVal715_003;
    }

    public String getRespVal715_004() {
        return respVal715_004;
    }

    public String getRespVal715_005() {
        return respVal715_005;
    }

    public String getRespVal715_006() {
        return respVal715_006;
    }

    public String getRespVal715_007() {
        return respVal715_007;
    }

    public String getRespVal715_008() {
        return respVal715_008;
    }

    public String getRespVal715_009() {
        return respVal715_009;
    }

    public String getRespVal715_010() {
        return respVal715_010;
    }

    public String getRespVal715_011() {
        return respVal715_011;
    }

    public String getRespVal715_012() {
        return respVal715_012;
    }

    public String getRespVal715_013() {
        return respVal715_013;
    }

    public String getRespVal715_014() {
        return respVal715_014;
    }

    public String getRespVal715_015() {
        return respVal715_015;
    }

    public String getRespVal715_016() {
        return respVal715_016;
    }

    public String getRespVal715_017() {
        return respVal715_017;
    }

    public String getRespVal715_018() {
        return respVal715_018;
    }

    public String getRespVal715_019() {
        return respVal715_019;
    }

    public String getRespVal715_020() {
        return respVal715_020;
    }

    public String getRespVal715_021() {
        return respVal715_021;
    }

    public String getRespVal715_022() {
        return respVal715_022;
    }

    public String getRespVal718_000() {
        return respVal718_000;
    }

    public String getRespVal719_000() {
        return respVal719_000;
    }

    public String getRespVal729_000() {
        return respVal729_000;
    }

    public String getRespVal730_000() {
        return respVal730_000;
    }

    public String getRespVal731_000() {
        return respVal731_000;
    }

    public String getRespVal732_000() {
        return respVal732_000;
    }

    public String getRespVal733_000() {
        return respVal733_000;
    }

    public String getRespVal735_000() {
        return respVal735_000;
    }

    public String getRespVal736_000() {
        return respVal736_000;
    }

    public String getRespVal738_000() {
        return respVal738_000;
    }

    public String getRespVal737_000() {
        return respVal737_000;
    }

    public String getRespVal739_000() {
        return respVal739_000;
    }

    public String getRespVal740_000() {
        return respVal740_000;
    }

    public String getRespVal747_000() {
        return respVal747_000;
    }

    public String getRespVal748_000() {
        return respVal748_000;
    }

    public String getRespVal999_999() {
        return respVal999_999;
    }

    public void lerArquivo() {
        String filePath = "C:\\PAYGO\\Resp\\intpos.001";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                atribuirValor(linha);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao ler o arquivo: {0}", e.getMessage());
        }
    }

    private void atribuirValor(String linha) {
        String[] partes = linha.split(" = ");
        //Garante que a linha está no formato esperado. Se não houver um " = ", o código não executa a atribuição.
        if (partes.length == 2) {
            String campo = partes[0].trim(); //trim() remove espaços em branco antes e depois da string.
            String valor = partes[1].trim();
            //O código divide a linha pelo delimitador " = ", gerando um array partes com duas posições:
//partes[0] → contém o código do campo (exemplo: "009-000").
//partes[1] → contém o valor associado a esse campo (exemplo: "0")

            switch (campo) {
                case "000-000":
                    this.respVal000 = valor;
                    break;
                case "001-000":
                    this.respVal001 = valor;
                    break;
                case "002-000":
                    this.respVal002 = valor;
                    break;
                case "003-000":
                    this.respVal003 = valor;
                    break;
                case "004-000":
                    this.respVal004 = valor;
                    break;
                case "006-000":
                    this.respVal006 = valor;
                    break;

                case "009-000":
                    this.respVal009 = valor;
                    break;
                case "010-000":
                    this.respVal010 = valor;
                    break;
                case "011-000":
                    this.respVal011 = valor;
                    break;
                case "012-000":
                    this.respVal012 = valor;
                    break;
                case "013-000":
                    this.respVal013 = valor;
                    break;
                case "017-000":
                    this.respVal017 = valor;
                    break;
                case "018-000":
                    this.respVal018 = valor;
                    break;
                case "022-000":
                    this.respVal022 = valor;
                    break;
                case "023-000":
                    this.respVal023 = valor;
                    break;
                case "024-000":
                    this.respVal024 = valor;
                    break;
                case "025-000":
                    this.respVal025 = valor;
                    break;
                case "026-000":
                    this.respVal026 = valor;
                    break;
                case "027-000":
                    this.respVal027 = valor;
                    break;
                case "028-000":
                    this.respVal028 = valor;
                    break;
                case "029-000":
                    this.respVal029 = valor;
                    break;
                case "030-000":
                    this.respVal030 = valor;
                    break;
                case "040-000":
                    this.respVal040 = valor;
                    break;
                case "710-000":
                    this.respVal710 = valor;
                    break;
                case "711-001":
                    this.respVal711_001 = valor;
                    break;
                case "711-002":
                    this.respVal711_002 = valor;
                    break;
                case "711-003":
                    this.respVal711_003 = valor;
                    break;
                case "711-004":
                    this.respVal711_004 = valor;
                    break;
                case "711-005":
                    this.respVal711_005 = valor;
                    break;
                case "712-000":
                    this.respVal712_000 = valor;
                    break;
                case "713-001":
                    this.respVal713_001 = valor;
                    break;
                case "713-002":
                    this.respVal713_002 = valor;
                    break;
                case "713-003":
                    this.respVal713_003 = valor;
                    break;
                case "713-004":
                    this.respVal713_004 = valor;
                    break;
                case "713-005":
                    this.respVal713_005 = valor;
                    break;
                case "713-006":
                    this.respVal713_006 = valor;
                    break;
                case "713-007":
                    this.respVal713_007 = valor;
                    break;
                case "713-008":
                    this.respVal713_008 = valor;
                    break;
                case "713-009":
                    this.respVal713_009 = valor;
                    break;
                case "713-010":
                    this.respVal713_010 = valor;
                    break;
                case "713-011":
                    this.respVal713_011 = valor;
                    break;
                case "713-012":
                    this.respVal713_012 = valor;
                    break;
                case "713-013":
                    this.respVal713_013 = valor;
                    break;
                case "713-014":
                    this.respVal713_014 = valor;
                    break;
                case "713-015":
                    this.respVal713_015 = valor;
                    break;
                case "713-016":
                    this.respVal713_016 = valor;
                    break;
                case "713-017":
                    this.respVal713_017 = valor;
                    break;
                case "713-018":
                    this.respVal713_018 = valor;
                    break;
                case "713-019":
                    this.respVal713_019 = valor;
                    break;
                case "713-020":
                    this.respVal713_020 = valor;
                    break;
                case "713-021":
                    this.respVal713_021 = valor;
                    break;
                case "713-022":
                    this.respVal713_022 = valor;
                    break;
                case "714-000":
                    this.respVal714_000 = valor;
                    break;
                case "715-001":
                    this.respVal715_001 = valor;
                    break;
                case "715-002":
                    this.respVal715_002 = valor;
                    break;
                case "715-003":
                    this.respVal715_003 = valor;
                    break;
                case "715-004":
                    this.respVal715_004 = valor;
                    break;
                case "715-005":
                    this.respVal715_005 = valor;
                    break;
                case "715-006":
                    this.respVal715_006 = valor;
                    break;
                case "715-007":
                    this.respVal715_007 = valor;
                    break;
                case "715-008":
                    this.respVal715_008 = valor;
                    break;
                case "715-009":
                    this.respVal715_009 = valor;
                    break;
                case "715-010":
                    this.respVal715_010 = valor;
                    break;
                case "715-011":
                    this.respVal715_011 = valor;
                    break;
                case "715-012":
                    this.respVal715_012 = valor;
                    break;
                case "715-013":
                    this.respVal715_013 = valor;
                    break;
                case "715-014":
                    this.respVal715_014 = valor;
                    break;
                case "715-015":
                    this.respVal715_015 = valor;
                    break;
                case "715-016":
                    this.respVal715_016 = valor;
                    break;
                case "715-017":
                    this.respVal715_017 = valor;
                    break;
                case "715-019":
                    this.respVal715_019 = valor;
                    break;
                case "715-020":
                    this.respVal715_020 = valor;
                    break;
                case "715-021":
                    this.respVal715_021 = valor;
                    break;
                case "715-022":
                    this.respVal715_022 = valor;
                    break;
                case "715-018":
                    this.respVal715_018 = valor;
                    break;
                case "718-000":
                    this.respVal718_000 = valor;
                    break;
                case "719-000":
                    this.respVal719_000 = valor;
                    break;
                case "729-000":
                    this.respVal729_000 = valor;
                    break;
                case "730-000":
                    this.respVal730_000 = valor;
                    break;
                case "731-000":
                    this.respVal731_000 = valor;
                    break;
                case "732-000":
                    this.respVal732_000 = valor;
                    break;
                case "733-000":
                    this.respVal733_000 = valor;
                    break;
                case "735-000":
                    this.respVal735_000 = valor;
                    break;
                case "736-000":
                    this.respVal736_000 = valor;
                    break;
                case "738-000":
                    this.respVal738_000 = valor;
                    break;
                case "737-000":
                    this.respVal737_000 = valor;
                    break;
                case "739-000":
                    this.respVal739_000 = valor;
                    break;
                case "740-000":
                    this.respVal740_000 = valor;
                    break;
                case "747-000":
                    this.respVal747_000 = valor;
                    break;
                case "748-000":
                    this.respVal748_000 = valor;
                    break;
                case "999-999":
                    this.respVal999_999 = valor;
                    break;
                default:

                    break;
            }

        }

    }

}
