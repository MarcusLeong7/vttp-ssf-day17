package vttp.ssf.day17.services;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomService {
    
    private Random rand = new SecureRandom();

    public int getRandom(int bounds){
        
        return rand.nextInt(100);
    }
}
