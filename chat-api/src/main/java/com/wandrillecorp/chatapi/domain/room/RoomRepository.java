package com.wandrillecorp.chatapi.domain.room;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    List<Room> findAllBy(Sort sort);

    Room findByName(String roomName);
}
