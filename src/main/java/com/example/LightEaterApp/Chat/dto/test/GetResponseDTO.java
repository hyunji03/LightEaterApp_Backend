package com.example.LightEaterApp.Chat.dto.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetResponseDTO{
    private String userId;
    private String chatId;
    private String chatWords;
    private int resultNum;
}
