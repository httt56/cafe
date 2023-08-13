package com.study.compicafe.menu.service;

import com.study.compicafe.menu.entity.Menu;
import com.study.compicafe.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository){
        this.menuRepository=menuRepository;
    }
    public Menu findMenuByCode(int menuCode){
        Menu menu = menuRepository.findById(menuCode);
        return menu;
    }

    public List<Menu> findAllMenu(){
        List<Menu> menuList=menuRepository.findAll();
        return menuList;
    }

    @Transactional
    public int registName(Menu menu){
        Menu result = menuRepository.save(menu);
        System.out.println(result);

        if (Objects.isNull(result)){
            return 0;
        }else {
            return 1;
        }
    }
    @Transactional
    public int updateMenu(Menu findMenu, Menu updaMenu) {
        if(!Objects.isNull(updaMenu.getMenuName())){
            findMenu.setMenuName(updaMenu.getMenuName());
            System.out.println("menu ->:"+ findMenu.getMenuName());
            findMenu.setMenuPrice(updaMenu.getMenuPrice());
            System.out.println("price변경 -> : "+findMenu.getMenuPrice());
        }
        Menu result = menuRepository.save(findMenu);
        if(Objects.isNull(result)){
            return 0;
        }else {
            return 1;
        }
    }
    @Transactional
    public void deleteCode(int del){
       //  menuRepository.delete(/*이렇게하면 쿼리 한번 더 타야됩*/);
        menuRepository.deleteById(del);
        Menu menu = menuRepository.findById(del); //존재하는지 먼저 찾기->영속화에서 제거->null값
        System.out.println(menu);

    }

    /* RestAPI 기반 작성법
     * GET(조회): /menus/1 -> 메뉴들 중 한가지를 확인하고자 할 때
     * GET(조회): /menus? -> 메뉴 전체를 대상으로 무언가를 하고 싶을 때(ex.주문 목록 확인할 때 /menus?order)
     * POST(등록): /menus
     * PUT(수정): /menus/1?
     * DELETE(삭제): /menus/1 -> /menus일 경우, 전체를 삭제한다는 의미이기 떄문에 말이 안됨...
     * */

}
