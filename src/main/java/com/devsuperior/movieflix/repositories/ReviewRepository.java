package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	//findByMovieId(Long movieId, Pageable pageable);

    @Query("SELECT r FROM Review r WHERE r.movie.id = :movieId")
    Page<Review> findReviewsByMovieId(Long movieId, Pageable pageable);

}
