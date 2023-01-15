package ru.mephi.gpus_statistics.repository.clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.mephi.gpus_statistics.entity.clients.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Integer deleteClientByEmail(String email);

    Optional<Client> findClientByEmail(String email);

    @Query(value = "select cl.client_id, cl.email,cl.nickname,p_l.productid " +
            "from client as cl inner join product_link as p_l on cl.client_id = p_l.client_id" +
            " where p_l.productid = :productId",nativeQuery = true)
    List<Client> findAllByProductId(@Param("productId") String productId);
}
