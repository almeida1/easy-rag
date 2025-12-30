package com.fatec.easy.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fatec.easy.service.DocumentIngestor;
import com.fatec.easy.model.ChatRequest;
import com.fatec.easy.service.Assistant;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AssistantController {

    private final DocumentIngestor ingestor;
    private final Assistant assistant; // Injetando a interface diretamente

    public AssistantController(DocumentIngestor ingestor, Assistant assistant) {
        this.ingestor = ingestor;
        this.assistant = assistant;
    }

    @PostMapping("/consultar")
    public ResponseEntity<String> consultar(@RequestBody ChatRequest request) {
        String answer = assistant.chat(request.getQuestion());
        return ResponseEntity.ok(answer);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Por favor, selecione um arquivo.");
        }

        try {
            ingestor.ingestDocument(file.getInputStream());
            return ResponseEntity.ok("Documento processado e ingerido com sucesso: " + file.getOriginalFilename());
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .body("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

}
