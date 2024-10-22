/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd;

import java.sql.SQLException;
import java.util.List;
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaFisicaDAO;
import cadastrobd.model.PessoaJuridica;
import cadastrobd.model.PessoaJuridicaDAO;
import cadastrobd.model.util.ConectorBD;
import java.sql.Connection;


 */
public class CadastroBDTeste {

    public static void main(String[] args) {
        try {
            Connection conn = ConectorBD.getConnection();
            PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
            PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();

            // Criar uma pessoa física
            PessoaFisica pf = new PessoaFisica(6, "Pedro", "Rua A, 10", "Atibaia", "SP", 
                    "1234-5678", "pedro@gmail.com", "12345678910");

            // Persistir a pessoa física no banco de dados
            pfDAO.incluir(pf);
            System.out.println("Pessoa fisica criada:");
            pf.exibir();
            System.out.println();

            // Alterar os dados da pessoa fisica no banco
            pfDAO.alterar(pf, "Pedro Alves", "Rua B, 11", "Atibaia", "SP",
                    "9999-8888", "pedro.alves@email.com", "12345678900");
            System.out.println("---------------------------------");  
            System.out.println("Dados da pessoa fisica alterados.");
            System.out.println("---------------------------------");
            System.out.println();

            // Consultar todas as pessoas físicas do banco de dados e listar no console
            List<PessoaFisica> pessoasFisicas = pfDAO.getPessoas();
            System.out.println("Todas as pessoas fisicas:");
            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                pessoaFisica.exibir();
            }
            System.out.println();

            // Excluir a pessoa física criada anteriormente no banco
            System.out.println("---------------------------------");  
            pfDAO.excluir(pf.getId());
            System.out.println("---------------------------------");
            System.out.println();
       
            // Criar uma pessoa jurídica
            PessoaJuridica pj = new PessoaJuridica(7, "Empresa ABC", "Av. Principal, 100",
                    "Sao Paulo", "SP", "1234-5678", "empresa@abc.com", "12345678901234");

            // Persistir a pessoa jurídica no banco de dados
            pjDAO.incluir(pj);
            System.out.println("Pessoa juridica criada:");
            pj.exibir();
            System.out.println();

            // Alterar os dados da pessoa jurídica no banco
            pjDAO.alterar(pj, "Companhia ABC", "Av. Nova, 200", "Rio de Janeiro", "RJ",
                    "9876-5432", "companhia@abc.com", "98765432109876");
            System.out.println("---------------------------------");  
            System.out.println("Dados da pessoa juridica alterados.");
            System.out.println("---------------------------------");
            System.out.println();

            // Consultar todas as pessoas jurídicas do banco de dados e listar no console
            List<PessoaJuridica> pessoasJuridicas = pjDAO.getPessoas();
            System.out.println("Todas as pessoas juridicas:");
            for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {
                pessoaJuridica.exibir();
            }
            System.out.println();

            // Excluir a pessoa jurídica criada anteriormente no banco
            System.out.println("---------------------------------");  
            pjDAO.excluir(pj.getId());
            System.out.println("---------------------------------");
            System.out.println();

            ConectorBD.close(conn);

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}

