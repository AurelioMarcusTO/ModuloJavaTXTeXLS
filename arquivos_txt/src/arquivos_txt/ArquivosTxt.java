package arquivos_txt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivosTxt {

	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Marcus");
		pessoa1.setEmail("marcus@gmail.com");
		pessoa1.setIdade("43");
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Maria");
		pessoa2.setEmail("maria@gmail.com");
		pessoa2.setIdade("18");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Jose");
		pessoa3.setEmail("jose@gmail.com");
		pessoa3.setIdade("34");
		
		/*Essa lista pode vir de um Banco de Dados*/
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		
		File arquivo = new File("C:\\Users\\Oficina\\Documents\\AMTO\\Prog. Java\\arquivos_txt\\src\\arquivos_txt.csv\\");
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);
		
		for (Pessoa p : pessoas) {
			
			escrever_no_arquivo.write(p.getNome() + " ; " + p.getEmail() + " ; " + p.getIdade() + " \n");
			
		}
		
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();
		
		
	}

}
