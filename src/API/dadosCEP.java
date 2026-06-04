package API;

public class dadosCEP {
	
	private String CEP;
	private String Logradouro;
	private String Bairro;
	private String Local;
	private String UF;
	private String Estado;
	private String Regiao;
	private String DDD;
	
	
	
	public dadosCEP(String CEP, String logradouro, String bairro, String local, String UF, String estado, String regiao,String DDD) {
		this.CEP = CEP;
		this.Logradouro = logradouro;
		this.Bairro = bairro;
		this.Local = local;
		this.UF = UF;
		this.Estado = estado;
		this.Regiao = regiao;
		this.DDD = DDD;
	}
	public dadosCEP(CEP c) {
		this.CEP = c.cep();
		this.Logradouro = c.logradouro();
		this.Bairro = c.bairro();
		this.Local = c.localidade();
		this.UF = c.uf();
		this.Estado = c.estado();
		this.Regiao = c.regiao();
		this.DDD = c.ddd();
	}
	public String getCEP() {
		return CEP;
	}
	public String getLogradouro() {
		return Logradouro;
	}
	public String getBairro() {
		return Bairro;
	}
	public String getLocal() {
		return Local;
	}
	public String getUF() {
		return UF;
	}
	public String getEstado() {
		return Estado;
	}
	public String getRegiao() {
		return Regiao;
	}
	public String getDDD() {
		return DDD;
	}
	
	@Override
	public String toString() {
		return "dadosCEP [CEP=" + CEP + ", Logradouro=" + Logradouro + ", Bairro=" + Bairro + ", Local=" + Local
				+ ", UF=" + UF + ", Estado=" + Estado + ", Regiao=" + Regiao + ", DDD=" + DDD + "]";
	}
}
