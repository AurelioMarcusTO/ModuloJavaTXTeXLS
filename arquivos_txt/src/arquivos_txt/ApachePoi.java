package arquivos_txt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;





public class ApachePoi {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Oficina\\Documents\\AMTO\\Prog. Java\\arquivos_txt\\src\\arquivos_txt\\arquivo_excel.xls"); 
		
		if (!file.exists()) {
			
			file.createNewFile();
			
		}
		
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
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(); /*Usado para escrever a planilha*/
		HSSFSheet linhasPessoa = hssfWorkBook.createSheet("Planilha de pessoas JDEV"); /*Criar a planilha*/
		
		int numeroLinha = 0;
		
		for (Pessoa p : pessoas) {
			
			org.apache.poi.ss.usermodel.Row linha = linhasPessoa.createRow(numeroLinha ++);/*Criando a linha da planilha*/
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula ++); /*Celula 1*/
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula ++); /*Celula 2*/
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++); /*Celula 3*/
			celIdade.setCellValue(p.getIdade());
			
		}
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkBook.write(saida); /*Escreve a planilha em arquivo*/
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada !");
		
	}

}
