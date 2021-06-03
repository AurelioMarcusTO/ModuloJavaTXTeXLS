package arquivos_txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditando {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Oficina\\Documents\\AMTO\\Prog. Java\\arquivos_txt\\src\\arquivos_txt\\arquivo_excel.xls");

		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(entrada); /*Prepara a entrada do arquivo excel para ler*/
		
		HSSFSheet planilha = hssfWorkBook.getSheetAt(0);
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while (linhaIterator.hasNext()) {/*Enquanto tiver linha*/
			
			Row linha = linhaIterator.next();/*Dados da pessoa na linha*/
			
			int numeroCelulas = linha.getPhysicalNumberOfCells();/*Quantidade de celulks*/
			
			Cell cell = linha.createCell(numeroCelulas);/*Cria uma nova celula na linnha*/
			cell.setCellValue("5.487,67");
			
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkBook.write(saida);
		saida.flush();
		saida.flush();
		
		
		System.out.println("Planilha atualizada !");
		
	}

}
