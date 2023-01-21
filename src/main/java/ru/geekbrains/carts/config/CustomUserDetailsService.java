package ru.geekbrains.carts.config;

import ru.geekbrains.carts.entities.Customer;
import ru.geekbrains.carts.security.AuthenticatedUser;
import ru.geekbrains.carts.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Customer customer = customerService.getCustomerByEmail(email);
        if(customer == null){
            throw new UsernameNotFoundException("Email "+email+" not found");
        }
        return new AuthenticatedUser(customer);
    }

}
