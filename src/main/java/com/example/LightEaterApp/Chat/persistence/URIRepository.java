package com.example.LightEaterApp.Chat.persistence;

import com.example.LightEaterApp.Chat.model.URIEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URIRepository extends JpaRepository<URIEntity, Long> {

    // 필요에 따라 추가적인 메소드를 정의할 수 있습니다.
}