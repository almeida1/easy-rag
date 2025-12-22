package com.fatec.easy.service;

import org.springframework.stereotype.Service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;

@Service
public class AssistantService {

    private final AiAssistant assistant;

    // Interface que o LangChain4j implementará automaticamente
    interface AiAssistant {
        String answer(String query);
    }

    public AssistantService(ChatLanguageModel chatModel, ContentRetriever retriever) {
        this.assistant = AiServices.builder(AiAssistant.class)
                .chatLanguageModel(chatModel)
                .contentRetriever(retriever) // Conecta ao seu Banco de Vetores
                .build();
    }

    public String answer(String question) {
        return assistant.answer(question);
    }
}