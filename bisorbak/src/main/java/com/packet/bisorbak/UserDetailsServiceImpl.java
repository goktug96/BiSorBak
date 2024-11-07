package com.packet.bisorbak;

import com.packet.bisorbak.domain.User;
import com.packet.bisorbak.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User currentUser = userRepository.findByUserName(userName);
        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(userName, currentUser.getPassword(), true, true, true, true,
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return userDetails;
    }
}
