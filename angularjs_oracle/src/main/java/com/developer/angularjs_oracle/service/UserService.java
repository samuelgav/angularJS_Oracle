package com.developer.angularjs_oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.angularjs_oracle.dao.UserDao;
import com.developer.angularjs_oracle.dto.User;
import com.developer.angularjs_oracle.exception.FieldPolicyException;
import com.developer.angularjs_oracle.model.DomainResponseModel;
import com.developer.angularjs_oracle.model.UserModel;
import com.developer.angularjs_oracle.validator.UserFieldValidator;


@Service("userService")
public class UserService {

	@Autowired
	private UserDao userDAO;
	
	@Autowired
	private UserFieldValidator userFieldValidator;
	
	public DomainResponseModel add(User user){
		DomainResponseModel model=new DomainResponseModel();
		try {
				if(user == null){
					throw new NullPointerException("el objeto de usuario es nulo!");
				}else{
					// segundo nivel de defensa para verificar nombre de usuario y contraseña
					if(!userFieldValidator.validateUsername(user.getUsername())){
						throw new FieldPolicyException("¡El nombre de usuario no coincide con la política!");
					}
					if(!userFieldValidator.validatePassword(user.getPassword())){
						throw new FieldPolicyException("¡El password no coincide con la política!");
					}
				}
				userDAO.add(user);
				model.setCode(201);
				model.setMessage("¡Registro exitoso! Ingresar de nuevo");
				
		} catch (NullPointerException e) {
			// TODO: handle exception
			model.setCode(499);
			model.setMessage("Failed to register the user cause no user is passed!");
		} catch (FieldPolicyException e) {
			// TODO: handle exception
			model.setCode(498);
			model.setMessage(e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			model.setCode(497);
			model.setMessage(e.getMessage());
		}
		return model;
	}
	
	
	public DomainResponseModel validate(User user){
		User u=userDAO.getByParam("username", user.getUsername());
		if(u !=null){
			// si el usuario se encuentra, verifique la contraseña
			if(u.getPassword().equals(user.getPassword())){
				// la validación es exitosa
				// pasa el mínimo detalle del usuario
				UserModel model=new UserModel();
				model.setFullName(u.getFirstName()+" "+u.getLastName());
				model.setId(u.getId());
				model.setUsername(u.getUsername());
				model.setCode(201);
				model.setMessage("exito al loguear!");
				return model;
			}
		}
		// la validación falló significa que el usuario no se encuentra con las credenciales dadas
		DomainResponseModel model=new DomainResponseModel(401,"Usuario y Contraseña invalidos");
		return model;
	}
	
	public User getByParam(String param, String value){
		User user=null;
		try {
			if(param.equals("username")){
				user=userDAO.getByParam("username", value);
			}else if (param.equals("password")){
				user=userDAO.getByParam("password", value);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	
}
