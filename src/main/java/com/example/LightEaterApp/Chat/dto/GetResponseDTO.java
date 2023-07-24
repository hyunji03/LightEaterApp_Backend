package com.example.LightEaterApp.Chat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetResponseDTO<T> {
//http응답으로 사용

        private String error;                   //에러메세지를 보내줌
        //private String result;
        private int status;
        private List<T> data;


}
