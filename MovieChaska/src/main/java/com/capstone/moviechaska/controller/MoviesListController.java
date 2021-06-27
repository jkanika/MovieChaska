package com.capstone.moviechaska.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.moviechaska.entity.MoviesList;
import com.capstone.moviechaska.exception.MovieNotFoundException;
import com.capstone.moviechaska.repository.MoviesListRepository;


@RestController
public class MoviesListController {

	
	// inject dependency
		@Autowired
		private MoviesListRepository moviesListRepo;
		

		@Autowired
		private HttpSession session;

		
		// GET all product
		@GetMapping("/movies")
		public List<MoviesList> getAllProducts() {
			return this.moviesListRepo.findAll();
		}

		// GET One Product by id
		@GetMapping("/movies/{id}")
		public Optional<MoviesList> getProductById(@PathVariable("id") long productId, HttpSession session) {
			System.out.println(productId);
			if(!this.moviesListRepo.findById(productId).isEmpty()) {
				session.setAttribute("movie",productId);
				System.out.println("movie session : "+session.getAttribute("movie"));
				return this.moviesListRepo.findById(productId);
			}
			throw new MovieNotFoundException("Product Not Found with id " + productId);
		}

		
		@PostMapping("/movies/{search}")
		public List<MoviesList> searchMovie(@PathVariable("search") String product) {
			System.out.println(product);
			List<MoviesList> searchedMovie = null;
			List<MoviesList> allMovies = this.getAllProducts();
			for (MoviesList moviesList : allMovies) {
				if(moviesList.getMovName().contains(product)) {
					searchedMovie.add(moviesList);
				}
			}
			return searchedMovie;
		}
		
		// Add a product
		@PostMapping("/movies")
		public MoviesList addProduct(@RequestBody MoviesList product) {
			return this.moviesListRepo.save(product);
		}

		@PutMapping("/movies/{id}")
		public MoviesList updateProduct(@PathVariable("id") long productId, @RequestBody MoviesList product) {

			// 1. find product
			MoviesList fechedProduct = this.moviesListRepo.findById(productId).orElseThrow(() -> {
				throw new MovieNotFoundException("Movie Not Found with id " + product.getId());
			});
			
			System.out.println(product);

			if(!product.getMovName().isEmpty()) {
				fechedProduct.setMovName(product.getMovName());
			}
			if(!product.getMovDesc().equals("")) {
				fechedProduct.setMovDesc(product.getMovDesc());
			}
			if(!product.getMovRel().isBlank()) {
				fechedProduct.setMovRel(product.getMovRel());
			}
			if(product.getMovPrice() != 0) {
				fechedProduct.setMovPrice(product.getMovPrice());
			}
//			// 2. set new values
//			fechedProduct.setMovName(product.getMovName());
//			fechedProduct.setMovDesc(product.getMovDesc());
//			fechedProduct.setMovRel(product.getMovRel());
//			fechedProduct.setMovPrice(product.getMovPrice());

			// 3. save product
			return this.moviesListRepo.save(fechedProduct);
		}

		@DeleteMapping("/movies/{id}")
		public void deleteProduct(@PathVariable(value = "id") long productId) {
			// 1. find product
			MoviesList fechedProduct = this.moviesListRepo.findById(productId).orElseThrow(() -> {
				throw new MovieNotFoundException("Product Not Found with id " + productId);
			});
			this.moviesListRepo.delete(fechedProduct);
		}
}
