package com.study.compicafe.menu.repository;

import com.study.compicafe.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Menu, Integer> {
    Menu findById(int menuCode);

}
