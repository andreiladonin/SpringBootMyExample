package ru.springladonin.musicweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.springladonin.musicweb.entities.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
}
