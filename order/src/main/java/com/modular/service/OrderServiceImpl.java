package com.modular.service;

import com.modular.domain.usecase.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

//    private final MemberReader memberReader;
//
//    @Override
//    public void createOrder() {
//        if(!memberReader.existsById("임도현")){
//            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
//        }
//
//        // 주문 저장
//        log.info("주문 저장");
//    }
//
//    @Override
//    public void selectOrder() {
//        memberReader.findByMemberId();
//    }
}
