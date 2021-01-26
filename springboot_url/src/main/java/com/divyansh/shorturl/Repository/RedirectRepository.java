package com.divyansh.shorturl.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

@Repository
public interface RedirectRepository extends JpaRepository<RedirectEntity, Long> {
	Optional<RedirectEntity> findByAlias(String alias);
	Boolean existsByAlias(String alias);
}
