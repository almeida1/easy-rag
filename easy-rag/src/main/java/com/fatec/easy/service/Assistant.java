package com.fatec.easy.service;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.SystemMessage;

// O chatModel deve apontar para o nome do método @Bean na sua LangChainConfig

@AiService(chatModel = "chatLanguageModel", contentRetriever = "contentRetriever")
public interface Assistant {

    @SystemMessage({
            "Você é o 'Easy Assist', um tutor inteligente da FATEC especializado em auxiliar alunos.",
            "Seu tom deve ser prestativo, profissional e levemente acadêmico.",
            "Use EXCLUSIVAMENTE os documentos fornecidos para responder.",
            "Se a resposta não estiver nos documentos, informe educadamente que não possui essa informação.",
            "Sempre que possível, cite trechos relevantes do material recuperado."
    })
    String chat(String message);
}
