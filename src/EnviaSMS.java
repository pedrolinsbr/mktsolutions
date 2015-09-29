import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.facilitamovel.bean.Retorno;


import br.com.facilitamovel.bean.SmsMultiplo;
import br.com.facilitamovel.bean.SmsMultiploMessages;
import br.com.facilitamovel.bean.SmsSimples;
import br.com.facilitamovel.service.SendMessage;

@ManagedBean
@ViewScoped
public class EnviaSMS {
	
	
	/**
	 * Exemplo de um envio Simples de SMS para a Plataforma
	 * @return 
	 * @throws Exception
	 */


	
	public static String EnviarSimples(String Nome, String Numero, String msg) throws Exception {
		// Simple Send
		SmsSimples sms = new SmsSimples();
		sms.setUser("ecmasga");
		sms.setPassword("ecmasga");
		sms.setDestinatario(Numero);
		sms.setMessage(msg);
		Retorno retorno = SendMessage.simpleSend(sms);
		System.out.println("Codigo:" + retorno.getCodigo());
		System.out.println("Descricao:" + retorno.getMensagem());
		
//		retornoWS = retorno.getMensagem();
		return retorno.getMensagem();
		
	}
	
	
	
}
