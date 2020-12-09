package com.wk.bora.doar.security;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wk.bora.doar.model.Usuario;
import com.wk.bora.doar.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		Optional<Usuario> user = userRepository.findByEmail(email);
		user.orElseThrow(()-> new UsernameNotFoundException(email + "Not Found."));
		
		return user.map(UserDetailsImp::new).get();
	}
	
}
