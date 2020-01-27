package com.upul.redis.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upul.redis.test.model.ResponseData;
import com.upul.redis.test.model.Student;
import com.upul.redis.test.repository.StudentRepository;

@Service
public class RedisTestService {

	private StudentRepository studentRepository;

	public RedisTestService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public ResponseEntity<ResponseData> save() {

		Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
		Student student1 = new Student("Eng2015002", "Jane Smith", Student.Gender.MALE, 2);
		Student student2 = new Student("Eng2015003", "John Smith", Student.Gender.FEMALE, 4);
		Student student3 = new Student("Eng2015004", "John John", Student.Gender.MALE, 5);
		Student student4 = new Student("Eng2015005", "Doe Doe", Student.Gender.FEMALE, 6);
		ResponseData response = new ResponseData();

		Student save = studentRepository.save(student);
		studentRepository.save(student);
		studentRepository.save(student2);
		studentRepository.save(student3);
		studentRepository.save(student4);
		response.setMessage(save.getId());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseData> findById(String id) {
		ResponseData response = new ResponseData();

		Student retrievedStudent =
				studentRepository.findById(id).get();

		response.setMessage("Student Info " + retrievedStudent);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseData> findAll() {
		ResponseData response = new ResponseData();
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);

		StringBuilder builder = new StringBuilder("Student Info");
		for (Student student : students) {
			builder.append(students + "\n");
		}
		response.setMessage(builder.toString());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseData> delete(String id) {
		ResponseData response = new ResponseData();
		studentRepository.deleteById(id);
		response.setMessage("Student " + id + " deleted");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
