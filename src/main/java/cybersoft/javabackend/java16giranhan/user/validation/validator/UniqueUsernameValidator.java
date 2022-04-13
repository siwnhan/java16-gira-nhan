package cybersoft.javabackend.java16giranhan.user.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java16giranhan.user.model.GiraUser;
import cybersoft.javabackend.java16giranhan.user.repository.GiraUserRepository;
import cybersoft.javabackend.java16giranhan.user.validation.annotation.UniqueUsername;

public class UniqueUsernameValidator 
	implements  ConstraintValidator<UniqueUsername, String> {
	private  String message;
	
	@Autowired
	private GiraUserRepository repository;
	
	@Override
	public void initialize(UniqueUsername uniqueUsername) {
		message = uniqueUsername.message();
	}
	
	@Override
	public boolean isValid(String username	, ConstraintValidatorContext context) {
		Optional<GiraUser> userOpt  =  repository.findByUsername(username);
		//Nếu cái tên này có rồi thì userOpt.present sẽ trả về true 
		if(userOpt.isEmpty())
			return true;
		
		//context là nơi lưu trữ những thông tin liên quan đến nhau 
		context.buildConstraintViolationWithTemplate(message) 
				.addConstraintViolation()
				.disableDefaultConstraintViolation();
		
		return false;
	}

}
