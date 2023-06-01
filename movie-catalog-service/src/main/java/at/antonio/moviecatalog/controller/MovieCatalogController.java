package at.antonio.moviecatalog.controller;

import at.antonio.moviecatalog.model.*;
import at.antonio.moviecatalog.service.MovieCatalogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/catalog")
public class MovieCatalogController {

  @Autowired private MovieCatalogService movieCatalogService;

  @GetMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
    return movieCatalogService.getCatalog(userId);
  }
}
