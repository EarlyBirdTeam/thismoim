package com.websocket.board.repo;

import com.websocket.board.dto.Postit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostitRepository extends CrudRepository<Postit, Long> {
    List<Postit> findAllByChannel(String channelId);
}
