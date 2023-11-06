package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class FuncTelaArquivo {

	public static String[] lePdf(String nome, File file, File arq){
		PDDocument pdf = null;
		try {
			pdf = PDDocument.load(file);
			PDFTextStripper striper = new PDFTextStripper();
			String texto = striper.getText(pdf);
			var linhas = texto.split("\n");
			pdf.close();
			return linhas;
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String[] leDoc(File arq, String caminho) throws FileNotFoundException, IOException {
		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(caminho));
		try (WordExtractor extractor = new WordExtractor(fs)) {
			String wordText = extractor.getText();
			
			String[] linhas = wordText.split("\n");
			return linhas;
		}
	}
	
	public static void criaTxtComLista(String[] linhas, File arq) throws IOException {
		FileWriter fw = new FileWriter(arq, true);
		BufferedWriter bw = new BufferedWriter(fw);
		for(String linha: linhas) {
    		bw.write(linha);
    		bw.newLine();
		}
		bw.close();
		fw.close();
	}
	
	public static void criaTxt(File arquivo, String caminho) throws IOException {
		   arquivo.createNewFile();
		   FileWriter fw = new FileWriter(arquivo, true);
		   BufferedWriter bw = new BufferedWriter(fw);
		   BufferedReader buferredReader = new BufferedReader(new FileReader(caminho));
		   String str1 = "";
		   while (buferredReader.ready()) {
			   str1 = buferredReader.readLine();
			   bw.write(str1);
			   bw.newLine();
		   }
		   buferredReader.close();
		   bw.close();
		   fw.close();
	}
	
	public static void escolheFormato(String formato, File arquivo, String nome, String caminho, File file) throws FileNotFoundException, IOException {
		if(formato.equals(".txt")) {
 		   arquivo = new File("C:\\Users\\Manhã\\Desktop\\" + nome);
	    	   if(arquivo.exists()) {
	    		   JOptionPane.showMessageDialog(null, "Um arquivo com o mesmo nome já foi carregado. Por favor escolha outro nome para o arquivo.");
	    	   } else {
	    		   FuncTelaArquivo.criaTxt(arquivo, caminho);
	    		   JOptionPane.showMessageDialog(null, "Arquivo Carregado com Sucesso!");
	    	   }
		   } else if(formato.equals(".doc")) {    		   
			   	arquivo = new File("C:\\Users\\Manhã\\Desktop\\" + nome.substring(0, nome.length() - 4) + "txt");
			   	if(arquivo.exists()) {
			   		JOptionPane.showMessageDialog(null, "Um arquivo com o mesmo nome já foi carregado. Por favor escolha outro nome para o arquivo.");
			   	} else {
			   		var linhas = FuncTelaArquivo.leDoc(file, caminho);
			   		FuncTelaArquivo.criaTxtComLista(linhas, arquivo);
			   		JOptionPane.showMessageDialog(null, "Arquivo Carregado com Sucesso!");
	    	   }
		   } else {
	    			File arq = new File("C:\\Users\\Manhã\\Desktop\\" + nome.substring(0, nome.length() - 4) + ".txt");
	    			if(arq.exists()) {
	    				JOptionPane.showMessageDialog(null, "Um arquivo com o mesmo nome já foi carregado. Por favor escolha outro nome para o arquivo.");
	    			} else {
	    				arq.createNewFile();
	    				var linhas = FuncTelaArquivo.lePdf(nome, file, arq);
	    				FuncTelaArquivo.criaTxtComLista(linhas, arq);
	    				JOptionPane.showMessageDialog(null, "Arquivo Carregado com Sucesso!");
	    			}
 	   }
	}
	
	public static void escolheFiltro(boolean[] formatos, JFileChooser chooser) {
		if(formatos[3] == true) {
	    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Formato csv", "csv");			    	
	    	chooser.setFileFilter(filter);
	    } else if(formatos[1] == true) {
	    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Formato doc", "doc");			    	
	    	chooser.setFileFilter(filter);
	    } else if(formatos[2] == true) {
	    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Formato txt", "txt");			    	
	    	chooser.setFileFilter(filter);
	    } else {
	    	FileNameExtensionFilter filter = new FileNameExtensionFilter("Formato pdf", "pdf");			    	
	    	chooser.setFileFilter(filter);
	    }
	}
}
