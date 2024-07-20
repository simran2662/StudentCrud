package com.crud.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.crud.model.StudentModel;
import com.crud.repository.StudentRepository;
import com.crud.service.StudentService;
import com.crud.util.StudentUtil;

import jakarta.persistence.EntityManager;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	StudentUtil studentUtil;

	@Autowired
	EntityManager entityManager;

	@Override
	public Student saveOrUpdateStudent(StudentModel studentModel) {
		Student saveStudent = null;
		Student student = modelMapper.map(studentModel, Student.class);

		if (studentModel.getId() != null) {
			Optional<Student> studentById = studentRepository.findById(studentModel.getId());
			if (studentById.isPresent()) {
				studentUtil.updateStudentData(studentById.get(), student);
				saveStudent = studentRepository.save(studentById.get());
			}
		} else {
			saveStudent = studentRepository.save(student);
		}
		return saveStudent;
	}

	@Override
	public String deleteStudentById(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent())
			return "Student Details not found";
		studentRepository.deleteById(id);

		return "Deleted Successfully";
	}

	public List<Student> getAllData(Integer id) {
        List<Student> list = new ArrayList<>();
        if (id != null) {
            Optional<Student> s = studentRepository.findById(id);
            if (s.isPresent()) {
                list.add(s.get());
            }
        } else {
            list.addAll(studentRepository.findAll());
        }
        return list;
    }
}
