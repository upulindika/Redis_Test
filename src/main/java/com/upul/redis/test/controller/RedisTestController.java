package com.upul.redis.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upul.redis.test.model.ResponseData;
import com.upul.redis.test.service.RedisTestService;

@RestController
@RequestMapping("/redis_test")
public class RedisTestController {

	private RedisTestService redisTestService;

	public RedisTestController(RedisTestService redisTestService) {
		this.redisTestService = redisTestService;
	}

	@GetMapping("/save")
	public ResponseEntity<ResponseData> save() {
		ResponseEntity<ResponseData> response = redisTestService.save();
		return response;
	}

	@GetMapping("/find")
	public ResponseEntity<ResponseData> findById(@RequestParam("id") String id) {
		ResponseEntity<ResponseData> response = redisTestService.findById(id);
		return response;
	}

	@GetMapping("/findAll")
	public ResponseEntity<ResponseData> findAll() {
		ResponseEntity<ResponseData> response = redisTestService.findAll();
		return response;
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<ResponseData> delete(@RequestParam String id) {
		ResponseEntity<ResponseData> response = redisTestService.delete(id);
		return response;
	}
}
