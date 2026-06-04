package API;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner input = new Scanner(System.in);
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		List<dadosCEP> CEPs = new LinkedList<dadosCEP>();
		
		while(true) {
		System.out.println("Qual CEP você busca?");
		var opçao = input.nextLine();
		
		if(opçao.equalsIgnoreCase("sair")) {
			break;
		}
		
		String endereço = "https://viacep.com.br/ws/"+opçao+"/json/";
		try {
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(URI.create(endereço)).build();
		HttpResponse <String> response = cliente.send(request, BodyHandlers.ofString());
		
		String json = response.body();
		
		CEP c = g.fromJson(json, CEP.class);
		
		dadosCEP d = new dadosCEP(c);
		CEPs.add(d);
		System.out.println(d);
		} catch (JsonSyntaxException e) {
			System.out.println("Erro, endereço não encontrado");
		}
		}
		
		FileWriter escrita = new FileWriter("CEP.json");
		escrita.write(g.toJson(CEPs));
		escrita.close();
		
		System.out.println(CEPs);
		System.out.println("Busca concluida com sucesso!");
	}

}
