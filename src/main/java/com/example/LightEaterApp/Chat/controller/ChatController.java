package com.example.LightEaterApp.Chat.controller;

import com.example.LightEaterApp.Chat.dto.ChatResponseBodyDTO;
import com.example.LightEaterApp.Chat.dto.ChatUploadDTO;
import com.example.LightEaterApp.Chat.dto.ResponseDTO;
import com.example.LightEaterApp.Chat.dto.ResponseListDTO;
import com.example.LightEaterApp.Chat.dto.test.ChatDTO;
import com.example.LightEaterApp.Chat.dto.test.GetResponseDTO;
import com.example.LightEaterApp.Chat.dto.test.PostResponseDTO;
import com.example.LightEaterApp.Chat.dto.test.PostResponseTestDTO;
import com.example.LightEaterApp.Chat.model.ChatEntity;
import com.example.LightEaterApp.Chat.model.UserEntity;
import com.example.LightEaterApp.Chat.service.ChatService;
import com.example.LightEaterApp.Chat.service.FlaskService;
import com.example.LightEaterApp.Chat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.event.ComponentListener;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("chatupload")
public class ChatController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;
    @Autowired
    private FlaskService flaskService;

    //
    @PostMapping("/img")
    public ResponseEntity<?> uploadChatByImage(
            //@AuthenticationPrincipal String userId,
            @RequestBody ChatUploadDTO chatUploadDTO) {
        try {
            /*
            DTO 참고용
    private String chatId;
    private String userId;
    private int resultNum;
    private int relation;
    private String chatText;
    private Date chatDate;
    private String doubtSentence;

    private String userId;
    private float avoidScore;
    private float anxietyScore;
    private int testType;
             */
            String temporaryUserId = "userId";             //이부분은 로그인 구현시 userId 로 대체되어 들어갈 부분 ->로그인 구현시 삭제


            ChatEntity chatEntity = ChatUploadDTO.toChatEntity(chatUploadDTO);
            UserEntity userEntity = ChatUploadDTO.toUserEntity(chatUploadDTO);
            //userEntity의 userEmail, name없음

            chatEntity.setUserId(temporaryUserId);
            chatEntity.setChatDate(new Date());
            userEntity.setUserId(temporaryUserId);
            //임의설정
            chatEntity.setResultNum((int) (Math.random()*100));
            userEntity.setUserEmail("4hyunhee@duksung.ac.kr");
            userEntity.setName("사현희");
            float random1 =(float) (Math.random()*10);
            float random2 =(float) (Math.random()*10);
            userEntity.setAnxietyScore(random1);
            userEntity.setAvoidScore(random2);
            userEntity.setTestType(((int) (((Math.random()*10)%4)+1))); //1,2,3,4

/*
//flask 서버와 주고 받음

            //int resultnum = flaskService.sendChatWords(entity.getChatWords()).block();

            entity.setResultNum(resultnum);


 */
            List<ChatEntity> chatEntities = chatService.createChatEntity(chatEntity);         //프론트에서 보내주면 전체 db말고 해당chatId entity만 리턴
            List<UserEntity> userEntities = userService.createUserEntity(userEntity);


            List<ChatUploadDTO> dtos = chatEntities.stream()
                    .flatMap(chatEntity1 -> userEntities.stream().map(userEntity1 -> new ChatUploadDTO(chatEntity, userEntity)))
                    .collect(Collectors.toList());
/*
            List<ChatUploadDTO> dtos = chatEntities.stream()
                    .map(ChatUploadDTO::new)
                    .collect(Collectors.toList());

             dtos.addAll( userEntities.stream()
                    .map(ChatUploadDTO::new)
                    .collect(Collectors.toList())
             );


 /*

            List<ChatUploadDTO> dtos = chatEntities.stream()
                    .map(entity -> new ChatUploadDTO(chatEntity, null))
                    .collect(Collectors.toList());
            dtos = userEntities.stream()
                    .map(entity -> new ChatUploadDTO(null, userEntity))
                    .collect(Collectors.toList());


/*
            List<ChatResponseBodyDTO> dtos = chatEntities.stream()
                    .map(ChatResponseBodyDTO::new)
                    .collect(Collectors.toList());\


            List<ChatResponseBodyDTO> dtos = chatEntities.stream()
                    .map(entity -> new ChatResponseBodyDTO(chatEntity, null))
                    .collect(Collectors.toList());

            dtos.addAll(userEntities.stream()
                    .map(entity -> new ChatResponseBodyDTO(null, userEntity))
                    .collect(Collectors.toList()));

*/


            ResponseListDTO<ChatUploadDTO> response = ResponseListDTO.<ChatUploadDTO>builder()
                    .data(dtos)
                    .build();


            return ResponseEntity.ok().body(response);
        } catch(Exception e) {                                      //예외 있는 경우 dto 대신 error 메세지 넣어 리턴
            String error = e.getMessage();
            ResponseListDTO<ChatUploadDTO> response = ResponseListDTO.<ChatUploadDTO>builder()
                    .error(error).build();

            return ResponseEntity.badRequest().body(response);

        }
    }

    @PostMapping("/file")
    public ResponseEntity<?> uploadChatByFile(
            //@AuthenticationPrincipal String userId,
            @RequestBody ChatUploadDTO chatUploadDTO) {
        try {
            /*
            DTO 참고용
    private String chatId;
    private String userId;
    private int resultNum;
    private int relation;
    private String chatText;
    private Date chatDate;
    private String doubtSentence;

    private String userId;
    private float avoidScore;
    private float anxietyScore;
    private int testType;
             */
            String temporaryUserId = "userId";             //이부분은 로그인 구현시 userId 로 대체되어 들어갈 부분 ->로그인 구현시 삭제


            ChatEntity chatEntity = ChatUploadDTO.toChatEntity(chatUploadDTO);
            UserEntity userEntity = ChatUploadDTO.toUserEntity(chatUploadDTO);
            //userEntity의 userEmail, name없음

            chatEntity.setUserId(temporaryUserId);
            chatEntity.setChatDate(new Date());
            userEntity.setUserId(temporaryUserId);
            //임의설정
            chatEntity.setResultNum((int) (Math.random()*100));
            userEntity.setUserEmail("4hyunhee@duksung.ac.kr");
            userEntity.setName("사현희");
            float random1 = ((float) (Math.round(Math.random()*1000)/100.0));
            float random2 = ((float) (Math.round(Math.random()*1000)/100.0));

            userEntity.setAnxietyScore(random1);
            userEntity.setAvoidScore(random2);
            userEntity.setTestType(((int) (((Math.random()*10)%4)+1))); //1,2,3,4

/*
//flask 서버와 주고 받음

            //int resultnum = flaskService.sendChatWords(entity.getChatWords()).block();

            entity.setResultNum(resultnum);


 */
            List<ChatEntity> chatEntities = chatService.createChatEntity(chatEntity);         //프론트에서 보내주면 전체 db말고 해당chatId entity만 리턴
            List<UserEntity> userEntities = userService.createUserEntity(userEntity);

           ChatUploadDTO chatUploadDTO1 = new ChatUploadDTO(chatEntity, userEntity);

/*
            List<ChatUploadDTO> dtos = chatEntities.stream()
                    .flatMap(chatEntity1 -> userEntities.stream().map(userEntity1 -> new ChatUploadDTO(chatEntity, userEntity)))
                    .collect(Collectors.toList());
/*
            List<ChatUploadDTO> dtos = chatEntities.stream()
                    .map(ChatUploadDTO::new)
                    .collect(Collectors.toList());

             dtos.addAll( userEntities.stream()
                    .map(ChatUploadDTO::new)
                    .collect(Collectors.toList())
             );


 /*

            List<ChatUploadDTO> dtos = chatEntities.stream()
                    .map(entity -> new ChatUploadDTO(chatEntity, null))
                    .collect(Collectors.toList());
            dtos = userEntities.stream()
                    .map(entity -> new ChatUploadDTO(null, userEntity))
                    .collect(Collectors.toList());


/*
            List<ChatResponseBodyDTO> dtos = chatEntities.stream()
                    .map(ChatResponseBodyDTO::new)
                    .collect(Collectors.toList());\


            List<ChatResponseBodyDTO> dtos = chatEntities.stream()
                    .map(entity -> new ChatResponseBodyDTO(chatEntity, null))
                    .collect(Collectors.toList());

            dtos.addAll(userEntities.stream()
                    .map(entity -> new ChatResponseBodyDTO(null, userEntity))
                    .collect(Collectors.toList()));

*/

            ResponseDTO response = ResponseDTO.<ChatUploadDTO>builder()
                    .data(chatUploadDTO1)
                    .build();


            return ResponseEntity.ok().body(response);
        } catch(Exception e) {                                      //예외 있는 경우 dto 대신 error 메세지 넣어 리턴
            String error = e.getMessage();
            ResponseDTO response = ResponseDTO.<ChatUploadDTO>builder()
                    .error(error).build();

            return ResponseEntity.badRequest().body(response);

        }
    }
