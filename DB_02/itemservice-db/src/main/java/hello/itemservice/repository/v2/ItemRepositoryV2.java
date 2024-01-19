package hello.itemservice.repository.v2;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ItemRepositoryV2 extends JpaRepository<Item, Long> {
}
