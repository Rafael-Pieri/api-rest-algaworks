package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.ErrorDetails;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<ErrorDetails> handleLivroNaoEncontradoException(LivroNaoEncontradoException e, HttpServletRequest request){
		
		ErrorDetails erro = new ErrorDetails();
		erro.setStatus(404L);
		erro.setTitle("Livro não pôde ser encontrado.");
		erro.setDeveloperMessage("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<ErrorDetails> handleAutorExistenteException(AutorExistenteException e, HttpServletRequest request){
		
		ErrorDetails erro = new ErrorDetails();
		erro.setStatus(409L);
		erro.setTitle("Autor já existente.");
		erro.setDeveloperMessage("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<ErrorDetails> handleAutorNaoEncontradoException(AutorNaoEncontradoException e, HttpServletRequest request){
		
		ErrorDetails erro = new ErrorDetails();
		erro.setStatus(404L);
		erro.setTitle("Autor não pôde ser encontrado.");
		erro.setDeveloperMessage("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDetails> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
		
		ErrorDetails erro = new ErrorDetails();
		erro.setStatus(400L);
		erro.setTitle("Requisição inválida.");
		erro.setDeveloperMessage("http://erros.socialbooks.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
