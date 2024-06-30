package com.webLogin.demo.dao;

import com.webLogin.demo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp  implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Usuario usuario) {
        System.out.println(usuario.toString());
        entityManager.merge(usuario);
    }

    @Override
    public Usuario checkCredentials(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email ";
        List<Usuario> lista = entityManager.createQuery(query).setParameter("email", usuario.getEmail()).getResultList();

        if(lista.isEmpty()){
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if( argon2.verify(passwordHashed, usuario.getPassword())){
            return lista.get(0);
        };

        return null;

    }


}
