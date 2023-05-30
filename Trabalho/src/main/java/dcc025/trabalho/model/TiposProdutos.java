/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dcc025.trabalho.model;

/**
 *
 * @author gabri
 */
public interface TiposProdutos {
    
    public static enum TipoRoupa{
        N_A, SAPATO, CALCA, BLUSA, CONJUNTO, ACESSORIOS
    }
    
    public static enum TipoEletrodomestico{
        N_A, GELADEIRA, FOGAO, COMPUTADOR, TV, MAQUINA_DE_LAVAR
    }
    
    public static enum TipoMatEscritorio{
        N_A, CANETA, LAPIS, BORRACHA, PAPEL, CLIPES
    }
    
    public static enum TipoMovel{
        N_A, ASSENTO, MESA, ESTANTE, QUADRO, LUMINARIA, ARMARIO, CAMA
    }
}
