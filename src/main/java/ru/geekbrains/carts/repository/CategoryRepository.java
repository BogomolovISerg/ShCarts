package ru.geekbrains.carts.repository;

import ru.geekbrains.carts.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{
    Category getByName(String name);
}


