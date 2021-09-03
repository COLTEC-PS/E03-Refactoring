package ContaBancaria;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    // TODO(#1) REFATORAR: Esses dados deveriam ficar em outro lugar
    private String nomeCliente;
    private String cpfCliente;
    private String telefoneCliente;

    // TODO(#1) REFATORAR: Esses dados deveriam ficar em outro lugar
    private int numAgencia;
    private int numConta;
    private String gerente;

    // TODO(#2) REFATORAR: Esse nome não é o ideal para representar o saldo da conta
    private double saldo;

    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double valor) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.numAgencia = numAgencia;
        this.numConta = numConta;
        this.gerente = gerente;
        this.saldo = valor;

        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public List<Operacao> getOperacoes(){
        return this.operacoes;
    }

    // TODO(#3) REFATORAR: Muita responsabilidade para o mesmo método
    public void realizarOperacao(char tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);

        if (tipo == 'd')
            this.saldo += valor;
        else if(tipo == 's')
            this.saldo -= valor;
    }

    public String toString() {
        // TODO(#4) REFATORAR: Esses dados não estão relacionados a conta
        String dadosCliente = String.format("CPF: %s\nNome: %s\nTelefone: %s",
                this.cpfCliente, this.nomeCliente, this.telefoneCliente);

        // TODO(#4) REFATORAR: Esses dados não estão relacinados a conta
        String dadosConta = String.format("Ag.: %d\nConta: %d\nGerente: %s\nSaldo: %.2f",
                this.numAgencia, this.numConta, this.gerente, this.saldo);

        // TODO(#5) REFATORAR: Essa operação não deveria estar sendo realizada neste método
        String dadosExtrato = "";
        for(Operacao op : this.operacoes) {
            dadosExtrato += op.toString() + "\n";
        }

        return "-----CLIENTE-----\n" +
                dadosCliente +
                "\n\n" +
                "-----CONTA-----\n" +
                dadosConta +
                "\n\n" +
                "-----EXTRATO-----\n" +
                dadosExtrato +
                "\n";
    }
}
