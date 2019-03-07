public class PontuacaoCliente
{ 
    private EstatisticaCliente estatistica;

    public PontuacaoCliente(EstatisticaCliente estatistica)
    { 
        this.estatistica = estatistica;
    } 

    public double pontuacaoSaldoMedio(int nroConta,int mes,int ano)
    { 
        return (1000 * (estatistica.saldoMedioMes(nroConta, mes, ano) % 1000));
    } 

    public double pontuacaoValorMedioOperacoes(int nroConta,int mes,int ano)
    { 
        double valor = estatistica.valorMedioOperacoes(nroConta, mes, ano);
        if (valor > 300) return (100*(valor % 100));
        else return 0;
    } 

    public double pontuacaoSaldoMedioNegativoMes(int nroConta,int mes,int ano)
    { 
        //Se o valor do saldo médio negativo do mês é maior que R$ 500,00, então Pontos -= ((100*(valorMedioSaldoNegativo % 100) /2.0)    
        double valor = estatistica.saldoMedioNegativoMes(nroConta, mes, ano);
        if (valor > 500) return ((100*(valor % 100) /2.0));
        else return 0;
    } 

} 