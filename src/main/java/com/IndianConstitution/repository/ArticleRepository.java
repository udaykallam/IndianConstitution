package com.IndianConstitution.repository;

import com.IndianConstitution.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
