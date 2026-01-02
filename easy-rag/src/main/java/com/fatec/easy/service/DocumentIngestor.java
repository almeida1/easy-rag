package com.fatec.easy.service;

import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;

/**
 * Responsavel por processar e indexar os documentos para que eles possam ser
 * posteriormente consultados pela IA
 * documentos são ingeridos (TextDocumentParser), sem a adição de metadados
 * explícitos (como nome do arquivo, data de upload, etc.) ao objeto
 */
@Service
public class DocumentIngestor {

    private final EmbeddingStoreIngestor ingestor;
    Logger logger = LogManager.getLogger(this.getClass());

    // O Spring injetará o Bean configurado na classe de configuração
    public DocumentIngestor(EmbeddingStoreIngestor ingestor) {
        this.ingestor = ingestor;
    }

    public void ingestDocument(InputStream dataStream) {

        // o parser deve ser adequado ao tipo de arquivo
        // para um arquivo PDF, o parser deve ser PDFDocumentParser
        // para um arquivo Word, o parser deve ser WordDocumentParser
        // para um arquivo CSV, o parser deve ser CSVDocumentParser
        // para um arquivo JSON, o parser deve ser JSONDocumentParser
        // para um arquivo XML, o parser deve ser XMLDocumentParser
        // para um arquivo YAML, o parser deve ser YAMLDocumentParser
        // para um arquivo HTML, o parser deve ser HTMLDocumentParser
        // para um arquivo Markdown, o parser deve ser MarkdownDocumentParser
        // para um arquivo Text, o parser deve ser TextDocumentParser
        // podes-se passar o parser como parâmetro para o DocumentIngestor
        logger.info(">>>>>> Indexacao dos documentos - Iniciando...");
        Document document = new TextDocumentParser().parse(dataStream);
        ingestor.ingest(document);
        logger.info(">>>>>> Treinamento concluído. Documentos ingeridos: "
                + document.text().length());
    }
}