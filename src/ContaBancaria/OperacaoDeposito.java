package ContaBancaria;

public class OperacaoDeposito extends Operacao{

    public OperacaoDeposito(double valor){
        super('d', valor);
    }

    @Override
    public String getTipo(){
        return "Depósito";
    }
    
}
