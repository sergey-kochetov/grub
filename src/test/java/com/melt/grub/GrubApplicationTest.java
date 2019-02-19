package com.melt.grub;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

public class GrubApplicationTest {

    @Test
    public void corsConfig() {
        String auth = "$2a$10$Zzb1aoyyk0cG5r4xHBmQM.umVIoNObhzgIQEr6jORsWfAYJwCbI/y";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);

        //assertEquals(auth, encode);
    }
}