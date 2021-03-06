package com.nya.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nya.domain.Cart;
import com.nya.domain.Commodity;
import com.nya.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private ICartService cartService;

    @PostMapping
    public Boolean  addGoods(@RequestBody Cart cart) {
        return  cartService.save(cart);
    }

    @DeleteMapping("/{cid}/{buyerid}")
    public Boolean deleteGoods(@PathVariable Integer cid, @PathVariable Integer buyerid) {
        return cartService.removeGoods(cid, buyerid);
    }

    @GetMapping("/{id}")
    public List<Cart> getByUser(@PathVariable Integer id) {
        return cartService.getByBuyerid(id);
    }

    @GetMapping("/incart/{id}")
    public List<Cart> getByUserIncart(@PathVariable Integer id) {
        return cartService.getByBuyeridIncart(id);
    }

    @GetMapping("/finish/{id}")
    public List<Cart> getByUserFinish(@PathVariable Integer id) {
        return cartService.getByBuyeridFinish(id);
    }

    @PutMapping("/{cid}/{buyerid}")
    public Boolean finishTrade(@PathVariable Integer cid, @PathVariable Integer buyerid) {
        return  cartService.finishTrade(cid, buyerid);
    }

    @PutMapping("/{buyerid}")
    public Boolean finishAllTrade(@PathVariable Integer buyerid) {
        System.out.println(buyerid);
        return  cartService.finishAllTrade(buyerid);
    }
}
