package com.fatec.easy.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;

@Service
public class DocumentIngestor {

    private final EmbeddingStoreIngestor ingestor;

    // O Spring injetará o Bean configurado na classe de configuração
    public DocumentIngestor(EmbeddingStoreIngestor ingestor) {
        this.ingestor = ingestor;
    }

    public void ingestDocument(InputStream dataStream) {
        // Nota: Certifique-se de que o parser é adequado ao tipo de arquivo
        Document document = new TextDocumentParser().parse(dataStream);
        ingestor.ingest(document);
    }
}