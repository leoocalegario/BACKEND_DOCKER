package app.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.config.JwtServiceGenerator;
import app.entity.Log;
import app.repository.LogRepository;

@Service
public class LogService {
	@Autowired
	LogRepository logRepository;
//	@Autowired
//	JwtServiceGenerator jwtServiceGenerator;
	
	public void createLog(String metodo,String conteudo,String categoria) {
		Log log = new Log();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		//String nome = jwtServiceGenerator.getNomeFromToken();
		log.setNome("");
		log.setMetodo(metodo);
		log.setTimestamp(LocalDateTime.now().format(formatador));
		log.setConteudo(conteudo);
		log.setCategoria(categoria);
		logRepository.save(log);
	}
	
	public List<Log> listAll(){
		return logRepository.findAll();
	}
}