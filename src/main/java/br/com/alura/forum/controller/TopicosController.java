package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.dto.TopicoDto;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso) {
		if (nomeCurso == null) {
			return TopicoDto.converter(topicoRepository.findAll());
		} else {
			return TopicoDto.converter(topicoRepository.findByCursoNome(nomeCurso));
		}
	}

}