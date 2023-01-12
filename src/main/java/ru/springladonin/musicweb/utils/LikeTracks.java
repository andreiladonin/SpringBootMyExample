package ru.springladonin.musicweb.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.springladonin.musicweb.entities.OrderItem;
import ru.springladonin.musicweb.entities.Track;
import ru.springladonin.musicweb.repositories.TrackRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LikeTracks {

    private List<OrderItem> items;

    private TrackRepository trackRepository;


    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void addTrackById(Long id) {
        Track track = trackRepository.findById(id).get();

        OrderItem orderItem = new OrderItem();
        orderItem.setTrack(track);
        items.add(orderItem);
    }
}
