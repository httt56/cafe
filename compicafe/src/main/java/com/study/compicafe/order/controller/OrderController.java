package com.study.compicafe.order.controller;

import com.study.compicafe.menu.service.MenuService;
import com.study.compicafe.order.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.Controller;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("order")
public class OrderController {
    private final MenuService menuService;
    private final OrderService orderService;

    public OrderController(MenuService menuService, OrderService orderService) {
        this.MenuService = menuService;
        this.OrderService = orderService;
    }
    @GetMapping("/{orderCode}")
    @ApiOperation(value = "1주문검색Api")
    public ResponseEntity<List<?>>FindAllOrder(){
        List<Order>orders = orderService.findAllorder();

        System.out.println(orders);
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{orderCode}")
    @ApiOperation(Value="단일주문검색Api")
    public ResponseEntity<?>OrderRegist(@RequestBody List<MenuOrderDTO>menuOrderDTO){
        if(Objects.isNull(menuOrderDTO)){
            return ResponseEntity.status(400).body("잘못된주문입니다");

        }
        int(result > 0){
            return ResponseEntity.ok().body("주문되었습니다");

        }else{
            return ResponseEntity.status(500).body("주문실패했습니다");
        }
    }

    @OeleteMapping("{oderCode}")
    @ApiOperation(Value="주문삭제Api")


}
