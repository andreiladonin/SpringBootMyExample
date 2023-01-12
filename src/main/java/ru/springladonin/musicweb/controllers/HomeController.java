package ru.springladonin.musicweb.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.springladonin.musicweb.entities.Track;
import ru.springladonin.musicweb.services.TrackService;

import java.util.List;

@Controller
public class HomeController {

    private TrackService trackService;

    @Autowired
    public void setTrackService(TrackService trackService) {

        this.trackService = trackService;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<Track> allTrack = trackService.getAllTracks();
        model.addAttribute("allTrack", allTrack);
        return "index";
    }

    @GetMapping("/addTrack")
    public String addTrackPage(Model model) {
        model.addAttribute("track", new Track());
        return "addTrack";
    }

    @PostMapping("/addTrack")
    public String addTrack(@ModelAttribute("track") Track track) {

        trackService.addTrack(track);
        return "redirect:/";
    }

    @GetMapping("/track/{id}")
    public String track(Model model, @PathVariable("id") Long id) {

        Track track = trackService.getTrackById(id);
        model.addAttribute("track", track);
        return "track";
    }

    @GetMapping("/track/remove/{id}")
    public String removeTrack(Model model, @PathVariable("id") Long id) {
        trackService.deleteTrackById(id);
        return "redirect:/";
    }
}
