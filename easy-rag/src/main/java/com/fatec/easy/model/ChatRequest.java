package com.fatec.easy.model;

/**
 * as perguntas do chat podem ser armazenadas para avaliar a qualidade da
 * resposta
 */
public class ChatRequest {

    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
