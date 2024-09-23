package com.example.school_test.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school_test.Dto.QuestionDto;
import com.example.school_test.entity.Questions;
import com.example.school_test.exception.UserNotFoundException;
import com.example.school_test.repository.QuestionRepository;


@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public Questions createQuestion(Questions questions) {
		return questionRepository.save(questions);
	}
	
	public Questions getQuestion(Long id) {
	 return questionRepository.findById(id)
			 .orElseThrow(()-> new UserNotFoundException("Question not found by id "+id));
	
	}
	
	public String updateQuestion(Long id,Questions questions) {
		questionRepository.findById(id)
		.orElseThrow(()-> new UserNotFoundException("Question not found by id "+ id));
		questions.setId(id);
	    questionRepository.save(questions);
	    return "Updated Sucessfully!";	
	}
	
	public String deleteQuestion(Long id) {
	   Questions questions = questionRepository.findById(id)
			   .orElseThrow(()->new UserNotFoundException("Question not found by id "+id));
	   this.questionRepository.delete(questions);
	   return "Deleted Successfully!";
	}
	
	public List<Questions> getAllQuestions(){
		return questionRepository.findAll();
	}
	
	public List<QuestionDto> getAllQuestionDTOs() {
	        List<Questions> questions = questionRepository.findAll();
	        return questions.stream()
	                .map(this::convert)
	                .collect(Collectors.toList());
	 }

	public QuestionDto convert(Questions question) {
	        return QuestionDto.builder()
	                .id(question.getId())
	                .question(question.getQuestion())
	                .choice1(question.getChoice1())
	                .choice2(question.getChoice2())
	                .choice3(question.getChoice3())
	                .build();
	  }
	
	public QuestionDto getOneQuestionDTOS(Long id) {
	    Optional<Questions> question = questionRepository.findById(id);
	    if (question.isEmpty()) {
	        throw new UserNotFoundException("Question not found with id: " + id);
	    }
	    return response(question.get());
	  }
	
	public QuestionDto response(Questions question) {
        return QuestionDto.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .choice1(question.getChoice1())
                .choice2(question.getChoice2())
                .choice3(question.getChoice3())
                .build();
      } 
}



