package com.example.sportgym.service;

import com.example.sportgym.model.dao.UsuariosDao;
import com.example.sportgym.model.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosImpl implements IUsuarios {

    @Autowired
    private UsuariosDao usuariosDao;

    @Transactional
    @Override
    public Usuarios save(Usuarios usuarios) {
        return usuariosDao.save(usuarios);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuarios findById(Integer id_usuarios) {
        return usuariosDao.findById(id_usuarios).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Usuarios usuarios) {
        usuariosDao.delete(usuarios);
    }

}
