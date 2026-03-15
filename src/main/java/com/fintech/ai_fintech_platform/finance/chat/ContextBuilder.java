package com.fintech.ai_fintech_platform.finance.chat;
import org.springframework.stereotype.Component;
import java.util.List;
import com.fintech.ai_fintech_platform.model.DocumentChunk;

@Component
public class ContextBuilder {

    public String ContextBuilder(List<DocumentChunk> chunks) {
        StringBuilder context = new StringBuilder(); //stringbuilder en java permet de construire une chaîne de caractères de manière efficace, en évitant la création de multiples objets String immuables lors de la concaténation.
        //methodes de la classe StringBuilder: append , toString, insert, delete, reverse, length, charAt, setCharAt, etc.
        //au lieu de faire : char = char + "new string" à chaque fois, on utilise StringBuilder pour éviter de créer un nouvel objet String à chaque concaténation.
        for (DocumentChunk chunk : chunks) {
            context.append("Source: ").append(chunk.getSource()).append("\n");
            context.append("Content: ").append(chunk.getContent()).append("\n\n");
        }
        return context.toString();
    }

}