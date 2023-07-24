package com.example.LightEaterApp.Chat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LightEaterApp.Chat.model.ChatEntity;
import com.example.LightEaterApp.Chat.persistence.ChatRepository;

import java.util.List;

@Slf4j
@Service
public class ChatService {
    @Autowired
    private ChatRepository repository;

    public String testService() {
        ChatEntity entity = ChatEntity.builder().chatWords("채팅 문장").build();

        repository.save(entity);

        ChatEntity savedEntity = repository.findById(entity.getChatId()).get();     //리포지터리에서 검색

        return savedEntity.getChatWords();
    }

    public List<ChatEntity> create(final ChatEntity entity) {

        validate(entity);
            if(entity == null) {
                log.warn("Entity cannot be null.");
                throw new RuntimeException("Entity cannot be null.");
            }

            if(entity.getUserId() == null) {
                log.warn("Unknown user.");
                throw new RuntimeException("Unknown user.");
            }

            repository.save(entity);

            log.info("Entity chatId: {} is saved.", entity.getChatId());
            log.info("Entity chatWords: {} is saved.", entity.getChatWords());
            log.info("Entity status: {} is saved.", entity.getResultNum());

            return repository.findByUserId(entity.getUserId());




    }
    public List<ChatEntity> retrieve(final ChatEntity entity) {

        validate(entity);

        return repository.findByChatId(entity.getChatId());
    }

    private void validate(final ChatEntity entity) {
        if(entity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException(("Entity cannot be null."));
        } if(entity.getUserId() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException(("Unknown user."));
        }
    }


}

