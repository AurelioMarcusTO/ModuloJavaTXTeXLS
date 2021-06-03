package arquivos_txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;





public class ApachePoi2 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream entrada = new FileInputStream(new File("C:\\Users\\Oficina\\Documents\\AMTO\\Prog. Java\\arquivos_txt\\src\\arquivos_txt\\arquivo_excel.xls"));
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(entrada); /*Prepara a entrada do arquivo excel para ler*/
		
		HSSFSheet planilha = hssfWorkBook.getSheetAt(0); /*Pega a primeira planilha do nosso arquivo excel*/
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (linhaIterator.hasNext()) {/*Enquanto tiver linha no Excel*/
			
			Row linha = linhaIterator.next();/*Dados da pedssoa na linha*/
			
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while (celulas.hasNext()) {/*Percorrer as celulas*/
				Cell cell = celulas.next();
				
				switch (cell.getColumnIndex()) {
				
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
					
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
				
					
				case 2:
					pessoa.setIdade(cell.getStringCellValue());
					break;
					
				}
			}
			
			pessoas.add(pessoa);
			
		}
		
		entrada.close();
		for (Pessoa p : pessoas) {
			
			System.out.println(p);
			
		}
		
	}

}
