package com.example.LightEaterApp.Chat.controller;

import com.example.LightEaterApp.Chat.dto.ChatDTO;
import com.example.LightEaterApp.Chat.dto.ResponseDTO;
import com.example.LightEaterApp.Chat.model.ChatEntity;
import com.example.LightEaterApp.Chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("chat")
public class ChatController {
    @Autowired
    private ChatService service;
    /*
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);

    }
     */
    @PostMapping
    public ResponseEntity<?> createChat(
           //@AuthenticationPrincipal String userId,
            @RequestBody ChatDTO dto) {
        try {
            String temporaryUserId = "userId";             //이부분은 로그인 구현시 userId 로 대체되어 들어갈 부분 ->로그인 구현시 삭제


            ChatEntity entity = ChatDTO.toEntity(dto);

            entity.setChatId(null);

            entity.setUserId(temporaryUserId);

            entity.setResultNum(100);

            List<ChatEntity> entities = service.create(entity);

            List<ChatDTO> dtos = entities.stream()
                    .map(ChatDTO::new)
                    .collect(Collectors.toList());

            ResponseDTO<ChatDTO> response = ResponseDTO.<ChatDTO>builder()
                    .data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch(Exception e) {                                      //예외 있는 경우 dto 대신 error 메세지 넣어 리턴
            String error = e.getMessage();
            ResponseDTO<ChatDTO> response = ResponseDTO.<ChatDTO>builder()
                    .error(error).build();

            return ResponseEntity.badRequest().body(response);

        }
    }

}
