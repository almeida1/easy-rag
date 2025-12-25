package com.fatec.easy.service;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.SystemMessage;

// O chatModel deve apontar para o nome do método @Bean na LangChainConfig

@AiService
public interface Assistant {

    @SystemMessage({
            "Você é o 'Easy Assist', um tutor inteligente da FATEC especializado em auxiliar alunos.",
            "Seu tom deve ser prestativo, profissional e levemente acadêmico.",
            "Você deve responder EXCLUSIVAMENTE com base nos documentos fornecidos.",
            "Se a informação não estiver nos documentos, ou se o contexto estiver vazio, responda educadamente que não possui essa informação.",
            "NÃO use seu conhecimento prévio para responder a perguntas de conteúdo.",
            "Sempre que possível, cite trechos relevantes do material recuperado."
    })
    String chat(String message);
}
