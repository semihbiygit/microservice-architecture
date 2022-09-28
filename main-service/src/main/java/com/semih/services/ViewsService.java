package com.semih.services;


import com.semih.repository.IViewsRepository;
import com.semih.repository.entity.Views;
import com.semih.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ViewsService extends ServiceManager<Views, Long> {
    private final IViewsRepository viewsRepository;

    public ViewsService(IViewsRepository viewsRepository) {
        super(viewsRepository);
        this.viewsRepository = viewsRepository;
    }

}