/*
    @PostMapping("/file")
    public ResponseEntity<?> uploadChatByFile(
            //@AuthenticationPrincipal String userId,
            @RequestBody ChatDTO dto) {
        try {
            /*
            DTO 참고용
    private String chatId;
    private String userId;
    private int resultNum;
    private int relation;
    private String chatText;
    private Date chatDate;
    private String doubtSentence;

    private String userId;
    private float avoidScore;
    private float anxietyScore;
    private int testType;

            //responsebody 바꾸는중
            String temporaryUserId = "userId";             //이부분은 로그인 구현시 userId 로 대체되어 들어갈 부분 ->로그인 구현시 삭제


            ChatEntity entity = ChatDTO.toEntity(dto);

            entity.setChatId(null);

            entity.setUserId(temporaryUserId);

            int resultnum = flaskService.sendChatWords(entity.getChatWords()).block();

            entity.setResultNum(resultnum);

            List<ChatEntity> entities = service.createChatEntity(entity);         //프론트에서 보내주면 전체 db말고 해당chatId entity만 리턴

            List<ChatDTO> dtos = entities.stream()
                    .map(ChatDTO::new)
                    .collect(Collectors.toList());



            PostResponseTestDTO response = PostResponseTestDTO.<ChatDTO>builder()
                    .userId(entity.getUserId())
                    .chatId(entity.getChatId())
                    .resultNum(entity.getResultNum())
                    .chatWords(entity.getChatWords())
                    .build();

            return ResponseEntity.ok().body(response);
        } catch(Exception e) {                                      //예외 있는 경우 dto 대신 error 메세지 넣어 리턴
            String error = e.getMessage();
            PostResponseDTO<ChatDTO> response = PostResponseDTO.<ChatDTO>builder()
                    .error(error).build();

            return ResponseEntity.badRequest().body(response);

        }
    }











*/

