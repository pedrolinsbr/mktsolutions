package br.com.mktsolutions.util;

import br.com.mktsolutions.domain.Usuario;

public class UsuarioReadyToLogin {
	/* public Usuario isUsuarioReadyToLogin(String email, String senha) {
         try {
                email = email.toLowerCase().trim();
                System.out.println("Verificando login do usuário " + email);
               // List retorno = dao.findByNamedQuery(Usuario.FIND_BY_EMAIL_SENHA,new NamedParams("email", email.trim(), "senha", convertStringToMd5(senha)));

          //      if (retorno.size() == 1) {
                       Usuario userFound = (Usuario) retorno.get(0);
                       return userFound;
                }

                return null;
         } catch (DAOException e) {
                e.printStackTrace();
                throw new BOException(e.getMessage());
         }
   }*/
}
