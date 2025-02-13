package com.sample.user.userService.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.user.userService.entity.Hotel;
import com.sample.user.userService.entity.Rating;
import com.sample.user.userService.entity.User;
import com.sample.user.userService.exception.ResouceNotFoundException;
import com.sample.user.userService.exception.ResourceAlreadyExist;
import com.sample.user.userService.repo.UserServiceRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserServiceRepo userServiceRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub

		log.info("user id {} ", user.getUserId());

		if (!userServiceRepo.existsById(user.getUserId())) {

			return userServiceRepo.save(user);
		} else

			throw new ResourceAlreadyExist("this id is already exist in Database");

	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> userList = userServiceRepo.findAll();
		log.info("user size ***" + userList.size());

		return userList;
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = userServiceRepo.findById(userId)
				.orElseThrow(() -> new ResouceNotFoundException("User Not found in the DB ==" + userId));
		
		//calling to rating service

		Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/rating-api/user/" + userId, Rating[].class);

		user.setRatings(Arrays.asList(ratings));
		log.info("user rating" + ratings);

		Arrays.stream(ratings).forEach(rating -> {
			String hotelId = rating.getHotelId();
			log.info("hotelId" + ratings);

			// calling to hotel Service

			Hotel hotel = restTemplate.getForObject("http://HOTELSERVICE/hotelservice-api/hotel/" + hotelId,
					Hotel.class);
			rating.setHotel(hotel);

		});

		return user;
	}

	@Override
	public void deleteUser(String userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
