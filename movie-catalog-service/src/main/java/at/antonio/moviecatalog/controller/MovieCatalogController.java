package at.antonio.moviecatalog.controller;

import at.antonio.shared.model.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog")
public class MovieCatalogController {

    //Get all rated movie IDs

    //For each rated movie get the details

    //Put everything together
    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        return Collections.singletonList(CatalogItem.builder().name("Die Hard 3").desc("John McClane in NY").rating(10).build());
    }
}
