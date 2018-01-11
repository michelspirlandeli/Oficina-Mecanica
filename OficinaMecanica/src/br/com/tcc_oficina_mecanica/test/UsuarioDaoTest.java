package br.com.tcc_oficina_mecanica.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.tcc_oficina_mecanica.dao.UsuarioDAO;
import br.com.tcc_oficina_mecanica.entity.Usuario;

public class UsuarioDaoTest {

	@Test
	@Ignore
	public void salvar() {

		Usuario usu = new Usuario();
		usu.setLoginUsuario("leandrosilva");
		usu.setSenhaUsuario("123456789");
		usu.setFuncaoUsuario("Administrador");

		Usuario usu1 = new Usuario();
		usu1.setLoginUsuario("MarioAyala");
		usu1.setSenhaUsuario("qwerty");
		usu1.setFuncaoUsuario("Atendente");

		Usuario usu2 = new Usuario();
		usu2.setLoginUsuario("robertojunior");
		usu2.setSenhaUsuario("hfytggdsg");
		usu2.setFuncaoUsuario("Mecanico");

		UsuarioDAO dao = new UsuarioDAO();
		dao.persist(usu);
		dao.persist(usu1);
		dao.persist(usu2);

	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.findAll();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario s1 = dao.getById(2L);
		Usuario s2 = dao.getById(5L);
		Usuario s3 = dao.getById(7L);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}

	@Test
	@Ignore
	public void excluir() {
		UsuarioDAO dao = new UsuarioDAO();

		Usuario usuario = dao.getById(2L);
		if (usuario != null) {
			dao.remove(usuario);
		}
	}

	@Test
	@Ignore
	public void excluirCodigo() {
		UsuarioDAO dao = new UsuarioDAO();
		dao.removeById(2L);
	}

	@Test
	@Ignore
	public void editar() {
		Usuario usuario = new Usuario();

		UsuarioDAO dao = new UsuarioDAO();
		dao.merge(usuario);
	}

}