/*










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

            PostResponseDTO<ChatDTO> response = PostResponseDTO.<ChatDTO>builder()
                    .data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch(Exception e) {                                      //예외 있는 경우 dto 대신 error 메세지 넣어 리턴
            String error = e.getMessage();
            PostResponseDTO<ChatDTO> response = PostResponseDTO.<ChatDTO>builder()
                    .error(error).build();

            return ResponseEntity.badRequest().body(response);

        }
    }

    @PostMapping("/ByDataList")
    public ResponseEntity<?> createChatTest(
            //@AuthenticationPrincipal String userId,
            @RequestBody ChatDTO dto) {
        try {
            //responsebody 바꾸는중
            String temporaryUserId = "userId";             //이부분은 로그인 구현시 userId 로 대체되어 들어갈 부분 ->로그인 구현시 삭제


            ChatEntity entity = ChatDTO.toEntity(dto);

            entity.setChatId(null);

            entity.setUserId(temporaryUserId);

            entity.setResultNum(100);

            List<ChatEntity> entities = service.createTest(entity);

            List<ChatDTO> dtos = entities.stream()
                    .map(ChatDTO::new)
                    .collect(Collectors.toList());

            PostResponseDTO<ChatDTO> response = PostResponseDTO.<ChatDTO>builder()
                    .data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch(Exception e) {                                      //예외 있는 경우 dto 대신 error 메세지 넣어 리턴
            String error = e.getMessage();
            PostResponseDTO<ChatDTO> response = PostResponseDTO.<ChatDTO>builder()
                    .error(error).build();

            return ResponseEntity.badRequest().body(response);

        }
    }
    //list빼고 변수만으로 테스트중
    @PostMapping("/justVariable")
    public ResponseEntity<?> createChatTestByVariable(
            //@AuthenticationPrincipal String userId,
            @RequestBody ChatDTO dto) {
        try {
            /*
    private String error;
    private String userId;
    private String chatId;
    private int resultNum;

            //responsebody 바꾸는중
            String temporaryUserId = "userId";             //이부분은 로그인 구현시 userId 로 대체되어 들어갈 부분 ->로그인 구현시 삭제


            ChatEntity entity = ChatDTO.toEntity(dto);

            entity.setChatId(null);

            entity.setUserId(temporaryUserId);

            int resultnum = flaskService.sendChatWords(entity.getChatWords()).block();

            entity.setResultNum(resultnum);

            List<ChatEntity> entities = service.createTest(entity);         //프론트에서 보내주면 전체 db말고 해당chatId entity만 리턴

            List<ChatDTO> dtos = entities.stream()
                    .map(ChatDTO::new)
                    .collect(Collectors.toList());



            PostResponseTestDTO response = PostResponseTestDTO.<ChatDTO>builder()
                    .userId(entity.getUserId())
                    .chatId(entity.getChatId())
                    .resultNum(entity.getResultNum())
                    .chatWords(entity.getChatWords())
                    .build();

            return ResponseEntity.ok().body(response);
        } catch(Exception e) {                                      //예외 있는 경우 dto 대신 error 메세지 넣어 리턴
            String error = e.getMessage();
            PostResponseDTO<ChatDTO> response = PostResponseDTO.<ChatDTO>builder()
                    .error(error).build();

            return ResponseEntity.badRequest().body(response);

        }
    }
    //@PostMapping("AI")


    @GetMapping
    public ResponseEntity<?> retrieveTodoList(@RequestBody ChatDTO dto) {   //저장된 리스트 반환
        String temporaryUserId ="userId";

        ChatEntity entity = ChatDTO.toEntity(dto);

        entity.setUserId((temporaryUserId));
        entity.setResultNum(60);


        List<ChatEntity> entities = service.retrieve(entity);

        List<ChatDTO> dtos = entities.stream().map(ChatDTO::new).collect(Collectors.toList());
        //List<ChatDTO> responsedto = dtos.stream().map(ChatDTO::toArray).collect(toList());

        GetResponseDTO response = GetResponseDTO.<ChatDTO>builder()
                .userId(dtos.toString())
                .chatId(entity.getChatId())
                .chatWords(dtos.toString())
                .resultNum(100)
                .build();


        return ResponseEntity.ok().body(response);
    }*/

        }

