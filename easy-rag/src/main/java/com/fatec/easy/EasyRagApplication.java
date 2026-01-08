package com.fatec.easy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RAG Ingenuo - implementa o ciclo fundamental retrieve-read sem otimizações
 * de pré-recuperação (na query) ou pos-recuperação (na resposta)
 * É funcional para protótipos e casos de uso simples, mas pode sofrer com
 * problemas comuns dessa abordagem, como baixa precisão em perguntas complexas
 * ou "alucinações" se o contexto recuperado não for perfeitamente relevante.
 */
@SpringBootApplication
public class EasyRagApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyRagApplication.class, args);
	}

}
