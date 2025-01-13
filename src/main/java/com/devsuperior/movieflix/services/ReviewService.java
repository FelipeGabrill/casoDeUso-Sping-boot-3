package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private AuthService authService;

	@Transactional
	public ReviewDTO postReview(ReviewDTO dto) {

		Review entity = new Review();
		copyToEntity(dto, entity);
		repository.save(entity);
		return new ReviewDTO(entity.getId(), entity.getText(), entity.getMovie().getId(), entity.getUser().getId(),
				entity.getUser().getName(), entity.getUser().getEmail());

	}

	private void copyToEntity(ReviewDTO dto, Review entity) {
		Movie movie = movieRepository.findById(dto.getMovieId())
				.orElseThrow(() -> new ResourceNotFoundException("Movie not found with ID " + dto.getMovieId()));

		entity.setUser(authService.authenticated());
		entity.setMovie(movie);
		entity.setText(dto.getText());
	}

}
