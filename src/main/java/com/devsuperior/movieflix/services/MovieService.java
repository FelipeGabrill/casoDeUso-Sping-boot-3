package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	
	@Transactional(readOnly = true)
	public MovieDetailsDTO findById(Long id) {
		Movie entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDetailsDTO(entity);
	}


	@Transactional(readOnly = true)
	public Page<MovieCardDTO> findByGenre(Long genreId, Pageable pageable) {
		Genre genre = (genreId == 0) ? null : genreRepository.getReferenceById(genreId);
		Page<Movie> page = repository.searchMovies(genre, pageable);
		return page.map(x -> new MovieCardDTO(x));
	}

	@Transactional(readOnly = true)
	public Page<ReviewDTO> findReviewsById(Long id, Pageable pageable) {
		Page<Review> reviews = reviewRepository.findReviewsByMovieId(id, pageable);
		
		if (reviews.isEmpty()) {
            throw new ResourceNotFoundException("Movie with id " + id + " not found or has no reviews.");
        }
		
        return reviews.map(review -> new ReviewDTO(review));
	}
}
