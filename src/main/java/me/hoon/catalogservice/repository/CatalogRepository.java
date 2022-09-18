package me.hoon.catalogservice.repository;

import me.hoon.catalogservice.domain.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}
