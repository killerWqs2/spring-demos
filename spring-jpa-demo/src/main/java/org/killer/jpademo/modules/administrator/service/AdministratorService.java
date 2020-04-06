package org.killer.jpademo.modules.administrator.service;

import org.killer.jpademo.modules.administrator.entity.Administrator;
import org.killer.jpademo.modules.administrator.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wu QiaoSheng
 * @description service 本身没有任何状态，可以作为单例使用
 * @date 2020-03-26 16:53
 */
@Service
public class AdministratorService {

    private AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public void register(Administrator administrator) {
        administratorRepository.save(administrator);
    }

    public Administrator loadAdministratorByPhone(String phone) {
        return administratorRepository.findAdministratorByPhone(phone);
    }

}
