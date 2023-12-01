package com.rmj.tqs;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Conta {
	
	/**
	 * @author Luiz Minozi
	 * @param num1 Este é o primeiro parâmetro
	 * @throws Throwable
	 */
	
    private int balance;
    private boolean special;
    private int count;
    
    public int getbalance() {
    	return balance;
    }
    
    public void setbalance(int balance) {
    	this.balance = balance;
    }
    
    public void sacar(int qtd) {
        if(balance >= qtd || special) {
            balance-= qtd;
            count++;
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }
    
    public void setSpecial(boolean special){
    	special = special;
    }
    
    public boolean getspecial() {
        return special;
    }
    
    /* 
     * Conta normal
     */
    @Given("^Um cliente normal com saldo atual de {int} reais")
    public void um_cliente_normal_com_saldo_atual_de_reais(Integer num1) {
       special = false;
        balance = num1;
    }


    @When("^for solicitado um saque no valor de {int} reais")
    public void solicitado_um_saque_no_valor_de_reais(Integer num1) {
        sacar(num1);
    }

    @Then("^não deve sacar o dinehrio e deve retornar uma mensagem de erro ao cliente")
    public void nao_efetuar_o_saque_e_retornar_mensagem_de_erro() {
        assert count == 0;
    }
    
    
    /* 
     * Conta especial
     */
    @Given("^Um cliente especial com saldo atual de {int} reais")
    public void um_cliente_especial_com_saldo_atual_de_reais(Integer num1) {
       special = true;
        balance = num1;
    }


    @When("^for solicitado um saque no valor de {int} reais")
    public void for_solicitado_um_saque_no_valor_de_reais(Integer num1) {
        sacar(num1);
    }

    @Then("^deve efetuar o saque e atualizar o saldo da conta para {int} reais")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer num1) {
        assert num1 == balance;
    }


    @Then("check more outcomes")
    public void check_more_outcomes() {
        assert special;
    }
}
    
   
 