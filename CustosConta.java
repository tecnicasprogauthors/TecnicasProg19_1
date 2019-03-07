/*

Cálculo dos juros sobre saldo negativo: 

O banco cobra 0,3% de juros ao dia sobre o saldo negativo. Para calcular o total de juros a serem cobrados no final do mês é necessário gerar uma lista com os saldos diários do mês e acumular o equivalente a 0,3% sobre o saldo de cada dia em que este for negativo. O valor acumulado é o valor a ser cobrado. 

*/

public class CustosConta
{ 

    public CustosConta(EstatisticaCliente estatistica,  
                       PontuacaoCliente pontuacao)
    {
	this.estatistica = estatistica;
	this.pontuacao = pontuacao;

    } 

  

    public double jurosNoMes(int nroConta,int mes,int ano)
    { 

        List<Double> saldos = estatistica.saldosMes(nroConta, mes, ano);
	double juros = 0;
	for (int i = 0; i < saldos.length(); i++)
	{
		if ( saldos.get(i) < 0)
		{
			juros+=saldos.get(i)*0.3;
		}
	}
        return juros; 

    } 

  

    public double taxaNoMes(int nroConta,int mes, int ano)
    {
	double taxaBasica = 100;
	if(pontuacao.pontuacaoSaldoMedio(nroConta,mes,ano) > 5000)	
	{
		taxaBasica-=(taxaBasica*0.3);
	}
	else if(pontuacao.pontuacaoSaldoMedio(nroConta,mes,ano) > 10000)
	{
		taxaBasica-=(taxaBasica*0.5);
	}
	else if(pontuacao.pontuacaoSaldoMedio(nroConta,mes,ano) > 20000)
	{
		taxaBasica = 0;
	}
	return taxaBasica;
    } 

} 
