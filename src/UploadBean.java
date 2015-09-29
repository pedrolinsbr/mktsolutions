import java.io.IOException;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;
import javax.swing.plaf.synth.SynthSeparatorUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@ManagedBean(name="uploadBean")
@ViewScoped

public class UploadBean {
	private Part file;

	private List<Eventos> eventos = new ArrayList<Eventos>();
	
	String retorno = "";
	
	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public List<Eventos> upload() throws IOException{

		Scanner s  = new Scanner(file.getInputStream());
		System.out.println("inicialllllllllllllllllllllllll: "+s);		
		String fileContent  = s.useDelimiter("\\A").next();
		System.out.println("File Content: "+ fileContent);
		System.out.println("S to string: "+ s.toString() );

		File arquivo = new File("arquivo.csv");
		try( FileWriter fw = new FileWriter(arquivo) ){
			fw.write(fileContent);		    
			fw.flush();
		}catch(IOException ex){
			ex.printStackTrace();
		}

		System.out.println("Arquivo: "+arquivo);
		//Criação de um buffer para a ler de uma stream
		BufferedReader StrR = new BufferedReader(new FileReader("arquivo.csv"));

		String Str;

		String[] TableLine;

		//Essa estrutura do looping while é clássica para ler cada linha
		//do arquivo 
		StrR.readLine();

		while((Str = StrR.readLine())!= null){
			//Aqui usamos o método split que divide a linha lida em um array de String
			//passando como parametro o divisor ";".
			TableLine = Str.split(";");			
			
			System.out.println("table like ==========="+TableLine.length);
			if (TableLine.length == 3){
				String nome = TableLine[TableLine.length-3];
				System.out.print(" Telefone: "+TableLine[TableLine.length-2] +"nome: "+nome);
				String msg = TableLine[TableLine.length-1];
				msg = "Ola "+ nome +". "+ msg;
				String numero = TableLine[TableLine.length-2] ;
				Eventos eve = new Eventos();
				eve.setNome(nome);
				eve.setCel(numero);
				eve.setMsg(msg);
				
				eventos.add(eve);
				System.out.println(nome +" "+ numero +" "+ msg);
				System.out.println("\n");
			}
		}

		//Fechamos o buffer
		StrR.close();
		System.out.println("Lista de enventos: "+eventos.toString());
		System.out.println("Enviado!!!!");
		return eventos;    

	}

	public void enviar() throws Exception{
		EnviaSMS enviar = new EnviaSMS();
		List <String> lista = new ArrayList<String>();
		for (Eventos eventos : eventos) {
			retorno = enviar.EnviarSimples(eventos.getNome(), eventos.getCel(), eventos.getMsg()) ;
			eventos.setRetorno(retorno);
		}
	}

	public List<Eventos> getEventos() {
		return eventos;           
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}



}
