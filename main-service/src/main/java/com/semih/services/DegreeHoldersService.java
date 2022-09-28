package com.semih.services;


import com.semih.repository.IDegreeHoldersRepository;
import com.semih.repository.entity.DegreeHolders;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class DegreeHoldersService extends ServiceManager<DegreeHolders, Long> {
    private final IDegreeHoldersRepository degreeHoldersRepository;

    public DegreeHoldersService(IDegreeHoldersRepository degreeHoldersRepository) {
        super(degreeHoldersRepository);
        this.degreeHoldersRepository = degreeHoldersRepository;
    }
}
