package br.com.vinhos.projetovinhos.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.vinhos.projetovinhos.dto.ErroDTO;
import br.com.vinhos.projetovinhos.dto.ErroValidacaoDTO;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroValidacaoDTO> handle(MethodArgumentNotValidException exception) {
		List<ErroValidacaoDTO> dto = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			ErroValidacaoDTO erro = new ErroValidacaoDTO(e.getField(), e.getDefaultMessage());
			dto.add(erro);
		});
		return dto;
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ErroDTO handle(NotFoundException exception) {
		ErroDTO erro = new ErroDTO(exception.getMessage());
		return erro;
	}

	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ErroDTO handle(EntidadeEmUsoException exception) {
		ErroDTO erro = new ErroDTO(exception.getMessage());
		return erro;
	}

}
